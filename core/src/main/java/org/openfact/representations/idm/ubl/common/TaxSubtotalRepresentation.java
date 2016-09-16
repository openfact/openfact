package org.openfact.representations.idm.ubl.common;

import java.math.BigDecimal;

public class TaxSubtotalRepresentation {
    private BigDecimal TaxableAmount;
    private BigDecimal TaxAmount;
    private BigDecimal CalculationSequenceNumeric;
    private BigDecimal TransactionCurrencyTaxAmount;
    private BigDecimal Percent;
    private MeasureRepresentation BaseUnitMeasure;
    private BigDecimal PerUnitAmount;
    private String TierRange;
    private BigDecimal TierRatePercent;
    private TaxCategoryRepresentation TaxCategory;
    private String Id;
}