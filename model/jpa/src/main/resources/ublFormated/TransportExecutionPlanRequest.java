package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
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
public class TransportExecutionPlanRequest{

	/**
	 * Indicates whether this document is a copy (true) or not (false).
	 */
	private boolean CopyIndicator;
	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private IdentifierType CustomizationID;
	/**
	 * A code signifying the status of the TransportExecutionPlan Request.
	 */
	private DocumentStatusCodeType CodeTypeDocumentStatusCode;
	/**
	 * A code signifying a reason associated with the status of the Transport
	 * Execution Plan Request.
	 */
	private CodeType DocumentStatusReasonCode;
	/**
	 * A reason associated with the status of the TransportExecutionPlan Request.
	 */
	private TextType DocumentStatusReasonDescription;
	/**
	 * An identifier for this document, assigned by the sender.
	 */
	private IdentifierType ID;
	/**
	 * The date, assigned by the sender, on which this document was issued.
	 */
	private LocalDate IssueDate;
	/**
	 * The time, assigned by the sender, at which this document was issued.
	 */
	private LocalTime IssueTime;
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
	 * Remarks from the transport user regarding the transport operations referenced
	 * in the TransportExecutionPlan Request.
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
	 * An identifier for the current version of the TransportExecutionPlan Request.
	 */
	private IdentifierType VersionID;
	private List<Consignment> Consignments = new ArrayList<>();
	private Contract TransportContract;
	private DocumentReference TransportServiceDescriptionDocumentReference;
	private DocumentReference AdditionalDocumentReference;
	private DocumentReference TransportExecutionPlanDocumentReference;
	private Location ToLocation;
	private Location FromLocation;
	private Location AtLocation;
	private Party TransportUserParty;
	private Party ReceiverParty;
	private Party SenderParty;
	private Party TransportServiceProviderParty;
	private Party PayeeParty;
	private Period ServiceEndTimePeriod;
	private Period ServiceStartTimePeriod;
	private Period TransportServiceProviderResponseDeadlinePeriod;
	private List<Signature> Signatures = new ArrayList<>();
	private List<TransportExecutionTerms> TransportExecutionTermses = new ArrayList<>();
	private TransportationService MainTransportationService;
	private TransportationService AdditionalTransportationService;

}
