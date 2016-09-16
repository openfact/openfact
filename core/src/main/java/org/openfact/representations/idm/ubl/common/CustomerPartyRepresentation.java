package org.openfact.representations.idm.ubl.common;

import java.util.ArrayList;
import java.util.List;

public class CustomerPartyRepresentation {
    private String customerAssignedAccountID;
    private String supplierAssignedAccountID;
    private List<String> additionalAccountID;
    private PartyRepresentation party;
    private ContactRepresentation deliveryContact;
    private ContactRepresentation accountingContact;
    private ContactRepresentation buyerContact;
    private String id;

    /**/
    public  void addAdditionalAccountID(String rep){
        if(additionalAccountID==null){
            additionalAccountID=new ArrayList<>();
        }
        additionalAccountID.add(rep);
    }
    /**/

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ContactRepresentation getBuyerContact() {
        return this.buyerContact;
    }

    public void setBuyerContact(ContactRepresentation buyerContact) {
        this.buyerContact = buyerContact;
    }

    public ContactRepresentation getDeliveryContact() {
        return this.deliveryContact;
    }

    public void setDeliveryContact(ContactRepresentation deliveryContact) {
        this.deliveryContact = deliveryContact;
    }

    public String getSupplierAssignedAccountID() {
        return this.supplierAssignedAccountID;
    }

    public void setSupplierAssignedAccountID(String supplierAssignedAccountID) {
        this.supplierAssignedAccountID = supplierAssignedAccountID;
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

    public PartyRepresentation getParty() {
        return this.party;
    }

    public void setParty(PartyRepresentation party) {
        this.party = party;
    }
}