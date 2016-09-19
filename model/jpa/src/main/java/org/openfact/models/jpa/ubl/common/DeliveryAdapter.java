package org.openfact.models.jpa.ubl.common;

import java.time.LocalDate;
import java.time.LocalTime;

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

    String getID() {
        return this.delivery.getID();
    }

    void setID(String value) {
        this.delivery.setID(value);
    }

    QuantityAdapter getQuantity() {
        return this.delivery.getQuantity();
    }

    void setQuantity(QuantityAdapter value) {
        this.delivery.setQuantity(value);
    }

    QuantityAdapter getMinimumQuantity() {
        return this.delivery.getMinimumQuantity();
    }

    void setMinimumQuantity(QuantityAdapter value) {
        this.delivery.setMinimumQuantity(value);
    }

    QuantityAdapter getMaximumQuantity() {
        return this.delivery.getMaximumQuantity();
    }

    void setMaximumQuantity(QuantityAdapter value) {
        this.delivery.setMaximumQuantity(value);
    }

    LocalDate getActualDeliveryDate() {
        return this.delivery.getActualDeliveryDate();
    }

    void setActualDeliveryDate(LocalDate value) {
        this.delivery.setActualDeliveryDate(value);
    }

    LocalTime getActualDeliveryTime() {
        return this.delivery.getActualDeliveryTime();
    }

    void setActualDeliveryTime(LocalTime value) {
        this.delivery.setActualDeliveryTime(value);
    }

    LocalDate getLatestDeliveryDate() {
        return this.delivery.getLatestDeliveryDate();
    }

    void setLatestDeliveryDate(LocalDate value) {
        this.delivery.setLatestDeliveryDate(value);
    }

    LocalTime getLatestDeliveryTime() {
        return this.delivery.getLatestDeliveryTime();
    }

    void setLatestDeliveryTime(LocalTime value) {
        this.delivery.setLatestDeliveryTime(value);
    }

    String getTrackingID() {
        return this.delivery.getTrackingID();
    }

    void setTrackingID(String value) {
        this.delivery.setTrackingID(value);
    }

    AddressAdapter getDeliveryAddress() {
        return this.delivery.getDeliveryAddress();
    }

    void setDeliveryAddress(AddressAdapter value) {
        this.delivery.setDeliveryAddress(value);
    }

    LocationAdapterCommAgg getDeliveryLocation() {
        return this.delivery.getDeliveryLocation();
    }

    void setDeliveryLocation(LocationAdapterCommAgg value) {
        this.delivery.setDeliveryLocation(value);
    }

    PeriodAdapter getRequestedDeliveryPeriod() {
        return this.delivery.getRequestedDeliveryPeriod();
    }

    void setRequestedDeliveryPeriod(PeriodAdapter value) {
        this.delivery.setRequestedDeliveryPeriod(value);
    }

    PeriodAdapter getPromisedDeliveryPeriod() {
        return this.delivery.getPromisedDeliveryPeriod();
    }

    void setPromisedDeliveryPeriod(PeriodAdapter value) {
        this.delivery.setPromisedDeliveryPeriod(value);
    }

    PeriodAdapter getEstimatedDeliveryPeriod() {
        return this.delivery.getEstimatedDeliveryPeriod();
    }

    void setEstimatedDeliveryPeriod(PeriodAdapter value) {
        this.delivery.setEstimatedDeliveryPeriod(value);
    }

    PartyAdapter getDeliveryParty() {
        return this.delivery.getDeliveryParty();
    }

    void setDeliveryParty(PartyAdapter value) {
        this.delivery.setDeliveryParty(value);
    }

    DespatchAdapter getDespatch() {
        return this.delivery.getDespatch();
    }

    void setDespatch(DespatchAdapter value) {
        this.delivery.setDespatch(value);
    }

    String getId() {
        return this.delivery.getId();
    }

    void setId(String value) {
        this.delivery.setId(value);
    }

}
