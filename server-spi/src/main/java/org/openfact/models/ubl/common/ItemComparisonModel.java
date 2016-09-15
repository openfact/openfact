package org.openfact.models.ubl.common;

public interface ItemComparisonModel {

    PriceAmountModel getPriceAmount();

    void setPriceAmount(PriceAmountModel value);

    QuantityModelCommBas getQuantity();

    void setQuantity(QuantityModelCommBas value);

    String getId();

    void setId(String value);

}
