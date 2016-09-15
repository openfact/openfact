package org.openfact.models.ubl.common;

import java.util.List;

public interface TransportEquipmentModel {

    String getID();

    void setID(String value);

    String getTransportEquipmentModelCode();

    void setTransportEquipmentModelCode(String value);

    String getProviderModelCode();

    void setProviderModelCode(String value);

    String getOwnerModelCode();

    void setOwnerModelCode(String value);

    String getSizeModelCode();

    void setSizeModelCode(String value);

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

    LocationModelCommAgg getLoadingLocation();

    void setLoadingLocation(LocationModelCommAgg value);

    String getId();

    void setId(String value);

}
