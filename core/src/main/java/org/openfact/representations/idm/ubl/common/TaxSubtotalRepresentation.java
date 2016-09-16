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

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getTaxAmount() {
        return this.taxAmount;
    }

    public void setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
    }

    public BigDecimal getPercent() {
        return this.percent;
    }

    public void setPercent(BigDecimal percent) {
        this.percent = percent;
    }

    public BigDecimal getTaxableAmount() {
        return this.taxableAmount;
    }

    public void setTaxableAmount(BigDecimal taxableAmount) {
        this.taxableAmount = taxableAmount;
    }

    public MeasureRepresentation getBaseUnitMeasure() {
        return this.baseUnitMeasure;
    }

    public void setBaseUnitMeasure(MeasureRepresentation baseUnitMeasure) {
        this.baseUnitMeasure = baseUnitMeasure;
    }

    public BigDecimal getCalculationSequenceNumeric() {
        return this.calculationSequenceNumeric;
    }

    public void setCalculationSequenceNumeric(BigDecimal calculationSequenceNumeric) {
        this.calculationSequenceNumeric = calculationSequenceNumeric;
    }

    public BigDecimal getTransactionCurrencyTaxAmount() {
        return this.transactionCurrencyTaxAmount;
    }

    public void setTransactionCurrencyTaxAmount(BigDecimal transactionCurrencyTaxAmount) {
        this.transactionCurrencyTaxAmount = transactionCurrencyTaxAmount;
    }

    public BigDecimal getPerUnitAmount() {
        return this.perUnitAmount;
    }

    public void setPerUnitAmount(BigDecimal perUnitAmount) {
        this.perUnitAmount = perUnitAmount;
    }

    public TaxCategoryRepresentation getTaxCategory() {
        return this.taxCategory;
    }

    public void setTaxCategory(TaxCategoryRepresentation taxCategory) {
        this.taxCategory = taxCategory;
    }

    public BigDecimal getTierRatePercent() {
        return this.tierRatePercent;
    }

    public void setTierRatePercent(BigDecimal tierRatePercent) {
        this.tierRatePercent = tierRatePercent;
    }

    public String getTierRange() {
        return this.tierRange;
    }

    public void setTierRange(String tierRange) {
        this.tierRange = tierRange;
    }
}