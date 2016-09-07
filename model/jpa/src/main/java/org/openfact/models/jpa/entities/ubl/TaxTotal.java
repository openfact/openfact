package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;

/**
 * A class to describe the total tax for a particular taxation scheme.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:07 a. m.
 */
public class TaxTotal {

    /**
     * The rounding amount (positive or negative) added to the calculated tax
     * total to produce the rounded TaxAmount.
     */
    private BigDecimal roundingAmount;
    /**
     * The total tax amount for a particular taxation scheme, e.g., VAT; the sum
     * of the tax subtotals for each tax category within the taxation scheme.
     */
    private BigDecimal taxAmount;
    /**
     * An indicator that this total is recognized as legal evidence for taxation
     * purposes (true) or not (false).
     */
    private boolean taxEvidenceIndicator;
    /**
     * An indicator that tax is included in the calculation (true) or not
     * (false).
     */
    private boolean taxIncludedIndicator;
    private TaxSubtotal m_TaxSubtotal;

    /**
     * @return the roundingAmount
     */
    public BigDecimal getRoundingAmount() {
        return roundingAmount;
    }

    /**
     * @param roundingAmount
     *            the roundingAmount to set
     */
    public void setRoundingAmount(BigDecimal roundingAmount) {
        this.roundingAmount = roundingAmount;
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
     * @return the taxEvidenceIndicator
     */
    public boolean isTaxEvidenceIndicator() {
        return taxEvidenceIndicator;
    }

    /**
     * @param taxEvidenceIndicator
     *            the taxEvidenceIndicator to set
     */
    public void setTaxEvidenceIndicator(boolean taxEvidenceIndicator) {
        this.taxEvidenceIndicator = taxEvidenceIndicator;
    }

    /**
     * @return the taxIncludedIndicator
     */
    public boolean isTaxIncludedIndicator() {
        return taxIncludedIndicator;
    }

    /**
     * @param taxIncludedIndicator
     *            the taxIncludedIndicator to set
     */
    public void setTaxIncludedIndicator(boolean taxIncludedIndicator) {
        this.taxIncludedIndicator = taxIncludedIndicator;
    }

    /**
     * @return the m_TaxSubtotal
     */
    public TaxSubtotal getM_TaxSubtotal() {
        return m_TaxSubtotal;
    }

    /**
     * @param m_TaxSubtotal
     *            the m_TaxSubtotal to set
     */
    public void setM_TaxSubtotal(TaxSubtotal m_TaxSubtotal) {
        this.m_TaxSubtotal = m_TaxSubtotal;
    }

}