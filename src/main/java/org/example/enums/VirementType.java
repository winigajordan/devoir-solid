package com.example.solidproject.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum VirementType {
    Bancaire(1),OM(2),Wave(3);
    public static VirementType getValue(int index) {
        return VirementType.values()[index-1];
    }
    private final int index;
}
