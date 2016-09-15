package org.openfact.models.ubl.common;

import java.util.List;

public interface HazardousItemModel {

    String getID();

    void setID(String value);

    String getPlacardNotation();

    void setPlacardNotation(String value);

    String getPlacardEndorsement();

    void setPlacardEndorsement(String value);

    String getAdditionalInformation();

    void setAdditionalInformation(String value);

    String getUNDGCode();

    void setUNDGCode(String value);

    String getEmergencyProceduresCode();

    void setEmergencyProceduresCode(String value);

    String getMedicalFirstAidGuideCode();

    void setMedicalFirstAidGuideCode(String value);

    String getTechnicalName();

    void setTechnicalName(String value);

    String getCategoryName();

    void setCategoryName(String value);

    String getHazardousCategoryCode();

    void setHazardousCategoryCode(String value);

    String getUpperOrangeHazardPlacardID();

    void setUpperOrangeHazardPlacardID(String value);

    String getLowerOrangeHazardPlacardID();

    void setLowerOrangeHazardPlacardID(String value);

    String getMarkingID();

    void setMarkingID(String value);

    String getHazardClassID();

    void setHazardClassID(String value);

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
