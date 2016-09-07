package org.openfact.models.jpa.entities.ubl;


/**
 * A class to describe a supplier party.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:00 a. m.
 */
public class SupplierParty {

	/**
	 * An additional identifier for this supplier party.
	 */
	private String AdditionalAccountID;
	/**
	 * An identifier for this supplier party, assigned by the customer.
	 */
	private String CustomerAssignedAccountID;
	/**
	 * Text describing the supplier's ability to send invoice data via a purchase card
	 * provider (e.g., VISA, MasterCard, American Express).
	 */
	private String DataSendingCapability;
	private Contact Seller Contact;
	private Contact Accounting Contact;
	private Contact Despatch Contact;
	private Party m_Party;

	public SupplierParty(){

	}

	public void finalize() throws Throwable {

	}
	public Contact getAccounting Contact(){
		return Accounting Contact;
	}

	public String getAdditionalAccountID(){
		return AdditionalAccountID;
	}

	public String getCustomerAssignedAccountID(){
		return CustomerAssignedAccountID;
	}

	public String getDataSendingCapability(){
		return DataSendingCapability;
	}

	public Contact getDespatch Contact(){
		return Despatch Contact;
	}

	public Party getParty(){
		return m_Party;
	}

	public Contact getSeller Contact(){
		return Seller Contact;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAccounting Contact(Contact newVal){
		Accounting Contact = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAdditionalAccountID(String newVal){
		AdditionalAccountID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCustomerAssignedAccountID(String newVal){
		CustomerAssignedAccountID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDataSendingCapability(String newVal){
		DataSendingCapability = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDespatch Contact(Contact newVal){
		Despatch Contact = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setParty(Party newVal){
		m_Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSeller Contact(Contact newVal){
		Seller Contact = newVal;
	}
}//end SupplierParty