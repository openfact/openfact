package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to describe a scheme for corporate registration.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:09 a. m.
 */
public class CorporateRegistrationScheme {

	/**
	 * A code signifying the type of this registration scheme.
	 */
	private String CorporateRegistrationTypeCode;
	/**
	 * An identifier for this registration scheme.
	 */
	private String ID;
	/**
	 * The name of this registration scheme.
	 */
	private String Name;
	private Address JurisdictionRegionAddress;

	public CorporateRegistrationScheme() {

	}

	public void finalize() throws Throwable {

	}

	public String getCorporateRegistrationTypeCode() {
		return CorporateRegistrationTypeCode;
	}

	public String getID() {
		return ID;
	}

	public Address getJurisdictionRegionAddress() {
		return JurisdictionRegionAddress;
	}

	public String getName() {
		return Name;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCorporateRegistrationTypeCode(String newVal) {
		CorporateRegistrationTypeCode = newVal;
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
	public void setJurisdictionRegionAddress(Address newVal) {
		JurisdictionRegionAddress = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setName(String newVal) {
		Name = newVal;
	}
}// end Corporate Registration Scheme