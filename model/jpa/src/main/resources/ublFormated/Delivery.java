package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe a delivery.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:22 a. m.
 */
public class Delivery{

	/**
	 * The actual date of delivery.
	 */
	private LocalDate ActualDeliveryDate;
	/**
	 * The actual time of delivery.
	 */
	private LocalTime ActualDeliveryTime;
	/**
	 * An identifier for this delivery.
	 */
	private IdentifierType ID;
	/**
	 * The latest date of delivery allowed by the buyer.
	 */
	private LocalDate LatestDeliveryDate;
	/**
	 * The latest time of delivery allowed by the buyer.
	 */
	private LocalTime LatestDeliveryTime;
	/**
	 * The maximum quantity of items, child consignments, shipments in this delivery.
	 */
	private QuantityType MaximumQuantity;
	/**
	 * The minimum quantity of items, child consignments, shipments in this delivery.
	 */
	private QuantityType MinimumQuantity;
	/**
	 * The quantity of items, child consignments, shipments in this delivery.
	 */
	private QuantityType Quantity;
	/**
	 * An identifier used for approval of access to delivery locations (e.g., port
	 * terminals).
	 */
	private IdentifierType ReleaseID;
	/**
	 * The delivery Tracking ID (for transport tracking).
	 */
	private IdentifierType TrackingID;
	private Address DeliveryAddress;
	private DeliveryUnit MaximumDeliveryUnit;
	private DeliveryUnit MinimumDeliveryUnit;
	private List<Despatch> Despatches = new ArrayList<>();
	private Period EstimatedDeliveryPeriod;
	private Period PromisedDeliveryPeriod;
	private Period RequestedDeliveryPeriod;
	private Location DeliveryLocation;
	private Location AlternativeDeliveryLocation;
	private Party NotifyParty;
	private Party CarrierParty;
	private Party DeliveryParty;
	private List<Shipment> Shipments = new ArrayList<>();
	private List<DeliveryTerms> DeliveryTermses = new ArrayList<>();

}
