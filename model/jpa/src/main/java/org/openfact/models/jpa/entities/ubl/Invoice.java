package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A document used to request payment.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:20:49 a. m.
 */
public class Invoice {

    /**
     * The buyer's accounting code, applied to the Invoice as a whole, expressed
     * as text.
     */
    private String accountingCost;
    /**
     * The buyer's accounting code, applied to the Invoice as a whole.
     */
    private String accountingCostCode;
    /**
     * A reference provided by the buyer used for internal routing of the
     * document.
     */
    private String buyerReference;
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
     * The date on which Invoice is due.
     */
    private LocalDate dueDate;
    /**
     * An identifier for this document, assigned by the sender.
     */
    private String ID;
    /**
     * A code signifying the type of the Invoice.
     */
    private String invoiceTypeCode;
    /**
     * The date, assigned by the sender, on which this document was issued.
     */
    private LocalDate issueDate;
    /**
     * The time, assigned by the sender, at which this document was issued.
     */
    private LocalTime issueTime;
    /**
     * The number of lines in the document.
     */
    private BigDecimal LineCountNumeric;
    /**
     * Free-form text pertinent to this document, conveying information that is
     * not contained explicitly in other structures.
     */
    private String note;
    /**
     * A code signifying the alternative currency used for payment in the
     * Invoice.
     */
    private String paymentAlternativeCurrencyCode;
    /**
     * A code signifying the currency used for payment in the Invoice.
     */
    private String paymentCurrencyCode;
    /**
     * A code signifying the currency used for prices in the Invoice.
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
     * A code signifying the currency used for tax amounts in the Invoice.
     */
    private String taxCurrencyCode;
    /**
     * The date of the Invoice, used to indicate the point at which tax becomes
     * applicable.
     */
    private LocalDate taxPointDate;
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
    private BillingReference m_BillingReference;
    private CustomerParty accountingCustomerParty;
    private CustomerParty buyerCustomerParty;
    private Delivery m_Delivery;
    private DeliveryTerms m_DeliveryTerms;
    private DocumentReference dtatementDocumentReference;
    private DocumentReference receiptDocumentReference;
    private DocumentReference despatchDocumentReference;
    private DocumentReference originatorDocumentReference;
    private DocumentReference contractDocumentReference;
    private DocumentReference additionalDocumentReference;
    private ExchangeRate taxExchangeRate;
    private ExchangeRate pricingExchangeRate;
    private ExchangeRate paymentExchangeRate;
    private ExchangeRate paymentAlternativeExchangeRate;
    private InvoiceLine m_InvoiceLine;
    private MonetaryTotal LegalMonetaryTotal;
    private OrderReference m_OrderReference;
    private Party taxRepresentativeParty;
    private Party payeeParty;
    private Payment prepaidPayment;
    private PaymentMeans m_PaymentMeans;
    private PaymentTerms m_PaymentTerms;
    private Period invoicePeriod;
    private ProjectReference m_ProjectReference;
    private Signature m_Signature;
    private SupplierParty accountingSupplierParty;
    private SupplierParty sellerSupplierParty;
    private TaxTotal withholdingTaxTotal;
    private TaxTotal m_TaxTotal;

    /**
     * @return the accountingCost
     */
    public String getAccountingCost() {
        return accountingCost;
    }

    /**
     * @param accountingCost
     *            the accountingCost to set
     */
    public void setAccountingCost(String accountingCost) {
        this.accountingCost = accountingCost;
    }

    /**
     * @return the accountingCostCode
     */
    public String getAccountingCostCode() {
        return accountingCostCode;
    }

    /**
     * @param accountingCostCode
     *            the accountingCostCode to set
     */
    public void setAccountingCostCode(String accountingCostCode) {
        this.accountingCostCode = accountingCostCode;
    }

    /**
     * @return the buyerReference
     */
    public String getBuyerReference() {
        return buyerReference;
    }

    /**
     * @param buyerReference
     *            the buyerReference to set
     */
    public void setBuyerReference(String buyerReference) {
        this.buyerReference = buyerReference;
    }

    /**
     * @return the copyIndicator
     */
    public boolean isCopyIndicator() {
        return copyIndicator;
    }

