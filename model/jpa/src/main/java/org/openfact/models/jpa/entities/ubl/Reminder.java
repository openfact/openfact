package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A document used to remind a customer of payments past due.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:21:15 a. m.
 */
public class Reminder {

    /**
     * The buyer's accounting code, applied to the Reminder as a whole,
     * expressed as text.
     */
    private String accountingCost;
    /**
     * The buyer's accounting code, applied to the Reminder as a whole.
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
     * The number of ReminderLines in this document.
     */
    private BigDecimal lineCountNumeric;
    /**
     * Free-form text pertinent to this document, conveying information that is
     * not contained explicitly in other structures.
     */
    private String note;
    /**
     * A code signifying the alternative currency used for payment in the
     * Reminder.
     */
    private String paymentAlternativeCurrencyCode;
    /**
     * A code signifying the currency used for payment in the Reminder.
     */
    private String paymentCurrencyCode;
    /**
     * A code signifying the currency used for prices in the Reminder.
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
     * The number of the current Reminder in the sequence of reminders relating
     * to the specified payments; the number of reminders previously sent plus
     * one.
     */
    private BigDecimal reminderSequenceNumeric;
    /**
     * A code signifying the type of the Reminder.
     */
    private String reminderTypeCode;
    /**
     * A code signifying the currency used for tax amounts in the Reminder.
     */
    private String taxCurrencyCode;
    /**
     * The date of the Reminder, used to indicate the point at which tax becomes
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
    private CustomerParty accountingCustomerParty;
    private DocumentReference additionalDocumentReference;
    private ExchangeRate paymentAlternativeExchangeRate;
    private ExchangeRate pricingExchangeRate;
    private ExchangeRate taxExchangeRate;
    private ExchangeRate paymentExchangeRate;
    private MonetaryTotal legalMonetaryTotal;
    private Party taxRepresentativeParty;
    private Party payeeParty;
    private Payment prepaidPayment;
    private PaymentMeans m_PaymentMeans;
    private PaymentTerms m_PaymentTerms;
    private Period reminderPeriod;
    private ReminderLine m_ReminderLine;
    private Signature m_Signature;
    private SupplierParty accountingSupplierParty;
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
     * @return the reminderSequenceNumeric
     */
    public BigDecimal getReminderSequenceNumeric() {
        return reminderSequenceNumeric;
    }

    /**
     * @param reminderSequenceNumeric
     *            the reminderSequenceNumeric to set
     */
    public void setReminderSequenceNumeric(BigDecimal reminderSequenceNumeric) {
        this.reminderSequenceNumeric = reminderSequenceNumeric;
    }

    /**
     * @return the reminderTypeCode
     */
    public String getReminderTypeCode() {
        return reminderTypeCode;
    }

    /**
     * @param reminderTypeCode
     *            the reminderTypeCode to set
     */
    public void setReminderTypeCode(String reminderTypeCode) {
        this.reminderTypeCode = reminderTypeCode;
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
     * @return the reminderPeriod
     */
    public Period getReminderPeriod() {
        return reminderPeriod;
    }

    /**
     * @param reminderPeriod
     *            the reminderPeriod to set
     */
    public void setReminderPeriod(Period reminderPeriod) {
        this.reminderPeriod = reminderPeriod;
    }

    /**
     * @return the m_ReminderLine
     */
    public ReminderLine getM_ReminderLine() {
        return m_ReminderLine;
    }

    /**
     * @param m_ReminderLine
     *            the m_ReminderLine to set
     */
    public void setM_ReminderLine(ReminderLine m_ReminderLine) {
        this.m_ReminderLine = m_ReminderLine;
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