package org.openfact.models.jpa.entities.ubl;


/**
 * A class to describe a taxation scheme (e.g., VAT, State tax, County tax).
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:04 a. m.
 */
public class TaxScheme {

	/**
	 * A code signifying the currency in which the tax is collected and reported.
	 */
	private Currency_ String CurrencyCode;
	/**
	 * An identifier for this taxation scheme.
	 */
	private String ID;
	/**
	 * The name of this taxation scheme.
	 */
	private String Name;
	/**
	 * A code signifying the type of tax.
	 */
	private String TaxTypeCode;
	private Address Jurisdiction Region Address;

	public Tax Scheme(){

	}

	public void finalize() throws Throwable {

	}
	public Currency_ String getCurrencyCode(){
		return CurrencyCode;
	}

	public String getID(){
		return ID;
	}

	public Address getJurisdiction Region Address(){
		return Jurisdiction Region Address;
	}

	public String getName(){
		return Name;
	}

	public String getTaxTypeCode(){
		return TaxTypeCode;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCurrencyCode(Currency_ String newVal){
		CurrencyCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setID(String newVal){
		ID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setJurisdiction Region Address(Address newVal){
		Jurisdiction Region Address = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setName(String newVal){
		Name = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTaxTypeCode(String newVal){
		TaxTypeCode = newVal;
	}
}//end Tax Scheme