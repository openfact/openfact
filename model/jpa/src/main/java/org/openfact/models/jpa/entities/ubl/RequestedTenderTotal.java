package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;

/**
 * A class defining budgeted monetary amounts.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:31 a. m.
 */
public class RequestedTenderTotal {

    /**
     * The average monetary amount for the subsequent contracts following this
     * budget amount.
     */
    private BigDecimal AverageSubsequentContractAmount;
    /**
     * The estimated overall monetary amount of a contract.
     */
    private BigDecimal EstimatedOverallContractAmount;
    /**
     * The maximum monetary amount of the budget.
     */
    private BigDecimal MaximumAmount;
    /**
     * The minimum monetary amount of the budget.
     */
    private BigDecimal MinimumAmount;
    /**
     * A description of the monetary scope of the budget.
     */
    private String MonetaryScope;
    /**
     * Indicates whether the amounts are taxes included (true) or not (false).
     */
    private boolean TaxIncludedIndicator;
    /**
     * The monetary amount of the total budget including net amount, taxes, and
     * material and instalment costs.
     */
    private BigDecimal TotalAmount;
    private TaxCategory ApplicableTaxCategory;

    /**
     * @return the averageSubsequentContractAmount
     */
    public BigDecimal getAverageSubsequentContractAmount() {
        return AverageSubsequentContractAmount;
    }

    /**
     * @param averageSubsequentContractAmount
     *            the averageSubsequentContractAmount to set
     */
    public void setAverageSubsequentContractAmount(BigDecimal averageSubsequentContractAmount) {
        AverageSubsequentContractAmount = averageSubsequentContractAmount;
    }

    /**
     * @return the estimatedOverallContractAmount
     */
    public BigDecimal getEstimatedOverallContractAmount() {
        return EstimatedOverallContractAmount;
    }

    /**
     * @param estimatedOverallContractAmount
     *            the estimatedOverallContractAmount to set
     */
    public void setEstimatedOverallContractAmount(BigDecimal estimatedOverallContractAmount) {
        EstimatedOverallContractAmount = estimatedOverallContractAmount;
    }

    /**
     * @return the maximumAmount
     */
    public BigDecimal getMaximumAmount() {
        return MaximumAmount;
    }

    /**
     * @param maximumAmount
     *            the maximumAmount to set
     */
    public void setMaximumAmount(BigDecimal maximumAmount) {
        MaximumAmount = maximumAmount;
    }

    /**
     * @return the minimumAmount
     */
    public BigDecimal getMinimumAmount() {
        return MinimumAmount;
    }

    /**
     * @param minimumAmount
     *            the minimumAmount to set
     */
    public void setMinimumAmount(BigDecimal minimumAmount) {
        MinimumAmount = minimumAmount;
    }

    /**
     * @return the monetaryScope
     */
    public String getMonetaryScope() {
        return MonetaryScope;
    }

    /**
     * @param monetaryScope
     *            the monetaryScope to set
     */
    public void setMonetaryScope(String monetaryScope) {
        MonetaryScope = monetaryScope;
    }

    /**
     * @return the taxIncludedIndicator
     */
    public boolean isTaxIncludedIndicator() {
        return TaxIncludedIndicator;
    }

    /**
     * @param taxIncludedIndicator
     *            the taxIncludedIndicator to set
     */
    public void setTaxIncludedIndicator(boolean taxIncludedIndicator) {
        TaxIncludedIndicator = taxIncludedIndicator;
    }

    /**
     * @return the totalAmount
     */
    public BigDecimal getTotalAmount() {
        return TotalAmount;
    }

    /**
     * @param totalAmount
     *            the totalAmount to set
     */
    public void setTotalAmount(BigDecimal totalAmount) {
        TotalAmount = totalAmount;
    }

    /**
     * @return the applicableTaxCategory
     */
    public TaxCategory getApplicableTaxCategory() {
        return ApplicableTaxCategory;
    }

    /**
     * @param applicableTaxCategory
     *            the applicableTaxCategory to set
     */
    public void setApplicableTaxCategory(TaxCategory applicableTaxCategory) {
        ApplicableTaxCategory = applicableTaxCategory;
    }

}// end Requested Tender Total