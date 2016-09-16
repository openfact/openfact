package org.openfact.representations.idm.ubl.common;

import java.time.LocalDate;
import java.time.LocalTime;

public class DeliveryRepresentation {
    private String ID;
    private QuantityRepresentation quantity;
    private QuantityRepresentation minimumQuantity;
    private QuantityRepresentation maximumQuantity;
    private LocalDate actualDeliveryDate;
    private LocalTime actualDeliveryTime;
    private LocalDate latestDeliveryDate;
    private LocalTime latestDeliveryTime;
    private String trackingID;
    private AddressRepresentation deliveryAddress;
    private LocationRepresentationCommAgg deliveryLocation;
    private PeriodRepresentation requestedDeliveryPeriod;
    private PeriodRepresentation promisedDeliveryPeriod;
    private PeriodRepresentation estimatedDeliveryPeriod;
    private PartyRepresentation deliveryParty;
    private DespatchRepresentation despatch;
    private String id;
}
