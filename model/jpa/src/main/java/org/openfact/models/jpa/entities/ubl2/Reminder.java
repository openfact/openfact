package org.openfact.models.jpa.entities.ubl2;

/**
 * A document used to remind a customer of payments past due.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:21:15 a. m.
 */
public class Reminder {

    /**
     * The buyer's accounting code, applied to the Reminder as a whole,
     * expressed as text.
     */
    private Text.Type AccountingCost;
    /**
     * The buyer's accounting code, applied to the Reminder as a whole.
     */
    private Code.Type AccountingCostCode;
    /**
     * Indicates whether this document is a copy (true) or not (false).
     */
    private Indicator.Type CopyIndicator;
    /**
     * Identifies a user-defined customization of UBL for a specific use.
     */
    private Identifier.Type CustomizationID;
    /**
	 * A code signifying the default currency for this document.
	 */
	private Currency_ Code.
    Type DocumentCurrencyCode;
    /**
     * An identifier for this document, assigned by the sender.
     */
    private Identifier.Type ID;
    /**
     * The date, assigned by the sender, on which this document was issued.
     */
    private Date.Type IssueDate;
    /**
     * The time, assigned by the sender, at which this document was issued.
     */
    private Time.Type IssueTime;
    /**
     * The number of Reminder Lines in this document.
     */
    private Numeric.Type LineCountNumeric;
    /**
     * Free-form text pertinent to this document, conveying information that is
     * not contained explicitly in other structures.
     */
    private Text.Type Note;
    /**
	 * A code signifying the alternative currency used for payment in the Reminder.
	 */
	private Currency_ Code.
    Type PaymentAlternativeCurrencyCode;
    /**
	 * A code signifying the currency used for payment in the Reminder.
	 */
	private Currency_ Code.
    Type PaymentCurrencyCode;
    /**
	 * A code signifying the currency used for prices in the Reminder.
	 */
	private Currency_ Code.
    Type PricingCurrencyCode;
    /**
     * Identifies an instance of executing a profile, to associate all
     * transactions in a collaboration.
     */
    private Identifier.Type ProfileExecutionID;
    /**
     * Identifies a user-defined profile of the customization of UBL being used.
     */
    private Identifier.Type ProfileID;
    /**
     * The number of the current Reminder in the sequence of reminders relating
     * to the specified payments; the number of reminders previously sent plus
     * one.
     */
    private Numeric.Type ReminderSequenceNumeric;
    /**
     * A code signifying the type of the Reminder.
     */
    private Code.Type ReminderTypeCode;
    /**
	 * A code signifying the currency used for tax amounts in the Reminder.
	 */
	private Currency_ Code.
    Type TaxCurrencyCode;
    /**
     * The date of the Reminder, used to indicate the point at which tax becomes
     * applicable.
     */
    private Date.Type TaxPointDate;
    /**
     * Identifies the earliest version of the UBL 2 schema for this document
     * type that defines all of the elements that might be encountered in the
     * current instance.
     */
    private Identifier.Type UBLVersionID;
    /**
     * A universally unique identifier for an instance of this document.
     */
    private Identifier.Type UUID;
    private Allowance Charge
    m_Allowance Charge;
    private Customer Party
    Accounting Customer Party;
    private Document Reference
    Additional Document Reference;
    private Exchange Rate
    Payment Alternative
    Exchange Rate;
    private Exchange Rate
    Pricing Exchange Rate;
    private Exchange Rate
    Tax Exchange Rate;
    private Exchange Rate
    Payment Exchange Rate;
    private Monetary Total
    Legal Monetary Total;
    private Party Tax
    Representative Party;
    private Party Payee Party;
    private Payment Prepaid Payment;
    private Payment Means
    m_Payment Means;
    private Payment Terms
    m_Payment Terms;
    private Period Reminder Period;
    private Reminder Line
    m_Reminder Line;
    private Signature m_Signature;
    private Supplier Party
    Accounting Supplier Party;
    private Tax Total
    m_Tax Total;

    public Reminder() {

    }

    public void finalize() throws Throwable {

    }

    public Customer Party
    getAccounting Customer

    Party(){
		return Accounting Customer Party;
	}

    public Supplier Party
    getAccounting Supplier

    Party(){
		return Accounting Supplier Party;
	}

    public Text.Type getAccountingCost() {
        return AccountingCost;
    }

    public Code.Type getAccountingCostCode() {
        return AccountingCostCode;
    }

    public Document Reference
    getAdditional Document

    Reference(){
		return Additional Document Reference;
	}

    public Allowance Charge

    getAllowance Charge(){
		return m_Allowance Charge;
	}

    public Indicator.Type getCopyIndicator() {
        return CopyIndicator;
    }

    public Identifier.Type getCustomizationID() {
        return CustomizationID;
    }

