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
	private String UBLVersionID;
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private String UUID;
	private AllowanceCharge m_AllowanceCharge;
	private Contract m_Contract;
	private Country destinationCountry;
	private CustomerParty originatorCustomerParty;
	private CustomerParty accountingCustomerParty;
	private CustomerParty buyerCustomerParty;
	private Delivery m_Delivery;
	private DeliveryTerms m_DeliveryTerms;
	private DocumentReference additionalDocumentReference;
	private DocumentReference originatorDocumentReference;
	private DocumentReference orderDocumentReference;
	private ExchangeRate taxExchangeRate;
	private ExchangeRate pricingExchangeRate;
	private ExchangeRate paymentExchangeRate;
	private MonetaryTotal legalMonetaryTotal;
	private OrderLine m_OrderLine;
	private OrderReference m_OrderReference;
	private Party freightForwarderParty;
	private PaymentMeans m_PaymentMeans;
	private PaymentTerms m_PaymentTerms;
	private Signature m_Signature;
	private SupplierParty SellerSupplierParty;
	private SupplierParty AccountingSupplierParty;
	private TaxTotal m_TaxTotal;
	private TransactionConditions m_TransactionConditions;

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

	public Signature getM_Signature() {
		return m_Signature;
	}

	public void setM_Signature(Signature m_Signature) {
		this.m_Signature = m_Signature;
	}

	public SupplierParty getSellerSupplierParty() {
		return SellerSupplierParty;
	}

	public void setSellerSupplierParty(SupplierParty sellerSupplierParty) {
		SellerSupplierParty = sellerSupplierParty;
	}

	public SupplierParty getAccountingSupplierParty() {
		return AccountingSupplierParty;
	}

	public void setAccountingSupplierParty(SupplierParty accountingSupplierParty) {
		AccountingSupplierParty = accountingSupplierParty;
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
}// end Order Response