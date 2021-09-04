package com.company;
import java.util.ArrayList;

public class Clube {
    private String nome;
    private String cidade;
    private ArrayList<Player>listPlayer= new ArrayList<>();

    public void addPlayer(String nome, String situacap, Clube clube, Salario salario){
        listPlayer.add(new Player(nome,situacap,clube, salario));
    }

    public ArrayList<Player> getListPlayer() {
        return listPlayer;
    }

    public void setListPlayer(ArrayList<Player> listPlayer) {
        this.listPlayer = listPlayer;
    }

    public Clube(String nome, String cidade) {
        this.nome = nome;
        this.cidade = cidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "nome= " + nome + "\n" +
                " cidade= " + cidade;
    }
}
