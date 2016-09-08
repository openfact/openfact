package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to define a clause (a distinct article or provision) in a contract,
 * treaty, will, or other formal or legal written document requiring compliance.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:35 a. m.
 */
public class Clause {

	/**
	 * The text of this clause.
	 */
	private String content;
	/**
	 * An identifier for this clause.
	 */
	private String ID;

	public Clause() {

	}

	public void finalize() throws Throwable {

	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}
}// end Clause