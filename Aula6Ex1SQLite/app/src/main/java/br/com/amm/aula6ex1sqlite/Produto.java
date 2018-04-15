package br.com.amm.aula6ex1sqlite;

/**
 * Created by andre on 03/04/2018.
 */

public class Produto {
    private String nomeProduto;
    private double precoProduto;

    public Produto(String nomeProduto, double precoProduto) {
        this.nomeProduto = nomeProduto;
        this.precoProduto = precoProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public double getPrecoProduto() {
        return precoProduto;
    }

    @Override
    public String toString() {
        return nomeProduto + " R$ "+precoProduto;
    }
}
