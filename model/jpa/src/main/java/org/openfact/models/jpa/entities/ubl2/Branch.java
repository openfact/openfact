package org.openfact.models.jpa.entities.ubl2;


/**
 * A class to describe a branch or a division of an organization.
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:13:10 a. m.
 */
public class Branch {

	/**
	 * An identifier for this branch or division of an organization.
	 */
	private Identifier. Type ID;
	/**
	 * The name of this branch or division of an organization.
	 */
	private Name. Type Name;
	private Address m_Address;
	private Financial Institution m_Financial Institution;

	public Branch(){

	}

	public void finalize() throws Throwable {

	}
	public Address getAddress(){
		return m_Address;
	}

	public Financial Institution getFinancial Institution(){
		return m_Financial Institution;
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
	public void setFinancial Institution(Financial Institution newVal){
		m_Financial Institution = newVal;
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
}//end Branch