package org.openfact.representations.idm.ubl;

import java.util.List;

/**
 * A class to describe an organization, sub-organization, or individual
 * fulfilling a role in a business process.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:25 a. m.
 */
public class PartyRepresentation {

    private AddressRepresentation postalAddress;
    private List<PartyLegalEntityRepresentation> partyLegalEntities;
    private List<PartyNameRepresentation> partyNames;

    /**
     * @return the postalAddress
     */
    public AddressRepresentation getPostalAddress() {
        return postalAddress;
    }

    /**
     * @param postalAddress
     *            the postalAddress to set
     */
    public void setPostalAddress(AddressRepresentation postalAddress) {
        this.postalAddress = postalAddress;
    }

    /**
     * @return the partyLegalEntities
     */
    public List<PartyLegalEntityRepresentation> getPartyLegalEntities() {
        return partyLegalEntities;
    }

    /**
     * @param partyLegalEntities
     *            the partyLegalEntities to set
     */
    public void setPartyLegalEntities(List<PartyLegalEntityRepresentation> partyLegalEntities) {
        this.partyLegalEntities = partyLegalEntities;
    }

    /**
     * @return the partyNames
     */
    public List<PartyNameRepresentation> getPartyNames() {
        return partyNames;
    }

    /**
     * @param partyNames
     *            the partyNames to set
     */
    public void setPartyNames(List<PartyNameRepresentation> partyNames) {
        this.partyNames = partyNames;
    }

}
