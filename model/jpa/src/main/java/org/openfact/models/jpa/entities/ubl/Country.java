package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to describe a country.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:11 a. m.
 */
public class Country {

	/**
	 * A code signifying this country.
	 */
	private String IdentificationCode;
	/**
	 * The name of this country.
	 */
	private String name;

	public Country() {

	}

	public void finalize() throws Throwable {

	}

	public String getIdentificationCode() {
		return IdentificationCode;
	}

	public void setIdentificationCode(String identificationCode) {
		IdentificationCode = identificationCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}// end Country