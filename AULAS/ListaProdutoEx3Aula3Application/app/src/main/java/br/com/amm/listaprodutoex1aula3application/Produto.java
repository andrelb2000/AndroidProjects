package br.com.amm.listaprodutoex1aula3application;

/**
 * Created by andre on 13/03/2018.
 */

public class Produto {
    private String nomeProduto;
    private int    quantidadeVenda;
    private double custoUnitario;
    private double precoVenda;

    public Produto(String nome,double custo,double preco){
        nomeProduto = nome;
        custoUnitario = custo;
        precoVenda = preco;
    }

    public double totalVenda(){
        return precoVenda * quantidadeVenda;
    }

    public double lucroTotal(){
        return totalVenda() - (quantidadeVenda*custoUnitario);
    }

    @Override
    public String toString() {
        return nomeProduto + "- R$ " + precoVenda;
    }

    public int getQuantidadeVenda() {
        return quantidadeVenda;
    }

    public void setQuantidadeVenda(int quantidadeVenda) {
        this.quantidadeVenda = quantidadeVenda;
    }
}
