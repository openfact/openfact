

/**
 * A class to describe a party contracting to provide services, such as
 * transportation, finance, etc.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:41 a. m.
 */
public class Service Provider Party {

	/**
	 * An identifier for this service provider.
	 */
	private Identifier. Type ID;
	/**
	 * The type of service provided, expressed as text.
	 */
	private Text. Type ServiceType;
	/**
	 * The type of service provided, expressed as a code.
	 */
	private Code. Type ServiceTypeCode;
	private Contact Seller Contact;
	private Party m_Party;

	public Service Provider Party(){

	}

	public void finalize() throws Throwable {

	}
	public Identifier. Type getID(){
		return ID;
	}

	public Party getParty(){
		return m_Party;
	}

	public Contact getSeller Contact(){
		return Seller Contact;
	}

	public Text. Type getServiceType(){
		return ServiceType;
	}

	public Code. Type getServiceTypeCode(){
		return ServiceTypeCode;
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
	public void setParty(Party newVal){
		m_Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSeller Contact(Contact newVal){
		Seller Contact = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setServiceType(Text. Type newVal){
		ServiceType = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setServiceTypeCode(Code. Type newVal){
		ServiceTypeCode = newVal;
	}
}//end Service Provider Party