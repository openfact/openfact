package representation;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A document requesting a TransportServiceDescription, sent from a party with a
 * transport demand (transport user) to a party providing transport services
 * (transport service provider).
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:21:44 a. m.
 */
public class TransportServiceDescriptionRequestRepresentation{

	/**
	 * Indicates whether this document is a copy (true) or not (false).
	 */
	private IndicatorType copyIndicator;
	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private IdentifierType customizationID;
	/**
	 * An identifier for this document, assigned by the sender.
	 */
	private IdentifierType ID;
	/**
	 * The date, assigned by the sender, on which this document was issued.
	 */
	private DateType issueDate;
	/**
	 * The time, assigned by the sender, at which this document was issued.
	 */
	private TimeType issueTime;
	/**
	 * Free-form text pertinent to this document, conveying information that is not
	 * contained explicitly in other structures.
	 */
	private TextType note;
	/**
	 * Identifies an instance of executing a profile, to associate all transactions in
	 * a collaboration.
	 */
	private IdentifierType profileExecutionID;
	/**
	 * Identifies a user-defined profile of the customization of UBL being used.
	 */
	private IdentifierType profileID;
	/**
	 * A code signifying the category of service information requested to be provided
	 * in the TransportServiceDescription.
	 */
	private CodeType serviceInformationPreferenceCode;
	/**
	 * Identifies the earliest version of the UBL 2 schema for this document type that
	 * defines all of the elements that might be encountered in the current instance.
	 */
	private IdentifierType UBLVersionID;
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private IdentifierType UUID;
	private PartyRepresentation receiverParty;
	private PartyRepresentation transportServiceProviderParty;
	private PartyRepresentation senderParty;
	private List<SignatureRepresentation> signatures = new ArrayList<>();
	private List<TransportationServiceRepresentation> transportationServices = new ArrayList<>();

}
