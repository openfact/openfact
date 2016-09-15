package org.openfact.models.ubl.common;

import java.math.BigDecimal;

public interface TaxSubtotalModel {

    TaxableAmountModel getTaxableAmount();

    void setTaxableAmount(TaxableAmountModel value);

    TaxAmountModel getTaxAmount();

    void setTaxAmount(TaxAmountModel value);

    CalculationSequenceNumericModel getCalculationSequenceNumeric();

    void setCalculationSequenceNumeric(CalculationSequenceNumericModel value);

    TransactionCurrencyTaxAmountModel getTransactionCurrencyTaxAmount();

    void setTransactionCurrencyTaxAmount(TransactionCurrencyTaxAmountModel value);

    BigDecimal getPercent();

    void setPercent(BigDecimal value);

    BaseUnitMeasureModel getBaseUnitMeasure();

    void setBaseUnitMeasure(BaseUnitMeasureModel value);

    PerUnitAmountModel getPerUnitAmount();

    void setPerUnitAmount(PerUnitAmountModel value);

    String getTierRange();

    void setTierRange(String value);

    TierRatePercentModel getTierRatePercent();

    void setTierRatePercent(TierRatePercentModel value);

    TaxCategoryModel getTaxCategory();

    void setTaxCategory(TaxCategoryModel value);

    String getId();

    void setId(String value);

}
