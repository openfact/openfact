package org.openfact.models.jpa.entities.ubl;


/**
 * A class for describing the terms of a trade agreement.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:33 a. m.
 */
public class TradingTerms {

	/**
	 * Text describing the terms of a trade agreement.
	 */
	private Text. Type Information;
	/**
	 * A reference quoting the basis of the terms
	 */
	private Text. Type Reference;
	private Address Applicable Address;

	public Trading Terms(){

	}

	public void finalize() throws Throwable {

	}
	public Address getApplicable Address(){
		return Applicable Address;
	}

	public Text. Type getInformation(){
		return Information;
	}

	public Text. Type getReference(){
		return Reference;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setApplicable Address(Address newVal){
		Applicable Address = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setInformation(Text. Type newVal){
		Information = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setReference(Text. Type newVal){
		Reference = newVal;
	}
}//end Trading Terms