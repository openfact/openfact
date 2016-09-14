package org.openfact.representations.idm.ubl;

public class SupplierPartyRepresentation {

    /**
     * An additional identifier for this supplier party.
     */
    private String additionalAccountID;
    /**
     * An identifier for this supplier party, assigned by the customer.
     */
    private String customerAssignedAccountID;

    private PartyRepresentation party;

    /**
     * @return the additionalAccountID
     */
    public String getAdditionalAccountID() {
        return additionalAccountID;
    }

    /**
     * @param additionalAccountID
     *            the additionalAccountID to set
     */
    public void setAdditionalAccountID(String additionalAccountID) {
        this.additionalAccountID = additionalAccountID;
    }

    /**
     * @return the customerAssignedAccountID
     */
    public String getCustomerAssignedAccountID() {
        return customerAssignedAccountID;
    }

    /**
     * @param customerAssignedAccountID
     *            the customerAssignedAccountID to set
     */
    public void setCustomerAssignedAccountID(String customerAssignedAccountID) {
        this.customerAssignedAccountID = customerAssignedAccountID;
    }

    /**
     * @return the party
     */
    public PartyRepresentation getParty() {
        return party;
    }

    /**
     * @param party
     *            the party to set
     */
    public void setParty(PartyRepresentation party) {
        this.party = party;
    }

}
