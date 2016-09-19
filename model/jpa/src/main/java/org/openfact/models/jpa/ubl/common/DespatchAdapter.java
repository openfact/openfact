package org.openfact.models.jpa.ubl.common;

import java.time.LocalDate;
import java.time.LocalTime;

public class DespatchAdapter implements DespatchModel, JpaModel<DespatchEntity> {

    protected static final Logger logger = Logger.getLogger(DespatchAdapter.class);
    protected DespatchEntity despatch;
    protected EntityManager em;
    protected OpenfactSession session;

    public DespatchAdapter(OpenfactSession session, EntityManager em, DespatchEntity despatch) {
        this.session = session;
        this.em = em;
        this.despatch = despatch;
    }

    String getID() {
        return this.despatch.getID();
    }

    void setID(String value) {
        this.despatch.setID(value);
    }

    LocalDate getRequestedDespatchDate() {
        return this.despatch.getRequestedDespatchDate();
    }

    void setRequestedDespatchDate(LocalDate value) {
        this.despatch.setRequestedDespatchDate(value);
    }

    LocalTime getRequestedDespatchTime() {
        return this.despatch.getRequestedDespatchTime();
    }

    void setRequestedDespatchTime(LocalTime value) {
        this.despatch.setRequestedDespatchTime(value);
    }

    LocalDate getEstimatedDespatchDate() {
        return this.despatch.getEstimatedDespatchDate();
    }

    void setEstimatedDespatchDate(LocalDate value) {
        this.despatch.setEstimatedDespatchDate(value);
    }

    LocalTime getEstimatedDespatchTime() {
        return this.despatch.getEstimatedDespatchTime();
    }

    void setEstimatedDespatchTime(LocalTime value) {
        this.despatch.setEstimatedDespatchTime(value);
    }

    LocalDate getActualDespatchDate() {
        return this.despatch.getActualDespatchDate();
    }

    void setActualDespatchDate(LocalDate value) {
        this.despatch.setActualDespatchDate(value);
    }

    LocalTime getActualDespatchTime() {
        return this.despatch.getActualDespatchTime();
    }

    void setActualDespatchTime(LocalTime value) {
        this.despatch.setActualDespatchTime(value);
    }

    AddressAdapter getDespatchAddress() {
        return this.despatch.getDespatchAddress();
    }

    void setDespatchAddress(AddressAdapter value) {
        this.despatch.setDespatchAddress(value);
    }

    PartyAdapter getDespatchParty() {
        return this.despatch.getDespatchParty();
    }

    void setDespatchParty(PartyAdapter value) {
        this.despatch.setDespatchParty(value);
    }

    ContactAdapter getContact() {
        return this.despatch.getContact();
    }

    void setContact(ContactAdapter value) {
        this.despatch.setContact(value);
    }

    String getId() {
        return this.despatch.getId();
    }

    void setId(String value) {
        this.despatch.setId(value);
    }

}
