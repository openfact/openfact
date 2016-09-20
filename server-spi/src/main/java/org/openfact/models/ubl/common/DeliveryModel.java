package org.openfact.models.ubl.common;

import java.time.LocalDate;
import java.time.LocalTime;

public interface DeliveryModel {

    String getID();

    void setID(String value);

    QuantityModel getQuantity();

    void setQuantity(QuantityModel value);

    QuantityModel getMinimumQuantity();

    void setMinimumQuantity(QuantityModel value);

    QuantityModel getMaximumQuantity();

    void setMaximumQuantity(QuantityModel value);

    LocalDate getActualDeliveryDate();

    void setActualDeliveryDate(LocalDate value);

    LocalTime getActualDeliveryTime();

    void setActualDeliveryTime(LocalTime value);

    LocalDate getLatestDeliveryDate();

    void setLatestDeliveryDate(LocalDate value);

    LocalTime getLatestDeliveryTime();

    void setLatestDeliveryTime(LocalTime value);

    String getTrackingID();

    void setTrackingID(String value);

    AddressModel getDeliveryAddress();

    void setDeliveryAddress(AddressModel value);

    LocationCommAggModel getDeliveryLocation();

    void setDeliveryLocation(LocationCommAggModel value);

    PeriodModel getRequestedDeliveryPeriod();

    void setRequestedDeliveryPeriod(PeriodModel value);

    PeriodModel getPromisedDeliveryPeriod();

    void setPromisedDeliveryPeriod(PeriodModel value);

    PeriodModel getEstimatedDeliveryPeriod();

    void setEstimatedDeliveryPeriod(PeriodModel value);

    PartyModel getDeliveryParty();

    void setDeliveryParty(PartyModel value);

    DespatchModel getDespatch();

    void setDespatch(DespatchModel value);

    String getId();

    void setId(String value);

}
