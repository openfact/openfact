package org.openfact.representations.idm.ubl.common;

import java.time.LocalDate;
import java.time.LocalTime;

public class DeliveryModel {
    protected String ID;
    protected QuantityModel Quantity;
    protected QuantityModel MinimumQuantity;
    protected QuantityModel MaximumQuantity;
    protected LocalDate ActualDeliveryDate;
    protected LocalTime ActualDeliveryTime;
    protected LocalDate LatestDeliveryDate;
    protected LocalTime LatestDeliveryTime;
    protected String TrackingID;
    protected AddressModel DeliveryAddress;
    protected LocationModelCommAgg DeliveryLocation;
    protected PeriodModel RequestedDeliveryPeriod;
    protected PeriodModel PromisedDeliveryPeriod;
    protected PeriodModel EstimatedDeliveryPeriod;
    protected PartyModel DeliveryParty;
    protected DespatchModel Despatch;
    protected String Id;
}