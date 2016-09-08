package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;

/**
 * A class to describe possible extensions to a contract.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:03 a. m.
 */
public class ContractExtension {

	/**
	 * The maximum allowed number of contract extensions.
	 */
	private BigDecimal maximumNumberNumeric;
	/**
	 * The fixed minimum number of contract extensions or renewals.
	 */
	private BigDecimal minimumNumberNumeric;
	/**
	 * A description for the possible options that can be carried out during the
	 * execution of the contract.
	 */
	private String optionsDescription;
	private Period optionValidityPeriod;
	private List<Renewal> renewals= new ArrayList<>();

	public ContractExtension() {

	}

	public void finalize() throws Throwable {

	}

	public BigDecimal getMaximumNumberNumeric() {
		return maximumNumberNumeric;
	}

	public void setMaximumNumberNumeric(BigDecimal maximumNumberNumeric) {
		this.maximumNumberNumeric = maximumNumberNumeric;
	}

	public BigDecimal getMinimumNumberNumeric() {
		return minimumNumberNumeric;
	}

	public void setMinimumNumberNumeric(BigDecimal minimumNumberNumeric) {
		this.minimumNumberNumeric = minimumNumberNumeric;
	}

	public String getOptionsDescription() {
		return optionsDescription;
	}

	public void setOptionsDescription(String optionsDescription) {
		this.optionsDescription = optionsDescription;
	}

	public Period getOptionValidityPeriod() {
		return optionValidityPeriod;
	}

	public void setOptionValidityPeriod(Period optionValidityPeriod) {
		this.optionValidityPeriod = optionValidityPeriod;
	}

	public List<Renewal> getRenewals() {
		return renewals;
	}

	public void setRenewals(List<Renewal> renewals) {
		this.renewals = renewals;
	}
}// end Contract Extension