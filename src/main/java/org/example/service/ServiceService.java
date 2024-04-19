package com.example.solidproject.service;

import com.example.solidproject.entity.Service;
import com.example.solidproject.repository.interfaces.IServiceRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
@RequiredArgsConstructor
public class ServiceService {
    private final IServiceRepository serviceRepository;

    public Service getByCode(String code){
        return serviceRepository.findByCode(code);
    }

    public void add(Service service,String nom){
        service.setCode("CL00"+service.getId());
        service.setNom(nom);
        serviceRepository.save(service);
    }

    public List<Service> getAll(){
        return serviceRepository.findAll();
    }

}
