package org.openfact.models.jpa.entities.ubl;

/**
 * A class to describe a price list.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:56 a. m.
 */
public class PriceList {

	/**
	 * An identifier for this price list.
	 */
	private String ID;
	/**
	 * A code signifying whether this price list is an original, copy, revision,
	 * or cancellation.
	 */
	private String StatusCode;
	private Period ValidityPeriod;
	private PriceList PreviousPriceList;

	public PriceList() {

	}

	public void finalize() throws Throwable {

	}

	public String getID() {
		return ID;
	}

	public PriceList getPreviousPriceList() {
		return PreviousPriceList;
	}

	public String getStatusCode() {
		return StatusCode;
	}

	public Period getValidityPeriod() {
		return ValidityPeriod;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setID(String newVal) {
		ID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPreviousPriceList(PriceList newVal) {
		PreviousPriceList = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setStatusCode(String newVal) {
		StatusCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setValidityPeriod(Period newVal) {
		ValidityPeriod = newVal;
	}
}// end Price List