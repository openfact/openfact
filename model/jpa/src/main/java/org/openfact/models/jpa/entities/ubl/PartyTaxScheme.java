package org.openfact.models.jpa.entities.ubl;


/**
 * A class to describe a taxation scheme applying to a party.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:31 a. m.
 */
public class PartyTaxScheme {

	/**
	 * An identifier for the party assigned for tax purposes by the taxation authority.
	 */
	private String CompanyID;
	/**
	 * A reason for the party's exemption from tax, expressed as text.
	 */
	private String ExemptionReason;
	/**
	 * A reason for the party's exemption from tax, expressed as a code.
	 */
	private String ExemptionReasonCode;
	/**
	 * The name of the party as registered with the relevant fiscal authority.
	 */
	private String RegistrationName;
	/**
	 * A code signifying the tax level applicable to the party within this taxation
	 * scheme.
	 */
	private String TaxLevelCode;
	private Address Registration Address;
	private Tax Scheme m_Tax Scheme;

	public Party Tax Scheme(){

	}

	public void finalize() throws Throwable {

	}
	public String getCompanyID(){
		return CompanyID;
	}

	public String getExemptionReason(){
		return ExemptionReason;
	}

	public String getExemptionReasonCode(){
		return ExemptionReasonCode;
	}

	public Address getRegistration Address(){
		return Registration Address;
	}

	public String getRegistrationName(){
		return RegistrationName;
	}

	public Tax Scheme getTax Scheme(){
		return m_Tax Scheme;
	}

	public String getTaxLevelCode(){
		return TaxLevelCode;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCompanyID(String newVal){
		CompanyID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setExemptionReason(String newVal){
		ExemptionReason = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setExemptionReasonCode(String newVal){
		ExemptionReasonCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRegistration Address(Address newVal){
		Registration Address = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRegistrationName(String newVal){
		RegistrationName = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTax Scheme(Tax Scheme newVal){
		m_Tax Scheme = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTaxLevelCode(String newVal){
		TaxLevelCode = newVal;
	}
}//end Party Tax Scheme