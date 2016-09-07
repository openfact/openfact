package org.openfact.models.jpa.entities.ubl;

/**
 * A document used to quote for the provision of goods and services.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:21:10 a. m.
 */
public class Quotation {

    /**
     * Indicates whether this document is a copy (true) or not (false).
     */
    private Indicator.Type CopyIndicator;
    /**
     * Identifies a user-defined customization of UBL for a specific use.
     */
    private Identifier.Type CustomizationID;
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
     * The number of Quotation Lines in this document.
     */
    private Numeric.Type LineCountNumeric;
    /**
     * Free-form text pertinent to this document, conveying information that is
     * not contained explicitly in other structures.
     */
    private Text.Type Note;
    /**
	 * A code signifying the currency used for all prices in the Quotation.
	 */
	private Currency_ Code.
    Type PricingCurrencyCode;
    /**
     * Identifies an instance of executing a profile, to associate all
     * transactions in a collaboration.
     */
    private Identifier.Type ProfileExecutionID;
    /**
     * Identifies a user-defined profile of the subset of UBL being used.
     */
    private Identifier.Type ProfileID;
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
    private Contract m_Contract;
    private Country Destination Country;
    private Customer Party
    Buyer Customer Party;
    private Customer Party
    Originator Customer Party;
    private Delivery m_Delivery;
    private Delivery Terms
    m_Delivery Terms;
    private Document Reference
    Additional Document Reference;
    private Document Reference
    Request For
    Quotation Document Reference;
    private Monetary Total
    Quoted Monetary Total;
    private Payment Means
    m_Payment Means;
    private Period Validity Period;
    private Quotation Line
    m_Quotation Line;
    private Signature m_Signature;
    private Supplier Party
    Seller Supplier Party;
    private Tax Total
    m_Tax Total;
    private Transaction Conditions
    m_Transaction Conditions;

    public Quotation() {

    }

    public void finalize() throws Throwable {

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

    public Customer Party
    getBuyer Customer

    Party(){
		return Buyer Customer Party;
	}

    public Contract getContract() {
        return m_Contract;
    }

    public Indicator.Type getCopyIndicator() {
        return CopyIndicator;
    }

    public Identifier.Type getCustomizationID() {
        return CustomizationID;
    }

    public Delivery getDelivery() {
        return m_Delivery;
    }

    public Delivery Terms

    getDelivery Terms(){
		return m_Delivery Terms;
	}

    public Country getDestination

    Country(){
		return Destination Country;
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

    public Numeric.Type getLineCountNumeric() {
        return LineCountNumeric;
    }

    public Text.Type getNote() {
        return Note;
    }

    public Customer Party
    getOriginator Customer

    Party(){
		return Originator Customer Party;
	}

    public Payment Means

    getPayment Means(){
		return m_Payment Means;
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

    public Quotation Line

    getQuotation Line(){
		return m_Quotation Line;
	}

    public Monetary Total
    getQuoted Monetary

    Total(){
		return Quoted Monetary Total;
	}

    public Document Reference
    getRequest For
    Quotation Document

    Reference(){
		return Request For Quotation Document Reference;
	}

    public Supplier Party
    getSeller Supplier

    Party(){
		return Seller Supplier Party;
	}

    public Signature getSignature() {
        return m_Signature;
    }

    public Tax Total

    getTax Total(){
		return m_Tax Total;
	}

    public Transaction Conditions

    getTransaction Conditions(){
		return m_Transaction Conditions;
	}

    public Identifier.Type getUBLVersionID() {
        return UBLVersionID;
    }

    public Identifier.Type getUUID() {
        return UUID;
    }

    public Period getValidity

    Period(){
		return Validity Period;
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
	public void setBuyer

    Customer Party(Customer Party newVal){
		Buyer Customer Party = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setContract(Contract newVal) {
        m_Contract = newVal;
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
	public void setDestination

    Country(Country newVal){
		Destination Country = newVal;
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
	public void setOriginator

    Customer Party(Customer Party newVal){
		Originator Customer Party = newVal;
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
	public void setQuotation

    Line(Quotation Line newVal){
		m_Quotation Line = newVal;
	}

    /**
	 * 
	 * @param newVal
	 */
	public void setQuoted

    Monetary Total(Monetary Total newVal){
		Quoted Monetary Total = newVal;
	}

    /**
	 * 
	 * @param newVal
	 */
	public void setRequest
    For Quotation

    Document Reference(Document Reference newVal){
		Request For Quotation Document Reference = newVal;
	}

    /**
	 * 
	 * @param newVal
	 */
	public void setSeller

    Supplier Party(Supplier Party newVal){
		Seller Supplier Party = newVal;
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

    Total(Tax Total newVal){
		m_Tax Total = newVal;
	}

    /**
	 * 
	 * @param newVal
	 */
	public void setTransaction

    Conditions(Transaction Conditions newVal){
		m_Transaction Conditions = newVal;
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

    /**
	 * 
	 * @param newVal
	 */
	public void setValidity

    Period(Period newVal){
		Validity Period = newVal;
	}
}// end Quotation