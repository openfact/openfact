package org.openfact.models.jpa.ubl.common;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.EntityManager;

import org.openfact.models.OpenfactSession;
import org.jboss.logging.Logger;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.DeliveryEntity;
import org.openfact.models.jpa.entities.ubl.common.DeliveryEntity;
import org.openfact.models.ubl.common.AddressModel;
import org.openfact.models.ubl.common.DeliveryModel;
import org.openfact.models.ubl.common.DespatchModel;
import org.openfact.models.ubl.common.LocationCommAggModel;
import org.openfact.models.ubl.common.PartyModel;
import org.openfact.models.ubl.common.PeriodModel;
import org.openfact.models.ubl.common.QuantityModel;

public class DeliveryAdapter implements DeliveryModel, JpaModel<DeliveryEntity> {

    protected static final Logger logger = Logger.getLogger(DeliveryAdapter.class);
    protected DeliveryEntity delivery;
    protected EntityManager em;
    protected OpenfactSession session;

    public DeliveryAdapter(OpenfactSession session, EntityManager em, DeliveryEntity delivery) {
        this.session = session;
        this.em = em;
        this.delivery = delivery;
    }

    @Override
    public String getID() {
        return this.delivery.getID();
    }

    @Override
    public void setID(String value) {
        this.delivery.setID(value);
    }

    @Override
    public QuantityModel getQuantity() {
        return this.delivery.getQuantity();
    }

    @Override
    public void setQuantity(QuantityAdapter value) {
        this.delivery.setQuantity(value);
    }

    @Override
    public QuantityModel getMinimumQuantity() {
        return this.delivery.getMinimumQuantity();
    }

    @Override
    public void setMinimumQuantity(QuantityAdapter value) {
        this.delivery.setMinimumQuantity(value);
    }

    @Override
    public QuantityModel getMaximumQuantity() {
        return this.delivery.getMaximumQuantity();
    }

    @Override
    public void setMaximumQuantity(QuantityAdapter value) {
        this.delivery.setMaximumQuantity(value);
    }

    @Override
    public LocalDate getActualDeliveryDate() {
        return this.delivery.getActualDeliveryDate();
    }

    @Override
    public void setActualDeliveryDate(LocalDate value) {
        this.delivery.setActualDeliveryDate(value);
    }

    @Override
    public LocalTime getActualDeliveryTime() {
        return this.delivery.getActualDeliveryTime();
    }

    @Override
    public void setActualDeliveryTime(LocalTime value) {
        this.delivery.setActualDeliveryTime(value);
    }

    @Override
    public LocalDate getLatestDeliveryDate() {
        return this.delivery.getLatestDeliveryDate();
    }

    @Override
    public void setLatestDeliveryDate(LocalDate value) {
        this.delivery.setLatestDeliveryDate(value);
    }

    @Override
    public LocalTime getLatestDeliveryTime() {
        return this.delivery.getLatestDeliveryTime();
    }

    @Override
    public void setLatestDeliveryTime(LocalTime value) {
        this.delivery.setLatestDeliveryTime(value);
    }

    @Override
    public String getTrackingID() {
        return this.delivery.getTrackingID();
    }

    @Override
    public void setTrackingID(String value) {
        this.delivery.setTrackingID(value);
    }

    @Override
    public AddressModel getDeliveryAddress() {
        return this.delivery.getDeliveryAddress();
    }

    @Override
    public void setDeliveryAddress(AddressAdapter value) {
        this.delivery.setDeliveryAddress(value);
    }

    @Override
    public LocationCommAggModel getDeliveryLocation() {
        return this.delivery.getDeliveryLocation();
    }

    @Override
    public void setDeliveryLocation(LocationCommAggAdapter value) {
        this.delivery.setDeliveryLocation(value);
    }

    @Override
    public PeriodModel getRequestedDeliveryPeriod() {
        return this.delivery.getRequestedDeliveryPeriod();
    }

    @Override
    public void setRequestedDeliveryPeriod(PeriodAdapter value) {
        this.delivery.setRequestedDeliveryPeriod(value);
    }

    @Override
    public PeriodModel getPromisedDeliveryPeriod() {
        return this.delivery.getPromisedDeliveryPeriod();
    }

    @Override
    public void setPromisedDeliveryPeriod(PeriodAdapter value) {
        this.delivery.setPromisedDeliveryPeriod(value);
    }

    @Override
    public PeriodModel getEstimatedDeliveryPeriod() {
        return this.delivery.getEstimatedDeliveryPeriod();
    }

    @Override
    public void setEstimatedDeliveryPeriod(PeriodAdapter value) {
        this.delivery.setEstimatedDeliveryPeriod(value);
    }

    @Override
    public PartyModel getDeliveryParty() {
        return this.delivery.getDeliveryParty();
    }

    @Override
    public void setDeliveryParty(PartyAdapter value) {
        this.delivery.setDeliveryParty(value);
    }

    @Override
    public DespatchModel getDespatch() {
        return this.delivery.getDespatch();
    }

    @Override
    public void setDespatch(DespatchAdapter value) {
        this.delivery.setDespatch(value);
    }

    @Override
    public String getId() {
        return this.delivery.getId();
    }

    @Override
    public void setId(String value) {
        this.delivery.setId(value);
    }

}
