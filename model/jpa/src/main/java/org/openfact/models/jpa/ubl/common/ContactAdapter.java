package org.openfact.models.jpa.ubl.common;

import java.util.List;

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

    String getID() {
        return this.contact.getID();
    }

    void setID(String value) {
        this.contact.setID(value);
    }

    String getName() {
        return this.contact.getName();
    }

    void setName(String value) {
        this.contact.setName(value);
    }

    String getTelephone() {
        return this.contact.getTelephone();
    }

    void setTelephone(String value) {
        this.contact.setTelephone(value);
    }

    String getTelefax() {
        return this.contact.getTelefax();
    }

    void setTelefax(String value) {
        this.contact.setTelefax(value);
    }

    String getElectronicMail() {
        return this.contact.getElectronicMail();
    }

    void setElectronicMail(String value) {
        this.contact.setElectronicMail(value);
    }

    String getNote() {
        return this.contact.getNote();
    }

    void setNote(String value) {
        this.contact.setNote(value);
    }

    List<CommunicationAdapter> getOtherCommunication() {
        return this.contact.getOtherCommunication();
    }

    void setOtherCommunication(List<CommunicationAdapter> otherCommunication) {
        this.contact.setOtherCommunication(otherCommunication);
    }

    String getId() {
        return this.contact.getId();
    }

    void setId(String value) {
        this.contact.setId(value);
    }

}
