package org.openfact.models.ubl.common;

import java.math.BigDecimal;

public interface ItemComparisonModel {

    BigDecimal getPriceAmount();

    void setPriceAmount(BigDecimal value);

    QuantityModel getQuantity();

    void setQuantity(QuantityModel value);

    String getId();

    

}
