package org.openfact.models.jpa.entities.ubl;


/**
 * A document that specifies details of an actual payment.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:21:17 a. m.
 */
public class RemittanceAdvice {

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
	 * An internal reference to the order for payment by the invoicing party. This may
	 * have been requested of the payer by the payee to accompany the payer's
	 * remittance.
	 */
	private String InvoicingPartyReference;
	/**
	 * The date, assigned by the sender, on which this document was issued.
	 */
	private LocalDate IssueDate;
	/**
	 * The time, assigned by the sender, at which this document was issued.
	 */
	private LocalTime IssueTime;
	/**
	 * The number of Remittance Advice Lines in the document.
	 */
	private BigDecimal LineCountNumeric;
	/**
	 * Free-form text pertinent to this document, conveying information that is not
	 * contained explicitly in other structures.
	 */
	private String Note;
	/**
	 * An internal reference to the payer's order for payment.
	 */
	private String PayerReference;
	/**
	 * An internal reference to the order for payment from the payer to the payer's
	 * bank.
	 */
	private String PaymentOrderReference;
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
	 * The totals of all credit amounts for the Remittance Advice.
	 */
	private BigDecimal TotalCreditAmount;
	/**
	 * The totals of all debit amounts for the Remittance Advice.
	 */
	private BigDecimal TotalDebitAmount;
	/**
	 * The total payable amount for the Remittance Advice (must be positive).
	 */
	private BigDecimal TotalPaymentAmount;
	/**
	 * Identifies the earliest version of the UBL 2 schema for this document type that
	 * defines all of the elements that might be encountered in the current instance.
	 */
	private String UBLVersionID;
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private String UUID;
	private Billing Reference m_Billing Reference;
	private Customer Party Accounting Customer Party;
	private Document Reference Additional Document Reference;
	private Party Payee Party;
	private Payment Means m_Payment Means;
	private Period Invoice Period;
	private Remittance Advice Line m_Remittance Advice Line;
	private Signature m_Signature;
	private Supplier Party Accounting Supplier Party;
	private Tax Total m_Tax Total;

	public Remittance Advice(){

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

	public Billing Reference getBilling Reference(){
		return m_Billing Reference;
	}

	public boolean getCopyIndicator(){
		return CopyIndicator;
	}

	public String getCustomizationID(){
		return CustomizationID;
	}

	public Currency_ String getDocumentCurrencyCode(){
		return DocumentCurrencyCode;
	}

	public String getID(){
		return ID;
	}

	public Period getInvoice Period(){
		return Invoice Period;
	}

	public String getInvoicingPartyReference(){
		return InvoicingPartyReference;
	}

	public LocalDate getIssueDate(){
		return IssueDate;
	}

	public LocalTime getIssueTime(){
		return IssueTime;
	}

	public BigDecimal getLineCountNumeric(){
		return LineCountNumeric;
	}

	public String getNote(){
		return Note;
	}

	public Party getPayee Party(){
		return Payee Party;
	}

	public String getPayerReference(){
		return PayerReference;
	}

	public Payment Means getPayment Means(){
		return m_Payment Means;
	}

	public String getPaymentOrderReference(){
		return PaymentOrderReference;
	}

	public String getProfileExecutionID(){
		return ProfileExecutionID;
	}

	public String getProfileID(){
		return ProfileID;
	}

	public Remittance Advice Line getRemittance Advice Line(){
		return m_Remittance Advice Line;
	}

	public Signature getSignature(){
		return m_Signature;
	}

	public Tax Total getTax Total(){
		return m_Tax Total;
	}

	public BigDecimal getTotalCreditAmount(){
		return TotalCreditAmount;
	}

	public BigDecimal getTotalDebitAmount(){
		return TotalDebitAmount;
	}

	public BigDecimal getTotalPaymentAmount(){
		return TotalPaymentAmount;
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
	public void setAdditional Document Reference(Document Reference newVal){
		Additional Document Reference = newVal;
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
	public void setInvoice Period(Period newVal){
		Invoice Period = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setInvoicingPartyReference(String newVal){
		InvoicingPartyReference = newVal;
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
	public void setPayee Party(Party newVal){
		Payee Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPayerReference(String newVal){
		PayerReference = newVal;
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
	public void setPaymentOrderReference(String newVal){
		PaymentOrderReference = newVal;
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
	public void setRemittance Advice Line(Remittance Advice Line newVal){
		m_Remittance Advice Line = newVal;
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
	public void setTax Total(Tax Total newVal){
		m_Tax Total = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTotalCreditAmount(BigDecimal newVal){
		TotalCreditAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTotalDebitAmount(BigDecimal newVal){
		TotalDebitAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTotalPaymentAmount(BigDecimal newVal){
		TotalPaymentAmount = newVal;
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
}//end Remittance Advice