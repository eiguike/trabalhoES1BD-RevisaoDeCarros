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
            texto_consulta = "SELECT CLIENTE.CPF, CLIENTE.NOME, CLIENTE.RUA, CLIENTE.NUMERO, CLIENTE.COMPLEMENTO"
                    + ", CLIENTE.BAIRRO, CLIENTE.CIDADE, CLIENTE.ESTADO, TELEFONE.TELEFONE, TELEFONE.CELULAR"
                    + ", TELEFONE.EMPRESARIAL  FROM CLIENTE, TELEFONE WHERE CLIENTE.CPF = '"+CPF+ "' AND TELEFONE.CPF ='" + CPF+"'";   
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
          retCliente.setRua(rs.getString(3));
          retCliente.setNumero(Integer.parseInt(rs.getString(4)));
          retCliente.setComplemento(rs.getString(5));
          retCliente.setBairro(rs.getString(6));
          retCliente.setCidade(rs.getString(7));
          retCliente.setEstado(rs.getString(8));
          retCliente.setTelefone(rs.getString(9));
          retCliente.setCelular(rs.getString(10));
          retCliente.setEmpresarial(rs.getString(11));                
                   
        }catch(SQLException e){
          return null;
        }

        return retCliente;  
    }
    
    public boolean setCliente(Cliente cliente)
    {
        return true;
    }
}
