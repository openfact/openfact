package org.openfact.models.ubl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A document used by a Contracting party to announce a project to buy goods,
 * services, or works.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:20:23 a. m.
 */
public class ContractNoticeModel {

    /**
     * An identifier, assigned by the sender, for the process file (i.e.,
     * record) to which this document belongs.
     */
    private IdentifierModel contractFolderID;
    /**
     * Indicates whether this document is a copy (true) or not (false).
     */
    private boolean copyIndicator;
    /**
     * Identifies a user-defined customization of UBL for a specific use.
     */
    private IdentifierModel customizationID;
    /**
     * An identifier for this document, assigned by the sender.
     */
    private IdentifierModel ID;
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
    private TextModel note;
    /**
     * Identifies an instance of executing a profile, to associate all
     * transactions in a collaboration.
     */
    private IdentifierModel profileExecutionID;
    /**
     * Identifies a user-defined profile of the customization of UBL being used.
     */
    private IdentifierModel profileID;
    /**
     * Information about the law that defines the regulatory domain.
     */
    private TextModel regulatoryDomain;
    /**
     * The requested publication date for this ContractNotice.
     */
    private LocalDate requestedPublicationDate;
    /**
     * Identifies the earliest version of the UBL 2 schema for this document
     * type that defines all of the elements that might be encountered in the
     * current instance.
     */
    private IdentifierModel UBLVersionID;
    /**
     * A universally unique identifier for an instance of this document.
     */
    private IdentifierModel UUID;
    private List<ContractingPartyModel> contractingParties = new ArrayList<>();
    private CustomerPartyModel originatorCustomerParty;
    private PartyModel receiverParty;
    private PeriodModel frequencyPeriod;
    private List<ProcurementProjectLotModel> procurementProjectLots = new ArrayList<>();
    private List<ProcurementProjectModel> procurementProjects = new ArrayList<>();
    private List<SignatureModel> signatures = new ArrayList<>();
    private List<TenderingProcessModel> tenderingProcesses = new ArrayList<>();
    private List<TenderingTermsModel> tenderingTermses = new ArrayList<>();

}
