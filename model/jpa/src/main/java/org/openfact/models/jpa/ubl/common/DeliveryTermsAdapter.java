package org.openfact.models.jpa.ubl.common;

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

    String getID() {
        return this.deliveryTerms.getID();
    }

    void setID(String value) {
        this.deliveryTerms.setID(value);
    }

    String getSpecialTerms() {
        return this.deliveryTerms.getSpecialTerms();
    }

    void setSpecialTerms(String value) {
        this.deliveryTerms.setSpecialTerms(value);
    }

    String getLossRiskResponsibilityCode() {
        return this.deliveryTerms.getLossRiskResponsibilityCode();
    }

    void setLossRiskResponsibilityCode(String value) {
        this.deliveryTerms.setLossRiskResponsibilityCode(value);
    }

    String getLossRisk() {
        return this.deliveryTerms.getLossRisk();
    }

    void setLossRisk(String value) {
        this.deliveryTerms.setLossRisk(value);
    }

    LocationAdapterCommAgg getDeliveryLocation() {
        return this.deliveryTerms.getDeliveryLocation();
    }

    void setDeliveryLocation(LocationAdapterCommAgg value) {
        this.deliveryTerms.setDeliveryLocation(value);
    }

    AllowanceChargeAdapter getAllowanceCharge() {
        return this.deliveryTerms.getAllowanceCharge();
    }

    void setAllowanceCharge(AllowanceChargeAdapter value) {
        this.deliveryTerms.setAllowanceCharge(value);
    }

    String getId() {
        return this.deliveryTerms.getId();
    }

    void setId(String value) {
        this.deliveryTerms.setId(value);
    }

}
