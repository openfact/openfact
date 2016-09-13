package org.openfact.representations.idm.ubl.type;

import java.math.BigDecimal;

public class QuantityRepresentation {
    protected BigDecimal value;
    protected String unitCode;

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }
}
