package com.info.mercadoriaconsumer.Model;

public class Mercadoria {
    private String codbarras;
    private String descricao;
    private String marca;
    private Double quantidade;
    private Double estoqueminimo;

    public Mercadoria(){}

    public Mercadoria(String codbarras, String descricao, String marca, Double quantidade, Double estoqueminimo){
        this.codbarras = codbarras;
        this.descricao = descricao;
        this.marca = marca;
        this.quantidade = quantidade;
        this.estoqueminimo = estoqueminimo;
    }

    public String getCodbarras() {
        return codbarras;
    }

    public void setCodbarras(String codbarras) {
        this.codbarras = codbarras;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Double getEstoqueminimo() {
        return estoqueminimo;
    }

    public void setEstoqueminimo(Double estoqueminimo) {
        this.estoqueminimo = estoqueminimo;
    }
}
