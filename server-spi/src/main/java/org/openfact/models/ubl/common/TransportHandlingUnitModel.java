package org.openfact.models.ubl.common;

import java.util.List;

import org.openfact.models.ubl.common.pe.DespatchAdviceLineModel;

public interface TransportHandlingUnitModel {

    String getID();

    void setID(String value);

    String getTransportHandlingUnitTypeCode();

    void setTransportHandlingUnitTypeCode(String value);

    String getHandlingCode();

    void setHandlingCode(String value);

    String getHandlingInstructions();

    void setHandlingInstructions(String value);

    boolean getHazardousRiskIndicator();

    void setHazardousRiskIndicator(boolean value);

    QuantityModel getTotalGoodsItemQuantity();

    void setTotalGoodsItemQuantity(QuantityModel value);

    QuantityModel getTotalPackageQuantity();

    void setTotalPackageQuantity(QuantityModel value);

    List<String> getDamageRemarks();

    void setDamageRemarks(List<String> damageRemarks);

    List<String> getShippingMarks();

    void setShippingMarks(List<String> shippingMarks);

    List<DespatchAdviceLineModel> getHandlingUnitDespatchLine();

    void setHandlingUnitDespatchLine(List<DespatchAdviceLineModel> handlingUnitDespatchLine);

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

    

}
