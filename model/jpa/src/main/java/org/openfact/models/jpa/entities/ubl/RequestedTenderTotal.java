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

	public RequestedTenderTotal() {

	}

	public void finalize() throws Throwable {

	}

	public TaxCategory getApplicableTaxCategory() {
		return ApplicableTaxCategory;
	}

	public BigDecimal getAverageSubsequentContractAmount() {
		return AverageSubsequentContractAmount;
	}

	public BigDecimal getEstimatedOverallContractAmount() {
		return EstimatedOverallContractAmount;
	}

	public BigDecimal getMaximumAmount() {
		return MaximumAmount;
	}

	public BigDecimal getMinimumAmount() {
		return MinimumAmount;
	}

	public String getMonetaryScope() {
		return MonetaryScope;
	}

	public boolean getTaxIncludedIndicator() {
		return TaxIncludedIndicator;
	}

	public BigDecimal getTotalAmount() {
		return TotalAmount;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setApplicableTaxCategory(TaxCategory newVal) {
		ApplicableTaxCategory = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAverageSubsequentContractAmount(BigDecimal newVal) {
		AverageSubsequentContractAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setEstimatedOverallContractAmount(BigDecimal newVal) {
		EstimatedOverallContractAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMaximumAmount(BigDecimal newVal) {
		MaximumAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMinimumAmount(BigDecimal newVal) {
		MinimumAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMonetaryScope(String newVal) {
		MonetaryScope = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTaxIncludedIndicator(boolean newVal) {
		TaxIncludedIndicator = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTotalAmount(BigDecimal newVal) {
		TotalAmount = newVal;
	}
}// end Requested Tender Total