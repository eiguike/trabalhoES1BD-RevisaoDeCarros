/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;
import Model.Carro;
import Control.ConexaoBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author floss
 */
public class CarroControl {
    ConexaoBD con;
    Carro retCarro;
    
    public CarroControl(){
        con = new ConexaoBD();
    }
    
    public ArrayList<Carro> getCarros(String CPF) {
        ArrayList<Carro> carros = new ArrayList<Carro>();
        Carro aux;

        ResultSet rs = null;
        String texto_consulta = "SELECT CPF, PLACACARRO, CHASSI, COR, ANO, MODELO, REMOVIDO FROM CARRO WHERE CPF='"
                + CPF + "'";
        
        System.out.println(texto_consulta);
        
        try {
            con.st.execute(texto_consulta);
            rs = con.st.getResultSet();
            rs.next();
            
            while(rs.isAfterLast() == false){
                aux = new Carro();
                aux.setCPF(rs.getString(1));
                aux.setPlacaCarro(rs.getString(2));
                aux.setChassi(rs.getString(3));
                aux.setCor(rs.getString(4));
                aux.setAno(rs.getInt(5));
                aux.setModelo(rs.getString(6));
                if(rs.getString(7).compareTo("t") == 0){
                    // foi removido
                    aux.setRemovido(true);
                }else{
                    aux.setRemovido(false);
                } 
                
                carros.add(aux);
                
                rs.next();
              }

            return carros;
        } catch (SQLException e) {
            return null;
        }

    }
    
    public Carro getCarro(String placaCarro, String chassi){
        retCarro = new Carro();
        String texto_consulta = null;
        ResultSet rs = null;    
        if(placaCarro != null){
            //texto_consulta = "SELECT * FROM CLIENTE, TELEFONE, ENDERECO WHERE CPF = '";
            texto_consulta = "SELECT CARRO.CPF, CARRO.PLACACARRO, CARRO.CHASSI, CARRO.COR, CARRO.ANO, CARRO.MODELO"
                    + " ,GARANTIA.DATAINICIO, GARANTIA.DATAFIM FROM CARRO, CARROGARANTIA, GARANTIA WHERE CARRO.PLACACARRO = '";
            texto_consulta += placaCarro;
            texto_consulta+="' AND CARROGARANTIA.PLACACARRO = '"
                    + placaCarro + "' AND CARROGARANTIA.CODGARANTIA = GARANTIA.CODGARANTIA";   
        }
        if(chassi != null){
            // arrumar aqui....
            //texto_consulta = "SELECT * FROM CLIENTE, TELEFONE, ENDERECO WHERE CPF = '";
            texto_consulta = "SELECT * FROM CARRO WHERE CHASSI = '";
            texto_consulta += chassi;
            texto_consulta+="'";         
        }
        
        System.out.println(texto_consulta);
        
        try{
          con.st.execute(texto_consulta);
          rs = con.st.getResultSet();
          rs.next();
          retCarro.setCPF(rs.getString(1));          
          retCarro.setPlacaCarro(rs.getString(2));
          retCarro.setChassi(rs.getString(3));
          retCarro.setCor(rs.getString(4));
          retCarro.setAno(rs.getInt(5));
          retCarro.setModelo(rs.getString(6));
          retCarro.setGarantia(rs.getDate(8));
        }catch(SQLException e){
          return null;
        }
        return retCarro;  
        
    }
    
    
}
