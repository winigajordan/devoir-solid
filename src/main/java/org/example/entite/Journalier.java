package org.example.entite;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Journalier extends Employe {
    private Double montantJournalier;
    private Integer nombreJour;
    private Double salaire;


    @Override
    public String toString() {
        return "id=" + getId() +
                " \n matricule='" + getMatricule() +
                "\n montantJournalier='" + montantJournalier  +
                "\n nombreJour='" + nombreJour  +
                "\n salaire='" + salaire  +
                "\n ---------------------------------------------------------------- \n";


    }


}
