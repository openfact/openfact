

/**
 * A document to notify the deposit of a bid bond guarantee.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:20:45 a. m.
 */
public class Guarantee Certificate {

	/**
	 * The code stating the constitution means of the guarantee.
	 */
	private Code. Type ConstitutionCode;
	/**
	 * An identifier, assigned by the sender, for the process file (i.e., record) to
	 * which this document belongs.
	 */
	private Identifier. Type ContractFolderID;
	/**
	 * Indicates whether this document is a copy (true) or not (false).
	 */
	private Indicator. Type CopyIndicator;
	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private Identifier. Type CustomizationID;
	/**
	 * A code signifying the type of the guarantee.
	 */
	private Code. Type GuaranteeTypeCode;
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
	 * The liability amount (a monetary value) in the bid bond guarantee.
	 */
	private Amount. Type LiabilityAmount;
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
	 * A textual description of the purpose of the bid bond guarantee.
	 */
	private Text. Type Purpose;
	/**
	 * Identifies the earliest version of the UBL 2 schema for this document type that
	 * defines all of the elements that might be encountered in the current instance.
	 */
	private Identifier. Type UBLVersionID;
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private Identifier. Type UUID;
	private Document Reference Guarantee Document Reference;
	private Immobilized Security m_Immobilized Security;
	private Party Interested Party;
	private Party Guarantor Party;
	private Party Beneficiary Party;
	private Period Applicable Period;
	private Regulation Applicable Regulation;
	private Signature m_Signature;

	public Guarantee Certificate(){

	}

	public void finalize() throws Throwable {

	}
	public Period getApplicable Period(){
		return Applicable Period;
	}

	public Regulation getApplicable Regulation(){
		return Applicable Regulation;
	}

	public Party getBeneficiary Party(){
		return Beneficiary Party;
	}

	public Code. Type getConstitutionCode(){
		return ConstitutionCode;
	}

	public Identifier. Type getContractFolderID(){
		return ContractFolderID;
	}

	public Indicator. Type getCopyIndicator(){
		return CopyIndicator;
	}

	public Identifier. Type getCustomizationID(){
		return CustomizationID;
	}

	public Document Reference getGuarantee Document Reference(){
		return Guarantee Document Reference;
	}

	public Code. Type getGuaranteeTypeCode(){
		return GuaranteeTypeCode;
	}

	public Party getGuarantor Party(){
		return Guarantor Party;
	}

	public Identifier. Type getID(){
		return ID;
	}

	public Immobilized Security getImmobilized Security(){
		return m_Immobilized Security;
	}

	public Party getInterested Party(){
		return Interested Party;
	}

	public Date. Type getIssueDate(){
		return IssueDate;
	}

	public Time. Type getIssueTime(){
		return IssueTime;
	}

	public Amount. Type getLiabilityAmount(){
		return LiabilityAmount;
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

	public Text. Type getPurpose(){
		return Purpose;
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

	/**
	 * 
	 * @param newVal
	 */
	public void setApplicable Period(Period newVal){
		Applicable Period = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setApplicable Regulation(Regulation newVal){
		Applicable Regulation = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setBeneficiary Party(Party newVal){
		Beneficiary Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setConstitutionCode(Code. Type newVal){
		ConstitutionCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setContractFolderID(Identifier. Type newVal){
		ContractFolderID = newVal;
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
	public void setCustomizationID(Identifier. Type newVal){
		CustomizationID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setGuarantee Document Reference(Document Reference newVal){
		Guarantee Document Reference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setGuaranteeTypeCode(Code. Type newVal){
		GuaranteeTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setGuarantor Party(Party newVal){
		Guarantor Party = newVal;
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
	public void setImmobilized Security(Immobilized Security newVal){
		m_Immobilized Security = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setInterested Party(Party newVal){
		Interested Party = newVal;
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
	public void setLiabilityAmount(Amount. Type newVal){
		LiabilityAmount = newVal;
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
	public void setPurpose(Text. Type newVal){
		Purpose = newVal;
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
}//end Guarantee Certificate