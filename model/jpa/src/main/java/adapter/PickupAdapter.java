package adapter;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe a pickup for delivery.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:16:49 a. m.
 */
public class PickupAdapter{

	/**
	 * The actual pickup date.
	 */
	private DateType actualPickupDate;
	/**
	 * The actual pickup time.
	 */
	private TimeType actualPickupTime;
	/**
	 * The earliest pickup date.
	 */
	private DateType earliestPickupDate;
	/**
	 * The earliest pickup time.
	 */
	private TimeType earliestPickupTime;
	/**
	 * An identifier for this pickup.
	 */
	private IdentifierType ID;
	/**
	 * The latest pickup date.
	 */
	private DateType latestPickupDate;
	/**
	 * The latest pickup time.
	 */
	private TimeType latestPickupTime;
	private LocationAdapter pickupLocation;
	private PartyAdapter pickupParty;

}
