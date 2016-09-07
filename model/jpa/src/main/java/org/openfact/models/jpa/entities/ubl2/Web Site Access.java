

/**
 * A class to describe access to a web site.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:57 a. m.
 */
public class Web Site Access {

	/**
	 * Text describing login details.
	 */
	private Text. Type Login;
	/**
	 * A password to the web site.
	 */
	private Text. Type Password;
	/**
	 * The Uniform Resource Identifier (URI) for this web site; i.e., its Uniform
	 * Resource Locator (URL).
	 */
	private Identifier. Type URIID;

	public Web Site Access(){

	}

	public void finalize() throws Throwable {

	}
	public Text. Type getLogin(){
		return Login;
	}

	public Text. Type getPassword(){
		return Password;
	}

	public Identifier. Type getURIID(){
		return URIID;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLogin(Text. Type newVal){
		Login = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPassword(Text. Type newVal){
		Password = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setURIID(Identifier. Type newVal){
		URIID = newVal;
	}
}//end Web Site Access