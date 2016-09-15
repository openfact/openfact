package org.openfact.models.ubl.common;

public interface DeliveryModel {

    String getID();

    void setID(String value);

    QuantityModelCommBas getQuantity();

    void setQuantity(QuantityModelCommBas value);

    MinimumQuantityModel getMinimumQuantity();

    void setMinimumQuantity(MinimumQuantityModel value);

    MaximumQuantityModel getMaximumQuantity();

    void setMaximumQuantity(MaximumQuantityModel value);

    ActualDeliveryDateModel getActualDeliveryDate();

    void setActualDeliveryDate(ActualDeliveryDateModel value);

    ActualDeliveryTimeModel getActualDeliveryTime();

    void setActualDeliveryTime(ActualDeliveryTimeModel value);

    LatestDeliveryDateModel getLatestDeliveryDate();

    void setLatestDeliveryDate(LatestDeliveryDateModel value);

    LatestDeliveryTimeModel getLatestDeliveryTime();

    void setLatestDeliveryTime(LatestDeliveryTimeModel value);

    String getTrackingID();

    void setTrackingID(String value);

    AddressModel getDeliveryAddress();

    void setDeliveryAddress(AddressModel value);

    LocationModelCommAgg getDeliveryLocation();

    void setDeliveryLocation(LocationModelCommAgg value);

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
