package org.openfact.representations.idm.ubl;

import java.math.BigDecimal;

/**
 * A class to describe one of the tax categories within a taxation scheme (e.g.,
 * High Rate VAT, Low Rate VAT).
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:02 a. m.
 */
public class TaxCategoryRepresentation {

    /**
     * The reason for tax being exempted, expressed as a code.
     */
    private String taxExemptionReasonCode;

    private TaxSchemeRepresentation taxScheme;

    private String tierRange;
    
    /**
     * @return the taxExemptionReasonCode
     */
    public String getTaxExemptionReasonCode() {
        return taxExemptionReasonCode;
    }

    /**
     * @param taxExemptionReasonCode
     *            the taxExemptionReasonCode to set
     */
    public void setTaxExemptionReasonCode(String taxExemptionReasonCode) {
        this.taxExemptionReasonCode = taxExemptionReasonCode;
    }

    /**
     * @return the taxScheme
     */
    public TaxSchemeRepresentation getTaxScheme() {
        return taxScheme;
    }

    /**
     * @param taxScheme
     *            the taxScheme to set
     */
    public void setTaxScheme(TaxSchemeRepresentation taxScheme) {
        this.taxScheme = taxScheme;
    }

    /**
     * @return the tierRange
     */
    public String getTierRange() {
        return tierRange;
    }

    /**
     * @param tierRange the tierRange to set
     */
    public void setTierRange(String tierRange) {
        this.tierRange = tierRange;
    }

}
