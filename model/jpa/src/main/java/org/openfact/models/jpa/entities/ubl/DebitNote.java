package org.openfact.models.jpa.entities.ubl;

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
    private AllowanceCharge m_AllowanceCharge;
    private BillingReference m_BillingReference;
    private CustomerParty accountingCustomerParty;
    private CustomerParty buyerCustomerParty;
    private DebitNoteLine m_DebitNoteLine;
    private Delivery m_Delivery;
    private DeliveryTerms m_DeliveryTerms;
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
    private OrderReference m_OrderReference;
    private Party taxRepresentativeParty;
    private Party payeeParty;
    private Payment prepaidPayment;
    private PaymentMeans m_PaymentMeans;
    private PaymentTerms m_PaymentTerms;
    private Period iInvoicePeriod;

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

    public AllowanceCharge getM_AllowanceCharge() {
        return m_AllowanceCharge;
    }

    public void setM_AllowanceCharge(AllowanceCharge m_AllowanceCharge) {
        this.m_AllowanceCharge = m_AllowanceCharge;
    }

    public BillingReference getM_BillingReference() {
        return m_BillingReference;
    }

    public void setM_BillingReference(BillingReference m_BillingReference) {
        this.m_BillingReference = m_BillingReference;
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

    public DebitNoteLine getM_DebitNoteLine() {
        return m_DebitNoteLine;
    }

    public void setM_DebitNoteLine(DebitNoteLine m_DebitNoteLine) {
        this.m_DebitNoteLine = m_DebitNoteLine;
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

    public OrderReference getM_OrderReference() {
        return m_OrderReference;
    }

    public void setM_OrderReference(OrderReference m_OrderReference) {
        this.m_OrderReference = m_OrderReference;
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

    public Signature getM_Signature() {
        return m_Signature;
    }

    public void setM_Signature(Signature m_Signature) {
        this.m_Signature = m_Signature;
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

    public TaxTotal getM_TaxTotal() {
        return m_TaxTotal;
    }

    public void setM_TaxTotal(TaxTotal m_TaxTotal) {
        this.m_TaxTotal = m_TaxTotal;
    }

    private Response discrepancyResponse;
    private Signature m_Signature;
    private SupplierParty accountingSupplierParty;
    private SupplierParty sellerSupplierParty;
    private TaxTotal m_TaxTotal;

    public DebitNote() {

    }

}// end Debit Note