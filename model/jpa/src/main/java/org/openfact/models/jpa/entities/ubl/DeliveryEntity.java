package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.DateType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.quantityType;
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
    private DateType actualDeliveryDate;
    /**
     * The actual time of delivery.
     */
    private TimeType actualDeliveryTime;
    /**
     * An identifier for this delivery.
     */
    private IdentifierType ID;
    /**
     * The latest date of delivery allowed by the buyer.
     */
    private DateType latestDeliveryDate;
    /**
     * The latest time of delivery allowed by the buyer.
     */
    private TimeType latestDeliveryTime;
    /**
     * The maximum quantity of items, child consignments, shipments in this
     * delivery.
     */
    private quantityType maximumquantity;
    /**
     * The minimum quantity of items, child consignments, shipments in this
     * delivery.
     */
    private quantityType minimumquantity;
    /**
     * The quantity of items, child consignments, shipments in this delivery.
     */
    private quantityType quantity;
    /**
     * An identifier used for approval of access to delivery locations (e.g.,
     * port terminals).
     */
    private IdentifierType releaseID;
    /**
     * The delivery Tracking ID (for transport tracking).
     */
    private IdentifierType trackingID;
    private AddressEntity deliveryAddress;
    private DeliveryUnitEntity maximumDeliveryUnit;
    private DeliveryUnitEntity minimumDeliveryUnit;
    private List<DespatchEntity> despatches = new ArrayList<>();
    private PeriodEntity estimatedDeliveryPeriod;
    private PeriodEntity promisedDeliveryPeriod;
    private PeriodEntity requestedDeliveryPeriod;
    private LocationEntity deliveryLocation;
    private LocationEntity AlternativedeliveryLocation;
    private PartyEntity notifyParty;
    private PartyEntity carrierParty;
    private PartyEntity deliveryParty;
    private List<ShipmentEntity> shipments = new ArrayList<>();
    private List<DeliveryTermsEntity> deliveryTermses = new ArrayList<>();

}
