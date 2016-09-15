package org.openfact.models.ubl.common;

import java.util.List;

public interface TransportEquipmentType {

    IDType getID();

    void setID(IDType value);

    TransportEquipmentTypeCodeTypeCommBas getTransportEquipmentTypeCode();

    void setTransportEquipmentTypeCode(TransportEquipmentTypeCodeTypeCommBas value);

    ProviderTypeCodeType getProviderTypeCode();

    void setProviderTypeCode(ProviderTypeCodeType value);

    OwnerTypeCodeType getOwnerTypeCode();

    void setOwnerTypeCode(OwnerTypeCodeType value);

    SizeTypeCodeType getSizeTypeCode();

    void setSizeTypeCode(SizeTypeCodeType value);

    DispositionCodeType getDispositionCode();

    void setDispositionCode(DispositionCodeType value);

    FullnessIndicationCodeType getFullnessIndicationCode();

    void setFullnessIndicationCode(FullnessIndicationCodeType value);

    RefrigerationOnIndicatorType getRefrigerationOnIndicator();

    void setRefrigerationOnIndicator(RefrigerationOnIndicatorType value);

    InformationType getInformation();

    void setInformation(InformationType value);

    ReturnabilityIndicatorType getReturnabilityIndicator();

    void setReturnabilityIndicator(ReturnabilityIndicatorType value);

    LegalStatusIndicatorType getLegalStatusIndicator();

    void setLegalStatusIndicator(LegalStatusIndicatorType value);

    List<DimensionType> getMeasurementDimension();

    void setMeasurementDimension(List<DimensionType> measurementDimension);

    List<TransportEquipmentSealType> getTransportEquipmentSeal();

    void setTransportEquipmentSeal(List<TransportEquipmentSealType> transportEquipmentSeal);

    TemperatureType getMinimumTemperature();

    void setMinimumTemperature(TemperatureType value);

    TemperatureType getMaximumTemperature();

    void setMaximumTemperature(TemperatureType value);

    PartyType getProviderParty();

    void setProviderParty(PartyType value);

    PartyType getLoadingProofParty();

    void setLoadingProofParty(PartyType value);

    LocationTypeCommAgg getLoadingLocation();

    void setLoadingLocation(LocationTypeCommAgg value);

    String getId();

    void setId(String value);

}
