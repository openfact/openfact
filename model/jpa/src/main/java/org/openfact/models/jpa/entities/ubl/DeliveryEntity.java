package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.DateType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.QuantityType;
import org.openfact.models.jpa.entities.ublType.TimeType;

/**
 * A class to describe a delivery.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:22 a. m.
 */
public class DeliveryEntity {

    /**
     * The actual date of delivery.
     */
    private DateType ActualDeliveryDate;
    /**
     * The actual time of delivery.
     */
    private TimeType ActualDeliveryTime;
    /**
     * An identifier for this delivery.
     */
    private IdentifierType ID;
    /**
     * The latest date of delivery allowed by the buyer.
     */
    private DateType LatestDeliveryDate;
    /**
     * The latest time of delivery allowed by the buyer.
     */
    private TimeType LatestDeliveryTime;
    /**
     * The maximum quantity of items, child consignments, shipments in this
     * delivery.
     */
    private QuantityType MaximumQuantity;
    /**
     * The minimum quantity of items, child consignments, shipments in this
     * delivery.
     */
    private QuantityType MinimumQuantity;
    /**
     * The quantity of items, child consignments, shipments in this delivery.
     */
    private QuantityType Quantity;
    /**
     * An identifier used for approval of access to delivery locations (e.g.,
     * port terminals).
     */
    private IdentifierType ReleaseID;
    /**
     * The delivery Tracking ID (for transport tracking).
     */
    private IdentifierType TrackingID;
    private AddressEntity DeliveryAddress;
    private DeliveryUnitEntity MaximumDeliveryUnit;
    private DeliveryUnitEntity MinimumDeliveryUnit;
    private List<DespatchEntity> Despatches = new ArrayList<>();
    private PeriodEntity EstimatedDeliveryPeriod;
    private PeriodEntity PromisedDeliveryPeriod;
    private PeriodEntity RequestedDeliveryPeriod;
    private LocationEntity DeliveryLocation;
    private LocationEntity AlternativeDeliveryLocation;
    private PartyEntity NotifyParty;
    private PartyEntity CarrierParty;
    private PartyEntity DeliveryParty;
    private List<ShipmentEntity> Shipments = new ArrayList<>();
    private List<DeliveryTermsEntity> DeliveryTermses = new ArrayList<>();

}
