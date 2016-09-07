package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A document used to indicate detailed acceptance or rejection of an Order or
 * to make a counter-offer.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:20:59 a. m.
 */
public class OrderResponse {

	/**
	 * An accounting cost code applied to the order as a whole, expressed as
	 * text.
	 */
	private String accountingCost;
	/**
	 * An accounting cost code applied to the order as a whole.
	 */
	private String accountingCostCode;
	/**
	 * Indicates whether this document is a copy (true) or not (false).
	 */
	private boolean copyIndicator;
	/**
	 * A supplementary reference assigned by the buyer, e.g., the CRI in a
	 * purchasing card transaction.
	 */
	private String customerReference;
	/**
	 * Identifies a user-defined customization of UBL.
	 */
	private String customizationID;
	/**
	 * A code signifying the default currency for this document.
	 */
	private String documentCurrencyCode;
	/**
	 * The total volume of the goods in the Order Response including packaging.
	 */
	private BigDecimal grossVolumeMeasure;
	/**
	 * The total gross weight for the Order Response (goods + packaging +
	 * transport equipment).
	 */
	private BigDecimal grossWeightMeasure;
	/**
	 * An identifier for this document, assigned by the sender.
	 */
	private String id;
	/**
	 * The date, assigned by the sender, on which this document was issued.
	 */
	private LocalDate issueDate;
	/**
	 * The time, assigned by the sender, at which this document was issued.
	 */
	private LocalTime issueTime;
	/**
	 * The number of Order Lines in this document.
	 */
	private BigDecimal lineCountNumeric;
	/**
	 * The total net weight of the goods in the Order Response excluding
	 * packaging.
	 */
	private BigDecimal netNetWeightMeasure;
	/**
	 * The total volume of the goods in the Order Response excluding packaging.
	 */
	private BigDecimal netVolumeMeasure;
	/**
	 * The total net weight for the Order Response (goods + packaging).
	 */
	private BigDecimal netWeightMeasure;
	/**
	 * Free-form text pertinent to this document, conveying information that is
	 * not contained explicitly in other structures.
	 */
	private String note;
	/**
	 * A code signifying the type of response for this Order.
	 */
	private String orderResponseCode;
	/**
	 * A code signifying the currency that is used for all prices in the Order
	 * Response.
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
	 * An identifier for the Order, issued by the Seller.
	 */
	private String salesOrderID;
	/**
	 * A code signifying the currency that is used for all tax amounts in the
	 * Order Response.
	 */
	private String taxCurrencyCode;
	/**
	 * The total number of packages contained in the Order Response.
	 */
	private BigDecimal totalPackagesQuantity;
	/**
	 * Identifies the earliest version of the UBL 2 schema for this document
	 * type that defines all of the elements that might be encountered in the
	 * current instance.
	 */
	private String ublVersionID;
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private String UUID;
	private List<AllowanceCharge> allowanceCharges = new ArrayList<>();
	private List<Contract> contracts = new ArrayList<>();
	private Country destinationCountry;
	private CustomerParty originatorCustomerParty;
	private CustomerParty accountingCustomerParty;
	private CustomerParty buyerCustomerParty;
	private List<Delivery> deliveries = new ArrayList<>();
	private List<DeliveryTerms> deliveryTerms = new ArrayList<>(); 
	private DocumentReference additionalDocumentReference;
	private DocumentReference originatorDocumentReference;
	private DocumentReference orderDocumentReference;
	private ExchangeRate taxExchangeRate;
	private ExchangeRate pricingExchangeRate;
	private ExchangeRate paymentExchangeRate;
	private MonetaryTotal legalMonetaryTotal;
	private List<OrderLine> orderLines = new ArrayList<>();
	private List<OrderReference> orderReferences = new ArrayList<>();
	private Party freightForwarderParty;
	private List<PaymentMeans> paymentMeans = new ArrayList<>();
	private List<PaymentTerms> paymentTerms = new ArrayList<>();
	private List<Signature> signatures = new ArrayList<>();
	private SupplierParty sellerSupplierParty;
	private SupplierParty accountingSupplierParty;
	private List<TaxTotal> taxTotals = new ArrayList<>();
	private List<TransactionConditions> transactionConditions = new ArrayList<>();

