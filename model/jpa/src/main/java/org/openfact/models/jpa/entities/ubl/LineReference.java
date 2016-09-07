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
	private String LineID;
	/**
	 * A code signifying the status of the referenced line with respect to its
	 * original state.
	 */
	private Line Status_ String LineStatusCode;
	/**
	 * A universally unique identifier for this line reference.
	 */
	private String UUID;
	private Document Reference m_Document Reference;

	public Line Reference(){

	}

	public void finalize() throws Throwable {

	}
	public Document Reference getDocument Reference(){
		return m_Document Reference;
	}

	public String getLineID(){
		return LineID;
	}

	public Line Status_ String getLineStatusCode(){
		return LineStatusCode;
	}

	public String getUUID(){
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
	public void setLineID(String newVal){
		LineID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLineStatusCode(Line Status_ String newVal){
		LineStatusCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setUUID(String newVal){
		UUID = newVal;
	}
}//end Line Reference