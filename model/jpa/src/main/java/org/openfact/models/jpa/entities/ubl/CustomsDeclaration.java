package org.openfact.models.jpa.entities.ubl;


/**
 * A class describing identifiers or references relating to customs procedures.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:17 a. m.
 */
public class CustomsDeclaration {

	/**
	 * An identifier associated with customs related procedures.
	 */
	private String ID;
	private Party Issuer Party;

	public Customs Declaration(){

	}

	public void finalize() throws Throwable {

	}
	public String getID(){
		return ID;
	}

	public Party getIssuer Party(){
		return Issuer Party;
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
	public void setIssuer Party(Party newVal){
		Issuer Party = newVal;
	}
}//end Customs Declaration