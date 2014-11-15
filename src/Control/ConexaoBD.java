/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;
import Model.*;
import java.sql.*;

public class ConexaoBD {
    //Objeto que guarda informacoes da conexao com o SGBD.
    private Connection myConnection;

    //Objeto usado para enviar comandos SQL no SGBD
    private Statement st;
    private boolean conectado;

    public boolean isConectado() {
        return conectado;
    }

    public void setConectado(boolean conectado) {
        this.conectado = conectado;
    }

    // Construtor
    public ConexaoBD(){
        setConectado(false);
        try{
            Class.forName("org.postgresql.Driver").newInstance();
            
            myConnection = DriverManager.getConnection("jdbc:postgresql:" +
                    "//localhost/postgres?user=postgres&password=postgres");
            st = myConnection.createStatement();
            setConectado(true);
        }
        catch (Exception e){
            setConectado(false);
            e.printStackTrace();
        }
    }
    public Usuario getUsuario(String usuario, String senha){
        Usuario ret_usuario = new Usuario();
        ResultSet rs = null;        
            
        String texto_consulta = "SELECT CPF, LOGIN, SENHA, MECANICO FROM FUNCIONARIO WHERE LOGIN = '";
        texto_consulta +=usuario;
        texto_consulta+="' AND SENHA = '";
        texto_consulta +=senha;
        texto_consulta+="'";
        
        System.out.println(texto_consulta);

        try{
          st.execute(texto_consulta);
          rs = st.getResultSet();
          rs.next();
          ret_usuario.setCPF(rs.getString(1));          
          ret_usuario.setLogin(rs.getString(2));
          ret_usuario.setSenha(rs.getString(3));
          if(rs.getString(4).compareTo("t") == 0){
              // é mecânico
              
              ret_usuario.setTipo(true);
          }else{
              ret_usuario.setTipo(false);
          } 
        }catch(SQLException e){
          return null;
        }
        return ret_usuario;      
    }
    
    public Carro getCarro(String placaCarro){
        Carro retCarro = new Carro();
        ResultSet rs = null;        
            
        String texto_consulta = "SELECT * FROM CARRO WHERE PLACACARRO = '";
        texto_consulta +=placaCarro; 
        texto_consulta+="'";
        
        try{
          st.execute(texto_consulta);
          rs = st.getResultSet();
          rs.next();
          retCarro.setCPF(rs.getString(1));          
          retCarro.setPlacaCarro(rs.getString(2));
          retCarro.setChassi(rs.getString(3));
          retCarro.setCor(rs.getString(4));
          retCarro.setAno(rs.getInt(5));
          retCarro.setModelo(rs.getString(6));

        }catch(SQLException e){
          return null;
        }
        return retCarro;     
        
    }
}
