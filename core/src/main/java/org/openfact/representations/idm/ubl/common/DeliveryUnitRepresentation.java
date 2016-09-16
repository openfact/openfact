package org.openfact.representations.idm.ubl.common;

public class DeliveryUnitRepresentation {
    private QuantityRepresentation batchQuantity;
    private QuantityRepresentation consumerUnitQuantity;
    private boolean hazardousRiskIndicator;
    private String id;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public QuantityRepresentation getConsumerUnitQuantity() {
        return this.consumerUnitQuantity;
    }

    public void setConsumerUnitQuantity(QuantityRepresentation consumerUnitQuantity) {
        this.consumerUnitQuantity = consumerUnitQuantity;
    }

    public boolean getHazardousRiskIndicator() {
        return this.hazardousRiskIndicator;
    }

    public void setHazardousRiskIndicator(boolean hazardousRiskIndicator) {
        this.hazardousRiskIndicator = hazardousRiskIndicator;
    }

    public QuantityRepresentation getBatchQuantity() {
        return this.batchQuantity;
    }

    public void setBatchQuantity(QuantityRepresentation batchQuantity) {
        this.batchQuantity = batchQuantity;
    }
}