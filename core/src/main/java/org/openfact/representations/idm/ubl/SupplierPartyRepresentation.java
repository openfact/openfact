package org.openfact.representations.idm.ubl;

import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;

public class SupplierPartyRepresentation {

    /**
     * An additional identifier for this supplier party.
     */
    private IdentifierRepresentation additionalAccountID;
    /**
     * An identifier for this supplier party, assigned by the customer.
     */
    private IdentifierRepresentation customerAssignedAccountID;
    /**
     * Text describing the supplier's ability to send invoice data via a
     * purchase card provider (e.g., VISA, MasterCard, American Express).
     */
    private String dataSendingCapability;
    private ContactRepresentation sellerContact;
    private ContactRepresentation accountingContact;
    private ContactRepresentation despatchContact;
    private PartyRepresentation party;

    /**
     * @return the additionalAccountID
     */
    public IdentifierRepresentation getAdditionalAccountID() {
        return additionalAccountID;
    }

    /**
     * @param additionalAccountID
     *            the additionalAccountID to set
     */
    public void setAdditionalAccountID(IdentifierRepresentation additionalAccountID) {
        this.additionalAccountID = additionalAccountID;
    }

    /**
     * @return the customerAssignedAccountID
     */
    public IdentifierRepresentation getCustomerAssignedAccountID() {
        return customerAssignedAccountID;
    }

    /**
     * @param customerAssignedAccountID
     *            the customerAssignedAccountID to set
     */
    public void setCustomerAssignedAccountID(IdentifierRepresentation customerAssignedAccountID) {
        this.customerAssignedAccountID = customerAssignedAccountID;
    }

    /**
     * @return the dataSendingCapability
     */
    public String getDataSendingCapability() {
        return dataSendingCapability;
    }

    /**
     * @param dataSendingCapability
     *            the dataSendingCapability to set
     */
    public void setDataSendingCapability(String dataSendingCapability) {
        this.dataSendingCapability = dataSendingCapability;
    }

    /**
     * @return the sellerContact
     */
    public ContactRepresentation getSellerContact() {
        return sellerContact;
    }

    /**
     * @param sellerContact
     *            the sellerContact to set
     */
    public void setSellerContact(ContactRepresentation sellerContact) {
        this.sellerContact = sellerContact;
    }

    /**
     * @return the accountingContact
     */
    public ContactRepresentation getAccountingContact() {
        return accountingContact;
    }

    /**
     * @param accountingContact
     *            the accountingContact to set
     */
    public void setAccountingContact(ContactRepresentation accountingContact) {
        this.accountingContact = accountingContact;
    }

    /**
     * @return the despatchContact
     */
    public ContactRepresentation getDespatchContact() {
        return despatchContact;
    }

    /**
     * @param despatchContact
     *            the despatchContact to set
     */
    public void setDespatchContact(ContactRepresentation despatchContact) {
        this.despatchContact = despatchContact;
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
