package org.openfact.models.jpa.entities.ubl;

/**
 * A document used to report the status of orders, billing, and payment. This
 * document is a statement of account, not a summary invoice.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:21:25 a. m.
 */
public class Statement {

    /**
     * Indicates whether this document is a copy (true) or not (false).
     */
    private boolean CopyIndicator;
    /**
     * Identifies a user-defined customization of UBL for a specific use.
     */
    private String CustomizationID;
    /**
	 * The default currency for the Statement.
	 */
	private Currency_ Code.
    Type DocumentCurrencyCode;
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
     * The number of Statement Lines in the Statement.
     */
    private BigDecimal LineCountNumeric;
    /**
     * Free-form text pertinent to this document, conveying information that is
     * not contained explicitly in other structures.
     */
    private String Note;
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
     * A code signifying the type of the Statement.
     */
    private String StatementTypeCode;
    /**
     * The total amount for the Statement.
     */
    private BigDecimal TotalBalanceAmount;
    /**
     * The total of all credit amounts for the Statement.
     */
    private BigDecimal TotalCreditAmount;
    /**
     * The total of all debit amounts for the Statement.
     */
    private BigDecimal TotalDebitAmount;
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
    private Customer Party
    Accounting Customer Party;
    private Customer Party
    Originator Customer Party;
    private Customer Party
    Buyer Customer Party;
    private DocumentReference
    Additional DocumentReference;
    private Party Payee Party;
    private Payment Means
    m_Payment Means;
    private Payment Terms
    m_Payment Terms;
    private Period Statement Period;
    private Signature m_Signature;
    private Statement Line
    m_Statement Line;
    private Supplier Party
    Seller Supplier Party;
    private Supplier Party
    Accounting Supplier Party;
    private Tax Total
    m_Tax Total;

    public Statement() {

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

    public DocumentReference
    getAdditional Document

    Reference(){
		return Additional DocumentReference;
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

    public boolean getCopyIndicator() {
        return CopyIndicator;
    }

    public String getCustomizationID() {
        return CustomizationID;
    }

    public Currency_ Code.

    Type getDocumentCurrencyCode() {
        return DocumentCurrencyCode;
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

    public Customer Party
    getOriginator Customer

    Party(){
		return Originator Customer Party;
	}

    public Party getPayee

    Party(){
		return Payee Party;
	}

    public Payment Means

    getPayment Means(){
		return m_Payment Means;
	}

    public Payment Terms

    getPayment Terms(){
		return m_Payment Terms;
	}

    public String getProfileExecutionID() {
        return ProfileExecutionID;
    }

    public String getProfileID() {
        return ProfileID;
    }

    public Supplier Party
    getSeller Supplier

    Party(){
		return Seller Supplier Party;
	}

    public Signature getSignature() {
        return m_Signature;
    }

    public Statement Line

    getStatement Line(){
		return m_Statement Line;
	}

    public Period getStatement

    Period(){
		return Statement Period;
	}

    public String getStatementTypeCode() {
        return StatementTypeCode;
    }

    public Tax Total

    getTax Total(){
		return m_Tax Total;
	}

    public BigDecimal getTotalBalanceAmount() {
        return TotalBalanceAmount;
    }

    public BigDecimal getTotalCreditAmount() {
        return TotalCreditAmount;
    }

    public BigDecimal getTotalDebitAmount() {
        return TotalDebitAmount;
    }

    public String getUBLVersionID() {
        return UBLVersionID;
    }

    public String getUUID() {
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

    Customer Party(Customer Party newVal){
		Buyer Customer Party = newVal;
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
	public void setDocumentCurrencyCode(Currency_ String newVal){
		DocumentCurrencyCode = newVal;
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

    Customer Party(Customer Party newVal){
		Originator Customer Party = newVal;
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
	public void setStatement

    Line(Statement Line newVal){
		m_Statement Line = newVal;
	}

    /**
	 * 
	 * @param newVal
	 */
	public void setStatement

    Period(Period newVal){
		Statement Period = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setStatementTypeCode(String newVal) {
        StatementTypeCode = newVal;
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
    public void setTotalBalanceAmount(BigDecimal newVal) {
        TotalBalanceAmount = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setTotalCreditAmount(BigDecimal newVal) {
        TotalCreditAmount = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setTotalDebitAmount(BigDecimal newVal) {
        TotalDebitAmount = newVal;
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
}// end Statement