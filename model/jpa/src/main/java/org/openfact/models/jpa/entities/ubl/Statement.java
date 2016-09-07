package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A document used to report the status of orders, billing, and payment. This
 * document is a statement of account, not a summary invoice.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:21:25 a. m.
 */
public class Statement {

    /**
     * Indicates whether this document is a copy (true) or not (false).
     */
    private boolean CopyIndicator;
    /**
     * Identifies a user-defined customization of UBL for a specific use.
     */
    private String CustomizationID;
    /**
     * The default currency for the Statement.
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
     * The number of Statement Lines in the Statement.
     */
    private BigDecimal LineCountNumeric;
    /**
     * Free-form text pertinent to this document, conveying information that is
     * not contained explicitly in other structures.
     */
    private String Note;
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
     * A code signifying the type of the Statement.
     */
    private String StatementTypeCode;
    /**
     * The total amount for the Statement.
     */
    private BigDecimal TotalBalanceAmount;
    /**
     * The total of all credit amounts for the Statement.
     */
    private BigDecimal TotalCreditAmount;
    /**
     * The total of all debit amounts for the Statement.
     */
    private BigDecimal TotalDebitAmount;
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
    private CustomerParty AccountingCustomerParty;
    private CustomerParty OriginatorCustomerParty;
    private CustomerParty BuyerCustomerParty;
    private DocumentReference AdditionalDocumentReference;
    private Party PayeeParty;
    private List<PaymentMeans> paymentMeans = new ArrayList<>();
    private List<PaymentTerms> paymentTerms = new ArrayList<>();
    private Period StatementPeriod;
    private List<Signature> signatures = new ArrayList<>();
    private List<StatementLine> statementLines = new ArrayList<>();
    private SupplierParty SellerSupplierParty;
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
     * @return the statementTypeCode
     */
    public String getStatementTypeCode() {
        return StatementTypeCode;
    }

    /**
     * @param statementTypeCode
     *            the statementTypeCode to set
     */
    public void setStatementTypeCode(String statementTypeCode) {
        StatementTypeCode = statementTypeCode;
    }

    /**
     * @return the totalBalanceAmount
     */
    public BigDecimal getTotalBalanceAmount() {
        return TotalBalanceAmount;
    }

    /**
     * @param totalBalanceAmount
     *            the totalBalanceAmount to set
     */
    public void setTotalBalanceAmount(BigDecimal totalBalanceAmount) {
        TotalBalanceAmount = totalBalanceAmount;
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
     * @return the originatorCustomerParty
     */
    public CustomerParty getOriginatorCustomerParty() {
        return OriginatorCustomerParty;
    }

    /**
     * @param originatorCustomerParty
     *            the originatorCustomerParty to set
     */
    public void setOriginatorCustomerParty(CustomerParty originatorCustomerParty) {
        OriginatorCustomerParty = originatorCustomerParty;
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
     * @return the statementPeriod
     */
    public Period getStatementPeriod() {
        return StatementPeriod;
    }

    /**
     * @param statementPeriod
     *            the statementPeriod to set
     */
    public void setStatementPeriod(Period statementPeriod) {
        StatementPeriod = statementPeriod;
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
     * @return the statementLines
     */
    public List<StatementLine> getStatementLines() {
        return statementLines;
    }

    /**
     * @param statementLines
     *            the statementLines to set
     */
    public void setStatementLines(List<StatementLine> statementLines) {
        this.statementLines = statementLines;
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

}// end Statement