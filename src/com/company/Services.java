package com.company;

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

import static java.lang.Math.abs;

public class Services {
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
            else
                retornarCadastro="sair";
        }while (opUsuario>1);

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
        float percent;
        if (salario <9001){
            percent=((salario/100)*20)+salario;
        }else if(salario <13001){
            percent=((salario/100)*10)+salario;
        }else if(salario <=18000){
            percent=((salario/100)*5)+salario;
        }else
            percent=salario;

        return  percent;
    }

    public String formatarPercentuais(float salario, float novoSalario){
        DecimalFormat formatter = new DecimalFormat("#.00");
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
        float novoSalario=0, novoSalarioReserva=0,salario=0, salarioReserva=0;
        for (int i = 0; i < listClubs.size(); i++) {
            for (int j = 0; j < listClubs.get(i).getListPlayer().size(); j++) {
                if (listClubs.get(i).getListPlayer().get(j).getSituacao().equalsIgnoreCase(situacao)) {
                    novoSalarioReserva = listClubs.get(i).getListPlayer().get(j).getSalario().getNewSalario();
                    salarioReserva = listClubs.get(i).getListPlayer().get(j).getSalario().getSalario();
                }
            }
        }
        return this.formatarPercentuais(salarioReserva,novoSalarioReserva);
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
        for (int i = 0; i < listClubs.size(); i++) {
            qtd += listClubs.get(i).getListPlayer().size();
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
        DecimalFormat formatter = new DecimalFormat("###,###.00");
        return  "O Total dos salarios sem aumento percentual resultou em: "+ formatter.format(this.retornarTotalSalariosAtuais())+"\n"+
                "O Total dos novos salarios resultou em: "+ formatter.format(this.retornarTotalNovosSalarios())+"\n"+
                "Os dados do jogador com menor salario atual é: "+ this.dadosMenorSalarioAtual()+"\n"+
                "A participação percentual dos titulares sobre o total dos novos salarios é de: "+ this.percentualDeSalarios("Titular")+"\n"+
                "A participação percentual dos reservas sobre o total dos novos salarios é de: "+ this.percentualDeSalarios("Reserva")+"\n"+
                "Os jogadores com salarios acima da média são: "+ this.dadosMaiorSalarioAtual(mediaSalarioClubes(qtdJogadores()))+"\n"+
                "As seguintes informações dos clubes foram coletadas: "+ this.dadosClubes()+"\n"+
                "A média salarial dos jogadores baseada no salario sem aumento é de: "+ formatter.format(this.mediaSalarioClubes(qtdJogadores()))+"\n"+
                "A média salarial dos jogadores baseada no salario com aumento é de: "+ formatter.format(this.mediaNovoSalarioClubes(qtdJogadores()));

    }

}
