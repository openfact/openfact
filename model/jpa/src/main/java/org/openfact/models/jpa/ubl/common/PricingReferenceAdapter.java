package org.openfact.models.jpa.ubl.common;

import java.util.List;

import javax.persistence.EntityManager;

import org.openfact.models.OpenfactSession;
import org.jboss.logging.Logger;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.ubl.common.ItemLocationQuantityModel;
import org.openfact.models.ubl.common.PriceModel;
import org.openfact.models.ubl.common.PricingReferenceModel;

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

    @Override
    public ItemLocationQuantityModel getOriginalItemLocationQuantity() {
        return this.pricingReference.getOriginalItemLocationQuantity();
    }

    @Override
    public void setOriginalItemLocationQuantity(ItemLocationQuantityAdapter value) {
        this.pricingReference.setOriginalItemLocationQuantity(value);
    }

    @Override
    public List<PriceModel> getAlternativeConditionPrice() {
        return this.pricingReference.getAlternativeConditionPrice();
    }

    @Override
    public void setAlternativeConditionPrice(List<PriceAdapter> alternativeConditionPrice) {
        this.pricingReference.setAlternativeConditionPrice(alternativeConditionPrice);
    }

    @Override
    public String getId() {
        return this.pricingReference.getId();
    }

    @Override
    public void setId(String value) {
        this.pricingReference.setId(value);
    }

    /***
     * */
    PriceAdapter addAlternativeConditionPrice();

}
