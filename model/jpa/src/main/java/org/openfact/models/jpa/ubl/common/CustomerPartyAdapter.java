package org.openfact.models.jpa.ubl.common;

import java.util.List;

import javax.persistence.EntityManager;

import org.openfact.models.OpenfactSession;
import org.jboss.logging.Logger;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.ubl.common.ContactModel;
import org.openfact.models.ubl.common.CustomerPartyModel;
import org.openfact.models.ubl.common.PartyModel;

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

    @Override
    public String getCustomerAssignedAccountID() {
        return this.customerParty.getCustomerAssignedAccountID();
    }

    @Override
    public void setCustomerAssignedAccountID(String value) {
        this.customerParty.setCustomerAssignedAccountID(value);
    }

    @Override
    public String getSupplierAssignedAccountID() {
        return this.customerParty.getSupplierAssignedAccountID();
    }

    @Override
    public void setSupplierAssignedAccountID(String value) {
        this.customerParty.setSupplierAssignedAccountID(value);
    }

    @Override
    public List<String> getAdditionalAccountID() {
        return this.customerParty.getAdditionalAccountID();
    }

    @Override
    public void setAdditionalAccountID(List<String> additionalAccountID) {
        this.customerParty.setAdditionalAccountID(additionalAccountID);
    }

    @Override
    public PartyModel getParty() {
        return this.customerParty.getParty();
    }

    @Override
    public void setParty(PartyAdapter value) {
        this.customerParty.setParty(value);
    }

    @Override
    public ContactModel getDeliveryContact() {
        return this.customerParty.getDeliveryContact();
    }

    @Override
    public void setDeliveryContact(ContactAdapter value) {
        this.customerParty.setDeliveryContact(value);
    }

    @Override
    public ContactModel getAccountingContact() {
        return this.customerParty.getAccountingContact();
    }

    @Override
    public void setAccountingContact(ContactAdapter value) {
        this.customerParty.setAccountingContact(value);
    }

    @Override
    public ContactModel getBuyerContact() {
        return this.customerParty.getBuyerContact();
    }

    @Override
    public void setBuyerContact(ContactAdapter value) {
        this.customerParty.setBuyerContact(value);
    }

    @Override
    public String getId() {
        return this.customerParty.getId();
    }

    @Override
    public void setId(String value) {
        this.customerParty.setId(value);
    }

}
