package com.example.aula3ex_filmes_listas;

public class ProgramaModelo {
    private String nomePrograma;
    private double duracaoPrograma;
    private String categoriaPrograma;

    public ProgramaModelo(String nomePrograma,
                          double duracaoPrograma,
                          String categoriaPrograma) {
        this.nomePrograma = nomePrograma;
        this.duracaoPrograma = duracaoPrograma;
        this.categoriaPrograma = categoriaPrograma;
    }

    public String getNomePrograma() {
        return nomePrograma;
    }

    public double getDuracaoPrograma() {
        return duracaoPrograma;
    }

    public String getCategoriaPrograma() {
        return categoriaPrograma;
    }

    @Override
    public String toString() {
        return nomePrograma + " - " + categoriaPrograma;
    }
}