    /**
     * @param copyIndicator
     *            the copyIndicator to set
     */
    public void setCopyIndicator(boolean copyIndicator) {
        this.copyIndicator = copyIndicator;
    }

    /**
     * @return the customizationID
     */
    public String getCustomizationID() {
        return customizationID;
    }

    /**
     * @param customizationID
     *            the customizationID to set
     */
    public void setCustomizationID(String customizationID) {
        this.customizationID = customizationID;
    }

    /**
     * @return the documentCurrencyCode
     */
    public String getDocumentCurrencyCode() {
        return documentCurrencyCode;
    }

    /**
     * @param documentCurrencyCode
     *            the documentCurrencyCode to set
     */
    public void setDocumentCurrencyCode(String documentCurrencyCode) {
        this.documentCurrencyCode = documentCurrencyCode;
    }

    /**
     * @return the dueDate
     */
    public LocalDate getDueDate() {
        return dueDate;
    }

    /**
     * @param dueDate
     *            the dueDate to set
     */
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
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
     * @return the invoiceTypeCode
     */
    public String getInvoiceTypeCode() {
        return invoiceTypeCode;
    }

    /**
     * @param invoiceTypeCode
     *            the invoiceTypeCode to set
     */
    public void setInvoiceTypeCode(String invoiceTypeCode) {
        this.invoiceTypeCode = invoiceTypeCode;
    }

    /**
     * @return the issueDate
     */
    public LocalDate getIssueDate() {
        return issueDate;
    }

    /**
     * @param issueDate
     *            the issueDate to set
     */
    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    /**
     * @return the issueTime
     */
    public LocalTime getIssueTime() {
        return issueTime;
    }

    /**
     * @param issueTime
     *            the issueTime to set
     */
    public void setIssueTime(LocalTime issueTime) {
        this.issueTime = issueTime;
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
        return note;
    }

    /**
     * @param note
     *            the note to set
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * @return the paymentAlternativeCurrencyCode
     */
    public String getPaymentAlternativeCurrencyCode() {
        return paymentAlternativeCurrencyCode;
    }

    /**
     * @param paymentAlternativeCurrencyCode
     *            the paymentAlternativeCurrencyCode to set
     */
    public void setPaymentAlternativeCurrencyCode(String paymentAlternativeCurrencyCode) {
        this.paymentAlternativeCurrencyCode = paymentAlternativeCurrencyCode;
    }

    /**
     * @return the paymentCurrencyCode
     */
    public String getPaymentCurrencyCode() {
        return paymentCurrencyCode;
    }

    /**
     * @param paymentCurrencyCode
     *            the paymentCurrencyCode to set
     */
    public void setPaymentCurrencyCode(String paymentCurrencyCode) {
        this.paymentCurrencyCode = paymentCurrencyCode;
    }

    /**
     * @return the pricingCurrencyCode
     */
    public String getPricingCurrencyCode() {
        return pricingCurrencyCode;
    }

    /**
     * @param pricingCurrencyCode
     *            the pricingCurrencyCode to set
     */
    public void setPricingCurrencyCode(String pricingCurrencyCode) {
        this.pricingCurrencyCode = pricingCurrencyCode;
    }

    /**
     * @return the profileExecutionID
     */
    public String getProfileExecutionID() {
        return profileExecutionID;
    }

    /**
     * @param profileExecutionID
     *            the profileExecutionID to set
     */
    public void setProfileExecutionID(String profileExecutionID) {
        this.profileExecutionID = profileExecutionID;
    }

    /**
     * @return the profileID
     */
    public String getProfileID() {
        return profileID;
    }

    /**
     * @param profileID
     *            the profileID to set
     */
    public void setProfileID(String profileID) {
        this.profileID = profileID;
    }

    /**
     * @return the taxCurrencyCode
     */
    public String getTaxCurrencyCode() {
        return taxCurrencyCode;
    }

    /**
     * @param taxCurrencyCode
     *            the taxCurrencyCode to set
     */
    public void setTaxCurrencyCode(String taxCurrencyCode) {
        this.taxCurrencyCode = taxCurrencyCode;
    }

