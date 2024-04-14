package org.example.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Etat {
    CONGE (1),
    ABSENT(2),
    MALADE(3);

    final long index;
    public static Etat getValue(int index) {
            return Etat.values()[index-1];
    }
}
