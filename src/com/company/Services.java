package com.company;

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

import static java.lang.Math.abs;

public class Services {
    private DecimalFormat formatter = new DecimalFormat("###,###.00");

    private final ArrayList<Clube> listClubs = new ArrayList<>();

    public void addListClub(Clube clube){
        listClubs.add(clube);
    }

    public String capNomeClube(){
        return JOptionPane.showInputDialog("Informe o nome do Clube: ");
    }

    public String capNomeCidade(){
        return JOptionPane.showInputDialog("Informe qual a cidade do clube: ");
    }

    public String capNomeJogador(){
        return JOptionPane.showInputDialog("Informe o nome do Jogador: ");
    }

    public String capSituacaoJogador(){
        int situacaoJog;
        String situacao;
        do {
            situacaoJog= Integer.parseInt(JOptionPane.showInputDialog("Informe a situação do jogador: \n\t[0]RESERVA \n\t[1]TITULAR"));
            String.valueOf(situacaoJog);
            if (situacaoJog==0)
                situacao="Reserva";
            else
                situacao="Titular";
        }while (situacaoJog>1);
        return situacao;
    }

    public float capSalarioJogador(){
        return Float.parseFloat(JOptionPane.showInputDialog("Informe o salario atual do Jgador: "));
    }

    public String capNovoClube(){
        int opUsuario;
        String retornarCadastro;
        do {
            opUsuario= Integer.parseInt(JOptionPane.showInputDialog("O que você deseja fazer? \n\t[0]NOVO CADASTRO \n\t[1]SAIR"));
            if (opUsuario==0)
                retornarCadastro=JOptionPane.showInputDialog("Informe o nome do clube: ");
            else{
            retornarCadastro = "sair";
            this.apresentarOpcao(this.escolherOpcao());
            }
        }while (opUsuario>2);
        return retornarCadastro;
    }
    
    public float retornarTotalSalariosAtuais(){
        float salarioAtual=0;
        for (int i = 0; i < listClubs.size(); i++) {
            for (int j = 0; j < listClubs.get(i).getListPlayer().size(); j++) {
                salarioAtual+=Float.parseFloat(String.valueOf(listClubs.get(i).getListPlayer().get(j).getSalario().getSalario()));
            }
        }
        return salarioAtual;
    }

    public float retornarTotalNovosSalarios(){
        float novoSalario=0;
        for (int i = 0; i < listClubs.size(); i++) {
            for (int j = 0; j < listClubs.get(i).getListPlayer().size(); j++) {
                novoSalario+=Float.parseFloat(String.valueOf(listClubs.get(i).getListPlayer().get(j).getSalario().getNewSalario()));
            }
        }
        return novoSalario;
    }
    
    public String dadosMenorSalarioAtual(){
        float ms=99999999;
        String salario="";
        for (int i = 0; i < listClubs.size(); i++) {
            for (int j = 0; j < listClubs.get(i).getListPlayer().size(); j++) {
                if (listClubs.get(i).getListPlayer().get(j).getSalario().getSalario() <ms) {
                    ms = Float.parseFloat(String.valueOf(listClubs.get(i).getListPlayer().get(j).getSalario().getSalario()));
                    salario =listClubs.get(i).getListPlayer().get(j).toString();
                }
            }
        }
        return salario;
    }

    public float aumentoSalario(float salario){
        if (salario <9001){
            salario=((salario/100)*20)+salario;
        }else if(salario <13001){
            salario=((salario/100)*10)+salario;
        }else if(salario <=18000){
            salario=((salario/100)*5)+salario;
        }

        return  salario;
    }

    public String formatarPercentuais(float salario, float novoSalario){
        int centena=100;
        String formato;
        float s=abs(((salario*centena)/novoSalario)-centena);
        if (s>0)
        formato= formatter.format(s)+"%";
        else
            formato="Sem valores...";
        return formato;
    }

    public String percentualDeSalarios(String situacao){
        float novoSalarioReserva=0;
        for (int i = 0; i < listClubs.size(); i++) {
            for (int j = 0; j < listClubs.get(i).getListPlayer().size(); j++) {
                if (listClubs.get(i).getListPlayer().get(j).getSituacao().equalsIgnoreCase(situacao)) {
                    novoSalarioReserva += listClubs.get(i).getListPlayer().get(j).getSalario().getNewSalario();
                }
            }
        }
        return this.formatarPercentuais(this.retornarTotalNovosSalarios(),novoSalarioReserva);
    }

    public String dadosMaiorSalarioAtual(float media){
    String jogadores= "";
    for (int i = 0; i < listClubs.size(); i++) {
        for (int j = 0; j < listClubs.get(i).getListPlayer().size(); j++) {
            if (listClubs.get(i).getListPlayer().get(j).getSalario().getSalario() >media) {
                jogadores += "\n"+listClubs.get(i).getListPlayer().get(j).getNome()+": "+ listClubs.get(i).getListPlayer().get(j).getSalario().toString();
            }
        }
    }
    return jogadores;
    }

    public ArrayList dadosClubes(){
        return listClubs;
    }

