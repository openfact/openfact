package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A class to describe an external object, such as a document stored at a remote
 * location.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:10 a. m.
 */
public class ExternalReference {

	/**
	 * A code signifying the character set of an external document.
	 */
	private String characterSetCode;
	/**
	 * Text describing the external object.
	 */
	private String description;
	/**
	 * A hash value for the externally stored object.
	 */
	private String documentHash;
	/**
	 * A code signifying the encoding/decoding algorithm used with the external
	 * object.
	 */
	private String encodingCode;
	/**
	 * The date on which availability of the resource can no longer be relied
	 * upon.
	 */
	private LocalDate expiryDate;
	/**
	 * The time after which availability of the resource can no longer be relied
	 * upon.
	 */
	private LocalTime expiryTime;
	/**
	 * The file name of the external object.
	 */
	private String fileName;
	/**
	 * A code signifying the format of the external object.
	 */
	private String formatCode;
	/**
	 * A hash algorithm used to calculate the hash value of the externally
	 * stored object.
	 */
	private String hashAlgorithmMethod;
	/**
	 * A code signifying the mime type of the external object.
	 */
	private String mimeCode;

	public String getURIID() {
		return URIID;
	}

	public void setURIID(String URIID) {
		this.URIID = URIID;
	}

	public String getCharacterSetCode() {
		return characterSetCode;
	}

	public void setCharacterSetCode(String characterSetCode) {
		this.characterSetCode = characterSetCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDocumentHash() {
		return documentHash;
	}

	public void setDocumentHash(String documentHash) {
		this.documentHash = documentHash;
	}

	public String getEncodingCode() {
		return encodingCode;
	}

	public void setEncodingCode(String encodingCode) {
		this.encodingCode = encodingCode;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public LocalTime getExpiryTime() {
		return expiryTime;
	}

	public void setExpiryTime(LocalTime expiryTime) {
		this.expiryTime = expiryTime;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFormatCode() {
		return formatCode;
	}

	public void setFormatCode(String formatCode) {
		this.formatCode = formatCode;
	}

	public String getHashAlgorithmMethod() {
		return hashAlgorithmMethod;
	}

	public void setHashAlgorithmMethod(String hashAlgorithmMethod) {
		this.hashAlgorithmMethod = hashAlgorithmMethod;
	}

	public String getMimeCode() {
		return mimeCode;
	}

	public void setMimeCode(String mimeCode) {
		this.mimeCode = mimeCode;
	}

	/**
	 * The Uniform Resource Identifier (URI) that identifies the external object
	 * as an Internet resource.
	 */

	private String URIID;

}// end External Reference