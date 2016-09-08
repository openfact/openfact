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
	private String corporateRegistrationTypeCode;
	/**
	 * An identifier for this registration scheme.
	 */
	private String ID;
	/**
	 * The name of this registration scheme.
	 */
	private String name;
	private Address jurisdictionRegionAddress;

	public CorporateRegistrationScheme() {

	}

	public void finalize() throws Throwable {

	}

	public String getCorporateRegistrationTypeCode() {
		return corporateRegistrationTypeCode;
	}

	public void setCorporateRegistrationTypeCode(String corporateRegistrationTypeCode) {
		this.corporateRegistrationTypeCode = corporateRegistrationTypeCode;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getJurisdictionRegionAddress() {
		return jurisdictionRegionAddress;
	}

	public void setJurisdictionRegionAddress(Address jurisdictionRegionAddress) {
		this.jurisdictionRegionAddress = jurisdictionRegionAddress;
	}
}// end Corporate Registration Scheme