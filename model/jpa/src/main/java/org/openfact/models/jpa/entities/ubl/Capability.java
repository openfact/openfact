package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;

/**
 * A class to describe a specific capability of an organization.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:15 a. m.
 */
public class Capability {

	/**
	 * This class can be used as Financial or Technical capabilities. For
	 * instance, "Turnover" or "Qualified Engineers" are two possible codes.
	 */
	private String CapabilityTypeCode;
	/**
	 * Text describing this capability.
	 */
	private String Description;
	/**
	 * A monetary amount as a measure of this capability.
	 */
	private BigDecimal ValueAmount;
	/**
	 * A quantity as a measure of this capability.
	 */
	private BigDecimal ValueQuantity;
	private EvidenceSupplied m_EvidenceSupplied;
	private Period ValidityPeriod;

	public Capability() {

	}

	public void finalize() throws Throwable {

	}

	public String getCapabilityTypeCode() {
		return CapabilityTypeCode;
	}

	public String getDescription() {
		return Description;
	}

	public EvidenceSupplied getEvidenceSupplied() {
		return m_EvidenceSupplied;
	}

	public Period getValidityPeriod() {
		return ValidityPeriod;
	}

	public BigDecimal getValueAmount() {
		return ValueAmount;
	}

	public BigDecimal getValueQuantity() {
		return ValueQuantity;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCapabilityTypeCode(String newVal) {
		CapabilityTypeCode = newVal;
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
	public void setEvidenceSupplied(EvidenceSupplied newVal) {
		m_EvidenceSupplied = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setValidityPeriod(Period newVal) {
		ValidityPeriod = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setValueAmount(BigDecimal newVal) {
		ValueAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setValueQuantity(BigDecimal newVal) {
		ValueQuantity = newVal;
	}
}// end Capability