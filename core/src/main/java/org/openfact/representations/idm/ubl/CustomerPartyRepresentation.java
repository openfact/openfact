package org.openfact.representations.idm.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.IdentifierType;

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
    private IdentifierType additionalAccountID;
    /**
     * An identifier for the customer's account, assigned by the customer
     * itself.
     */
    private IdentifierType customerAssignedAccountID;
    /**
     * An identifier for the customer's account, assigned by the supplier.
     */
    private IdentifierType supplierAssignedAccountID;
    private ContactRepresentation deliveryContact;
    private ContactRepresentation accountingContact;
    private ContactRepresentation buyerContact;
    private List<PartyRepresentation> parties = new ArrayList<>();

    /**
     * @return the additionalAccountID
     */
    public IdentifierType getAdditionalAccountID() {
        return additionalAccountID;
    }

    /**
     * @param additionalAccountID
     *            the additionalAccountID to set
     */
    public void setAdditionalAccountID(IdentifierType additionalAccountID) {
        this.additionalAccountID = additionalAccountID;
    }

    /**
     * @return the customerAssignedAccountID
     */
    public IdentifierType getCustomerAssignedAccountID() {
        return customerAssignedAccountID;
    }

    /**
     * @param customerAssignedAccountID
     *            the customerAssignedAccountID to set
     */
    public void setCustomerAssignedAccountID(IdentifierType customerAssignedAccountID) {
        this.customerAssignedAccountID = customerAssignedAccountID;
    }

    /**
     * @return the supplierAssignedAccountID
     */
    public IdentifierType getSupplierAssignedAccountID() {
        return supplierAssignedAccountID;
    }

    /**
     * @param supplierAssignedAccountID
     *            the supplierAssignedAccountID to set
     */
    public void setSupplierAssignedAccountID(IdentifierType supplierAssignedAccountID) {
        this.supplierAssignedAccountID = supplierAssignedAccountID;
    }

    /**
     * @return the deliveryContact
     */
    public ContactRepresentation getDeliveryContact() {
        return deliveryContact;
    }

    /**
     * @param deliveryContact
     *            the deliveryContact to set
     */
    public void setDeliveryContact(ContactRepresentation deliveryContact) {
        this.deliveryContact = deliveryContact;
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
     * @return the parties
     */
    public List<PartyRepresentation> getParties() {
        return parties;
    }

    /**
     * @param parties
     *            the parties to set
     */
    public void setParties(List<PartyRepresentation> parties) {
        this.parties = parties;
    }

}
