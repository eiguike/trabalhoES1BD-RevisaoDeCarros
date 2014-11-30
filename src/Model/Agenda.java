/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author floss
 */
public class Agenda {

    private String hora;
    private Integer kmatual;
    private Cliente cliente;
    private Date data;
    private ArrayList<String> cpfMecanicos;
    private Carro carro;
    private String tipoDeRevisao;
    private Integer tipoDeRevisao2;
    private String usuarioFuncionario;

    public Integer getTipoDeRevisao2() {
        return tipoDeRevisao2;
    }

    public void setTipoDeRevisao2(Integer tipoDeRevisao2) {
        this.tipoDeRevisao2 = tipoDeRevisao2;
    }

    public String getUsuarioFuncionario() {
        return usuarioFuncionario;
    }

    public void setUsuarioFuncionario(String usuarioFuncionario) {
        this.usuarioFuncionario = usuarioFuncionario;
    }

    public String getTipoDeRevisao() {
        return tipoDeRevisao;
    }

    public void setTipoDeRevisao(String tipoDeRevisao) {
        this.tipoDeRevisao = tipoDeRevisao;
    }

    public Integer getKmatual() {
        return kmatual;
    }

    public void setKmatual(Integer kmatual) {
        this.kmatual = kmatual;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public ArrayList<String> getCpfMecanicos() {
        return cpfMecanicos;
    }

    public void setCpfMecanicos(ArrayList<String> cpfMecanicos) {
        this.cpfMecanicos = cpfMecanicos;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
