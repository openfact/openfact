package org.openfact.models.ubl;

import java.math.BigDecimal;
import java.util.List;

import org.openfact.models.ubl.type.*;

public interface TaxSubtotalModel {

    MeasureType getBaseUnitMeasure();

    void setBaseUnitMeasure(MeasureType baseUnitMeasure);

    BigDecimal getCalculationSequenceNumeric();

    void setCalculationSequenceNumeric(BigDecimal calculationSequenceNumeric);

    BigDecimal getPercent();

    void setPercent(BigDecimal percent);

    BigDecimal getPerUnitAmount();

    void setPerUnitAmount(BigDecimal perUnitAmount);

    BigDecimal getTaxableAmount();

    void setTaxableAmount(BigDecimal taxableAmount);

    BigDecimal getTaxAmount();

    void setTaxAmount(BigDecimal taxAmount);

    TextType getTierRange();

    void setTierRange(TextType tierRange);

    BigDecimal getTierRatePercent();

    void setTierRatePercent(BigDecimal tierRatePercent);

    BigDecimal getTransactionCurrencyTaxAmount();

    void setTransactionCurrencyTaxAmount(BigDecimal transactionCurrencyTaxAmount);

    TaxCategoryModel getTaxCategory();

    void setTaxCategories(TaxCategoryModel taxCategory);

}
