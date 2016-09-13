package org.openfact.representations.idm.ubl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A document used by a Contracting party to announce a project to buy goods,
 * services, or works.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:20:23 a. m.
 */
public class ContractNoticeRepresentation {

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
     * Identifies an instance of executing a profile, to associate all
     * transactions in a collaboration.
     */
    private IdentifierRepresentation profileExecutionID;
    /**
     * Identifies a user-defined profile of the customization of UBL being used.
     */
    private IdentifierRepresentation profileID;
    /**
     * Information about the law that defines the regulatory domain.
     */
    private TextRepresentation regulatoryDomain;
    /**
     * The requested publication date for this ContractNotice.
     */
    private LocalDate requestedPublicationDate;
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
    private List<ContractingPartyRepresentation> contractingParties = new ArrayList<>();
    private CustomerPartyRepresentation originatorCustomerParty;
    private PartyRepresentation receiverParty;
    private PeriodRepresentation frequencyPeriod;
    private List<ProcurementProjectLotRepresentation> procurementProjectLots = new ArrayList<>();
    private List<ProcurementProjectRepresentation> procurementProjects = new ArrayList<>();
    private List<SignatureRepresentation> signatures = new ArrayList<>();
    private List<TenderingProcessRepresentation> tenderingProcesses = new ArrayList<>();
    private List<TenderingTermsRepresentation> tenderingTermses = new ArrayList<>();

}
