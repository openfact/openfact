package org.openfact.models.jpa.entities.ubl;

import org.openfact.models.jpa.entities.ublType.AmountType;
import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.QuantityType;
import org.openfact.models.jpa.entities.ublType.TextType;

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
	private CodeType capabilityTypeCode;
	/**
	 * Text describing this capability.
	 */
	private TextType description;
	/**
	 * A monetary amount as a measure of this capability.
	 */
	private AmountType valueAmount;
	/**
	 * A quantity as a measure of this capability.
	 */
	private QuantityType valueQuantity;
	private List<EvidenceSupplied> evidenceSupplieds= new ArrayList<>();
	private Period validityPeriod;

	public Capability() {

	}

	public void finalize() throws Throwable {

	}

	public CodeType getCapabilityTypeCode() {
		return capabilityTypeCode;
	}

	public void setCapabilityTypeCode(CodeType capabilityTypeCode) {
		this.capabilityTypeCode = capabilityTypeCode;
	}

	public TextType getDescription() {
		return description;
	}

	public void setDescription(TextType description) {
		this.description = description;
	}

	public AmountType getValueAmount() {
		return valueAmount;
	}

	public void setValueAmount(AmountType valueAmount) {
		this.valueAmount = valueAmount;
	}

	public QuantityType getValueQuantity() {
		return valueQuantity;
	}

	public void setValueQuantity(QuantityType valueQuantity) {
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