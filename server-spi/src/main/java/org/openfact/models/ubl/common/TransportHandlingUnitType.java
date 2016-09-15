package org.openfact.models.ubl.common;

import java.util.List;

public interface TransportHandlingUnitType {

    IDType getID();

    void setID(IDType value);

    TransportHandlingUnitTypeCodeType getTransportHandlingUnitTypeCode();

    void setTransportHandlingUnitTypeCode(TransportHandlingUnitTypeCodeType value);

    HandlingCodeType getHandlingCode();

    void setHandlingCode(HandlingCodeType value);

    HandlingInstructionsType getHandlingInstructions();

    void setHandlingInstructions(HandlingInstructionsType value);

    HazardousRiskIndicatorType getHazardousRiskIndicator();

    void setHazardousRiskIndicator(HazardousRiskIndicatorType value);

    TotalGoodsItemQuantityType getTotalGoodsItemQuantity();

    void setTotalGoodsItemQuantity(TotalGoodsItemQuantityType value);

    TotalPackageQuantityType getTotalPackageQuantity();

    void setTotalPackageQuantity(TotalPackageQuantityType value);

    List<DamageRemarksType> getDamageRemarks();

    void setDamageRemarks(List<DamageRemarksType> damageRemarks);

    List<ShippingMarksType> getShippingMarks();

    void setShippingMarks(List<ShippingMarksType> shippingMarks);

    List<DespatchLineType> getHandlingUnitDespatchLine();

    void setHandlingUnitDespatchLine(List<DespatchLineType> handlingUnitDespatchLine);

    List<PackageType> getActualPackage();

    void setActualPackage(List<PackageType> actualPackage);

    List<ReceiptLineType> getReceivedHandlingUnitReceiptLine();

    void setReceivedHandlingUnitReceiptLine(List<ReceiptLineType> receivedHandlingUnitReceiptLine);

    List<TransportEquipmentType> getTransportEquipment();

    void setTransportEquipment(List<TransportEquipmentType> transportEquipment);

    List<HazardousGoodsTransitType> getHazardousGoodsTransit();

    void setHazardousGoodsTransit(List<HazardousGoodsTransitType> hazardousGoodsTransit);

    List<DimensionType> getMeasurementDimension();

    void setMeasurementDimension(List<DimensionType> measurementDimension);

    TemperatureType getMinimumTemperature();

    void setMinimumTemperature(TemperatureType value);

    TemperatureType getMaximumTemperature();

    void setMaximumTemperature(TemperatureType value);

    String getId();

    void setId(String value);

}
