package org.openfact.models.jpa.ubl.common;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.AllowanceChargeEntity;
import org.openfact.models.jpa.entities.ubl.common.AddressEntity;
import org.openfact.models.jpa.entities.ubl.common.PriceEntity;
import org.openfact.models.jpa.entities.ubl.common.PricingReferenceEntity;
import org.openfact.models.jpa.entities.ubl.common.TaxTotalEntity;
import org.openfact.models.ubl.common.AllowanceChargeModel;
import org.openfact.models.ubl.common.AddressModel;
import org.openfact.models.ubl.common.ItemLocationQuantityModel;
import org.openfact.models.ubl.common.PriceModel;
import org.openfact.models.ubl.common.PricingReferenceModel;

public class PricingReferenceAdapter implements PricingReferenceModel, JpaModel<PricingReferenceEntity> {

	protected static final Logger logger = Logger.getLogger(PricingReferenceAdapter.class);
	protected PricingReferenceEntity pricingReference;
	protected EntityManager em;
	protected OpenfactSession session;

	public PricingReferenceAdapter(OpenfactSession session, EntityManager em, PricingReferenceEntity pricingReference) {
		this.session = session;
		this.em = em;
		this.pricingReference = pricingReference;
	}

	@Override
	public ItemLocationQuantityModel getOriginalItemLocationQuantity() {
		return new ItemLocationQuantityAdapter(session, em, this.pricingReference.getOriginalItemLocationQuantity());
	}

	@Override
	public void setOriginalItemLocationQuantity(ItemLocationQuantityModel value) {
		this.pricingReference.setOriginalItemLocationQuantity(ItemLocationQuantityAdapter.toEntity(value, em));
	}

	@Override
	public List<PriceModel> getAlternativeConditionPrice() {
		return pricingReference.getAlternativeConditionPrice().stream().map(f -> new PriceAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	@Override
	public void setAlternativeConditionPrice(List<PriceModel> alternativeConditionPrice) {
		List<PriceEntity> entities = alternativeConditionPrice.stream().map(f -> PriceAdapter.toEntity(f, em))
				.collect(Collectors.toList());
		this.pricingReference.setAlternativeConditionPrice(entities);
	}

	@Override
	public String getId() {
		return this.pricingReference.getId();
	}

	@Override
	public void setId(String value) {
		this.pricingReference.setId(value);
	}

	@Override
	public PricingReferenceEntity getEntity() {
		return pricingReference;
	}

	@Override
	public PriceModel addAlternativeConditionPrice() {
		List<PriceEntity> priceEntities = pricingReference.getAlternativeConditionPrice();
		PriceEntity priceEntity = new PriceEntity();
		priceEntities.add(priceEntity);
		return new PriceAdapter(session, em, priceEntity);
	}

    public static PricingReferenceEntity toEntity(PricingReferenceModel model, EntityManager em) {
        if (model instanceof PricingReferenceAdapter) {
            return ((PricingReferenceAdapter) model).getEntity();
        }
        return em.getReference(PricingReferenceEntity.class, model.getId());
    }

}
