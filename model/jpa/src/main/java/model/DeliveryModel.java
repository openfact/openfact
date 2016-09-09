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
	private quantityType maximumquantity;
	/**
	 * The minimum quantity of items, child consignments, shipments in this delivery.
	 */
	private quantityType minimumquantity;
	/**
	 * The quantity of items, child consignments, shipments in this delivery.
	 */
	private quantityType quantity;
	/**
	 * An identifier used for approval of access to delivery locations (e.g., port
	 * terminals).
	 */
	private IdentifierType releaseID;
	/**
	 * The delivery Tracking ID (for transport tracking).
	 */
	private IdentifierType trackingID;
	private AddressModel deliveryAddress;
	private DeliveryUnitModel maximumDeliveryUnit;
	private DeliveryUnitModel minimumDeliveryUnit;
	private List<DespatchModel> despatches = new ArrayList<>();
	private PeriodModel estimatedDeliveryPeriod;
	private PeriodModel promisedDeliveryPeriod;
	private PeriodModel requestedDeliveryPeriod;
	private LocationModel deliveryLocation;
	private LocationModel AlternativedeliveryLocation;
	private PartyModel notifyParty;
	private PartyModel carrierParty;
	private PartyModel deliveryParty;
	private List<ShipmentModel> shipments = new ArrayList<>();
	private List<DeliveryTermsModel> deliveryTermses = new ArrayList<>();

}
