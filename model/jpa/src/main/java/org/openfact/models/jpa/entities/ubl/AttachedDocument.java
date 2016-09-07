package org.openfact.models.jpa.entities.ubl;


/**
 * A wrapper that allows a document of any kind to be packaged with the UBL
 * document that references it.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:19:08 a. m.
 */
public class AttachedDocument {

	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private Identifier. Type CustomizationID;
	/**
	 * Text specifying the type of document.
	 */
	private Text. Type DocumentType;
	/**
	 * A code signifying the type of document.
	 */
	private Code. Type DocumentTypeCode;
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
	 * The Identifier of the parent document.
	 */
	private Identifier. Type ParentDocumentID;
	/**
	 * A code signifying the type of parent document.
	 */
	private Code. Type ParentDocumentTypeCode;
	/**
	 * Indicates the current version of the referred document.
	 */
	private Identifier. Type ParentDocumentVersionID;
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
	private Attachment m_Attachment;
	private Line Reference Parent Document Line Reference;
	private Party Receiver Party;
	private Party Sender Party;
	private Signature m_Signature;

	public Attached Document(){

	}

	public void finalize() throws Throwable {

	}
	public Attachment getAttachment(){
		return m_Attachment;
	}

	public Identifier. Type getCustomizationID(){
		return CustomizationID;
	}

	public Text. Type getDocumentType(){
		return DocumentType;
	}

	public Code. Type getDocumentTypeCode(){
		return DocumentTypeCode;
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

	public Text. Type getNote(){
		return Note;
	}

	public Line Reference getParent Document Line Reference(){
		return Parent Document Line Reference;
	}

	public Identifier. Type getParentDocumentID(){
		return ParentDocumentID;
	}

	public Code. Type getParentDocumentTypeCode(){
		return ParentDocumentTypeCode;
	}

	public Identifier. Type getParentDocumentVersionID(){
		return ParentDocumentVersionID;
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
	public void setAttachment(Attachment newVal){
		m_Attachment = newVal;
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
	public void setDocumentType(Text. Type newVal){
		DocumentType = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDocumentTypeCode(Code. Type newVal){
		DocumentTypeCode = newVal;
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
	public void setNote(Text. Type newVal){
		Note = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setParent Document Line Reference(Line Reference newVal){
		Parent Document Line Reference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setParentDocumentID(Identifier. Type newVal){
		ParentDocumentID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setParentDocumentTypeCode(Code. Type newVal){
		ParentDocumentTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setParentDocumentVersionID(Identifier. Type newVal){
		ParentDocumentVersionID = newVal;
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
}//end Attached Document