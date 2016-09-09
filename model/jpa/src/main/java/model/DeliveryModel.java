package model;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe a delivery.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:22 a. m.
 */
public class DeliveryModel{

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
	private AddressModel DeliveryAddress;
	private DeliveryUnitModel MaximumDeliveryUnit;
	private DeliveryUnitModel MinimumDeliveryUnit;
	private List<DespatchModel> Despatches = new ArrayList<>();
	private PeriodModel EstimatedDeliveryPeriod;
	private PeriodModel PromisedDeliveryPeriod;
	private PeriodModel RequestedDeliveryPeriod;
	private LocationModel DeliveryLocation;
	private LocationModel AlternativeDeliveryLocation;
	private PartyModel NotifyParty;
	private PartyModel CarrierParty;
	private PartyModel DeliveryParty;
	private List<ShipmentModel> Shipments = new ArrayList<>();
	private List<DeliveryTermsModel> DeliveryTermses = new ArrayList<>();

}
