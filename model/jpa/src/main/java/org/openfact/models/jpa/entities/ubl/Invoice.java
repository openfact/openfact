package org.openfact.models.jpa.entities.ubl;

/**
 * A document used to request payment.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:20:49 a. m.
 */
public class Invoice {

    /**
     * The buyer's accounting code, applied to the Invoice as a whole, expressed
     * as text.
     */
    private String AccountingCost;
    /**
     * The buyer's accounting code, applied to the Invoice as a whole.
     */
    private String AccountingCostCode;
    /**
     * A reference provided by the buyer used for internal routing of the
     * document.
     */
    private String BuyerReference;
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
	private Currency_ Code.
    Type DocumentCurrencyCode;
    /**
     * The date on which Invoice is due.
     */
    private LocalDate DueDate;
    /**
     * An identifier for this document, assigned by the sender.
     */
    private String ID;
    /**
     * A code signifying the type of the Invoice.
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
     * The number of lines in the document.
     */
    private BigDecimal LineCountNumeric;
    /**
     * Free-form text pertinent to this document, conveying information that is
     * not contained explicitly in other structures.
     */
    private String Note;
    /**
	 * A code signifying the alternative currency used for payment in the Invoice.
	 */
	private Currency_ Code.
    Type PaymentAlternativeCurrencyCode;
    /**
	 * A code signifying the currency used for payment in the Invoice.
	 */
	private Currency_ Code.
    Type PaymentCurrencyCode;
    /**
	 * A code signifying the currency used for prices in the Invoice.
	 */
	private Currency_ Code.
    Type PricingCurrencyCode;
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
	 * A code signifying the currency used for tax amounts in the Invoice.
	 */
	private Currency_ Code.
    Type TaxCurrencyCode;
    /**
     * The date of the Invoice, used to indicate the point at which tax becomes
     * applicable.
     */
    private LocalDate TaxPointDate;
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
    private Allowance Charge
    m_Allowance Charge;
    private Billing Reference
    m_Billing Reference;
    private CustomerParty
    Accounting CustomerParty;
    private CustomerParty
    Buyer CustomerParty;
    private Delivery m_Delivery;
    private Delivery Terms
    m_Delivery Terms;
    private DocumentReference
    Statement DocumentReference;
    private DocumentReference
    Receipt DocumentReference;
    private DocumentReference
    Despatch DocumentReference;
    private DocumentReference
    Originator DocumentReference;
    private DocumentReference
    Contract DocumentReference;
    private DocumentReference
    Additional DocumentReference;
    private ExchangeRate
    Tax ExchangeRate;
    private ExchangeRate
    Pricing ExchangeRate;
    private ExchangeRate
    Payment ExchangeRate;
    private ExchangeRate
    Payment Alternative
    ExchangeRate;
    private Invoice Line
    m_Invoice Line;
    private Monetary Total
    Legal Monetary Total;
    private Order Reference
    m_Order Reference;
    private Party Tax
    Representative Party;
    private Party Payee Party;
    private Payment Prepaid Payment;
    private Payment Means
    m_Payment Means;
    private Payment Terms
    m_Payment Terms;
    private Period Invoice Period;
    private Project Reference
    m_Project Reference;
    private Signature m_Signature;
    private Supplier Party
    Accounting Supplier Party;
    private Supplier Party
    Seller Supplier Party;
    private Tax Total
    Withholding Tax Total;
    private Tax Total
    m_Tax Total;

    public Invoice() {

    }

    public void finalize() throws Throwable {

    }

    public CustomerParty
    getAccounting Customer

    Party(){
		return Accounting CustomerParty;
	}

    public Supplier Party
    getAccounting Supplier

    Party(){
		return Accounting Supplier Party;
	}

    public String getAccountingCost() {
        return AccountingCost;
    }

    public String getAccountingCostCode() {
        return AccountingCostCode;
    }

    public DocumentReference
    getAdditional Document

    Reference(){
		return Additional DocumentReference;
	}

    public Allowance Charge

    getAllowance Charge() {
        return m_Allowance Charge;
    }

    public Billing Reference

    getBilling Reference() {
        return m_Billing Reference;
    }

    public CustomerParty
    getBuyer Customer

    Party(){
		return Buyer CustomerParty;
	}

    public String getBuyerReference() {
        return BuyerReference;
    }

