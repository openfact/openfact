package org.openfact.models.jpa.entities.ubl;

/**
 * A class for describing the terms of a trade agreement.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:33 a. m.
 */
public class TradingTerms {

    /**
     * Text describing the terms of a trade agreement.
     */
    private String Information;
    /**
     * A reference quoting the basis of the terms
     */
    private String Reference;
    private Address ApplicableAddress;

    /**
     * @return the information
     */
    public String getInformation() {
        return Information;
    }

    /**
     * @param information
     *            the information to set
     */
    public void setInformation(String information) {
        Information = information;
    }

    /**
     * @return the reference
     */
    public String getReference() {
        return Reference;
    }

    /**
     * @param reference
     *            the reference to set
     */
    public void setReference(String reference) {
        Reference = reference;
    }

    /**
     * @return the applicableAddress
     */
    public Address getApplicableAddress() {
        return ApplicableAddress;
    }

    /**
     * @param applicableAddress
     *            the applicableAddress to set
     */
    public void setApplicableAddress(Address applicableAddress) {
        ApplicableAddress = applicableAddress;
    }

}// end TradingTerms