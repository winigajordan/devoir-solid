package org.example.entite;

import lombok.Getter;
import lombok.Setter;
import org.example.enums.TypeContrat;

@Getter
@Setter
public class Contractuel extends Employe{
    private Double salaireBrut;
    private Double retenue;
    private Service service;
    private Double salaireNet;
    private TypeContrat typeContrat;

    private final Double PRIME = 0.1;


    public Contractuel() {

        /*
         y = retenue
         prime = brut + brut * x = (1+x)* brut
        annuel = brut + prime - y
        annuel = brut + brut + brut * 0.1 - y
        annuel = 2brut + brut * prime - y
        annuel = brut (2+ prime) -y
        annuel = 2.1 brut - y
         */


    }

    @Override
    public String toString() {
        return
                "id=" + getId() +
                " \n matricule='" + getMatricule() +
                "\n etat='" + getEtat()  +
                "\n salaireBrut='" + salaireBrut  +
                "\n retenue='" + retenue  +
                "\n service='" + service.getCode()  +
                "\n salaireNet='" + salaireNet  +
                "\n typeContrat='" + typeContrat.name()  +
                "\n ---------------------------------------------------------------- \n ";
    }


}
