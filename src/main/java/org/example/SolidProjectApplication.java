package com.example.solidproject;

import com.example.solidproject.entity.*;
import com.example.solidproject.enums.ContractType;
import com.example.solidproject.enums.Etat;
import com.example.solidproject.repository.interfaces.IEmployeRepository;
import com.example.solidproject.repository.interfaces.IServiceRepository;
import com.example.solidproject.repository.list.EmployeRepository;
import com.example.solidproject.repository.list.ServiceRepository;
import com.example.solidproject.service.EmployeService;
import com.example.solidproject.service.ServiceService;
import com.example.solidproject.service.virement.Virement;
import com.example.solidproject.service.virement.VirementBancaire;
import com.example.solidproject.service.virement.VirementOM;
import com.example.solidproject.service.virement.VirementWave;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SolidProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SolidProjectApplication.class, args);
		IServiceRepository serviceRepository = new ServiceRepository();
		IEmployeRepository employeRepository = new EmployeRepository();
		ServiceService serviceService = new ServiceService(serviceRepository);
		EmployeService employeService = new EmployeService(employeRepository);
		Scanner scanner=new Scanner(System.in);
		int choix;

		do{
			System.out.println("1-Enregister un service");
			System.out.println("2-Enregister un employé");
			System.out.println("3-Virer un salaire");
			System.out.println("4-Enregistrer un congé pour un employé");
			choix = scanner.nextInt();
			scanner.nextLine();
			switch (choix){
				case 1:
					Service service = new Service();
					System.out.println("Entrer le nom du service");
					String name = scanner.nextLine();
					serviceService.add(service,name);
					System.out.println("----------------------------------");
					System.out.println("Liste des services");
					serviceService.getAll().forEach(System.out::println);
					break;
				case 2:
					Employe employe = null;
					System.out.println("Veuillez choisir le type d'employé");
					System.out.println("1-Journalier");
					System.out.println("2-Contractuel");
					System.out.println("3-Prestataire");
					int typeEmploye = scanner.nextInt();
					switch (typeEmploye){
						case 1:
							employe = new Journalier();
							System.out.println("Veuillez entrer le cout journalier de l'employé");
							((Journalier) employe).setCoutJ(scanner.nextInt());
							System.out.println("Veuillez Entrer le nombre d'heures de l'employé");
							((Journalier) employe).setNbreJours(scanner.nextInt());
							
							employeService.add(employe);
							System.out.println("----------------------------------");
							System.out.println("Liste des employés");
							employeService.getAll().forEach(System.out::println);
							break;
						case 2:
							employe = new Contractuel();
							System.out.println("Veuillez entrer le salaire brut de l'employé");
							((Contractuel) employe).setSalaireBrut(scanner.nextInt());
							System.out.println("Veuillez entrer la retenue de l'employé");
							((Contractuel) employe).setRetenue(scanner.nextInt());
							//La prime est 10 % du salaire net
							((Contractuel) employe).setPrime(((Contractuel) employe).getSalaireBrut()*10/100);
							System.out.println("Veuillez entrer le code du service");
							scanner.nextLine();
							String codeService = scanner.nextLine();
							Service s = serviceService.getByCode(codeService);
							if(s==null){
								System.out.println("Service introuvable");
							}else{
								System.out.println("Veuillez choisir le type de contrat");
								System.out.println("1-CDI");
								System.out.println("2-CDD");
								int contrat = scanner.nextInt();
								if(contrat==1||contrat==2){
									((Contractuel) employe).setContractType(ContractType.getValue(contrat));
								}else{
									System.out.println("Type de contrat introuvable");
								}
							}
							((Contractuel) employe).setService(s);
							employeService.add(employe);
							System.out.println("----------------------------------");
							System.out.println("Liste des employés");
							employeService.getAll().forEach(System.out::println);
							break;
						case 3:
							employe = new Prestataire();
							System.out.println("Veuillez entrer la période de service");
							((Prestataire) employe).setCoutService(scanner.nextInt());
							System.out.println("Veuillez entrer le cout de service");
							((Prestataire) employe).setPeriodeService(scanner.nextInt());
							employeService.add(employe);
							System.out.println("----------------------------------");
							System.out.println("Liste des employés");
							employeService.getAll().forEach(System.out::println);
							break;

					}
					break;
				case 3:
					System.out.println("Veuillez entrer le matricule de l'employé");
					String matEmploye = scanner.nextLine();
					Employe e = employeService.getByMatricule(matEmploye);
					if (e==null){
						System.out.println("Employé introuvable");
						break;
					}
					System.out.println("Veuillez choisir la méthode de virement");
					System.out.println("1-Virement bancaire");
					System.out.println("2-Wave");
					System.out.println("3-Orange Money");
					int moyen = scanner.nextInt();
					Virement virement = null;
					if(moyen==1){
						virement = new VirementBancaire();
					}else if(moyen==2){
						virement = new VirementWave();
					}else if(moyen==3){
						virement = new VirementOM();
					}
					employeService.virerSalaire(e,virement);
					break;
				case 4:
					System.out.println("Veuillez entrer le matricule de l'employé");
					String mat = scanner.nextLine();
					Employe employe1 = employeService.getByMatricule(mat);
					if (employe1==null){
						System.out.println("Employé introuvable");
						break;
					}
					employe1.changerEtat(Etat.getValue(1));
					System.out.println("Congé enregistré avec succès");
					System.out.println(employe1.toString());
			}

		}while (choix!=5);
	}

}
