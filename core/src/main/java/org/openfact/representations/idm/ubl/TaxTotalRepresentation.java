package org.openfact.representations.idm.ubl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * A class to describe the total tax for a particular taxation scheme.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:07 a. m.
 */
public class TaxTotalRepresentation {

    /**
     * The total tax amount for a particular taxation scheme, e.g., VAT; the sum
     * of the tax subtotals for each tax category within the taxation scheme.
     */
    private BigDecimal taxAmount;

    private Boolean taxIncludedIndicator;
    private List<TaxSubtotalRepresentation> taxSubtotals;

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
     * @return the taxIncludedIndicator
     */
    public Boolean getTaxIncludedIndicator() {
        return taxIncludedIndicator;
    }

    /**
     * @param taxIncludedIndicator
     *            the taxIncludedIndicator to set
     */
    public void setTaxIncludedIndicator(Boolean taxIncludedIndicator) {
        this.taxIncludedIndicator = taxIncludedIndicator;
    }

    /**
     * @return the taxSubtotals
     */
    public List<TaxSubtotalRepresentation> getTaxSubtotals() {
        return taxSubtotals;
    }

    /**
     * @param taxSubtotals
     *            the taxSubtotals to set
     */
    public void setTaxSubtotals(List<TaxSubtotalRepresentation> taxSubtotals) {
        this.taxSubtotals = taxSubtotals;
    }

}
