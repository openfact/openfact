package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

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
    private List<Party> parties = new ArrayList<>();

    /**
     * @return the rank
     */
    public String getRank() {
        return rank;
    }

    /**
     * @param rank
     *            the rank to set
     */
    public void setRank(String rank) {
        this.rank = rank;
    }

    /**
     * @return the parties
     */
    public List<Party> getParties() {
        return parties;
    }

    /**
     * @param parties
     *            the parties to set
     */
    public void setParties(List<Party> parties) {
        this.parties = parties;
    }

}