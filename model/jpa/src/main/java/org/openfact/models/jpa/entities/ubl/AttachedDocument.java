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
	private String CustomizationID;
	/**
	 * Text specifying the type of document.
	 */
	private String DocumentType;
	/**
	 * A code signifying the type of document.
	 */
	private String DocumentTypeCode;
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
	 * The Identifier of the parent document.
	 */
	private String ParentDocumentID;
	/**
	 * A code signifying the type of parent document.
	 */
	private String ParentDocumentTypeCode;
	/**
	 * Indicates the current version of the referred document.
	 */
	private String ParentDocumentVersionID;
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
	 * A universally unique identifier for an instance of this document.
	 */
	private String UUID;
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

	public String getCustomizationID(){
		return CustomizationID;
	}

	public String getDocumentType(){
		return DocumentType;
	}

	public String getDocumentTypeCode(){
		return DocumentTypeCode;
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

	public String getNote(){
		return Note;
	}

	public Line Reference getParent Document Line Reference(){
		return Parent Document Line Reference;
	}

	public String getParentDocumentID(){
		return ParentDocumentID;
	}

	public String getParentDocumentTypeCode(){
		return ParentDocumentTypeCode;
	}

	public String getParentDocumentVersionID(){
		return ParentDocumentVersionID;
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
	public void setAttachment(Attachment newVal){
		m_Attachment = newVal;
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
	public void setDocumentType(String newVal){
		DocumentType = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDocumentTypeCode(String newVal){
		DocumentTypeCode = newVal;
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
	public void setNote(String newVal){
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
	public void setParentDocumentID(String newVal){
		ParentDocumentID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setParentDocumentTypeCode(String newVal){
		ParentDocumentTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setParentDocumentVersionID(String newVal){
		ParentDocumentVersionID = newVal;
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
}//end Attached Document