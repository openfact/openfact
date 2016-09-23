package org.openfact.models.jpa.ubl.common;

import java.util.List;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.CustomerPartyEntity;
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
        return new PartyAdapter(session, em, this.customerParty.getParty());
    }

    @Override
    public void setParty(PartyModel value) {
        this.customerParty.setParty(PartyAdapter.toEntity(value, em));
    }

    @Override
    public ContactModel getDeliveryContact() {
        return new ContactAdapter(session, em, this.customerParty.getDeliveryContact());
    }

    @Override
    public void setDeliveryContact(ContactModel value) {
        this.customerParty.setDeliveryContact(ContactAdapter.toEntity(value, em));
    }

    @Override
    public ContactModel getAccountingContact() {
        return new ContactAdapter(session, em, this.customerParty.getAccountingContact());
    }

    @Override
    public void setAccountingContact(ContactModel value) {
        this.customerParty.setAccountingContact(ContactAdapter.toEntity(value, em));
    }

    @Override
    public ContactModel getBuyerContact() {
        return new ContactAdapter(session, em, this.customerParty.getBuyerContact());
    }

    @Override
    public void setBuyerContact(ContactModel value) {
        this.customerParty.setBuyerContact(ContactAdapter.toEntity(value, em));
    }

    @Override
    public String getId() {
        return this.customerParty.getId();
    }

    @Override
    public void setId(String value) {
        this.customerParty.setId(value);
    }

    @Override
    public CustomerPartyEntity getEntity() {
        return this.customerParty;
    }

    public static CustomerPartyEntity toEntity(CustomerPartyModel model, EntityManager em) {
        if (model instanceof CustomerPartyAdapter) {
            return ((CustomerPartyAdapter) model).getEntity();
        }
        return em.getReference(CustomerPartyEntity.class, model.getId());
    }

}
