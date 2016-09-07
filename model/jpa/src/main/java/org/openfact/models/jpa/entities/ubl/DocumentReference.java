package org.openfact.models.jpa.entities.ubl;


/**
 * A class to define a reference to a document.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:35 a. m.
 */
public class DocumentReference {

	/**
	 * An indicator that the referenced document is a copy (true) or the original
	 * (false).
	 */
	private boolean CopyIndicator;
	/**
	 * Text describing the referenced document.
	 */
	private String DocumentDescription;
	/**
	 * A code signifying the status of the reference document with respect to its
	 * original state.
	 */
	private Document Status_ String DocumentStatusCode;
	/**
	 * The type of document being referenced, expressed as text.
	 */
	private String DocumentType;
	/**
	 * The type of document being referenced, expressed as a code.
	 */
	private String DocumentTypeCode;
	/**
	 * An identifier for the referenced document.
	 */
	private String ID;
	/**
	 * The date, assigned by the sender of the referenced document, on which the
	 * document was issued.
	 */
	private LocalDate IssueDate;
	/**
	 * The time, assigned by the sender of the referenced document, at which the
	 * document was issued.
	 */
	private LocalTime IssueTime;
	/**
	 * An identifier for the language used in the referenced document.
	 */
	private String LanguageID;
	/**
	 * A code signifying the locale in which the language in the referenced document
	 * is used.
	 */
	private String LocaleCode;
	/**
	 * A universally unique identifier for this document reference.
	 */
	private String UUID;
	/**
	 * An identifier for the current version of the referenced document.
	 */
	private String VersionID;
	/**
	 * A reference to another place in the same XML document instance in which
	 * DocumentReference appears.
	 */
	private String XPath;
	private Attachment m_Attachment;
	private Party Issuer Party;
	private Period Validity Period;
	private Result Of Verification m_Result Of Verification;

	public DocumentReference(){

	}

	public void finalize() throws Throwable {

	}
	public Attachment getAttachment(){
		return m_Attachment;
	}

	public boolean getCopyIndicator(){
		return CopyIndicator;
	}

	public String getDocumentDescription(){
		return DocumentDescription;
	}

	public Document Status_ String getDocumentStatusCode(){
		return DocumentStatusCode;
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

	public Party getIssuer Party(){
		return Issuer Party;
	}

	public LocalTime getIssueTime(){
		return IssueTime;
	}

	public String getLanguageID(){
		return LanguageID;
	}

	public String getLocaleCode(){
		return LocaleCode;
	}

	public Result Of Verification getResult Of Verification(){
		return m_Result Of Verification;
	}

	public String getUUID(){
		return UUID;
	}

	public Period getValidity Period(){
		return Validity Period;
	}

	public String getVersionID(){
		return VersionID;
	}

	public String getXPath(){
		return XPath;
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
	public void setCopyIndicator(boolean newVal){
		CopyIndicator = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDocumentDescription(String newVal){
		DocumentDescription = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDocumentStatusCode(Document Status_ String newVal){
		DocumentStatusCode = newVal;
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
	public void setIssuer Party(Party newVal){
		Issuer Party = newVal;
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
	public void setLanguageID(String newVal){
		LanguageID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLocaleCode(String newVal){
		LocaleCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setResult Of Verification(Result Of Verification newVal){
		m_Result Of Verification = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setUUID(String newVal){
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
	public void setVersionID(String newVal){
		VersionID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setXPath(String newVal){
		XPath = newVal;
	}
}//end DocumentReference