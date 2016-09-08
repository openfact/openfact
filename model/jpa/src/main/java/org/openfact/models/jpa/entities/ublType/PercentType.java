package org.openfact.models.jpa.entities.ublType;

import java.math.BigDecimal;

/**
 * Created by lxpary on 08/09/16.
 */
public class PercentType {
    protected BigDecimal value;

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
