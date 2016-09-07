

/**
 * A class to describe a scheme for corporate registration.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:09 a. m.
 */
public class Corporate Registration Scheme {

	/**
	 * A code signifying the type of this registration scheme.
	 */
	private Code. Type CorporateRegistrationTypeCode;
	/**
	 * An identifier for this registration scheme.
	 */
	private Identifier. Type ID;
	/**
	 * The name of this registration scheme.
	 */
	private Name. Type Name;
	private Address Jurisdiction Region Address;

	public Corporate Registration Scheme(){

	}

	public void finalize() throws Throwable {

	}
	public Code. Type getCorporateRegistrationTypeCode(){
		return CorporateRegistrationTypeCode;
	}

	public Identifier. Type getID(){
		return ID;
	}

	public Address getJurisdiction Region Address(){
		return Jurisdiction Region Address;
	}

	public Name. Type getName(){
		return Name;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCorporateRegistrationTypeCode(Code. Type newVal){
		CorporateRegistrationTypeCode = newVal;
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
	public void setJurisdiction Region Address(Address newVal){
		Jurisdiction Region Address = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setName(Name. Type newVal){
		Name = newVal;
	}
}//end Corporate Registration Scheme