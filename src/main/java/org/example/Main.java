package org.example;

import org.example.entite.Contractuel;
import org.example.entite.Employe;
import org.example.entite.Journalier;
import org.example.entite.Service;
import org.example.enums.Etat;
import org.example.enums.TypeContrat;
import org.example.service.EmployeService;
import org.example.service.ServService;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ServService servService = new ServService();
        EmployeService employeService = new EmployeService();

        int choix;
        Service service;
        Employe employe;

        do {
            System.out.println("1-Ajouter un Service");
            System.out.println("2-Ajouter un employe");

            choix = scanner.nextInt();
            scanner.nextLine();
            switch (choix) {
                case 1 -> {
                    service = new Service();
                    System.out.println("Ajouter un Service");
                    System.out.println("Entrer le code du service");
                    service.setCode(scanner.nextLine());
                    System.out.println("Entrer le nom du service");
                    service.setNom(scanner.nextLine());
                    servService.save(service);
                    System.out.println("Liste des Services");
                    servService.list();
                }
                case 2 -> {
                    System.out.println("Ajouter un Employe");

                    employe = new Employe();

                    System.out.println("Entrer l'etat de l'employe");
                    System.out.println("1-Conge");
                    System.out.println("2-Absent");
                    System.out.println("3-Malade");

                    int etat = scanner.nextInt();
                    employe.setEtat(Etat.getValue(etat));

                    System.out.println("Entrer le type d'employe");
                    System.out.println("1-COntratctuel");
                    System.out.println("2-Journalier");
                    System.out.println("3-Prestataire");

                    int type = scanner.nextInt();
                    if (type == 1) {
                        employe = new Contractuel();

                        System.out.println("Liste des services");
                        servService.list();
                        System.out.println("Entrer le code du service");
                          scanner.nextLine();

                        service = servService.findByCode(scanner.nextLine());
                        if (service == null) {
                            System.out.println("Ce service n'existe pas");
                        } else {
                            ((Contractuel) employe).setService(service);
                            System.out.println("Entrer le salaire de l'employe");
                            ((Contractuel) employe).setSalaireBrut(scanner.nextDouble());
                            System.out.println("Entrer les retenu de l'employe");
                            ((Contractuel) employe).setRetenue(scanner.nextDouble());
                            System.out.println("Choisir le type de contrat");
                            System.out.println("1-CDI");
                            System.out.println("2-CDD");


                                ((Contractuel) employe).setTypeContrat(TypeContrat.getValue(scanner.nextInt()));

                        }


                        employeService.save(employe);
                        System.out.println("Liste des Employes");
                        employeService.list();

                    } else {
                        //enregistrement journalier
                        System.out.println("Enregistrement d'un journalier");
                        employe = new Journalier();
                        System.out.println("Entrer le nombre de jour de travaille");
                        ((Journalier) employe).setNombreJour(scanner.nextInt());
                        System.out.println("Entrer le salaire de l'employe");
                        ((Journalier) employe).setMontantJournalier(scanner.nextDouble());
                        employeService.save(employe);
                        System.out.println("Liste des Employes");
                        employeService.list();


                    }

                }
                default -> System.out.println("Choix invalide");
            }
        } while (choix != 5);
        scanner.close();
    }
}


