package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;

/**
 * A class to describe a shareholder party.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:42 a. m.
 */
public class ShareholderParty {

    /**
     * The shareholder participation, expressed as a percentage.
     */
    private BigDecimal PartecipationPercent;
    private List<Party> parties = new ArrayList<>();

    /**
     * @return the partecipationPercent
     */
    public BigDecimal getPartecipationPercent() {
        return PartecipationPercent;
    }

    /**
     * @param partecipationPercent
     *            the partecipationPercent to set
     */
    public void setPartecipationPercent(BigDecimal partecipationPercent) {
        PartecipationPercent = partecipationPercent;
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

}// end Shareholder Party