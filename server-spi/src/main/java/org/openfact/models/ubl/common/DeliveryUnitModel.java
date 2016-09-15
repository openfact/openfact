package org.openfact.models.ubl.common;

public interface DeliveryUnitModel {

    BatchQuantityModel getBatchQuantity();

    void setBatchQuantity(BatchQuantityModel value);

    ConsumerUnitQuantityModel getConsumerUnitQuantity();

    void setConsumerUnitQuantity(ConsumerUnitQuantityModel value);

    boolean getHazardousRiskIndicator();

    void setHazardousRiskIndicator(boolean value);

    String getId();

    void setId(String value);

}
