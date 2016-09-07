package org.openfact.models.jpa.entities.ubl;


/**
 * A class to describe a price list.
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
	 * A code signifying whether this price list is an original, copy, revision, or
	 * cancellation.
	 */
	private String StatusCode;
	private Period Validity Period;
	private Price List Previous Price List;

	public Price List(){

	}

	public void finalize() throws Throwable {

	}
	public String getID(){
		return ID;
	}

	public Price List getPrevious Price List(){
		return Previous Price List;
	}

	public String getStatusCode(){
		return StatusCode;
	}

	public Period getValidity Period(){
		return Validity Period;
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
	public void setPrevious Price List(Price List newVal){
		Previous Price List = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setStatusCode(String newVal){
		StatusCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setValidity Period(Period newVal){
		Validity Period = newVal;
	}
}//end Price List