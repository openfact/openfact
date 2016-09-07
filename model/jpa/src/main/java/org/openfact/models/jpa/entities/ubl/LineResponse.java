package org.openfact.models.jpa.entities.ubl;


/**
 * A class to describe responses to a line in a document.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:58 a. m.
 */
public class LineResponse {

	private LineReference m_LineReference;
	private Response m_Response;

	public LineResponse(){

	}

	public void finalize() throws Throwable {

	}
	public LineReference getLineReference(){
		return m_LineReference;
	}

	public Response getResponse(){
		return m_Response;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLineReference(LineReference newVal){
		m_LineReference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setResponse(Response newVal){
		m_Response = newVal;
	}
}//end LineResponse