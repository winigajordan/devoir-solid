package com.example.solidproject.entity;

import com.example.solidproject.enums.Etat;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employe {
    protected Long id;
    protected String matricule;
    protected static Long nbreEmployes =0L;
    private Etat etat;

    public Employe(){
        id=++nbreEmployes;
    }
    

    public int calculerRenumeration(){
        throw new RuntimeException("Not Found");
    }

    public void changerEtat(Etat etat){
        this.etat = etat;
    }

    public String toString(){
        return "Employe{" +
                "id=" + id +
                ", matricule='" + matricule + '\'' +
                ", etat=" + etat;
    }

}
