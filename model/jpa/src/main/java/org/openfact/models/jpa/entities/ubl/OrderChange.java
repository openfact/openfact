package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A document used to specify changes to an existing Order.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:20:57 a. m.
 */
public class OrderChange {

	/**
	 * The buyer's accounting code, applied to the Order Change as a whole,
	 * expressed as text.
	 */
	private String accountingCost;
	/**
	 * The buyer's accounting code, applied to the Order Change as a whole.
	 */
	private String accountingCostCode;
	/**
	 * Indicates whether this document is a copy (true) or not (false).
	 */
	private boolean copyIndicator;
	/**
	 * A supplementary reference for the transaction (e.g., CRI when using
	 * purchasing card).
	 */
	private String customerReference;
	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private String customizationID;
	/**
	 * A code signifying the default currency for this document.
	 */
	private String documentCurrencyCode;
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
	 * The number of Order Change lines in the document.
	 */
	private BigDecimal lineCountNumeric;
	/**
	 * Free-form text pertinent to this document, conveying information that is
	 * not contained explicitly in other structures.
	 */
	private String note;
	/**
	 * A code signifying the currency that is used for all prices in the Order
	 * Change.
	 */
	private String pricingCurrencyCode;
	/**
	 * Identifies an instance of executing a profile, to associate all
	 * transactions in a collaboration.
	 */
	private String profileExecutionID;
	/**
	 * Identifies a user-defined profile of the customization of UBL being used.
	 */
	private String profileID;
	/**
	 * A code signifying he currency requested for amount totals in Invoices
	 * related to this Order Change.
	 */
	private String requestedInvoiceCurrencyCode;
	/**
	 * An identifier for the Order Change, assigned by the seller.
	 */
	private String salesOrderID;
	/**
	 * The Order Change Sequence Number assigned by the Buyer to ensure the
	 * proper sequencing of changes.
	 */
	private String sequenceNumberID;
	/**
	 * A code signifying the currency requested for tax amounts in Invoices
	 * related to this Order Change.
	 */
	private String taxCurrencyCode;
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
	private Contract m_Contract;
	private Country destinationCountry;
	private CustomerParty accountingCustomerParty;
	private CustomerParty originatorCustomerParty;
	private CustomerParty buyerCustomerParty;
	private List<Delivery> deliveries = new ArrayList<>();
	private List<DeliveryTerms> deliveryTerms = new ArrayList<>(); 
	private DocumentReference additionalDocumentReference;
	private DocumentReference originatorDocumentReference;
	private DocumentReference quotationDocumentReference;
	private ExchangeRate pricingExchangeRate;
	private ExchangeRate paymentExchangeRate;
	private ExchangeRate taxExchangeRate;
	private MonetaryTotal anticipatedMonetaryTotal;
	private OrderLine m_OrderLine;
	private List<OrderReference> orderReferences = new ArrayList<>();
	private Party freightForwarderParty;
	private List<PaymentMeans> paymentMeans = new ArrayList<>();
	private List<PaymentTerms> paymentTerms = new ArrayList<>();
	private Period validityPeriod;
	private List<Signature> signatures = new ArrayList<>();
	private SupplierParty sellerSupplierParty;
	private SupplierParty accountingSupplierParty;
	private List<TaxTotal> taxTotals = new ArrayList<>();
	private TransactionConditions m_TransactionConditions;

	public OrderChange() {

	}

	public void finalize() throws Throwable {

	}

	public String getAccountingCost() {
		return accountingCost;
	}

	public void setAccountingCost(String accountingCost) {
		this.accountingCost = accountingCost;
	}

	public String getAccountingCostCode() {
		return accountingCostCode;
	}

