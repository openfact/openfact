package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

/**
 * A class for describing the terms of a trade agreement.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:33 a. m.
 */
public class TradingTerms {

	/**
	 * Text describing the terms of a trade agreement.
	 */
	private String information;
	/**
	 * A reference quoting the basis of the terms
	 */
	private String reference;
	private Address applicableAddress;

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Address getApplicableAddress() {
		return applicableAddress;
	}

	public void setApplicableAddress(Address applicableAddress) {
		this.applicableAddress = applicableAddress;
	}
}// end TradingTerms