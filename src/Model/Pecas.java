/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author marcello
 */
public class Pecas {
    private Date data;
    private String descricao;
    private Integer garantia;
    
    public Integer getGarantia() {
        return garantia;
    }

    public void setGarantia(Integer garantia) {
        this.garantia = garantia;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data =data;
    }    
    
    
}
