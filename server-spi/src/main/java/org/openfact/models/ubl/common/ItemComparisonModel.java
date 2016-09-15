package org.openfact.models.ubl.common;

import java.math.BigDecimal;

public interface ItemComparisonModel {

    BigDecimal getPriceAmount();

    void setPriceAmount(BigDecimal value);

    QuantityModelCommBas getQuantity();

    void setQuantity(QuantityModelCommBas value);

    String getId();

    void setId(String value);

}
