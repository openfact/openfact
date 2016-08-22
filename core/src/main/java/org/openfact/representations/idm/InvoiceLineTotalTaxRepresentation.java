
package org.openfact.representations.idm;

import java.math.BigDecimal;

public class InvoiceLineTotalTaxRepresentation {

    private String document;
    private String reason;
    private BigDecimal ammount;

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public BigDecimal getAmmount() {
        return ammount;
    }

    public void setAmmount(BigDecimal ammount) {
        this.ammount = ammount;
    }

}