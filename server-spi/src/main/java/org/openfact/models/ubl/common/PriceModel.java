package org.openfact.models.ubl.common;

import java.util.List;

public interface PriceModel {

    PriceAmountModel getPriceAmount();

    void setPriceAmount(PriceAmountModel value);

    BaseQuantityModel getBaseQuantity();

    void setBaseQuantity(BaseQuantityModel value);

    List<String> getPriceChangeReason();

    void setPriceChangeReason(List<String> priceChangeReason);

    String getPriceModelCode();

    void setPriceModelCode(String value);

    String getPriceModel();

    void setPriceModel(String value);

    OrderableUnitFactorRateModel getOrderableUnitFactorRate();

    void setOrderableUnitFactorRate(OrderableUnitFactorRateModel value);

    List<PeriodModel> getValidityPeriod();

    void setValidityPeriod(List<PeriodModel> validityPeriod);

    PriceListModel getPriceList();

    void setPriceList(PriceListModel value);

    List<AllowanceChargeModel> getAllowanceCharge();

    void setAllowanceCharge(List<AllowanceChargeModel> allowanceCharge);

    String getId();

    void setId(String value);

}
