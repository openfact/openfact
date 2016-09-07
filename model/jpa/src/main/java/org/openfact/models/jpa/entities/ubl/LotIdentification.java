package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;

/**
 * A class for defining a lot identifier (the identifier of a set of item
 * instances that would be used in case of a recall of that item).
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:03 a. m.
 */
public class LotIdentification {

	/**
	 * The expiry date of the lot.
	 */
	private LocalDate expiryDate;
	/**
	 * An identifier for the lot.
	 */
	private String lotNumberID;
	private ItemProperty additionalItemProperty;

	public LotIdentification() {

	}

	public void finalize() throws Throwable {

	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getLotNumberID() {
		return lotNumberID;
	}

	public void setLotNumberID(String lotNumberID) {
		this.lotNumberID = lotNumberID;
	}

	public ItemProperty getAdditionalItemProperty() {
		return additionalItemProperty;
	}

	public void setAdditionalItemProperty(ItemProperty additionalItemProperty) {
		this.additionalItemProperty = additionalItemProperty;
	}
}// end Lot Identification