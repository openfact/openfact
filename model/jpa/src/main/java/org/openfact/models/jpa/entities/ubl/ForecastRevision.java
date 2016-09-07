package org.openfact.models.jpa.entities.ubl;


import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A document used to revise a Forecast.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:20:37 a. m.
 */
public class ForecastRevision {

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
	 * Indicates the purpose of the revision.
	 */
	private String purposeCode;
	/**
	 * Indicates the revision status of this Forecast Revision.
	 */
	private String revisionStatusCode;
	/**
	 * A sequence number, to ensure the proper sequencing of revisions.
	 */
	private String sequenceNumberID;
	/**
	 * Identifies the earliest version of the UBL 2 schema for this document type that
	 * defines all of the elements that might be encountered in the current instance.
	 */
	private String UBLVersionID;
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private String UUID;
	private CustomerParty buyerCustomerParty;
	private DocumentReference originalDocumentReference;
	private ForecastRevisionLine m_ForecastRevisionLine;
	private Party senderParty;
	private Party receiverParty;
	private Period forecastPeriod;
	private Signature m_Signature;
	private SupplierParty sellerSupplierParty;

	public ForecastRevision(){

	}

	public void finalize() throws Throwable {

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

	public String getPurposeCode() {
		return purposeCode;
	}

	public void setPurposeCode(String purposeCode) {
		this.purposeCode = purposeCode;
	}

	public String getRevisionStatusCode() {
		return revisionStatusCode;
	}

	public void setRevisionStatusCode(String revisionStatusCode) {
		this.revisionStatusCode = revisionStatusCode;
	}

	public String getSequenceNumberID() {
		return sequenceNumberID;
	}

	public void setSequenceNumberID(String sequenceNumberID) {
		this.sequenceNumberID = sequenceNumberID;
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

	public CustomerParty getBuyerCustomerParty() {
		return buyerCustomerParty;
	}

	public void setBuyerCustomerParty(CustomerParty buyerCustomerParty) {
		this.buyerCustomerParty = buyerCustomerParty;
	}

	public DocumentReference getOriginalDocumentReference() {
		return originalDocumentReference;
	}

	public void setOriginalDocumentReference(DocumentReference originalDocumentReference) {
		this.originalDocumentReference = originalDocumentReference;
	}

	public ForecastRevisionLine getM_ForecastRevisionLine() {
		return m_ForecastRevisionLine;
	}

	public void setM_ForecastRevisionLine(ForecastRevisionLine m_ForecastRevisionLine) {
		this.m_ForecastRevisionLine = m_ForecastRevisionLine;
	}

	public Party getSenderParty() {
		return senderParty;
	}

	public void setSenderParty(Party senderParty) {
		this.senderParty = senderParty;
	}

	public Party getReceiverParty() {
		return receiverParty;
	}

	public void setReceiverParty(Party receiverParty) {
		this.receiverParty = receiverParty;
	}

	public Period getForecastPeriod() {
		return forecastPeriod;
	}

	public void setForecastPeriod(Period forecastPeriod) {
		this.forecastPeriod = forecastPeriod;
	}

	public Signature getM_Signature() {
		return m_Signature;
	}

	public void setM_Signature(Signature m_Signature) {
		this.m_Signature = m_Signature;
	}

	public SupplierParty getSellerSupplierParty() {
		return sellerSupplierParty;
	}

	public void setSellerSupplierParty(SupplierParty sellerSupplierParty) {
		this.sellerSupplierParty = sellerSupplierParty;
	}
}//end Forecast Revision