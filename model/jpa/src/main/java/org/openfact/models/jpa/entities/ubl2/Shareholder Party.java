

/**
 * A class to describe a shareholder party.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:42 a. m.
 */
public class Shareholder Party {

	/**
	 * The shareholder participation, expressed as a percentage.
	 */
	private Percent. Type PartecipationPercent;
	private Party m_Party;

	public Shareholder Party(){

	}

	public void finalize() throws Throwable {

	}
	public Percent. Type getPartecipationPercent(){
		return PartecipationPercent;
	}

	public Party getParty(){
		return m_Party;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPartecipationPercent(Percent. Type newVal){
		PartecipationPercent = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setParty(Party newVal){
		m_Party = newVal;
	}
}//end Shareholder Party