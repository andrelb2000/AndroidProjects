package com.example.aula05ex1;

public class EstadoModelo {
    private String nomeEstado;
    private int    populacaoEstado;

    public EstadoModelo(String nomeEstado, int populacaoEstado) {
        this.nomeEstado = nomeEstado;
        this.populacaoEstado = populacaoEstado;
    }

    public String getNomeEstado() {
        return nomeEstado;
    }

    public int getPopulacaoEstado() {
        return populacaoEstado;
    }

    @Override
    public String toString() {
        return nomeEstado + " - Pop("+populacaoEstado+")";    }
}
