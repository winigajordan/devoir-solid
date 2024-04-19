package com.example.solidproject.repository.list;

import com.example.solidproject.entity.Employe;
import com.example.solidproject.entity.Service;
import com.example.solidproject.repository.interfaces.IEmployeRepository;
import com.example.solidproject.service.virement.Virement;

import java.util.ArrayList;
import java.util.List;

public class EmployeRepository implements IEmployeRepository {
    List<Employe> employes = new ArrayList<>();

    @Override
    public Employe findByMatricule(String matricule){
        return employes.stream().filter(c->c.getMatricule().compareToIgnoreCase(matricule)==0).findFirst().orElse(null);
    }

    @Override
    public void save(Employe employe){
        employe.setMatricule("EMP00"+employe.getId());
        employes.add(employe);
    }

    @Override
    public List<Employe> findAll(){
        return employes;
    }
}
