package com.example.solidproject.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Service {
    private Long id;
    private static Long nbreServices = 0L;
    private String code;
    private String nom;

    @Override
    public String toString(){
        System.out.println("----------------------------------");
        return "Service [id=" + id + ", code= " + code  + ", nom= " + nom + "]";
    }

    public Service(){
        id=++nbreServices;
    }
}
