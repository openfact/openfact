

/**
 * A document used to cancel an entire Catalogue.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:19:19 a. m.
 */
public class CatalogueDeletion {

	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private Identifier. Type CustomizationID;
	/**
	 * Textual description of the document instance.
	 */
	private Text. Type Description;
	/**
	 * The effective date, assigned by the seller, on which the Catalogue expires.
	 */
	private Date. Type EffectiveDate;
	/**
	 * The effective time, assigned by the seller, at which the Catalogue expires.
	 */
	private Time. Type EffectiveTime;
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
	 * Text, assigned by the sender, that identifies this document to business users.
	 */
	private Name. Type Name;
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
	 * A universally unique identifier for an instance of this document.
	 */
	private Identifier. Type UUID;
	/**
	 * Identifies the current version of the Catalogue.
	 */
	private Identifier. Type VersionID;
	private Catalogue Reference Deleted Catalogue Reference;
	private Contract Referenced Contract;
	private Customer Party Contractor Customer Party;
	private Party Receiver Party;
	private Party Provider Party;
	private Period Validity Period;
	private Signature m_Signature;
	private Supplier Party Seller Supplier Party;

	public Catalogue Deletion(){

	}

	public void finalize() throws Throwable {

	}
	public Customer Party getContractor Customer Party(){
		return Contractor Customer Party;
	}

	public Identifier. Type getCustomizationID(){
		return CustomizationID;
	}

	public Catalogue Reference getDeleted Catalogue Reference(){
		return Deleted Catalogue Reference;
	}

	public Text. Type getDescription(){
		return Description;
	}

	public Date. Type getEffectiveDate(){
		return EffectiveDate;
	}

	public Time. Type getEffectiveTime(){
		return EffectiveTime;
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

	public Name. Type getName(){
		return Name;
	}

	public Text. Type getNote(){
		return Note;
	}

	public Identifier. Type getProfileExecutionID(){
		return ProfileExecutionID;
	}

	public Identifier. Type getProfileID(){
		return ProfileID;
	}

	public Party getProvider Party(){
		return Provider Party;
	}

	public Party getReceiver Party(){
		return Receiver Party;
	}

	public Contract getReferenced Contract(){
		return Referenced Contract;
	}

	public Supplier Party getSeller Supplier Party(){
		return Seller Supplier Party;
	}

	public Signature getSignature(){
		return m_Signature;
	}

	public Identifier. Type getUBLVersionID(){
		return UBLVersionID;
	}

	public Identifier. Type getUUID(){
		return UUID;
	}

	public Period getValidity Period(){
		return Validity Period;
	}

	public Identifier. Type getVersionID(){
		return VersionID;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setContractor Customer Party(Customer Party newVal){
		Contractor Customer Party = newVal;
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
	public void setDeleted Catalogue Reference(Catalogue Reference newVal){
		Deleted Catalogue Reference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDescription(Text. Type newVal){
		Description = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setEffectiveDate(Date. Type newVal){
		EffectiveDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setEffectiveTime(Time. Type newVal){
		EffectiveTime = newVal;
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
	public void setName(Name. Type newVal){
		Name = newVal;
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
	public void setProvider Party(Party newVal){
		Provider Party = newVal;
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
	public void setReferenced Contract(Contract newVal){
		Referenced Contract = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSeller Supplier Party(Supplier Party newVal){
		Seller Supplier Party = newVal;
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
	public void setUBLVersionID(Identifier. Type newVal){
		UBLVersionID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setUUID(Identifier. Type newVal){
		UUID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setValidity Period(Period newVal){
		Validity Period = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setVersionID(Identifier. Type newVal){
		VersionID = newVal;
	}
}//end Catalogue Deletion