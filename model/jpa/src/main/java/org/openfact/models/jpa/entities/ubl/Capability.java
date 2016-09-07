package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

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
	private String capabilityTypeCode;
	/**
	 * Text describing this capability.
	 */
	private String description;
	/**
	 * A monetary amount as a measure of this capability.
	 */
	private BigDecimal valueAmount;
	/**
	 * A quantity as a measure of this capability.
	 */
	private BigDecimal valueQuantity;
	private List<EvidenceSupplied> evidenceSupplieds= new ArrayList<>();
	private Period validityPeriod;

	public Capability() {

	}

	public void finalize() throws Throwable {

	}

	public String getCapabilityTypeCode() {
		return capabilityTypeCode;
	}

	public void setCapabilityTypeCode(String capabilityTypeCode) {
		this.capabilityTypeCode = capabilityTypeCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getValueAmount() {
		return valueAmount;
	}

	public void setValueAmount(BigDecimal valueAmount) {
		this.valueAmount = valueAmount;
	}

	public BigDecimal getValueQuantity() {
		return valueQuantity;
	}

	public void setValueQuantity(BigDecimal valueQuantity) {
		this.valueQuantity = valueQuantity;
	}

	public List<EvidenceSupplied> getEvidenceSupplieds() {
		return evidenceSupplieds;
	}

	public void setEvidenceSupplieds(List<EvidenceSupplied> evidenceSupplieds) {
		this.evidenceSupplieds = evidenceSupplieds;
	}

	public Period getValidityPeriod() {
		return validityPeriod;
	}

	public void setValidityPeriod(Period validityPeriod) {
		this.validityPeriod = validityPeriod;
	}
}// end Capability