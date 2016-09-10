package org.openfact.representations.idm.ubl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.IdentifierType;
import org.openfact.representations.idm.ubl.type.QuantityType;

/**
 * A class to describe a delivery.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:22 a. m.
 */
public class DeliveryRepresentation {

    /**
     * The actual date of delivery.
     */
    private LocalDate actualDeliveryDate;
    /**
     * The actual time of delivery.
     */
    private LocalTime actualDeliveryTime;
    /**
     * An identifier for this delivery.
     */
    private IdentifierType ID;
    /**
     * The latest date of delivery allowed by the buyer.
     */
    private LocalDate latestDeliveryDate;
    /**
     * The latest time of delivery allowed by the buyer.
     */
    private LocalTime latestDeliveryTime;
    /**
     * The maximum quantity of items, child consignments, shipments in this
     * delivery.
     */
    private QuantityType maximumQuantity;
    /**
     * The minimum quantity of items, child consignments, shipments in this
     * delivery.
     */
    private QuantityType minimumQuantity;
    /**
     * The quantity of items, child consignments, shipments in this delivery.
     */
    private QuantityType quantity;
    /**
     * An identifier used for approval of access to delivery locations (e.g.,
     * port terminals).
     */
    private IdentifierType releaseID;
    /**
     * The delivery Tracking ID (for transport tracking).
     */
    private IdentifierType trackingID;
    private AddressRepresentation deliveryAddress;
    private DeliveryUnitRepresentation maximumDeliveryUnit;
    private DeliveryUnitRepresentation minimumDeliveryUnit;
    private List<DespatchRepresentation> despatches = new ArrayList<>();
    private PeriodRepresentation estimatedDeliveryPeriod;
    private PeriodRepresentation promisedDeliveryPeriod;
    private PeriodRepresentation requestedDeliveryPeriod;
    private LocationRepresentation deliveryLocation;
    private LocationRepresentation alternativeDeliveryLocation;
    private PartyRepresentation notifyParty;
    private PartyRepresentation carrierParty;
    private PartyRepresentation deliveryParty;
    private List<ShipmentRepresentation> shipments = new ArrayList<>();
    private List<DeliveryTermsRepresentation> deliveryTermses = new ArrayList<>();

}
