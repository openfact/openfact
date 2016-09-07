package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A document used to quote for the provision of goods and services.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:21:10 a. m.
 */
public class Quotation {

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
	 * The number of Quotation Lines in this document.
	 */
	private BigDecimal lineCountNumeric;
	/**
	 * Free-form text pertinent to this document, conveying information that is
	 * not contained explicitly in other structures.
	 */
	private String note;
	/**
	 * A code signifying the currency used for all prices in the Quotation.
	 */
	private String pricingCurrencyCode;
	/**
	 * Identifies an instance of executing a profile, to associate all
	 * transactions in a collaboration.
	 */
	private String profileExecutionID;
	/**
	 * Identifies a user-defined profile of the subset of UBL being used.
	 */
	private String profileID;
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
	private List<AllowanceCharge> allowanceCharges = new ArrayList<>();
	private List<Contract> contracts = new ArrayList<>();
	private Country destinationCountry;
	private CustomerParty buyerCustomerParty;
	private CustomerParty originatorCustomerParty;
	private List<Delivery> deliveries = new ArrayList<>();
	private List<DeliveryTerms> deliveryTerms = new ArrayList<>(); 
	private DocumentReference additionalDocumentReference;
	private DocumentReference requestForQuotationDocumentReference;
	private MonetaryTotal quotedMonetaryTotal;
	private List<PaymentMeans> paymentMeans = new ArrayList<>();
	private Period validityPeriod;
	private QuotationLine m_QuotationLine;
	private List<Signature> signatures = new ArrayList<>();
	private SupplierParty sellerSupplierParty;
	private List<TaxTotal> taxTotals = new ArrayList<>();
	private TransactionConditions m_TransactionConditions;

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

	public BigDecimal getLineCountNumeric() {
		return lineCountNumeric;
	}

	public void setLineCountNumeric(BigDecimal lineCountNumeric) {
		this.lineCountNumeric = lineCountNumeric;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getPricingCurrencyCode() {
		return pricingCurrencyCode;
	}

	public void setPricingCurrencyCode(String pricingCurrencyCode) {
		this.pricingCurrencyCode = pricingCurrencyCode;
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

	public AllowanceCharge getM_AllowanceCharge() {
		return m_AllowanceCharge;
	}

	public void setM_AllowanceCharge(AllowanceCharge m_AllowanceCharge) {
		this.m_AllowanceCharge = m_AllowanceCharge;
	}

	public Contract getM_Contract() {
		return m_Contract;
	}

	public void setM_Contract(Contract m_Contract) {
		this.m_Contract = m_Contract;
	}

	public Country getDestinationCountry() {
		return destinationCountry;
	}

	public void setDestinationCountry(Country destinationCountry) {
		this.destinationCountry = destinationCountry;
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

	public Delivery getM_Delivery() {
		return m_Delivery;
	}

	public void setM_Delivery(Delivery m_Delivery) {
		this.m_Delivery = m_Delivery;
	}

	public DeliveryTerms getM_DeliveryTerms() {
		return m_DeliveryTerms;
	}

	public void setM_DeliveryTerms(DeliveryTerms m_DeliveryTerms) {
		this.m_DeliveryTerms = m_DeliveryTerms;
	}

	public DocumentReference getAdditionalDocumentReference() {
		return additionalDocumentReference;
	}

	public void setAdditionalDocumentReference(DocumentReference additionalDocumentReference) {
		this.additionalDocumentReference = additionalDocumentReference;
	}

	public DocumentReference getRequestForQuotationDocumentReference() {
		return requestForQuotationDocumentReference;
	}

	public void setRequestForQuotationDocumentReference(DocumentReference requestForQuotationDocumentReference) {
		this.requestForQuotationDocumentReference = requestForQuotationDocumentReference;
	}

	public MonetaryTotal getQuotedMonetaryTotal() {
		return quotedMonetaryTotal;
	}

	public void setQuotedMonetaryTotal(MonetaryTotal quotedMonetaryTotal) {
		this.quotedMonetaryTotal = quotedMonetaryTotal;
	}

	public PaymentMeans getM_PaymentMeans() {
		return m_PaymentMeans;
	}

	public void setM_PaymentMeans(PaymentMeans m_PaymentMeans) {
		this.m_PaymentMeans = m_PaymentMeans;
	}

	public Period getValidityPeriod() {
		return validityPeriod;
	}

	public void setValidityPeriod(Period validityPeriod) {
		this.validityPeriod = validityPeriod;
	}

	public QuotationLine getM_QuotationLine() {
		return m_QuotationLine;
	}

	public void setM_QuotationLine(QuotationLine m_QuotationLine) {
		this.m_QuotationLine = m_QuotationLine;
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

	public TaxTotal getM_TaxTotal() {
		return m_TaxTotal;
	}

	public void setM_TaxTotal(TaxTotal m_TaxTotal) {
		this.m_TaxTotal = m_TaxTotal;
	}

	public TransactionConditions getM_TransactionConditions() {
		return m_TransactionConditions;
	}

	public void setM_TransactionConditions(TransactionConditions m_TransactionConditions) {
		this.m_TransactionConditions = m_TransactionConditions;
	}
}// end Quotation