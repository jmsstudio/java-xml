package br.com.jmsstudio.model;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Venda {

    @XmlAttribute
    private String moeda;

    @XmlElement
    private String formaDePagamento;

    @XmlElementWrapper(name = "produtos")
    @XmlElement(name = "produto")
    private List<Produto> produtos;

    public String getFormaDePagamento() {
        return formaDePagamento;
    }

    public void setFormaDePagamento(String formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public String getMoeda() {
        return moeda;
    }

    public void setMoeda(String moeda) {
        this.moeda = moeda;
    }

    @Override
    public String toString() {
        return "Venda{" +
                "moeda='" + moeda + '\'' +
                ", formaDePagamento='" + formaDePagamento + '\'' +
                ", produtos=" + produtos +
                '}';
    }
}
