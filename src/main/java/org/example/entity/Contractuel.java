package com.example.solidproject.entity;

import com.example.solidproject.enums.ContractType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Contractuel extends Employe{
    private int prime;
    private int retenue;
    private int salaireBrut;
    private int salaireNet;

    private Service service;
    private ContractType contractType;

    @Override
    public int calculerRenumeration() {
        return salaireBrut+prime-retenue;
    }

    public String toString(){
        return super.toString() + ", Contractuel{" +
                "prime=" + prime +
                ", retenue=" + retenue +
                ", salaireBrut=" + salaireBrut +
                ", salaireNet=" + salaireNet +
                ", service=" + service.getNom() +
                ", contractType=" + contractType +
                '}';
    }
}
