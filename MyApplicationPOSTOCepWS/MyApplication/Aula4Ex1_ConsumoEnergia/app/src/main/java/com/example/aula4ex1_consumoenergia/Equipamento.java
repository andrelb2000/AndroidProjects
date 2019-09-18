package com.example.aula4ex1_consumoenergia;

public class Equipamento {
    private String usuarioEquipamento;
    private String nomeEquipamento;
    private int    consumoEquipamento;

    public Equipamento(String usuarioEquipamento, String nomeEquipamento, int consumoEquipamento) {
        this.usuarioEquipamento = usuarioEquipamento;
        this.nomeEquipamento = nomeEquipamento;
        this.consumoEquipamento = consumoEquipamento;
    }

    public String getUsuarioEquipamento() {
        return usuarioEquipamento;
    }

    public String getNomeEquipamento() {
        return nomeEquipamento;
    }

    public int getConsumoEquipamento() {
        return consumoEquipamento;
    }

    @Override
    public String toString() {
        return usuarioEquipamento + " - " + nomeEquipamento + " - " + consumoEquipamento;
    }
}
