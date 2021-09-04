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
        float salJogador;
        Player player;


        nomeClube= services.capNomeClube();
        while(!nomeClube.equalsIgnoreCase("sair")){
            nomeCidade= services.capNomeCidade();

            clube=new Clube(nomeClube,nomeCidade);
            nomeJogador= services.capNomeJogador();
            while (!nomeJogador.equalsIgnoreCase("sair")){
                salJogador=services.capSalarioJogador();
                salario= new Salario(salJogador,services.aumentoSalario(salJogador));
                services.infSalarios(salJogador,services.aumentoSalario(salJogador));
                situacao=services.capSituacaoJogador();
                player = new Player(nomeJogador,situacao,clube,salario);
                clube.addPlayer(nomeJogador,situacao,clube,salario);
                services.addListClub(clube);

                nomeJogador= services.capNomeJogador();
            }
            nomeClube=services.capNovoClube();
            System.out.println();
        }
        System.out.println(services.retornarTotalSalarios()+"\n");
        System.out.println(services.dadosMenorSalarioAtual()+"\n");
        System.out.println(services.percentualDeSalarios()+"\n");
        System.out.println(services.dadosMaiorSalarioAtual()+"\n");

    }
}
