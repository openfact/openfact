package org.openfact.representations.idm.ubl.common;

public class DeliveryUnitRepresentation {
    private QuantityRepresentation batchQuantity;
    private QuantityRepresentation consumerUnitQuantity;
    private Boolean hazardousRiskIndicator;
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

    public Boolean getHazardousRiskIndicator() {
        return this.hazardousRiskIndicator;
    }

    public void setHazardousRiskIndicator(Boolean hazardousRiskIndicator) {
        this.hazardousRiskIndicator = hazardousRiskIndicator;
    }

    public QuantityRepresentation getBatchQuantity() {
        return this.batchQuantity;
    }

    public void setBatchQuantity(QuantityRepresentation batchQuantity) {
        this.batchQuantity = batchQuantity;
    }
}