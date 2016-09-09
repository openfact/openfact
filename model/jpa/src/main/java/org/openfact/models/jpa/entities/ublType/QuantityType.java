package org.openfact.models.jpa.entities.ublType;

import java.math.BigDecimal;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;

/**
 * Created by lxpary on 08/09/16.
 */
@Embeddable
@Access(AccessType.FIELD)
public class QuantityType {
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
