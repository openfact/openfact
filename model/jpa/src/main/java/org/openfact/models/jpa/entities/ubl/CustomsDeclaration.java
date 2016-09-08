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
	private Party issuerParty;

	public CustomsDeclaration() {

	}

	public void finalize() throws Throwable {

	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public Party getIssuerParty() {
		return issuerParty;
	}

	public void setIssuerParty(Party issuerParty) {
		this.issuerParty = issuerParty;
	}
}// end Customs Declaration