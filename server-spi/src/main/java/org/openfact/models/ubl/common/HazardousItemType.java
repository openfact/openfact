package org.openfact.models.ubl.common;

import java.util.List;

public interface HazardousItemType {

    IDType getID();

    void setID(IDType value);

    PlacardNotationType getPlacardNotation();

    void setPlacardNotation(PlacardNotationType value);

    PlacardEndorsementType getPlacardEndorsement();

    void setPlacardEndorsement(PlacardEndorsementType value);

    AdditionalInformationType getAdditionalInformation();

    void setAdditionalInformation(AdditionalInformationType value);

    UNDGCodeType getUNDGCode();

    void setUNDGCode(UNDGCodeType value);

    EmergencyProceduresCodeType getEmergencyProceduresCode();

    void setEmergencyProceduresCode(EmergencyProceduresCodeType value);

    MedicalFirstAidGuideCodeType getMedicalFirstAidGuideCode();

    void setMedicalFirstAidGuideCode(MedicalFirstAidGuideCodeType value);

    TechnicalNameType getTechnicalName();

    void setTechnicalName(TechnicalNameType value);

    CategoryNameType getCategoryName();

    void setCategoryName(CategoryNameType value);

    HazardousCategoryCodeType getHazardousCategoryCode();

    void setHazardousCategoryCode(HazardousCategoryCodeType value);

    UpperOrangeHazardPlacardIDType getUpperOrangeHazardPlacardID();

    void setUpperOrangeHazardPlacardID(UpperOrangeHazardPlacardIDType value);

    LowerOrangeHazardPlacardIDType getLowerOrangeHazardPlacardID();

    void setLowerOrangeHazardPlacardID(LowerOrangeHazardPlacardIDType value);

    MarkingIDType getMarkingID();

    void setMarkingID(MarkingIDType value);

    HazardClassIDType getHazardClassID();

    void setHazardClassID(HazardClassIDType value);

    NetWeightMeasureType getNetWeightMeasure();

    void setNetWeightMeasure(NetWeightMeasureType value);

    NetVolumeMeasureType getNetVolumeMeasure();

    void setNetVolumeMeasure(NetVolumeMeasureType value);

    QuantityTypeCommBas getQuantity();

    void setQuantity(QuantityTypeCommBas value);

    PartyType getContactParty();

    void setContactParty(PartyType value);

    List<SecondaryHazardType> getSecondaryHazard();

    void setSecondaryHazard(List<SecondaryHazardType> secondaryHazard);

    List<HazardousGoodsTransitType> getHazardousGoodsTransit();

    void setHazardousGoodsTransit(List<HazardousGoodsTransitType> hazardousGoodsTransit);

    TemperatureType getEmergencyTemperature();

    void setEmergencyTemperature(TemperatureType value);

    TemperatureType getFlashpointTemperature();

    void setFlashpointTemperature(TemperatureType value);

    List<TemperatureType> getAdditionalTemperature();

    void setAdditionalTemperature(List<TemperatureType> additionalTemperature);

    String getId();

    void setId(String value);

}
