package br.com.amm.aularevav1_veiculo;

public class Motorista {
    private String nomeMotorista;
    private String marcaCarro;
    private int nrMultas;
    private double precoCarro;

    public Motorista(String nomeMotorista, String marcaCarro, int nrMultas, double precoCarro) {
        this.nomeMotorista = nomeMotorista;
        this.marcaCarro = marcaCarro;
        this.nrMultas = nrMultas;
        this.precoCarro = precoCarro;
    }

    public String getNomeMotorista() {
        return nomeMotorista;
    }

    public String getMarcaCarro() {
        return marcaCarro;
    }

    public int getNrMultas() {
        return nrMultas;
    }

    public double getPrecoCarro() {
        return precoCarro;
    }

    @Override
    public String toString() {
        return nomeMotorista + " - " + marcaCarro;
    }
}
