package org.openfact.models.ubl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A document used in the negotiation of a transport service between a transport
 * user and a transport service provider.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:21:37 a. m.
 */
public class TransportExecutionPlanModel {

    /**
     * Indicates whether this document is a copy (true) or not (false).
     */
    private boolean copyIndicator;
    /**
     * Identifies a user-defined customization of UBL for a specific use.
     */
    private IdentifierModel customizationID;
    /**
     * A code signifying the status of the TransportExecutionPlanModel (updated,
     * cancelled, confirmed, etc.)
     */
    private DocumentStatusCodeModel codeTypeDocumentStatusCode;
    /**
     * A code signifying a reason associated with the status of a Transport
     * Execution Plan.
     */
    private CodeModel documentStatusReasonCode;
    /**
     * A reason for the status assigned to the TransportExecutionPlan, expressed
     * in text.
     */
    private TextModel documentStatusReasonDescription;
    /**
     * An identifier for this document, assigned by the sender.
     */
    private IdentifierModel ID;
    /**
     * The date, assigned by the sender, on which this document was issued.
     */
    private LocalDate issueDate;
    /**
     * The time, assigned by the sender, at which this document was issued.
     */
    private LocalTime issueTime;
    /**
     * Free-form text pertinent to this document, conveying information that is
     * not contained explicitly in other structures.
     */
    private TextModel note;
    /**
     * Identifies an instance of executing a profile, to associate all
     * transactions in a collaboration.
     */
    private IdentifierModel profileExecutionID;
    /**
     * Identifies a user-defined profile of the customization of UBL being used.
     */
    private IdentifierModel profileID;
    /**
     * Remarks from the transport service provider regarding the transport
     * operations referred to in the TransportExecutionPlan.
     */
    private TextModel transportServiceProviderRemarks;
    /**
     * Remarks from the transport user regarding the transport operations
     * referred to in the TransportExecutionPlan.
     */
    private TextModel transportUserRemarks;
    /**
     * Identifies the earliest version of the UBL 2 schema for this document
     * type that defines all of the elements that might be encountered in the
     * current instance.
     */
    private IdentifierModel UBLVersionID;
    /**
     * A universally unique identifier for an instance of this document.
     */
    private IdentifierModel UUID;
    /**
     * Indicates the current version of the TransportExecutionPlan.
     */
    private IdentifierModel versionID;
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
