package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.DateType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.IndicatorType;
import org.openfact.models.jpa.entities.ublType.TextType;
import org.openfact.models.jpa.entities.ublType.TimeType;

/**
 * A document published by a ContractingPartyEntity to announce the awarding of
 * a procurement project.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:20:21 a. m.
 */
public class ContractAwardNoticeEntity {

    /**
     * An identifier, assigned by the sender, for the process file (i.e.,
     * record) to which this document belongs.
     */
    private IdentifierType ContractFolderID;
    /**
     * Indicates whether this document is a copy (true) or not (false).
     */
    private IndicatorType CopyIndicator;
    /**
     * Identifies a user-defined customization of UBL for a specific use.
     */
    private IdentifierType CustomizationID;
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
     * An indicator specifying if the notice is published for service contracts
     * within certain service categories (true) or not (false).
     */
    private IndicatorType PublishAwardIndicator;
    /**
     * Information about the law that defines the regulatory domain.
     */
    private TextType RegulatoryDomain;
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
    private List<ContractingPartyEntity> ContractingParties = new ArrayList<>();
    private CustomerPartyEntity OriginatorCustomerParty;
    private DocumentReferenceEntity PreviousDocumentReference;
    private DocumentReferenceEntity MinutesDocumentReference;
    private PartyEntity ReceiverParty;
    private List<ProcurementProjectLotEntity> ProcurementProjectLots = new ArrayList<>();
    private List<ProcurementProjectEntity> ProcurementProjects = new ArrayList<>();
    private List<SignatureEntity> Signatures = new ArrayList<>();
    private List<TenderResultEntity> TenderResults = new ArrayList<>();
    private List<TenderingProcessEntity> TenderingProcesses = new ArrayList<>();
    private List<TenderingTermsEntity> TenderingTermses = new ArrayList<>();

}
