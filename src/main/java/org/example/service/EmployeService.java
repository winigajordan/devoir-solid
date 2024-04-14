package org.example.service;

import org.example.entite.Contractuel;
import org.example.entite.Employe;
import org.example.entite.Journalier;
import org.example.repository.EmployeRepository;

public class EmployeService {

    EmployeRepository repository = new EmployeRepository();

    public  void save(Employe employe) {
        employe.setMatricule("EMP-"+employe.getId());
        if (employe instanceof Contractuel){
            Contractuel contractuel = (Contractuel) employe;
            contractuel.setSalaireNet((2 + contractuel.getPRIME()) * contractuel.getSalaireBrut() - contractuel.getRetenue());
        }
        if (employe instanceof Journalier){
            Journalier journalier = (Journalier) employe;
            journalier.setSalaire(journalier.getMontantJournalier() * journalier.getNombreJour());
        }


        repository.add(employe);
    }

    public void list() {
        repository.list().forEach(System.out::println);
    }

    public Employe findByMatricule(String matricule) {
        return repository.findByMatricule(matricule);
    }
}
