package model;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A document used in the negotiation of a transport service between a transport
 * user and a transport service provider.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:21:37 a. m.
 */
public class TransportExecutionPlanModel{

	/**
	 * Indicates whether this document is a copy (true) or not (false).
	 */
	private IndicatorType CopyIndicator;
	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private IdentifierType CustomizationID;
	/**
	 * A code signifying the status of the TransportExecutionPlanModel (updated,
	 * cancelled, confirmed, etc.)
	 */
	private DocumentStatusCodeType CodeTypeDocumentStatusCode;
	/**
	 * A code signifying a reason associated with the status of a Transport Execution
	 * Plan.
	 */
	private CodeType DocumentStatusReasonCode;
	/**
	 * A reason for the status assigned to the TransportExecutionPlan, expressed in
	 * text.
	 */
	private TextType DocumentStatusReasonDescription;
	/**
	 * An identifier for this document, assigned by the sender.
	 */
	private IdentifierType ID;
	/**
	 * The date, assigned by the sender, on which this document was issued.
	 */
	private DateType IssueDate;
	/**
	 * The time, assigned by the sender, at which this document was issued.
	 */
	private TimeType IssueTime;
	/**
	 * Free-form text pertinent to this document, conveying information that is not
	 * contained explicitly in other structures.
	 */
	private TextType Note;
	/**
	 * Identifies an instance of executing a profile, to associate all transactions in
	 * a collaboration.
	 */
	private IdentifierType ProfileExecutionID;
	/**
	 * Identifies a user-defined profile of the customization of UBL being used.
	 */
	private IdentifierType ProfileID;
	/**
	 * Remarks from the transport service provider regarding the transport operations
	 * referred to in the TransportExecutionPlan.
	 */
	private TextType TransportServiceProviderRemarks;
	/**
	 * Remarks from the transport user regarding the transport operations referred to
	 * in the TransportExecutionPlan.
	 */
	private TextType TransportUserRemarks;
	/**
	 * Identifies the earliest version of the UBL 2 schema for this document type that
	 * defines all of the elements that might be encountered in the current instance.
	 */
	private IdentifierType UBLVersionID;
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private IdentifierType UUID;
	/**
	 * Indicates the current version of the TransportExecutionPlan.
	 */
	private IdentifierType VersionID;
	private List<ConsignmentModel> Consignments = new ArrayList<>();
	private ContractModel TransportContract;
	private DocumentReferenceModel TransportExecutionPlanDocumentReference;
	private DocumentReferenceModel TransportExecutionPlanRequestDocumentReference;
	private DocumentReferenceModel TransportServiceDescriptionDocumentReference;
	private DocumentReferenceModel AdditionalDocumentReference;
	private LocationModel ToLocation;
	private LocationModel FromLocation;
	private LocationModel AtLocation;
	private PartyModel SenderParty;
	private PartyModel TransportUserParty;
	private PartyModel ReceiverParty;
	private PartyModel BillToParty;
	private PartyModel TransportServiceProviderParty;
	private PeriodModel ServiceStartTimePeriod;
	private PeriodModel ServiceEndTimePeriod;
	private PeriodModel ValidityPeriod;
	private PeriodModel TransportUserResponseRequiredPeriod;
	private PeriodModel TransportServiceProviderResponseRequiredPeriod;
	private List<SignatureModel> Signatures = new ArrayList<>();
	private List<TransportExecutionTermsModel> TransportExecutionTermses = new ArrayList<>();
	private TransportationServiceModel AdditionalTransportationService;
	private TransportationServiceModel MainTransportationService;

}
