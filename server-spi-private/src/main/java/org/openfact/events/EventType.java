package org.openfact.events;

public enum EventType {

    INVOICE(true),

    CREDIT_NOTE(true),

    DEBIT_NOTE(true);

    private boolean saveByDefault;

    EventType(boolean saveByDefault) {
        this.saveByDefault = saveByDefault;
    }

    public boolean isSaveByDefault() {
        return saveByDefault;
    }

}
