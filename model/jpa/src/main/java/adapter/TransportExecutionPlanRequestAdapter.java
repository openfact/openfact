package adapter;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A document sent by a transport user to request a transport service from a
 * transport service provider.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:21:38 a. m.
 */
public class TransportExecutionPlanRequestAdapter{

	/**
	 * Indicates whether this document is a copy (true) or not (false).
	 */
	private IndicatorType copyIndicator;
	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private IdentifierType customizationID;
	/**
	 * A code signifying the status of the TransportExecutionPlanAdapter Request.
	 */
	private DocumentStatusCodeType codeTypeDocumentStatusCode;
	/**
	 * A code signifying a reason associated with the status of the Transport
	 * Execution Plan Request.
	 */
	private CodeType documentStatusReasonCode;
	/**
	 * A reason associated with the status of the TransportExecutionPlanAdapter Request.
	 */
	private TextType documentStatusReasonDescription;
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
	 * Remarks from the transport user regarding the transport operations referenced
	 * in the TransportExecutionPlanAdapter Request.
	 */
	private TextType transportUserRemarks;
	/**
	 * Identifies the earliest version of the UBL 2 schema for this document type that
	 * defines all of the elements that might be encountered in the current instance.
	 */
	private IdentifierType UBLversionID;
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private IdentifierType UUID;
	/**
	 * An identifier for the current version of the TransportExecutionPlanAdapter Request.
	 */
	private IdentifierType versionID;
	private List<ConsignmentAdapter> consignments = new ArrayList<>();
	private ContractAdapter transportContract;
	private DocumentReferenceAdapter transportServiceDescriptionDocumentReference;
	private DocumentReferenceAdapter additionalDocumentReference;
	private DocumentReferenceAdapter transportExecutionPlanDocumentReference;
	private LocationAdapter toLocation;
	private LocationAdapter fromLocation;
	private LocationAdapter atLocation;
	private PartyAdapter transportUserParty;
	private PartyAdapter receiverParty;
	private PartyAdapter senderParty;
	private PartyAdapter transportServiceProviderParty;
	private PartyAdapter payeeParty;
	private PeriodAdapter serviceEndTimePeriod;
	private PeriodAdapter serviceStartTimePeriod;
	private PeriodAdapter transportServiceProviderResponseDeadlinePeriod;
	private List<SignatureAdapter> signatures = new ArrayList<>();
	private List<TransportExecutionTermsAdapter> transportExecutionTermses = new ArrayList<>();
	private TransportationServiceAdapter mainTransportationService;
	private TransportationServiceAdapter additionalTransportationService;

}
