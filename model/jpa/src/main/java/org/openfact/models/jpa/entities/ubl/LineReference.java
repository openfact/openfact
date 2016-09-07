package org.openfact.models.jpa.entities.ubl;


/**
 * A class to define a reference to a line in a document.
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:15:57 a. m.
 */
public class LineReference {

	/**
	 * Identifies the referenced line in the document.
	 */
	private String lineID;
	/**
	 * A code signifying the status of the referenced line with respect to its
	 * original state.
	 */
	private String lineStatusCode;
	/**
	 * A universally unique identifier for this line reference.
	 */
	private String UUID;
	private DocumentReference m_DocumentReference;

	public LineReference(){

	}

	public void finalize() throws Throwable {

	}

	public String getLineID() {
		return lineID;
	}

	public void setLineID(String lineID) {
		this.lineID = lineID;
	}

	public String getLineStatusCode() {
		return lineStatusCode;
	}

	public void setLineStatusCode(String lineStatusCode) {
		this.lineStatusCode = lineStatusCode;
	}

	public String getUUID() {
		return UUID;
	}

	public void setUUID(String UUID) {
		this.UUID = UUID;
	}

	public DocumentReference getM_DocumentReference() {
		return m_DocumentReference;
	}

	public void setM_DocumentReference(DocumentReference m_DocumentReference) {
		this.m_DocumentReference = m_DocumentReference;
	}
}//end LineReference