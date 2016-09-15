package org.openfact.models.ubl.common;

public interface DeliveryType {

    IDType getID();

    void setID(IDType value);

    QuantityTypeCommBas getQuantity();

    void setQuantity(QuantityTypeCommBas value);

    MinimumQuantityType getMinimumQuantity();

    void setMinimumQuantity(MinimumQuantityType value);

    MaximumQuantityType getMaximumQuantity();

    void setMaximumQuantity(MaximumQuantityType value);

    ActualDeliveryDateType getActualDeliveryDate();

    void setActualDeliveryDate(ActualDeliveryDateType value);

    ActualDeliveryTimeType getActualDeliveryTime();

    void setActualDeliveryTime(ActualDeliveryTimeType value);

    LatestDeliveryDateType getLatestDeliveryDate();

    void setLatestDeliveryDate(LatestDeliveryDateType value);

    LatestDeliveryTimeType getLatestDeliveryTime();

    void setLatestDeliveryTime(LatestDeliveryTimeType value);

    TrackingIDType getTrackingID();

    void setTrackingID(TrackingIDType value);

    AddressType getDeliveryAddress();

    void setDeliveryAddress(AddressType value);

    LocationTypeCommAgg getDeliveryLocation();

    void setDeliveryLocation(LocationTypeCommAgg value);

    PeriodType getRequestedDeliveryPeriod();

    void setRequestedDeliveryPeriod(PeriodType value);

    PeriodType getPromisedDeliveryPeriod();

    void setPromisedDeliveryPeriod(PeriodType value);

    PeriodType getEstimatedDeliveryPeriod();

    void setEstimatedDeliveryPeriod(PeriodType value);

    PartyType getDeliveryParty();

    void setDeliveryParty(PartyType value);

    DespatchType getDespatch();

    void setDespatch(DespatchType value);

    String getId();

    void setId(String value);

}
