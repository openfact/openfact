package org.openfact.models.ubl.common;

import java.util.List;

public interface TransportEquipmentModel {

    IDModel getID();

    void setID(IDModel value);

    TransportEquipmentModelCodeModelCommBas getTransportEquipmentModelCode();

    void setTransportEquipmentModelCode(TransportEquipmentModelCodeModelCommBas value);

    ProviderModelCodeModel getProviderModelCode();

    void setProviderModelCode(ProviderModelCodeModel value);

    OwnerModelCodeModel getOwnerModelCode();

    void setOwnerModelCode(OwnerModelCodeModel value);

    SizeModelCodeModel getSizeModelCode();

    void setSizeModelCode(SizeModelCodeModel value);

    DispositionCodeModel getDispositionCode();

    void setDispositionCode(DispositionCodeModel value);

    FullnessIndicationCodeModel getFullnessIndicationCode();

    void setFullnessIndicationCode(FullnessIndicationCodeModel value);

    RefrigerationOnIndicatorModel getRefrigerationOnIndicator();

    void setRefrigerationOnIndicator(RefrigerationOnIndicatorModel value);

    InformationModel getInformation();

    void setInformation(InformationModel value);

    ReturnabilityIndicatorModel getReturnabilityIndicator();

    void setReturnabilityIndicator(ReturnabilityIndicatorModel value);

    LegalStatusIndicatorModel getLegalStatusIndicator();

    void setLegalStatusIndicator(LegalStatusIndicatorModel value);

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
