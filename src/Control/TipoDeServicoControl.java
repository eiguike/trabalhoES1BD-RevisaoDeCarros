/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.TipoDeServico;
import Control.ConexaoBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author floss
 */
public class TipoDeServicoControl {

    private ConexaoBD con;
    //TipoDeServico tipodeservico;
    ArrayList<TipoDeServico> retTiposDeServicos;

    public TipoDeServicoControl() {
        con = new ConexaoBD();

    }

    public ArrayList<TipoDeServico> getTiposDeServicos() {
        ArrayList<TipoDeServico> retTiposDeServicos = new ArrayList<TipoDeServico>();
        TipoDeServico aux;
        ResultSet rs = null;
        Integer i2;

        String texto_consulta = "SELECT CODSERVICO, DESCRICAO, PRECO, QUILOMETRAGEM, TEMPOMEDIO FROM TIPODESERVICO";
        
        try {
            con.st.execute(texto_consulta);
            rs = con.st.getResultSet();
            rs.next();
            for (i2 = 0; (rs.isAfterLast() == false); i2++) {
                aux = new TipoDeServico();
                aux.setCodServico(rs.getInt(1));
                aux.setDescricao(rs.getString(2));
                aux.setPreco(rs.getFloat(3));
                aux.setQuilometragem(rs.getInt(4));
                aux.setTempoMedio(rs.getFloat(5));      
                retTiposDeServicos.add(aux);
                rs.next();
            }
            rs.next();
            
            return retTiposDeServicos;
        } catch (SQLException e) {
            return null;
        }

    }

}
