package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.DateType;
import org.openfact.models.jpa.entities.ublType.DocumentStatusCodeType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.IndicatorType;
import org.openfact.models.jpa.entities.ublType.TextType;
import org.openfact.models.jpa.entities.ublType.TimeType;

/**
 * A document sent by a transport user to request a transport service from a
 * transport service provider.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:21:38 a. m.
 */
public class TransportExecutionPlanRequestEntity {

    /**
     * Indicates whether this document is a copy (true) or not (false).
     */
    private IndicatorType CopyIndicator;
    /**
     * Identifies a user-defined customization of UBL for a specific use.
     */
    private IdentifierType CustomizationID;
    /**
     * A code signifying the status of the TransportExecutionPlanEntity Request.
     */
    private DocumentStatusCodeType CodeTypeDocumentStatusCode;
    /**
     * A code signifying a reason associated with the status of the Transport
     * Execution Plan Request.
     */
    private CodeType DocumentStatusReasonCode;
    /**
     * A reason associated with the status of the TransportExecutionPlanEntity
     * Request.
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
     * Free-form text pertinent to this document, conveying information that is
     * not contained explicitly in other structures.
     */
    private TextType Note;
    /**
     * Identifies an instance of executing a profile, to associate all
     * transactions in a collaboration.
     */
    private IdentifierType ProfileExecutionID;
    /**
     * Identifies a user-defined profile of the customization of UBL being used.
     */
    private IdentifierType ProfileID;
    /**
     * Remarks from the transport user regarding the transport operations
     * referenced in the TransportExecutionPlanEntity Request.
     */
    private TextType TransportUserRemarks;
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
     * An identifier for the current version of the TransportExecutionPlanEntity
     * Request.
     */
    private IdentifierType VersionID;
    private List<ConsignmentEntity> Consignments = new ArrayList<>();
    private ContractEntity TransportContract;
    private DocumentReferenceEntity TransportServiceDescriptionDocumentReference;
    private DocumentReferenceEntity AdditionalDocumentReference;
    private DocumentReferenceEntity TransportExecutionPlanDocumentReference;
    private LocationEntity ToLocation;
    private LocationEntity FromLocation;
    private LocationEntity AtLocation;
    private PartyEntity TransportUserParty;
    private PartyEntity ReceiverParty;
    private PartyEntity SenderParty;
    private PartyEntity TransportServiceProviderParty;
    private PartyEntity PayeeParty;
    private PeriodEntity ServiceEndTimePeriod;
    private PeriodEntity ServiceStartTimePeriod;
    private PeriodEntity TransportServiceProviderResponseDeadlinePeriod;
    private List<SignatureEntity> Signatures = new ArrayList<>();
    private List<TransportExecutionTermsEntity> TransportExecutionTermses = new ArrayList<>();
    private TransportationServiceEntity MainTransportationService;
    private TransportationServiceEntity AdditionalTransportationService;

}
