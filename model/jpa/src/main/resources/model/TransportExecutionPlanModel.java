package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
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
	private boolean copyIndicator; 
	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private IdentifierType customizationID; 
	/**
	 * A code signifying the status of the TransportExecutionPlanModel (updated,
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
	private LocalDate issueDate; 
	/**
	 * The time, assigned by the sender, at which this document was issued.
	 */
	private LocalTime issueTime; 
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
	private List<ConsignmentModel> consignments = new ArrayList<>(); 
	private ContractModel transportContract; 
	private DocumentReferenceModel transportExecutionPlanDocumentReference; 
	private DocumentReferenceModel transportExecutionPlanRequestDocumentReference; 
	private DocumentReferenceModel transportServiceDescriptionDocumentReference; 
	private DocumentReferenceModel additionalDocumentReference; 
	private LocationModel toLocation; 
	private LocationModel fromLocation; 
	private LocationModel atLocation; 
	private PartyModel senderParty; 
	private PartyModel transportUserParty; 
	private PartyModel receiverParty; 
	private PartyModel billToParty; 
	private PartyModel transportServiceProviderParty; 
	private PeriodModel serviceStartTimePeriod; 
	private PeriodModel serviceEndTimePeriod; 
	private PeriodModel validityPeriod; 
	private PeriodModel transportUserResponseRequiredPeriod; 
	private PeriodModel transportServiceProviderResponseRequiredPeriod; 
	private List<SignatureModel> signatures = new ArrayList<>(); 
	private List<TransportExecutionTermsModel> transportExecutionTermses = new ArrayList<>(); 
	private TransportationServiceModel additionalTransportationService; 
	private TransportationServiceModel mainTransportationService; 

}
