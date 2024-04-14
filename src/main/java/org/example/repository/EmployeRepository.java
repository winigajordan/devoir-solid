package org.example.repository;

import org.example.entite.Employe;

import java.util.ArrayList;
import java.util.List;

public class EmployeRepository {

    List<Employe> employes = new ArrayList<>();

    public void add(Employe employe) {
        employes.add(employe);
    }

    public List<Employe> list() {
        return employes;
    }

    public Employe findByMatricule(String matricule) {
        return employes.stream().filter(e -> e.getMatricule().equals(matricule)).findFirst().orElse(null);
    }


}
