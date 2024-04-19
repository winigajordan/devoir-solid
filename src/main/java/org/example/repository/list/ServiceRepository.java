package com.example.solidproject.repository.list;

import com.example.solidproject.entity.Service;
import com.example.solidproject.repository.interfaces.IServiceRepository;

import java.util.ArrayList;
import java.util.List;

public class ServiceRepository implements IServiceRepository
{
    List<Service> services =new ArrayList<>();
    @Override
    public Service findByCode(String code){
        return services.stream().filter(c->c.getCode().compareToIgnoreCase(code)==0).findFirst().orElse(null);
    }

    @Override
    public void save(Service service){
        services.add(service);
    }

    @Override
    public List<Service> findAll(){
        return services;
    }
}
