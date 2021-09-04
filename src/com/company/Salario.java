package com.company;

import java.text.DecimalFormat;

public class Salario {
    private float salario;
    private float newSalario;

    public Salario(float salario, float newSalario){
        this.salario= salario;
        this.newSalario=newSalario;
    }
    public Salario(){
        this.salario= salario;
        this.newSalario=newSalario;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public float getNewSalario() {
        return newSalario;
    }

    public void setNewSalario(float newSalario) {
        this.newSalario = newSalario;
    }

    @Override
    public String toString() {
        DecimalFormat formatter = new DecimalFormat("###,###.00");
        String s = formatter.format(salario);
        String ns=formatter.format(newSalario);

        return " Salário= " +  s+"R$" +"\n" +
                " Novo saláio= " + ns+"R$\n";
    }
}
