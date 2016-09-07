package org.openfact.models.jpa.entities.ubl;


import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A document used to cancel an entire fulfilment document (Despatch Advice or
 * Receipt Advice).
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:20:42 a. m.
 */
public class FulfilmentCancellation {

	/**
	 * The reason for cancellation of the referenced document.
	 */
	private String cancellationNote;
	/**
	 * Indicates whether this document is a copy (true) or not (false).
	 */
	private boolean copyIndicator;
	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private String customizationID;
	/**
	 * An identifier for this document, assigned by the sender.
	 */
	private String ID;
	/**
	 * The date, assigned by the sender, on which this document was issued.
	 */
	private LocalDate issueDate;
	/**
	 * The time, assigned by the sender, at which this document was issued.
	 */
	private LocalTime issueTime;
	/**
	 * Free-form text pertinent to this document, conveying information that is not
	 * contained explicitly in other structures.
	 */
	private String note;
	/**
	 * Identifies an instance of executing a profile, to associate all transactions in
	 * a collaboration.
	 */
	private String profileExecutionID;
	/**
	 * Identifies a user-defined profile of the customization of UBL being used.
	 */
	private String profileID;
	/**
	 * Identifies the earliest version of the UBL 2 schema for this document type that
	 * defines all of the elements that might be encountered in the current instance.
	 */
	private String UBLVersionID;
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private String UUID;
	private Contract m_Contract;
	private CustomerParty buyerCustomerParty;
	private CustomerParty originatorCustomerParty;
	private CustomerParty deliveryCustomerParty;
	private DocumentReference additionalDocumentReference;
	private DocumentReference receiptDocumentReference;
	private DocumentReference despatchDocumentReference;
	private OrderReference m_OrderReference;
	private Signature m_Signature;
	private SupplierParty despatchSupplierParty;
	private SupplierParty sellerSupplierParty;

	public FulfilmentCancellation(){

	}

	public void finalize() throws Throwable {

	}

	public String getCancellationNote() {
		return cancellationNote;
	}

	public void setCancellationNote(String cancellationNote) {
		this.cancellationNote = cancellationNote;
	}

	public boolean isCopyIndicator() {
		return copyIndicator;
	}

	public void setCopyIndicator(boolean copyIndicator) {
		this.copyIndicator = copyIndicator;
	}

	public String getCustomizationID() {
		return customizationID;
	}

	public void setCustomizationID(String customizationID) {
		this.customizationID = customizationID;
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

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getProfileExecutionID() {
		return profileExecutionID;
	}

	public void setProfileExecutionID(String profileExecutionID) {
		this.profileExecutionID = profileExecutionID;
	}

	public String getProfileID() {
		return profileID;
	}

	public void setProfileID(String profileID) {
		this.profileID = profileID;
	}

	public String getUBLVersionID() {
		return UBLVersionID;
	}

	public void setUBLVersionID(String UBLVersionID) {
		this.UBLVersionID = UBLVersionID;
	}

	public String getUUID() {
		return UUID;
	}

	public void setUUID(String UUID) {
		this.UUID = UUID;
	}

	public Contract getM_Contract() {
		return m_Contract;
	}

	public void setM_Contract(Contract m_Contract) {
		this.m_Contract = m_Contract;
	}

	public CustomerParty getBuyerCustomerParty() {
		return buyerCustomerParty;
	}

	public void setBuyerCustomerParty(CustomerParty buyerCustomerParty) {
		this.buyerCustomerParty = buyerCustomerParty;
	}

	public CustomerParty getOriginatorCustomerParty() {
		return originatorCustomerParty;
	}

	public void setOriginatorCustomerParty(CustomerParty originatorCustomerParty) {
		this.originatorCustomerParty = originatorCustomerParty;
	}

	public CustomerParty getDeliveryCustomerParty() {
		return deliveryCustomerParty;
	}

	public void setDeliveryCustomerParty(CustomerParty deliveryCustomerParty) {
		this.deliveryCustomerParty = deliveryCustomerParty;
	}

	public DocumentReference getAdditionalDocumentReference() {
		return additionalDocumentReference;
	}

	public void setAdditionalDocumentReference(DocumentReference additionalDocumentReference) {
		this.additionalDocumentReference = additionalDocumentReference;
	}

	public DocumentReference getReceiptDocumentReference() {
		return receiptDocumentReference;
	}

	public void setReceiptDocumentReference(DocumentReference receiptDocumentReference) {
		this.receiptDocumentReference = receiptDocumentReference;
	}

	public DocumentReference getDespatchDocumentReference() {
		return despatchDocumentReference;
	}

	public void setDespatchDocumentReference(DocumentReference despatchDocumentReference) {
		this.despatchDocumentReference = despatchDocumentReference;
	}

	public OrderReference getM_OrderReference() {
		return m_OrderReference;
	}

	public void setM_OrderReference(OrderReference m_OrderReference) {
		this.m_OrderReference = m_OrderReference;
	}

	public Signature getM_Signature() {
		return m_Signature;
	}

	public void setM_Signature(Signature m_Signature) {
		this.m_Signature = m_Signature;
	}

	public SupplierParty getDespatchSupplierParty() {
		return despatchSupplierParty;
	}

	public void setDespatchSupplierParty(SupplierParty despatchSupplierParty) {
		this.despatchSupplierParty = despatchSupplierParty;
	}

	public SupplierParty getSellerSupplierParty() {
		return sellerSupplierParty;
	}

	public void setSellerSupplierParty(SupplierParty sellerSupplierParty) {
		this.sellerSupplierParty = sellerSupplierParty;
	}
}//end Fulfilment Cancellation