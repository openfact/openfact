package org.openfact.representations.idm.ubl.common;

import java.util.List;

public interface PricingReferenceModel {

    ItemLocationQuantityModel getOriginalItemLocationQuantity();

    void setOriginalItemLocationQuantity(ItemLocationQuantityModel value);

    List<PriceModel> getAlternativeConditionPrice();

    void setAlternativeConditionPrice(List<PriceModel> alternativeConditionPrice);

    String getId();

    void setId(String value);

}
