package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to describe a customer party.
 * 
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:14:16 a. m.
 */
public class CustomerParty {

	/**
	 * An identifier for the customer's account, assigned by a third party.
	 */
	private String additionalAccountID;
	/**
	 * An identifier for the customer's account, assigned by the customer
	 * itself.
	 */
	private String customerAssignedAccountID;
	/**
	 * An identifier for the customer's account, assigned by the supplier.
	 */
	private String supplierAssignedAccountID;
	private Contact deliveryContact;
	private Contact accountingContact;
	private Contact buyerContact;
	private List<Party> parties= new ArrayList<>();

	public String getCustomerAssignedAccountID() {
		return customerAssignedAccountID;
	}

	public void setCustomerAssignedAccountID(String customerAssignedAccountID) {
		this.customerAssignedAccountID = customerAssignedAccountID;
	}

	public String getAdditionalAccountID() {
		return additionalAccountID;
	}

	public void setAdditionalAccountID(String additionalAccountID) {
		this.additionalAccountID = additionalAccountID;
	}

	public String getSupplierAssignedAccountID() {
		return supplierAssignedAccountID;
	}

	public void setSupplierAssignedAccountID(String supplierAssignedAccountID) {
		this.supplierAssignedAccountID = supplierAssignedAccountID;
	}

	public Contact getDeliveryContact() {
		return deliveryContact;
	}

	public void setDeliveryContact(Contact deliveryContact) {
		this.deliveryContact = deliveryContact;
	}

	public Contact getAccountingContact() {
		return accountingContact;
	}

	public void setAccountingContact(Contact accountingContact) {
		this.accountingContact = accountingContact;
	}

	public Contact getBuyerContact() {
		return buyerContact;
	}

	public void setBuyerContact(Contact buyerContact) {
		this.buyerContact = buyerContact;
	}

	public List<Party> getParties() {
		return parties;
	}

	public void setParties(List<Party> parties) {
		this.parties = parties;
	}
}