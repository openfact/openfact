package org.openfact.models.jpa.entities.ubl;


/**
 * A class to describe a line item associated with a promotional event.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:10 a. m.
 */
public class PromotionalEventLineItem {

	/**
	 * The amount associated with this promotional event line item.
	 */
	private Amount. Type Amount;
	private Event Line Item m_Event Line Item;

	public Promotional Event Line Item(){

	}

	public void finalize() throws Throwable {

	}
	public Amount. Type getAmount(){
		return Amount;
	}

	public Event Line Item getEvent Line Item(){
		return m_Event Line Item;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAmount(Amount. Type newVal){
		Amount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setEvent Line Item(Event Line Item newVal){
		m_Event Line Item = newVal;
	}
}//end Promotional Event Line Item