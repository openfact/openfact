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
	private Indicator. Type CopyIndicator;
	/**
	 * Text used for tagging purchasing card transactions.
	 */
	private Text. Type CustomerReference;
	/**
	 * An identifier for this order reference, assigned by the buyer.
	 */
	private Identifier. Type ID;
	/**
	 * The date on which the referenced Order was issued.
	 */
	private Date. Type IssueDate;
	/**
	 * The time at which the referenced Order was issued.
	 */
	private Time. Type IssueTime;
	/**
	 * A code signifying the type of the referenced Order.
	 */
	private Code. Type OrderTypeCode;
	/**
	 * An identifier for this order reference, assigned by the seller.
	 */
	private Identifier. Type SalesOrderID;
	/**
	 * A universally unique identifier for this order reference.
	 */
	private Identifier. Type UUID;
	private Document Reference m_Document Reference;

	public Order Reference(){

	}

	public void finalize() throws Throwable {

	}
	public Indicator. Type getCopyIndicator(){
		return CopyIndicator;
	}

	public Text. Type getCustomerReference(){
		return CustomerReference;
	}

	public Document Reference getDocument Reference(){
		return m_Document Reference;
	}

	public Identifier. Type getID(){
		return ID;
	}

	public Date. Type getIssueDate(){
		return IssueDate;
	}

	public Time. Type getIssueTime(){
		return IssueTime;
	}

	public Code. Type getOrderTypeCode(){
		return OrderTypeCode;
	}

	public Identifier. Type getSalesOrderID(){
		return SalesOrderID;
	}

	public Identifier. Type getUUID(){
		return UUID;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCopyIndicator(Indicator. Type newVal){
		CopyIndicator = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCustomerReference(Text. Type newVal){
		CustomerReference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDocument Reference(Document Reference newVal){
		m_Document Reference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setID(Identifier. Type newVal){
		ID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setIssueDate(Date. Type newVal){
		IssueDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setIssueTime(Time. Type newVal){
		IssueTime = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setOrderTypeCode(Code. Type newVal){
		OrderTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSalesOrderID(Identifier. Type newVal){
		SalesOrderID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setUUID(Identifier. Type newVal){
		UUID = newVal;
	}
}//end Order Reference