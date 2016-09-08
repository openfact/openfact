package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

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
    private String typeDocumentCurrencyCode;
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
    private BigDecimal lineCountNumeric;
    /**
     * Free-form text pertinent to this document, conveying information that is
     * not contained explicitly in other structures.
     */
    private String note;
    /**
     * A code signifying the alternative currency used for payment in the
     * Invoice.
     */
    private String typePaymentAlternativeCurrencyCode;
    /**
     * A code signifying the currency used for payment in the Invoice.
     */
    private String typePaymentCurrencyCode;
    /**
     * A code signifying the currency used for prices in the Invoice.
     */
    private String typePricingCurrencyCode;
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
    private String typeTaxCurrencyCode;
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
    private List<AllowanceCharge> allowanceCharges = new ArrayList<>();
    private List<BillingReference> billingReferences = new ArrayList<>();
    private CustomerParty accountingCustomerParty;
    private CustomerParty buyerCustomerParty;
    private List<Delivery> deliveries = new ArrayList<>();
    private List<DeliveryTerms> deliveryTerms = new ArrayList<>();
    private DocumentReference statementDocumentReference;
    private DocumentReference receiptDocumentReference;
    private DocumentReference despatchDocumentReference;
    private DocumentReference originatorDocumentReference;
    private DocumentReference contractDocumentReference;
    private DocumentReference additionalDocumentReference;
    private ExchangeRate taxExchangeRate;
    private ExchangeRate pricingExchangeRate;
    private ExchangeRate paymentExchangeRate;
    private ExchangeRate paymentAlternativeExchangeRate;
    private List<InvoiceLine> invoiceLines = new ArrayList<>();
    private MonetaryTotal legalMonetaryTotal;
    private List<OrderReference> orderReferences = new ArrayList<>();
    private Party taxRepresentativeParty;
    private Party payeeParty;
    private Payment prepaidPayment;
    private List<PaymentMeans> paymentMeans = new ArrayList<>();
    private List<PaymentTerms> paymentTerms = new ArrayList<>();
    private Period invoicePeriod;
    private List<ProjectReference> projectReferences = new ArrayList<>();
    private List<Signature> signatures = new ArrayList<>();
    private SupplierParty accountingSupplierParty;
    private SupplierParty sellerSupplierParty;
    private TaxTotal withholdingTaxTotal;
    private List<TaxTotal> taxTotals = new ArrayList<>();

    private UBLExtensions ublExtensions;

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
     * @return the typeDocumentCurrencyCode
     */
    public String getTypeDocumentCurrencyCode() {
        return typeDocumentCurrencyCode;
    }

    /**
     * @param typeDocumentCurrencyCode
     *            the typeDocumentCurrencyCode to set
     */
    public void setTypeDocumentCurrencyCode(String typeDocumentCurrencyCode) {
        this.typeDocumentCurrencyCode = typeDocumentCurrencyCode;
    }

    public UBLExtensions getUblExtensions() {
        return ublExtensions;
    }

    public void setUblExtensions(UBLExtensions ublExtensions) {
        this.ublExtensions = ublExtensions;
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
        return lineCountNumeric;
    }

    /**
     * @param lineCountNumeric
     *            the lineCountNumeric to set
     */
    public void setLineCountNumeric(BigDecimal lineCountNumeric) {
        this.lineCountNumeric = lineCountNumeric;
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
     * @return the typePaymentAlternativeCurrencyCode
     */
    public String getTypePaymentAlternativeCurrencyCode() {
        return typePaymentAlternativeCurrencyCode;
    }

    /**
     * @param typePaymentAlternativeCurrencyCode
     *            the typePaymentAlternativeCurrencyCode to set
     */
    public void setTypePaymentAlternativeCurrencyCode(String typePaymentAlternativeCurrencyCode) {
        this.typePaymentAlternativeCurrencyCode = typePaymentAlternativeCurrencyCode;
    }

    /**
     * @return the typePaymentCurrencyCode
     */
    public String getTypePaymentCurrencyCode() {
        return typePaymentCurrencyCode;
    }

    /**
     * @param typePaymentCurrencyCode
     *            the typePaymentCurrencyCode to set
     */
    public void setTypePaymentCurrencyCode(String typePaymentCurrencyCode) {
        this.typePaymentCurrencyCode = typePaymentCurrencyCode;
    }

    /**
     * @return the typePricingCurrencyCode
     */
    public String getTypePricingCurrencyCode() {
        return typePricingCurrencyCode;
    }

    /**
     * @param typePricingCurrencyCode
     *            the typePricingCurrencyCode to set
     */
    public void setTypePricingCurrencyCode(String typePricingCurrencyCode) {
        this.typePricingCurrencyCode = typePricingCurrencyCode;
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
     * @return the typeTaxCurrencyCode
     */
    public String getTypeTaxCurrencyCode() {
        return typeTaxCurrencyCode;
    }

    /**
     * @param typeTaxCurrencyCode
     *            the typeTaxCurrencyCode to set
     */
    public void setTypeTaxCurrencyCode(String typeTaxCurrencyCode) {
        this.typeTaxCurrencyCode = typeTaxCurrencyCode;
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
     * @return the allowanceCharges
     */
    public List<AllowanceCharge> getAllowanceCharges() {
        return allowanceCharges;
    }

    /**
     * @param allowanceCharges
     *            the allowanceCharges to set
     */
    public void setAllowanceCharges(List<AllowanceCharge> allowanceCharges) {
        this.allowanceCharges = allowanceCharges;
    }

    /**
     * @return the billingReferences
     */
    public List<BillingReference> getBillingReferences() {
        return billingReferences;
    }

    /**
     * @param billingReferences
     *            the billingReferences to set
     */
    public void setBillingReferences(List<BillingReference> billingReferences) {
        this.billingReferences = billingReferences;
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
     * @return the deliveries
     */
    public List<Delivery> getDeliveries() {
        return deliveries;
    }

    /**
     * @param deliveries
     *            the deliveries to set
     */
    public void setDeliveries(List<Delivery> deliveries) {
        this.deliveries = deliveries;
    }

    /**
     * @return the deliveryTerms
     */
    public List<DeliveryTerms> getDeliveryTerms() {
        return deliveryTerms;
    }

    /**
     * @param deliveryTerms
     *            the deliveryTerms to set
     */
    public void setDeliveryTerms(List<DeliveryTerms> deliveryTerms) {
        this.deliveryTerms = deliveryTerms;
    }

    /**
     * @return the statementDocumentReference
     */
    public DocumentReference getStatementDocumentReference() {
        return statementDocumentReference;
    }

    /**
     * @param statementDocumentReference
     *            the statementDocumentReference to set
     */
    public void setStatementDocumentReference(DocumentReference statementDocumentReference) {
        this.statementDocumentReference = statementDocumentReference;
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
     * @return the invoiceLines
     */
    public List<InvoiceLine> getInvoiceLines() {
        return invoiceLines;
    }

    /**
     * @param invoiceLines
     *            the invoiceLines to set
     */
    public void setInvoiceLines(List<InvoiceLine> invoiceLines) {
        this.invoiceLines = invoiceLines;
    }

    /**
     * @return the legalMonetaryTotal
     */
    public MonetaryTotal getLegalMonetaryTotal() {
        return legalMonetaryTotal;
    }

    /**
     * @param legalMonetaryTotal
     *            the legalMonetaryTotal to set
     */
    public void setLegalMonetaryTotal(MonetaryTotal legalMonetaryTotal) {
        this.legalMonetaryTotal = legalMonetaryTotal;
    }

    /**
     * @return the orderReferences
     */
    public List<OrderReference> getOrderReferences() {
        return orderReferences;
    }

    /**
     * @param orderReferences
     *            the orderReferences to set
     */
    public void setOrderReferences(List<OrderReference> orderReferences) {
        this.orderReferences = orderReferences;
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
     * @return the paymentMeans
     */
    public List<PaymentMeans> getPaymentMeans() {
        return paymentMeans;
    }

    /**
     * @param paymentMeans
     *            the paymentMeans to set
     */
    public void setPaymentMeans(List<PaymentMeans> paymentMeans) {
        this.paymentMeans = paymentMeans;
    }

    /**
     * @return the paymentTerms
     */
    public List<PaymentTerms> getPaymentTerms() {
        return paymentTerms;
    }

    /**
     * @param paymentTerms
     *            the paymentTerms to set
     */
    public void setPaymentTerms(List<PaymentTerms> paymentTerms) {
        this.paymentTerms = paymentTerms;
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
     * @return the projectReferences
     */
    public List<ProjectReference> getProjectReferences() {
        return projectReferences;
    }

    /**
     * @param projectReferences
     *            the projectReferences to set
     */
    public void setProjectReferences(List<ProjectReference> projectReferences) {
        this.projectReferences = projectReferences;
    }

    /**
     * @return the signatures
     */
    public List<Signature> getSignatures() {
        return signatures;
    }

    /**
     * @param signatures
     *            the signatures to set
     */
    public void setSignatures(List<Signature> signatures) {
        this.signatures = signatures;
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
     * @return the taxTotals
     */
    public List<TaxTotal> getTaxTotals() {
        return taxTotals;
    }

    /**
     * @param taxTotals
     *            the taxTotals to set
     */
    public void setTaxTotals(List<TaxTotal> taxTotals) {
        this.taxTotals = taxTotals;
    }

}