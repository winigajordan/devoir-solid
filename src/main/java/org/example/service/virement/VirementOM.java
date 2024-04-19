package com.example.solidproject.service.virement;

import com.example.solidproject.entity.Employe;

public class VirementOM implements Virement{
    @Override
    public void virement(Employe employe, int salaire) {
        System.out.println("Le virement d'un salaire de montant "
                +salaire+" a ete bien envoyé à l'employé de matricule "
                +employe.getMatricule()+" par Orange Money");
    }
}
