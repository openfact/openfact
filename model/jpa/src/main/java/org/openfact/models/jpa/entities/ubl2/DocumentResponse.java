

/**
 * A class to describe an application-level response to a document.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:37 a. m.
 */
public class DocumentResponse {

	private Document Reference m_Document Reference;
	private Line Response m_Line Response;
	private Party Recipient Party;
	private Party Issuer Party;
	private Response m_Response;

	public Document Response(){

	}

	public void finalize() throws Throwable {

	}
	public Document Reference getDocument Reference(){
		return m_Document Reference;
	}

	public Party getIssuer Party(){
		return Issuer Party;
	}

	public Line Response getLine Response(){
		return m_Line Response;
	}

	public Party getRecipient Party(){
		return Recipient Party;
	}

	public Response getResponse(){
		return m_Response;
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
	public void setIssuer Party(Party newVal){
		Issuer Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLine Response(Line Response newVal){
		m_Line Response = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRecipient Party(Party newVal){
		Recipient Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setResponse(Response newVal){
		m_Response = newVal;
	}
}//end Document Response