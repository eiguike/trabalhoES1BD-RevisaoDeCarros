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
