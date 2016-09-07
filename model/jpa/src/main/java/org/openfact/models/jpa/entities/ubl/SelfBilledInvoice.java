package org.openfact.models.jpa.entities.ubl;


/**
 * An Invoice document created by the Customer (rather than the Supplier) in a
 * Self Billing relationship.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:21:24 a. m.
 */
public class SelfBilledInvoice {

	/**
	 * An accounting cost code, applied to the Invoice as a whole, expressed as text.
	 */
	private String AccountingCost;
	/**
	 * An accounting cost code, applied to the Invoice as a whole.
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
	 * A code signifying the type of invoice.
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
	 * The number of InvoiceLines in this document.
	 */
	private BigDecimal LineCountNumeric;
	/**
	 * Free-form text pertinent to this document, conveying information that is not
	 * contained explicitly in other structures.
	 */
	private String Note;
	/**
	 * A code signifying the alternative currency used for payment in the Invoice.
	 */
	private Currency_ String PaymentAlternativeCurrencyCode;
	/**
	 * A code signifying the currency used for payment in the Invoice.
	 */
	private Currency_ String PaymentCurrencyCode;
	/**
	 * A code signifying the currency used for prices in the Invoice.
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
	 * A code signifying the currency used for tax amounts in the Invoice.
	 */
	private Currency_ String TaxCurrencyCode;
	/**
	 * The date of the invoice for tax purposes, in accordance with the applicable tax
	 * regulation.
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
	private AllowanceCharge m_AllowanceCharge;
	private BillingReference m_BillingReference;
	private CustomerParty Accounting CustomerParty;
	private CustomerParty Buyer CustomerParty;
	private Delivery m_Delivery;
	private DeliveryTerms m_DeliveryTerms;
	private DocumentReference Statement DocumentReference;
	private DocumentReference Receipt DocumentReference;
	private DocumentReference Despatch DocumentReference;
	private DocumentReference Additional DocumentReference;
	private DocumentReference Contract DocumentReference;
	private DocumentReference Originator DocumentReference;
	private ExchangeRate Tax ExchangeRate;
	private ExchangeRate Pricing ExchangeRate;
	private ExchangeRate Payment ExchangeRate;
	private ExchangeRate Payment Alternative ExchangeRate;
	private InvoiceLine m_InvoiceLine;
	private MonetaryTotal Legal MonetaryTotal;
	private Order Reference m_Order Reference;
	private Party Payee Party;
	private Party Tax Representative Party;
	private Payment Prepaid Payment;
	private PaymentMeans m_PaymentMeans;
	private PaymentTerms m_PaymentTerms;
	private Period Invoice Period;
	private Signature m_Signature;
	private SupplierParty Seller SupplierParty;
	private SupplierParty Accounting SupplierParty;
	private TaxTotal m_TaxTotal;

	public Self Billed Invoice(){

	}

	public void finalize() throws Throwable {

	}
	public CustomerParty getAccounting CustomerParty(){
		return Accounting CustomerParty;
	}

	public SupplierParty getAccounting SupplierParty(){
		return Accounting SupplierParty;
	}

	public String getAccountingCost(){
		return AccountingCost;
	}

	public String getAccountingCostCode(){
		return AccountingCostCode;
	}

	public DocumentReference getAdditional DocumentReference(){
		return Additional DocumentReference;
	}

	public AllowanceCharge getAllowanceCharge(){
		return m_AllowanceCharge;
	}

	public BillingReference getBillingReference(){
		return m_BillingReference;
	}

	public CustomerParty getBuyer CustomerParty(){
		return Buyer CustomerParty;
	}

	public DocumentReference getContract DocumentReference(){
		return Contract DocumentReference;
	}

	public boolean getCopyIndicator(){
		return CopyIndicator;
	}

	public String getCustomizationID(){
		return CustomizationID;
	}

	public Delivery getDelivery(){
		return m_Delivery;
	}

	public DeliveryTerms getDeliveryTerms(){
		return m_DeliveryTerms;
	}

	public DocumentReference getDespatch DocumentReference(){
		return Despatch DocumentReference;
	}

	public Currency_ String getDocumentCurrencyCode(){
		return DocumentCurrencyCode;
	}

	public String getID(){
		return ID;
	}

	public InvoiceLine getInvoiceLine(){
		return m_InvoiceLine;
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

	public MonetaryTotal getLegal MonetaryTotal(){
		return Legal MonetaryTotal;
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

	public DocumentReference getOriginator DocumentReference(){
		return Originator DocumentReference;
	}

	public Party getPayee Party(){
		return Payee Party;
	}

	public ExchangeRate getPayment Alternative ExchangeRate(){
		return Payment Alternative ExchangeRate;
	}

	public ExchangeRate getPayment ExchangeRate(){
		return Payment ExchangeRate;
	}

	public PaymentMeans getPaymentMeans(){
		return m_PaymentMeans;
	}

	public PaymentTerms getPaymentTerms(){
		return m_PaymentTerms;
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

	public ExchangeRate getPricing ExchangeRate(){
		return Pricing ExchangeRate;
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

	public DocumentReference getReceipt DocumentReference(){
		return Receipt DocumentReference;
	}

	public SupplierParty getSeller SupplierParty(){
		return Seller SupplierParty;
	}

	public Signature getSignature(){
		return m_Signature;
	}

	public DocumentReference getStatement DocumentReference(){
		return Statement DocumentReference;
	}

	public ExchangeRate getTax ExchangeRate(){
		return Tax ExchangeRate;
	}

	public Party getTax Representative Party(){
		return Tax Representative Party;
	}

	public TaxTotal getTaxTotal(){
		return m_TaxTotal;
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
	public void setAccounting CustomerParty(CustomerParty newVal){
		Accounting CustomerParty = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAccounting SupplierParty(SupplierParty newVal){
		Accounting SupplierParty = newVal;
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
	public void setAdditional DocumentReference(DocumentReference newVal){
		Additional DocumentReference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAllowanceCharge(AllowanceCharge newVal){
		m_AllowanceCharge = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setBillingReference(BillingReference newVal){
		m_BillingReference = newVal;
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
	public void setContract DocumentReference(DocumentReference newVal){
		Contract DocumentReference = newVal;
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
	public void setDelivery(Delivery newVal){
		m_Delivery = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDeliveryTerms(DeliveryTerms newVal){
		m_DeliveryTerms = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDespatch DocumentReference(DocumentReference newVal){
		Despatch DocumentReference = newVal;
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
	public void setInvoiceLine(InvoiceLine newVal){
		m_InvoiceLine = newVal;
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
	public void setLegal MonetaryTotal(MonetaryTotal newVal){
		Legal MonetaryTotal = newVal;
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
	public void setOriginator DocumentReference(DocumentReference newVal){
		Originator DocumentReference = newVal;
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
	public void setPayment Alternative ExchangeRate(ExchangeRate newVal){
		Payment Alternative ExchangeRate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPayment ExchangeRate(ExchangeRate newVal){
		Payment ExchangeRate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPaymentMeans(PaymentMeans newVal){
		m_PaymentMeans = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPaymentTerms(PaymentTerms newVal){
		m_PaymentTerms = newVal;
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
	public void setPricing ExchangeRate(ExchangeRate newVal){
		Pricing ExchangeRate = newVal;
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
	public void setReceipt DocumentReference(DocumentReference newVal){
		Receipt DocumentReference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSeller SupplierParty(SupplierParty newVal){
		Seller SupplierParty = newVal;
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
	public void setStatement DocumentReference(DocumentReference newVal){
		Statement DocumentReference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTax ExchangeRate(ExchangeRate newVal){
		Tax ExchangeRate = newVal;
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
	public void setTaxTotal(TaxTotal newVal){
		m_TaxTotal = newVal;
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
}//end Self Billed Invoice