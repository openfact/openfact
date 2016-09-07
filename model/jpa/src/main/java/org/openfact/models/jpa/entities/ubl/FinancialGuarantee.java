package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;

/**
 * A class to describe the bond guarantee of a tenderer or bid submitter's
 * actual entry into a contract in the event that it is the successful bidder.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:15:13 a. m.
 */
public class FinancialGuarantee {

	/**
	 * The rate used to calculate the amount of liability in this financial
	 * guarantee.
	 */
	private BigDecimal amountRate;
	/**
	 * Text describing this financial guarantee.
	 */
	private String description;
	/**
	 * A code signifying the type of financial guarantee. For instance
	 * "Provisional Guarantee" or "Final Guarantee"
	 */
	private String guaranteeTypeCode;
	/**
	 * The amount of liability in this financial guarantee.
	 */
	private BigDecimal liabilityAmount;
	private Period constitutionPeriod;

	public FinancialGuarantee() {

	}

	public void finalize() throws Throwable {

	}

	public BigDecimal getAmountRate() {
		return amountRate;
	}

	public void setAmountRate(BigDecimal amountRate) {
		this.amountRate = amountRate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGuaranteeTypeCode() {
		return guaranteeTypeCode;
	}

	public void setGuaranteeTypeCode(String guaranteeTypeCode) {
		this.guaranteeTypeCode = guaranteeTypeCode;
	}

	public BigDecimal getLiabilityAmount() {
		return liabilityAmount;
	}

	public void setLiabilityAmount(BigDecimal liabilityAmount) {
		this.liabilityAmount = liabilityAmount;
	}

	public Period getConstitutionPeriod() {
		return constitutionPeriod;
	}

	public void setConstitutionPeriod(Period constitutionPeriod) {
		this.constitutionPeriod = constitutionPeriod;
	}
}// end FinancialGuarantee