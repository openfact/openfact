

/**
 * A class to describe an external object, such as a document stored at a remote
 * location.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:10 a. m.
 */
public class ExternalReference {

	/**
	 * A code signifying the character set of an external document.
	 */
	private Code. Type CharacterSetCode;
	/**
	 * Text describing the external object.
	 */
	private Text. Type Description;
	/**
	 * A hash value for the externally stored object.
	 */
	private Text. Type DocumentHash;
	/**
	 * A code signifying the encoding/decoding algorithm used with the external object.
	 */
	private Code. Type EncodingCode;
	/**
	 * The date on which availability of the resource can no longer be relied upon.
	 */
	private Date. Type ExpiryDate;
	/**
	 * The time after which availability of the resource can no longer be relied upon.
	 */
	private Time. Type ExpiryTime;
	/**
	 * The file name of the external object.
	 */
	private Name. Type FileName;
	/**
	 * A code signifying the format of the external object.
	 */
	private Code. Type FormatCode;
	/**
	 * A hash algorithm used to calculate the hash value of the externally stored
	 * object.
	 */
	private Text. Type HashAlgorithmMethod;
	/**
	 * A code signifying the mime type of the external object.
	 */
	private Code. Type MimeCode;
	/**
	 * The Uniform Resource Identifier (URI) that identifies the external object as an
	 * Internet resource.
	 */
	private Identifier. Type URIID;

	public External Reference(){

	}

	public void finalize() throws Throwable {

	}
	public Code. Type getCharacterSetCode(){
		return CharacterSetCode;
	}

	public Text. Type getDescription(){
		return Description;
	}

	public Text. Type getDocumentHash(){
		return DocumentHash;
	}

	public Code. Type getEncodingCode(){
		return EncodingCode;
	}

	public Date. Type getExpiryDate(){
		return ExpiryDate;
	}

	public Time. Type getExpiryTime(){
		return ExpiryTime;
	}

	public Name. Type getFileName(){
		return FileName;
	}

	public Code. Type getFormatCode(){
		return FormatCode;
	}

	public Text. Type getHashAlgorithmMethod(){
		return HashAlgorithmMethod;
	}

	public Code. Type getMimeCode(){
		return MimeCode;
	}

	public Identifier. Type getURIID(){
		return URIID;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCharacterSetCode(Code. Type newVal){
		CharacterSetCode = newVal;
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
	public void setDocumentHash(Text. Type newVal){
		DocumentHash = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setEncodingCode(Code. Type newVal){
		EncodingCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setExpiryDate(Date. Type newVal){
		ExpiryDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setExpiryTime(Time. Type newVal){
		ExpiryTime = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFileName(Name. Type newVal){
		FileName = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFormatCode(Code. Type newVal){
		FormatCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setHashAlgorithmMethod(Text. Type newVal){
		HashAlgorithmMethod = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMimeCode(Code. Type newVal){
		MimeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setURIID(Identifier. Type newVal){
		URIID = newVal;
	}
}//end External Reference