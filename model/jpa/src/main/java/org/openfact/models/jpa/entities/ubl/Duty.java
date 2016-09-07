package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;

/**
 * The charging rate used for both call charging and time dependent charging
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:38 a. m.
 */
public class Duty {

	/**
	 * The amount of this duty.
	 */
	private BigDecimal amount;
	/**
	 * Text describing this duty.
	 */
	private String duty;
	/**
	 * The type of this charge rate, expressed as a code.
	 */
	private String dutyCode;
	private List<TaxCategory> taxCategories=new ArrayList<>();

	public Duty() {

	}

	public void finalize() throws Throwable {

	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public String getDutyCode() {
		return dutyCode;
	}

	public void setDutyCode(String dutyCode) {
		this.dutyCode = dutyCode;
	}

	public List<TaxCategory> getTaxCategories() {
		return taxCategories;
	}

	public void setTaxCategories(List<TaxCategory> taxCategories) {
		this.taxCategories = taxCategories;
	}
}// end Duty