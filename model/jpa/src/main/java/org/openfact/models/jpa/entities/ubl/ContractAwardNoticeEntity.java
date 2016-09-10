package org.openfact.models.jpa.entities.ubl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.IdentifierType;
import org.openfact.models.ubl.type.TextType;

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
    private List<ContractingPartyEntity> contractingParties = new ArrayList<>();
    private CustomerPartyEntity originatorCustomerParty;
    private DocumentReferenceEntity previousDocumentReference;
    private DocumentReferenceEntity minutesDocumentReference;
    private PartyEntity receiverParty;
    private List<ProcurementProjectLotEntity> procurementProjectLots = new ArrayList<>();
    private List<ProcurementProjectEntity> procurementProjects = new ArrayList<>();
    private List<SignatureEntity> signatures = new ArrayList<>();
    private List<TenderResultEntity> tenderResults = new ArrayList<>();
    private List<TenderingProcessEntity> tenderingProcesses = new ArrayList<>();
    private List<TenderingTermsEntity> tenderingTermses = new ArrayList<>();

}
