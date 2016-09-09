package representation;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe the despatching of goods (their pickup for delivery).
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:28 a. m.
 */
public class DespatchRepresentation{

	/**
	 * The actual despatch (pickup) date.
	 */
	private DateType actualDespatchDate;
	/**
	 * The actual despatch (pickup) time.
	 */
	private TimeType actualDespatchTime;
	/**
	 * The estimated despatch (pickup) date.
	 */
	private DateType estimatedDespatchDate;
	/**
	 * The estimated despatch (pickup) time.
	 */
	private TimeType estimatedDespatchTime;
	/**
	 * The date guaranteed for the despatch (pickup).
	 */
	private DateType guaranteedDespatchDate;
	/**
	 * The time guaranteed for the despatch (pickup).
	 */
	private TimeType guaranteedDespatchTime;
	/**
	 * An identifier for this despatch event.
	 */
	private IdentifierType ID;
	/**
	 * Text describing any special instructions applying to the despatch (pickup).
	 */
	private TextType instructions;
	/**
	 * An identifier for the release of the despatch used as security control or cargo
	 * control (pick-up).
	 */
	private IdentifierType releaseID;
	/**
	 * The despatch (pickup) date requested, normally by the buyer.
	 */
	private DateType requestedDespatchDate;
	/**
	 * The despatch (pickup) time requested, normally by the buyer.
	 */
	private TimeType requestedDespatchTime;
	private AddressRepresentation despatchAddress;
	private List<ContactRepresentation> contacts = new ArrayList<>();
	private LocationRepresentation despatchLocation;
	private PartyRepresentation notifyParty;
	private PartyRepresentation carrierParty;
	private PartyRepresentation despatchParty;
	private PeriodRepresentation requestedDespatchPeriod;
	private PeriodRepresentation estimatedDespatchPeriod;

}
