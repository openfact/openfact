package org.openfact.models.jpa.entities.ubl;


/**
 * A class to define a reference to an Order.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:18 a. m.
 */
public class OrderReference {

	/**
	 * Indicates whether the referenced Order is a copy (true) or the original (false).
	 */
	private boolean CopyIndicator;
	/**
	 * Text used for tagging purchasing card transactions.
	 */
	private String CustomerReference;
	/**
	 * An identifier for this order reference, assigned by the buyer.
	 */
	private String ID;
	/**
	 * The date on which the referenced Order was issued.
	 */
	private LocalDate IssueDate;
	/**
	 * The time at which the referenced Order was issued.
	 */
	private LocalTime IssueTime;
	/**
	 * A code signifying the type of the referenced Order.
	 */
	private String OrderTypeCode;
	/**
	 * An identifier for this order reference, assigned by the seller.
	 */
	private String SalesOrderID;
	/**
	 * A universally unique identifier for this order reference.
	 */
	private String UUID;
	private DocumentReference m_DocumentReference;

	public Order Reference(){

	}

	public void finalize() throws Throwable {

	}
	public boolean getCopyIndicator(){
		return CopyIndicator;
	}

	public String getCustomerReference(){
		return CustomerReference;
	}

	public DocumentReference getDocumentReference(){
		return m_DocumentReference;
	}

	public String getID(){
		return ID;
	}

	public LocalDate getIssueDate(){
		return IssueDate;
	}

	public LocalTime getIssueTime(){
		return IssueTime;
	}

	public String getOrderTypeCode(){
		return OrderTypeCode;
	}

	public String getSalesOrderID(){
		return SalesOrderID;
	}

	public String getUUID(){
		return UUID;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCopyIndicator(boolean newVal){
		CopyIndicator = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCustomerReference(String newVal){
		CustomerReference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDocumentReference(DocumentReference newVal){
		m_DocumentReference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setID(String newVal){
		ID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setIssueDate(LocalDate newVal){
		IssueDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setIssueTime(LocalTime newVal){
		IssueTime = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setOrderTypeCode(String newVal){
		OrderTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSalesOrderID(String newVal){
		SalesOrderID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setUUID(String newVal){
		UUID = newVal;
	}
}//end Order Reference