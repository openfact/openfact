package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A document that specifies details of an actual payment.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:21:17 a. m.
 */
public class RemittanceAdvice {

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
     * An internal reference to the order for payment by the invoicing party.
     * This may have been requested of the payer by the payee to accompany the
     * payer's remittance.
     */
    private String InvoicingPartyReference;
    /**
     * The date, assigned by the sender, on which this document was issued.
     */
    private LocalDate IssueDate;
    /**
     * The time, assigned by the sender, at which this document was issued.
     */
    private LocalTime IssueTime;
    /**
     * The number of Remittance Advice Lines in the document.
     */
    private BigDecimal LineCountNumeric;
    /**
     * Free-form text pertinent to this document, conveying information that is
     * not contained explicitly in other structures.
     */
    private String Note;
    /**
     * An internal reference to the payer's order for payment.
     */
    private String PayerReference;
    /**
     * An internal reference to the order for payment from the payer to the
     * payer's bank.
     */
    private String PaymentOrderReference;
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
     * The totals of all credit amounts for the Remittance Advice.
     */
    private BigDecimal TotalCreditAmount;
    /**
     * The totals of all debit amounts for the Remittance Advice.
     */
    private BigDecimal TotalDebitAmount;
    /**
     * The total payable amount for the Remittance Advice (must be positive).
     */
    private BigDecimal TotalPaymentAmount;
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
    private List<BillingReference> billingReferences = new ArrayList<>();
    private CustomerParty AccountingCustomerParty;
    private DocumentReference AdditionalDocumentReference;
    private Party PayeeParty;
    private List<PaymentMeans> paymentMeans = new ArrayList<>();
    private Period InvoicePeriod;
    private List<RemittanceAdviceLine> remittanceAdviceLines = new ArrayList<>();
    private List<Signature> signatures = new ArrayList<>();
    private SupplierParty AccountingSupplierParty;
    private List<TaxTotal> taxTotals = new ArrayList<>();

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
     * @return the invoicingPartyReference
     */
    public String getInvoicingPartyReference() {
        return InvoicingPartyReference;
    }

    /**
     * @param invoicingPartyReference
     *            the invoicingPartyReference to set
     */
    public void setInvoicingPartyReference(String invoicingPartyReference) {
        InvoicingPartyReference = invoicingPartyReference;
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
     * @return the payerReference
     */
    public String getPayerReference() {
        return PayerReference;
    }

    /**
     * @param payerReference
     *            the payerReference to set
     */
    public void setPayerReference(String payerReference) {
        PayerReference = payerReference;
    }

    /**
     * @return the paymentOrderReference
     */
    public String getPaymentOrderReference() {
        return PaymentOrderReference;
    }

    /**
     * @param paymentOrderReference
     *            the paymentOrderReference to set
     */
    public void setPaymentOrderReference(String paymentOrderReference) {
        PaymentOrderReference = paymentOrderReference;
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
     * @return the totalCreditAmount
     */
    public BigDecimal getTotalCreditAmount() {
        return TotalCreditAmount;
    }

    /**
     * @param totalCreditAmount
     *            the totalCreditAmount to set
     */
    public void setTotalCreditAmount(BigDecimal totalCreditAmount) {
        TotalCreditAmount = totalCreditAmount;
    }

    /**
     * @return the totalDebitAmount
     */
    public BigDecimal getTotalDebitAmount() {
        return TotalDebitAmount;
    }

    /**
     * @param totalDebitAmount
     *            the totalDebitAmount to set
     */
    public void setTotalDebitAmount(BigDecimal totalDebitAmount) {
        TotalDebitAmount = totalDebitAmount;
    }

    /**
     * @return the totalPaymentAmount
     */
    public BigDecimal getTotalPaymentAmount() {
        return TotalPaymentAmount;
    }

    /**
     * @param totalPaymentAmount
     *            the totalPaymentAmount to set
     */
    public void setTotalPaymentAmount(BigDecimal totalPaymentAmount) {
        TotalPaymentAmount = totalPaymentAmount;
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
     * @return the remittanceAdviceLines
     */
    public List<RemittanceAdviceLine> getRemittanceAdviceLines() {
        return remittanceAdviceLines;
    }

    /**
     * @param remittanceAdviceLines
     *            the remittanceAdviceLines to set
     */
    public void setRemittanceAdviceLines(List<RemittanceAdviceLine> remittanceAdviceLines) {
        this.remittanceAdviceLines = remittanceAdviceLines;
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

}// end Remittance Advice