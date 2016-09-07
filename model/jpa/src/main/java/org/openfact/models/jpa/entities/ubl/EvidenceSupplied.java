package org.openfact.models.jpa.entities.ubl;


/**
 * A reference to evidence.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:15:02 a. m.
 */
public class EvidenceSupplied {

	/**
	 * The identifier of the referenced evidence.
	 */
	private String ID;

	public EvidenceSupplied(){

	}

	public void finalize() throws Throwable {

	}
	public String getID(){
		return ID;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setID(String newVal){
		ID = newVal;
	}
}//end Evidence Supplied