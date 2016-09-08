package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to define a line describing a pricing update to a catalogue line.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:21 a. m.
 */
public class CataloguePricingUpdateLine {

	/**
	 * An identifier for the catalogue line to be updated.
	 */
	private String id;
	private CustomerParty contractorCustomerParty;
	private ItemLocationQuantity requiredItemLocationQuantity;
	private SupplierParty sellerSupplierParty;

	public CataloguePricingUpdateLine() {

	}

	public void finalize() throws Throwable {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public CustomerParty getContractorCustomerParty() {
		return contractorCustomerParty;
	}

	public void setContractorCustomerParty(CustomerParty contractorCustomerParty) {
		this.contractorCustomerParty = contractorCustomerParty;
	}

	public ItemLocationQuantity getRequiredItemLocationQuantity() {
		return requiredItemLocationQuantity;
	}

	public void setRequiredItemLocationQuantity(ItemLocationQuantity requiredItemLocationQuantity) {
		this.requiredItemLocationQuantity = requiredItemLocationQuantity;
	}

	public SupplierParty getSellerSupplierParty() {
		return sellerSupplierParty;
	}

	public void setSellerSupplierParty(SupplierParty sellerSupplierParty) {
		this.sellerSupplierParty = sellerSupplierParty;
	}
}// end Catalogue Pricing Update Line