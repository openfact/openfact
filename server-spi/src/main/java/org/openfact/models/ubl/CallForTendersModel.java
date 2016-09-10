package org.openfact.models.ubl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A document used by a ContractingPartyModel to define a procurement project to
 * buy goods, services, or works during a specified period.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:19:15 a. m.
 */
public class CallForTendersModel {

    /**
     * The date, assigned by the contracting party, on which the
     * CallForTendersModel was approved.
     */
    private LocalDate approvalDate;
    /**
     * An identifier, assigned by the sender, for the process file (i.e.,
     * record) to which this document belongs.
     */
    private IdentifierType contractFolderID;
    /**
     * Indicates whether this document is a copy (true) or not (false).
     */
    private boolean copyIndicator;
    /**
     * Identifies a user-defined customization of UBL for a specific use.
     */
    private IdentifierType customizationID;
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
     * Identifies the previous version of the Call for Tenders which is
     * superceded by this version.
     */
    private IdentifierType previousVersionID;
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
     * Indicates the current version of the Call for Tenders.
     */
    private IdentifierType versionID;
    private List<ContractingPartyModel> contractingParties = new ArrayList<>();
    private CustomerPartyModel originatorCustomerParty;
    private DocumentReferenceModel technicalDocumentReference;
    private DocumentReferenceModel additionalDocumentReference;
    private DocumentReferenceModel legalDocumentReference;
    private PartyModel receiverParty;
    private List<ProcurementProjectModel> procurementProjects = new ArrayList<>();
    private List<ProcurementProjectLotModel> procurementProjectsLot = new ArrayList<>();
    private List<SignatureModel> signatures = new ArrayList<>();
    private List<TenderingProcessModel> tenderingProcesses = new ArrayList<>();
    private List<TenderingTermsModel> tenderingTermses = new ArrayList<>();

}
