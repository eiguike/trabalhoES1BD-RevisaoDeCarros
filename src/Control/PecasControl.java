/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;
import Model.Pecas;
import Control.ConexaoBD;
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
    
    public ArrayList getPecas(String placaCarro, Integer quilometragem){
        ArrayList<Pecas> pecas = new ArrayList<Pecas>();
        Pecas aux;

        ResultSet rs = null;
        String texto_consulta = "select nome, vencimento from peca, revisaotipodeservico, revisao where revisao.placaCarro = '" + placaCarro + "' and revisaotipodeservico.codservico = revisao.codservico and peca.codpeca = revisaotipodeservico.codpeca and tiporevisao.quilometragem = " + quilometragem + ";" ;
        
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
