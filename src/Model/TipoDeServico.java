/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author floss
 */
public class TipoDeServico {
    private Integer codServico;
    private String descricao;
    private Float preco;

    public Integer getCodServico() {
        return codServico;
    }

    public void setCodServico(Integer codServico) {
        this.codServico = codServico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public Integer getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(Integer quilometragem) {
        this.quilometragem = quilometragem;
    }

    public Float getTempoMedio() {
        return tempoMedio;
    }

    public void setTempoMedio(Float tempoMedio) {
        this.tempoMedio = tempoMedio;
    }
    private Integer quilometragem;
    private Float tempoMedio;
    
}
