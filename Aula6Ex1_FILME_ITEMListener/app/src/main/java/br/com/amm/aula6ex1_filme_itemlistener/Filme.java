package br.com.amm.aula6ex1_filme_itemlistener;

public class Filme {
    private String nomeFilme;
    private String atorFilme;
    private String dataFilme;

    public Filme(String nomeFilme, String atorFilme, String dataFilme) {
        this.nomeFilme = nomeFilme;
        this.atorFilme = atorFilme;
        this.dataFilme = dataFilme;
    }

    public String getNomeFilme() {
        return nomeFilme;
    }

    public String getAtorFilme() {
        return atorFilme;
    }

    public String getDataFilme() {
        return dataFilme;
    }

    @Override
    public String toString() {
        return "Filme:" + nomeFilme;
    }
}
