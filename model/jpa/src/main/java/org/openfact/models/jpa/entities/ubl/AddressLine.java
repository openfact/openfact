package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to define an unstructured address line.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:12:39 a. m.
 */
public class AddressLine {

	/**
	 * An address line expressed as unstructured text.
	 */
	private String line;

	/**
	 * @return the line
	 */
	public String getLine() {
		return line;
	}

	/**
	 * @param line
	 *            the line to set
	 */
	public void setLine(String line) {
		this.line = line;
	}

}