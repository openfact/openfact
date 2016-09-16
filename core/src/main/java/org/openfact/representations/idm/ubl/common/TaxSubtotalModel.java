package org.openfact.representations.idm.ubl.common;

import java.math.BigDecimal;

public class TaxSubtotalModel {
    protected BigDecimal TaxableAmount;
    protected BigDecimal TaxAmount;
    protected BigDecimal CalculationSequenceNumeric;
    protected BigDecimal TransactionCurrencyTaxAmount;
    protected BigDecimal Percent;
    protected MeasureModel BaseUnitMeasure;
    protected BigDecimal PerUnitAmount;
    protected String TierRange;
    protected BigDecimal TierRatePercent;
    protected TaxCategoryModel TaxCategory;
    protected String Id;
}