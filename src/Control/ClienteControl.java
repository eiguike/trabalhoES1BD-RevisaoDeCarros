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
import java.util.ArrayList;


/**
 *
 * @author floss
 */
public class ClienteControl{
    
    ConexaoBD con;
    
    public ClienteControl(){
        con = new ConexaoBD();
    
    }
    
    public boolean updateCliente(Cliente aux){
        ResultSet rs = null;
        String texto_consulta = "UPDATE Cliente SET RUA = '"+ aux.getRua() +"', NUMERO ="
                + aux.getNumero() + ", BAIRRO ='" + aux.getBairro() +"', ESTADO='"+ aux.getEstado() +"',"
                + "COMPLEMENTO = '" + aux.getComplemento() + "', CIDADE ='" + aux.getCidade() + "'"
                + " WHERE CLIENTE.CPF ='"+ aux.getCPF() +"';";
        texto_consulta+="UPDATE Telefone SET(TELEFONE, CELULAR, EMPRESARIAL) = ('"+aux.getTelefone()+"'"
                + ", '" + aux.getCelular() +"', '" + aux.getEmpresarial() +"') WHERE Telefone.CPF = '"+ aux.getCPF()+"';";
                
        System.out.println(texto_consulta);
        
        try{
            con.st.execute(texto_consulta);
        }catch(SQLException e){
            return false;
        }
        
        return true;   
    }
    
    public boolean setCliente(Cliente aux){
        ResultSet rs = null;
        String texto_consulta = "INSERT INTO Cliente VALUES('"
                + aux.getCPF() + "','" + aux.getNome() + "','" + aux.getRua() +"',"
                + aux.getNumero() +", '" + aux.getComplemento() + "','" + aux.getBairro() +"','"
                + aux.getCidade() +"','" + aux.getEstado()+"');";
        texto_consulta+="INSERT INTO Telefone VALUES('"
                + aux.getCPF() + "','" + aux.getTelefone() +"','" + aux.getCelular() +"','"
                + aux.getEmpresarial() +"');";
                
        System.out.println(texto_consulta);
        
        try{
            con.st.execute(texto_consulta);
        }catch(SQLException e){
          return false;
        }
        
        return true;
    }
    // consultas
    public Cliente getCliente(String CPF){
        Cliente retCliente = new Cliente();
        ResultSet rs = null;  
        String texto_consulta = null;
        
        //texto_consulta = "SELECT * FROM CLIENTE, TELEFONE, ENDERECO WHERE CPF = '";
        texto_consulta = "SELECT CLIENTE.CPF, CLIENTE.NOME, CLIENTE.RUA, CLIENTE.NUMERO, CLIENTE.COMPLEMENTO"
                + ", CLIENTE.BAIRRO, CLIENTE.CIDADE, CLIENTE.ESTADO, TELEFONE.TELEFONE, TELEFONE.CELULAR"
                + ", TELEFONE.EMPRESARIAL  FROM CLIENTE, TELEFONE WHERE CLIENTE.CPF = '"+CPF+ "' AND TELEFONE.CPF ='" + CPF+"'";
       
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
    
    public ArrayList<Cliente> getClientes(String nome) {
        ArrayList<Cliente> retCliente = new ArrayList<Cliente>();
        Cliente aux = new Cliente();
        ResultSet rs = null;  
        String texto_consulta = null;

        texto_consulta = "SELECT CLIENTE.CPF, CLIENTE.NOME, CLIENTE.RUA, CLIENTE.NUMERO, CLIENTE.COMPLEMENTO"
                + ", CLIENTE.BAIRRO, CLIENTE.CIDADE, CLIENTE.ESTADO, TELEFONE.TELEFONE, TELEFONE.CELULAR"
                    + ", TELEFONE.EMPRESARIAL  FROM CLIENTE, TELEFONE WHERE UPPER(CLIENTE.NOME) LIKE '"+nome.toUpperCase()+"%' AND TELEFONE.CPF=CLIENTE.CPF";           
 
       
        System.out.println(texto_consulta);
        try{
          con.st.execute(texto_consulta);
          rs = con.st.getResultSet();
          rs.next();
          
          while(rs.isAfterLast() == false)
          {
            aux.setCPF(rs.getString(1));
            aux.setNome(rs.getString(2));
            aux.setRua(rs.getString(3));
            aux.setNumero(Integer.parseInt(rs.getString(4)));
            aux.setComplemento(rs.getString(5));
            aux.setBairro(rs.getString(6));
            aux.setCidade(rs.getString(7));
            aux.setEstado(rs.getString(8));
            aux.setTelefone(rs.getString(9));
            aux.setCelular(rs.getString(10));
            aux.setEmpresarial(rs.getString(11));
            
            retCliente.add(aux);
            rs.next();
          }
        }catch(SQLException e){
          return null;
        }
       
        return retCliente;
    }
}
