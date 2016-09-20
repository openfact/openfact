package org.openfact.models.jpa.ubl.common;

import javax.persistence.EntityManager;

import org.openfact.models.OpenfactSession;
import org.jboss.logging.Logger;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.AllowanceChargeEntity;
import org.openfact.models.jpa.entities.ubl.common.DeliveryTermsEntity;
import org.openfact.models.ubl.common.AllowanceChargeModel;
import org.openfact.models.ubl.common.DeliveryTermsModel;
import org.openfact.models.ubl.common.LocationCommAggModel;

public class DeliveryTermsAdapter implements DeliveryTermsModel, JpaModel<DeliveryTermsEntity> {

    protected static final Logger logger = Logger.getLogger(DeliveryTermsAdapter.class);
    protected DeliveryTermsEntity deliveryTerms;
    protected EntityManager em;
    protected OpenfactSession session;

    public DeliveryTermsAdapter(OpenfactSession session, EntityManager em,
            DeliveryTermsEntity deliveryTerms) {
        this.session = session;
        this.em = em;
        this.deliveryTerms = deliveryTerms;
    }

    @Override
    public String getID() {
        return this.deliveryTerms.getID();
    }

    @Override
    public void setID(String value) {
        this.deliveryTerms.setID(value);
    }

    @Override
    public String getSpecialTerms() {
        return this.deliveryTerms.getSpecialTerms();
    }

    @Override
    public void setSpecialTerms(String value) {
        this.deliveryTerms.setSpecialTerms(value);
    }

    @Override
    public String getLossRiskResponsibilityCode() {
        return this.deliveryTerms.getLossRiskResponsibilityCode();
    }

    @Override
    public void setLossRiskResponsibilityCode(String value) {
        this.deliveryTerms.setLossRiskResponsibilityCode(value);
    }

    @Override
    public String getLossRisk() {
        return this.deliveryTerms.getLossRisk();
    }

    @Override
    public void setLossRisk(String value) {
        this.deliveryTerms.setLossRisk(value);
    }

    @Override
    public LocationCommAggModel getDeliveryLocation() {
        return new LocationCommAggAdapter(session, em, this.deliveryTerms.getDeliveryLocation());
    }

    @Override
    public void setDeliveryLocation(LocationCommAggModel value) {
        this.deliveryTerms.setDeliveryLocation(LocationCommAggAdapter.toEntity(value, em));
    }

    @Override
    public AllowanceChargeModel getAllowanceCharge() {
        return new AllowanceChargeAdapter(session, em, this.deliveryTerms.getAllowanceCharge());
    }

    @Override
    public void setAllowanceCharge(AllowanceChargeModel value) {
        this.deliveryTerms.setAllowanceCharge(AllowanceChargeAdapter.toEntity(value, em));
    }

    @Override
    public String getId() {
        return this.deliveryTerms.getId();
    }

    @Override
    public void setId(String value) {
        this.deliveryTerms.setId(value);
    }

    @Override
    public DeliveryTermsEntity getEntity() {
        return this.deliveryTerms;
    }

	public static DeliveryTermsEntity toEntity(DeliveryTermsModel model, EntityManager em) {
		if (model instanceof DeliveryTermsAdapter) {
			return ((DeliveryTermsAdapter) model).getEntity();
		}
		return em.getReference(DeliveryTermsEntity.class, model.getId());
	}

}
