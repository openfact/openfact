package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;

/**
 * A class to define a line in a Statement of account.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:17:49 a. m.
 */
public class StatementLine {

	/**
	 * The balance amount on this statement line.
	 */
	private BigDecimal BalanceAmount;
	/**
	 * An indication that this statement line contains an outstanding balance
	 * from the previous bill(s) (true) or does not (false).
	 */
	private boolean BalanceBroughtForwardIndicator;
	/**
	 * The amount credited on this statement line.
	 */
	private BigDecimal CreditLineAmount;
	/**
	 * The amount debited on this statement line.
	 */
	private BigDecimal DebitLineAmount;
	/**
	 * An identifier for this statement line.
	 */
	private String ID;
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
	 * A universally unique identifier for this statement line.
	 */
	private String UUID;
	private AllowanceCharge m_AllowanceCharge;
	private BillingReference m_BillingReference;
	private CustomerParty BuyerCustomerParty;
	private CustomerParty OriginatorCustomerParty;
	private CustomerParty AccountingCustomerParty;
	private DocumentReference m_DocumentReference;
	private ExchangeRate m_ExchangeRate;
	private Party PayeeParty;
	private Payment CollectedPayment;
	private PaymentMeans m_PaymentMeans;
	private PaymentTerms m_PaymentTerms;
	private Period InvoicePeriod;
	private SupplierParty AccountingSupplierParty;
	private SupplierParty SellerSupplierParty;

	public StatementLine() {

	}

	public void finalize() throws Throwable {

	}

	/**
	 * @return the balanceAmount
	 */
	public BigDecimal getBalanceAmount() {
		return BalanceAmount;
	}

	/**
	 * @param balanceAmount
	 *            the balanceAmount to set
	 */
	public void setBalanceAmount(BigDecimal balanceAmount) {
		BalanceAmount = balanceAmount;
	}

	/**
	 * @return the balanceBroughtForwardIndicator
	 */
	public boolean isBalanceBroughtForwardIndicator() {
		return BalanceBroughtForwardIndicator;
	}

	/**
	 * @param balanceBroughtForwardIndicator
	 *            the balanceBroughtForwardIndicator to set
	 */
	public void setBalanceBroughtForwardIndicator(boolean balanceBroughtForwardIndicator) {
		BalanceBroughtForwardIndicator = balanceBroughtForwardIndicator;
	}

	/**
	 * @return the creditLineAmount
	 */
	public BigDecimal getCreditLineAmount() {
		return CreditLineAmount;
	}

	/**
	 * @param creditLineAmount
	 *            the creditLineAmount to set
	 */
	public void setCreditLineAmount(BigDecimal creditLineAmount) {
		CreditLineAmount = creditLineAmount;
	}

	/**
	 * @return the debitLineAmount
	 */
	public BigDecimal getDebitLineAmount() {
		return DebitLineAmount;
	}

	/**
	 * @param debitLineAmount
	 *            the debitLineAmount to set
	 */
	public void setDebitLineAmount(BigDecimal debitLineAmount) {
		DebitLineAmount = debitLineAmount;
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
	 * @return the paymentPurposeCode
	 */
	public String getPaymentPurposeCode() {
		return PaymentPurposeCode;
	}

	/**
	 * @param paymentPurposeCode
	 *            the paymentPurposeCode to set
	 */
	public void setPaymentPurposeCode(String paymentPurposeCode) {
		PaymentPurposeCode = paymentPurposeCode;
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
	 * @return the m_DocumentReference
	 */
	public DocumentReference getM_DocumentReference() {
		return m_DocumentReference;
	}

	/**
	 * @param m_DocumentReference
	 *            the m_DocumentReference to set
	 */
	public void setM_DocumentReference(DocumentReference m_DocumentReference) {
		this.m_DocumentReference = m_DocumentReference;
	}

	/**
	 * @return the m_ExchangeRate
	 */
	public ExchangeRate getM_ExchangeRate() {
		return m_ExchangeRate;
	}

	/**
	 * @param m_ExchangeRate
	 *            the m_ExchangeRate to set
	 */
	public void setM_ExchangeRate(ExchangeRate m_ExchangeRate) {
		this.m_ExchangeRate = m_ExchangeRate;
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
	 * @return the collectedPayment
	 */
	public Payment getCollectedPayment() {
		return CollectedPayment;
	}

	/**
	 * @param collectedPayment
	 *            the collectedPayment to set
	 */
	public void setCollectedPayment(Payment collectedPayment) {
		CollectedPayment = collectedPayment;
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

}// end Statement Line