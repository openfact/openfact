package org.openfact.models.jpa.entities.ubl;

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
	private BigDecimal MaximumNumberNumeric;
	/**
	 * The fixed minimum number of contract extensions or renewals.
	 */
	private BigDecimal MinimumNumberNumeric;
	/**
	 * A description for the possible options that can be carried out during the
	 * execution of the contract.
	 */
	private String OptionsDescription;
	private Period OptionValidityPeriod;
	private Renewal m_Renewal;

	public ContractExtension() {

	}

	public void finalize() throws Throwable {

	}

	public BigDecimal getMaximumNumberNumeric() {
		return MaximumNumberNumeric;
	}

	public BigDecimal getMinimumNumberNumeric() {
		return MinimumNumberNumeric;
	}

	public Period getOptionValidityPeriod() {
		return OptionValidityPeriod;
	}

	public String getOptionsDescription() {
		return OptionsDescription;
	}

	public Renewal getRenewal() {
		return m_Renewal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMaximumNumberNumeric(BigDecimal newVal) {
		MaximumNumberNumeric = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMinimumNumberNumeric(BigDecimal newVal) {
		MinimumNumberNumeric = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setOptionValidityPeriod(Period newVal) {
		OptionValidityPeriod = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setOptionsDescription(String newVal) {
		OptionsDescription = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRenewal(Renewal newVal) {
		m_Renewal = newVal;
	}
}// end Contract Extension