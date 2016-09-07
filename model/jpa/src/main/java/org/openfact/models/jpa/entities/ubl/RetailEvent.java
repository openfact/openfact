package org.openfact.models.jpa.entities.ubl;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A document used to specify basic information about retail events (such as
 * promotions, product introductions, and community or environmental events)
 * that affect supply or demand.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:21:20 a. m.
 */
public class RetailEvent {

	/**
	 * An event tracking identifier assigned by the buyer.
	 */
	private String BuyerEventID;
	/**
	 * Indicates whether this document is a copy (true) or not (false).
	 */
	private boolean CopyIndicator;
	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private String CustomizationID;
	/**
	 * Definition of the discrete activity affecting supply or demand in the
	 * supply chain
	 */
	private String Description;
	/**
	 * An identifier for this document, assigned by the sender.
	 */
	private String ID;
	/**
	 * The date, assigned by the sender, on which this document was issued.
	 */
	private LocalDate IssueDate;
	/**
	 * The time, assigned by the sender, at which this document was issued.
	 */
	private LocalTime IssueTime;
	/**
	 * Free-form text pertinent to this document, conveying information that is
	 * not contained explicitly in other structures.
	 */
	private String Note;
	/**
	 * Identifies an instance of executing a profile, to associate all
	 * transactions in a collaboration.
	 */
	private String ProfileExecutionID;
	/**
	 * Identifies a user-defined profile of the customization of UBL being used.
	 */
	private String ProfileID;
	/**
	 * A title, theme, slogan, or other identifier for the event for use by
	 * trading partners.
	 */
	private String RetailEventName;
	/**
	 * Describes the logical state of the discrete activity affecting supply or
	 * demand in the supply chain
	 */
	private String RetailEventStatusCode;
	/**
	 * An event tracking identifier assigned by the seller.
	 */
	private String SellerEventID;
	/**
	 * Identifies the earliest version of the UBL 2 schema for this document
	 * type that defines all of the elements that might be encountered in the
	 * current instance.
	 */
	private String UBLVersionID;
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private String UUID;
	private CustomerParty BuyerCustomerParty;
	private DocumentReference OriginalDocumentReference;
	private EventComment m_EventComment;
	private MiscellaneousEvent m_MiscellaneousEvent;
	private Party SenderParty;
	private Party ReceiverParty;
	private Period m_Period;
	private PromotionalEvent m_PromotionalEvent;
	private Signature m_Signature;
	private SupplierParty SellerSupplierParty;

	public RetailEvent() {

	}

	public void finalize() throws Throwable {

	}

	public CustomerParty getBuyerCustomerParty() {
		return BuyerCustomerParty;
	}

	public String getBuyerEventID() {
		return BuyerEventID;
	}

	public boolean getCopyIndicator() {
		return CopyIndicator;
	}

	public String getCustomizationID() {
		return CustomizationID;
	}

	public String getDescription() {
		return Description;
	}

	public EventComment getEventComment() {
		return m_EventComment;
	}

	public String getID() {
		return ID;
	}

	public LocalDate getIssueDate() {
		return IssueDate;
	}

	public LocalTime getIssueTime() {
		return IssueTime;
	}

	public MiscellaneousEvent getMiscellaneousEvent() {
		return m_MiscellaneousEvent;
	}

	public String getNote() {
		return Note;
	}

	public DocumentReference getOriginalDocumentReference() {
		return OriginalDocumentReference;
	}

	public Period getPeriod() {
		return m_Period;
	}

	public String getProfileExecutionID() {
		return ProfileExecutionID;
	}

	public String getProfileID() {
		return ProfileID;
	}

	public PromotionalEvent getPromotionalEvent() {
		return m_PromotionalEvent;
	}

	public Party getReceiverParty() {
		return ReceiverParty;
	}

	public String getRetailEventName() {
		return RetailEventName;
	}

	public String getRetailEventStatusCode() {
		return RetailEventStatusCode;
	}

	public SupplierParty getSellerSupplierParty() {
		return SellerSupplierParty;
	}

	public String getSellerEventID() {
		return SellerEventID;
	}

	public Party getSenderParty() {
		return SenderParty;
	}

	public Signature getSignature() {
		return m_Signature;
	}

	public String getUBLVersionID() {
		return UBLVersionID;
	}

	public String getUUID() {
		return UUID;
	}

	/**
	 * @return the m_EventComment
	 */
	public EventComment getM_EventComment() {
		return m_EventComment;
	}

	/**
	 * @param m_EventComment
	 *            the m_EventComment to set
	 */
	public void setM_EventComment(EventComment m_EventComment) {
		this.m_EventComment = m_EventComment;
	}

	/**
	 * @return the m_MiscellaneousEvent
	 */
	public MiscellaneousEvent getM_MiscellaneousEvent() {
		return m_MiscellaneousEvent;
	}

