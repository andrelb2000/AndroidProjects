package br.com.amm.aula5ex1personagem;

public class Personagem {
    private String nomePersonagem;
    private int    forcaPersonagem;
    private double dinheiroPersonagem;

    public Personagem(String nomePersonagem,
                      int forcaPersonagem,
                      double dinheiroPersonagem) {
        this.nomePersonagem = nomePersonagem;
        this.forcaPersonagem = forcaPersonagem;
        this.dinheiroPersonagem = dinheiroPersonagem;
    }

    public String toString(){
        return "==> " + nomePersonagem + " Tem força "+forcaPersonagem ;
    }


}
