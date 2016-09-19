package org.openfact.models.jpa.ubl.common;

import java.util.List;

public class SupplierPartyAdapter implements SupplierPartyModel, JpaModel<SupplierPartyEntity> {

    protected static final Logger logger = Logger.getLogger(SupplierPartyAdapter.class);
    protected SupplierPartyEntity supplierParty;
    protected EntityManager em;
    protected OpenfactSession session;

    public SupplierPartyAdapter(OpenfactSession session, EntityManager em,
            SupplierPartyEntity supplierParty) {
        this.session = session;
        this.em = em;
        this.supplierParty = supplierParty;
    }

    String getCustomerAssignedAccountID() {
        return this.supplierParty.getCustomerAssignedAccountID();
    }

    void setCustomerAssignedAccountID(String value) {
        this.supplierParty.setCustomerAssignedAccountID(value);
    }

    List<String> getAdditionalAccountID() {
        return this.supplierParty.getAdditionalAccountID();
    }

    void setAdditionalAccountID(List<String> additionalAccountID) {
        this.supplierParty.setAdditionalAccountID(additionalAccountID);
    }

    String getDataSendingCapability() {
        return this.supplierParty.getDataSendingCapability();
    }

    void setDataSendingCapability(String value) {
        this.supplierParty.setDataSendingCapability(value);
    }

    PartyAdapter getParty() {
        return this.supplierParty.getParty();
    }

    void setParty(PartyAdapter value) {
        this.supplierParty.setParty(value);
    }

    ContactAdapter getDespatchContact() {
        return this.supplierParty.getDespatchContact();
    }

    void setDespatchContact(ContactAdapter value) {
        this.supplierParty.setDespatchContact(value);
    }

    ContactAdapter getAccountingContact() {
        return this.supplierParty.getAccountingContact();
    }

    void setAccountingContact(ContactAdapter value) {
        this.supplierParty.setAccountingContact(value);
    }

    ContactAdapter getSellerContact() {
        return this.supplierParty.getSellerContact();
    }

    void setSellerContact(ContactAdapter value) {
        this.supplierParty.setSellerContact(value);
    }

    String getId() {
        return this.supplierParty.getId();
    }

    void setId(String value) {
        this.supplierParty.setId(value);
    }

}
