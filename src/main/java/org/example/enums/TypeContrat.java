package org.example.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum TypeContrat {
    CDI(1),
    CDD(2);
    final  long index;
    public static TypeContrat getValue(int index) {
        return TypeContrat.values()[index-1];
    }
}
