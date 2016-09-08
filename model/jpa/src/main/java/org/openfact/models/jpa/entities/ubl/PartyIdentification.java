package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to define an identifier for a party.
 * 
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:16:26 a. m.
 */
public class PartyIdentification {

	/**
	 * An identifier for the party.
	 */
	private String id;

	public PartyIdentification() {

	}

	public void finalize() throws Throwable {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}