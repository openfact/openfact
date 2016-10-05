package org.openfact.models.ubl.common;

import java.math.BigDecimal;

public interface AdditionalMonetaryTotalModel {

    String getID();

    void setID(String value);

    String getName();

    void setName(String value);

    BigDecimal getReferenceAmount();

    void setReferenceAmount(BigDecimal value);

    BigDecimal getPayableAmount();

    void setPayableAmount(BigDecimal value);

    BigDecimal getPercent();

    void setPercent(BigDecimal value);

    BigDecimal getTotalAmount();

    void setTotalAmount(BigDecimal value);

    String getId();

    

}
