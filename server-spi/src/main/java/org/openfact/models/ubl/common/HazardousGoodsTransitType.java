package org.openfact.models.ubl.common;

public interface HazardousGoodsTransitType {

    TransportEmergencyCardCodeType getTransportEmergencyCardCode();

    void setTransportEmergencyCardCode(TransportEmergencyCardCodeType value);

    PackingCriteriaCodeType getPackingCriteriaCode();

    void setPackingCriteriaCode(PackingCriteriaCodeType value);

    HazardousRegulationCodeType getHazardousRegulationCode();

    void setHazardousRegulationCode(HazardousRegulationCodeType value);

    InhalationToxicityZoneCodeType getInhalationToxicityZoneCode();

    void setInhalationToxicityZoneCode(InhalationToxicityZoneCodeType value);

    TransportAuthorizationCodeType getTransportAuthorizationCode();

    void setTransportAuthorizationCode(TransportAuthorizationCodeType value);

    TemperatureType getMaximumTemperature();

    void setMaximumTemperature(TemperatureType value);

    TemperatureType getMinimumTemperature();

    void setMinimumTemperature(TemperatureType value);

    String getId();

    void setId(String value);

}
