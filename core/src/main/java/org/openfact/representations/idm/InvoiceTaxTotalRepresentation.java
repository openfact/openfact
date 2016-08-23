package org.openfact.representations.idm;

import java.math.BigDecimal;

/**
 * @author carlosthe19916@sistcoop.com
 */

public class InvoiceTaxTotalRepresentation {

    private String name;
    private BigDecimal amount;
    private BigDecimal value;

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

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

}
