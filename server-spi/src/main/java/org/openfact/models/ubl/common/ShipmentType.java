package org.openfact.models.ubl.common;

import java.util.List;

public interface ShipmentType {

    IDType getID();

    void setID(IDType value);

    ShippingPriorityLevelCodeType getShippingPriorityLevelCode();

    void setShippingPriorityLevelCode(ShippingPriorityLevelCodeType value);

    HandlingCodeType getHandlingCode();

    void setHandlingCode(HandlingCodeType value);

    HandlingInstructionsType getHandlingInstructions();

    void setHandlingInstructions(HandlingInstructionsType value);

    InformationType getInformation();

    void setInformation(InformationType value);

    GrossWeightMeasureType getGrossWeightMeasure();

    void setGrossWeightMeasure(GrossWeightMeasureType value);

    NetWeightMeasureType getNetWeightMeasure();

    void setNetWeightMeasure(NetWeightMeasureType value);

    NetNetWeightMeasureType getNetNetWeightMeasure();

    void setNetNetWeightMeasure(NetNetWeightMeasureType value);

    GrossVolumeMeasureType getGrossVolumeMeasure();

    void setGrossVolumeMeasure(GrossVolumeMeasureType value);

    NetVolumeMeasureType getNetVolumeMeasure();

    void setNetVolumeMeasure(NetVolumeMeasureType value);

    TotalGoodsItemQuantityType getTotalGoodsItemQuantity();

    void setTotalGoodsItemQuantity(TotalGoodsItemQuantityType value);

    TotalTransportHandlingUnitQuantityType getTotalTransportHandlingUnitQuantity();

    void setTotalTransportHandlingUnitQuantity(TotalTransportHandlingUnitQuantityType value);

    InsuranceValueAmountType getInsuranceValueAmount();

    void setInsuranceValueAmount(InsuranceValueAmountType value);

    DeclaredCustomsValueAmountType getDeclaredCustomsValueAmount();

    void setDeclaredCustomsValueAmount(DeclaredCustomsValueAmountType value);

    DeclaredForCarriageValueAmountType getDeclaredForCarriageValueAmount();

    void setDeclaredForCarriageValueAmount(DeclaredForCarriageValueAmountType value);

    DeclaredStatisticsValueAmountType getDeclaredStatisticsValueAmount();

    void setDeclaredStatisticsValueAmount(DeclaredStatisticsValueAmountType value);

    FreeOnBoardValueAmountType getFreeOnBoardValueAmount();

    void setFreeOnBoardValueAmount(FreeOnBoardValueAmountType value);

    List<SpecialInstructionsType> getSpecialInstructions();

    void setSpecialInstructions(List<SpecialInstructionsType> specialInstructions);

    List<DeliveryInstructionsType> getDeliveryInstructions();

    void setDeliveryInstructions(List<DeliveryInstructionsType> deliveryInstructions);

    SplitConsignmentIndicatorType getSplitConsignmentIndicator();

    void setSplitConsignmentIndicator(SplitConsignmentIndicatorType value);

    ConsignmentType getConsignment();

    void setConsignment(ConsignmentType value);

    List<GoodsItemType> getGoodsItem();

    void setGoodsItem(List<GoodsItemType> goodsItem);

    List<ShipmentStageType> getShipmentStage();

    void setShipmentStage(List<ShipmentStageType> shipmentStage);

    DeliveryType getDelivery();

    void setDelivery(DeliveryType value);

    List<TransportHandlingUnitType> getTransportHandlingUnit();

    void setTransportHandlingUnit(List<TransportHandlingUnitType> transportHandlingUnit);

    AddressType getOriginAddress();

    void setOriginAddress(AddressType value);

    LocationTypeCommAgg getFirstArrivalPortLocation();

    void setFirstArrivalPortLocation(LocationTypeCommAgg value);

    LocationTypeCommAgg getLastExitPortLocation();

    void setLastExitPortLocation(LocationTypeCommAgg value);

    CountryType getExportCountry();

    void setExportCountry(CountryType value);

    List<AllowanceChargeType> getFreightAllowanceCharge();

    void setFreightAllowanceCharge(List<AllowanceChargeType> freightAllowanceCharge);

    String getId();

    void setId(String value);

}
