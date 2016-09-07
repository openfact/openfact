package org.openfact.models.jpa.entities.ubl;

/**
 * A class to describe hazardous goods in transit.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:27 a. m.
 */
public class HazardousGoodsTransit {

    /**
     * A code signifying the set of legal regulations governing the
     * transportation of the hazardous goods.
     */
    private String hazardousRegulationCode;
    /**
     * A code signifying the Inhalation Toxicity Hazard Zone for the hazardous
     * goods, as defined by the US Department of Transportation.
     */
    private String inhalationToxicityZoneCode;
    /**
     * A code signifying the packaging requirement for transportation of the
     * hazardous goods as assigned by IATA, IMDB, ADR, RID etc.
     */
    private String packingCriteriaCode;
    /**
     * A code signifying authorization for the transportation of hazardous
     * cargo.
     */
    private String transportAuthorizationCode;
    /**
     * An identifier for a transport emergency card describing the actions to be
     * taken in an emergency in transporting the hazardous goods. It may be the
     * identity number of a hazardous emergency response plan assigned by the
     * appropriate authority.
     */
    private String transportEmergencyCardCode;
    private Temperature minimumTemperature;
    private Temperature maximumTemperature;

    public String getHazardousRegulationCode() {
        return hazardousRegulationCode;
    }

    public void setHazardousRegulationCode(String hazardousRegulationCode) {
        this.hazardousRegulationCode = hazardousRegulationCode;
    }

    public String getInhalationToxicityZoneCode() {
        return inhalationToxicityZoneCode;
    }

    public void setInhalationToxicityZoneCode(String inhalationToxicityZoneCode) {
        this.inhalationToxicityZoneCode = inhalationToxicityZoneCode;
    }

    public String getPackingCriteriaCode() {
        return packingCriteriaCode;
    }

    public void setPackingCriteriaCode(String packingCriteriaCode) {
        this.packingCriteriaCode = packingCriteriaCode;
    }

    public String getTransportAuthorizationCode() {
        return transportAuthorizationCode;
    }

    public void setTransportAuthorizationCode(String transportAuthorizationCode) {
        this.transportAuthorizationCode = transportAuthorizationCode;
    }

    public String getTransportEmergencyCardCode() {
        return transportEmergencyCardCode;
    }

    public void setTransportEmergencyCardCode(String transportEmergencyCardCode) {
        this.transportEmergencyCardCode = transportEmergencyCardCode;
    }

    public Temperature getMinimumTemperature() {
        return minimumTemperature;
    }

    public void setMinimumTemperature(Temperature minimumTemperature) {
        this.minimumTemperature = minimumTemperature;
    }

    public Temperature getMaximumTemperature() {
        return maximumTemperature;
    }

    public void setMaximumTemperature(Temperature maximumTemperature) {
        this.maximumTemperature = maximumTemperature;
    }
}// end Hazardous Goods Transit