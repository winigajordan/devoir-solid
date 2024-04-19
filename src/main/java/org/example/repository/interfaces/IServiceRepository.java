package com.example.solidproject.repository.interfaces;

import com.example.solidproject.entity.Service;

import java.util.List;

public interface IServiceRepository
{
    Service findByCode(String code);
    void save(Service service);
    List<Service> findAll();
}
