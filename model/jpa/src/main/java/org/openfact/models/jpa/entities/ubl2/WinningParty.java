

/**
 * A party that is identified as the awarded by a tender result.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:59 a. m.
 */
public class WinningParty {

	/**
	 * Indicates the rank obtained in the award.
	 */
	private Text. Type Rank;
	private Party m_Party;

	public Winning Party(){

	}

	public void finalize() throws Throwable {

	}
	public Party getParty(){
		return m_Party;
	}

	public Text. Type getRank(){
		return Rank;
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
	public void setRank(Text. Type newVal){
		Rank = newVal;
	}
}//end Winning Party