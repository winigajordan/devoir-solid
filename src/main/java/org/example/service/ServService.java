package org.example.service;

import org.example.entite.Service;
import org.example.repository.ServiceRepository;

public class ServService {

    ServiceRepository repository = new ServiceRepository();


    public void save(Service service) {
        repository.add(service);
    }

    public void list() {
        repository.list().forEach(System.out::println);
    }

    public Service findByCode(String code) {
        return repository.findByCode(code);
    }


}
