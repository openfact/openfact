package org.openfact.models.jpa.entities.ubl;


/**
 * A class to describe access to a web site.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:57 a. m.
 */
public class WebSiteAccess {

	/**
	 * Text describing login details.
	 */
	private String Login;
	/**
	 * A password to the web site.
	 */
	private String Password;
	/**
	 * The Uniform Resource Identifier (URI) for this web site; i.e., its Uniform
	 * Resource Locator (URL).
	 */
	private String URIID;

	public Web Site Access(){

	}

	public void finalize() throws Throwable {

	}
	public String getLogin(){
		return Login;
	}

	public String getPassword(){
		return Password;
	}

	public String getURIID(){
		return URIID;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLogin(String newVal){
		Login = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPassword(String newVal){
		Password = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setURIID(String newVal){
		URIID = newVal;
	}
}//end Web Site Access