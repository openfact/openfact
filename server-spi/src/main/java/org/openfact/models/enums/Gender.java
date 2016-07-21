package org.openfact.models.enums;

public enum Gender {

    MALE(1), FEMALE(2);

    private int value;

    private Gender(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

}
