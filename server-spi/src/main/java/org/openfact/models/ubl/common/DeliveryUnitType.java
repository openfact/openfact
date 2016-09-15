package org.openfact.models.ubl.common;

public interface DeliveryUnitType {

    BatchQuantityType getBatchQuantity();

    void setBatchQuantity(BatchQuantityType value);

    ConsumerUnitQuantityType getConsumerUnitQuantity();

    void setConsumerUnitQuantity(ConsumerUnitQuantityType value);

    HazardousRiskIndicatorType getHazardousRiskIndicator();

    void setHazardousRiskIndicator(HazardousRiskIndicatorType value);

    String getId();

    void setId(String value);

}
