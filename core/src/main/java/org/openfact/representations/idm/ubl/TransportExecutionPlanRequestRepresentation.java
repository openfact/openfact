package org.openfact.representations.idm.ubl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeType;
import org.openfact.representations.idm.ubl.type.DocumentStatusCodeType;
import org.openfact.representations.idm.ubl.type.IdentifierType;
import org.openfact.representations.idm.ubl.type.TextType;

/**
 * A document sent by a transport user to request a transport service from a
 * transport service provider.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:21:38 a. m.
 */
public class TransportExecutionPlanRequestRepresentation {

    /**
     * Indicates whether this document is a copy (true) or not (false).
     */
    private boolean copyIndicator;
    /**
     * Identifies a user-defined customization of UBL for a specific use.
     */
    private IdentifierType customizationID;
    /**
     * A code signifying the status of the TransportExecutionPlanRepresentation
     * Request.
     */
    private DocumentStatusCodeType codeTypeDocumentStatusCode;
    /**
     * A code signifying a reason associated with the status of the Transport
     * Execution Plan Request.
     */
    private CodeType documentStatusReasonCode;
    /**
     * A reason associated with the status of the
     * TransportExecutionPlanRepresentation Request.
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
     * Free-form text pertinent to this document, conveying information that is
     * not contained explicitly in other structures.
     */
    private TextType note;
    /**
     * Identifies an instance of executing a profile, to associate all
     * transactions in a collaboration.
     */
    private IdentifierType profileExecutionID;
    /**
     * Identifies a user-defined profile of the customization of UBL being used.
     */
    private IdentifierType profileID;
    /**
     * Remarks from the transport user regarding the transport operations
     * referenced in the TransportExecutionPlanRepresentation Request.
     */
    private TextType transportUserRemarks;
    /**
     * Identifies the earliest version of the UBL 2 schema for this document
     * type that defines all of the elements that might be encountered in the
     * current instance.
     */
    private IdentifierType UBLVersionID;
    /**
     * A universally unique identifier for an instance of this document.
     */
    private IdentifierType UUID;
    /**
     * An identifier for the current version of the
     * TransportExecutionPlanRepresentation Request.
     */
    private IdentifierType versionID;
    private List<ConsignmentRepresentation> consignments = new ArrayList<>();
    private ContractRepresentation transportContract;
    private DocumentReferenceRepresentation transportServiceDescriptionDocumentReference;
    private DocumentReferenceRepresentation additionalDocumentReference;
    private DocumentReferenceRepresentation transportExecutionPlanDocumentReference;
    private LocationRepresentation toLocation;
    private LocationRepresentation fromLocation;
    private LocationRepresentation atLocation;
    private PartyRepresentation transportUserParty;
    private PartyRepresentation receiverParty;
    private PartyRepresentation senderParty;
    private PartyRepresentation transportServiceProviderParty;
    private PartyRepresentation payeeParty;
    private PeriodRepresentation serviceEndTimePeriod;
    private PeriodRepresentation serviceStartTimePeriod;
    private PeriodRepresentation transportServiceProviderResponseDeadlinePeriod;
    private List<SignatureRepresentation> signatures = new ArrayList<>();
    private List<TransportExecutionTermsRepresentation> transportExecutionTermses = new ArrayList<>();
    private TransportationServiceRepresentation mainTransportationService;
    private TransportationServiceRepresentation additionalTransportationService;

}