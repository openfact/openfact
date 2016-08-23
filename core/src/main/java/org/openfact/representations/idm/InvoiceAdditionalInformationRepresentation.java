package org.openfact.representations.idm;

import java.math.BigDecimal;

/**
 * @author carlosthe19916@sistcoop.com
 */

public class InvoiceAdditionalInformationRepresentation {

    private String name;
    private BigDecimal amount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

}
