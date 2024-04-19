package com.example.solidproject.service;

import com.example.solidproject.entity.Employe;
import com.example.solidproject.entity.Service;
import com.example.solidproject.repository.interfaces.IEmployeRepository;
import com.example.solidproject.repository.list.EmployeRepository;
import com.example.solidproject.service.virement.Virement;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class EmployeService {
    private final IEmployeRepository employeRepository;

    public Employe getByMatricule(String code){
        return employeRepository.findByMatricule(code);
    }

    public void add(Employe employe){
        employe.setMatricule("EMP00"+employe.getId());
        employeRepository.save(employe);
    }

    public void virerSalaire(Employe employe, Virement virement){
        int montant = employe.calculerRenumeration();
        virement.virement(employe,montant);
    }

    public List<Employe> getAll(){
        return employeRepository.findAll();
    }
}
