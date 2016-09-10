package org.openfact.models.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
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
public class TransportExecutionPlanRequestModel{

	/**
	 * Indicates whether this document is a copy (true) or not (false).
	 */
	private boolean copyIndicator; 
	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private IdentifierType customizationID; 
	/**
	 * A code signifying the status of the TransportExecutionPlanModel Request.
	 */
	private DocumentStatusCodeType codeTypeDocumentStatusCode; 
	/**
	 * A code signifying a reason associated with the status of the Transport
	 * Execution Plan Request.
	 */
	private CodeType documentStatusReasonCode; 
	/**
	 * A reason associated with the status of the TransportExecutionPlanModel Request.
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
	 * Remarks from the transport user regarding the transport operations referenced
	 * in the TransportExecutionPlanModel Request.
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
	 * An identifier for the current version of the TransportExecutionPlanModel Request.
	 */
	private IdentifierType versionID; 
	private List<ConsignmentModel> consignments = new ArrayList<>(); 
	private ContractModel transportContract; 
	private DocumentReferenceModel transportServiceDescriptionDocumentReference; 
	private DocumentReferenceModel additionalDocumentReference; 
	private DocumentReferenceModel transportExecutionPlanDocumentReference; 
	private LocationModel toLocation; 
	private LocationModel fromLocation; 
	private LocationModel atLocation; 
	private PartyModel transportUserParty; 
	private PartyModel receiverParty; 
	private PartyModel senderParty; 
	private PartyModel transportServiceProviderParty; 
	private PartyModel payeeParty; 
	private PeriodModel serviceEndTimePeriod; 
	private PeriodModel serviceStartTimePeriod; 
	private PeriodModel transportServiceProviderResponseDeadlinePeriod; 
	private List<SignatureModel> signatures = new ArrayList<>(); 
	private List<TransportExecutionTermsModel> transportExecutionTermses = new ArrayList<>(); 
	private TransportationServiceModel mainTransportationService; 
	private TransportationServiceModel additionalTransportationService; 

}
