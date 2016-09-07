package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

/**
 * A class describing identifiers or references relating to customs procedures.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:17 a. m.
 */
public class CustomsDeclaration {

	/**
	 * An identifier associated with customs related procedures.
	 */
	private String ID;
	private Party IssuerParty;

	public CustomsDeclaration() {

	}

	public void finalize() throws Throwable {

	}

	public String getID() {
		return ID;
	}

	public Party getIssuerParty() {
		return IssuerParty;
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
	public void setIssuerParty(Party newVal) {
		IssuerParty = newVal;
	}
}// end Customs Declaration