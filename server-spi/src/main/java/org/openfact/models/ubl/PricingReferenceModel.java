package org.openfact.models.ubl;

public interface PricingReferenceModel {

    ItemLocationQuantityModel getOriginalItemLocationQuantity();

    void setOriginalItemLocationQuantity(ItemLocationQuantityModel originalItemLocationQuantity);

    PriceModel getAlternativeConditionPrice();

    void setAlternativeConditionPrice(PriceModel alternativeConditionPrice);

}
