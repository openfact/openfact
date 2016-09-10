package org.openfact.representations.idm.ubl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.IdentifierType;
import org.openfact.representations.idm.ubl.type.TextType;

/**
 * A document published by a ContractingPartyRepresentation to announce the
 * awarding of a procurement project.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:20:21 a. m.
 */
public class ContractAwardNoticeRepresentation {

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
     * Identifies an instance of executing a profile, to associate all
     * transactions in a collaboration.
     */
    private IdentifierType profileExecutionID;
    /**
     * Identifies a user-defined profile of the customization of UBL being used.
     */
    private IdentifierType profileID;
    /**
     * An indicator specifying if the notice is published for service contracts
     * within certain service categories (true) or not (false).
     */
    private boolean publishAwardIndicator;
    /**
     * Information about the law that defines the regulatory domain.
     */
    private TextType regulatoryDomain;
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
    private List<ContractingPartyRepresentation> contractingParties = new ArrayList<>();
    private CustomerPartyRepresentation originatorCustomerParty;
    private DocumentReferenceRepresentation previousDocumentReference;
    private DocumentReferenceRepresentation minutesDocumentReference;
    private PartyRepresentation receiverParty;
    private List<ProcurementProjectLotRepresentation> procurementProjectLots = new ArrayList<>();
    private List<ProcurementProjectRepresentation> procurementProjects = new ArrayList<>();
    private List<SignatureRepresentation> signatures = new ArrayList<>();
    private List<TenderResultRepresentation> tenderResults = new ArrayList<>();
    private List<TenderingProcessRepresentation> tenderingProcesses = new ArrayList<>();
    private List<TenderingTermsRepresentation> tenderingTermses = new ArrayList<>();

}