	public void setAccountingCostCode(String accountingCostCode) {
		this.accountingCostCode = accountingCostCode;
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

	public String getCustomizationID() {
		return customizationID;
	}

	public void setCustomizationID(String customizationID) {
		this.customizationID = customizationID;
	}

	public String getDocumentCurrencyCode() {
		return documentCurrencyCode;
	}

	public void setDocumentCurrencyCode(String documentCurrencyCode) {
		this.documentCurrencyCode = documentCurrencyCode;
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

	public String getRequestedInvoiceCurrencyCode() {
		return requestedInvoiceCurrencyCode;
	}

	public void setRequestedInvoiceCurrencyCode(String requestedInvoiceCurrencyCode) {
		this.requestedInvoiceCurrencyCode = requestedInvoiceCurrencyCode;
	}

	public String getSalesOrderID() {
		return salesOrderID;
	}

	public void setSalesOrderID(String salesOrderID) {
		this.salesOrderID = salesOrderID;
	}

	public String getSequenceNumberID() {
		return sequenceNumberID;
	}

	public void setSequenceNumberID(String sequenceNumberID) {
		this.sequenceNumberID = sequenceNumberID;
	}

	public String getTaxCurrencyCode() {
		return taxCurrencyCode;
	}

	public void setTaxCurrencyCode(String taxCurrencyCode) {
		this.taxCurrencyCode = taxCurrencyCode;
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

	public CustomerParty getAccountingCustomerParty() {
		return accountingCustomerParty;
	}

	public void setAccountingCustomerParty(CustomerParty accountingCustomerParty) {
		this.accountingCustomerParty = accountingCustomerParty;
	}

	public CustomerParty getOriginatorCustomerParty() {
		return originatorCustomerParty;
	}

	public void setOriginatorCustomerParty(CustomerParty originatorCustomerParty) {
		this.originatorCustomerParty = originatorCustomerParty;
	}

	public CustomerParty getBuyerCustomerParty() {
		return buyerCustomerParty;
	}

	public void setBuyerCustomerParty(CustomerParty buyerCustomerParty) {
		this.buyerCustomerParty = buyerCustomerParty;
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

	public DocumentReference getOriginatorDocumentReference() {
		return originatorDocumentReference;
	}

	public void setOriginatorDocumentReference(DocumentReference originatorDocumentReference) {
		this.originatorDocumentReference = originatorDocumentReference;
	}

	public DocumentReference getQuotationDocumentReference() {
		return quotationDocumentReference;
	}

	public void setQuotationDocumentReference(DocumentReference quotationDocumentReference) {
		this.quotationDocumentReference = quotationDocumentReference;
	}

	public ExchangeRate getPricingExchangeRate() {
		return pricingExchangeRate;
	}

	public void setPricingExchangeRate(ExchangeRate pricingExchangeRate) {
		this.pricingExchangeRate = pricingExchangeRate;
	}

	public ExchangeRate getPaymentExchangeRate() {
		return paymentExchangeRate;
	}

	public void setPaymentExchangeRate(ExchangeRate paymentExchangeRate) {
		this.paymentExchangeRate = paymentExchangeRate;
	}

	public ExchangeRate getTaxExchangeRate() {
		return taxExchangeRate;
	}

	public void setTaxExchangeRate(ExchangeRate taxExchangeRate) {
		this.taxExchangeRate = taxExchangeRate;
	}

	public MonetaryTotal getAnticipatedMonetaryTotal() {
		return anticipatedMonetaryTotal;
	}

	public void setAnticipatedMonetaryTotal(MonetaryTotal anticipatedMonetaryTotal) {
		this.anticipatedMonetaryTotal = anticipatedMonetaryTotal;
	}

	public OrderLine getM_OrderLine() {
		return m_OrderLine;
	}

	public void setM_OrderLine(OrderLine m_OrderLine) {
		this.m_OrderLine = m_OrderLine;
	}

	public OrderReference getM_OrderReference() {
		return m_OrderReference;
	}

	public void setM_OrderReference(OrderReference m_OrderReference) {
		this.m_OrderReference = m_OrderReference;
	}

	public Party getFreightForwarderParty() {
		return freightForwarderParty;
	}

	public void setFreightForwarderParty(Party freightForwarderParty) {
		this.freightForwarderParty = freightForwarderParty;
	}

	public PaymentMeans getM_PaymentMeans() {
		return m_PaymentMeans;
	}

	public void setM_PaymentMeans(PaymentMeans m_PaymentMeans) {
		this.m_PaymentMeans = m_PaymentMeans;
	}

	public PaymentTerms getM_PaymentTerms() {
		return m_PaymentTerms;
	}

	public void setM_PaymentTerms(PaymentTerms m_PaymentTerms) {
		this.m_PaymentTerms = m_PaymentTerms;
	}

	public Period getValidityPeriod() {
		return validityPeriod;
	}

	public void setValidityPeriod(Period validityPeriod) {
		this.validityPeriod = validityPeriod;
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

	public SupplierParty getAccountingSupplierParty() {
		return accountingSupplierParty;
	}

	public void setAccountingSupplierParty(SupplierParty accountingSupplierParty) {
		this.accountingSupplierParty = accountingSupplierParty;
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
}// end Order Change