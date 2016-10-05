package org.openfact.models.ubl.common;

import java.math.BigDecimal;
import java.util.List;

public interface PriceModel {

    BigDecimal getPriceAmount();

    void setPriceAmount(BigDecimal value);

    QuantityModel getBaseQuantity();

    void setBaseQuantity(QuantityModel value);

    List<String> getPriceChangeReason();

    void setPriceChangeReason(List<String> priceChangeReason);

    String getPriceTypeCode();

    void setPriceTypeCode(String value);

    String getPriceType();

    void setPriceType(String value);

    BigDecimal getOrderableUnitFactorRate();

    void setOrderableUnitFactorRate(BigDecimal value);

    List<PeriodModel> getValidityPeriod();

    void setValidityPeriod(List<PeriodModel> validityPeriod);

    PriceListModel getPriceList();

    void setPriceList(PriceListModel value);

    List<AllowanceChargeModel> getAllowanceCharge();

    void setAllowanceCharge(List<AllowanceChargeModel> allowanceCharge);

    String getId();

    

}
