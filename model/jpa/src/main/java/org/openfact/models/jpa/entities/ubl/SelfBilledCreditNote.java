package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A credit note created by the debtor in a self billing arrangement with a
 * creditor; Self Billed Credit Note replaces Debit Note in such arrangements.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:21:22 a. m.
 */
public class SelfBilledCreditNote {

	/**
	 * The buyer's accounting code, applied to the Self Billed Credit Note as a
	 * whole, expressed as text.
	 */
	private String AccountingCost;
	/**
	 * The buyer's accounting code, applied to the Self Billed Credit Note as a
	 * whole.
	 */
	private String AccountingCostCode;
	/**
	 * Indicates whether this document is a copy (true) or not (false).
	 */
	private boolean CopyIndicator;
	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private String CustomizationID;
	/**
	 * A code signifying the default currency for this document.
	 */
	private String DocumentCurrencyCode;
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
	 * The number of Self Billed Credit Note Lines in this document.
	 */
	private BigDecimal LineCountNumeric;
	/**
	 * Free-form text pertinent to this document, conveying information that is
	 * not contained explicitly in other structures.
	 */
	private String Note;
	/**
	 * A code signifying the alternative currency used for payment in the Self
	 * Billed Credit Note.
	 */
	private String PaymentAlternativeCurrencyCode;
	/**
	 * A code signifying the currency used for payment in the Self Billed Credit
	 * Note.
	 */
	private String PaymentCurrencyCode;
	/**
	 * A code signifying the currency used for prices in the Self Billed Credit
	 * Note.
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
	 * A code signifying the currency used for tax amounts in the Self Billed
	 * Credit Note.
	 */
	private String TaxCurrencyCode;
	/**
	 * The date of the Self Billed Credit Note, used to indicate the point at
	 * which tax becomes applicable.
	 */
	private LocalDate TaxPointDate;
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
	private BillingReference m_BillingReference;
	private CreditNoteLine m_CreditNoteLine;
	private CustomerParty AccountingCustomerParty;
	private CustomerParty BuyerCustomerParty;
	private List<Delivery> deliveries = new ArrayList<>();
	private List<DeliveryTerms> deliveryTerms = new ArrayList<>(); 
	private DocumentReference ContractDocumentReference;
	private DocumentReference OriginatorDocumentReference;
	private DocumentReference StatementDocumentReference;
	private DocumentReference DespatchDocumentReference;
	private DocumentReference ReceiptDocumentReference;
	private DocumentReference AdditionalDocumentReference;
	private ExchangeRate PricingExchangeRate;
	private ExchangeRate PaymentAlternativeExchangeRate;
	private ExchangeRate PaymentExchangeRate;
	private ExchangeRate TaxExchangeRate;
	private MonetaryTotal LegalMonetaryTotal;
	private List<OrderReference> orderReferences = new ArrayList<>();
	private Party TaxRepresentativeParty;
	private Party PayeeParty;
	private List<PaymentMeans> paymentMeans = new ArrayList<>();
	private List<PaymentTerms> paymentTerms = new ArrayList<>();
	private Period InvoicePeriod;
	private Response DiscrepancyResponse;
	private List<Signature> signatures = new ArrayList<>();
	private SupplierParty SellerSupplierParty;
	private SupplierParty AccountingSupplierParty;
	private List<TaxTotal> taxTotals = new ArrayList<>();

	public SelfBilledCreditNote() {

	}

	public void finalize() throws Throwable {

	}

	/**
	 * @return the accountingCost
	 */
	public String getAccountingCost() {
		return AccountingCost;
	}

	/**
	 * @param accountingCost
	 *            the accountingCost to set
	 */
	public void setAccountingCost(String accountingCost) {
		AccountingCost = accountingCost;
	}

	/**
	 * @return the accountingCostCode
	 */
	public String getAccountingCostCode() {
		return AccountingCostCode;
	}

	/**
	 * @param accountingCostCode
	 *            the accountingCostCode to set
	 */
	public void setAccountingCostCode(String accountingCostCode) {
		AccountingCostCode = accountingCostCode;
	}

