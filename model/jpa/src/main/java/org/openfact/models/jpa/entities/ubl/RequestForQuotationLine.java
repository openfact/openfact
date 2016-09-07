package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to define a line in a Request for Quotation.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:17:28 a. m.
 */
public class RequestForQuotationLine {

	/**
	 * An identifier for this line in the request for quotation.
	 */
	private String ID;
	/**
	 * Free-form text conveying information that is not contained explicitly in
	 * other structures.
	 */
	private String Note;
	/**
	 * An indication whether this line is optional (true) or not (false) for
	 * purposes of this request for quotation.
	 */
	private boolean OptionalLineItemIndicator;
	/**
	 * A code signifying the level of confidentiality of this request for
	 * quotation line.
	 */
	private String PrivacyCode;
	/**
	 * A code signifying the security classification of this request for
	 * quotation line.
	 */
	private String SecurityClassificationCode;
	/**
	 * A universally unique identifier for this line in the request for
	 * quotation.
	 */
	private String UUID;
	private DocumentReference m_DocumentReference;
	private LineItem m_LineItem;

	public RequestForQuotationLine() {

	}

	public void finalize() throws Throwable {

	}

	public DocumentReference getDocumentReference() {
		return m_DocumentReference;
	}

	public String getID() {
		return ID;
	}

	public LineItem getLineItem() {
		return m_LineItem;
	}

	public String getNote() {
		return Note;
	}

	public boolean getOptionalLineItemIndicator() {
		return OptionalLineItemIndicator;
	}

	public String getPrivacyCode() {
		return PrivacyCode;
	}

	public String getSecurityClassificationCode() {
		return SecurityClassificationCode;
	}

	public String getUUID() {
		return UUID;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDocumentReference(DocumentReference newVal) {
		m_DocumentReference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setID(String newVal) {
		ID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLineItem(LineItem newVal) {
		m_LineItem = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNote(String newVal) {
		Note = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setOptionalLineItemIndicator(boolean newVal) {
		OptionalLineItemIndicator = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPrivacyCode(String newVal) {
		PrivacyCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSecurityClassificationCode(String newVal) {
		SecurityClassificationCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setUUID(String newVal) {
		UUID = newVal;
	}
}// end Request For Quotation Line