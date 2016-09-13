package org.openfact.models.ubl;

import java.math.BigDecimal;
import java.util.List;

import org.openfact.models.ubl.type.*;

public interface PriceModel {

    QuantityType getBaseQuantity();

    void setBaseQuantity(QuantityType baseQuantity);

    RateType getOrderableUnitFactorRate();

    void setOrderableUnitFactorRate(RateType orderableUnitFactorRate);

    BigDecimal getPriceAmount();

    void setPriceAmount(BigDecimal priceAmount);

    TextType getPriceChangeReason();

    void setPriceChangeReason(TextType priceChangeReason);

    TextType getPriceType();

    void setPriceType(TextType priceType);

    CodeType getPriceTypeCode();

    void setPriceTypeCode(CodeType priceTypeCode);

    List<AllowanceChargeModel> getAllowanceCharges();

    void setAllowanceCharges(List<AllowanceChargeModel> allowanceCharges);

    ExchangeRateModel getPricingExchangeRate();

    void setPricingExchangeRate(ExchangeRateModel pricingExchangeRate);

    PeriodModel getValidityPeriod();

    void setValidityPeriod(PeriodModel validityPeriod);

    List<PriceListModel> getPriceLists();

    void setPriceLists(List<PriceListModel> priceLists);

}
