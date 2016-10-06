package org.openfact.models.ubl.common;

import java.math.BigDecimal;

public interface MeasureModel {

    BigDecimal getValue();

    void setValue(BigDecimal value);

    String getUnitCode();

    void setUnitCode(String value);

    String getId();

    

}