	public OrderResponse() {

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

	public BigDecimal getGrossVolumeMeasure() {
		return grossVolumeMeasure;
	}

	public void setGrossVolumeMeasure(BigDecimal grossVolumeMeasure) {
		this.grossVolumeMeasure = grossVolumeMeasure;
	}

	public BigDecimal getGrossWeightMeasure() {
		return grossWeightMeasure;
	}

	public void setGrossWeightMeasure(BigDecimal grossWeightMeasure) {
		this.grossWeightMeasure = grossWeightMeasure;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public BigDecimal getNetNetWeightMeasure() {
		return netNetWeightMeasure;
	}

	public void setNetNetWeightMeasure(BigDecimal netNetWeightMeasure) {
		this.netNetWeightMeasure = netNetWeightMeasure;
	}

	public BigDecimal getNetVolumeMeasure() {
		return netVolumeMeasure;
	}

	public void setNetVolumeMeasure(BigDecimal netVolumeMeasure) {
		this.netVolumeMeasure = netVolumeMeasure;
	}

	public BigDecimal getNetWeightMeasure() {
		return netWeightMeasure;
	}

	public void setNetWeightMeasure(BigDecimal netWeightMeasure) {
		this.netWeightMeasure = netWeightMeasure;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getOrderResponseCode() {
		return orderResponseCode;
	}

	public void setOrderResponseCode(String orderResponseCode) {
		this.orderResponseCode = orderResponseCode;
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

	public String getSalesOrderID() {
		return salesOrderID;
	}

	public void setSalesOrderID(String salesOrderID) {
		this.salesOrderID = salesOrderID;
	}

	public String getTaxCurrencyCode() {
		return taxCurrencyCode;
	}

	public void setTaxCurrencyCode(String taxCurrencyCode) {
		this.taxCurrencyCode = taxCurrencyCode;
	}

	public BigDecimal getTotalPackagesQuantity() {
		return totalPackagesQuantity;
	}

	public void setTotalPackagesQuantity(BigDecimal totalPackagesQuantity) {
		this.totalPackagesQuantity = totalPackagesQuantity;
	}

	public String getUblVersionID() {
		return ublVersionID;
	}

	public void setUblVersionID(String ublVersionID) {
		this.ublVersionID = ublVersionID;
	}

	public String getUUID() {
		return UUID;
	}

	public void setUUID(String UUID) {
		this.UUID = UUID;
	}

	public List<AllowanceCharge> getAllowanceCharges() {
		return allowanceCharges;
	}

	public void setAllowanceCharges(List<AllowanceCharge> allowanceCharges) {
		this.allowanceCharges = allowanceCharges;
	}

	public List<Contract> getContracts() {
		return contracts;
	}

	public void setContracts(List<Contract> contracts) {
		this.contracts = contracts;
	}

	public Country getDestinationCountry() {
		return destinationCountry;
	}

	public void setDestinationCountry(Country destinationCountry) {
		this.destinationCountry = destinationCountry;
	}

	public CustomerParty getOriginatorCustomerParty() {
		return originatorCustomerParty;
	}

	public void setOriginatorCustomerParty(CustomerParty originatorCustomerParty) {
		this.originatorCustomerParty = originatorCustomerParty;
	}

	public CustomerParty getAccountingCustomerParty() {
		return accountingCustomerParty;
	}

	public void setAccountingCustomerParty(CustomerParty accountingCustomerParty) {
		this.accountingCustomerParty = accountingCustomerParty;
	}

	public CustomerParty getBuyerCustomerParty() {
		return buyerCustomerParty;
	}

	public void setBuyerCustomerParty(CustomerParty buyerCustomerParty) {
		this.buyerCustomerParty = buyerCustomerParty;
	}

	public List<Delivery> getDeliveries() {
		return deliveries;
	}

	public void setDeliveries(List<Delivery> deliveries) {
		this.deliveries = deliveries;
	}

	public List<DeliveryTerms> getDeliveryTerms() {
		return deliveryTerms;
	}

	public void setDeliveryTerms(List<DeliveryTerms> deliveryTerms) {
		this.deliveryTerms = deliveryTerms;
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

	public DocumentReference getOrderDocumentReference() {
		return orderDocumentReference;
	}

	public void setOrderDocumentReference(DocumentReference orderDocumentReference) {
		this.orderDocumentReference = orderDocumentReference;
	}

	public ExchangeRate getTaxExchangeRate() {
		return taxExchangeRate;
	}

	public void setTaxExchangeRate(ExchangeRate taxExchangeRate) {
		this.taxExchangeRate = taxExchangeRate;
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

	public MonetaryTotal getLegalMonetaryTotal() {
		return legalMonetaryTotal;
	}

	public void setLegalMonetaryTotal(MonetaryTotal legalMonetaryTotal) {
		this.legalMonetaryTotal = legalMonetaryTotal;
	}

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}

	public List<OrderReference> getOrderReferences() {
		return orderReferences;
	}

	public void setOrderReferences(List<OrderReference> orderReferences) {
		this.orderReferences = orderReferences;
	}

	public Party getFreightForwarderParty() {
		return freightForwarderParty;
	}

	public void setFreightForwarderParty(Party freightForwarderParty) {
		this.freightForwarderParty = freightForwarderParty;
	}

	public List<PaymentMeans> getPaymentMeans() {
		return paymentMeans;
	}

	public void setPaymentMeans(List<PaymentMeans> paymentMeans) {
		this.paymentMeans = paymentMeans;
	}

	public List<PaymentTerms> getPaymentTerms() {
		return paymentTerms;
	}

	public void setPaymentTerms(List<PaymentTerms> paymentTerms) {
		this.paymentTerms = paymentTerms;
	}

	public List<Signature> getSignatures() {
		return signatures;
	}

	public void setSignatures(List<Signature> signatures) {
		this.signatures = signatures;
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

	public List<TaxTotal> getTaxTotals() {
		return taxTotals;
	}

	public void setTaxTotals(List<TaxTotal> taxTotals) {
		this.taxTotals = taxTotals;
	}

	public List<TransactionConditions> getTransactionConditions() {
		return transactionConditions;
	}

	public void setTransactionConditions(List<TransactionConditions> transactionConditions) {
		this.transactionConditions = transactionConditions;
	}
}// end Order Response