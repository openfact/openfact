package org.openfact.models.jpa.entities.ubl;


/**
 * A document to notify the deposit of a bid bond guarantee.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:20:45 a. m.
 */
public class GuaranteeCertificate {

	/**
	 * The code stating the constitution means of the guarantee.
	 */
	private String ConstitutionCode;
	/**
	 * An identifier, assigned by the sender, for the process file (i.e., record) to
	 * which this document belongs.
	 */
	private String ContractFolderID;
	/**
	 * Indicates whether this document is a copy (true) or not (false).
	 */
	private boolean CopyIndicator;
	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private String CustomizationID;
	/**
	 * A code signifying the type of the guarantee.
	 */
	private String GuaranteeTypeCode;
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
	 * The liability amount (a monetary value) in the bid bond guarantee.
	 */
	private BigDecimal LiabilityAmount;
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
	 * A textual description of the purpose of the bid bond guarantee.
	 */
	private String Purpose;
	/**
	 * Identifies the earliest version of the UBL 2 schema for this document type that
	 * defines all of the elements that might be encountered in the current instance.
	 */
	private String UBLVersionID;
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private String UUID;
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

	public String getConstitutionCode(){
		return ConstitutionCode;
	}

	public String getContractFolderID(){
		return ContractFolderID;
	}

	public boolean getCopyIndicator(){
		return CopyIndicator;
	}

	public String getCustomizationID(){
		return CustomizationID;
	}

	public Document Reference getGuarantee Document Reference(){
		return Guarantee Document Reference;
	}

	public String getGuaranteeTypeCode(){
		return GuaranteeTypeCode;
	}

	public Party getGuarantor Party(){
		return Guarantor Party;
	}

	public String getID(){
		return ID;
	}

	public Immobilized Security getImmobilized Security(){
		return m_Immobilized Security;
	}

	public Party getInterested Party(){
		return Interested Party;
	}

	public LocalDate getIssueDate(){
		return IssueDate;
	}

	public LocalTime getIssueTime(){
		return IssueTime;
	}

	public BigDecimal getLiabilityAmount(){
		return LiabilityAmount;
	}

	public String getNote(){
		return Note;
	}

	public String getProfileExecutionID(){
		return ProfileExecutionID;
	}

	public String getProfileID(){
		return ProfileID;
	}

	public String getPurpose(){
		return Purpose;
	}

	public Signature getSignature(){
		return m_Signature;
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
	public void setConstitutionCode(String newVal){
		ConstitutionCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setContractFolderID(String newVal){
		ContractFolderID = newVal;
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
	public void setGuarantee Document Reference(Document Reference newVal){
		Guarantee Document Reference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setGuaranteeTypeCode(String newVal){
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
	public void setID(String newVal){
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
	public void setLiabilityAmount(BigDecimal newVal){
		LiabilityAmount = newVal;
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
	public void setPurpose(String newVal){
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
}//end Guarantee Certificate