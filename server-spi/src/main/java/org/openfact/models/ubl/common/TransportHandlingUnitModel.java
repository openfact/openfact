package org.openfact.models.ubl.common;

import java.util.List;

public interface TransportHandlingUnitModel {

    IDModel getID();

    void setID(IDModel value);

    TransportHandlingUnitModelCodeModel getTransportHandlingUnitModelCode();

    void setTransportHandlingUnitModelCode(TransportHandlingUnitModelCodeModel value);

    HandlingCodeModel getHandlingCode();

    void setHandlingCode(HandlingCodeModel value);

    HandlingInstructionsModel getHandlingInstructions();

    void setHandlingInstructions(HandlingInstructionsModel value);

    HazardousRiskIndicatorModel getHazardousRiskIndicator();

    void setHazardousRiskIndicator(HazardousRiskIndicatorModel value);

    TotalGoodsItemQuantityModel getTotalGoodsItemQuantity();

    void setTotalGoodsItemQuantity(TotalGoodsItemQuantityModel value);

    TotalPackageQuantityModel getTotalPackageQuantity();

    void setTotalPackageQuantity(TotalPackageQuantityModel value);

    List<DamageRemarksModel> getDamageRemarks();

    void setDamageRemarks(List<DamageRemarksModel> damageRemarks);

    List<ShippingMarksModel> getShippingMarks();

    void setShippingMarks(List<ShippingMarksModel> shippingMarks);

    List<DespatchLineModel> getHandlingUnitDespatchLine();

    void setHandlingUnitDespatchLine(List<DespatchLineModel> handlingUnitDespatchLine);

    List<PackageModel> getActualPackage();

    void setActualPackage(List<PackageModel> actualPackage);

    List<ReceiptLineModel> getReceivedHandlingUnitReceiptLine();

    void setReceivedHandlingUnitReceiptLine(List<ReceiptLineModel> receivedHandlingUnitReceiptLine);

    List<TransportEquipmentModel> getTransportEquipment();

    void setTransportEquipment(List<TransportEquipmentModel> transportEquipment);

    List<HazardousGoodsTransitModel> getHazardousGoodsTransit();

    void setHazardousGoodsTransit(List<HazardousGoodsTransitModel> hazardousGoodsTransit);

    List<DimensionModel> getMeasurementDimension();

    void setMeasurementDimension(List<DimensionModel> measurementDimension);

    TemperatureModel getMinimumTemperature();

    void setMinimumTemperature(TemperatureModel value);

    TemperatureModel getMaximumTemperature();

    void setMaximumTemperature(TemperatureModel value);

    String getId();

    void setId(String value);

}
