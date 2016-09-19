package org.openfact.models.jpa.ubl.common;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.EntityManager;

import org.openfact.models.OpenfactSession;
import org.jboss.logging.Logger;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.DespatchEntity;
import org.openfact.models.ubl.common.AddressModel;
import org.openfact.models.ubl.common.ContactModel;
import org.openfact.models.ubl.common.DespatchModel;
import org.openfact.models.ubl.common.PartyModel;

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

    @Override
    public String getID() {
        return this.despatch.getID();
    }

    @Override
    public void setID(String value) {
        this.despatch.setID(value);
    }

    @Override
    public LocalDate getRequestedDespatchDate() {
        return this.despatch.getRequestedDespatchDate();
    }

    @Override
    public void setRequestedDespatchDate(LocalDate value) {
        this.despatch.setRequestedDespatchDate(value);
    }

    @Override
    public LocalTime getRequestedDespatchTime() {
        return this.despatch.getRequestedDespatchTime();
    }

    @Override
    public void setRequestedDespatchTime(LocalTime value) {
        this.despatch.setRequestedDespatchTime(value);
    }

    @Override
    public LocalDate getEstimatedDespatchDate() {
        return this.despatch.getEstimatedDespatchDate();
    }

    @Override
    public void setEstimatedDespatchDate(LocalDate value) {
        this.despatch.setEstimatedDespatchDate(value);
    }

    @Override
    public LocalTime getEstimatedDespatchTime() {
        return this.despatch.getEstimatedDespatchTime();
    }

    @Override
    public void setEstimatedDespatchTime(LocalTime value) {
        this.despatch.setEstimatedDespatchTime(value);
    }

    @Override
    public LocalDate getActualDespatchDate() {
        return this.despatch.getActualDespatchDate();
    }

    @Override
    public void setActualDespatchDate(LocalDate value) {
        this.despatch.setActualDespatchDate(value);
    }

    @Override
    public LocalTime getActualDespatchTime() {
        return this.despatch.getActualDespatchTime();
    }

    @Override
    public void setActualDespatchTime(LocalTime value) {
        this.despatch.setActualDespatchTime(value);
    }

    @Override
    public AddressModel getDespatchAddress() {
        return this.despatch.getDespatchAddress();
    }

    @Override
    public void setDespatchAddress(AddressAdapter value) {
        this.despatch.setDespatchAddress(value);
    }

    @Override
    public PartyModel getDespatchParty() {
        return this.despatch.getDespatchParty();
    }

    @Override
    public void setDespatchParty(PartyAdapter value) {
        this.despatch.setDespatchParty(value);
    }

    @Override
    public ContactModel getContact() {
        return this.despatch.getContact();
    }

    @Override
    public void setContact(ContactAdapter value) {
        this.despatch.setContact(value);
    }

    @Override
    public String getId() {
        return this.despatch.getId();
    }

    @Override
    public void setId(String value) {
        this.despatch.setId(value);
    }

}
