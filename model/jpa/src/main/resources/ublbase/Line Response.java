

/**
 * A class to describe responses to a line in a document.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:58 a. m.
 */
public class Line Response {

	private Line Reference m_Line Reference;
	private Response m_Response;

	public Line Response(){

	}

	public void finalize() throws Throwable {

	}
	public Line Reference getLine Reference(){
		return m_Line Reference;
	}

	public Response getResponse(){
		return m_Response;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLine Reference(Line Reference newVal){
		m_Line Reference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setResponse(Response newVal){
		m_Response = newVal;
	}
}//end Line Response