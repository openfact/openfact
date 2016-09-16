package org.openfact.representations.idm.ubl.common;

import java.math.BigDecimal;

public class TaxSubtotalRepresentation {
    private BigDecimal taxableAmount;
    private BigDecimal taxAmount;
    private BigDecimal calculationSequenceNumeric;
    private BigDecimal transactionCurrencyTaxAmount;
    private BigDecimal percent;
    private MeasureRepresentation baseUnitMeasure;
    private BigDecimal perUnitAmount;
    private String tierRange;
    private BigDecimal tierRatePercent;
    private TaxCategoryRepresentation taxCategory;
    private String id;
}
