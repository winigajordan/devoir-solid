package com.example.solidproject.repository.interfaces;

import com.example.solidproject.entity.Employe;

import java.util.List;

public interface IEmployeRepository {

    Employe findByMatricule(String matricule);
    public void save(Employe employe);
    List<Employe> findAll();
}
