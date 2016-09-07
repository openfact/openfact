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
	private Customer Party Buyer Customer Party;
	private Customer Party Originator Customer Party;
	private Customer Party Accounting Customer Party;
	private DocumentReference m_DocumentReference;
	private Exchange Rate m_Exchange Rate;
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
	public Customer Party getAccounting Customer Party(){
		return Accounting Customer Party;
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

	public Customer Party getBuyer Customer Party(){
		return Buyer Customer Party;
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

	public Exchange Rate getExchange Rate(){
		return m_Exchange Rate;
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

	public Customer Party getOriginator Customer Party(){
		return Originator Customer Party;
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
	public void setAccounting Customer Party(Customer Party newVal){
		Accounting Customer Party = newVal;
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
	public void setBuyer Customer Party(Customer Party newVal){
		Buyer Customer Party = newVal;
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
	public void setExchange Rate(Exchange Rate newVal){
		m_Exchange Rate = newVal;
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
	public void setOriginator Customer Party(Customer Party newVal){
		Originator Customer Party = newVal;
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