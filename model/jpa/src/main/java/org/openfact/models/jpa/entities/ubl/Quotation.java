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
    private boolean CopyIndicator;
    /**
     * Identifies a user-defined customization of UBL for a specific use.
     */
    private String CustomizationID;
    /**
     * An identifier for this document, assigned by the sender.
     */
    private String ID;
    /**
     * The date, assigned by the sender, on which this document was issued.
     */
    private LocalDate IssueDate;
    /**
     * The time, assigned by the sender, at which this document was issued.
     */
    private LocalTime IssueTime;
    /**
     * The number of Quotation Lines in this document.
     */
    private BigDecimal LineCountNumeric;
    /**
     * Free-form text pertinent to this document, conveying information that is
     * not contained explicitly in other structures.
     */
    private String Note;
    /**
	 * A code signifying the currency used for all prices in the Quotation.
	 */
	private Currency_ Code.
    Type PricingCurrencyCode;
    /**
     * Identifies an instance of executing a profile, to associate all
     * transactions in a collaboration.
     */
    private String ProfileExecutionID;
    /**
     * Identifies a user-defined profile of the subset of UBL being used.
     */
    private String ProfileID;
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
    private Contract m_Contract;
    private Country Destination Country;
    private CustomerParty
    Buyer CustomerParty;
    private CustomerParty
    Originator CustomerParty;
    private Delivery m_Delivery;
    private DeliveryTerms
    m_DeliveryTerms;
    private DocumentReference
    Additional DocumentReference;
    private DocumentReference
    Request For
    Quotation DocumentReference;
    private MonetaryTotal
    Quoted MonetaryTotal;
    private PaymentMeans
    m_PaymentMeans;
    private Period Validity Period;
    private Quotation Line
    m_Quotation Line;
    private Signature m_Signature;
    private SupplierParty
    Seller SupplierParty;
    private TaxTotal
    m_TaxTotal;
    private Transaction Conditions
    m_Transaction Conditions;

    public Quotation() {

    }

    public void finalize() throws Throwable {

    }

    public DocumentReference
    getAdditional Document

    Reference(){
		return Additional DocumentReference;
	}

    public Allowance Charge

    getAllowance Charge(){
		return m_Allowance Charge;
	}

    public CustomerParty
    getBuyer Customer

    Party(){
		return Buyer CustomerParty;
	}

    public Contract getContract() {
        return m_Contract;
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

    public DeliveryTerms

    getDeliveryTerms(){
		return m_DeliveryTerms;
	}

    public Country getDestination

    Country(){
		return Destination Country;
	}

    public String getID() {
        return ID;
    }

    public LocalDate getIssueDate() {
        return IssueDate;
    }

    public LocalTime getIssueTime() {
        return IssueTime;
    }

    public BigDecimal getLineCountNumeric() {
        return LineCountNumeric;
    }

    public String getNote() {
        return Note;
    }

    public CustomerParty
    getOriginator Customer

    Party(){
		return Originator CustomerParty;
	}

    public PaymentMeans

    getPaymentMeans(){
		return m_PaymentMeans;
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

    public Quotation Line

    getQuotation Line(){
		return m_Quotation Line;
	}

    public MonetaryTotal
    getQuoted Monetary

    Total(){
		return Quoted MonetaryTotal;
	}

    public DocumentReference
    getRequest For
    Quotation Document

    Reference(){
		return Request For Quotation DocumentReference;
	}

    public SupplierParty
    getSeller Supplier

    Party(){
		return Seller SupplierParty;
	}

    public Signature getSignature() {
        return m_Signature;
    }

    public TaxTotal

    getTaxTotal(){
		return m_TaxTotal;
	}

    public Transaction Conditions

    getTransaction Conditions(){
		return m_Transaction Conditions;
	}

    public String getUBLVersionID() {
        return UBLVersionID;
    }

    public String getUUID() {
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
	public void setBuyer

    CustomerParty(CustomerParty newVal){
		Buyer CustomerParty = newVal;
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

    Terms(DeliveryTerms newVal){
		m_DeliveryTerms = newVal;
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
    public void setID(String newVal) {
        ID = newVal;
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
	public void setOriginator

    CustomerParty(CustomerParty newVal){
		Originator CustomerParty = newVal;
	}

    /**
	 * 
	 * @param newVal
	 */
	public void setPayment

    Means(PaymentMeans newVal){
		m_PaymentMeans = newVal;
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
	public void setQuotation

    Line(Quotation Line newVal){
		m_Quotation Line = newVal;
	}

    /**
	 * 
	 * @param newVal
	 */
	public void setQuoted

    MonetaryTotal(MonetaryTotal newVal){
		Quoted MonetaryTotal = newVal;
	}

    /**
	 * 
	 * @param newVal
	 */
	public void setRequest
    For Quotation

    DocumentReference(DocumentReference newVal){
		Request For Quotation DocumentReference = newVal;
	}

    /**
	 * 
	 * @param newVal
	 */
	public void setSeller

    SupplierParty(SupplierParty newVal){
		Seller SupplierParty = newVal;
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

    Total(TaxTotal newVal){
		m_TaxTotal = newVal;
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
	public void setValidity

    Period(Period newVal){
		Validity Period = newVal;
	}
}// end Quotation