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
	private BillingReference m_BillingReference;
	private CustomerParty AccountingCustomerParty;
	private DocumentReference AdditionalDocumentReference;
	private Party PayeeParty;
	private PaymentMeans m_PaymentMeans;
	private Period InvoicePeriod;
	private RemittanceAdviceLine m_RemittanceAdviceLine;
	private Signature m_Signature;
	private SupplierParty AccountingSupplierParty;
	private TaxTotal m_TaxTotal;

	public RemittanceAdvice() {

	}

	public void finalize() throws Throwable {

	}

	public CustomerParty getAccountingCustomerParty() {
		return AccountingCustomerParty;
	}

	public SupplierParty getAccountingSupplierParty() {
		return AccountingSupplierParty;
	}

	public DocumentReference getAdditionalDocumentReference() {
		return AdditionalDocumentReference;
	}

	public BillingReference getBillingReference() {
		return m_BillingReference;
	}

	public boolean getCopyIndicator() {
		return CopyIndicator;
	}

	public String getCustomizationID() {
		return CustomizationID;
	}

	public String getDocumentCurrencyCode() {
		return DocumentCurrencyCode;
	}

	public String getID() {
		return ID;
	}

	public Period getInvoicePeriod() {
		return InvoicePeriod;
	}

	public String getInvoicingPartyReference() {
		return InvoicingPartyReference;
	}

	public LocalDate getIssueDate() {
		return IssueDate;
	}

	public LocalTime getIssueTime() {
		return IssueTime;
	}

	public BigDecimal getLineCountNumeric() {
		return LineCountNumeric;
	}

	public String getNote() {
		return Note;
	}

	public Party getPayeeParty() {
		return PayeeParty;
	}

	public String getPayerReference() {
		return PayerReference;
	}

	public PaymentMeans getPaymentMeans() {
		return m_PaymentMeans;
	}

	public String getPaymentOrderReference() {
		return PaymentOrderReference;
	}

	public String getProfileExecutionID() {
		return ProfileExecutionID;
	}

	public String getProfileID() {
		return ProfileID;
	}

	public RemittanceAdviceLine getRemittanceAdviceLine() {
		return m_RemittanceAdviceLine;
	}

	public Signature getSignature() {
		return m_Signature;
	}

	public TaxTotal getTaxTotal() {
		return m_TaxTotal;
	}

	public BigDecimal getTotalCreditAmount() {
		return TotalCreditAmount;
	}

	public BigDecimal getTotalDebitAmount() {
		return TotalDebitAmount;
	}

	public BigDecimal getTotalPaymentAmount() {
		return TotalPaymentAmount;
	}

	public String getUBLVersionID() {
		return UBLVersionID;
	}

	public String getUUID() {
		return UUID;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAccountingCustomerParty(CustomerParty newVal) {
		AccountingCustomerParty = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAccountingSupplierParty(SupplierParty newVal) {
		AccountingSupplierParty = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAdditionalDocumentReference(DocumentReference newVal) {
		AdditionalDocumentReference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setBillingReference(BillingReference newVal) {
		m_BillingReference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCopyIndicator(boolean newVal) {
		CopyIndicator = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCustomizationID(String newVal) {
		CustomizationID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDocumentCurrencyCode(String newVal) {
		DocumentCurrencyCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setID(String newVal) {
		ID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setInvoicePeriod(Period newVal) {
		InvoicePeriod = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setInvoicingPartyReference(String newVal) {
		InvoicingPartyReference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setIssueDate(LocalDate newVal) {
		IssueDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setIssueTime(LocalTime newVal) {
		IssueTime = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLineCountNumeric(BigDecimal newVal) {
		LineCountNumeric = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNote(String newVal) {
		Note = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPayeeParty(Party newVal) {
		PayeeParty = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPayerReference(String newVal) {
		PayerReference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPaymentMeans(PaymentMeans newVal) {
		m_PaymentMeans = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPaymentOrderReference(String newVal) {
		PaymentOrderReference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setProfileExecutionID(String newVal) {
		ProfileExecutionID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setProfileID(String newVal) {
		ProfileID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRemittanceAdviceLine(RemittanceAdviceLine newVal) {
		m_RemittanceAdviceLine = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSignature(Signature newVal) {
		m_Signature = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTaxTotal(TaxTotal newVal) {
		m_TaxTotal = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTotalCreditAmount(BigDecimal newVal) {
		TotalCreditAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTotalDebitAmount(BigDecimal newVal) {
		TotalDebitAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTotalPaymentAmount(BigDecimal newVal) {
		TotalPaymentAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setUBLVersionID(String newVal) {
		UBLVersionID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setUUID(String newVal) {
		UUID = newVal;
	}
}// end Remittance Advice