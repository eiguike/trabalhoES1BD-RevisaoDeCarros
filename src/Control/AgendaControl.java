/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.util.ArrayList;
import java.util.Date;
import java.sql.*;

/**
 *
 * @author floss
 */
public class AgendaControl {
    ConexaoBD con;
    public AgendaControl(){
        con = new ConexaoBD();
    }
    
    public ArrayList<String> getTipoRevisao(){
        ResultSet rs = null;
        String texto_consulta = "SELECT quilometragem FROM TipoRevisao";
        ArrayList<String> revisoesRet = new ArrayList<String>();
        
        try{
          con.st.execute(texto_consulta);
          rs = con.st.getResultSet();
          rs.next();
          
          while(rs.isAfterLast() == false)
          {
            revisoesRet.add(rs.getString(1));
            rs.next();
          }
          return revisoesRet;
           
        }catch(SQLException e){
          return null;
        }         
    }
    
    public  Integer getNumMecanicos(){
        ResultSet rs = null;
        String texto_consulta = null;
        
        texto_consulta = "SELECT COUNT(CPF) FROM FUNCIONARIO WHERE MECANICO = 't';";
        System.out.println(texto_consulta);
        try{
          con.st.execute(texto_consulta);
          rs = con.st.getResultSet();
          rs.next();
          return rs.getInt(1);
           
        }catch(SQLException e){
          return null;
        }            
    }
    
    // recebe a data e o horário, retorna os cpfs
    public ArrayList<String> getMecanicoLivre(Date data, String horas){
        ArrayList<String> cpfRet = new ArrayList<String>();
        ResultSet rs = null;
        String texto_consulta = null;
        
        texto_consulta = 
        "SELECT CPF FROM FUNCIONARIO WHERE MECANICO ='t' AND CPF NOT IN (\n" +
        "	SELECT CPFMECANICO as CPF FROM FuncionarioRevisao, Revisao, Revisao2\n" +
        "	WHERE FuncionarioRevisao.codRevisao = Revisao.codRevisao\n" +
        "	AND Revisao.codRevisao = Revisao2.codRevisao\n" +
        "	AND  Revisao2.dataRevisao = '"+ data +"' AND hora = '"+ horas +"'\n" +
        ")";
        
        System.out.println(texto_consulta);
        try{
          con.st.execute(texto_consulta);
          rs = con.st.getResultSet();
          rs.next();
          
          while(rs.isAfterLast() == false)
          {
         
            cpfRet.add(rs.getString(1));
            rs.next();
          }
          return cpfRet;
        }catch(SQLException e){
          return null;
        }        
        
        
    }
    
    public ArrayList<Integer> getHorarioLivre(Date aux){
        ArrayList<Integer> horarioRet = new ArrayList<Integer>();
        ResultSet rs = null;  
        String texto_consulta = null;
        
        System.out.println("HEUHUEHUEHE");
        System.out.println(aux);
        System.out.println(aux.getDate());
        System.out.println("AOOOOOOO");

        texto_consulta = 
        
        "SELECT oitoHoras, dezHoras, dozeHoras, catorzeHoras, dezesseisHoras FROM(\n" +
        "SELECT COUNT(Revisao2.codRevisao) as oitoHoras FROM FuncionarioRevisao, Revisao, Revisao2\n" +
        "WHERE FuncionarioRevisao.codRevisao = Revisao.codRevisao\n" +
        "AND Revisao.codRevisao = Revisao2.codRevisao\n" +
        "AND  Revisao2.dataRevisao = '"+ aux +"'\n" +
        "AND hora = '8:00') AS oitoHoras,\n" +
        "(SELECT COUNT(Revisao2.codRevisao) as dezHoras FROM FuncionarioRevisao, Revisao, Revisao2\n" +
        "WHERE FuncionarioRevisao.codRevisao = Revisao.codRevisao\n" +
        "AND Revisao.codRevisao = Revisao2.codRevisao\n" +
        "AND  Revisao2.dataRevisao = '"+ aux +"'\n" +
        "AND hora = '10:00') AS dezHoras,\n" +
        "(SELECT COUNT(Revisao2.codRevisao) as dozeHoras FROM FuncionarioRevisao, Revisao, Revisao2\n" +
        "WHERE FuncionarioRevisao.codRevisao = Revisao.codRevisao\n" +
        "AND Revisao.codRevisao = Revisao2.codRevisao\n" +
        "AND  Revisao2.dataRevisao = '"+ aux +"'\n" +
        "AND hora = '12:00') AS dozeHoras,\n" +
        "(SELECT COUNT(Revisao2.codRevisao) as catorzeHoras FROM FuncionarioRevisao, Revisao, Revisao2\n" +
        "WHERE FuncionarioRevisao.codRevisao = Revisao.codRevisao\n" +
        "AND Revisao.codRevisao = Revisao2.codRevisao\n" +
        "AND  Revisao2.dataRevisao = '"+ aux +"'\n" +
        "AND hora = '14:00') AS duasHoras,\n" +
        "(SELECT COUNT(Revisao2.codRevisao) as dezesseisHoras FROM FuncionarioRevisao, Revisao, Revisao2\n" +
        "WHERE FuncionarioRevisao.codRevisao = Revisao.codRevisao\n" +
        "AND Revisao.codRevisao = Revisao2.codRevisao\n" +
        "AND Revisao2.dataRevisao = '"+ aux +"'\n" +
        "AND hora = '16:00') AS quatroHoras;";
 
       
        System.out.println(texto_consulta);
        try{
          con.st.execute(texto_consulta);
          rs = con.st.getResultSet();
          rs.next();
          
      
            horarioRet.add(rs.getInt(1));
            horarioRet.add(rs.getInt(2));
            horarioRet.add(rs.getInt(3));
            horarioRet.add(rs.getInt(4));
            horarioRet.add(rs.getInt(5));
           
            aux = null;
            rs.next();
        }catch(SQLException e){
          return null;
        }
        return horarioRet;        
    }
}
