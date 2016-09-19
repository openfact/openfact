package org.openfact.models.jpa.ubl.common;

import java.util.List;

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

    String getID() {
        return this.hazardousItem.getID();
    }

    void setID(String value) {
        this.hazardousItem.setID(value);
    }

    String getPlacardNotation() {
        return this.hazardousItem.getPlacardNotation();
    }

    void setPlacardNotation(String value) {
        this.hazardousItem.setPlacardNotation(value);
    }

    String getPlacardEndorsement() {
        return this.hazardousItem.getPlacardEndorsement();
    }

    void setPlacardEndorsement(String value) {
        this.hazardousItem.setPlacardEndorsement(value);
    }

    String getAdditionalInformation() {
        return this.hazardousItem.getAdditionalInformation();
    }

    void setAdditionalInformation(String value) {
        this.hazardousItem.setAdditionalInformation(value);
    }

    String getUNDGCode() {
        return this.hazardousItem.getUNDGCode();
    }

    void setUNDGCode(String value) {
        this.hazardousItem.setUNDGCode(value);
    }

    String getEmergencyProceduresCode() {
        return this.hazardousItem.getEmergencyProceduresCode();
    }

    void setEmergencyProceduresCode(String value) {
        this.hazardousItem.setEmergencyProceduresCode(value);
    }

    String getMedicalFirstAidGuideCode() {
        return this.hazardousItem.getMedicalFirstAidGuideCode();
    }

    void setMedicalFirstAidGuideCode(String value) {
        this.hazardousItem.setMedicalFirstAidGuideCode(value);
    }

    String getTechnicalName() {
        return this.hazardousItem.getTechnicalName();
    }

    void setTechnicalName(String value) {
        this.hazardousItem.setTechnicalName(value);
    }

    String getCategoryName() {
        return this.hazardousItem.getCategoryName();
    }

    void setCategoryName(String value) {
        this.hazardousItem.setCategoryName(value);
    }

    String getHazardousCategoryCode() {
        return this.hazardousItem.getHazardousCategoryCode();
    }

    void setHazardousCategoryCode(String value) {
        this.hazardousItem.setHazardousCategoryCode(value);
    }

    String getUpperOrangeHazardPlacardID() {
        return this.hazardousItem.getUpperOrangeHazardPlacardID();
    }

    void setUpperOrangeHazardPlacardID(String value) {
        this.hazardousItem.setUpperOrangeHazardPlacardID(value);
    }

    String getLowerOrangeHazardPlacardID() {
        return this.hazardousItem.getLowerOrangeHazardPlacardID();
    }

    void setLowerOrangeHazardPlacardID(String value) {
        this.hazardousItem.setLowerOrangeHazardPlacardID(value);
    }

    String getMarkingID() {
        return this.hazardousItem.getMarkingID();
    }

    void setMarkingID(String value) {
        this.hazardousItem.setMarkingID(value);
    }

    String getHazardClassID() {
        return this.hazardousItem.getHazardClassID();
    }

    void setHazardClassID(String value) {
        this.hazardousItem.setHazardClassID(value);
    }

    MeasureAdapter getNetWeightMeasure() {
        return this.hazardousItem.getNetWeightMeasure();
    }

    void setNetWeightMeasure(MeasureAdapter value) {
        this.hazardousItem.setNetWeightMeasure(value);
    }

    MeasureAdapter getNetVolumeMeasure() {
        return this.hazardousItem.getNetVolumeMeasure();
    }

    void setNetVolumeMeasure(MeasureAdapter value) {
        this.hazardousItem.setNetVolumeMeasure(value);
    }

    QuantityAdapter getQuantity() {
        return this.hazardousItem.getQuantity();
    }

    void setQuantity(QuantityAdapter value) {
        this.hazardousItem.setQuantity(value);
    }

    PartyAdapter getContactParty() {
        return this.hazardousItem.getContactParty();
    }

    void setContactParty(PartyAdapter value) {
        this.hazardousItem.setContactParty(value);
    }

    List<SecondaryHazardAdapter> getSecondaryHazard() {
        return this.hazardousItem.getSecondaryHazard();
    }

    void setSecondaryHazard(List<SecondaryHazardAdapter> secondaryHazard) {
        this.hazardousItem.setSecondaryHazard(secondaryHazard);
    }

    List<HazardousGoodsTransitAdapter> getHazardousGoodsTransit() {
        return this.hazardousItem.getHazardousGoodsTransit();
    }

    void setHazardousGoodsTransit(List<HazardousGoodsTransitAdapter> hazardousGoodsTransit) {
        this.hazardousItem.setHazardousGoodsTransit(hazardousGoodsTransit);
    }

    TemperatureAdapter getEmergencyTemperature() {
        return this.hazardousItem.getEmergencyTemperature();
    }

    void setEmergencyTemperature(TemperatureAdapter value) {
        this.hazardousItem.setEmergencyTemperature(value);
    }

    TemperatureAdapter getFlashpointTemperature() {
        return this.hazardousItem.getFlashpointTemperature();
    }

    void setFlashpointTemperature(TemperatureAdapter value) {
        this.hazardousItem.setFlashpointTemperature(value);
    }

    List<TemperatureAdapter> getAdditionalTemperature() {
        return this.hazardousItem.getAdditionalTemperature();
    }

    void setAdditionalTemperature(List<TemperatureAdapter> additionalTemperature) {
        this.hazardousItem.setAdditionalTemperature(additionalTemperature);
    }

    String getId() {
        return this.hazardousItem.getId();
    }

    void setId(String value) {
        this.hazardousItem.setId(value);
    }

}
