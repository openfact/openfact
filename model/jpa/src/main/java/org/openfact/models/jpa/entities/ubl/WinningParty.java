package org.openfact.models.jpa.entities.ubl;

import org.openfact.models.jpa.entities.ubl2.Winning;

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
	private String Rank;
	private Party m_Party;

	public Winning Party(){

	}

	public void finalize() throws Throwable {

	}
	public Party getParty(){
		return m_Party;
	}

	public String getRank(){
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
	public void setRank(String newVal){
		Rank = newVal;
	}
}//end Winning Party