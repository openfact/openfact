package org.openfact.models.jpa.ubl.common;

import javax.persistence.EntityManager;

import org.openfact.models.OpenfactSession;
import org.jboss.logging.Logger;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.ubl.common.HazardousGoodsTransitModel;
import org.openfact.models.ubl.common.TemperatureModel;

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

    @Override
    public String getTransportEmergencyCardCode() {
        return this.hazardousGoodsTransit.getTransportEmergencyCardCode();
    }

    @Override
    public void setTransportEmergencyCardCode(String value) {
        this.hazardousGoodsTransit.setTransportEmergencyCardCode(value);
    }

    @Override
    public String getPackingCriteriaCode() {
        return this.hazardousGoodsTransit.getPackingCriteriaCode();
    }

    @Override
    public void setPackingCriteriaCode(String value) {
        this.hazardousGoodsTransit.setPackingCriteriaCode(value);
    }

    @Override
    public String getHazardousRegulationCode() {
        return this.hazardousGoodsTransit.getHazardousRegulationCode();
    }

    @Override
    public void setHazardousRegulationCode(String value) {
        this.hazardousGoodsTransit.setHazardousRegulationCode(value);
    }

    @Override
    public String getInhalationToxicityZoneCode() {
        return this.hazardousGoodsTransit.getInhalationToxicityZoneCode();
    }

    @Override
    public void setInhalationToxicityZoneCode(String value) {
        this.hazardousGoodsTransit.setInhalationToxicityZoneCode(value);
    }

    @Override
    public String getTransportAuthorizationCode() {
        return this.hazardousGoodsTransit.getTransportAuthorizationCode();
    }

    @Override
    public void setTransportAuthorizationCode(String value) {
        this.hazardousGoodsTransit.setTransportAuthorizationCode(value);
    }

    @Override
    public TemperatureModel getMaximumTemperature() {
        return this.hazardousGoodsTransit.getMaximumTemperature();
    }

    @Override
    public void setMaximumTemperature(TemperatureAdapter value) {
        this.hazardousGoodsTransit.setMaximumTemperature(value);
    }

    @Override
    public TemperatureModel getMinimumTemperature() {
        return this.hazardousGoodsTransit.getMinimumTemperature();
    }

    @Override
    public void setMinimumTemperature(TemperatureAdapter value) {
        this.hazardousGoodsTransit.setMinimumTemperature(value);
    }

    @Override
    public String getId() {
        return this.hazardousGoodsTransit.getId();
    }

    @Override
    public void setId(String value) {
        this.hazardousGoodsTransit.setId(value);
    }

}
