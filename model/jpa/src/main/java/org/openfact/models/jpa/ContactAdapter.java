package org.openfact.models.jpa;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.ContactModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.entities.ContactEntity;

public class ContactAdapter implements ContactModel, JpaModel<ContactEntity> {

    protected static final Logger logger = Logger.getLogger(ContactAdapter.class);
    protected ContactEntity contact;
    protected EntityManager em;
    protected OpenfactSession session;

    public ContactAdapter(OpenfactSession session, EntityManager em, ContactEntity contact) {
        this.session = session;
        this.em = em;
        this.contact = contact;
    }

    @Override
    public ContactEntity getEntity() {
        return contact;
    }

    @Override
    public String getId() {
        return contact.getId();
    }

    @Override
    public String getElectronicMail() {
        return contact.getElectronicMail();
    }

    @Override
    public void setElectronicMail(String value) {
        contact.setElectronicMail(value);
    }

}
