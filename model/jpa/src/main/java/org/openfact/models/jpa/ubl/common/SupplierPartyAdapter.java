package org.openfact.models.jpa.ubl.common;

import java.util.List;

import javax.persistence.EntityManager;

import org.openfact.models.OpenfactSession;
import org.jboss.logging.Logger;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.ubl.common.ContactModel;
import org.openfact.models.ubl.common.PartyModel;
import org.openfact.models.ubl.common.SupplierPartyModel;

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

    @Override
    public String getCustomerAssignedAccountID() {
        return this.supplierParty.getCustomerAssignedAccountID();
    }

    @Override
    public void setCustomerAssignedAccountID(String value) {
        this.supplierParty.setCustomerAssignedAccountID(value);
    }

    @Override
    public List<String> getAdditionalAccountID() {
        return this.supplierParty.getAdditionalAccountID();
    }

    @Override
    public void setAdditionalAccountID(List<String> additionalAccountID) {
        this.supplierParty.setAdditionalAccountID(additionalAccountID);
    }

    @Override
    public String getDataSendingCapability() {
        return this.supplierParty.getDataSendingCapability();
    }

    @Override
    public void setDataSendingCapability(String value) {
        this.supplierParty.setDataSendingCapability(value);
    }

    @Override
    public PartyModel getParty() {
        return this.supplierParty.getParty();
    }

    @Override
    public void setParty(PartyAdapter value) {
        this.supplierParty.setParty(value);
    }

    @Override
    public ContactModel getDespatchContact() {
        return this.supplierParty.getDespatchContact();
    }

    @Override
    public void setDespatchContact(ContactAdapter value) {
        this.supplierParty.setDespatchContact(value);
    }

    @Override
    public ContactModel getAccountingContact() {
        return this.supplierParty.getAccountingContact();
    }

    @Override
    public void setAccountingContact(ContactAdapter value) {
        this.supplierParty.setAccountingContact(value);
    }

    @Override
    public ContactModel getSellerContact() {
        return this.supplierParty.getSellerContact();
    }

    @Override
    public void setSellerContact(ContactAdapter value) {
        this.supplierParty.setSellerContact(value);
    }

    @Override
    public String getId() {
        return this.supplierParty.getId();
    }

    @Override
    public void setId(String value) {
        this.supplierParty.setId(value);
    }

}
