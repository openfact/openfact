package org.openfact.representations.idm.ubl;

import java.math.BigDecimal;

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
     * The net amount to which the tax percent (rate) is applied to calculate
     * the tax amount.
     */
    private BigDecimal taxableAmount;
    /**
     * The amount of this tax subtotal.
     */
    private BigDecimal taxAmount;

    private TaxCategoryRepresentation taxCategory;
    
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
     * @return the taxCategory
     */
    public TaxCategoryRepresentation getTaxCategory() {
        return taxCategory;
    }

    /**
     * @param taxCategory the taxCategory to set
     */
    public void setTaxCategory(TaxCategoryRepresentation taxCategory) {
        this.taxCategory = taxCategory;
    }

}
