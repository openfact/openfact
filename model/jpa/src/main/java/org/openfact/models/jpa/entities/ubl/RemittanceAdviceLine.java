package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;

/**
 * A class to define a line in a Remittance Advice.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:17:25 a. m.
 */
public class RemittanceAdviceLine {

	/**
	 * The monetary balance associated with this remittance advice line.
	 */
	private BigDecimal BalanceAmount;
	/**
	 * The amount credited on this remittance advice line.
	 */
	private BigDecimal CreditLineAmount;
	/**
	 * The amount debited on this remittance advice line.
	 */
	private BigDecimal DebitLineAmount;
	/**
	 * An identifier for this remittance advice line.
	 */
	private String ID;
	/**
	 * A reference to the order for payment used by the invoicing party. This
	 * may have been requested of the payer by the payee to accompany its
	 * remittance.
	 */
	private String InvoicingPartyReference;
	/**
	 * Free-form text conveying information that is not contained explicitly in
	 * other structures.
	 */
	private String Note;
	/**
	 * A code signifying the business purpose for this payment.
	 */
	private String PaymentPurposeCode;
	/**
	 * A universally unique identifier for this remittance advice line.
	 */
	private String UUID;
	private BillingReference m_BillingReference;
	private CustomerParty OriginatorCustomerParty;
	private CustomerParty AccountingCustomerParty;
	private CustomerParty BuyerCustomerParty;
	private DocumentReference m_DocumentReference;
	private ExchangeRate m_ExchangeRate;
	private Party PayeeParty;
	private Period InvoicePeriod;
	private SupplierParty AccountingSupplierParty;
	private SupplierParty SellerSupplierParty;

	public RemittanceAdviceLine() {

	}

	public void finalize() throws Throwable {

	}

	public CustomerParty getAccountingCustomerParty() {
		return AccountingCustomerParty;
	}

	public SupplierParty getAccountingSupplierParty() {
		return AccountingSupplierParty;
	}

	public BigDecimal getBalanceAmount() {
		return BalanceAmount;
	}

	public BillingReference getBillingReference() {
		return m_BillingReference;
	}

	public CustomerParty getBuyerCustomerParty() {
		return BuyerCustomerParty;
	}

	public BigDecimal getCreditLineAmount() {
		return CreditLineAmount;
	}

	public BigDecimal getDebitLineAmount() {
		return DebitLineAmount;
	}

	public DocumentReference getDocumentReference() {
		return m_DocumentReference;
	}

	public ExchangeRate getExchangeRate() {
		return m_ExchangeRate;
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

	public String getNote() {
		return Note;
	}

	public CustomerParty getOriginatorCustomerParty() {
		return OriginatorCustomerParty;
	}

	public Party getPayeeParty() {
		return PayeeParty;
	}

	public String getPaymentPurposeCode() {
		return PaymentPurposeCode;
	}

	public SupplierParty getSellerSupplierParty() {
		return SellerSupplierParty;
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
	public void setBalanceAmount(BigDecimal newVal) {
		BalanceAmount = newVal;
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
	public void setBuyerCustomerParty(CustomerParty newVal) {
		BuyerCustomerParty = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCreditLineAmount(BigDecimal newVal) {
		CreditLineAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDebitLineAmount(BigDecimal newVal) {
		DebitLineAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDocumentReference(DocumentReference newVal) {
		m_DocumentReference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setExchangeRate(ExchangeRate newVal) {
		m_ExchangeRate = newVal;
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
	public void setNote(String newVal) {
		Note = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setOriginatorCustomerParty(CustomerParty newVal) {
		OriginatorCustomerParty = newVal;
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
	public void setPaymentPurposeCode(String newVal) {
		PaymentPurposeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSellerSupplierParty(SupplierParty newVal) {
		SellerSupplierParty = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setUUID(String newVal) {
		UUID = newVal;
	}
}// end Remittance Advice Line