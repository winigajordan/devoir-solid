package org.example.repository;

import org.example.entite.Service;

import java.util.ArrayList;
import java.util.List;

public class ServiceRepository {
    List<Service> services = new ArrayList<>();

    public void add(Service service) {
        services.add(service);
    }

    public List<Service> list() {
        return services;
    }

    public  Service findByCode(String code) {
        return services.stream().filter(s -> s.getCode().equals(code)).findFirst().orElse(null);
    }



}