    public DocumentReference
    getContract Document

    Reference(){
		return Contract DocumentReference;
	}

    public boolean getCopyIndicator() {
        return CopyIndicator;
    }

    public String getCustomizationID() {
        return CustomizationID;
    }

    public Delivery getDelivery() {
        return m_Delivery;
    }

    public Delivery Terms

    getDelivery Terms() {
        return m_Delivery Terms;
    }

    public DocumentReference
    getDespatch Document

    Reference(){
		return Despatch DocumentReference;
	}

    public Currency_ Code.

    Type getDocumentCurrencyCode() {
        return DocumentCurrencyCode;
    }

    public LocalDate getDueDate() {
        return DueDate;
    }

    public String getID() {
        return ID;
    }

    public Invoice Line

    getInvoice Line() {
        return m_Invoice Line;
    }

    public Period getInvoice

    Period(){
		return Invoice Period;
	}

    public String getInvoiceTypeCode() {
        return InvoiceTypeCode;
    }

    public LocalDate getIssueDate() {
        return IssueDate;
    }

    public LocalTime getIssueTime() {
        return IssueTime;
    }

    public Monetary Total
    getLegal Monetary

    Total(){
		return Legal Monetary Total;
	}

    public BigDecimal getLineCountNumeric() {
        return LineCountNumeric;
    }

    public String getNote() {
        return Note;
    }

    public Order Reference

    getOrder Reference() {
        return m_Order Reference;
    }

    public DocumentReference
    getOriginator Document

    Reference(){
		return Originator DocumentReference;
	}

    public Party getPayee

    Party(){
		return Payee Party;
	}

    public ExchangeRate
    getPayment Alternative

    ExchangeRate(){
		return Payment Alternative ExchangeRate;
	}

    public ExchangeRate
    getPayment Exchange

    Rate(){
		return Payment ExchangeRate;
	}

    public Payment Means

    getPayment Means() {
        return m_Payment Means;
    }

    public Payment Terms

    getPayment Terms() {
        return m_Payment Terms;
    }

    public Currency_ Code.

    Type getPaymentAlternativeCurrencyCode() {
        return PaymentAlternativeCurrencyCode;
    }

    public Currency_ Code.

    Type getPaymentCurrencyCode() {
        return PaymentCurrencyCode;
    }

    public Payment getPrepaid

    Payment(){
		return Prepaid Payment;
	}

    public ExchangeRate
    getPricing Exchange

    Rate(){
		return Pricing ExchangeRate;
	}

    public Currency_ Code.

    Type getPricingCurrencyCode() {
        return PricingCurrencyCode;
    }

    public String getProfileExecutionID() {
        return ProfileExecutionID;
    }

    public String getProfileID() {
        return ProfileID;
    }

    public Project Reference

    getProject Reference() {
        return m_Project Reference;
    }

    public DocumentReference
    getReceipt Document

    Reference(){
		return Receipt DocumentReference;
	}

    public Supplier Party
    getSeller Supplier

    Party(){
		return Seller Supplier Party;
	}

    public Signature getSignature() {
        return m_Signature;
    }

    public DocumentReference
    getStatement Document

    Reference(){
		return Statement DocumentReference;
	}

    public ExchangeRate
    getTax Exchange

    Rate(){
		return Tax ExchangeRate;
	}

    public Party getTax

    Representative Party() {
        return Tax Representative Party;
    }

    public Tax Total

    getTax Total() {
        return m_Tax Total;
    }

    public Currency_ Code.

    Type getTaxCurrencyCode() {
        return TaxCurrencyCode;
    }

    public LocalDate getTaxPointDate() {
        return TaxPointDate;
    }

    public String getUBLVersionID() {
        return UBLVersionID;
    }

    public String getUUID() {
        return UUID;
    }

    public Tax Total
    getWithholding Tax

    Total(){
		return Withholding Tax Total;
	}

    /**
	 * 
	 * @param newVal
	 */
	public void setAccounting

    CustomerParty(CustomerParty newVal){
		Accounting CustomerParty = newVal;
	}

    /**
	 * 
	 * @param newVal
	 */
	public void setAccounting

