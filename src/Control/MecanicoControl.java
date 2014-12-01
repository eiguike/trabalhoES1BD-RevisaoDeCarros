/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;
import Control.ConexaoBD;
import Model.Carro;
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
    
    public ArrayList<Carro> getCarrosSemana(){
        ResultSet rs = null;
        String texto_consulta = "SELECT ";
        return null;
    }
    
}
