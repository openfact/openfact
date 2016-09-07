

/**
 * A class to describe an individual, a group, or a body having a procurement role
 * in a tendering process.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:06 a. m.
 */
public class ContractingParty {

	/**
	 * The buyer profile is typically located on a web site where the contracting
	 * party publishes its procurement opportunities
	 */
	private Identifier. Type BuyerProfileURIID;
	private Contracting Activity m_Contracting Activity;
	private Contracting Party Type m_Contracting Party Type;
	private Party m_Party;

	public Contracting Party(){

	}

	public void finalize() throws Throwable {

	}
	public Identifier. Type getBuyerProfileURIID(){
		return BuyerProfileURIID;
	}

	public Contracting Activity getContracting Activity(){
		return m_Contracting Activity;
	}

	public Contracting Party Type getContracting Party Type(){
		return m_Contracting Party Type;
	}

	public Party getParty(){
		return m_Party;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setBuyerProfileURIID(Identifier. Type newVal){
		BuyerProfileURIID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setContracting Activity(Contracting Activity newVal){
		m_Contracting Activity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setContracting Party Type(Contracting Party Type newVal){
		m_Contracting Party Type = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setParty(Party newVal){
		m_Party = newVal;
	}
}//end Contracting Party