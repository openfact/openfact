package org.openfact.models.jpa.entities.ubl;


/**
 * A class to define a line in a Request for Quotation.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:17:28 a. m.
 */
public class RequestForQuotationLine {

	/**
	 * An identifier for this line in the request for quotation.
	 */
	private Identifier. Type ID;
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private Text. Type Note;
	/**
	 * An indication whether this line is optional (true) or not (false) for purposes
	 * of this request for quotation.
	 */
	private Indicator. Type OptionalLineItemIndicator;
	/**
	 * A code signifying the level of confidentiality of this request for quotation
	 * line.
	 */
	private Code. Type PrivacyCode;
	/**
	 * A code signifying the security classification of this request for quotation
	 * line.
	 */
	private Code. Type SecurityClassificationCode;
	/**
	 * A universally unique identifier for this line in the request for quotation.
	 */
	private Identifier. Type UUID;
	private Document Reference m_Document Reference;
	private Line Item m_Line Item;

	public Request For Quotation Line(){

	}

	public void finalize() throws Throwable {

	}
	public Document Reference getDocument Reference(){
		return m_Document Reference;
	}

	public Identifier. Type getID(){
		return ID;
	}

	public Line Item getLine Item(){
		return m_Line Item;
	}

	public Text. Type getNote(){
		return Note;
	}

	public Indicator. Type getOptionalLineItemIndicator(){
		return OptionalLineItemIndicator;
	}

	public Code. Type getPrivacyCode(){
		return PrivacyCode;
	}

	public Code. Type getSecurityClassificationCode(){
		return SecurityClassificationCode;
	}

	public Identifier. Type getUUID(){
		return UUID;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDocument Reference(Document Reference newVal){
		m_Document Reference = newVal;
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
	public void setLine Item(Line Item newVal){
		m_Line Item = newVal;
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
	public void setOptionalLineItemIndicator(Indicator. Type newVal){
		OptionalLineItemIndicator = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPrivacyCode(Code. Type newVal){
		PrivacyCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSecurityClassificationCode(Code. Type newVal){
		SecurityClassificationCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setUUID(Identifier. Type newVal){
		UUID = newVal;
	}
}//end Request For Quotation Line