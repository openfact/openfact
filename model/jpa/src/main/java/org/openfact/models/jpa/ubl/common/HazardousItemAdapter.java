package org.openfact.models.jpa.ubl.common;

import java.util.List;

import javax.persistence.EntityManager;

import org.openfact.models.OpenfactSession;
import org.jboss.logging.Logger;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.ubl.common.HazardousGoodsTransitModel;
import org.openfact.models.ubl.common.HazardousItemModel;
import org.openfact.models.ubl.common.MeasureModel;
import org.openfact.models.ubl.common.PartyModel;
import org.openfact.models.ubl.common.QuantityModel;
import org.openfact.models.ubl.common.SecondaryHazardModel;
import org.openfact.models.ubl.common.TemperatureModel;

public class HazardousItemAdapter implements HazardousItemModel, JpaModel<HazardousItemEntity> {

    protected static final Logger logger = Logger.getLogger(HazardousItemAdapter.class);
    protected HazardousItemEntity hazardousItem;
    protected EntityManager em;
    protected OpenfactSession session;

    public HazardousItemAdapter(OpenfactSession session, EntityManager em,
            HazardousItemEntity hazardousItem) {
        this.session = session;
        this.em = em;
        this.hazardousItem = hazardousItem;
    }

    @Override
    public String getID() {
        return this.hazardousItem.getID();
    }

    @Override
    public void setID(String value) {
        this.hazardousItem.setID(value);
    }

    @Override
    public String getPlacardNotation() {
        return this.hazardousItem.getPlacardNotation();
    }

    @Override
    public void setPlacardNotation(String value) {
        this.hazardousItem.setPlacardNotation(value);
    }

    @Override
    public String getPlacardEndorsement() {
        return this.hazardousItem.getPlacardEndorsement();
    }

    @Override
    public void setPlacardEndorsement(String value) {
        this.hazardousItem.setPlacardEndorsement(value);
    }

    @Override
    public String getAdditionalInformation() {
        return this.hazardousItem.getAdditionalInformation();
    }

    @Override
    public void setAdditionalInformation(String value) {
        this.hazardousItem.setAdditionalInformation(value);
    }

    @Override
    public String getUNDGCode() {
        return this.hazardousItem.getUNDGCode();
    }

    @Override
    public void setUNDGCode(String value) {
        this.hazardousItem.setUNDGCode(value);
    }

    @Override
    public String getEmergencyProceduresCode() {
        return this.hazardousItem.getEmergencyProceduresCode();
    }

    @Override
    public void setEmergencyProceduresCode(String value) {
        this.hazardousItem.setEmergencyProceduresCode(value);
    }

    @Override
    public String getMedicalFirstAidGuideCode() {
        return this.hazardousItem.getMedicalFirstAidGuideCode();
    }

    @Override
    public void setMedicalFirstAidGuideCode(String value) {
        this.hazardousItem.setMedicalFirstAidGuideCode(value);
    }

    @Override
    public String getTechnicalName() {
        return this.hazardousItem.getTechnicalName();
    }

    @Override
    public void setTechnicalName(String value) {
        this.hazardousItem.setTechnicalName(value);
    }

    @Override
    public String getCategoryName() {
        return this.hazardousItem.getCategoryName();
    }

    @Override
    public void setCategoryName(String value) {
        this.hazardousItem.setCategoryName(value);
    }

    @Override
    public String getHazardousCategoryCode() {
        return this.hazardousItem.getHazardousCategoryCode();
    }

    @Override
    public void setHazardousCategoryCode(String value) {
        this.hazardousItem.setHazardousCategoryCode(value);
    }

    @Override
    public String getUpperOrangeHazardPlacardID() {
        return this.hazardousItem.getUpperOrangeHazardPlacardID();
    }

    @Override
    public void setUpperOrangeHazardPlacardID(String value) {
        this.hazardousItem.setUpperOrangeHazardPlacardID(value);
    }

    @Override
    public String getLowerOrangeHazardPlacardID() {
        return this.hazardousItem.getLowerOrangeHazardPlacardID();
    }

    @Override
    public void setLowerOrangeHazardPlacardID(String value) {
        this.hazardousItem.setLowerOrangeHazardPlacardID(value);
    }

    @Override
    public String getMarkingID() {
        return this.hazardousItem.getMarkingID();
    }

    @Override
    public void setMarkingID(String value) {
        this.hazardousItem.setMarkingID(value);
    }

    @Override
    public String getHazardClassID() {
        return this.hazardousItem.getHazardClassID();
    }

    @Override
    public void setHazardClassID(String value) {
        this.hazardousItem.setHazardClassID(value);
    }

    @Override
    public MeasureModel getNetWeightMeasure() {
        return this.hazardousItem.getNetWeightMeasure();
    }

    @Override
    public void setNetWeightMeasure(MeasureAdapter value) {
        this.hazardousItem.setNetWeightMeasure(value);
    }

    @Override
    public MeasureModel getNetVolumeMeasure() {
        return this.hazardousItem.getNetVolumeMeasure();
    }

    @Override
    public void setNetVolumeMeasure(MeasureAdapter value) {
        this.hazardousItem.setNetVolumeMeasure(value);
    }

    @Override
    public QuantityModel getQuantity() {
        return this.hazardousItem.getQuantity();
    }

    @Override
    public void setQuantity(QuantityAdapter value) {
        this.hazardousItem.setQuantity(value);
    }

    @Override
    public PartyModel getContactParty() {
        return this.hazardousItem.getContactParty();
    }

    @Override
    public void setContactParty(PartyAdapter value) {
        this.hazardousItem.setContactParty(value);
    }

    @Override
    public List<SecondaryHazardModel> getSecondaryHazard() {
        return this.hazardousItem.getSecondaryHazard();
    }

    @Override
    public void setSecondaryHazard(List<SecondaryHazardAdapter> secondaryHazard) {
        this.hazardousItem.setSecondaryHazard(secondaryHazard);
    }

    @Override
    public List<HazardousGoodsTransitModel> getHazardousGoodsTransit() {
        return this.hazardousItem.getHazardousGoodsTransit();
    }

    @Override
    public void setHazardousGoodsTransit(List<HazardousGoodsTransitAdapter> hazardousGoodsTransit) {
        this.hazardousItem.setHazardousGoodsTransit(hazardousGoodsTransit);
    }

    @Override
    public TemperatureModel getEmergencyTemperature() {
        return this.hazardousItem.getEmergencyTemperature();
    }

    @Override
    public void setEmergencyTemperature(TemperatureAdapter value) {
        this.hazardousItem.setEmergencyTemperature(value);
    }

    @Override
    public TemperatureModel getFlashpointTemperature() {
        return this.hazardousItem.getFlashpointTemperature();
    }

    @Override
    public void setFlashpointTemperature(TemperatureAdapter value) {
        this.hazardousItem.setFlashpointTemperature(value);
    }

    @Override
    public List<TemperatureModel> getAdditionalTemperature() {
        return this.hazardousItem.getAdditionalTemperature();
    }

    @Override
    public void setAdditionalTemperature(List<TemperatureAdapter> additionalTemperature) {
        this.hazardousItem.setAdditionalTemperature(additionalTemperature);
    }

    @Override
    public String getId() {
        return this.hazardousItem.getId();
    }

    @Override
    public void setId(String value) {
        this.hazardousItem.setId(value);
    }

}
