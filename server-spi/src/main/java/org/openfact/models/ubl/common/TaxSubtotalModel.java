package org.openfact.models.ubl.common;

import java.math.BigDecimal;

public interface TaxSubtotalModel {

    BigDecimal getTaxableAmount();

    void setTaxableAmount(BigDecimal value);

    BigDecimal getTaxAmount();

    void setTaxAmount(BigDecimal value);

    BigDecimal getCalculationSequenceNumeric();

    void setCalculationSequenceNumeric(BigDecimal value);

    BigDecimal getTransactionCurrencyTaxAmount();

    void setTransactionCurrencyTaxAmount(BigDecimal value);

    BigDecimal getPercent();

    void setPercent(BigDecimal value);

    MeasureModel getBaseUnitMeasure();

    void setBaseUnitMeasure(MeasureModel value);

    BigDecimal getPerUnitAmount();

    void setPerUnitAmount(BigDecimal value);

    String getTierRange();

    void setTierRange(String value);

    BigDecimal getTierRatePercent();

    void setTierRatePercent(BigDecimal value);

    TaxCategoryModel getTaxCategory();

    void setTaxCategory(TaxCategoryModel value);

    String getId();

    void setId(String value);

}
