package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;

/**
 * A class to describe the party endorsing a document.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:46 a. m.
 */
public class EndorserParty {

    /**
     * A code specifying the role of the party providing the endorsement (e.g.,
     * issuer, embassy, insurance, etc.).
     */
    private String RoleCode;
    /**
     * A number indicating the order of the endorsement provided by this party
     * in the sequence in which endorsements are to be applied.
     */
    private BigDecimal SequenceNumeric;
    private Contact signatoryContact;
    private Party m_Party;

    public String getRoleCode() {
        return RoleCode;
    }

    public void setRoleCode(String roleCode) {
        RoleCode = roleCode;
    }

    public BigDecimal getSequenceNumeric() {
        return SequenceNumeric;
    }

    public void setSequenceNumeric(BigDecimal sequenceNumeric) {
        SequenceNumeric = sequenceNumeric;
    }

    public Contact getSignatoryContact() {
        return signatoryContact;
    }

    public void setSignatoryContact(Contact signatoryContact) {
        this.signatoryContact = signatoryContact;
    }

    public Party getM_Party() {
        return m_Party;
    }

    public void setM_Party(Party m_Party) {
        this.m_Party = m_Party;
    }
}// end Endorser Party