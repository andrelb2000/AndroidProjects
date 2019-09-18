package com.example.myapplication;

public class Posto {
    private String nomePosto;
    private String cepPosto;
    private String ruaPosto;

    public Posto(String nomePosto, String cepPosto, String ruaPosto) {
        this.nomePosto = nomePosto;
        this.cepPosto = cepPosto;
        this.ruaPosto = ruaPosto;
    }
    public String getNomePosto() {
        return nomePosto;
    }
    public String getCepPosto() {
        return cepPosto;
    }
    public String getRuaPosto() {
        return ruaPosto;
    }
    @Override
    public String toString() {
        return nomePosto + " - " + ruaPosto;
    }


}
