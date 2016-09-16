package org.openfact.representations.idm.ubl.common;

import java.util.List;

public class ContactRepresentation {
    private String ID;
    private String name;
    private String telephone;
    private String telefax;
    private String electronicMail;
    private String note;
    private List<CommunicationRepresentation> otherCommunication;
    private String id;

    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getTelefax() {
        return this.telefax;
    }

    public void setTelefax(String telefax) {
        this.telefax = telefax;
    }

    public String getID() {
        return this.ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public List<CommunicationRepresentation> getOtherCommunication() {
        return this.otherCommunication;
    }

    public void setOtherCommunication(List<CommunicationRepresentation> otherCommunication) {
        this.otherCommunication = otherCommunication;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getElectronicMail() {
        return this.electronicMail;
    }

    public void setElectronicMail(String electronicMail) {
        this.electronicMail = electronicMail;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}