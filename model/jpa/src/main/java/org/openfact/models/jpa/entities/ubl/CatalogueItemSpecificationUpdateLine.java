package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to define a line describing the transaction that updates the
 * specification of an item in a catalogue.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:18 a. m.
 */
public class CatalogueItemSpecificationUpdateLine {

	/**
	 * An identifier for the line to be updated in a catalogue.
	 */
	private String ID;
	private CustomerParty ContractorCustomerParty;
	private List<Item> items = new ArrayList<>();
	private SupplierParty SellerSupplierParty;

	public CatalogueItemSpecificationUpdateLine() {

	}

	public void finalize() throws Throwable {

	}

	public CustomerParty getContractorCustomerParty() {
		return ContractorCustomerParty;
	}

	public String getID() {
		return ID;
	}

	public Item getItem() {
		return m_Item;
	}

	public SupplierParty getSellerSupplierParty() {
		return SellerSupplierParty;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setContractorCustomerParty(CustomerParty newVal) {
		ContractorCustomerParty = newVal;
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
	public void setItem(Item newVal) {
		m_Item = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSellerSupplierParty(SupplierParty newVal) {
		SellerSupplierParty = newVal;
	}
}// end Catalogue Item Specification Update Line