package org.openfact.models.ubl.common;

import java.util.List;

public interface GoodsItemType {

    IDType getID();

    void setID(IDType value);

    SequenceNumberIDType getSequenceNumberID();

    void setSequenceNumberID(SequenceNumberIDType value);

    List<DescriptionType> getDescription();

    void setDescription(List<DescriptionType> description);

    HazardousRiskIndicatorType getHazardousRiskIndicator();

    void setHazardousRiskIndicator(HazardousRiskIndicatorType value);

    DeclaredCustomsValueAmountType getDeclaredCustomsValueAmount();

    void setDeclaredCustomsValueAmount(DeclaredCustomsValueAmountType value);

    DeclaredForCarriageValueAmountType getDeclaredForCarriageValueAmount();

    void setDeclaredForCarriageValueAmount(DeclaredForCarriageValueAmountType value);

    DeclaredStatisticsValueAmountType getDeclaredStatisticsValueAmount();

    void setDeclaredStatisticsValueAmount(DeclaredStatisticsValueAmountType value);

    FreeOnBoardValueAmountType getFreeOnBoardValueAmount();

    void setFreeOnBoardValueAmount(FreeOnBoardValueAmountType value);

    InsuranceValueAmountType getInsuranceValueAmount();

    void setInsuranceValueAmount(InsuranceValueAmountType value);

    ValueAmountType getValueAmount();

    void setValueAmount(ValueAmountType value);

    GrossWeightMeasureType getGrossWeightMeasure();

    void setGrossWeightMeasure(GrossWeightMeasureType value);

    NetWeightMeasureType getNetWeightMeasure();

    void setNetWeightMeasure(NetWeightMeasureType value);

    NetNetWeightMeasureType getNetNetWeightMeasure();

    void setNetNetWeightMeasure(NetNetWeightMeasureType value);

    ChargeableWeightMeasureType getChargeableWeightMeasure();

    void setChargeableWeightMeasure(ChargeableWeightMeasureType value);

    GrossVolumeMeasureType getGrossVolumeMeasure();

    void setGrossVolumeMeasure(GrossVolumeMeasureType value);

    NetVolumeMeasureType getNetVolumeMeasure();

    void setNetVolumeMeasure(NetVolumeMeasureType value);

    QuantityTypeCommBas getQuantity();

    void setQuantity(QuantityTypeCommBas value);

    PreferenceCriterionCodeType getPreferenceCriterionCode();

    void setPreferenceCriterionCode(PreferenceCriterionCodeType value);

    RequiredCustomsIDType getRequiredCustomsID();

    void setRequiredCustomsID(RequiredCustomsIDType value);

    CustomsStatusCodeType getCustomsStatusCode();

    void setCustomsStatusCode(CustomsStatusCodeType value);

    CustomsTariffQuantityType getCustomsTariffQuantity();

    void setCustomsTariffQuantity(CustomsTariffQuantityType value);

    CustomsImportClassifiedIndicatorType getCustomsImportClassifiedIndicator();

    void setCustomsImportClassifiedIndicator(CustomsImportClassifiedIndicatorType value);

    List<ItemType> getItem();

    void setItem(List<ItemType> item);

    List<GoodsItemContainerType> getGoodsItemContainer();

    void setGoodsItemContainer(List<GoodsItemContainerType> goodsItemContainer);

    List<AllowanceChargeType> getFreightAllowanceCharge();

    void setFreightAllowanceCharge(List<AllowanceChargeType> freightAllowanceCharge);

    List<InvoiceLineType> getInvoiceLine();

    void setInvoiceLine(List<InvoiceLineType> invoiceLine);

    List<TemperatureType> getTemperature();

    void setTemperature(List<TemperatureType> temperature);

    List<GoodsItemType> getContainedGoodsItem();

    void setContainedGoodsItem(List<GoodsItemType> containedGoodsItem);

    AddressType getOriginAddress();

    void setOriginAddress(AddressType value);

    String getId();

    void setId(String value);

}
