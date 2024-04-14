package org.example.entite;

import lombok.Getter;
import lombok.Setter;
import org.example.enums.Etat;

@Getter
@Setter

public class Employe {
    private static Long nbrEmploye = 0L;
    private Long id;
    private String matricule;
    private Etat etat;


    public Employe() {
        this.id = ++nbrEmploye;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                " \n matricule='" + matricule +
                "\n etat='" + etat  +
                "\n ---------------------------------------------------------------- \n ";
    }


}
