package org.openfact.models.jpa.entities.ubl2;


/**
 * A class to describe an attached document. An attachment can refer to an
 * external document or be included with the document being exchanged.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:12:47 a. m.
 */
public class Attachment {

	/**
	 * A binary large object containing an attached document.
	 */
	private Binary Object. Type EmbeddedDocumentBinaryObject;
	private External Reference m_External Reference;

	public Attachment(){

	}

	public void finalize() throws Throwable {

	}
	public Binary Object. Type getEmbeddedDocumentBinaryObject(){
		return EmbeddedDocumentBinaryObject;
	}

	public External Reference getExternal Reference(){
		return m_External Reference;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setEmbeddedDocumentBinaryObject(Binary Object. Type newVal){
		EmbeddedDocumentBinaryObject = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setExternal Reference(External Reference newVal){
		m_External Reference = newVal;
	}
}//end Attachment