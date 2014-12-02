/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.util.ArrayList;
import java.util.Date;
import java.sql.*;
import Model.Agenda;
import Model.Carro;
import Model.Cliente;
import Model.Funcionario;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author floss
 */
public class AgendaControl {
    ConexaoBD con;
    public AgendaControl(){
        con = new ConexaoBD();
    }
    
    public ArrayList<String> getRevisaoAtual(Carro aux){
        ResultSet rs = null;
        String texto_consulta = 
                "select quilometragem from tiporevisao WHERE quilometragem NOT IN("
                + "select quilometragem from revisao where placacarro='" +aux.getPlacaCarro()+ "')"
                + "group by quilometragem order by quilometragem asc ";
        
        try{
            con.st.execute(texto_consulta);
            rs = con.st.getResultSet();
            rs.next();
            ArrayList<String> lista = new ArrayList<String>();
            
            while(rs.isAfterLast() == false){
                lista.add(rs.getString(1));
                rs.next();
            }
            return lista;
            
        }catch(SQLException e){
            return null;
        }
    }
    
    public ArrayList<String> getTipoRevisao(){
        ResultSet rs = null;
        String texto_consulta = "SELECT quilometragem FROM TipoRevisao GROUP BY quilometragem ORDER BY quilometragem";
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
    
    public Integer getEstimativaRevisao(String quilometragem){
        ResultSet rs = null;
        String texto_consulta = 
            "select sum(tempomedio) from tiporevisao, tipodeservico where quilometragem =" +quilometragem+ " and tipodeservico.codservico = tiporevisao.codservico";
        System.out.println(texto_consulta);
        
        try{
            con.st.execute(texto_consulta);
            rs = con.st.getResultSet();
            rs.next();
            return rs.getInt(1);
        }catch(SQLException e){
            return -1;
        }
    }  
    
    public Integer getPrecoTipoDeRevisao(String quilometragem){
        ResultSet rs = null;
        String texto_consulta = 
            "select sum(preco) from tiporevisao, tipodeservico where quilometragem ='" +quilometragem+ "' and tipodeservico.codservico = tiporevisao.codservico";
        System.out.println(texto_consulta);
        
        try{
            con.st.execute(texto_consulta);
            rs = con.st.getResultSet();
            rs.next();
            return rs.getInt(1);
        }catch(SQLException e){
            return -1;
        }
    }
    
    // recebe a data e o horário, retorna os cpfs
    public ArrayList<String> getMecanicoLivre(Date data, String horas){
        ArrayList<String> cpfRet = new ArrayList<String>();
        ResultSet rs = null;
        String texto_consulta = null;
        
        texto_consulta = 
        "SELECT CPF FROM FUNCIONARIO WHERE MECANICO ='t' AND CPF NOT IN (\n" +
        "	SELECT CPFMECANICO as CPF FROM FuncionarioRevisao, Revisao, RevisaoPrincipal\n" +
        "	WHERE FuncionarioRevisao.codRevisao = Revisao.codRevisao\n" +
        "	AND Revisao.codRevisao = RevisaoPrincipal.codRevisao\n" +
        "	AND  RevisaoPrincipal.dataRevisao = '"+ data +"' AND hora = '"+ horas +"'\n" +
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
    
    public int setPecasDefinidas(Integer codservico, Integer numPecas){
        if (numPecas == null){
            numPecas = setPecasDefinidas(codservico,-1);
            
        }else{
            if(numPecas == -1){
                //String text_consulta = "SELECT COUNT("
            }else{
                String texto_consulta = "";
            }
        }
        return 0;// pensando em como fazer ainda... :P
    }

    public boolean setAgendamento(ArrayList<String> CPFMecanico, Agenda agenda) {
        Date date = new Date();
        String texto_consulta
                = " INSERT INTO RevisaoPrincipal (kmatual, datarevisao, hora) VALUES (" + agenda.getKmatual() + ",'" + agenda.getData() + "','" + agenda.getHora() + "');"
                + "INSERT INTO REVISAO VALUES((SELECT MAX(CODREVISAO) FROM RevisaoPrincipal), '" + CPFMecanico.get(0) + "', '" + agenda.getCarro().getPlacaCarro() + "',"
                + "'" + agenda.getCliente().getCPF() + "', '" + agenda.getTipoDeRevisao().substring(0, 5) + "');"
                + "INSERT INTO FuncionarioRevisao VALUES((SELECT CPF FROM FUNCIONARIO WHERE login = '" + agenda.getUsuarioFuncionario() + "'), "
                + "'" + date + "', (SELECT MAX(codrevisao) FROM RevisaoPrincipal))";
        System.out.println(texto_consulta);
        System.out.println(agenda.getTipoDeRevisao().substring(0, 4));
        System.out.println(texto_consulta);

        try {
            con.st.execute(texto_consulta);
        } catch (SQLException e) {
            return false;
        }
        return true;
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
        "SELECT COUNT(RevisaoPrincipal.codRevisao) as oitoHoras FROM FuncionarioRevisao, Revisao, RevisaoPrincipal\n" +
        "WHERE FuncionarioRevisao.codRevisao = Revisao.codRevisao\n" +
        "AND Revisao.codRevisao = RevisaoPrincipal.codRevisao\n" +
        "AND  RevisaoPrincipal.dataRevisao = '"+ aux +"'\n" +
        "AND hora = '8:00') AS oitoHoras,\n" +
        "(SELECT COUNT(RevisaoPrincipal.codRevisao) as dezHoras FROM FuncionarioRevisao, Revisao, RevisaoPrincipal\n" +
        "WHERE FuncionarioRevisao.codRevisao = Revisao.codRevisao\n" +
        "AND Revisao.codRevisao = RevisaoPrincipal.codRevisao\n" +
        "AND  RevisaoPrincipal.dataRevisao = '"+ aux +"'\n" +
        "AND hora = '10:00') AS dezHoras,\n" +
        "(SELECT COUNT(RevisaoPrincipal.codRevisao) as dozeHoras FROM FuncionarioRevisao, Revisao, RevisaoPrincipal\n" +
        "WHERE FuncionarioRevisao.codRevisao = Revisao.codRevisao\n" +
        "AND Revisao.codRevisao = RevisaoPrincipal.codRevisao\n" +
        "AND  RevisaoPrincipal.dataRevisao = '"+ aux +"'\n" +
        "AND hora = '12:00') AS dozeHoras,\n" +
        "(SELECT COUNT(RevisaoPrincipal.codRevisao) as catorzeHoras FROM FuncionarioRevisao, Revisao, RevisaoPrincipal\n" +
        "WHERE FuncionarioRevisao.codRevisao = Revisao.codRevisao\n" +
        "AND Revisao.codRevisao = RevisaoPrincipal.codRevisao\n" +
        "AND  RevisaoPrincipal.dataRevisao = '"+ aux +"'\n" +
        "AND hora = '14:00') AS duasHoras,\n" +
        "(SELECT COUNT(RevisaoPrincipal.codRevisao) as dezesseisHoras FROM FuncionarioRevisao, Revisao, RevisaoPrincipal\n" +
        "WHERE FuncionarioRevisao.codRevisao = Revisao.codRevisao\n" +
        "AND Revisao.codRevisao = RevisaoPrincipal.codRevisao\n" +
        "AND RevisaoPrincipal.dataRevisao = '"+ aux +"'\n" +
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
    
    public ArrayList<Agenda> getRevisaoPorPeriodo(String inicio, String fim)
    {
        ArrayList<Agenda> Horarios = new ArrayList<Agenda>();
        ResultSet rs = null;  
        String texto_consulta = null;
             
        texto_consulta = "SELECT RevisaoPrincipal.dataRevisao, RevisaoPrincipal.hora, Funcionario.nome, Cliente.CPF, Cliente.nome, Carro.placaCarro, Carro.modelo " +
                "FROM Revisao, Funcionario, Cliente, Carro, RevisaoPrincipal " +
                "WHERE RevisaoPrincipal.dataRevisao >= '"+ inicio +"' AND " +
                "RevisaoPrincipal.dataRevisao <= '"+ fim +"' AND " +
                "RevisaoPrincipal.codRevisao = Revisao.codRevisao AND "+
                "Revisao.CPFMecanico = Funcionario.CPF AND "+
                "Revisao.placaCarro = Carro.placaCarro AND "+
                "Revisao.CPFCliente = Cliente.CPF "+
                "ORDER BY RevisaoPrincipal.dataRevisao ASC, RevisaoPrincipal.hora ASC";
        
        System.out.println(texto_consulta);
        try{
          con.st.execute(texto_consulta);
          rs = con.st.getResultSet();
          rs.next();
          
          while(rs.isAfterLast() == false)
          {      
            ArrayList<String> mecanico = new ArrayList<String>();
            Agenda agenda = new Agenda();
            Cliente cliente = new Cliente();
            Carro carro = new Carro();
            
            agenda.setData(rs.getDate(1));
            agenda.setHora(rs.getString(2));
            mecanico.add(rs.getString(3));
            agenda.setCpfMecanicos(mecanico);
            cliente.setCPF(rs.getString(4));
            cliente.setNome(rs.getString(5));
            agenda.setCliente(cliente);
            carro.setPlacaCarro(rs.getString(6));
            carro.setModelo(rs.getString(7));
            agenda.setCarro(carro);
            
            Horarios.add(agenda);
            rs.next();
          }
        }catch(SQLException e){
          return null;
        }
        
        return Horarios;
    }
    
    public Integer getLucroPeriodo(String inicio, String fim)
    {
        Integer valor_total;
        
        ResultSet rs = null;  
        String texto_consulta = null;
        
        texto_consulta = "SELECT SUM(R2.preco) FROM ("+
                "SELECT preco FROM  REVISAO, TipoRevisao, TipoDeServico, ("+
                "SELECT Revisao.codRevisao FROM "+
                "Revisao, RevisaoPrincipal "+
                "WHERE Revisao.codRevisao = RevisaoPrincipal.codRevisao AND RevisaoPrincipal.dataRevisao >= '"+inicio+"' "+
                "AND RevisaoPrincipal.dataRevisao < '"+fim+"'"+
                ") AS R1 "+
                "WHERE R1.codRevisao = Revisao.codRevisao "+
                "AND Revisao.quilometragem = TipoRevisao.quilometragem "+
                "AND TipoRevisao.codServico = TipoDeServico.codServico"+
                ") AS R2";
        
        System.out.println(texto_consulta);
        
        try{
          con.st.execute(texto_consulta);
          rs = con.st.getResultSet();
          rs.next();
          
          valor_total = Integer.parseInt(rs.getString(1));
        }catch(SQLException e){
          return null;
        }
        
        return valor_total;
    }
}
