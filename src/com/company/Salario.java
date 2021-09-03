package com.company;

public class Salario {
    private float salario;
    private float newSalario;

    public Salario(float salario){
        this.salario= salario;
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
        return "Salario{" +
                "salario=" + salario +
                ", newSalario=" + newSalario +
                '}';
    }
}
