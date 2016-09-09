package org.openfact.models.jpa.entities.ubl;
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
public class TransportExecutionPlan{

	/**
	 * Indicates whether this document is a copy (true) or not (false).
	 */
	private IndicatorType CopyIndicator;
	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private IdentifierType CustomizationID;
	/**
	 * A code signifying the status of the TransportExecutionPlan (updated,
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
	private List<Consignment> Consignments = new ArrayList<>();
	private Contract TransportContract;
	private DocumentReference TransportExecutionPlanDocumentReference;
	private DocumentReference TransportExecutionPlanRequestDocumentReference;
	private DocumentReference TransportServiceDescriptionDocumentReference;
	private DocumentReference AdditionalDocumentReference;
	private Location ToLocation;
	private Location FromLocation;
	private Location AtLocation;
	private Party SenderParty;
	private Party TransportUserParty;
	private Party ReceiverParty;
	private Party BillToParty;
	private Party TransportServiceProviderParty;
	private Period ServiceStartTimePeriod;
	private Period ServiceEndTimePeriod;
	private Period ValidityPeriod;
	private Period TransportUserResponseRequiredPeriod;
	private Period TransportServiceProviderResponseRequiredPeriod;
	private List<Signature> Signatures = new ArrayList<>();
	private List<TransportExecutionTerms> TransportExecutionTermses = new ArrayList<>();
	private TransportationService AdditionalTransportationService;
	private TransportationService MainTransportationService;

}
