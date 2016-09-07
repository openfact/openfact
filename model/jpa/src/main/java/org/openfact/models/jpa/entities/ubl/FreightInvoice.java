package org.openfact.models.jpa.entities.ubl;


/**
 * A document stating the charges incurred for a logistics service.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:20:40 a. m.
 */
public class FreightInvoice {

	/**
	 * The buyer's accounting cost centre, applied to the Freight Invoice as a whole,
	 * expressed as text.
	 */
	private String AccountingCost;
	/**
	 * The buyer's accounting code, applied to the Freight Invoice as a whole.
	 */
	private String AccountingCostCode;
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
	private Currency_ String DocumentCurrencyCode;
	/**
	 * An identifier for this document, assigned by the sender.
	 */
	private String ID;
	/**
	 * A code signifying the type of the Freight Invoice.
	 */
	private String InvoiceTypeCode;
	/**
	 * The date, assigned by the sender, on which this document was issued.
	 */
	private LocalDate IssueDate;
	/**
	 * The time, assigned by the sender, at which this document was issued.
	 */
	private LocalTime IssueTime;
	/**
	 * The number of Invoice Lines in the document.
	 */
	private BigDecimal LineCountNumeric;
	/**
	 * Free-form text pertinent to this document, conveying information that is not
	 * contained explicitly in other structures.
	 */
	private String Note;
	/**
	 * A code signifying the alternative currency used for payment in the Freight
	 * Invoice.
	 */
	private Currency_ String PaymentAlternativeCurrencyCode;
	/**
	 * A code signifying the currency used for payment in the Freight Invoice.
	 */
	private Currency_ String PaymentCurrencyCode;
	/**
	 * A code signifying the currency used for prices in the Freight Invoice.
	 */
	private Currency_ String PricingCurrencyCode;
	/**
	 * Identifies an instance of executing a profile, to associate all transactions in
	 * a collaboration.
	 */
	private String ProfileExecutionID;
	/**
	 * Identifies a user-defined profile of the customization of UBL being used.
	 */
	private String ProfileID;
	/**
	 * A code signifying the currency used for tax amounts in the Freight Invoice.
	 */
	private Currency_ String TaxCurrencyCode;
	/**
	 * The date of the Freight Invoice, used to indicate the point at which tax
	 * becomes applicable.
	 */
	private LocalDate TaxPointDate;
	/**
	 * Identifies the earliest version of the UBL 2 schema for this document type that
	 * defines all of the elements that might be encountered in the current instance.
	 */
	private String UBLVersionID;
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private String UUID;
	private Allowance Charge m_Allowance Charge;
	private Billing Reference m_Billing Reference;
	private Customer Party Accounting Customer Party;
	private Document Reference Despatch Document Reference;
	private Document Reference Receipt Document Reference;
	private Document Reference Originator Document Reference;
	private Document Reference Contract Document Reference;
	private Document Reference Additional Document Reference;
	private Exchange Rate Payment Alternative Exchange Rate;
	private Exchange Rate Payment Exchange Rate;
	private Exchange Rate Tax Exchange Rate;
	private Exchange Rate Pricing Exchange Rate;
	private Invoice Line m_Invoice Line;
	private Monetary Total Legal Monetary Total;
	private Order Reference m_Order Reference;
	private Party Tax Representative Party;
	private Party Payee Party;
	private Payment Prepaid Payment;
	private Payment Means m_Payment Means;
	private Payment Terms m_Payment Terms;
	private Period Invoice Period;
	private Shipment m_Shipment;
	private Signature m_Signature;
	private Supplier Party Accounting Supplier Party;
	private Tax Total m_Tax Total;

	public Freight Invoice(){

	}

	public void finalize() throws Throwable {

	}
	public Customer Party getAccounting Customer Party(){
		return Accounting Customer Party;
	}

	public Supplier Party getAccounting Supplier Party(){
		return Accounting Supplier Party;
	}

