package org.openfact.models.ubl.common;

import java.util.List;

public interface HazardousItemModel {

    IDModel getID();

    void setID(IDModel value);

    PlacardNotationModel getPlacardNotation();

    void setPlacardNotation(PlacardNotationModel value);

    PlacardEndorsementModel getPlacardEndorsement();

    void setPlacardEndorsement(PlacardEndorsementModel value);

    AdditionalInformationModel getAdditionalInformation();

    void setAdditionalInformation(AdditionalInformationModel value);

    UNDGCodeModel getUNDGCode();

    void setUNDGCode(UNDGCodeModel value);

    EmergencyProceduresCodeModel getEmergencyProceduresCode();

    void setEmergencyProceduresCode(EmergencyProceduresCodeModel value);

    MedicalFirstAidGuideCodeModel getMedicalFirstAidGuideCode();

    void setMedicalFirstAidGuideCode(MedicalFirstAidGuideCodeModel value);

    TechnicalNameModel getTechnicalName();

    void setTechnicalName(TechnicalNameModel value);

    CategoryNameModel getCategoryName();

    void setCategoryName(CategoryNameModel value);

    HazardousCategoryCodeModel getHazardousCategoryCode();

    void setHazardousCategoryCode(HazardousCategoryCodeModel value);

    UpperOrangeHazardPlacardIDModel getUpperOrangeHazardPlacardID();

    void setUpperOrangeHazardPlacardID(UpperOrangeHazardPlacardIDModel value);

    LowerOrangeHazardPlacardIDModel getLowerOrangeHazardPlacardID();

    void setLowerOrangeHazardPlacardID(LowerOrangeHazardPlacardIDModel value);

    MarkingIDModel getMarkingID();

    void setMarkingID(MarkingIDModel value);

    HazardClassIDModel getHazardClassID();

    void setHazardClassID(HazardClassIDModel value);

    NetWeightMeasureModel getNetWeightMeasure();

    void setNetWeightMeasure(NetWeightMeasureModel value);

    NetVolumeMeasureModel getNetVolumeMeasure();

    void setNetVolumeMeasure(NetVolumeMeasureModel value);

    QuantityModelCommBas getQuantity();

    void setQuantity(QuantityModelCommBas value);

    PartyModel getContactParty();

    void setContactParty(PartyModel value);

    List<SecondaryHazardModel> getSecondaryHazard();

    void setSecondaryHazard(List<SecondaryHazardModel> secondaryHazard);

    List<HazardousGoodsTransitModel> getHazardousGoodsTransit();

    void setHazardousGoodsTransit(List<HazardousGoodsTransitModel> hazardousGoodsTransit);

    TemperatureModel getEmergencyTemperature();

    void setEmergencyTemperature(TemperatureModel value);

    TemperatureModel getFlashpointTemperature();

    void setFlashpointTemperature(TemperatureModel value);

    List<TemperatureModel> getAdditionalTemperature();

    void setAdditionalTemperature(List<TemperatureModel> additionalTemperature);

    String getId();

    void setId(String value);

}
