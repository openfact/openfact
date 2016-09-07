package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A document used to specify debts incurred by the Debtor.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:20:27 a. m.
 */
public class DebitNote {

	/**
	 * The Buyer's accounting code, applied to the Credit Note as a whole,
	 * expressed as text.
	 */
	private String accountingCost;
	/**
	 * The Buyer's accounting code, applied to the Credit Note as a whole.
	 */
	private String accountingCostCode;
	/**
	 * Indicates whether this document is a copy (true) or not (false).
	 */
	private boolean copyIndicator;
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
	 * The number of Debit Note Lines in this document.
	 */
	private BigDecimal lineCountNumeric;
	/**
	 * Free-form text pertinent to this document, conveying information that is
	 * not contained explicitly in other structures.
	 */
	private String note;
	/**
	 * A code signifying the alternative currency used for payment in the Debit
	 * Note.
	 */
	private String paymentAlternativeCurrencyCode;
	/**
	 * A code signifying the currency used for payment in the Debit Note.
	 */
	private String paymentCurrencyCode;
	/**
	 * A code signifying the currency used for prices in the Debit Note.
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
	 * A code signifying the currency used for tax amounts in the Debit Note.
	 */
	private String taxCurrencyCode;
	/**
	 * The date of the Debit Note, used to indicate the point at which tax
	 * becomes applicable.
	 */
	private LocalDate taxPointDate;
	/**
	 * Identifies the earliest version of the UBL 2 schema for this document
	 * type that defines all of the elements that might be encountered in the
	 * current instance.
	 */
	private String uBLVersionID;
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private String UUID;
	private List<AllowanceCharge> allowanceCharges=new ArrayList<>();
	private List<BillingReference> billingReferences=new ArrayList<>();
	private CustomerParty accountingCustomerParty;
	private CustomerParty buyerCustomerParty;
	private List< DebitNoteLine> DebitNoteLines=new ArrayList<>();
	private List<Delivery> deliveries=new ArrayList<>();
	private List<DeliveryTerms> deliveryTerms=new ArrayList<>();
	private DocumentReference additionalDocumentReference;
	private DocumentReference contractDocumentReference;
	private DocumentReference despatchDocumentReference;
	private DocumentReference receiptDocumentReference;
	private DocumentReference statementDocumentReference;
	private ExchangeRate paymentAlternativeExchangeRate;
	private ExchangeRate paymentExchangeRate;
	private ExchangeRate pricingExchangeRate;
	private ExchangeRate taxExchangeRate;
	private MonetaryTotal requestedMonetaryTotal;
	private List<OrderReference> orderReferences=new ArrayList<>();
	private Party taxRepresentativeParty;
	private Party payeeParty;
	private Payment prepaidPayment;
	private List<PaymentMeans> paymentMeans=new ArrayList<>();
	private List<PaymentTerms> paymentTerms=new ArrayList<>();
	private Period iInvoicePeriod;
	private Response discrepancyResponse;
	private List<Signature> signatures=new ArrayList<>();
	private SupplierParty accountingSupplierParty;
	private SupplierParty sellerSupplierParty;
	private List<TaxTotal> taxTotals=new ArrayList<>();

