package org.openfact.representations.idm.ubl.common;

import java.util.List;

public class PricingReferenceRepresentation {
    private ItemLocationQuantityRepresentation originalItemLocationQuantity;
    private List<PriceRepresentation> alternativeConditionPrice;
    private String id;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<PriceRepresentation> getAlternativeConditionPrice() {
        return this.alternativeConditionPrice;
    }

    public void setAlternativeConditionPrice(List<PriceRepresentation> alternativeConditionPrice) {
        this.alternativeConditionPrice = alternativeConditionPrice;
    }

    public ItemLocationQuantityRepresentation getOriginalItemLocationQuantity() {
        return this.originalItemLocationQuantity;
    }

    public void setOriginalItemLocationQuantity(
            ItemLocationQuantityRepresentation originalItemLocationQuantity) {
        this.originalItemLocationQuantity = originalItemLocationQuantity;
    }
}