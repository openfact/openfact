package org.openfact.models.jpa.ubl.common;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.AllowanceChargeEntity;
import org.openfact.models.jpa.entities.ubl.common.DeliveryEntity;
import org.openfact.models.ubl.common.AddressModel;
import org.openfact.models.ubl.common.AllowanceChargeModel;
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
        return new QuantityAdapter(session, em, this.delivery.getQuantity());
    }

    @Override
    public void setQuantity(QuantityModel value) {
        this.delivery.setQuantity(QuantityAdapter.toEntity(value, em));
    }

    @Override
    public QuantityModel getMinimumQuantity() {
        return new QuantityAdapter(session, em, this.delivery.getMinimumQuantity());
    }

    @Override
    public void setMinimumQuantity(QuantityModel value) {
        this.delivery.setMinimumQuantity(QuantityAdapter.toEntity(value, em));
    }

    @Override
    public QuantityModel getMaximumQuantity() {
        return new QuantityAdapter(session, em, this.delivery.getMaximumQuantity());
    }

    @Override
    public void setMaximumQuantity(QuantityModel value) {
        this.delivery.setMaximumQuantity(QuantityAdapter.toEntity(value, em));
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
        return new AddressAdapter(session, em, this.delivery.getDeliveryAddress());
    }

    @Override
    public void setDeliveryAddress(AddressModel value) {
        this.delivery.setDeliveryAddress(AddressAdapter.toEntity(value, em));
    }

    @Override
    public LocationCommAggModel getDeliveryLocation() {
        return new LocationCommAggAdapter(session, em, this.delivery.getDeliveryLocation());
    }

    @Override
    public void setDeliveryLocation(LocationCommAggModel value) {
        this.delivery.setDeliveryLocation(LocationCommAggAdapter.toEntity(value, em));
    }

    @Override
    public PeriodModel getRequestedDeliveryPeriod() {
        return new PeriodAdapter(session, em, this.delivery.getRequestedDeliveryPeriod());
    }

    @Override
    public void setRequestedDeliveryPeriod(PeriodModel value) {
        this.delivery.setRequestedDeliveryPeriod(PeriodAdapter.toEntity(value, em));
    }

    @Override
    public PeriodModel getPromisedDeliveryPeriod() {
        return new PeriodAdapter(session, em, this.delivery.getPromisedDeliveryPeriod());
    }

    @Override
    public void setPromisedDeliveryPeriod(PeriodModel value) {
        this.delivery.setPromisedDeliveryPeriod(PeriodAdapter.toEntity(value, em));
    }

    @Override
    public PeriodModel getEstimatedDeliveryPeriod() {
        return new PeriodAdapter(session, em, this.delivery.getEstimatedDeliveryPeriod());
    }

    @Override
    public void setEstimatedDeliveryPeriod(PeriodModel value) {
        this.delivery.setEstimatedDeliveryPeriod(PeriodAdapter.toEntity(value, em));
    }

    @Override
    public PartyModel getDeliveryParty() {
        return new PartyAdapter(session, em, this.delivery.getDeliveryParty());
    }

    @Override
    public void setDeliveryParty(PartyModel value) {
        this.delivery.setDeliveryParty(PartyAdapter.toEntity(value, em));
    }

    @Override
    public DespatchModel getDespatch() {
        return new DespatchAdapter(session, em, this.delivery.getDespatch());
    }

    @Override
    public void setDespatch(DespatchModel value) {
        this.delivery.setDespatch(DespatchAdapter.toEntity(value, em));
    }

    @Override
    public String getId() {
        return this.delivery.getId();
    }

    @Override
    public void setId(String value) {
        this.delivery.setId(value);
    }

    public static DeliveryEntity toEntity(DeliveryModel model, EntityManager em) {
        if (model instanceof DeliveryAdapter) {
            return ((DeliveryAdapter) model).getEntity();
        }
        return em.getReference(DeliveryEntity.class, model.getId());
    }

    @Override
    public DeliveryEntity getEntity() {
        return this.delivery;
    }

}
