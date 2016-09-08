package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to describe a price list.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:56 a. m.
 */
public class PriceList {

	/**
	 * An identifier for this price list.
	 */
	private String id;
	/**
	 * A code signifying whether this price list is an original, copy, revision,
	 * or cancellation.
	 */
	private String statusCode;
	private Period validityPeriod;
	private PriceList previousPriceList;

	public PriceList() {

	}

	public void finalize() throws Throwable {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public Period getValidityPeriod() {
		return validityPeriod;
	}

	public void setValidityPeriod(Period validityPeriod) {
		this.validityPeriod = validityPeriod;
	}

	public PriceList getPreviousPriceList() {
		return previousPriceList;
	}

	public void setPreviousPriceList(PriceList previousPriceList) {
		this.previousPriceList = previousPriceList;
	}
}// end Price List