package org.openfact.models.jpa.entities.ubl2;


/**
 * A document used to report the status of orders, billing, and payment. This
 * document is a statement of account, not a summary invoice.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:21:25 a. m.
 */
public class Statement {

	/**
	 * Indicates whether this document is a copy (true) or not (false).
	 */
	private Indicator. Type CopyIndicator;
	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private Identifier. Type CustomizationID;
	/**
	 * The default currency for the Statement.
	 */
	private Currency_ Code. Type DocumentCurrencyCode;
	/**
	 * An identifier for this document, assigned by the sender.
	 */
	private Identifier. Type ID;
	/**
	 * The date, assigned by the sender, on which this document was issued.
	 */
	private Date. Type IssueDate;
	/**
	 * The time, assigned by the sender, at which this document was issued.
	 */
	private Time. Type IssueTime;
	/**
	 * The number of Statement Lines in the Statement.
	 */
	private Numeric. Type LineCountNumeric;
	/**
	 * Free-form text pertinent to this document, conveying information that is not
	 * contained explicitly in other structures.
	 */
	private Text. Type Note;
	/**
	 * Identifies an instance of executing a profile, to associate all transactions in
	 * a collaboration.
	 */
	private Identifier. Type ProfileExecutionID;
	/**
	 * Identifies a user-defined profile of the customization of UBL being used.
	 */
	private Identifier. Type ProfileID;
	/**
	 * A code signifying the type of the Statement.
	 */
	private Code. Type StatementTypeCode;
	/**
	 * The total amount for the Statement.
	 */
	private Amount. Type TotalBalanceAmount;
	/**
	 * The total of all credit amounts for the Statement.
	 */
	private Amount. Type TotalCreditAmount;
	/**
	 * The total of all debit amounts for the Statement.
	 */
	private Amount. Type TotalDebitAmount;
	/**
	 * Identifies the earliest version of the UBL 2 schema for this document type that
	 * defines all of the elements that might be encountered in the current instance.
	 */
	private Identifier. Type UBLVersionID;
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private Identifier. Type UUID;
	private Allowance Charge m_Allowance Charge;
	private Customer Party Accounting Customer Party;
	private Customer Party Originator Customer Party;
	private Customer Party Buyer Customer Party;
	private Document Reference Additional Document Reference;
	private Party Payee Party;
	private Payment Means m_Payment Means;
	private Payment Terms m_Payment Terms;
	private Period Statement Period;
	private Signature m_Signature;
	private Statement Line m_Statement Line;
	private Supplier Party Seller Supplier Party;
	private Supplier Party Accounting Supplier Party;
	private Tax Total m_Tax Total;

	public Statement(){

	}

	public void finalize() throws Throwable {

	}
	public Customer Party getAccounting Customer Party(){
		return Accounting Customer Party;
	}

	public Supplier Party getAccounting Supplier Party(){
		return Accounting Supplier Party;
	}

	public Document Reference getAdditional Document Reference(){
		return Additional Document Reference;
	}

	public Allowance Charge getAllowance Charge(){
		return m_Allowance Charge;
	}

	public Customer Party getBuyer Customer Party(){
		return Buyer Customer Party;
	}

	public Indicator. Type getCopyIndicator(){
		return CopyIndicator;
	}

	public Identifier. Type getCustomizationID(){
		return CustomizationID;
	}

	public Currency_ Code. Type getDocumentCurrencyCode(){
		return DocumentCurrencyCode;
	}

	public Identifier. Type getID(){
		return ID;
	}

	public Date. Type getIssueDate(){
		return IssueDate;
	}

	public Time. Type getIssueTime(){
		return IssueTime;
	}

	public Numeric. Type getLineCountNumeric(){
		return LineCountNumeric;
	}

	public Text. Type getNote(){
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

	public Identifier. Type getProfileExecutionID(){
		return ProfileExecutionID;
	}

	public Identifier. Type getProfileID(){
		return ProfileID;
	}

	public Supplier Party getSeller Supplier Party(){
		return Seller Supplier Party;
	}

	public Signature getSignature(){
		return m_Signature;
	}

	public Statement Line getStatement Line(){
		return m_Statement Line;
	}

	public Period getStatement Period(){
		return Statement Period;
	}

	public Code. Type getStatementTypeCode(){
		return StatementTypeCode;
	}

	public Tax Total getTax Total(){
		return m_Tax Total;
	}

	public Amount. Type getTotalBalanceAmount(){
		return TotalBalanceAmount;
	}

	public Amount. Type getTotalCreditAmount(){
		return TotalCreditAmount;
	}

	public Amount. Type getTotalDebitAmount(){
		return TotalDebitAmount;
	}

	public Identifier. Type getUBLVersionID(){
		return UBLVersionID;
	}

	public Identifier. Type getUUID(){
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
	public void setAdditional Document Reference(Document Reference newVal){
		Additional Document Reference = newVal;
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
	public void setBuyer Customer Party(Customer Party newVal){
		Buyer Customer Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCopyIndicator(Indicator. Type newVal){
		CopyIndicator = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCustomizationID(Identifier. Type newVal){
		CustomizationID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDocumentCurrencyCode(Currency_ Code. Type newVal){
		DocumentCurrencyCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setID(Identifier. Type newVal){
		ID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setIssueDate(Date. Type newVal){
		IssueDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setIssueTime(Time. Type newVal){
		IssueTime = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLineCountNumeric(Numeric. Type newVal){
		LineCountNumeric = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNote(Text. Type newVal){
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
	public void setProfileExecutionID(Identifier. Type newVal){
		ProfileExecutionID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setProfileID(Identifier. Type newVal){
		ProfileID = newVal;
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
	public void setSignature(Signature newVal){
		m_Signature = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setStatement Line(Statement Line newVal){
		m_Statement Line = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setStatement Period(Period newVal){
		Statement Period = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setStatementTypeCode(Code. Type newVal){
		StatementTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTax Total(Tax Total newVal){
		m_Tax Total = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTotalBalanceAmount(Amount. Type newVal){
		TotalBalanceAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTotalCreditAmount(Amount. Type newVal){
		TotalCreditAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTotalDebitAmount(Amount. Type newVal){
		TotalDebitAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setUBLVersionID(Identifier. Type newVal){
		UBLVersionID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setUUID(Identifier. Type newVal){
		UUID = newVal;
	}
}//end Statement