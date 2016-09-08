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
	private String currencyCode;
	/**
	 * An identifier for this taxation scheme.
	 */
	private String id;
	/**
	 * The name of this taxation scheme.
	 */
	private String name;
	/**
	 * A code signifying the type of tax.
	 */
	private String taxTypeCode;
	private Address jurisdictionRegionAddress;

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTaxTypeCode() {
		return taxTypeCode;
	}

	public void setTaxTypeCode(String taxTypeCode) {
		this.taxTypeCode = taxTypeCode;
	}

	public Address getJurisdictionRegionAddress() {
		return jurisdictionRegionAddress;
	}

	public void setJurisdictionRegionAddress(Address jurisdictionRegionAddress) {
		this.jurisdictionRegionAddress = jurisdictionRegionAddress;
	}
}// end Tax Scheme