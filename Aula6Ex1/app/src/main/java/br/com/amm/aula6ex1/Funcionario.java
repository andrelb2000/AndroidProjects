package br.com.amm.aula6ex1;

public class Funcionario {
    private String nomeFuncionario;
    private double salarioFuncionario;

    public Funcionario(String nomeFuncionario, double salarioFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
        this.salarioFuncionario = salarioFuncionario;
    }
    public String getNomeFuncionario() {
        return nomeFuncionario;
    }
    public double getSalarioFuncionario() {
        return salarioFuncionario;
    }
}
