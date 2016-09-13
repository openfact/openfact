package org.openfact.models.ubl;

import java.math.BigDecimal;
import java.util.List;

import org.openfact.models.ubl.type.*;

public interface PriceModel {

    QuantityModel getBaseQuantity();

    void setBaseQuantity(QuantityModel baseQuantity);

    RateModel getOrderableUnitFactorRate();

    void setOrderableUnitFactorRate(RateModel orderableUnitFactorRate);

    BigDecimal getPriceAmount();

    void setPriceAmount(BigDecimal priceAmount);

    TextModel getPriceChangeReason();

    void setPriceChangeReason(TextModel priceChangeReason);

    TextModel getPriceType();

    void setPriceType(TextModel priceType);

    CodeModel getPriceTypeCode();

    void setPriceTypeCode(CodeModel priceTypeCode);

    List<AllowanceChargeModel> getAllowanceCharges();

    void setAllowanceCharges(List<AllowanceChargeModel> allowanceCharges);

    ExchangeRateModel getPricingExchangeRate();

    void setPricingExchangeRate(ExchangeRateModel pricingExchangeRate);

    PeriodModel getValidityPeriod();

    void setValidityPeriod(PeriodModel validityPeriod);

    List<PriceListModel> getPriceLists();

    void setPriceLists(List<PriceListModel> priceLists);

}