    /**
     * @return the taxPointDate
     */
    public LocalDate getTaxPointDate() {
        return taxPointDate;
    }

    /**
     * @param taxPointDate
     *            the taxPointDate to set
     */
    public void setTaxPointDate(LocalDate taxPointDate) {
        this.taxPointDate = taxPointDate;
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
     * @return the accountingCustomerParty
     */
    public CustomerParty getAccountingCustomerParty() {
        return accountingCustomerParty;
    }

    /**
     * @param accountingCustomerParty
     *            the accountingCustomerParty to set
     */
    public void setAccountingCustomerParty(CustomerParty accountingCustomerParty) {
        this.accountingCustomerParty = accountingCustomerParty;
    }

    /**
     * @return the buyerCustomerParty
     */
    public CustomerParty getBuyerCustomerParty() {
        return buyerCustomerParty;
    }

    /**
     * @param buyerCustomerParty
     *            the buyerCustomerParty to set
     */
    public void setBuyerCustomerParty(CustomerParty buyerCustomerParty) {
        this.buyerCustomerParty = buyerCustomerParty;
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
     * @return the dtatementDocumentReference
     */
    public DocumentReference getDtatementDocumentReference() {
        return dtatementDocumentReference;
    }

    /**
     * @param dtatementDocumentReference
     *            the dtatementDocumentReference to set
     */
    public void setDtatementDocumentReference(DocumentReference dtatementDocumentReference) {
        this.dtatementDocumentReference = dtatementDocumentReference;
    }

    /**
     * @return the receiptDocumentReference
     */
    public DocumentReference getReceiptDocumentReference() {
        return receiptDocumentReference;
    }

    /**
     * @param receiptDocumentReference
     *            the receiptDocumentReference to set
     */
    public void setReceiptDocumentReference(DocumentReference receiptDocumentReference) {
        this.receiptDocumentReference = receiptDocumentReference;
    }

    /**
     * @return the despatchDocumentReference
     */
    public DocumentReference getDespatchDocumentReference() {
        return despatchDocumentReference;
    }

    /**
     * @param despatchDocumentReference
     *            the despatchDocumentReference to set
     */
    public void setDespatchDocumentReference(DocumentReference despatchDocumentReference) {
        this.despatchDocumentReference = despatchDocumentReference;
    }

    /**
     * @return the originatorDocumentReference
     */
    public DocumentReference getOriginatorDocumentReference() {
        return originatorDocumentReference;
    }

    /**
     * @param originatorDocumentReference
     *            the originatorDocumentReference to set
     */
    public void setOriginatorDocumentReference(DocumentReference originatorDocumentReference) {
        this.originatorDocumentReference = originatorDocumentReference;
    }

    /**
     * @return the contractDocumentReference
     */
    public DocumentReference getContractDocumentReference() {
        return contractDocumentReference;
    }

    /**
     * @param contractDocumentReference
     *            the contractDocumentReference to set
     */
    public void setContractDocumentReference(DocumentReference contractDocumentReference) {
        this.contractDocumentReference = contractDocumentReference;
    }

    /**
     * @return the additionalDocumentReference
     */
    public DocumentReference getAdditionalDocumentReference() {
        return additionalDocumentReference;
    }

    /**
     * @param additionalDocumentReference
     *            the additionalDocumentReference to set
     */
    public void setAdditionalDocumentReference(DocumentReference additionalDocumentReference) {
        this.additionalDocumentReference = additionalDocumentReference;
    }

    /**
     * @return the taxExchangeRate
     */
    public ExchangeRate getTaxExchangeRate() {
        return taxExchangeRate;
    }

    /**
     * @param taxExchangeRate
     *            the taxExchangeRate to set
     */
    public void setTaxExchangeRate(ExchangeRate taxExchangeRate) {
        this.taxExchangeRate = taxExchangeRate;
    }

    /**
     * @return the pricingExchangeRate
     */
    public ExchangeRate getPricingExchangeRate() {
        return pricingExchangeRate;
    }

    /**
     * @param pricingExchangeRate
     *            the pricingExchangeRate to set
     */
    public void setPricingExchangeRate(ExchangeRate pricingExchangeRate) {
        this.pricingExchangeRate = pricingExchangeRate;
    }

    /**
     * @return the paymentExchangeRate
     */
    public ExchangeRate getPaymentExchangeRate() {
        return paymentExchangeRate;
    }

    /**
     * @param paymentExchangeRate
     *            the paymentExchangeRate to set
     */
    public void setPaymentExchangeRate(ExchangeRate paymentExchangeRate) {
        this.paymentExchangeRate = paymentExchangeRate;
    }

    /**
     * @return the paymentAlternativeExchangeRate
     */
    public ExchangeRate getPaymentAlternativeExchangeRate() {
        return paymentAlternativeExchangeRate;
    }

    /**
     * @param paymentAlternativeExchangeRate
     *            the paymentAlternativeExchangeRate to set
     */
    public void setPaymentAlternativeExchangeRate(ExchangeRate paymentAlternativeExchangeRate) {
        this.paymentAlternativeExchangeRate = paymentAlternativeExchangeRate;
    }

    /**
     * @return the m_InvoiceLine
     */
    public InvoiceLine getM_InvoiceLine() {
        return m_InvoiceLine;
    }

    /**
     * @param m_InvoiceLine
     *            the m_InvoiceLine to set
     */
    public void setM_InvoiceLine(InvoiceLine m_InvoiceLine) {
        this.m_InvoiceLine = m_InvoiceLine;
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
        return taxRepresentativeParty;
    }

    /**
     * @param taxRepresentativeParty
     *            the taxRepresentativeParty to set
     */
    public void setTaxRepresentativeParty(Party taxRepresentativeParty) {
        this.taxRepresentativeParty = taxRepresentativeParty;
    }

    /**
     * @return the payeeParty
     */
    public Party getPayeeParty() {
        return payeeParty;
    }

    /**
     * @param payeeParty
     *            the payeeParty to set
     */
    public void setPayeeParty(Party payeeParty) {
        this.payeeParty = payeeParty;
    }

    /**
     * @return the prepaidPayment
     */
    public Payment getPrepaidPayment() {
        return prepaidPayment;
    }

    /**
     * @param prepaidPayment
     *            the prepaidPayment to set
     */
    public void setPrepaidPayment(Payment prepaidPayment) {
        this.prepaidPayment = prepaidPayment;
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
        return invoicePeriod;
    }

    /**
     * @param invoicePeriod
     *            the invoicePeriod to set
     */
    public void setInvoicePeriod(Period invoicePeriod) {
        this.invoicePeriod = invoicePeriod;
    }

    /**
     * @return the m_ProjectReference
     */
    public ProjectReference getM_ProjectReference() {
        return m_ProjectReference;
    }

    /**
     * @param m_ProjectReference
     *            the m_ProjectReference to set
     */
    public void setM_ProjectReference(ProjectReference m_ProjectReference) {
        this.m_ProjectReference = m_ProjectReference;
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
     * @return the accountingSupplierParty
     */
    public SupplierParty getAccountingSupplierParty() {
        return accountingSupplierParty;
    }

    /**
     * @param accountingSupplierParty
     *            the accountingSupplierParty to set
     */
    public void setAccountingSupplierParty(SupplierParty accountingSupplierParty) {
        this.accountingSupplierParty = accountingSupplierParty;
    }

    /**
     * @return the sellerSupplierParty
     */
    public SupplierParty getSellerSupplierParty() {
        return sellerSupplierParty;
    }

    /**
     * @param sellerSupplierParty
     *            the sellerSupplierParty to set
     */
    public void setSellerSupplierParty(SupplierParty sellerSupplierParty) {
        this.sellerSupplierParty = sellerSupplierParty;
    }

    /**
     * @return the withholdingTaxTotal
     */
    public TaxTotal getWithholdingTaxTotal() {
        return withholdingTaxTotal;
    }

    /**
     * @param withholdingTaxTotal
     *            the withholdingTaxTotal to set
     */
    public void setWithholdingTaxTotal(TaxTotal withholdingTaxTotal) {
        this.withholdingTaxTotal = withholdingTaxTotal;
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

}