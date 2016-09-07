package org.openfact.models.jpa.entities.ubl;


/**
 * A class to define a reference to a billing document.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:07 a. m.
 */
public class BillingReference {

	private Billing Reference Line m_Billing Reference Line;
	private DocumentReference Self Billed Invoice DocumentReference;
	private DocumentReference Self Billed Credit Note DocumentReference;
	private DocumentReference Reminder DocumentReference;
	private DocumentReference Credit Note DocumentReference;
	private DocumentReference Debit Note DocumentReference;
	private DocumentReference Invoice DocumentReference;
	private DocumentReference Additional DocumentReference;

	public Billing Reference(){

	}

	public void finalize() throws Throwable {

	}
	public DocumentReference getAdditional DocumentReference(){
		return Additional DocumentReference;
	}

	public Billing Reference Line getBilling Reference Line(){
		return m_Billing Reference Line;
	}

	public DocumentReference getCredit Note DocumentReference(){
		return Credit Note DocumentReference;
	}

	public DocumentReference getDebit Note DocumentReference(){
		return Debit Note DocumentReference;
	}

	public DocumentReference getInvoice DocumentReference(){
		return Invoice DocumentReference;
	}

	public DocumentReference getReminder DocumentReference(){
		return Reminder DocumentReference;
	}

	public DocumentReference getSelf Billed Credit Note DocumentReference(){
		return Self Billed Credit Note DocumentReference;
	}

	public DocumentReference getSelf Billed Invoice DocumentReference(){
		return Self Billed Invoice DocumentReference;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAdditional DocumentReference(DocumentReference newVal){
		Additional DocumentReference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setBilling Reference Line(Billing Reference Line newVal){
		m_Billing Reference Line = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCredit Note DocumentReference(DocumentReference newVal){
		Credit Note DocumentReference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDebit Note DocumentReference(DocumentReference newVal){
		Debit Note DocumentReference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setInvoice DocumentReference(DocumentReference newVal){
		Invoice DocumentReference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setReminder DocumentReference(DocumentReference newVal){
		Reminder DocumentReference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSelf Billed Credit Note DocumentReference(DocumentReference newVal){
		Self Billed Credit Note DocumentReference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSelf Billed Invoice DocumentReference(DocumentReference newVal){
		Self Billed Invoice DocumentReference = newVal;
	}
}//end Billing Reference