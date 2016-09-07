package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A document used to request a Quotation for goods and services from a Seller.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:21:19 a. m.
 */
public class RequestForQuotation {

	/**
	 * Indicates whether this document is a copy (true) or not (false).
	 */
	private boolean CopyIndicator;
	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private String CustomizationID;
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
	 * The number of Request For Quotation Lines in this document.
	 */
	private BigDecimal LineCountNumeric;
	/**
	 * Free-form text pertinent to this document, conveying information that is
	 * not contained explicitly in other structures.
	 */
	private String Note;
	/**
	 * The currency that the Seller should use to price the Quotation.
	 */
	private String PricingCurrencyCode;
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
	 * The due date for submission of the Quotation.
	 */
	private LocalDate SubmissionDueDate;
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
	private Contract m_Contract;
	private Country DestinationCountry;
	private CustomerParty BuyerCustomerParty;
	private CustomerParty OriginatorCustomerParty;
	private Delivery m_Delivery;
	private DeliveryTerms m_DeliveryTerms;
	private DocumentReference AdditionalDocumentReference;
	private DocumentReference CatalogueDocumentReference;
	private Period RequestedValidityPeriod;
	private RequestForQuotationLine m_RequestForQuotationLine;
	private Signature m_Signature;
	private SupplierParty SellerSupplierParty;

	public RequestForQuotation() {

	}

	public void finalize() throws Throwable {

	}

	public DocumentReference getAdditionalDocumentReference() {
		return AdditionalDocumentReference;
	}

	public CustomerParty getBuyerCustomerParty() {
		return BuyerCustomerParty;
	}

	public DocumentReference getCatalogueDocumentReference() {
		return CatalogueDocumentReference;
	}

	public Contract getContract() {
		return m_Contract;
	}

	public boolean getCopyIndicator() {
		return CopyIndicator;
	}

	public String getCustomizationID() {
		return CustomizationID;
	}

	public Delivery getDelivery() {
		return m_Delivery;
	}

	public DeliveryTerms getDeliveryTerms() {
		return m_DeliveryTerms;
	}

	public Country getDestinationCountry() {
		return DestinationCountry;
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

	public BigDecimal getLineCountNumeric() {
		return LineCountNumeric;
	}

	public String getNote() {
		return Note;
	}

	public CustomerParty getOriginatorCustomerParty() {
		return OriginatorCustomerParty;
	}

	public String getPricingCurrencyCode() {
		return PricingCurrencyCode;
	}

	public String getProfileExecutionID() {
		return ProfileExecutionID;
	}

	public String getProfileID() {
		return ProfileID;
	}

	public RequestForQuotationLine getRequestForQuotationLine() {
		return m_RequestForQuotationLine;
	}

	public Period getRequestedValidityPeriod() {
		return RequestedValidityPeriod;
	}

	public SupplierParty getSellerSupplierParty() {
		return SellerSupplierParty;
	}

	public Signature getSignature() {
		return m_Signature;
	}

	public LocalDate getSubmissionDueDate() {
		return SubmissionDueDate;
	}

	public String getUBLVersionID() {
		return UBLVersionID;
	}

	public String getUUID() {
		return UUID;
	}

	/**
	 * @return the m_Contract
	 */
	public Contract getM_Contract() {
		return m_Contract;
	}

	/**
	 * @param m_Contract
	 *            the m_Contract to set
	 */
	public void setM_Contract(Contract m_Contract) {
		this.m_Contract = m_Contract;
	}

	/**
	 * @return the m_Delivery
	 */
	public Delivery getM_Delivery() {
		return m_Delivery;
	}

	/**
	 * @param m_Delivery
	 *            the m_Delivery to set
	 */
	public void setM_Delivery(Delivery m_Delivery) {
		this.m_Delivery = m_Delivery;
	}

	/**
	 * @return the m_DeliveryTerms
	 */
	public DeliveryTerms getM_DeliveryTerms() {
		return m_DeliveryTerms;
	}

	/**
	 * @param m_DeliveryTerms
	 *            the m_DeliveryTerms to set
	 */
	public void setM_DeliveryTerms(DeliveryTerms m_DeliveryTerms) {
		this.m_DeliveryTerms = m_DeliveryTerms;
	}

	/**
	 * @return the m_RequestForQuotationLine
	 */
	public RequestForQuotationLine getM_RequestForQuotationLine() {
		return m_RequestForQuotationLine;
	}

	/**
	 * @param m_RequestForQuotationLine
	 *            the m_RequestForQuotationLine to set
	 */
	public void setM_RequestForQuotationLine(RequestForQuotationLine m_RequestForQuotationLine) {
		this.m_RequestForQuotationLine = m_RequestForQuotationLine;
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
	 * @param lineCountNumeric
	 *            the lineCountNumeric to set
	 */
	public void setLineCountNumeric(BigDecimal lineCountNumeric) {
		LineCountNumeric = lineCountNumeric;
	}

	/**
	 * @param note
	 *            the note to set
	 */
	public void setNote(String note) {
		Note = note;
	}

	/**
	 * @param pricingCurrencyCode
	 *            the pricingCurrencyCode to set
	 */
	public void setPricingCurrencyCode(String pricingCurrencyCode) {
		PricingCurrencyCode = pricingCurrencyCode;
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
	 * @param submissionDueDate
	 *            the submissionDueDate to set
	 */
	public void setSubmissionDueDate(LocalDate submissionDueDate) {
		SubmissionDueDate = submissionDueDate;
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
	 * @param destinationCountry
	 *            the destinationCountry to set
	 */
	public void setDestinationCountry(Country destinationCountry) {
		DestinationCountry = destinationCountry;
	}

	/**
	 * @param buyerCustomerParty
	 *            the buyerCustomerParty to set
	 */
	public void setBuyerCustomerParty(CustomerParty buyerCustomerParty) {
		BuyerCustomerParty = buyerCustomerParty;
	}

	/**
	 * @param originatorCustomerParty
	 *            the originatorCustomerParty to set
	 */
	public void setOriginatorCustomerParty(CustomerParty originatorCustomerParty) {
		OriginatorCustomerParty = originatorCustomerParty;
	}

	/**
	 * @param additionalDocumentReference
	 *            the additionalDocumentReference to set
	 */
	public void setAdditionalDocumentReference(DocumentReference additionalDocumentReference) {
		AdditionalDocumentReference = additionalDocumentReference;
	}

	/**
	 * @param catalogueDocumentReference
	 *            the catalogueDocumentReference to set
	 */
	public void setCatalogueDocumentReference(DocumentReference catalogueDocumentReference) {
		CatalogueDocumentReference = catalogueDocumentReference;
	}

	/**
	 * @param requestedValidityPeriod
	 *            the requestedValidityPeriod to set
	 */
	public void setRequestedValidityPeriod(Period requestedValidityPeriod) {
		RequestedValidityPeriod = requestedValidityPeriod;
	}

	/**
	 * @param sellerSupplierParty
	 *            the sellerSupplierParty to set
	 */
	public void setSellerSupplierParty(SupplierParty sellerSupplierParty) {
		SellerSupplierParty = sellerSupplierParty;
	}

}// end Request For Quotation