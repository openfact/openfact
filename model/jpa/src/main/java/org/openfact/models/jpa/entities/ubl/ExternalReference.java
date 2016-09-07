package org.openfact.models.jpa.entities.ubl;

import java.time.LocalDate;
import java.time.LocalTime;

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
	private String CharacterSetCode;
	/**
	 * Text describing the external object.
	 */
	private String Description;
	/**
	 * A hash value for the externally stored object.
	 */
	private String DocumentHash;
	/**
	 * A code signifying the encoding/decoding algorithm used with the external object.
	 */
	private String EncodingCode;
	/**
	 * The date on which availability of the resource can no longer be relied upon.
	 */
	private LocalDate ExpiryDate;
	/**
	 * The time after which availability of the resource can no longer be relied upon.
	 */
	private LocalTime ExpiryTime;
	/**
	 * The file name of the external object.
	 */
	private String FileName;
	/**
	 * A code signifying the format of the external object.
	 */
	private String FormatCode;
	/**
	 * A hash algorithm used to calculate the hash value of the externally stored
	 * object.
	 */
	private String HashAlgorithmMethod;
	/**
	 * A code signifying the mime type of the external object.
	 */
	private String MimeCode;
	/**
	 * The Uniform Resource Identifier (URI) that identifies the external object as an
	 * Internet resource.
	 */
	private String URIID;

	public External Reference(){

	}

	public void finalize() throws Throwable {

	}
	public String getCharacterSetCode(){
		return CharacterSetCode;
	}

	public String getDescription(){
		return Description;
	}

	public String getDocumentHash(){
		return DocumentHash;
	}

	public String getEncodingCode(){
		return EncodingCode;
	}

	public LocalDate getExpiryDate(){
		return ExpiryDate;
	}

	public LocalTime getExpiryTime(){
		return ExpiryTime;
	}

	public String getFileName(){
		return FileName;
	}

	public String getFormatCode(){
		return FormatCode;
	}

	public String getHashAlgorithmMethod(){
		return HashAlgorithmMethod;
	}

	public String getMimeCode(){
		return MimeCode;
	}

	public String getURIID(){
		return URIID;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCharacterSetCode(String newVal){
		CharacterSetCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDescription(String newVal){
		Description = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDocumentHash(String newVal){
		DocumentHash = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setEncodingCode(String newVal){
		EncodingCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setExpiryDate(LocalDate newVal){
		ExpiryDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setExpiryTime(LocalTime newVal){
		ExpiryTime = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFileName(String newVal){
		FileName = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFormatCode(String newVal){
		FormatCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setHashAlgorithmMethod(String newVal){
		HashAlgorithmMethod = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMimeCode(String newVal){
		MimeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setURIID(String newVal){
		URIID = newVal;
	}
}//end External Reference