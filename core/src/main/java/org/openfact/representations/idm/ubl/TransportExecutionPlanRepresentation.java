package org.openfact.representations.idm.ubl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.DocumentStatusCodeRepresentation;
import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A document used in the negotiation of a transport service between a transport
 * user and a transport service provider.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:21:37 a. m.
 */
public class TransportExecutionPlanRepresentation {

    /**
     * Indicates whether this document is a copy (true) or not (false).
     */
    private boolean copyIndicator;
    /**
     * Identifies a user-defined customization of UBL for a specific use.
     */
    private IdentifierRepresentation customizationID;
    /**
     * A code signifying the status of the TransportExecutionPlanRepresentation
     * (updated, cancelled, confirmed, etc.)
     */
    private DocumentStatusCodeRepresentation codeTypeDocumentStatusCode;
    /**
     * A code signifying a reason associated with the status of a Transport
     * Execution Plan.
     */
    private CodeRepresentation documentStatusReasonCode;
    /**
     * A reason for the status assigned to the TransportExecutionPlan, expressed
     * in text.
     */
    private TextRepresentation documentStatusReasonDescription;
    /**
     * An identifier for this document, assigned by the sender.
     */
    private IdentifierRepresentation ID;
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
    private TextRepresentation note;
    /**
     * Identifies an instance of executing a profile, to associate all
     * transactions in a collaboration.
     */
    private IdentifierRepresentation profileExecutionID;
    /**
     * Identifies a user-defined profile of the customization of UBL being used.
     */
    private IdentifierRepresentation profileID;
    /**
     * Remarks from the transport service provider regarding the transport
     * operations referred to in the TransportExecutionPlan.
     */
    private TextRepresentation transportServiceProviderRemarks;
    /**
     * Remarks from the transport user regarding the transport operations
     * referred to in the TransportExecutionPlan.
     */
    private TextRepresentation transportUserRemarks;
    /**
     * Identifies the earliest version of the UBL 2 schema for this document
     * type that defines all of the elements that might be encountered in the
     * current instance.
     */
    private IdentifierRepresentation UBLVersionID;
    /**
     * A universally unique identifier for an instance of this document.
     */
    private IdentifierRepresentation UUID;
    /**
     * Indicates the current version of the TransportExecutionPlan.
     */
    private IdentifierRepresentation versionID;
    private List<ConsignmentRepresentation> consignments = new ArrayList<>();
    private ContractRepresentation transportContract;
    private DocumentReferenceRepresentation transportExecutionPlanDocumentReference;
    private DocumentReferenceRepresentation transportExecutionPlanRequestDocumentReference;
    private DocumentReferenceRepresentation transportServiceDescriptionDocumentReference;
    private DocumentReferenceRepresentation additionalDocumentReference;
    private LocationRepresentation toLocation;
    private LocationRepresentation fromLocation;
    private LocationRepresentation atLocation;
    private PartyRepresentation senderParty;
    private PartyRepresentation transportUserParty;
    private PartyRepresentation receiverParty;
    private PartyRepresentation billToParty;
    private PartyRepresentation transportServiceProviderParty;
    private PeriodRepresentation serviceStartTimePeriod;
    private PeriodRepresentation serviceEndTimePeriod;
    private PeriodRepresentation validityPeriod;
    private PeriodRepresentation transportUserResponseRequiredPeriod;
    private PeriodRepresentation transportServiceProviderResponseRequiredPeriod;
    private List<SignatureRepresentation> signatures = new ArrayList<>();
    private List<TransportExecutionTermsRepresentation> transportExecutionTermses = new ArrayList<>();
    private TransportationServiceRepresentation additionalTransportationService;
    private TransportationServiceRepresentation mainTransportationService;

}
