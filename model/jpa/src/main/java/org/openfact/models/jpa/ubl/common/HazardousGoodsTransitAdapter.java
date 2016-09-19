package org.openfact.models.jpa.ubl.common;

public class HazardousGoodsTransitAdapter
        implements HazardousGoodsTransitModel, JpaModel<HazardousGoodsTransitEntity> {

    protected static final Logger logger = Logger.getLogger(HazardousGoodsTransitAdapter.class);
    protected HazardousGoodsTransitEntity hazardousGoodsTransit;
    protected EntityManager em;
    protected OpenfactSession session;

    public HazardousGoodsTransitAdapter(OpenfactSession session, EntityManager em,
            HazardousGoodsTransitEntity hazardousGoodsTransit) {
        this.session = session;
        this.em = em;
        this.hazardousGoodsTransit = hazardousGoodsTransit;
    }

    String getTransportEmergencyCardCode() {
        return this.hazardousGoodsTransit.getTransportEmergencyCardCode();
    }

    void setTransportEmergencyCardCode(String value) {
        this.hazardousGoodsTransit.setTransportEmergencyCardCode(value);
    }

    String getPackingCriteriaCode() {
        return this.hazardousGoodsTransit.getPackingCriteriaCode();
    }

    void setPackingCriteriaCode(String value) {
        this.hazardousGoodsTransit.setPackingCriteriaCode(value);
    }

    String getHazardousRegulationCode() {
        return this.hazardousGoodsTransit.getHazardousRegulationCode();
    }

    void setHazardousRegulationCode(String value) {
        this.hazardousGoodsTransit.setHazardousRegulationCode(value);
    }

    String getInhalationToxicityZoneCode() {
        return this.hazardousGoodsTransit.getInhalationToxicityZoneCode();
    }

    void setInhalationToxicityZoneCode(String value) {
        this.hazardousGoodsTransit.setInhalationToxicityZoneCode(value);
    }

    String getTransportAuthorizationCode() {
        return this.hazardousGoodsTransit.getTransportAuthorizationCode();
    }

    void setTransportAuthorizationCode(String value) {
        this.hazardousGoodsTransit.setTransportAuthorizationCode(value);
    }

    TemperatureAdapter getMaximumTemperature() {
        return this.hazardousGoodsTransit.getMaximumTemperature();
    }

    void setMaximumTemperature(TemperatureAdapter value) {
        this.hazardousGoodsTransit.setMaximumTemperature(value);
    }

    TemperatureAdapter getMinimumTemperature() {
        return this.hazardousGoodsTransit.getMinimumTemperature();
    }

    void setMinimumTemperature(TemperatureAdapter value) {
        this.hazardousGoodsTransit.setMinimumTemperature(value);
    }

    String getId() {
        return this.hazardousGoodsTransit.getId();
    }

    void setId(String value) {
        this.hazardousGoodsTransit.setId(value);
    }

}
