

/**
 * A class to describe one of the parts of a procurement project that is being
 * subdivided to allow the contracting party to award different lots to different
 * economic operators under different contracts.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:05 a. m.
 */
public class Procurement Project Lot {

	/**
	 * An identifier for this procurement project lot.
	 */
	private Identifier. Type ID;
	private Procurement Project m_Procurement Project;
	private Tendering Terms m_Tendering Terms;

	public Procurement Project Lot(){

	}

	public void finalize() throws Throwable {

	}
	public Identifier. Type getID(){
		return ID;
	}

	public Procurement Project getProcurement Project(){
		return m_Procurement Project;
	}

	public Tendering Terms getTendering Terms(){
		return m_Tendering Terms;
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
	public void setProcurement Project(Procurement Project newVal){
		m_Procurement Project = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTendering Terms(Tendering Terms newVal){
		m_Tendering Terms = newVal;
	}
}//end Procurement Project Lot