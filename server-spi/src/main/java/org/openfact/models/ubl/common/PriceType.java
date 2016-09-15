package org.openfact.models.ubl.common;

import java.util.List;

public interface PriceType {

    PriceAmountType getPriceAmount();

    void setPriceAmount(PriceAmountType value);

    BaseQuantityType getBaseQuantity();

    void setBaseQuantity(BaseQuantityType value);

    List<PriceChangeReasonType> getPriceChangeReason();

    void setPriceChangeReason(List<PriceChangeReasonType> priceChangeReason);

    PriceTypeCodeType getPriceTypeCode();

    void setPriceTypeCode(PriceTypeCodeType value);

    PriceTypeType getPriceType();

    void setPriceType(PriceTypeType value);

    OrderableUnitFactorRateType getOrderableUnitFactorRate();

    void setOrderableUnitFactorRate(OrderableUnitFactorRateType value);

    List<PeriodType> getValidityPeriod();

    void setValidityPeriod(List<PeriodType> validityPeriod);

    PriceListType getPriceList();

    void setPriceList(PriceListType value);

    List<AllowanceChargeType> getAllowanceCharge();

    void setAllowanceCharge(List<AllowanceChargeType> allowanceCharge);

    String getId();

    void setId(String value);

}