	/**
	 * @return the copyIndicator
	 */
	public boolean isCopyIndicator() {
		return CopyIndicator;
	}

	/**
	 * @param copyIndicator
	 *            the copyIndicator to set
	 */
	public void setCopyIndicator(boolean copyIndicator) {
		CopyIndicator = copyIndicator;
	}

	/**
	 * @return the customizationID
	 */
	public String getCustomizationID() {
		return CustomizationID;
	}

	/**
	 * @param customizationID
	 *            the customizationID to set
	 */
	public void setCustomizationID(String customizationID) {
		CustomizationID = customizationID;
	}

	/**
	 * @return the documentCurrencyCode
	 */
	public String getDocumentCurrencyCode() {
		return DocumentCurrencyCode;
	}

	/**
	 * @param documentCurrencyCode
	 *            the documentCurrencyCode to set
	 */
	public void setDocumentCurrencyCode(String documentCurrencyCode) {
		DocumentCurrencyCode = documentCurrencyCode;
	}

	/**
	 * @return the iD
	 */
	public String getID() {
		return ID;
	}

	/**
	 * @param iD
	 *            the iD to set
	 */
	public void setID(String iD) {
		ID = iD;
	}

	/**
	 * @return the issueDate
	 */
	public LocalDate getIssueDate() {
		return IssueDate;
	}

	/**
	 * @param issueDate
	 *            the issueDate to set
	 */
	public void setIssueDate(LocalDate issueDate) {
		IssueDate = issueDate;
	}

	/**
	 * @return the issueTime
	 */
	public LocalTime getIssueTime() {
		return IssueTime;
	}

	/**
	 * @param issueTime
	 *            the issueTime to set
	 */
	public void setIssueTime(LocalTime issueTime) {
		IssueTime = issueTime;
	}

	/**
	 * @return the lineCountNumeric
	 */
	public BigDecimal getLineCountNumeric() {
		return LineCountNumeric;
	}

	/**
	 * @param lineCountNumeric
	 *            the lineCountNumeric to set
	 */
	public void setLineCountNumeric(BigDecimal lineCountNumeric) {
		LineCountNumeric = lineCountNumeric;
	}

	/**
	 * @return the note
	 */
	public String getNote() {
		return Note;
	}

	/**
	 * @param note
	 *            the note to set
	 */
	public void setNote(String note) {
		Note = note;
	}

	/**
	 * @return the paymentAlternativeCurrencyCode
	 */
	public String getPaymentAlternativeCurrencyCode() {
		return PaymentAlternativeCurrencyCode;
	}

	/**
	 * @param paymentAlternativeCurrencyCode
	 *            the paymentAlternativeCurrencyCode to set
	 */
	public void setPaymentAlternativeCurrencyCode(String paymentAlternativeCurrencyCode) {
		PaymentAlternativeCurrencyCode = paymentAlternativeCurrencyCode;
	}

	/**
	 * @return the paymentCurrencyCode
	 */
	public String getPaymentCurrencyCode() {
		return PaymentCurrencyCode;
	}

	/**
	 * @param paymentCurrencyCode
	 *            the paymentCurrencyCode to set
	 */
	public void setPaymentCurrencyCode(String paymentCurrencyCode) {
		PaymentCurrencyCode = paymentCurrencyCode;
	}

	/**
	 * @return the pricingCurrencyCode
	 */
	public String getPricingCurrencyCode() {
		return PricingCurrencyCode;
	}

	/**
	 * @param pricingCurrencyCode
	 *            the pricingCurrencyCode to set
	 */
	public void setPricingCurrencyCode(String pricingCurrencyCode) {
		PricingCurrencyCode = pricingCurrencyCode;
	}

	/**
	 * @return the profileExecutionID
	 */
	public String getProfileExecutionID() {
		return ProfileExecutionID;
	}

	/**
	 * @param profileExecutionID
	 *            the profileExecutionID to set
	 */
	public void setProfileExecutionID(String profileExecutionID) {
		ProfileExecutionID = profileExecutionID;
	}