    public int qtdJogadores(){
        int qtd=0;
        for (Clube listClub : listClubs) {
            qtd += listClub.getListPlayer().size();
        }
        return qtd;
    }

    public float mediaSalarioClubes(int qtd){
        float salario=0;
        for (int i = 0; i < listClubs.size(); i++) {
            for (int j = 0; j < listClubs.get(i).getListPlayer().size(); j++) {
                salario+= listClubs.get(i).getListPlayer().get(j).getSalario().getSalario();
            }
        }
        return salario / Float.parseFloat(String.valueOf(qtd));
    }

    public String mediaSalarioPorClubes(){
        float salario=0;
        String nomeClube="", dadosPorClube="";
        for (int i = 0; i < listClubs.size(); i++) {
            float qtd = listClubs.get(i).getListPlayer().size();
            for (int j = 0; j < listClubs.get(i).getListPlayer().size(); j++) {
                nomeClube=listClubs.get(i).toString();
                salario+= listClubs.get(i).getListPlayer().get(j).getSalario().getSalario();
            }
            salario=salario / qtd;
            dadosPorClube+="O nome e cidade sede do clube é: \n"+"\t"+nomeClube+":\n"+
                           "\tA média salarial do clube é: "+formatter.format(salario)+"\n"+
                           "\tA quantidade de jogadores do clube é: "+qtd+"\n";
            salario=0;
            qtd=0;
        }
        return dadosPorClube;
    }

    public float mediaNovoSalarioClubes(int qtd){
        float salario=0;
        for (int i = 0; i < listClubs.size(); i++) {
            for (int j = 0; j < listClubs.get(i).getListPlayer().size(); j++) {
                salario+= listClubs.get(i).getListPlayer().get(j).getSalario().getNewSalario();
            }
        }
        return salario / Float.parseFloat(String.valueOf(qtd));
    }

    public String toString(){
        return  "O Total dos salarios sem aumento percentual resultou em: "+ formatter.format(this.retornarTotalSalariosAtuais())+"\n"+
                "O Total dos novos salarios resultou em: "+ formatter.format(this.retornarTotalNovosSalarios())+"\n"+
                "Os dados do jogador com menor salario atual é: "+ this.dadosMenorSalarioAtual()+"\n"+
                "A participação percentual dos titulares sobre o total dos novos salarios é de: "+ this.percentualDeSalarios("Titular")+"\n"+
                "A participação percentual dos reservas sobre o total dos novos salarios é de: "+ this.percentualDeSalarios("Reserva")+"\n"+
                "Os jogadores com salarios acima da média são: "+ this.dadosMaiorSalarioAtual(mediaSalarioClubes(qtdJogadores()))+"\n"+
                "As seguintes informações dos clubes foram coletadas: "+ this.dadosClubes()+"\n"+
                "A média salarial dos jogadores baseada no salario sem aumento é de: "+ formatter.format(this.mediaSalarioClubes(qtdJogadores()))+"\n"+
                "A média salarial dos jogadores baseada no salario com aumento é de: "+ formatter.format(this.mediaNovoSalarioClubes(qtdJogadores()))+"\n"+
                "A quantidade de jogadores é de: "+ formatter.format(this.qtdJogadores())+"\n"+
                this.mediaSalarioPorClubes();
    }

    public void apresentarOpcao(int opcao){
        switch (opcao) {
            case 1 -> System.out.println("O Total dos salarios sem aumento percentual resultou em: " + formatter.format(this.retornarTotalSalariosAtuais()) + "\n" +
                    "O Total dos novos salarios resultou em: " + formatter.format(this.retornarTotalNovosSalarios()) + "\n");
            case 2 -> System.out.println("Os dados do jogador com menor salario atual é: " + this.dadosMenorSalarioAtual());
            case 3 -> System.out.println("A participação percentual dos titulares sobre o total dos novos salarios é de: " + this.percentualDeSalarios("Titular") + "\n" +
                    "A participação percentual dos reservas sobre o total dos novos salarios é de: " + this.percentualDeSalarios("Reserva"));
            case 4 -> System.out.println("Os jogadores com salarios acima da média são: " + this.dadosMaiorSalarioAtual(mediaSalarioClubes(qtdJogadores())));
            case 5 -> System.out.println(this.mediaSalarioPorClubes());
            case 6 -> System.out.println(this.toString());
        }

    }

    public int escolherOpcao(){
        int op=0;
        do {
            op=Integer.parseInt(JOptionPane.showInputDialog("""
                    Informe a opção desejada:\s
                    \t[1] Total dos salários atuais e dos novos salários!
                    \t[2] Nome, salário atual e novo salário do jogador com menor salário atual!
                    \t[3] Participação percentual dos novos salários dos titulares e dos reservas sobre o total de novos salários!
                    \t[4] Nome, salário atual e novo salário dos jogadores com novo salário acima da média de novos salários!
                    \t[5] Nome do clube e cidade-sede, média salarial e quantidade de jogadores!
                    \t[6] TOTAS AS INFORMAÇÕES!!!"""));
        }while (op >6);
        return op;


    }

}
