package org.openfact.models.ubl.common;

public interface HazardousGoodsTransitModel {

    TransportEmergencyCardCodeModel getTransportEmergencyCardCode();

    void setTransportEmergencyCardCode(TransportEmergencyCardCodeModel value);

    PackingCriteriaCodeModel getPackingCriteriaCode();

    void setPackingCriteriaCode(PackingCriteriaCodeModel value);

    HazardousRegulationCodeModel getHazardousRegulationCode();

    void setHazardousRegulationCode(HazardousRegulationCodeModel value);

    InhalationToxicityZoneCodeModel getInhalationToxicityZoneCode();

    void setInhalationToxicityZoneCode(InhalationToxicityZoneCodeModel value);

    TransportAuthorizationCodeModel getTransportAuthorizationCode();

    void setTransportAuthorizationCode(TransportAuthorizationCodeModel value);

    TemperatureModel getMaximumTemperature();

    void setMaximumTemperature(TemperatureModel value);

    TemperatureModel getMinimumTemperature();

    void setMinimumTemperature(TemperatureModel value);

    String getId();

    void setId(String value);

}
