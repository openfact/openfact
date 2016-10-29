package org.openfact.models.ubl.common;

import java.util.List;

public interface TransportEquipmentModel {

    String getID();

    void setID(String value);

    String getTransportEquipmentTypeCode();

    void setTransportEquipmentTypeCode(String value);

    String getProviderTypeCode();

    void setProviderTypeCode(String value);

    String getOwnerTypeCode();

    void setOwnerTypeCode(String value);

    String getSizeTypeCode();

    void setSizeTypeCode(String value);

    String getDispositionCode();

    void setDispositionCode(String value);

    String getFullnessIndicationCode();

    void setFullnessIndicationCode(String value);

    boolean getRefrigerationOnIndicator();

    void setRefrigerationOnIndicator(boolean value);

    String getInformation();

    void setInformation(String value);

    boolean getReturnabilityIndicator();

    void setReturnabilityIndicator(boolean value);

    boolean getLegalStatusIndicator();

    void setLegalStatusIndicator(boolean value);

    List<DimensionModel> getMeasurementDimension();

    void setMeasurementDimension(List<DimensionModel> measurementDimension);

    List<TransportEquipmentSealModel> getTransportEquipmentSeal();

    void setTransportEquipmentSeal(List<TransportEquipmentSealModel> transportEquipmentSeal);

    TemperatureModel getMinimumTemperature();

    void setMinimumTemperature(TemperatureModel value);

    TemperatureModel getMaximumTemperature();

    void setMaximumTemperature(TemperatureModel value);

    PartyModel getProviderParty();

    void setProviderParty(PartyModel value);

    PartyModel getLoadingProofParty();

    void setLoadingProofParty(PartyModel value);

    LocationCommAggModel getLoadingLocation();

    void setLoadingLocation(LocationCommAggModel value);

    String getId();

    

}
