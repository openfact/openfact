package org.openfact.representations.idm.ubl.common;

import java.util.List;

public class SupplierPartyRepresentation {
    private String customerAssignedAccountID;
    private List<String> additionalAccountID;
    private String dataSendingCapability;
    private PartyRepresentation party;
    private ContactRepresentation despatchContact;
    private ContactRepresentation accountingContact;
    private ContactRepresentation sellerContact;
    private String id;

    public ContactRepresentation getSellerContact() {
        return this.sellerContact;
    }

    public void setSellerContact(ContactRepresentation sellerContact) {
        this.sellerContact = sellerContact;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ContactRepresentation getAccountingContact() {
        return this.accountingContact;
    }

    public void setAccountingContact(ContactRepresentation accountingContact) {
        this.accountingContact = accountingContact;
    }

    public List<String> getAdditionalAccountID() {
        return this.additionalAccountID;
    }

    public void setAdditionalAccountID(List<String> additionalAccountID) {
        this.additionalAccountID = additionalAccountID;
    }

    public String getCustomerAssignedAccountID() {
        return this.customerAssignedAccountID;
    }

    public void setCustomerAssignedAccountID(String customerAssignedAccountID) {
        this.customerAssignedAccountID = customerAssignedAccountID;
    }

    public ContactRepresentation getDespatchContact() {
        return this.despatchContact;
    }

    public void setDespatchContact(ContactRepresentation despatchContact) {
        this.despatchContact = despatchContact;
    }

    public PartyRepresentation getParty() {
        return this.party;
    }

    public void setParty(PartyRepresentation party) {
        this.party = party;
    }

    public String getDataSendingCapability() {
        return this.dataSendingCapability;
    }

    public void setDataSendingCapability(String dataSendingCapability) {
        this.dataSendingCapability = dataSendingCapability;
    }
}