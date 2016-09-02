package org.openfact.events;

public enum EventType {

    /**
     * CUSTOMER EVENTS
     */
    SEND_CUSTOMER_EMAIL(true), SEND_CUSTOMER_EMAIL_ERROR(true),

    /**
     * CUSTOMER EVENTS
     */
    SEND_INVOICE_UBL(true), SEND_INVOICE_UBL_ERROR(true);

    private boolean saveByDefault;

    EventType(boolean saveByDefault) {
        this.saveByDefault = saveByDefault;
    }

    public boolean isSaveByDefault() {
        return saveByDefault;
    }

}
