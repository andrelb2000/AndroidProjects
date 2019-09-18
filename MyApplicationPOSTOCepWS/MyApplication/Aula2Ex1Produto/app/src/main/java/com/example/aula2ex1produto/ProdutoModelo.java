package com.example.aula2ex1produto;

public class ProdutoModelo {
    private String nomeProduto;
    private double precoProduto;
    private double descontoProduto;

    public ProdutoModelo(String nome,double preco, double desconto){
        nomeProduto     = nome;
        precoProduto    = preco;
        descontoProduto = desconto;
        precoProduto = precoProduto * (1 - (desconto/100));
    }
    public String getNomeProduto(){
        return nomeProduto;
    }

    public double getPrecoProduto() {
        return precoProduto;
    }

    public double getDescontoProduto() {
        return descontoProduto;
    }
}