	/**
	 * @return the profileID
	 */
	public String getProfileID() {
		return ProfileID;
	}

	/**
	 * @param profileID
	 *            the profileID to set
	 */
	public void setProfileID(String profileID) {
		ProfileID = profileID;
	}

	/**
	 * @return the taxCurrencyCode
	 */
	public String getTaxCurrencyCode() {
		return TaxCurrencyCode;
	}

	/**
	 * @param taxCurrencyCode
	 *            the taxCurrencyCode to set
	 */
	public void setTaxCurrencyCode(String taxCurrencyCode) {
		TaxCurrencyCode = taxCurrencyCode;
	}

	/**
	 * @return the taxPointDate
	 */
	public LocalDate getTaxPointDate() {
		return TaxPointDate;
	}

	/**
	 * @param taxPointDate
	 *            the taxPointDate to set
	 */
	public void setTaxPointDate(LocalDate taxPointDate) {
		TaxPointDate = taxPointDate;
	}

	/**
	 * @return the uBLVersionID
	 */
	public String getUBLVersionID() {
		return UBLVersionID;
	}

	/**
	 * @param uBLVersionID
	 *            the uBLVersionID to set
	 */
	public void setUBLVersionID(String uBLVersionID) {
		UBLVersionID = uBLVersionID;
	}

	/**
	 * @return the uUID
	 */
	public String getUUID() {
		return UUID;
	}

	/**
	 * @param uUID
	 *            the uUID to set
	 */
	public void setUUID(String uUID) {
		UUID = uUID;
	}

	/**
	 * @return the m_AllowanceCharge
	 */
	public AllowanceCharge getM_AllowanceCharge() {
		return m_AllowanceCharge;
	}

	/**
	 * @param m_AllowanceCharge
	 *            the m_AllowanceCharge to set
	 */
	public void setM_AllowanceCharge(AllowanceCharge m_AllowanceCharge) {
		this.m_AllowanceCharge = m_AllowanceCharge;
	}

	/**
	 * @return the m_BillingReference
	 */
	public BillingReference getM_BillingReference() {
		return m_BillingReference;
	}

	/**
	 * @param m_BillingReference
	 *            the m_BillingReference to set
	 */
	public void setM_BillingReference(BillingReference m_BillingReference) {
		this.m_BillingReference = m_BillingReference;
	}

	/**
	 * @return the m_CreditNoteLine
	 */
	public CreditNoteLine getM_CreditNoteLine() {
		return m_CreditNoteLine;
	}

	/**
	 * @param m_CreditNoteLine
	 *            the m_CreditNoteLine to set
	 */
	public void setM_CreditNoteLine(CreditNoteLine m_CreditNoteLine) {
		this.m_CreditNoteLine = m_CreditNoteLine;
	}

	/**
	 * @return the accountingCustomerParty
	 */
	public CustomerParty getAccountingCustomerParty() {
		return AccountingCustomerParty;
	}

	/**
	 * @param accountingCustomerParty
	 *            the accountingCustomerParty to set
	 */
	public void setAccountingCustomerParty(CustomerParty accountingCustomerParty) {
		AccountingCustomerParty = accountingCustomerParty;
	}

	/**
	 * @return the buyerCustomerParty
	 */
	public CustomerParty getBuyerCustomerParty() {
		return BuyerCustomerParty;
	}

