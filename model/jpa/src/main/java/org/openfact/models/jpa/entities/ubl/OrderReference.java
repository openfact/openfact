package org.openfact.models.jpa.entities.ubl;


import java.time.LocalDate;
import java.time.LocalTime;

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
	private boolean copyIndicator;
	/**
	 * Text used for tagging purchasing card transactions.
	 */
	private String customerReference;
	/**
	 * An identifier for this order reference, assigned by the buyer.
	 */
	private String ID;
	/**
	 * The date on which the referenced Order was issued.
	 */
	private LocalDate issueDate;
	/**
	 * The time at which the referenced Order was issued.
	 */
	private LocalTime issueTime;
	/**
	 * A code signifying the type of the referenced Order.
	 */
	private String orderTypeCode;
	/**
	 * An identifier for this order reference, assigned by the seller.
	 */
	private String salesOrderID;
	/**
	 * A universally unique identifier for this order reference.
	 */
	private String UUID;
	private DocumentReference m_DocumentReference;

	public OrderReference(){

	}

	public void finalize() throws Throwable {

	}

	public boolean isCopyIndicator() {
		return copyIndicator;
	}

	public void setCopyIndicator(boolean copyIndicator) {
		this.copyIndicator = copyIndicator;
	}

	public String getCustomerReference() {
		return customerReference;
	}

	public void setCustomerReference(String customerReference) {
		this.customerReference = customerReference;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public LocalDate getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}

	public LocalTime getIssueTime() {
		return issueTime;
	}

	public void setIssueTime(LocalTime issueTime) {
		this.issueTime = issueTime;
	}

	public String getOrderTypeCode() {
		return orderTypeCode;
	}

	public void setOrderTypeCode(String orderTypeCode) {
		this.orderTypeCode = orderTypeCode;
	}

	public String getSalesOrderID() {
		return salesOrderID;
	}

	public void setSalesOrderID(String salesOrderID) {
		this.salesOrderID = salesOrderID;
	}

	public String getUUID() {
		return UUID;
	}

	public void setUUID(String UUID) {
		this.UUID = UUID;
	}

	public DocumentReference getM_DocumentReference() {
		return m_DocumentReference;
	}

	public void setM_DocumentReference(DocumentReference m_DocumentReference) {
		this.m_DocumentReference = m_DocumentReference;
	}
}//end Order Reference