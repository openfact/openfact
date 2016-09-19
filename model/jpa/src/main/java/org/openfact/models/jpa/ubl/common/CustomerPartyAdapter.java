package org.openfact.models.jpa.ubl.common;

import java.util.List;

public class CustomerPartyAdapter implements CustomerPartyModel, JpaModel<CustomerPartyEntity> {

    protected static final Logger logger = Logger.getLogger(CustomerPartyAdapter.class);
    protected CustomerPartyEntity customerParty;
    protected EntityManager em;
    protected OpenfactSession session;

    public CustomerPartyAdapter(OpenfactSession session, EntityManager em,
            CustomerPartyEntity customerParty) {
        this.session = session;
        this.em = em;
        this.customerParty = customerParty;
    }

    String getCustomerAssignedAccountID() {
        return this.customerParty.getCustomerAssignedAccountID();
    }

    void setCustomerAssignedAccountID(String value) {
        this.customerParty.setCustomerAssignedAccountID(value);
    }

    String getSupplierAssignedAccountID() {
        return this.customerParty.getSupplierAssignedAccountID();
    }

    void setSupplierAssignedAccountID(String value) {
        this.customerParty.setSupplierAssignedAccountID(value);
    }

    List<String> getAdditionalAccountID() {
        return this.customerParty.getAdditionalAccountID();
    }

    void setAdditionalAccountID(List<String> additionalAccountID) {
        this.customerParty.setAdditionalAccountID(additionalAccountID);
    }

    PartyAdapter getParty() {
        return this.customerParty.getParty();
    }

    void setParty(PartyAdapter value) {
        this.customerParty.setParty(value);
    }

    ContactAdapter getDeliveryContact() {
        return this.customerParty.getDeliveryContact();
    }

    void setDeliveryContact(ContactAdapter value) {
        this.customerParty.setDeliveryContact(value);
    }

    ContactAdapter getAccountingContact() {
        return this.customerParty.getAccountingContact();
    }

    void setAccountingContact(ContactAdapter value) {
        this.customerParty.setAccountingContact(value);
    }

    ContactAdapter getBuyerContact() {
        return this.customerParty.getBuyerContact();
    }

    void setBuyerContact(ContactAdapter value) {
        this.customerParty.setBuyerContact(value);
    }

    String getId() {
        return this.customerParty.getId();
    }

    void setId(String value) {
        this.customerParty.setId(value);
    }

}
