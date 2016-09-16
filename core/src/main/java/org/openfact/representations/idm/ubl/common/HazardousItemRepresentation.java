package org.openfact.representations.idm.ubl.common;

import java.util.List;

public class HazardousItemRepresentation {
    private String ID;
    private String placardNotation;
    private String placardEndorsement;
    private String additionalInformation;
    private String UNDGCode;
    private String emergencyProceduresCode;
    private String medicalFirstAidGuideCode;
    private String technicalName;
    private String categoryName;
    private String hazardousCategoryCode;
    private String upperOrangeHazardPlacardID;
    private String lowerOrangeHazardPlacardID;
    private String markingID;
    private String hazardClassID;
    private MeasureRepresentation netWeightMeasure;
    private MeasureRepresentation netVolumeMeasure;
    private QuantityRepresentation quantity;
    private PartyRepresentation contactParty;
    private List<SecondaryHazardRepresentation> secondaryHazard;
    private List<HazardousGoodsTransitRepresentation> hazardousGoodsTransit;
    private TemperatureRepresentation emergencyTemperature;
    private TemperatureRepresentation flashpointTemperature;
    private List<TemperatureRepresentation> additionalTemperature;
    private String id;

    public String getID() {
        return this.ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHazardousCategoryCode() {
        return this.hazardousCategoryCode;
    }

    public void setHazardousCategoryCode(String hazardousCategoryCode) {
        this.hazardousCategoryCode = hazardousCategoryCode;
    }

    public String getHazardClassID() {
        return this.hazardClassID;
    }

    public void setHazardClassID(String hazardClassID) {
        this.hazardClassID = hazardClassID;
    }

    public TemperatureRepresentation getFlashpointTemperature() {
        return this.flashpointTemperature;
    }

    public void setFlashpointTemperature(TemperatureRepresentation flashpointTemperature) {
        this.flashpointTemperature = flashpointTemperature;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<SecondaryHazardRepresentation> getSecondaryHazard() {
        return this.secondaryHazard;
    }

    public void setSecondaryHazard(List<SecondaryHazardRepresentation> secondaryHazard) {
        this.secondaryHazard = secondaryHazard;
    }

    public String getAdditionalInformation() {
        return this.additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public MeasureRepresentation getNetVolumeMeasure() {
        return this.netVolumeMeasure;
    }

    public void setNetVolumeMeasure(MeasureRepresentation netVolumeMeasure) {
        this.netVolumeMeasure = netVolumeMeasure;
    }

    public String getPlacardEndorsement() {
        return this.placardEndorsement;
    }

    public void setPlacardEndorsement(String placardEndorsement) {
        this.placardEndorsement = placardEndorsement;
    }

    public String getTechnicalName() {
        return this.technicalName;
    }

    public void setTechnicalName(String technicalName) {
        this.technicalName = technicalName;
    }

    public String getPlacardNotation() {
        return this.placardNotation;
    }

    public void setPlacardNotation(String placardNotation) {
        this.placardNotation = placardNotation;
    }

    public MeasureRepresentation getNetWeightMeasure() {
        return this.netWeightMeasure;
    }

    public void setNetWeightMeasure(MeasureRepresentation netWeightMeasure) {
        this.netWeightMeasure = netWeightMeasure;
    }

    public String getEmergencyProceduresCode() {
        return this.emergencyProceduresCode;
    }

    public void setEmergencyProceduresCode(String emergencyProceduresCode) {
        this.emergencyProceduresCode = emergencyProceduresCode;
    }

    public String getMedicalFirstAidGuideCode() {
        return this.medicalFirstAidGuideCode;
    }

    public void setMedicalFirstAidGuideCode(String medicalFirstAidGuideCode) {
        this.medicalFirstAidGuideCode = medicalFirstAidGuideCode;
    }

    public QuantityRepresentation getQuantity() {
        return this.quantity;
    }

    public void setQuantity(QuantityRepresentation quantity) {
        this.quantity = quantity;
    }

    public List<TemperatureRepresentation> getAdditionalTemperature() {
        return this.additionalTemperature;
    }

    public void setAdditionalTemperature(List<TemperatureRepresentation> additionalTemperature) {
        this.additionalTemperature = additionalTemperature;
    }

    public String getMarkingID() {
        return this.markingID;
    }

    public void setMarkingID(String markingID) {
        this.markingID = markingID;
    }

    public PartyRepresentation getContactParty() {
        return this.contactParty;
    }

    public void setContactParty(PartyRepresentation contactParty) {
        this.contactParty = contactParty;
    }

    public List<HazardousGoodsTransitRepresentation> getHazardousGoodsTransit() {
        return this.hazardousGoodsTransit;
    }

    public void setHazardousGoodsTransit(List<HazardousGoodsTransitRepresentation> hazardousGoodsTransit) {
        this.hazardousGoodsTransit = hazardousGoodsTransit;
    }

    public String getUNDGCode() {
        return this.UNDGCode;
    }

    public void setUNDGCode(String UNDGCode) {
        this.UNDGCode = UNDGCode;
    }

    public String getUpperOrangeHazardPlacardID() {
        return this.upperOrangeHazardPlacardID;
    }

    public void setUpperOrangeHazardPlacardID(String upperOrangeHazardPlacardID) {
        this.upperOrangeHazardPlacardID = upperOrangeHazardPlacardID;
    }

    public String getLowerOrangeHazardPlacardID() {
        return this.lowerOrangeHazardPlacardID;
    }

    public void setLowerOrangeHazardPlacardID(String lowerOrangeHazardPlacardID) {
        this.lowerOrangeHazardPlacardID = lowerOrangeHazardPlacardID;
    }

    public TemperatureRepresentation getEmergencyTemperature() {
        return this.emergencyTemperature;
    }

    public void setEmergencyTemperature(TemperatureRepresentation emergencyTemperature) {
        this.emergencyTemperature = emergencyTemperature;
    }
}