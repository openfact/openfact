package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;

/**
 * A class to describe subcontract terms for a tendering process.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:55 a. m.
 */
public class SubcontractTerms {

    /**
     * The monetary amount assigned to the subcontracted task.
     */
    private BigDecimal Amount;
    /**
     * Text describing the subcontract terms.
     */
    private String Description;
    /**
     * The maximum percentage allowed to be subcontracted.
     */
    private BigDecimal MaximumPercent;
    /**
     * The minimum percentage allowed to be subcontracted.
     */
    private BigDecimal MinimumPercent;
    /**
     * MF: I agree with the query. Rate?
     */
    private BigDecimal Rate;
    /**
     * A code specifying the conditions for subcontracting.
     */
    private String SubcontractingConditionsCode;
    /**
     * An indicator that the subcontract price is known (true) or not (false).
     */
    private boolean UnknownPriceIndicator;

    public SubcontractTerms() {

    }

    public void finalize() throws Throwable {

    }

    public BigDecimal getAmount() {
        return Amount;
    }

    public String getDescription() {
        return Description;
    }

    public BigDecimal getMaximumPercent() {
        return MaximumPercent;
    }

    public BigDecimal getMinimumPercent() {
        return MinimumPercent;
    }

    public BigDecimal getRate() {
        return Rate;
    }

    public String getSubcontractingConditionsCode() {
        return SubcontractingConditionsCode;
    }

    public boolean getUnknownPriceIndicator() {
        return UnknownPriceIndicator;
    }

    /**
     * 
     * @param newVal
     */
    public void setAmount(BigDecimal newVal) {
        Amount = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setDescription(String newVal) {
        Description = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setMaximumPercent(BigDecimal newVal) {
        MaximumPercent = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setMinimumPercent(BigDecimal newVal) {
        MinimumPercent = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setRate(BigDecimal newVal) {
        Rate = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setSubcontractingConditionsCode(String newVal) {
        SubcontractingConditionsCode = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setUnknownPriceIndicator(boolean newVal) {
        UnknownPriceIndicator = newVal;
    }
}// end Subcontract Terms