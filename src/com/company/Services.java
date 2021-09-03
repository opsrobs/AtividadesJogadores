package com.company;

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Services {
    Salario salario= new Salario();
    private ArrayList<Clube> listClubs = new ArrayList<>();

    public void addListClub(Clube clube){
        listClubs.add(clube);
    }

    public void menuInicial(int op){
        this.aumentoSalario(op);
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

            situacao=String.valueOf(situacaoJog);
            if (situacaoJog==0)
                situacao="Reserva!";
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
            opUsuario= Integer.parseInt(JOptionPane.showInputDialog("Informe a situação do jogador: \n\t[0]NOVO CADASTRO \n\t[1]SAIR"));
            if (opUsuario==0)
                retornarCadastro=JOptionPane.showInputDialog("Informe qual a cidade do clube: ");
            else
                retornarCadastro="sair";
        }while (opUsuario>1);

        return retornarCadastro;

    }
    
    public String retornarTotalSalarios(){
        DecimalFormat formatter = new DecimalFormat("###,###.00");
        float salarioAtual=0;
        String salarioAtualF="";
        float novoSalario=0;
        String novoSalariof;
        for (int i = 0; i < listClubs.size(); i++) {
            salarioAtual+=Float.parseFloat(String.valueOf(listClubs.get(i).getListPlayer().get(i).getSalario().getSalario()));
            novoSalario+= salario.getNewSalario() ;
        }
        salarioAtualF=formatter.format(salarioAtual);
        novoSalariof=formatter.format(novoSalario);
        return "O total dos salarios atuais é: "+ salarioAtualF+"R$"+
                "\n E o total dos novos sálarios é: " +novoSalariof+"R$";
        
    }
    
    public String dadosMenorSalarioAtual(){
        DecimalFormat formatter = new DecimalFormat("###,###.00");
        float ms=99999999;
        int cont=0;
        int pos=0;
        String salarioAtual="";
        String salAtual="",novoSal="",nome="";
        for (int i = 0; i < listClubs.size(); i++,cont++) {
            if (listClubs.get(i).getListPlayer().get(i).getSalario().getSalario() <ms) {
                ms = Float.parseFloat(String.valueOf(listClubs.get(i).getListPlayer().get(i).getSalario().getSalario()));
                pos=cont;
            }
        }
        return listClubs.get(pos).getListPlayer().get(pos).toString();
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

    public void infSalarios(float sal, float novoSal){
        salario.setSalario(sal);
        salario.setNewSalario(novoSal);
    }

    public float percentualDeSalarios(){
        int cont=0;
        float novoSalario=0;
        for (int i = 0; i < listClubs.size(); i++) {
            for (int j = 0; j < listClubs.get(i).getListPlayer().size(); j++) {
                if (listClubs.get(i).getListPlayer().get (j).getSituacao().equalsIgnoreCase("titular")){
                    cont++;
                    novoSalario+=listClubs.get(j).getListPlayer().get(j).getSalario().getNewSalario();
                }

            }
        }
        return novoSalario;
    }



}
