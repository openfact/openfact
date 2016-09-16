package org.openfact.representations.idm.ubl.common;

import java.math.BigDecimal;

public class QuantityRepresentation {
    private BigDecimal value;
    private String unitCode;
    private String id;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUnitCode() {
        return this.unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public BigDecimal getValue() {
        return this.value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}