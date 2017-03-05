package org.openfact.events;

public enum OpenfactEventType {

    INVOICE(true),

    CREDIT_NOTE(true),

    DEBIT_NOTE(true);

    private boolean saveByDefault;

    OpenfactEventType(boolean saveByDefault) {
        this.saveByDefault = saveByDefault;
    }

    public boolean isSaveByDefault() {
        return saveByDefault;
    }

}
