package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;

/**
 * A class to describe the completion of a specific task in the tendering
 * process.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:40 a. m.
 */
public class CompletedTask {

	/**
	 * The average monetary amount of a task such as this completed task.
	 */
	private BigDecimal annualAverageAmount;
	/**
	 * Text describing this completed task.
	 */
	private String description;
	/**
	 * A monetary amount corresponding to the financial capacity of the party
	 * that carried out this completed task.
	 */
	private BigDecimal partyCapacityAmount;
	/**
	 * The actual total monetary amount of this completed task.
	 */
	private BigDecimal totalTaskAmount;
	private CustomerParty recipientCustomerParty;
	private List<EvidenceSupplied> evidenceSupplieds= new ArrayList<>();
	private List<Period> periods= new ArrayList<>();

	public CompletedTask() {

	}

	public void finalize() throws Throwable {

	}

	public BigDecimal getAnnualAverageAmount() {
		return annualAverageAmount;
	}

	public void setAnnualAverageAmount(BigDecimal annualAverageAmount) {
		this.annualAverageAmount = annualAverageAmount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPartyCapacityAmount() {
		return partyCapacityAmount;
	}

	public void setPartyCapacityAmount(BigDecimal partyCapacityAmount) {
		this.partyCapacityAmount = partyCapacityAmount;
	}

	public BigDecimal getTotalTaskAmount() {
		return totalTaskAmount;
	}

	public void setTotalTaskAmount(BigDecimal totalTaskAmount) {
		this.totalTaskAmount = totalTaskAmount;
	}

	public CustomerParty getRecipientCustomerParty() {
		return recipientCustomerParty;
	}

	public void setRecipientCustomerParty(CustomerParty recipientCustomerParty) {
		this.recipientCustomerParty = recipientCustomerParty;
	}

	public List<EvidenceSupplied> getEvidenceSupplieds() {
		return evidenceSupplieds;
	}

	public void setEvidenceSupplieds(List<EvidenceSupplied> evidenceSupplieds) {
		this.evidenceSupplieds = evidenceSupplieds;
	}

	public List<Period> getPeriods() {
		return periods;
	}

	public void setPeriods(List<Period> periods) {
		this.periods = periods;
	}
}// end Completed Task