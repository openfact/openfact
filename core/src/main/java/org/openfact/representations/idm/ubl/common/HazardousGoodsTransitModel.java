package org.openfact.representations.idm.ubl.common;

public interface HazardousGoodsTransitModel {

    String getTransportEmergencyCardCode();

    void setTransportEmergencyCardCode(String value);

    String getPackingCriteriaCode();

    void setPackingCriteriaCode(String value);

    String getHazardousRegulationCode();

    void setHazardousRegulationCode(String value);

    String getInhalationToxicityZoneCode();

    void setInhalationToxicityZoneCode(String value);

    String getTransportAuthorizationCode();

    void setTransportAuthorizationCode(String value);

    TemperatureModel getMaximumTemperature();

    void setMaximumTemperature(TemperatureModel value);

    TemperatureModel getMinimumTemperature();

    void setMinimumTemperature(TemperatureModel value);

    String getId();

    void setId(String value);

}
