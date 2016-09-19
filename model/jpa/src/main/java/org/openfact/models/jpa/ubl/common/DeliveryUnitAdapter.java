package org.openfact.models.jpa.ubl.common;

public class DeliveryUnitAdapter implements DeliveryUnitModel, JpaModel<DeliveryUnitEntity> {

    protected static final Logger logger = Logger.getLogger(DeliveryUnitAdapter.class);
    protected DeliveryUnitEntity deliveryUnit;
    protected EntityManager em;
    protected OpenfactSession session;

    public DeliveryUnitAdapter(OpenfactSession session, EntityManager em, DeliveryUnitEntity deliveryUnit) {
        this.session = session;
        this.em = em;
        this.deliveryUnit = deliveryUnit;
    }

    QuantityAdapter getBatchQuantity() {
        return this.deliveryUnit.getBatchQuantity();
    }

    void setBatchQuantity(QuantityAdapter value) {
        this.deliveryUnit.setBatchQuantity(value);
    }

    QuantityAdapter getConsumerUnitQuantity() {
        return this.deliveryUnit.getConsumerUnitQuantity();
    }

    void setConsumerUnitQuantity(QuantityAdapter value) {
        this.deliveryUnit.setConsumerUnitQuantity(value);
    }

    boolean getHazardousRiskIndicator() {
        return this.deliveryUnit.getHazardousRiskIndicator();
    }

    void setHazardousRiskIndicator(boolean value) {
        this.deliveryUnit.setHazardousRiskIndicator(value);
    }

    String getId() {
        return this.deliveryUnit.getId();
    }

    void setId(String value) {
        this.deliveryUnit.setId(value);
    }

}
