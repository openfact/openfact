package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to define a line describing a request for a catalogue line.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:25 a. m.
 */
public class CatalogueRequestLine {

	/**
	 * A subdivision of a contract or tender covering the line being requested.
	 */
	private String contractSubdivision;
	/**
	 * An identifier for the requested catalogue line.
	 */
	private String ID;
	/**
	 * Free-form text conveying information that is not contained explicitly in
	 * other structures.
	 */
	private String note;
	private List<Item> items= new ArrayList<>();
	private ItemLocationQuantity requiredItemLocationQuantity;
	private Period lineValidityPeriod;

	public CatalogueRequestLine() {

	}

	public void finalize() throws Throwable {

	}

	public String getContractSubdivision() {
		return contractSubdivision;
	}

	public void setContractSubdivision(String contractSubdivision) {
		this.contractSubdivision = contractSubdivision;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public ItemLocationQuantity getRequiredItemLocationQuantity() {
		return requiredItemLocationQuantity;
	}

	public void setRequiredItemLocationQuantity(ItemLocationQuantity requiredItemLocationQuantity) {
		this.requiredItemLocationQuantity = requiredItemLocationQuantity;
	}

	public Period getLineValidityPeriod() {
		return lineValidityPeriod;
	}

	public void setLineValidityPeriod(Period lineValidityPeriod) {
		this.lineValidityPeriod = lineValidityPeriod;
	}
}// end Catalogue Request Line