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
 * A document used in the negotiation of a transport service between a transport
 * user and a transport service provider.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:21:37 a. m.
 */
public class TransportExecutionPlanEntity {

    /**
     * Indicates whether this document is a copy (true) or not (false).
     */
    private IndicatorType CopyIndicator;
    /**
     * Identifies a user-defined customization of UBL for a specific use.
     */
    private IdentifierType CustomizationID;
    /**
     * A code signifying the status of the TransportExecutionPlanEntity
     * (updated, cancelled, confirmed, etc.)
     */
    private DocumentStatusCodeType CodeTypeDocumentStatusCode;
    /**
     * A code signifying a reason associated with the status of a Transport
     * Execution Plan.
     */
    private CodeType DocumentStatusReasonCode;
    /**
     * A reason for the status assigned to the TransportExecutionPlan, expressed
     * in text.
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
     * Remarks from the transport service provider regarding the transport
     * operations referred to in the TransportExecutionPlan.
     */
    private TextType TransportServiceProviderRemarks;
    /**
     * Remarks from the transport user regarding the transport operations
     * referred to in the TransportExecutionPlan.
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
     * Indicates the current version of the TransportExecutionPlan.
     */
    private IdentifierType VersionID;
    private List<ConsignmentEntity> Consignments = new ArrayList<>();
    private ContractEntity TransportContract;
    private DocumentReferenceEntity TransportExecutionPlanDocumentReference;
    private DocumentReferenceEntity TransportExecutionPlanRequestDocumentReference;
    private DocumentReferenceEntity TransportServiceDescriptionDocumentReference;
    private DocumentReferenceEntity AdditionalDocumentReference;
    private LocationEntity ToLocation;
    private LocationEntity FromLocation;
    private LocationEntity AtLocation;
    private PartyEntity SenderParty;
    private PartyEntity TransportUserParty;
    private PartyEntity ReceiverParty;
    private PartyEntity BillToParty;
    private PartyEntity TransportServiceProviderParty;
    private PeriodEntity ServiceStartTimePeriod;
    private PeriodEntity ServiceEndTimePeriod;
    private PeriodEntity ValidityPeriod;
    private PeriodEntity TransportUserResponseRequiredPeriod;
    private PeriodEntity TransportServiceProviderResponseRequiredPeriod;
    private List<SignatureEntity> Signatures = new ArrayList<>();
    private List<TransportExecutionTermsEntity> TransportExecutionTermses = new ArrayList<>();
    private TransportationServiceEntity AdditionalTransportationService;
    private TransportationServiceEntity MainTransportationService;

}
