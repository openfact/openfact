package org.openfact.models.ubl.common;

import java.math.BigDecimal;
import java.util.List;

public interface ShipmentModel {

    String getID();

    void setID(String value);

    String getShippingPriorityLevelCode();

    void setShippingPriorityLevelCode(String value);

    String getHandlingCode();

    void setHandlingCode(String value);

    String getHandlingInstructions();

    void setHandlingInstructions(String value);

    String getInformation();

    void setInformation(String value);

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

    BigDecimal getInsuranceValueAmount();

    void setInsuranceValueAmount(BigDecimal value);

    BigDecimal getDeclaredCustomsValueAmount();

    void setDeclaredCustomsValueAmount(BigDecimal value);

    BigDecimal getDeclaredForCarriageValueAmount();

    void setDeclaredForCarriageValueAmount(BigDecimal value);

    BigDecimal getDeclaredStatisticsValueAmount();

    void setDeclaredStatisticsValueAmount(BigDecimal value);

    BigDecimal getFreeOnBoardValueAmount();

    void setFreeOnBoardValueAmount(BigDecimal value);

    List<String> getSpecialInstructions();

    void setSpecialInstructions(List<String> specialInstructions);

    List<String> getDeliveryInstructions();

    void setDeliveryInstructions(List<String> deliveryInstructions);

    boolean getSplitConsignmentIndicator();

    void setSplitConsignmentIndicator(boolean value);

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
