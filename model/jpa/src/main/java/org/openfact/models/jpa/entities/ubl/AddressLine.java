package org.openfact.models.jpa.entities.ubl;


/**
 * A class to define an unstructured address line.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:12:39 a. m.
 */
public class AddressLine {

	/**
	 * An address line expressed as unstructured text.
	 */
	private String Line;

	public Address Line(){

	}

	public void finalize() throws Throwable {

	}
	public String getLine(){
		return Line;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLine(String newVal){
		Line = newVal;
	}
}//end Address Line