package com.company;

import javax.swing.*;
import java.util.ArrayList;

public class Services {
    private ArrayList<Clube> listClubs = new ArrayList<>();

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
    public float capSalarioJogador(String jog){
        return Float.parseFloat(JOptionPane.showInputDialog("Informe o Salário do "+jog+": "));
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
    
    public String retornarSalarios(){
        String salarios="Sem dados...";
        for (int i = 0; i < listClubs.size(); i++) {
            salarios= String.valueOf(listClubs.get(i).getListPlayer().get(i).getSalario().toString());
            
        }
        return salarios;
        
    }



}