	public String getAccountingCost(){
		return AccountingCost;
	}

	public String getAccountingCostCode(){
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

	public Document Reference getContract Document Reference(){
		return Contract Document Reference;
	}

	public boolean getCopyIndicator(){
		return CopyIndicator;
	}

	public String getCustomizationID(){
		return CustomizationID;
	}

	public Document Reference getDespatch Document Reference(){
		return Despatch Document Reference;
	}

	public Currency_ String getDocumentCurrencyCode(){
		return DocumentCurrencyCode;
	}

	public String getID(){
		return ID;
	}

	public Invoice Line getInvoice Line(){
		return m_Invoice Line;
	}

	public Period getInvoice Period(){
		return Invoice Period;
	}

	public String getInvoiceTypeCode(){
		return InvoiceTypeCode;
	}

	public LocalDate getIssueDate(){
		return IssueDate;
	}

	public LocalTime getIssueTime(){
		return IssueTime;
	}

	public Monetary Total getLegal Monetary Total(){
		return Legal Monetary Total;
	}

	public BigDecimal getLineCountNumeric(){
		return LineCountNumeric;
	}

	public String getNote(){
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

	public Currency_ String getPaymentAlternativeCurrencyCode(){
		return PaymentAlternativeCurrencyCode;
	}

	public Currency_ String getPaymentCurrencyCode(){
		return PaymentCurrencyCode;
	}

	public Payment getPrepaid Payment(){
		return Prepaid Payment;
	}

	public Exchange Rate getPricing Exchange Rate(){
		return Pricing Exchange Rate;
	}

	public Currency_ String getPricingCurrencyCode(){
		return PricingCurrencyCode;
	}

	public String getProfileExecutionID(){
		return ProfileExecutionID;
	}

	public String getProfileID(){
		return ProfileID;
	}

	public Document Reference getReceipt Document Reference(){
		return Receipt Document Reference;
	}

	public Shipment getShipment(){
		return m_Shipment;
	}

	public Signature getSignature(){
		return m_Signature;
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

	public Currency_ String getTaxCurrencyCode(){
		return TaxCurrencyCode;
	}

	public LocalDate getTaxPointDate(){
		return TaxPointDate;
	}

	public String getUBLVersionID(){
		return UBLVersionID;
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
	public void setAccountingCost(String newVal){
		AccountingCost = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAccountingCostCode(String newVal){
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
	public void setContract Document Reference(Document Reference newVal){
		Contract Document Reference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCopyIndicator(boolean newVal){
		CopyIndicator = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCustomizationID(String newVal){
		CustomizationID = newVal;
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
	public void setDocumentCurrencyCode(Currency_ String newVal){
		DocumentCurrencyCode = newVal;
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
	public void setInvoice Line(Invoice Line newVal){
		m_Invoice Line = newVal;
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
	public void setInvoiceTypeCode(String newVal){
		InvoiceTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setIssueDate(LocalDate newVal){
		IssueDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setIssueTime(LocalTime newVal){
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
	public void setLineCountNumeric(BigDecimal newVal){
		LineCountNumeric = newVal;
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
	public void setPaymentAlternativeCurrencyCode(Currency_ String newVal){
		PaymentAlternativeCurrencyCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPaymentCurrencyCode(Currency_ String newVal){
		PaymentCurrencyCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPrepaid Payment(Payment newVal){
		Prepaid Payment = newVal;
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
	public void setPricingCurrencyCode(Currency_ String newVal){
		PricingCurrencyCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setProfileExecutionID(String newVal){
		ProfileExecutionID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setProfileID(String newVal){
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
	public void setShipment(Shipment newVal){
		m_Shipment = newVal;
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
	public void setTaxCurrencyCode(Currency_ String newVal){
		TaxCurrencyCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTaxPointDate(LocalDate newVal){
		TaxPointDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setUBLVersionID(String newVal){
		UBLVersionID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setUUID(String newVal){
		UUID = newVal;
	}
}//end Freight Invoice