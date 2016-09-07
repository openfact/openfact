package org.openfact.models.jpa.entities.ubl;


/**
 * A class to define a line in a Statement of account.
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
	 * An indication that this statement line contains an outstanding balance from the
	 * previous bill(s) (true) or does not (false).
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
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
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
	private Allowance Charge m_Allowance Charge;
	private Billing Reference m_Billing Reference;
	private CustomerParty Buyer CustomerParty;
	private CustomerParty Originator CustomerParty;
	private CustomerParty Accounting CustomerParty;
	private DocumentReference m_DocumentReference;
	private ExchangeRate m_ExchangeRate;
	private Party Payee Party;
	private Payment Collected Payment;
	private Payment Means m_Payment Means;
	private Payment Terms m_Payment Terms;
	private Period Invoice Period;
	private Supplier Party Accounting Supplier Party;
	private Supplier Party Seller Supplier Party;

	public Statement Line(){

	}

	public void finalize() throws Throwable {

	}
	public CustomerParty getAccounting CustomerParty(){
		return Accounting CustomerParty;
	}

	public Supplier Party getAccounting Supplier Party(){
		return Accounting Supplier Party;
	}

	public Allowance Charge getAllowance Charge(){
		return m_Allowance Charge;
	}

	public BigDecimal getBalanceAmount(){
		return BalanceAmount;
	}

	public boolean getBalanceBroughtForwardIndicator(){
		return BalanceBroughtForwardIndicator;
	}

	public Billing Reference getBilling Reference(){
		return m_Billing Reference;
	}

	public CustomerParty getBuyer CustomerParty(){
		return Buyer CustomerParty;
	}

	public Payment getCollected Payment(){
		return Collected Payment;
	}

	public BigDecimal getCreditLineAmount(){
		return CreditLineAmount;
	}

	public BigDecimal getDebitLineAmount(){
		return DebitLineAmount;
	}

	public DocumentReference getDocumentReference(){
		return m_DocumentReference;
	}

	public ExchangeRate getExchangeRate(){
		return m_ExchangeRate;
	}

	public String getID(){
		return ID;
	}

	public Period getInvoice Period(){
		return Invoice Period;
	}

	public String getNote(){
		return Note;
	}

	public CustomerParty getOriginator CustomerParty(){
		return Originator CustomerParty;
	}

	public Party getPayee Party(){
		return Payee Party;
	}

	public Payment Means getPayment Means(){
		return m_Payment Means;
	}

	public Payment Terms getPayment Terms(){
		return m_Payment Terms;
	}

	public String getPaymentPurposeCode(){
		return PaymentPurposeCode;
	}

	public Supplier Party getSeller Supplier Party(){
		return Seller Supplier Party;
	}

	public String getUUID(){
		return UUID;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAccounting CustomerParty(CustomerParty newVal){
		Accounting CustomerParty = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAccounting Supplier Party(Supplier Party newVal){
		Accounting Supplier Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAllowance Charge(Allowance Charge newVal){
		m_Allowance Charge = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setBalanceAmount(BigDecimal newVal){
		BalanceAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setBalanceBroughtForwardIndicator(boolean newVal){
		BalanceBroughtForwardIndicator = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setBilling Reference(Billing Reference newVal){
		m_Billing Reference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setBuyer CustomerParty(CustomerParty newVal){
		Buyer CustomerParty = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCollected Payment(Payment newVal){
		Collected Payment = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCreditLineAmount(BigDecimal newVal){
		CreditLineAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDebitLineAmount(BigDecimal newVal){
		DebitLineAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDocumentReference(DocumentReference newVal){
		m_DocumentReference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setExchangeRate(ExchangeRate newVal){
		m_ExchangeRate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setID(String newVal){
		ID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setInvoice Period(Period newVal){
		Invoice Period = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNote(String newVal){
		Note = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setOriginator CustomerParty(CustomerParty newVal){
		Originator CustomerParty = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPayee Party(Party newVal){
		Payee Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPayment Means(Payment Means newVal){
		m_Payment Means = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPayment Terms(Payment Terms newVal){
		m_Payment Terms = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPaymentPurposeCode(String newVal){
		PaymentPurposeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSeller Supplier Party(Supplier Party newVal){
		Seller Supplier Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setUUID(String newVal){
		UUID = newVal;
	}
}//end Statement Line