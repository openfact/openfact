package org.openfact.models.ubl.common;

import java.util.List;

public interface PricingReferenceType {

    ItemLocationQuantityType getOriginalItemLocationQuantity();

    void setOriginalItemLocationQuantity(ItemLocationQuantityType value);

    List<PriceType> getAlternativeConditionPrice();

    void setAlternativeConditionPrice(List<PriceType> alternativeConditionPrice);

    String getId();

    void setId(String value);

}
