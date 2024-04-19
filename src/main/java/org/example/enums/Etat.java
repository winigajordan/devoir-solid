package com.example.solidproject.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Etat {
    Conge(1),Absent(2),Malade(3);
    public static Etat getValue(int index) {
        return Etat.values()[index-1];
    }
    private final int index;
}
