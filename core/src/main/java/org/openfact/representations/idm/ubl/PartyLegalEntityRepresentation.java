package org.openfact.representations.idm.ubl;

/**
 * A class to describe a party as a legal entity.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:28 a. m.
 */
public class PartyLegalEntityRepresentation {

    /**
     * The name of the party as registered with the relevant legal authority.
     */
    private String registrationName;

    /**
     * @return the registrationName
     */
    public String getRegistrationName() {
        return registrationName;
    }

    /**
     * @param registrationName
     *            the registrationName to set
     */
    public void setRegistrationName(String registrationName) {
        this.registrationName = registrationName;
    }

}
