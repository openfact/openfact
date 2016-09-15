package org.openfact.models.ubl.common;

public interface ItemComparisonType {

    PriceAmountType getPriceAmount();

    void setPriceAmount(PriceAmountType value);

    QuantityTypeCommBas getQuantity();

    void setQuantity(QuantityTypeCommBas value);

    String getId();

    void setId(String value);

}
