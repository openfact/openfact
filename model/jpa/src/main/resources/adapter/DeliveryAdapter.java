package org.openfact.models.jpa.entities.ubl;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe a delivery.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:22 a. m.
 */
public class DeliveryAdapter{

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
	 * The maximum quantity of items, child consignments, shipments in this delivery.
	 */
	private QuantityType maximumQuantity; 
	/**
	 * The minimum quantity of items, child consignments, shipments in this delivery.
	 */
	private QuantityType minimumQuantity; 
	/**
	 * The quantity of items, child consignments, shipments in this delivery.
	 */
	private QuantityType quantity; 
	/**
	 * An identifier used for approval of access to delivery locations (e.g., port
	 * terminals).
	 */
	private IdentifierType releaseID; 
	/**
	 * The delivery Tracking ID (for transport tracking).
	 */
	private IdentifierType trackingID; 
	private AddressAdapter deliveryAddress; 
	private DeliveryUnitAdapter maximumDeliveryUnit; 
	private DeliveryUnitAdapter minimumDeliveryUnit; 
	private List<DespatchAdapter> despatches = new ArrayList<>(); 
	private PeriodAdapter estimatedDeliveryPeriod; 
	private PeriodAdapter promisedDeliveryPeriod; 
	private PeriodAdapter requestedDeliveryPeriod; 
	private LocationAdapter deliveryLocation; 
	private LocationAdapter alternativeDeliveryLocation; 
	private PartyAdapter notifyParty; 
	private PartyAdapter carrierParty; 
	private PartyAdapter deliveryParty; 
	private List<ShipmentAdapter> shipments = new ArrayList<>(); 
	private List<DeliveryTermsAdapter> deliveryTermses = new ArrayList<>(); 

}
