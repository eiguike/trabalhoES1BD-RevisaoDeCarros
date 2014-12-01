/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;
import Model.Pecas;
import Control.ConexaoBD;
import Model.Carro;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author marcello
 */
public class PecasControl {
    ConexaoBD con;
    Pecas retPeca;
    
    public PecasControl(){
        con = new ConexaoBD();
    }
    
    public boolean setPecas(ArrayList<Pecas> lista, String quilometragem, Carro carro){
        Integer i = 0;
        String texto_consulta = "";
        
        
        while(i<lista.size()){
            texto_consulta+="INSERT INTO REVISAOPECA((SELECT CODPECA FROM PECA WHERE DESCRICAO='"+lista.get(i).getDescricao()+"'),(SELECT CODPECA FROM REVISAO WHERE REVISAO.PLACACARRO = '"+carro.getPlacaCarro()+"' AND "
            + "QUILOMETRAGEM = '"+quilometragem+"'), 1);";            
        }
        
        System.out.println(texto_consulta);
        
        return false;
                
                

    }
    
    public boolean setPeca(Pecas aux, Integer codigo){
        ResultSet rs = null;
        String texto_consulta = "INSERT INTO PECA VALUES('" + codigo + "','"
                + aux.getDescricao() + "','" + aux.getGarantia()+ ");";
                
        System.out.println(texto_consulta);
        
        try{
            con.st.execute(texto_consulta);
        }catch(SQLException e){
            return false;
        }
        
        return true;        
    }
    
    public ArrayList<Pecas> getPecas(String placaCarro, Integer quilometragem){
        ArrayList<Pecas> pecas = new ArrayList<Pecas>();
        Pecas aux;

        ResultSet rs = null;
        String texto_consulta = "SELECT REVISAOPRINCIPAL.DATAREVISAO, PECA.NOME, PECA.VENCIMENTO FROM REVISAOPRINCIPAL, \n" +
"(SELECT PECA.CODPECA,PECA.NOME,PECA.VENCIMENTO FROM TIPOREVISAO, PECA WHERE TIPOREVISAO.QUILOMETRAGEM = " + quilometragem +"\n" +
              "AND TIPOREVISAO.CODPECA = PECA.CODPECA) AS PECA\n" +
    "WHERE CODREVISAO = (\n" +
        "SELECT CODREVISAO FROM REVISAO WHERE PLACACARRO = '" + placaCarro + "' AND QUILOMETRAGEM = " + quilometragem + ")";
        
        System.out.println(texto_consulta);
        
        try {
            con.st.execute(texto_consulta);
            rs = con.st.getResultSet();
            rs.next();
            
            while(rs.isAfterLast() == false){
                aux = new Pecas();
                aux.setData(rs.getDate(1));
                aux.setDescricao(rs.getString(2));
                aux.setGarantia(rs.getInt(3));
                                   
                pecas.add(aux);
                
                rs.next();
              }

            return pecas;
        } catch (SQLException e) {
            return null;
        }

    }
    
    public ArrayList<Pecas> getPecasRevisao(Integer quilometragem){
        ArrayList<Pecas> pecas = new ArrayList<Pecas>();
        Pecas aux;

        ResultSet rs = null;
        String texto_consulta = "SELECT Peca.nome, Peca.vencimento FROM Peca, TipoRevisao \n" +
                    " WHERE peca.codpeca = tiporevisao.codpeca AND TipoRevisao.quilometragem = " + quilometragem;
        
        System.out.println(texto_consulta);
        
        try {
            con.st.execute(texto_consulta);
            rs = con.st.getResultSet();
            rs.next();
            
            while(rs.isAfterLast() == false){
                aux = new Pecas();
                aux.setDescricao(rs.getString(1));
                aux.setGarantia(rs.getInt(2));
                                   
                pecas.add(aux);
                
                rs.next();
              }

            return pecas;
        } catch (SQLException e) {
            return null;
        }

    }
    
    public ArrayList<Pecas> getPecasDemais(Integer quilometragem){
        ArrayList<Pecas> pecas = new ArrayList<Pecas>();
        Pecas aux;

        ResultSet rs = null;
        String texto_consulta = "SELECT Peca.nome, Peca.vencimento FROM Peca, TipoRevisao \n" +
                    " WHERE TipoRevisao.quilometragem <> " + quilometragem;
        
        System.out.println(texto_consulta);
        
        try {
            con.st.execute(texto_consulta);
            rs = con.st.getResultSet();
            rs.next();
            
            while(rs.isAfterLast() == false){
                aux = new Pecas();
                aux.setDescricao(rs.getString(1));
                aux.setGarantia(rs.getInt(2));
                                   
                pecas.add(aux);
                
                rs.next();
              }

            return pecas;
        } catch (SQLException e) {
            return null;
        }

    }
    
}
