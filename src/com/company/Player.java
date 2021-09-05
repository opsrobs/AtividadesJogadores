package com.company;

public class Player {
    private String nome;
    private String situacao;
    private Clube clube;
    private Salario salario;
    private Salario newSalario;


    public Player(String nome, String situacao, Clube clube, Salario salario) {
        this.nome = nome;
        this.situacao = situacao;
        this.clube = clube;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Clube getClube() {
        return clube;
    }

    public void setClube(Clube clube) {
        this.clube = clube;
    }

    public Salario getSalario() {
        return salario;
    }


    public void setSalario(Salario salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "\n Nome= " + nome + "\n" +
                " Situacão= " + situacao + "\n" +
                clube.toString() +"\n" +
                salario ;
    }
}
