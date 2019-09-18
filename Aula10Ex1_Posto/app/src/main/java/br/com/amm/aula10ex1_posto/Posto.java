package br.com.amm.aula10ex1_posto;

public class Posto {
    private String nomePosto;
    private double precoGas;
    private String ruaPosto;
    private int    nrPosto;
    private String cidadePosto;
    private String ufPosto;
    private String cepPosto;

    public Posto(String nomePosto, double precoGas, String ruaPosto, int nrPosto, String cidadePosto, String ufPosto, String cepPosto) {
        this.nomePosto = nomePosto;
        this.precoGas = precoGas;
        this.ruaPosto = ruaPosto;
        this.nrPosto = nrPosto;
        this.cidadePosto = cidadePosto;
        this.ufPosto = ufPosto;
        this.cepPosto = cepPosto;
    }

    public String getNomePosto() {
        return nomePosto;
    }

    public double getPrecoGas() {
        return precoGas;
    }

    public String getRuaPosto() {
        return ruaPosto;
    }

    public int getNrPosto() {
        return nrPosto;
    }

    public String getCidadePosto() {
        return cidadePosto;
    }

    public String getUfPosto() {
        return ufPosto;
    }

    public String getCepPosto() {
        return cepPosto;
    }

    @Override
    public String toString() {
        return  nomePosto " - " + precoGas;
    }


