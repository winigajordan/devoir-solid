package com.example.solidproject.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ContractType {
    CDI(1),CDD(2);
    public static ContractType getValue(int index) {
        return ContractType.values()[index-1];
    }
    private final int index;
}
