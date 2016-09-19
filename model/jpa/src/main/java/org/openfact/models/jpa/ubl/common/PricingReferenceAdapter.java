package org.openfact.models.jpa.ubl.common;

import java.util.List;

public class PricingReferenceAdapter implements PricingReferenceModel, JpaModel<PricingReferenceEntity> {

    protected static final Logger logger = Logger.getLogger(PricingReferenceAdapter.class);
    protected PricingReferenceEntity pricingReference;
    protected EntityManager em;
    protected OpenfactSession session;

    public PricingReferenceAdapter(OpenfactSession session, EntityManager em,
            PricingReferenceEntity pricingReference) {
        this.session = session;
        this.em = em;
        this.pricingReference = pricingReference;
    }

    ItemLocationQuantityAdapter getOriginalItemLocationQuantity() {
        return this.pricingReference.getOriginalItemLocationQuantity();
    }

    void setOriginalItemLocationQuantity(ItemLocationQuantityAdapter value) {
        this.pricingReference.setOriginalItemLocationQuantity(value);
    }

    List<PriceAdapter> getAlternativeConditionPrice() {
        return this.pricingReference.getAlternativeConditionPrice();
    }

    void setAlternativeConditionPrice(List<PriceAdapter> alternativeConditionPrice) {
        this.pricingReference.setAlternativeConditionPrice(alternativeConditionPrice);
    }

    String getId() {
        return this.pricingReference.getId();
    }

    void setId(String value) {
        this.pricingReference.setId(value);
    }

    /***
     * */
    PriceAdapter addAlternativeConditionPrice();

}
