

/**
 * A class to define a reference to a document.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:35 a. m.
 */
public class Document Reference {

	/**
	 * An indicator that the referenced document is a copy (true) or the original
	 * (false).
	 */
	private Indicator. Type CopyIndicator;
	/**
	 * Text describing the referenced document.
	 */
	private Text. Type DocumentDescription;
	/**
	 * A code signifying the status of the reference document with respect to its
	 * original state.
	 */
	private Document Status_ Code. Type DocumentStatusCode;
	/**
	 * The type of document being referenced, expressed as text.
	 */
	private Text. Type DocumentType;
	/**
	 * The type of document being referenced, expressed as a code.
	 */
	private Code. Type DocumentTypeCode;
	/**
	 * An identifier for the referenced document.
	 */
	private Identifier. Type ID;
	/**
	 * The date, assigned by the sender of the referenced document, on which the
	 * document was issued.
	 */
	private Date. Type IssueDate;
	/**
	 * The time, assigned by the sender of the referenced document, at which the
	 * document was issued.
	 */
	private Time. Type IssueTime;
	/**
	 * An identifier for the language used in the referenced document.
	 */
	private Identifier. Type LanguageID;
	/**
	 * A code signifying the locale in which the language in the referenced document
	 * is used.
	 */
	private Code. Type LocaleCode;
	/**
	 * A universally unique identifier for this document reference.
	 */
	private Identifier. Type UUID;
	/**
	 * An identifier for the current version of the referenced document.
	 */
	private Identifier. Type VersionID;
	/**
	 * A reference to another place in the same XML document instance in which
	 * DocumentReference appears.
	 */
	private Text. Type XPath;
	private Attachment m_Attachment;
	private Party Issuer Party;
	private Period Validity Period;
	private Result Of Verification m_Result Of Verification;

	public Document Reference(){

	}

	public void finalize() throws Throwable {

	}
	public Attachment getAttachment(){
		return m_Attachment;
	}

	public Indicator. Type getCopyIndicator(){
		return CopyIndicator;
	}

	public Text. Type getDocumentDescription(){
		return DocumentDescription;
	}

	public Document Status_ Code. Type getDocumentStatusCode(){
		return DocumentStatusCode;
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

	public Party getIssuer Party(){
		return Issuer Party;
	}

	public Time. Type getIssueTime(){
		return IssueTime;
	}

	public Identifier. Type getLanguageID(){
		return LanguageID;
	}

	public Code. Type getLocaleCode(){
		return LocaleCode;
	}

	public Result Of Verification getResult Of Verification(){
		return m_Result Of Verification;
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

	public Text. Type getXPath(){
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
	public void setCopyIndicator(Indicator. Type newVal){
		CopyIndicator = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDocumentDescription(Text. Type newVal){
		DocumentDescription = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDocumentStatusCode(Document Status_ Code. Type newVal){
		DocumentStatusCode = newVal;
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
	public void setIssuer Party(Party newVal){
		Issuer Party = newVal;
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
	public void setLanguageID(Identifier. Type newVal){
		LanguageID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLocaleCode(Code. Type newVal){
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

	/**
	 * 
	 * @param newVal
	 */
	public void setXPath(Text. Type newVal){
		XPath = newVal;
	}
}//end Document Reference