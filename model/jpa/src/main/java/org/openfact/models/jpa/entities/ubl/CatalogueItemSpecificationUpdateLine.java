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
	private CustomerParty contractorCustomerParty;
	private List<Item> Items= new ArrayList<>();
	private SupplierParty sellerSupplierParty;

	public CatalogueItemSpecificationUpdateLine() {

	}

	public void finalize() throws Throwable {

	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public CustomerParty getContractorCustomerParty() {
		return contractorCustomerParty;
	}

	public void setContractorCustomerParty(CustomerParty contractorCustomerParty) {
		this.contractorCustomerParty = contractorCustomerParty;
	}

	public List<Item> getItems() {
		return Items;
	}

	public void setItems(List<Item> items) {
		Items = items;
	}

	public SupplierParty getSellerSupplierParty() {
		return sellerSupplierParty;
	}

	public void setSellerSupplierParty(SupplierParty sellerSupplierParty) {
		this.sellerSupplierParty = sellerSupplierParty;
	}
}// end Catalogue Item Specification Update Line