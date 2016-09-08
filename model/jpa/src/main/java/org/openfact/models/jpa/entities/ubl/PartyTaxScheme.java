package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to describe a taxation scheme applying to a party.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:31 a. m.
 */
public class PartyTaxScheme {

	/**
	 * An identifier for the party assigned for tax purposes by the taxation
	 * authority.
	 */
	private String companyID;
	/**
	 * A reason for the party's exemption from tax, expressed as text.
	 */
	private String exemptionReason;
	/**
	 * A reason for the party's exemption from tax, expressed as a code.
	 */
	private String exemptionReasonCode;
	/**
	 * The name of the party as registered with the relevant fiscal authority.
	 */
	private String registrationName;
	/**
	 * A code signifying the tax level applicable to the party within this
	 * taxation scheme.
	 */
	private String taxLevelCode;
	private Address registrationAddress;
	private List<TaxScheme> taxSchemes = new ArrayList<>();

	public PartyTaxScheme() {

	}

	public void finalize() throws Throwable {

	}

	public String getCompanyID() {
		return companyID;
	}

	public void setCompanyID(String companyID) {
		this.companyID = companyID;
	}

	public String getExemptionReason() {
		return exemptionReason;
	}

	public void setExemptionReason(String exemptionReason) {
		this.exemptionReason = exemptionReason;
	}

	public String getExemptionReasonCode() {
		return exemptionReasonCode;
	}

	public void setExemptionReasonCode(String exemptionReasonCode) {
		this.exemptionReasonCode = exemptionReasonCode;
	}

	public String getRegistrationName() {
		return registrationName;
	}

	public void setRegistrationName(String registrationName) {
		this.registrationName = registrationName;
	}

	public String getTaxLevelCode() {
		return taxLevelCode;
	}

	public void setTaxLevelCode(String taxLevelCode) {
		this.taxLevelCode = taxLevelCode;
	}

	public Address getRegistrationAddress() {
		return registrationAddress;
	}

	public void setRegistrationAddress(Address registrationAddress) {
		this.registrationAddress = registrationAddress;
	}

	public List<TaxScheme> getTaxSchemes() {
		return taxSchemes;
	}

	public void setTaxSchemes(List<TaxScheme> taxSchemes) {
		this.taxSchemes = taxSchemes;
	}
}// end Party Tax Scheme