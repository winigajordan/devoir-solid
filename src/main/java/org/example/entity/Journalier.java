package com.example.solidproject.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Journalier extends Employe{
    private int coutJ;
    private int nbreJours;
    private int salaire;

    @Override
    public int calculerRenumeration() {
        salaire = coutJ*nbreJours;
        return salaire;
    }

    public String toString(){
        return super.toString() + ", Journalier{" +
                "coutJ=" + coutJ +
                ", nbreJours=" + nbreJours +
                ", salaire=" + salaire +
                '}';
    }
}
