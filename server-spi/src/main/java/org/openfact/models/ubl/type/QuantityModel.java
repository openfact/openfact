package org.openfact.models.ubl.type;

import java.math.BigDecimal;

public interface QuantityModel {

    BigDecimal getValue();

    void setValue(BigDecimal value);

    String getUnitCode();

    void setUnitCode(String unitCode);

}