	/**
	 * @param m_MiscellaneousEvent
	 *            the m_MiscellaneousEvent to set
	 */
	public void setM_MiscellaneousEvent(MiscellaneousEvent m_MiscellaneousEvent) {
		this.m_MiscellaneousEvent = m_MiscellaneousEvent;
	}

	/**
	 * @return the m_Period
	 */
	public Period getM_Period() {
		return m_Period;
	}

	/**
	 * @param m_Period
	 *            the m_Period to set
	 */
	public void setM_Period(Period m_Period) {
		this.m_Period = m_Period;
	}

	/**
	 * @return the m_PromotionalEvent
	 */
	public PromotionalEvent getM_PromotionalEvent() {
		return m_PromotionalEvent;
	}

	/**
	 * @param m_PromotionalEvent
	 *            the m_PromotionalEvent to set
	 */
	public void setM_PromotionalEvent(PromotionalEvent m_PromotionalEvent) {
		this.m_PromotionalEvent = m_PromotionalEvent;
	}

	/**
	 * @return the m_Signature
	 */
	public Signature getM_Signature() {
		return m_Signature;
	}

	/**
	 * @param m_Signature
	 *            the m_Signature to set
	 */
	public void setM_Signature(Signature m_Signature) {
		this.m_Signature = m_Signature;
	}

	/**
	 * @param buyerEventID
	 *            the buyerEventID to set
	 */
	public void setBuyerEventID(String buyerEventID) {
		BuyerEventID = buyerEventID;
	}

	/**
	 * @param copyIndicator
	 *            the copyIndicator to set
	 */
	public void setCopyIndicator(boolean copyIndicator) {
		CopyIndicator = copyIndicator;
	}

	/**
	 * @param customizationID
	 *            the customizationID to set
	 */
	public void setCustomizationID(String customizationID) {
		CustomizationID = customizationID;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		Description = description;
	}

	/**
	 * @param iD
	 *            the iD to set
	 */
	public void setID(String iD) {
		ID = iD;
	}

	/**
	 * @param issueDate
	 *            the issueDate to set
	 */
	public void setIssueDate(LocalDate issueDate) {
		IssueDate = issueDate;
	}

	/**
	 * @param issueTime
	 *            the issueTime to set
	 */
	public void setIssueTime(LocalTime issueTime) {
		IssueTime = issueTime;
	}

	/**
	 * @param note
	 *            the note to set
	 */
	public void setNote(String note) {
		Note = note;
	}

	/**
	 * @param profileExecutionID
	 *            the profileExecutionID to set
	 */
	public void setProfileExecutionID(String profileExecutionID) {
		ProfileExecutionID = profileExecutionID;
	}

	/**
	 * @param profileID
	 *            the profileID to set
	 */
	public void setProfileID(String profileID) {
		ProfileID = profileID;
	}

	/**
	 * @param retailEventName
	 *            the retailEventName to set
	 */
	public void setRetailEventName(String retailEventName) {
		RetailEventName = retailEventName;
	}

	/**
	 * @param retailEventStatusCode
	 *            the retailEventStatusCode to set
	 */
	public void setRetailEventStatusCode(String retailEventStatusCode) {
		RetailEventStatusCode = retailEventStatusCode;
	}

	/**
	 * @param sellerEventID
	 *            the sellerEventID to set
	 */
	public void setSellerEventID(String sellerEventID) {
		SellerEventID = sellerEventID;
	}

	/**
	 * @param uBLVersionID
	 *            the uBLVersionID to set
	 */
	public void setUBLVersionID(String uBLVersionID) {
		UBLVersionID = uBLVersionID;
	}

	/**
	 * @param uUID
	 *            the uUID to set
	 */
	public void setUUID(String uUID) {
		UUID = uUID;
	}

	/**
	 * @param buyerCustomerParty
	 *            the buyerCustomerParty to set
	 */
	public void setBuyerCustomerParty(CustomerParty buyerCustomerParty) {
		BuyerCustomerParty = buyerCustomerParty;
	}

	/**
	 * @param originalDocumentReference
	 *            the originalDocumentReference to set
	 */
	public void setOriginalDocumentReference(DocumentReference originalDocumentReference) {
		OriginalDocumentReference = originalDocumentReference;
	}

	/**
	 * @param senderParty
	 *            the senderParty to set
	 */
	public void setSenderParty(Party senderParty) {
		SenderParty = senderParty;
	}

	/**
	 * @param receiverParty
	 *            the receiverParty to set
	 */
	public void setReceiverParty(Party receiverParty) {
		ReceiverParty = receiverParty;
	}

	/**
	 * @param sellerSupplierParty
	 *            the sellerSupplierParty to set
	 */
	public void setSellerSupplierParty(SupplierParty sellerSupplierParty) {
		SellerSupplierParty = sellerSupplierParty;
	}

}// end Retail Event