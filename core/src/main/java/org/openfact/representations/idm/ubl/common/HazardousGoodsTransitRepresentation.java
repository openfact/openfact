package org.openfact.representations.idm.ubl.common;

public class HazardousGoodsTransitRepresentation {
    private String transportEmergencyCardCode;
    private String packingCriteriaCode;
    private String hazardousRegulationCode;
    private String inhalationToxicityZoneCode;
    private String transportAuthorizationCode;
    private TemperatureRepresentation maximumTemperature;
    private TemperatureRepresentation minimumTemperature;
    private String id;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TemperatureRepresentation getMaximumTemperature() {
        return this.maximumTemperature;
    }

    public void setMaximumTemperature(TemperatureRepresentation maximumTemperature) {
        this.maximumTemperature = maximumTemperature;
    }

    public String getHazardousRegulationCode() {
        return this.hazardousRegulationCode;
    }

    public void setHazardousRegulationCode(String hazardousRegulationCode) {
        this.hazardousRegulationCode = hazardousRegulationCode;
    }

    public TemperatureRepresentation getMinimumTemperature() {
        return this.minimumTemperature;
    }

    public void setMinimumTemperature(TemperatureRepresentation minimumTemperature) {
        this.minimumTemperature = minimumTemperature;
    }

    public String getInhalationToxicityZoneCode() {
        return this.inhalationToxicityZoneCode;
    }

    public void setInhalationToxicityZoneCode(String inhalationToxicityZoneCode) {
        this.inhalationToxicityZoneCode = inhalationToxicityZoneCode;
    }

    public String getTransportEmergencyCardCode() {
        return this.transportEmergencyCardCode;
    }

    public void setTransportEmergencyCardCode(String transportEmergencyCardCode) {
        this.transportEmergencyCardCode = transportEmergencyCardCode;
    }

    public String getPackingCriteriaCode() {
        return this.packingCriteriaCode;
    }

    public void setPackingCriteriaCode(String packingCriteriaCode) {
        this.packingCriteriaCode = packingCriteriaCode;
    }

    public String getTransportAuthorizationCode() {
        return this.transportAuthorizationCode;
    }

    public void setTransportAuthorizationCode(String transportAuthorizationCode) {
        this.transportAuthorizationCode = transportAuthorizationCode;
    }
}