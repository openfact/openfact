package org.openfact.models.jpa.entities.ubl;

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
    private Party m_Party;

    public ShareholderParty() {

    }

    public void finalize() throws Throwable {

    }

    public BigDecimal getPartecipationPercent() {
        return PartecipationPercent;
    }

    public Party getParty() {
        return m_Party;
    }

    /**
     * 
     * @param newVal
     */
    public void setPartecipationPercent(BigDecimal newVal) {
        PartecipationPercent = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setParty(Party newVal) {
        m_Party = newVal;
    }
}// end Shareholder Party