    public Currency_ Code.

    Type getDocumentCurrencyCode() {
        return DocumentCurrencyCode;
    }

    public Identifier.Type getID() {
        return ID;
    }

    public Date.Type getIssueDate() {
        return IssueDate;
    }

    public Time.Type getIssueTime() {
        return IssueTime;
    }

    public Monetary Total
    getLegal Monetary

    Total(){
		return Legal Monetary Total;
	}

    public Numeric.Type getLineCountNumeric() {
        return LineCountNumeric;
    }

    public Text.Type getNote() {
        return Note;
    }

    public Party getPayee

    Party(){
		return Payee Party;
	}

    public Exchange Rate
    getPayment Alternative

    Exchange Rate(){
		return Payment Alternative Exchange Rate;
	}

    public Exchange Rate
    getPayment Exchange

    Rate(){
		return Payment Exchange Rate;
	}

    public Payment Means

    getPayment Means(){
		return m_Payment Means;
	}

    public Payment Terms

    getPayment Terms(){
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

    public Exchange Rate
    getPricing Exchange

    Rate(){
		return Pricing Exchange Rate;
	}

    public Currency_ Code.

    Type getPricingCurrencyCode() {
        return PricingCurrencyCode;
    }

    public Identifier.Type getProfileExecutionID() {
        return ProfileExecutionID;
    }

    public Identifier.Type getProfileID() {
        return ProfileID;
    }

    public Reminder Line

    getReminder Line() {
        return m_Reminder Line;
    }

    public Period getReminder

    Period(){
		return Reminder Period;
	}

    public Numeric.Type getReminderSequenceNumeric() {
        return ReminderSequenceNumeric;
    }

    public Code.Type getReminderTypeCode() {
        return ReminderTypeCode;
    }

    public Signature getSignature() {
        return m_Signature;
    }

    public Exchange Rate
    getTax Exchange

    Rate(){
		return Tax Exchange Rate;
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

    public Date.Type getTaxPointDate() {
        return TaxPointDate;
    }

    public Identifier.Type getUBLVersionID() {
        return UBLVersionID;
    }

    public Identifier.Type getUUID() {
        return UUID;
    }

    /**
	 * 
	 * @param newVal
	 */
	public void setAccounting

    Customer Party(Customer Party newVal){
		Accounting Customer Party = newVal;
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
    public void setAccountingCost(Text.Type newVal) {
        AccountingCost = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setAccountingCostCode(Code.Type newVal) {
        AccountingCostCode = newVal;
    }

    /**
	 * 
	 * @param newVal
	 */
	public void setAdditional

    Document Reference(Document Reference newVal){
		Additional Document Reference = newVal;
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
    public void setCopyIndicator(Indicator.Type newVal) {
        CopyIndicator = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setCustomizationID(Identifier.Type newVal) {
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
    public void setID(Identifier.Type newVal) {
        ID = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setIssueDate(Date.Type newVal) {
        IssueDate = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setIssueTime(Time.Type newVal) {
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
    public void setLineCountNumeric(Numeric.Type newVal) {
        LineCountNumeric = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setNote(Text.Type newVal) {
        Note = newVal;
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

    Rate(Exchange Rate newVal){
		Payment Alternative Exchange Rate = newVal;
	}

    /**
	 * 
	 * @param newVal
	 */
	public void setPayment

    Exchange Rate(Exchange Rate newVal){
		Payment Exchange Rate = newVal;
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
	public void setPrepaid

    Payment(Payment newVal){
		Prepaid Payment = newVal;
	}

    /**
	 * 
	 * @param newVal
	 */
	public void setPricing

    Exchange Rate(Exchange Rate newVal){
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
    public void setProfileExecutionID(Identifier.Type newVal) {
        ProfileExecutionID = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setProfileID(Identifier.Type newVal) {
        ProfileID = newVal;
    }

    /**
	 * 
	 * @param newVal
	 */
	public void setReminder

    Line(Reminder Line newVal){
		m_Reminder Line = newVal;
	}

    /**
	 * 
	 * @param newVal
	 */
	public void setReminder

    Period(Period newVal){
		Reminder Period = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setReminderSequenceNumeric(Numeric.Type newVal) {
        ReminderSequenceNumeric = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setReminderTypeCode(Code.Type newVal) {
        ReminderTypeCode = newVal;
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
	public void setTax

    Exchange Rate(Exchange Rate newVal){
		Tax Exchange Rate = newVal;
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
	public void setTaxCurrencyCode(Currency_ Code. Type newVal){
		TaxCurrencyCode = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setTaxPointDate(Date.Type newVal) {
        TaxPointDate = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setUBLVersionID(Identifier.Type newVal) {
        UBLVersionID = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setUUID(Identifier.Type newVal) {
        UUID = newVal;
    }
}// end Reminder