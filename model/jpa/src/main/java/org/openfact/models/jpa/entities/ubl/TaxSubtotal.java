package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;

/**
 * A class to define the subtotal for a particular tax category within a
 * particular taxation scheme, such as standard rate within VAT.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:05 a. m.
 */
public class TaxSubtotal {

    /**
     * The unit of measure on which the tax calculation is based
     */
    private BigDecimal BaseUnitMeasure;
    /**
     * The number of this tax subtotal in the sequence of subtotals
     * corresponding to the order in which multiple taxes are applied. If all
     * taxes are applied to the same taxable amount (i.e., their order of
     * application is inconsequential), then CalculationSequenc
     */
    private BigDecimal CalculationSequenceNumeric;
    /**
     * The tax rate of the tax category applied to this tax subtotal, expressed
     * as a percentage.
     */
    private BigDecimal Percent;
    /**
     * Where a tax is applied at a certain rate per unit, the rate per unit
     * applied.
     */
    private BigDecimal PerUnitAmount;
    /**
     * The net amount to which the tax percent (rate) is applied to calculate
     * the tax amount.
     */
    private BigDecimal TaxableAmount;
    /**
     * The amount of this tax subtotal.
     */
    private BigDecimal TaxAmount;
    /**
     * Where a tax is tiered, the range of taxable amounts that determines the
     * rate of tax applicable to this tax subtotal.
     */
    private String TierRange;
    /**
     * Where a tax is tiered, the tax rate that applies within a specified range
     * of taxable amounts for this tax subtotal.
     */
    private BigDecimal TierRatePercent;
    /**
     * The amount of this tax subtotal, expressed in the currency used for
     * invoicing.
     */
    private BigDecimal TransactionCurrencyTaxAmount;
    private TaxCategory m_TaxCategory;

    /**
     * @return the baseUnitMeasure
     */
    public BigDecimal getBaseUnitMeasure() {
        return BaseUnitMeasure;
    }

    /**
     * @param baseUnitMeasure
     *            the baseUnitMeasure to set
     */
    public void setBaseUnitMeasure(BigDecimal baseUnitMeasure) {
        BaseUnitMeasure = baseUnitMeasure;
    }

    /**
     * @return the calculationSequenceNumeric
     */
    public BigDecimal getCalculationSequenceNumeric() {
        return CalculationSequenceNumeric;
    }

    /**
     * @param calculationSequenceNumeric
     *            the calculationSequenceNumeric to set
     */
    public void setCalculationSequenceNumeric(BigDecimal calculationSequenceNumeric) {
        CalculationSequenceNumeric = calculationSequenceNumeric;
    }

    /**
     * @return the percent
     */
    public BigDecimal getPercent() {
        return Percent;
    }

    /**
     * @param percent
     *            the percent to set
     */
    public void setPercent(BigDecimal percent) {
        Percent = percent;
    }

    /**
     * @return the perUnitAmount
     */
    public BigDecimal getPerUnitAmount() {
        return PerUnitAmount;
    }

    /**
     * @param perUnitAmount
     *            the perUnitAmount to set
     */
    public void setPerUnitAmount(BigDecimal perUnitAmount) {
        PerUnitAmount = perUnitAmount;
    }

    /**
     * @return the taxableAmount
     */
    public BigDecimal getTaxableAmount() {
        return TaxableAmount;
    }

    /**
     * @param taxableAmount
     *            the taxableAmount to set
     */
    public void setTaxableAmount(BigDecimal taxableAmount) {
        TaxableAmount = taxableAmount;
    }

    /**
     * @return the taxAmount
     */
    public BigDecimal getTaxAmount() {
        return TaxAmount;
    }

    /**
     * @param taxAmount
     *            the taxAmount to set
     */
    public void setTaxAmount(BigDecimal taxAmount) {
        TaxAmount = taxAmount;
    }

    /**
     * @return the tierRange
     */
    public String getTierRange() {
        return TierRange;
    }

    /**
     * @param tierRange
     *            the tierRange to set
     */
    public void setTierRange(String tierRange) {
        TierRange = tierRange;
    }

    /**
     * @return the tierRatePercent
     */
    public BigDecimal getTierRatePercent() {
        return TierRatePercent;
    }

    /**
     * @param tierRatePercent
     *            the tierRatePercent to set
     */
    public void setTierRatePercent(BigDecimal tierRatePercent) {
        TierRatePercent = tierRatePercent;
    }

    /**
     * @return the transactionCurrencyTaxAmount
     */
    public BigDecimal getTransactionCurrencyTaxAmount() {
        return TransactionCurrencyTaxAmount;
    }

    /**
     * @param transactionCurrencyTaxAmount
     *            the transactionCurrencyTaxAmount to set
     */
    public void setTransactionCurrencyTaxAmount(BigDecimal transactionCurrencyTaxAmount) {
        TransactionCurrencyTaxAmount = transactionCurrencyTaxAmount;
    }

    /**
     * @return the m_TaxCategory
     */
    public TaxCategory getM_TaxCategory() {
        return m_TaxCategory;
    }

    /**
     * @param m_TaxCategory
     *            the m_TaxCategory to set
     */
    public void setM_TaxCategory(TaxCategory m_TaxCategory) {
        this.m_TaxCategory = m_TaxCategory;
    }

}// end TaxSubtotal