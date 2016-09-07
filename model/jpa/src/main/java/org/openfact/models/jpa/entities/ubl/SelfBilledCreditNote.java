package org.openfact.models.jpa.entities.ubl;


/**
 * A credit note created by the debtor in a self billing arrangement with a
 * creditor; Self Billed Credit Note replaces Debit Note in such arrangements.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:21:22 a. m.
 */
public class SelfBilledCreditNote {

	/**
	 * The buyer's accounting code, applied to the Self Billed Credit Note as a whole,
	 * expressed as text.
	 */
	private Text. Type AccountingCost;
	/**
	 * The buyer's accounting code, applied to the Self Billed Credit Note as a whole.
	 */
	private Code. Type AccountingCostCode;
	/**
	 * Indicates whether this document is a copy (true) or not (false).
	 */
	private Indicator. Type CopyIndicator;
	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private Identifier. Type CustomizationID;
	/**
	 * A code signifying the default currency for this document.
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
	 * The number of Self Billed Credit Note Lines in this document.
	 */
	private Numeric. Type LineCountNumeric;
	/**
	 * Free-form text pertinent to this document, conveying information that is not
	 * contained explicitly in other structures.
	 */
	private Text. Type Note;
	/**
	 * A code signifying the alternative currency used for payment in the Self Billed
	 * Credit Note.
	 */
	private Currency_ Code. Type PaymentAlternativeCurrencyCode;
	/**
	 * A code signifying the currency used for payment in the Self Billed Credit Note.
	 */
	private Currency_ Code. Type PaymentCurrencyCode;
	/**
	 * A code signifying the currency used for prices in the Self Billed Credit Note.
	 */
	private Currency_ Code. Type PricingCurrencyCode;
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
	 * A code signifying the currency used for tax amounts in the Self Billed Credit
	 * Note.
	 */
	private Currency_ Code. Type TaxCurrencyCode;
	/**
	 * The date of the Self Billed Credit Note, used to indicate the point at which
	 * tax becomes applicable.
	 */
	private Date. Type TaxPointDate;
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
	private Billing Reference m_Billing Reference;
	private Credit Note Line m_Credit Note Line;
	private Customer Party Accounting Customer Party;
	private Customer Party Buyer Customer Party;
	private Delivery m_Delivery;
	private Delivery Terms m_Delivery Terms;
	private Document Reference Contract Document Reference;
	private Document Reference Originator Document Reference;
	private Document Reference Statement Document Reference;
	private Document Reference Despatch Document Reference;
	private Document Reference Receipt Document Reference;
	private Document Reference Additional Document Reference;
	private Exchange Rate Pricing Exchange Rate;
	private Exchange Rate Payment Alternative Exchange Rate;
	private Exchange Rate Payment Exchange Rate;
	private Exchange Rate Tax Exchange Rate;
	private Monetary Total Legal Monetary Total;
	private Order Reference m_Order Reference;
	private Party Tax Representative Party;
	private Party Payee Party;
	private Payment Means m_Payment Means;
	private Payment Terms m_Payment Terms;
	private Period Invoice Period;
	private Response Discrepancy Response;
	private Signature m_Signature;
	private Supplier Party Seller Supplier Party;
	private Supplier Party Accounting Supplier Party;
	private Tax Total m_Tax Total;

	public Self Billed Credit Note(){

	}

	public void finalize() throws Throwable {

	}
	public Customer Party getAccounting Customer Party(){
		return Accounting Customer Party;
	}

	public Supplier Party getAccounting Supplier Party(){
		return Accounting Supplier Party;
	}

	public Text. Type getAccountingCost(){
		return AccountingCost;
	}

	public Code. Type getAccountingCostCode(){
		return AccountingCostCode;
	}

	public Document Reference getAdditional Document Reference(){
		return Additional Document Reference;
	}

	public Allowance Charge getAllowance Charge(){
		return m_Allowance Charge;
	}

	public Billing Reference getBilling Reference(){
		return m_Billing Reference;
	}

	public Customer Party getBuyer Customer Party(){
		return Buyer Customer Party;
	}

	public Document Reference getContract Document Reference(){
		return Contract Document Reference;
	}

	public Indicator. Type getCopyIndicator(){
		return CopyIndicator;
	}

	public Credit Note Line getCredit Note Line(){
		return m_Credit Note Line;
	}

	public Identifier. Type getCustomizationID(){
		return CustomizationID;
	}

	public Delivery getDelivery(){
		return m_Delivery;
	}

	public Delivery Terms getDelivery Terms(){
		return m_Delivery Terms;
	}

	public Document Reference getDespatch Document Reference(){
		return Despatch Document Reference;
	}

	public Response getDiscrepancy Response(){
		return Discrepancy Response;
	}

	public Currency_ Code. Type getDocumentCurrencyCode(){
		return DocumentCurrencyCode;
	}

