

/**
 * A class to describe a financial institution.
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:15:14 a. m.
 */
public class FinancialInstitution {

	/**
	 * An identifier for this financial institution. It is recommended that the ISO
	 * 9362 Bank Identification Code (BIC) be used as the ID.
	 */
	private Identifier. Type ID;
	/**
	 * The name of this financial institution.
	 */
	private Name. Type Name;
	private Address m_Address;

	public Financial Institution(){

	}

	public void finalize() throws Throwable {

	}
	public Address getAddress(){
		return m_Address;
	}

	public Identifier. Type getID(){
		return ID;
	}

	public Name. Type getName(){
		return Name;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAddress(Address newVal){
		m_Address = newVal;
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
	public void setName(Name. Type newVal){
		Name = newVal;
	}
}//end Financial Institution