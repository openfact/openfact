package org.openfact.models.enums;

public enum MaritalStatus {

    SINGLE(1), MARRIED(2);

    private int value;

    private MaritalStatus(int value) {
        this.value = value;
    }
}
