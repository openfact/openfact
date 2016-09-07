package org.openfact.models.jpa.entities.ubl;


/**
 * A supplement to an Invoice or Credit Note, containing information on the
 * consumption of services provided by utility suppliers to private and public
 * customers, including electricity, gas, water, and telephone services.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:21:50 a. m.
 */
public class UtilityStatement {

	/**
	 * The buyer's accounting cost code, applied to the UtilityStatement, expressed as
	 * text.
	 */
	private String AccountingCost;
	/**
	 * The buyer's accounting cost code, applied to the UtilityStatement.
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
	 * The date, assigned by the sender, on which this document was issued.
	 */
	private LocalDate IssueDate;
	/**
	 * The time, assigned by the sender, at which this document was issued.
	 */
	private LocalTime IssueTime;
	/**
	 * Free-form text pertinent to this document, conveying information that is not
	 * contained explicitly in other structures.
	 */
	private String Note;
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
	 * Identifies the earliest version of the UBL 2 schema for this document type that
	 * defines all of the elements that might be encountered in the current instance.
	 */
	private String UBLVersionID;
	/**
	 * A code signifying the type of Utility Statement.
	 */
	private String UtilityStatementTypeCode;
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private String UUID;
	private Customer Party m_Customer Party;
	private DocumentReference Parent DocumentReference;
	private DocumentReference Additional DocumentReference;
	private On Account Payment Main On Account Payment;
	private Party Receiver Party;
	private Party Subscriber Party;
	private Party Sender Party;
	private Signature m_Signature;
	private Subscriber Consumption m_Subscriber Consumption;

	public Utility Statement(){

	}

	public void finalize() throws Throwable {

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

	public boolean getCopyIndicator(){
		return CopyIndicator;
	}

	public Customer Party getCustomer Party(){
		return m_Customer Party;
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

	public LocalDate getIssueDate(){
		return IssueDate;
	}

	public LocalTime getIssueTime(){
		return IssueTime;
	}

	public On Account Payment getMain On Account Payment(){
		return Main On Account Payment;
	}

	public String getNote(){
		return Note;
	}

	public DocumentReference getParent DocumentReference(){
		return Parent DocumentReference;
	}

	public String getProfileExecutionID(){
		return ProfileExecutionID;
	}

	public String getProfileID(){
		return ProfileID;
	}

	public Party getReceiver Party(){
		return Receiver Party;
	}

	public Party getSender Party(){
		return Sender Party;
	}

	public Signature getSignature(){
		return m_Signature;
	}

	public Subscriber Consumption getSubscriber Consumption(){
		return m_Subscriber Consumption;
	}

	public Party getSubscriber Party(){
		return Subscriber Party;
	}

	public String getUBLVersionID(){
		return UBLVersionID;
	}

	public String getUtilityStatementTypeCode(){
		return UtilityStatementTypeCode;
	}

	public String getUUID(){
		return UUID;
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
	public void setCopyIndicator(boolean newVal){
		CopyIndicator = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCustomer Party(Customer Party newVal){
		m_Customer Party = newVal;
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
	public void setMain On Account Payment(On Account Payment newVal){
		Main On Account Payment = newVal;
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
	public void setParent DocumentReference(DocumentReference newVal){
		Parent DocumentReference = newVal;
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
	public void setReceiver Party(Party newVal){
		Receiver Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSender Party(Party newVal){
		Sender Party = newVal;
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
	public void setSubscriber Consumption(Subscriber Consumption newVal){
		m_Subscriber Consumption = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSubscriber Party(Party newVal){
		Subscriber Party = newVal;
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
	public void setUtilityStatementTypeCode(String newVal){
		UtilityStatementTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setUUID(String newVal){
		UUID = newVal;
	}
}//end Utility Statement