package com.example.solidproject.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Prestataire extends Employe{
    private int periodeService;
    private int coutService;

    @Override
    public int calculerRenumeration() {
        return periodeService*coutService;
    }

    public String toString(){
        return super.toString() + ", Prestataire{" +
                "periodeService=" + periodeService +
                ", coutService=" + coutService +
                '}';
    }
}
