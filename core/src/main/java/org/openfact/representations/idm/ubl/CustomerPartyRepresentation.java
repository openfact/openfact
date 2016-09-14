package org.openfact.representations.idm.ubl;

/**
 * A class to describe a customer party.
 * 
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:14:16 a. m.
 */
public class CustomerPartyRepresentation {

    /**
     * An identifier for the customer's account, assigned by a third party.
     */
    private String additionalAccountID;

    /**
     * An identifier for the customer's account, assigned by the customer
     * itself.
     */
    private String customerAssignedAccountID;

    private ContactRepresentation buyerContact;
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
     * @return the buyerContact
     */
    public ContactRepresentation getBuyerContact() {
        return buyerContact;
    }

    /**
     * @param buyerContact
     *            the buyerContact to set
     */
    public void setBuyerContact(ContactRepresentation buyerContact) {
        this.buyerContact = buyerContact;
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