	public Identifier. Type getID(){
		return ID;
	}

	public Period getInvoice Period(){
		return Invoice Period;
	}

	public Date. Type getIssueDate(){
		return IssueDate;
	}

	public Time. Type getIssueTime(){
		return IssueTime;
	}

	public Monetary Total getLegal Monetary Total(){
		return Legal Monetary Total;
	}

	public Numeric. Type getLineCountNumeric(){
		return LineCountNumeric;
	}

	public Text. Type getNote(){
		return Note;
	}

	public Order Reference getOrder Reference(){
		return m_Order Reference;
	}

	public Document Reference getOriginator Document Reference(){
		return Originator Document Reference;
	}

	public Party getPayee Party(){
		return Payee Party;
	}

	public Exchange Rate getPayment Alternative Exchange Rate(){
		return Payment Alternative Exchange Rate;
	}

	public Exchange Rate getPayment Exchange Rate(){
		return Payment Exchange Rate;
	}

	public Payment Means getPayment Means(){
		return m_Payment Means;
	}

	public Payment Terms getPayment Terms(){
		return m_Payment Terms;
	}

	public Currency_ Code. Type getPaymentAlternativeCurrencyCode(){
		return PaymentAlternativeCurrencyCode;
	}

	public Currency_ Code. Type getPaymentCurrencyCode(){
		return PaymentCurrencyCode;
	}

	public Exchange Rate getPricing Exchange Rate(){
		return Pricing Exchange Rate;
	}

	public Currency_ Code. Type getPricingCurrencyCode(){
		return PricingCurrencyCode;
	}

	public Identifier. Type getProfileExecutionID(){
		return ProfileExecutionID;
	}

	public Identifier. Type getProfileID(){
		return ProfileID;
	}

	public Document Reference getReceipt Document Reference(){
		return Receipt Document Reference;
	}

	public Supplier Party getSeller Supplier Party(){
		return Seller Supplier Party;
	}

	public Signature getSignature(){
		return m_Signature;
	}

	public Document Reference getStatement Document Reference(){
		return Statement Document Reference;
	}

	public Exchange Rate getTax Exchange Rate(){
		return Tax Exchange Rate;
	}

	public Party getTax Representative Party(){
		return Tax Representative Party;
	}

	public Tax Total getTax Total(){
		return m_Tax Total;
	}

	public Currency_ Code. Type getTaxCurrencyCode(){
		return TaxCurrencyCode;
	}

	public Date. Type getTaxPointDate(){
		return TaxPointDate;
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
	public void setAccountingCost(Text. Type newVal){
		AccountingCost = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAccountingCostCode(Code. Type newVal){
		AccountingCostCode = newVal;
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
	public void setContract Document Reference(Document Reference newVal){
		Contract Document Reference = newVal;
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
	public void setCredit Note Line(Credit Note Line newVal){
		m_Credit Note Line = newVal;
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
	public void setDelivery(Delivery newVal){
		m_Delivery = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDelivery Terms(Delivery Terms newVal){
		m_Delivery Terms = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDespatch Document Reference(Document Reference newVal){
		Despatch Document Reference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDiscrepancy Response(Response newVal){
		Discrepancy Response = newVal;
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
	public void setInvoice Period(Period newVal){
		Invoice Period = newVal;
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
	public void setLegal Monetary Total(Monetary Total newVal){
		Legal Monetary Total = newVal;
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
	public void setOrder Reference(Order Reference newVal){
		m_Order Reference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setOriginator Document Reference(Document Reference newVal){
		Originator Document Reference = newVal;
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
	public void setPayment Alternative Exchange Rate(Exchange Rate newVal){
		Payment Alternative Exchange Rate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPayment Exchange Rate(Exchange Rate newVal){
		Payment Exchange Rate = newVal;
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
	public void setPaymentAlternativeCurrencyCode(Currency_ Code. Type newVal){
		PaymentAlternativeCurrencyCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPaymentCurrencyCode(Currency_ Code. Type newVal){
		PaymentCurrencyCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPricing Exchange Rate(Exchange Rate newVal){
		Pricing Exchange Rate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPricingCurrencyCode(Currency_ Code. Type newVal){
		PricingCurrencyCode = newVal;
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
	public void setReceipt Document Reference(Document Reference newVal){
		Receipt Document Reference = newVal;
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
	public void setStatement Document Reference(Document Reference newVal){
		Statement Document Reference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTax Exchange Rate(Exchange Rate newVal){
		Tax Exchange Rate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTax Representative Party(Party newVal){
		Tax Representative Party = newVal;
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
	public void setTaxCurrencyCode(Currency_ Code. Type newVal){
		TaxCurrencyCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTaxPointDate(Date. Type newVal){
		TaxPointDate = newVal;
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
}//end Self Billed Credit Note