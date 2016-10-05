package org.openfact.models.jpa.ubl.common;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.CommunicationEntity;
import org.openfact.models.jpa.entities.ubl.common.ContactEntity;
import org.openfact.models.ubl.common.CommunicationModel;
import org.openfact.models.ubl.common.ContactModel;

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
    public String getID() {
        return this.contact.getID();
    }

    @Override
    public void setID(String value) {
        this.contact.setID(value);
    }

    @Override
    public String getName() {
        return this.contact.getName();
    }

    @Override
    public void setName(String value) {
        this.contact.setName(value);
    }

    @Override
    public String getTelephone() {
        return this.contact.getTelephone();
    }

    @Override
    public void setTelephone(String value) {
        this.contact.setTelephone(value);
    }

    @Override
    public String getTelefax() {
        return this.contact.getTelefax();
    }

    @Override
    public void setTelefax(String value) {
        this.contact.setTelefax(value);
    }

    @Override
    public String getElectronicMail() {
        return this.contact.getElectronicMail();
    }

    @Override
    public void setElectronicMail(String value) {
        this.contact.setElectronicMail(value);
    }

    @Override
    public String getNote() {
        return this.contact.getNote();
    }

    @Override
    public void setNote(String value) {
        this.contact.setNote(value);
    }

    @Override
    public List<CommunicationModel> getOtherCommunication() {
        return this.contact.getOtherCommunication().stream()
                .map(f -> new CommunicationAdapter(session, em, f)).collect(Collectors.toList());
    }

    @Override
    public void setOtherCommunication(List<CommunicationModel> otherCommunication) {
        List<CommunicationEntity> entities = otherCommunication.stream()
                .map(f -> CommunicationAdapter.toEntity(f, em)).collect(Collectors.toList());
        this.contact.setOtherCommunication(entities);
    }

    @Override
    public String getId() {
        return this.contact.getId();
    }

    @Override
    public ContactEntity getEntity() {
        return this.contact;
    }

    public static ContactEntity toEntity(ContactModel model, EntityManager em) {
        if (model instanceof ContactAdapter) {
            return ((ContactAdapter) model).getEntity();
        }
        return em.getReference(ContactEntity.class, model.getId());
    }

}