	/**
	 * @param buyerCustomerParty
	 *            the buyerCustomerParty to set
	 */
	public void setBuyerCustomerParty(CustomerParty buyerCustomerParty) {
		BuyerCustomerParty = buyerCustomerParty;
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
	 * @return the contractDocumentReference
	 */
	public DocumentReference getContractDocumentReference() {
		return ContractDocumentReference;
	}

	/**
	 * @param contractDocumentReference
	 *            the contractDocumentReference to set
	 */
	public void setContractDocumentReference(DocumentReference contractDocumentReference) {
		ContractDocumentReference = contractDocumentReference;
	}

	/**
	 * @return the originatorDocumentReference
	 */
	public DocumentReference getOriginatorDocumentReference() {
		return OriginatorDocumentReference;
	}

	/**
	 * @param originatorDocumentReference
	 *            the originatorDocumentReference to set
	 */
	public void setOriginatorDocumentReference(DocumentReference originatorDocumentReference) {
		OriginatorDocumentReference = originatorDocumentReference;
	}

	/**
	 * @return the statementDocumentReference
	 */
	public DocumentReference getStatementDocumentReference() {
		return StatementDocumentReference;
	}

	/**
	 * @param statementDocumentReference
	 *            the statementDocumentReference to set
	 */
	public void setStatementDocumentReference(DocumentReference statementDocumentReference) {
		StatementDocumentReference = statementDocumentReference;
	}

	/**
	 * @return the despatchDocumentReference
	 */
	public DocumentReference getDespatchDocumentReference() {
		return DespatchDocumentReference;
	}

	/**
	 * @param despatchDocumentReference
	 *            the despatchDocumentReference to set
	 */
	public void setDespatchDocumentReference(DocumentReference despatchDocumentReference) {
		DespatchDocumentReference = despatchDocumentReference;
	}

	/**
	 * @return the receiptDocumentReference
	 */
	public DocumentReference getReceiptDocumentReference() {
		return ReceiptDocumentReference;
	}

	/**
	 * @param receiptDocumentReference
	 *            the receiptDocumentReference to set
	 */
	public void setReceiptDocumentReference(DocumentReference receiptDocumentReference) {
		ReceiptDocumentReference = receiptDocumentReference;
	}

	/**
	 * @return the additionalDocumentReference
	 */
	public DocumentReference getAdditionalDocumentReference() {
		return AdditionalDocumentReference;
	}

	/**
	 * @param additionalDocumentReference
	 *            the additionalDocumentReference to set
	 */
	public void setAdditionalDocumentReference(DocumentReference additionalDocumentReference) {
		AdditionalDocumentReference = additionalDocumentReference;
	}

	/**
	 * @return the pricingExchangeRate
	 */
	public ExchangeRate getPricingExchangeRate() {
		return PricingExchangeRate;
	}

	/**
	 * @param pricingExchangeRate
	 *            the pricingExchangeRate to set
	 */
	public void setPricingExchangeRate(ExchangeRate pricingExchangeRate) {
		PricingExchangeRate = pricingExchangeRate;
	}

	/**
	 * @return the paymentAlternativeExchangeRate
	 */
	public ExchangeRate getPaymentAlternativeExchangeRate() {
		return PaymentAlternativeExchangeRate;
	}

	/**
	 * @param paymentAlternativeExchangeRate
	 *            the paymentAlternativeExchangeRate to set
	 */
	public void setPaymentAlternativeExchangeRate(ExchangeRate paymentAlternativeExchangeRate) {
		PaymentAlternativeExchangeRate = paymentAlternativeExchangeRate;
	}

	/**
	 * @return the paymentExchangeRate
	 */
	public ExchangeRate getPaymentExchangeRate() {
		return PaymentExchangeRate;
	}

	/**
	 * @param paymentExchangeRate
	 *            the paymentExchangeRate to set
	 */
	public void setPaymentExchangeRate(ExchangeRate paymentExchangeRate) {
		PaymentExchangeRate = paymentExchangeRate;
	}

	/**
	 * @return the taxExchangeRate
	 */
	public ExchangeRate getTaxExchangeRate() {
		return TaxExchangeRate;
	}

	/**
	 * @param taxExchangeRate
	 *            the taxExchangeRate to set
	 */
	public void setTaxExchangeRate(ExchangeRate taxExchangeRate) {
		TaxExchangeRate = taxExchangeRate;
	}

	/**
	 * @return the legalMonetaryTotal
	 */
	public MonetaryTotal getLegalMonetaryTotal() {
		return LegalMonetaryTotal;
	}

	/**
	 * @param legalMonetaryTotal
	 *            the legalMonetaryTotal to set
	 */
	public void setLegalMonetaryTotal(MonetaryTotal legalMonetaryTotal) {
		LegalMonetaryTotal = legalMonetaryTotal;
	}

	/**
	 * @return the m_OrderReference
	 */
	public OrderReference getM_OrderReference() {
		return m_OrderReference;
	}

	/**
	 * @param m_OrderReference
	 *            the m_OrderReference to set
	 */
	public void setM_OrderReference(OrderReference m_OrderReference) {
		this.m_OrderReference = m_OrderReference;
	}

	/**
	 * @return the taxRepresentativeParty
	 */
	public Party getTaxRepresentativeParty() {
		return TaxRepresentativeParty;
	}

	/**
	 * @param taxRepresentativeParty
	 *            the taxRepresentativeParty to set
	 */
	public void setTaxRepresentativeParty(Party taxRepresentativeParty) {
		TaxRepresentativeParty = taxRepresentativeParty;
	}

	/**
	 * @return the payeeParty
	 */
	public Party getPayeeParty() {
		return PayeeParty;
	}

	/**
	 * @param payeeParty
	 *            the payeeParty to set
	 */
	public void setPayeeParty(Party payeeParty) {
		PayeeParty = payeeParty;
	}

	/**
	 * @return the m_PaymentMeans
	 */
	public PaymentMeans getM_PaymentMeans() {
		return m_PaymentMeans;
	}

	/**
	 * @param m_PaymentMeans
	 *            the m_PaymentMeans to set
	 */
	public void setM_PaymentMeans(PaymentMeans m_PaymentMeans) {
		this.m_PaymentMeans = m_PaymentMeans;
	}

	/**
	 * @return the m_PaymentTerms
	 */
	public PaymentTerms getM_PaymentTerms() {
		return m_PaymentTerms;
	}

	/**
	 * @param m_PaymentTerms
	 *            the m_PaymentTerms to set
	 */
	public void setM_PaymentTerms(PaymentTerms m_PaymentTerms) {
		this.m_PaymentTerms = m_PaymentTerms;
	}

	/**
	 * @return the invoicePeriod
	 */
	public Period getInvoicePeriod() {
		return InvoicePeriod;
	}

	/**
	 * @param invoicePeriod
	 *            the invoicePeriod to set
	 */
	public void setInvoicePeriod(Period invoicePeriod) {
		InvoicePeriod = invoicePeriod;
	}

	/**
	 * @return the discrepancyResponse
	 */
	public Response getDiscrepancyResponse() {
		return DiscrepancyResponse;
	}

	/**
	 * @param discrepancyResponse
	 *            the discrepancyResponse to set
	 */
	public void setDiscrepancyResponse(Response discrepancyResponse) {
		DiscrepancyResponse = discrepancyResponse;
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
	 * @return the sellerSupplierParty
	 */
	public SupplierParty getSellerSupplierParty() {
		return SellerSupplierParty;
	}

	/**
	 * @param sellerSupplierParty
	 *            the sellerSupplierParty to set
	 */
	public void setSellerSupplierParty(SupplierParty sellerSupplierParty) {
		SellerSupplierParty = sellerSupplierParty;
	}

	/**
	 * @return the accountingSupplierParty
	 */
	public SupplierParty getAccountingSupplierParty() {
		return AccountingSupplierParty;
	}

	/**
	 * @param accountingSupplierParty
	 *            the accountingSupplierParty to set
	 */
	public void setAccountingSupplierParty(SupplierParty accountingSupplierParty) {
		AccountingSupplierParty = accountingSupplierParty;
	}

	/**
	 * @return the m_TaxTotal
	 */
	public TaxTotal getM_TaxTotal() {
		return m_TaxTotal;
	}

	/**
	 * @param m_TaxTotal
	 *            the m_TaxTotal to set
	 */
	public void setM_TaxTotal(TaxTotal m_TaxTotal) {
		this.m_TaxTotal = m_TaxTotal;
	}

}// end Self Billed Credit Note