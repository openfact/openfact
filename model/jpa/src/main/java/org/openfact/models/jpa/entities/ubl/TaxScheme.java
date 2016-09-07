package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to describe a taxation scheme (e.g., VAT, State tax, County tax).
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:04 a. m.
 */
public class TaxScheme {

	/**
	 * A code signifying the currency in which the tax is collected and
	 * reported.
	 */
	private String CurrencyCode;
	/**
	 * An identifier for this taxation scheme.
	 */
	private String ID;
	/**
	 * The name of this taxation scheme.
	 */
	private String Name;
	/**
	 * A code signifying the type of tax.
	 */
	private String TaxTypeCode;
	private Address JurisdictionRegionAddress;

	/**
	 * @return the currencyCode
	 */
	public String getCurrencyCode() {
		return CurrencyCode;
	}

	/**
	 * @param currencyCode
	 *            the currencyCode to set
	 */
	public void setCurrencyCode(String currencyCode) {
		CurrencyCode = currencyCode;
	}

	/**
	 * @return the iD
	 */
	public String getID() {
		return ID;
	}

	/**
	 * @param iD
	 *            the iD to set
	 */
	public void setID(String iD) {
		ID = iD;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return Name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		Name = name;
	}

	/**
	 * @return the taxTypeCode
	 */
	public String getTaxTypeCode() {
		return TaxTypeCode;
	}

	/**
	 * @param taxTypeCode
	 *            the taxTypeCode to set
	 */
	public void setTaxTypeCode(String taxTypeCode) {
		TaxTypeCode = taxTypeCode;
	}

	/**
	 * @return the jurisdictionRegionAddress
	 */
	public Address getJurisdictionRegionAddress() {
		return JurisdictionRegionAddress;
	}

	/**
	 * @param jurisdictionRegionAddress
	 *            the jurisdictionRegionAddress to set
	 */
	public void setJurisdictionRegionAddress(Address jurisdictionRegionAddress) {
		JurisdictionRegionAddress = jurisdictionRegionAddress;
	}

}// end Tax Scheme