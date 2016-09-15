package org.openfact.models.ubl.common;

public interface TaxSubtotalType {

    TaxableAmountType getTaxableAmount();

    void setTaxableAmount(TaxableAmountType value);

    TaxAmountType getTaxAmount();

    void setTaxAmount(TaxAmountType value);

    CalculationSequenceNumericType getCalculationSequenceNumeric();

    void setCalculationSequenceNumeric(CalculationSequenceNumericType value);

    TransactionCurrencyTaxAmountType getTransactionCurrencyTaxAmount();

    void setTransactionCurrencyTaxAmount(TransactionCurrencyTaxAmountType value);

    PercentType getPercent();

    void setPercent(PercentType value);

    BaseUnitMeasureType getBaseUnitMeasure();

    void setBaseUnitMeasure(BaseUnitMeasureType value);

    PerUnitAmountType getPerUnitAmount();

    void setPerUnitAmount(PerUnitAmountType value);

    TierRangeType getTierRange();

    void setTierRange(TierRangeType value);

    TierRatePercentType getTierRatePercent();

    void setTierRatePercent(TierRatePercentType value);

    TaxCategoryType getTaxCategory();

    void setTaxCategory(TaxCategoryType value);

    String getId();

    void setId(String value);

}
