package org.openfact.models.jpa.entities.ubl;

/**
 * A party that is identified as the awarded by a tender result.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:59 a. m.
 */
public class WinningParty {

    /**
     * Indicates the rank obtained in the award.
     */
    private String rank;
    private Party m_Party;

    public WinningParty() {

    }

    public void finalize() throws Throwable {

    }

    public Party getParty() {
        return m_Party;
    }

    public String getRank() {
        return rank;
    }

    /**
     * 
     * @param newVal
     */
    public void setParty(Party newVal) {
        m_Party = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setRank(String newVal) {
        rank = newVal;
    }
}// end WinningParty