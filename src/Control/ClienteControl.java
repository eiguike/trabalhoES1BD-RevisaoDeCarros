/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;
import Control.ConexaoBD;
import Model.Cliente;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author floss
 */
public class ClienteControl{
    
    ConexaoBD con;
    
    public ClienteControl(){
        con = new ConexaoBD();
    
    }
    // consultas
    public Cliente getCliente(String CPF, String nome){
        Cliente retCliente = new Cliente();
        ResultSet rs = null;        
        String texto_consulta = null;
        if(CPF != null){
            //texto_consulta = "SELECT * FROM CLIENTE, TELEFONE, ENDERECO WHERE CPF = '";
            texto_consulta = "SELECT * FROM CLIENTE WHERE CPF = '";
            texto_consulta += CPF;
            texto_consulta+="'";   
        }
        if(nome != null){
            texto_consulta = "SELECT * FROM CLIENTE WHERE NOME LIKE '";
            texto_consulta += nome;
            texto_consulta+="%'";             
        } 
       
        System.out.println(texto_consulta);
        try{
          con.st.execute(texto_consulta);
          rs = con.st.getResultSet();
          rs.next();
          retCliente.setCPF(rs.getString(1));          
          retCliente.setNome(rs.getString(2));
        }catch(SQLException e){
          return null;
        }
        return retCliente;  
    }
}
