package org.openfact.models.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.CustomerPartyModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.PartyModel;
import org.openfact.models.jpa.entities.CustomerPartyEntity;
import org.openfact.models.jpa.entities.PartyEntity;

public class CustomerPartyAdapter implements CustomerPartyModel, JpaModel<CustomerPartyEntity> {

    protected static final Logger logger = Logger.getLogger(CustomerPartyAdapter.class);
    protected CustomerPartyEntity customerParty;
    protected EntityManager em;
    protected OpenfactSession session;

    public CustomerPartyAdapter(OpenfactSession session, EntityManager em,
            CustomerPartyEntity supplierParty) {
        this.session = session;
        this.em = em;
        this.customerParty = supplierParty;
    }

    @Override
    public CustomerPartyEntity getEntity() {
        return customerParty;
    }

    @Override
    public String getId() {
        return customerParty.getId();
    }

    @Override
    public String getCustomerAssignedAccountID() {
        return customerParty.getCustomerAssignedAccountId();
    }

    @Override
    public void setCustomerAssignedAccountID(String value) {
        customerParty.setCustomerAssignedAccountId(value);
    }

    @Override
    public List<String> getAdditionalAccountID() {
        return customerParty.getAdditionalAccountId();
    }

    @Override
    public void setAdditionalAccountID(List<String> additionalAccountId) {
        customerParty.setAdditionalAccountId(additionalAccountId);
    }

    @Override
    public PartyModel getParty() {
        if (customerParty.getParty() == null) {
            return null;
        }
        return new PartyAdapter(session, em, customerParty.getParty());
    }

    @Override
    public PartyModel getPartyAsNotNull() {
        if (customerParty.getParty() == null) {
            PartyEntity entity = new PartyEntity();
            customerParty.setParty(entity);
        }
        return new PartyAdapter(session, em, customerParty.getParty());
    }

}
