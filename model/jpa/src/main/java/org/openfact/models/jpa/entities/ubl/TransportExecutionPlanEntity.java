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
public class TransportExecutionPlanEntity{

	/**
	 * Indicates whether this document is a copy (true) or not (false).
	 */
	private IndicatorType copyIndicator; 
	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private IdentifierType customizationID; 
	/**
	 * A code signifying the status of the TransportExecutionPlanEntity (updated,
	 * cancelled, confirmed, etc.)
	 */
	private DocumentStatusCodeType codeTypeDocumentStatusCode; 
	/**
	 * A code signifying a reason associated with the status of a Transport Execution
	 * Plan.
	 */
	private CodeType documentStatusReasonCode; 
	/**
	 * A reason for the status assigned to the TransportExecutionPlan, expressed in
	 * text.
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
	 * Remarks from the transport service provider regarding the transport operations
	 * referred to in the TransportExecutionPlan.
	 */
	private TextType transportServiceProviderRemarks; 
	/**
	 * Remarks from the transport user regarding the transport operations referred to
	 * in the TransportExecutionPlan.
	 */
	private TextType transportUserRemarks; 
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
	private IdentifierType versionID; 
	private List<ConsignmentEntity> consignments = new ArrayList<>(); 
	private ContractEntity transportContract; 
	private DocumentReferenceEntity transportExecutionPlanDocumentReference; 
	private DocumentReferenceEntity transportExecutionPlanRequestDocumentReference; 
	private DocumentReferenceEntity transportServiceDescriptionDocumentReference; 
	private DocumentReferenceEntity additionalDocumentReference; 
	private LocationEntity toLocation; 
	private LocationEntity fromLocation; 
	private LocationEntity atLocation; 
	private PartyEntity senderParty; 
	private PartyEntity transportUserParty; 
	private PartyEntity receiverParty; 
	private PartyEntity billToParty; 
	private PartyEntity transportServiceProviderParty; 
	private PeriodEntity serviceStartTimePeriod; 
	private PeriodEntity serviceEndTimePeriod; 
	private PeriodEntity validityPeriod; 
	private PeriodEntity transportUserResponseRequiredPeriod; 
	private PeriodEntity transportServiceProviderResponseRequiredPeriod; 
	private List<SignatureEntity> signatures = new ArrayList<>(); 
	private List<TransportExecutionTermsEntity> transportExecutionTermses = new ArrayList<>(); 
	private TransportationServiceEntity additionalTransportationService; 
	private TransportationServiceEntity mainTransportationService; 

}
