package com.company;

public class Main {

    public static void main(String[] args) {
        Services services = new Services();
        Salario salario;
        Clube clube;
        String nomeClube;
        String nomeCidade;
            //
        String nomeJogador;
        String situacao;
        Player player=new Player();


        nomeClube= services.capNomeClube();
        while(!nomeClube.equalsIgnoreCase("sair")){
            nomeCidade= services.capNomeCidade();

            clube=new Clube(nomeClube,nomeCidade);
            nomeJogador= services.capNomeJogador();
            while (!nomeJogador.equalsIgnoreCase("sair")){
                salario= new Salario(services.capSalarioJogador());
                situacao=services.capSituacaoJogador();
                player = new Player(nomeJogador,situacao,clube,salario);
                clube.addPlayer(nomeJogador,situacao,clube,salario);

                nomeJogador= services.capNomeJogador();
                services.addListClub(clube);
            }
            nomeClube=services.capNovoClube();
            System.out.println();
        }
        System.out.println(services.retornarSalarios());
    }
}
