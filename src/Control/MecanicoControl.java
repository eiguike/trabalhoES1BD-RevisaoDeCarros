/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;
import Control.ConexaoBD;
import java.util.Date;
import Model.AgendaMecanico;
import Model.Carro;
import Model.Cliente;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class MecanicoControl {
    ConexaoBD con;
    
    public MecanicoControl(){
        con = new ConexaoBD();
    }
    
    public AgendaMecanico getRevisao(String login, String placaCarro, String quilometragem){
        String texto_consulta = 
                "SELECT REVISAOPRINCIPAL.DATAREVISAO, REVISAOPRINCIPAL.HORA, AUX.NOME, REVISAO.PLACACARRO, REVISAO.QUILOMETRAGEM "
                + "FROM REVISAO, REVISAOPRINCIPAL, CARRO, (SELECT NOME FROM CLIENTE WHERE CPF = "
                + "(SELECT CPFCLIENTE FROM REVISAO WHERE PLACACARRO='"+placaCarro+"' AND QUILOMETRAGEM='"+quilometragem+"')"
                + ") AS AUX WHERE REVISAO.CODREVISAO = REVISAOPRINCIPAL.CODREVISAO "
                + "AND REVISAO.quilometragem = '"+quilometragem+"' AND REVISAO.placaCarro='"+placaCarro+"'";
        ResultSet rs = null;
        
        System.out.println(texto_consulta);
        
        try{
            con.st.execute(texto_consulta);
            rs = con.st.getResultSet();
            rs.next();
            AgendaMecanico aux = new AgendaMecanico();
            aux.setData(rs.getDate(1));
            aux.setHora(rs.getString(2));
            aux.setCliente(new Cliente());
            aux.getCliente().setNome(rs.getString(3));
            aux.setCarro(new Carro());
            aux.getCarro().setPlacaCarro(rs.getString(4));
            
            return aux;
        }catch(SQLException e){
            return null;
        }
    }
    
    public ArrayList<AgendaMecanico> getCarrosSemana(String login, Date dataAtual, Date fim){
        System.out.println(dataAtual);
        String texto_consulta = 
        " SELECT REVISAOPRINCIPAL.DATAREVISAO, REVISAOPRINCIPAL.HORA, AUX.NOME, AUX.PLACACARRO, AUX.QUILOMETRAGEM\n" +
        " FROM REVISAOPRINCIPAL, (SELECT MEC.CPFMECANICO,CODREVISAO, CLIENTE.NOME, REVISAO.PLACACARRO, REVISAO.QUILOMETRAGEM FROM \n" +
        " REVISAO, CLIENTE, (SELECT CPF AS CPFMECANICO FROM FUNCIONARIO WHERE LOGIN ='"+login+"') AS MEC \n" +
        " WHERE CLIENTE.CPF = REVISAO.CPFCLIENTE AND REVISAO.CPFMECANICO = MEC.CPFMECANICO) AS AUX\n" +
        " WHERE AUX.CODREVISAO = REVISAOPRINCIPAL.CODREVISAO AND\n" +
        " REVISAOPRINCIPAL.DATAREVISAO >= '"+(dataAtual.getYear()+1900)+"-"+(dataAtual.getMonth()+1)+"-"+dataAtual.getDay()+"' "
        + "AND REVISAOPRINCIPAL.DATAREVISAO < DATE '"+(fim.getYear()+1900)+"-"+(fim.getMonth()+1)+"-"+fim.getDay()+"' + INTEGER'1'\n" +
        " ORDER BY REVISAOPRINCIPAL.DATAREVISAO ASC, REVISAOPRINCIPAL.HORA";
        
        System.out.println(texto_consulta);
        ConexaoBD con = new ConexaoBD();
        ResultSet rs = null;
        try{
            con.st.execute(texto_consulta);
            rs = con.st.getResultSet();
            rs.next();
            ArrayList<AgendaMecanico> agendaMecanico = new ArrayList<AgendaMecanico>();
            while(rs.isAfterLast() == false){
                AgendaMecanico aux = new AgendaMecanico();
                aux.setData(rs.getDate(1));
                aux.setHora(rs.getString(2));
                aux.setCarro(new Carro());
                aux.setCliente(new Cliente());
                aux.getCliente().setNome(rs.getString(3));
                aux.getCliente().setCPF(rs.getString(4));
                aux.getCarro().setPlacaCarro(rs.getString(4));
                aux.setQuilometragem(rs.getString(5));
                agendaMecanico.add(aux);
                rs.next();
            }
            return agendaMecanico;
        }catch(SQLException e){
            return null;
        }
    }
    
}
