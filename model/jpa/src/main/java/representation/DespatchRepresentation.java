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
	private DateType ActualDespatchDate;
	/**
	 * The actual despatch (pickup) time.
	 */
	private TimeType ActualDespatchTime;
	/**
	 * The estimated despatch (pickup) date.
	 */
	private DateType EstimatedDespatchDate;
	/**
	 * The estimated despatch (pickup) time.
	 */
	private TimeType EstimatedDespatchTime;
	/**
	 * The date guaranteed for the despatch (pickup).
	 */
	private DateType GuaranteedDespatchDate;
	/**
	 * The time guaranteed for the despatch (pickup).
	 */
	private TimeType GuaranteedDespatchTime;
	/**
	 * An identifier for this despatch event.
	 */
	private IdentifierType ID;
	/**
	 * Text describing any special instructions applying to the despatch (pickup).
	 */
	private TextType Instructions;
	/**
	 * An identifier for the release of the despatch used as security control or cargo
	 * control (pick-up).
	 */
	private IdentifierType ReleaseID;
	/**
	 * The despatch (pickup) date requested, normally by the buyer.
	 */
	private DateType RequestedDespatchDate;
	/**
	 * The despatch (pickup) time requested, normally by the buyer.
	 */
	private TimeType RequestedDespatchTime;
	private AddressRepresentation DespatchAddress;
	private List<ContactRepresentation> Contacts = new ArrayList<>();
	private LocationRepresentation DespatchLocation;
	private PartyRepresentation NotifyParty;
	private PartyRepresentation CarrierParty;
	private PartyRepresentation DespatchParty;
	private PeriodRepresentation RequestedDespatchPeriod;
	private PeriodRepresentation EstimatedDespatchPeriod;

}
