

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
	private Text. Type AccountingCost;
	/**
	 * The buyer's accounting cost code, applied to the UtilityStatement.
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
	 * Free-form text pertinent to this document, conveying information that is not
	 * contained explicitly in other structures.
	 */
	private Text. Type Note;
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
	 * Identifies the earliest version of the UBL 2 schema for this document type that
	 * defines all of the elements that might be encountered in the current instance.
	 */
	private Identifier. Type UBLVersionID;
	/**
	 * A code signifying the type of Utility Statement.
	 */
	private Code. Type UtilityStatementTypeCode;
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private Identifier. Type UUID;
	private Customer Party m_Customer Party;
	private Document Reference Parent Document Reference;
	private Document Reference Additional Document Reference;
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
	public Text. Type getAccountingCost(){
		return AccountingCost;
	}

	public Code. Type getAccountingCostCode(){
		return AccountingCostCode;
	}

	public Document Reference getAdditional Document Reference(){
		return Additional Document Reference;
	}

	public Indicator. Type getCopyIndicator(){
		return CopyIndicator;
	}

	public Customer Party getCustomer Party(){
		return m_Customer Party;
	}

	public Identifier. Type getCustomizationID(){
		return CustomizationID;
	}

	public Currency_ Code. Type getDocumentCurrencyCode(){
		return DocumentCurrencyCode;
	}

	public Identifier. Type getID(){
		return ID;
	}

	public Date. Type getIssueDate(){
		return IssueDate;
	}

	public Time. Type getIssueTime(){
		return IssueTime;
	}

	public On Account Payment getMain On Account Payment(){
		return Main On Account Payment;
	}

	public Text. Type getNote(){
		return Note;
	}

	public Document Reference getParent Document Reference(){
		return Parent Document Reference;
	}

	public Identifier. Type getProfileExecutionID(){
		return ProfileExecutionID;
	}

	public Identifier. Type getProfileID(){
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

	public Identifier. Type getUBLVersionID(){
		return UBLVersionID;
	}

	public Code. Type getUtilityStatementTypeCode(){
		return UtilityStatementTypeCode;
	}

	public Identifier. Type getUUID(){
		return UUID;
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
	public void setCopyIndicator(Indicator. Type newVal){
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
	public void setCustomizationID(Identifier. Type newVal){
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
	public void setID(Identifier. Type newVal){
		ID = newVal;
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
	public void setMain On Account Payment(On Account Payment newVal){
		Main On Account Payment = newVal;
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
	public void setParent Document Reference(Document Reference newVal){
		Parent Document Reference = newVal;
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
	public void setUBLVersionID(Identifier. Type newVal){
		UBLVersionID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setUtilityStatementTypeCode(Code. Type newVal){
		UtilityStatementTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setUUID(Identifier. Type newVal){
		UUID = newVal;
	}
}//end Utility Statement