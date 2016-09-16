package org.openfact.representations.idm.ubl.common;

import java.time.LocalDate;
import java.time.LocalTime;

public class DeliveryRepresentation {
    private String ID;
    private QuantityRepresentation Quantity;
    private QuantityRepresentation MinimumQuantity;
    private QuantityRepresentation MaximumQuantity;
    private LocalDate ActualDeliveryDate;
    private LocalTime ActualDeliveryTime;
    private LocalDate LatestDeliveryDate;
    private LocalTime LatestDeliveryTime;
    private String TrackingID;
    private AddressRepresentation DeliveryAddress;
    private LocationRepresentationCommAgg DeliveryLocation;
    private PeriodRepresentation RequestedDeliveryPeriod;
    private PeriodRepresentation PromisedDeliveryPeriod;
    private PeriodRepresentation EstimatedDeliveryPeriod;
    private PartyRepresentation DeliveryParty;
    private DespatchRepresentation Despatch;
    private String Id;
}