	public DebitNote() {

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

	public String getPaymentAlternativeCurrencyCode() {
		return paymentAlternativeCurrencyCode;
	}

	public void setPaymentAlternativeCurrencyCode(String paymentAlternativeCurrencyCode) {
		this.paymentAlternativeCurrencyCode = paymentAlternativeCurrencyCode;
	}

	public String getPaymentCurrencyCode() {
		return paymentCurrencyCode;
	}

	public void setPaymentCurrencyCode(String paymentCurrencyCode) {
		this.paymentCurrencyCode = paymentCurrencyCode;
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

	public String getTaxCurrencyCode() {
		return taxCurrencyCode;
	}

	public void setTaxCurrencyCode(String taxCurrencyCode) {
		this.taxCurrencyCode = taxCurrencyCode;
	}

	public LocalDate getTaxPointDate() {
		return taxPointDate;
	}

	public void setTaxPointDate(LocalDate taxPointDate) {
		this.taxPointDate = taxPointDate;
	}

	public String getuBLVersionID() {
		return uBLVersionID;
	}

	public void setuBLVersionID(String uBLVersionID) {
		this.uBLVersionID = uBLVersionID;
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
		allowanceCharges = allowanceCharges;
	}

	public List<BillingReference> getBillingReferences() {
		return billingReferences;
	}

	public void setBillingReferences(List<BillingReference> billingReferences) {
		billingReferences = billingReferences;
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

	public List<DebitNoteLine> getDebitNoteLines() {
		return DebitNoteLines;
	}

	public void setDebitNoteLines(List<DebitNoteLine> debitNoteLines) {
		DebitNoteLines = debitNoteLines;
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

    public List<DeliveryTerms> getDeliveryTermss() {
		return deliveryTerms;
	}

	public void setDeliveryTermss(List<DeliveryTerms> deliveryTermss) {
		deliveryTermss = deliveryTermss;
	}

	public DocumentReference getAdditionalDocumentReference() {
		return additionalDocumentReference;
	}

	public void setAdditionalDocumentReference(DocumentReference additionalDocumentReference) {
		this.additionalDocumentReference = additionalDocumentReference;
	}

	public DocumentReference getContractDocumentReference() {
		return contractDocumentReference;
	}

	public void setContractDocumentReference(DocumentReference contractDocumentReference) {
		this.contractDocumentReference = contractDocumentReference;
	}

	public DocumentReference getDespatchDocumentReference() {
		return despatchDocumentReference;
	}

	public void setDespatchDocumentReference(DocumentReference despatchDocumentReference) {
		this.despatchDocumentReference = despatchDocumentReference;
	}

	public DocumentReference getReceiptDocumentReference() {
		return receiptDocumentReference;
	}

	public void setReceiptDocumentReference(DocumentReference receiptDocumentReference) {
		this.receiptDocumentReference = receiptDocumentReference;
	}

	public DocumentReference getStatementDocumentReference() {
		return statementDocumentReference;
	}

	public void setStatementDocumentReference(DocumentReference statementDocumentReference) {
		this.statementDocumentReference = statementDocumentReference;
	}

	public ExchangeRate getPaymentAlternativeExchangeRate() {
		return paymentAlternativeExchangeRate;
	}

	public void setPaymentAlternativeExchangeRate(ExchangeRate paymentAlternativeExchangeRate) {
		this.paymentAlternativeExchangeRate = paymentAlternativeExchangeRate;
	}

	public ExchangeRate getPaymentExchangeRate() {
		return paymentExchangeRate;
	}

	public void setPaymentExchangeRate(ExchangeRate paymentExchangeRate) {
		this.paymentExchangeRate = paymentExchangeRate;
	}

	public ExchangeRate getPricingExchangeRate() {
		return pricingExchangeRate;
	}

	public void setPricingExchangeRate(ExchangeRate pricingExchangeRate) {
		this.pricingExchangeRate = pricingExchangeRate;
	}

	public ExchangeRate getTaxExchangeRate() {
		return taxExchangeRate;
	}

	public void setTaxExchangeRate(ExchangeRate taxExchangeRate) {
		this.taxExchangeRate = taxExchangeRate;
	}

	public MonetaryTotal getRequestedMonetaryTotal() {
		return requestedMonetaryTotal;
	}

	public void setRequestedMonetaryTotal(MonetaryTotal requestedMonetaryTotal) {
		this.requestedMonetaryTotal = requestedMonetaryTotal;
	}

	public List<OrderReference> getOrderReferences() {
		return orderReferences;
	}

	public void setOrderReferences(List<OrderReference> orderReferences) {
		orderReferences = orderReferences;
	}

	public Party getTaxRepresentativeParty() {
		return taxRepresentativeParty;
	}

	public void setTaxRepresentativeParty(Party taxRepresentativeParty) {
		this.taxRepresentativeParty = taxRepresentativeParty;
	}

	public Party getPayeeParty() {
		return payeeParty;
	}

	public void setPayeeParty(Party payeeParty) {
		this.payeeParty = payeeParty;
	}

	public Payment getPrepaidPayment() {
		return prepaidPayment;
	}

	public void setPrepaidPayment(Payment prepaidPayment) {
		this.prepaidPayment = prepaidPayment;
	}

	public List<PaymentMeans> getPaymentMeanss() {
		return paymentMeans;
	}

	public void setPaymentMeanss(List<PaymentMeans> paymentMeanss) {
		paymentMeans = paymentMeanss;
	}

	public List<PaymentTerms> getPaymentTermss() {
		return paymentTerms;
	}

	public void setPaymentTermss(List<PaymentTerms> paymentTermss) {
		paymentTerms = paymentTermss;
	}

	public Period getiInvoicePeriod() {
		return iInvoicePeriod;
	}

	public void setiInvoicePeriod(Period iInvoicePeriod) {
		this.iInvoicePeriod = iInvoicePeriod;
	}

	public Response getDiscrepancyResponse() {
		return discrepancyResponse;
	}

	public void setDiscrepancyResponse(Response discrepancyResponse) {
		this.discrepancyResponse = discrepancyResponse;
	}

	public List<Signature> getSignatures() {
		return signatures;
	}

	public void setSignatures(List<Signature> signatures) {
		signatures = signatures;
	}

	public SupplierParty getAccountingSupplierParty() {
		return accountingSupplierParty;
	}

	public void setAccountingSupplierParty(SupplierParty accountingSupplierParty) {
		this.accountingSupplierParty = accountingSupplierParty;
	}

	public SupplierParty getSellerSupplierParty() {
		return sellerSupplierParty;
	}

	public void setSellerSupplierParty(SupplierParty sellerSupplierParty) {
		this.sellerSupplierParty = sellerSupplierParty;
	}

	public List<TaxTotal> getTaxTotals() {
		return taxTotals;
	}

	public void setTaxTotals(List<TaxTotal> taxTotals) {
		taxTotals = taxTotals;
	}
}// end Debit Note