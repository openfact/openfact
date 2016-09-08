package org.openfact.models.jpa.entities.ubl;

import org.openfact.models.jpa.entities.ublType.TextType;

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
	private TextType line;

	public AddressLine() {
	}

	public TextType getLine() {
		return line;
	}

	public void setLine(TextType line) {
		this.line = line;
	}
}