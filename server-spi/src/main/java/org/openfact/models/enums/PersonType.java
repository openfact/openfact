package org.openfact.models.enums;

public enum PersonType {

    NATURAL(1), LEGAL(2);

    private int value;

    private PersonType(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return this.value;
    }
    
}