    Supplier Party(Supplier Party newVal){
		Accounting Supplier Party = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setAccountingCost(String newVal) {
        AccountingCost = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setAccountingCostCode(String newVal) {
        AccountingCostCode = newVal;
    }

    /**
	 * 
	 * @param newVal
	 */
	public void setAdditional

    DocumentReference(DocumentReference newVal){
		Additional DocumentReference = newVal;
	}

    /**
	 * 
	 * @param newVal
	 */
	public void setAllowance

    Charge(Allowance Charge newVal){
		m_Allowance Charge = newVal;
	}

    /**
	 * 
	 * @param newVal
	 */
	public void setBilling

    Reference(Billing Reference newVal){
		m_Billing Reference = newVal;
	}

    /**
	 * 
	 * @param newVal
	 */
	public void setBuyer

    CustomerParty(CustomerParty newVal){
		Buyer CustomerParty = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setBuyerReference(String newVal) {
        BuyerReference = newVal;
    }

    /**
	 * 
	 * @param newVal
	 */
	public void setContract

    DocumentReference(DocumentReference newVal){
		Contract DocumentReference = newVal;
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
    public void setDelivery(Delivery newVal) {
        m_Delivery = newVal;
    }

    /**
	 * 
	 * @param newVal
	 */
	public void setDelivery

    Terms(Delivery Terms newVal){
		m_Delivery Terms = newVal;
	}

    /**
	 * 
	 * @param newVal
	 */
	public void setDespatch

    DocumentReference(DocumentReference newVal){
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
    public void setDueDate(LocalDate newVal) {
        DueDate = newVal;
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
	public void setInvoice

    Line(Invoice Line newVal){
		m_Invoice Line = newVal;
	}

    /**
	 * 
	 * @param newVal
	 */
	public void setInvoice

    Period(Period newVal){
		Invoice Period = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setInvoiceTypeCode(String newVal) {
        InvoiceTypeCode = newVal;
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
	public void setLegal

    Monetary Total(Monetary Total newVal){
		Legal Monetary Total = newVal;
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
	public void setOrder

    Reference(Order Reference newVal){
		m_Order Reference = newVal;
	}

    /**
	 * 
	 * @param newVal
	 */
	public void setOriginator

    DocumentReference(DocumentReference newVal){
		Originator DocumentReference = newVal;
	}

    /**
	 * 
	 * @param newVal
	 */
	public void setPayee

    Party(Party newVal){
		Payee Party = newVal;
	}

    /**
	 * 
	 * @param newVal
	 */
	public void setPayment
    Alternative Exchange

    Rate(ExchangeRate newVal){
		Payment Alternative ExchangeRate = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setPayment

    ExchangeRate(ExchangeRate newVal) {
        Payment ExchangeRate=newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setPayment

    Means(Payment Means newVal){
		m_Payment Means = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setPayment

    Terms(Payment Terms newVal){
		m_Payment Terms = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setPaymentAlternativeCurrencyCode(Currency_ String newVal) {
        PaymentAlternativeCurrencyCode=newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setPaymentCurrencyCode(Currency_ String newVal) {
        PaymentCurrencyCode=newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setPrepaid

    Payment(Payment newVal){
		Prepaid Payment = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setPricing

    ExchangeRate(ExchangeRate newVal) {
        Pricing ExchangeRate=newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setPricingCurrencyCode(Currency_ String newVal) {
        PricingCurrencyCode=newVal;
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
    public void setProject

    Reference(Project Reference newVal){
		m_Project Reference = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setReceipt

    DocumentReference(DocumentReference newVal) {
        Receipt DocumentReference=newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setSeller

    Supplier Party(Supplier Party newVal) {
        Seller Supplier Party=newVal;
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
    public void setStatement

    DocumentReference(DocumentReference newVal) {
        Statement DocumentReference=newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setTax

    ExchangeRate(ExchangeRate newVal) {
        Tax ExchangeRate=newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setTax

    Representative Party(Party newVal) {
        Tax Representative Party=newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setTax

    Total(Tax Total newVal){
		m_Tax Total = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setTaxCurrencyCode(Currency_ String newVal) {
        TaxCurrencyCode=newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setTaxPointDate(LocalDate newVal) {
        TaxPointDate = newVal;
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

    /**
     * 
     * @param newVal
     */
    public void setWithholding

    Tax Total(Tax Total newVal) {
        Withholding Tax Total=newVal;}
}// end Invoice