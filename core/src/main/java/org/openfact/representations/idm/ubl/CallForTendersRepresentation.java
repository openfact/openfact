package org.openfact.representations.idm.ubl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A document used by a ContractingPartyRepresentation to define a procurement
 * project to buy goods, services, or works during a specified period.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:19:15 a. m.
 */
public class CallForTendersRepresentation {

    /**
     * The date, assigned by the contracting party, on which the
     * CallForTendersRepresentation was approved.
     */
    private LocalDate approvalDate;
    /**
     * An identifier, assigned by the sender, for the process file (i.e.,
     * record) to which this document belongs.
     */
    private IdentifierRepresentation contractFolderID;
    /**
     * Indicates whether this document is a copy (true) or not (false).
     */
    private boolean copyIndicator;
    /**
     * Identifies a user-defined customization of UBL for a specific use.
     */
    private IdentifierRepresentation customizationID;
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
     * Identifies the previous version of the Call for Tenders which is
     * superceded by this version.
     */
    private IdentifierRepresentation previousVersionID;
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
     * Indicates the current version of the Call for Tenders.
     */
    private IdentifierRepresentation versionID;
    private List<ContractingPartyRepresentation> contractingParties = new ArrayList<>();
    private CustomerPartyRepresentation originatorCustomerParty;
    private DocumentReferenceRepresentation technicalDocumentReference;
    private DocumentReferenceRepresentation additionalDocumentReference;
    private DocumentReferenceRepresentation legalDocumentReference;
    private PartyRepresentation receiverParty;
    private List<ProcurementProjectRepresentation> procurementProjects = new ArrayList<>();
    private List<ProcurementProjectLotRepresentation> procurementProjectsLot = new ArrayList<>();
    private List<SignatureRepresentation> signatures = new ArrayList<>();
    private List<TenderingProcessRepresentation> tenderingProcesses = new ArrayList<>();
    private List<TenderingTermsRepresentation> tenderingTermses = new ArrayList<>();

}
