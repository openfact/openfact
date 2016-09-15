package org.openfact.models.ubl.common;

import java.util.List;

public interface ShipmentModel {

    IDModel getID();

    void setID(IDModel value);

    String getShippingPriorityLevelCode();

    void setShippingPriorityLevelCode(String value);

    String getHandlingCode();

    void setHandlingCode(String value);

    HandlingInstructionsModel getHandlingInstructions();

    void setHandlingInstructions(HandlingInstructionsModel value);

    InformationModel getInformation();

    void setInformation(InformationModel value);

    GrossWeightMeasureModel getGrossWeightMeasure();

    void setGrossWeightMeasure(GrossWeightMeasureModel value);

    NetWeightMeasureModel getNetWeightMeasure();

    void setNetWeightMeasure(NetWeightMeasureModel value);

    NetNetWeightMeasureModel getNetNetWeightMeasure();

    void setNetNetWeightMeasure(NetNetWeightMeasureModel value);

    GrossVolumeMeasureModel getGrossVolumeMeasure();

    void setGrossVolumeMeasure(GrossVolumeMeasureModel value);

    NetVolumeMeasureModel getNetVolumeMeasure();

    void setNetVolumeMeasure(NetVolumeMeasureModel value);

    TotalGoodsItemQuantityModel getTotalGoodsItemQuantity();

    void setTotalGoodsItemQuantity(TotalGoodsItemQuantityModel value);

    TotalTransportHandlingUnitQuantityModel getTotalTransportHandlingUnitQuantity();

    void setTotalTransportHandlingUnitQuantity(TotalTransportHandlingUnitQuantityModel value);

    InsuranceValueAmountModel getInsuranceValueAmount();

    void setInsuranceValueAmount(InsuranceValueAmountModel value);

    DeclaredCustomsValueAmountModel getDeclaredCustomsValueAmount();

    void setDeclaredCustomsValueAmount(DeclaredCustomsValueAmountModel value);

    DeclaredForCarriageValueAmountModel getDeclaredForCarriageValueAmount();

    void setDeclaredForCarriageValueAmount(DeclaredForCarriageValueAmountModel value);

    DeclaredStatisticsValueAmountModel getDeclaredStatisticsValueAmount();

    void setDeclaredStatisticsValueAmount(DeclaredStatisticsValueAmountModel value);

    FreeOnBoardValueAmountModel getFreeOnBoardValueAmount();

    void setFreeOnBoardValueAmount(FreeOnBoardValueAmountModel value);

    List<SpecialInstructionsModel> getSpecialInstructions();

    void setSpecialInstructions(List<SpecialInstructionsModel> specialInstructions);

    List<DeliveryInstructionsModel> getDeliveryInstructions();

    void setDeliveryInstructions(List<DeliveryInstructionsModel> deliveryInstructions);

    SplitConsignmentIndicatorModel getSplitConsignmentIndicator();

    void setSplitConsignmentIndicator(SplitConsignmentIndicatorModel value);

    ConsignmentModel getConsignment();

    void setConsignment(ConsignmentModel value);

    List<GoodsItemModel> getGoodsItem();

    void setGoodsItem(List<GoodsItemModel> goodsItem);

    List<ShipmentStageModel> getShipmentStage();

    void setShipmentStage(List<ShipmentStageModel> shipmentStage);

    DeliveryModel getDelivery();

    void setDelivery(DeliveryModel value);

    List<TransportHandlingUnitModel> getTransportHandlingUnit();

    void setTransportHandlingUnit(List<TransportHandlingUnitModel> transportHandlingUnit);

    AddressModel getOriginAddress();

    void setOriginAddress(AddressModel value);

    LocationModelCommAgg getFirstArrivalPortLocation();

    void setFirstArrivalPortLocation(LocationModelCommAgg value);

    LocationModelCommAgg getLastExitPortLocation();

    void setLastExitPortLocation(LocationModelCommAgg value);

    CountryModel getExportCountry();

    void setExportCountry(CountryModel value);

    List<AllowanceChargeModel> getFreightAllowanceCharge();

    void setFreightAllowanceCharge(List<AllowanceChargeModel> freightAllowanceCharge);

    String getId();

    void setId(String value);

}
