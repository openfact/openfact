package org.openfact.representations.idm.ubl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.MeasureRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A class to define the subtotal for a particular tax category within a
 * particular taxation scheme, such as standard rate within VAT.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:05 a. m.
 */
public class TaxSubtotalRepresentation {

    /**
     * The unit of measure on which the tax calculation is based
     */
    private MeasureRepresentation baseUnitMeasure;
    /**
     * The number of this tax subtotal in the sequence of subtotals
     * corresponding to the order in which multiple taxes are applied. If all
     * taxes are applied to the same taxable amount (i.e., their order of
     * application is inconsequential), then CalculationSequenc
     */
    private BigDecimal calculationSequenceNumeric;
    /**
     * The tax rate of the tax category applied to this tax subtotal, expressed
     * as a percentage.
     */
    private BigDecimal percent;
    /**
     * Where a tax is applied at a certain rate per unit, the rate per unit
     * applied.
     */
    private BigDecimal perUnitAmount;
    /**
     * The net amount to which the tax percent (rate) is applied to calculate
     * the tax amount.
     */
    private BigDecimal taxableAmount;
    /**
     * The amount of this tax subtotal.
     */
    private BigDecimal taxAmount;
    /**
     * Where a tax is tiered, the range of taxable amounts that determines the
     * rate of tax applicable to this tax subtotal.
     */
    private TextRepresentation tierRange;
    /**
     * Where a tax is tiered, the tax rate that applies within a specified range
     * of taxable amounts for this tax subtotal.
     */
    private BigDecimal tierRatePercent;
    /**
     * The amount of this tax subtotal, expressed in the currency used for
     * invoicing.
     */
    private BigDecimal transactionCurrencyTaxAmount;
    private TaxCategoryRepresentation taxCategory;

    /**
     * @return the baseUnitMeasure
     */
    public MeasureRepresentation getBaseUnitMeasure() {
        return baseUnitMeasure;
    }

    /**
     * @param baseUnitMeasure
     *            the baseUnitMeasure to set
     */
    public void setBaseUnitMeasure(MeasureRepresentation baseUnitMeasure) {
        this.baseUnitMeasure = baseUnitMeasure;
    }

    /**
     * @return the calculationSequenceNumeric
     */
    public BigDecimal getCalculationSequenceNumeric() {
        return calculationSequenceNumeric;
    }

    /**
     * @param calculationSequenceNumeric
     *            the calculationSequenceNumeric to set
     */
    public void setCalculationSequenceNumeric(BigDecimal calculationSequenceNumeric) {
        this.calculationSequenceNumeric = calculationSequenceNumeric;
    }

    /**
     * @return the percent
     */
    public BigDecimal getPercent() {
        return percent;
    }

    /**
     * @param percent
     *            the percent to set
     */
    public void setPercent(BigDecimal percent) {
        this.percent = percent;
    }

    /**
     * @return the perUnitAmount
     */
    public BigDecimal getPerUnitAmount() {
        return perUnitAmount;
    }

    /**
     * @param perUnitAmount
     *            the perUnitAmount to set
     */
    public void setPerUnitAmount(BigDecimal perUnitAmount) {
        this.perUnitAmount = perUnitAmount;
    }

    /**
     * @return the taxableAmount
     */
    public BigDecimal getTaxableAmount() {
        return taxableAmount;
    }

    /**
     * @param taxableAmount
     *            the taxableAmount to set
     */
    public void setTaxableAmount(BigDecimal taxableAmount) {
        this.taxableAmount = taxableAmount;
    }

    /**
     * @return the taxAmount
     */
    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    /**
     * @param taxAmount
     *            the taxAmount to set
     */
    public void setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
    }

    /**
     * @return the tierRange
     */
    public TextRepresentation getTierRange() {
        return tierRange;
    }

    /**
     * @param tierRange
     *            the tierRange to set
     */
    public void setTierRange(TextRepresentation tierRange) {
        this.tierRange = tierRange;
    }

    /**
     * @return the tierRatePercent
     */
    public BigDecimal getTierRatePercent() {
        return tierRatePercent;
    }

    /**
     * @param tierRatePercent
     *            the tierRatePercent to set
     */
    public void setTierRatePercent(BigDecimal tierRatePercent) {
        this.tierRatePercent = tierRatePercent;
    }

    /**
     * @return the transactionCurrencyTaxAmount
     */
    public BigDecimal getTransactionCurrencyTaxAmount() {
        return transactionCurrencyTaxAmount;
    }

    /**
     * @param transactionCurrencyTaxAmount
     *            the transactionCurrencyTaxAmount to set
     */
    public void setTransactionCurrencyTaxAmount(BigDecimal transactionCurrencyTaxAmount) {
        this.transactionCurrencyTaxAmount = transactionCurrencyTaxAmount;
    }

    /**
     * @return the taxCategory
     */
    public TaxCategoryRepresentation getTaxCategory() {
        return taxCategory;
    }

    /**
     * @param taxCategory
     *            the taxCategory to set
     */
    public void setTaxCategory(TaxCategoryRepresentation taxCategory) {
        this.taxCategory = taxCategory;
    }

}
