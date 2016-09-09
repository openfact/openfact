

/**
 * A class to define a reference to a line in a document.
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:15:57 a. m.
 */
public class Line Reference {

	/**
	 * Identifies the referenced line in the document.
	 */
	private Identifier. Type LineID;
	/**
	 * A code signifying the status of the referenced line with respect to its
	 * original state.
	 */
	private Line Status_ Code. Type LineStatusCode;
	/**
	 * A universally unique identifier for this line reference.
	 */
	private Identifier. Type UUID;
	private Document Reference m_Document Reference;

	public Line Reference(){

	}

	public void finalize() throws Throwable {

	}
	public Document Reference getDocument Reference(){
		return m_Document Reference;
	}

	public Identifier. Type getLineID(){
		return LineID;
	}

	public Line Status_ Code. Type getLineStatusCode(){
		return LineStatusCode;
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
	public void setLineID(Identifier. Type newVal){
		LineID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLineStatusCode(Line Status_ Code. Type newVal){
		LineStatusCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setUUID(Identifier. Type newVal){
		UUID = newVal;
	}
}//end Line Reference