package org.openfact.representations.idm.ubl.common;

public interface DeliveryUnitModel {

    QuantityModel getBatchQuantity();

    void setBatchQuantity(QuantityModel value);

    QuantityModel getConsumerUnitQuantity();

    void setConsumerUnitQuantity(QuantityModel value);

    boolean getHazardousRiskIndicator();

    void setHazardousRiskIndicator(boolean value);

    String getId();

    void setId(String value);

}
