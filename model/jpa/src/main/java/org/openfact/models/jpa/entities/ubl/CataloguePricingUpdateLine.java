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
	private String ID;
	private CustomerParty ContractorCustomerParty;
	private ItemLocationQuantity RequiredItemLocationQuantity;
	private SupplierParty SellerSupplierParty;

	public CataloguePricingUpdateLine() {

	}

	public void finalize() throws Throwable {

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
	 * @return the contractorCustomerParty
	 */
	public CustomerParty getContractorCustomerParty() {
		return ContractorCustomerParty;
	}

	/**
	 * @param contractorCustomerParty
	 *            the contractorCustomerParty to set
	 */
	public void setContractorCustomerParty(CustomerParty contractorCustomerParty) {
		ContractorCustomerParty = contractorCustomerParty;
	}

	/**
	 * @return the requiredItemLocationQuantity
	 */
	public ItemLocationQuantity getRequiredItemLocationQuantity() {
		return RequiredItemLocationQuantity;
	}

	/**
	 * @param requiredItemLocationQuantity
	 *            the requiredItemLocationQuantity to set
	 */
	public void setRequiredItemLocationQuantity(ItemLocationQuantity requiredItemLocationQuantity) {
		RequiredItemLocationQuantity = requiredItemLocationQuantity;
	}

	/**
	 * @return the sellerSupplierParty
	 */
	public SupplierParty getSellerSupplierParty() {
		return SellerSupplierParty;
	}

	/**
	 * @param sellerSupplierParty
	 *            the sellerSupplierParty to set
	 */
	public void setSellerSupplierParty(SupplierParty sellerSupplierParty) {
		SellerSupplierParty = sellerSupplierParty;
	}

}// end Catalogue Pricing Update Line