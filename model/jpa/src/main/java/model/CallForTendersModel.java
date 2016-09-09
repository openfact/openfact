package model;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A document used by a ContractingPartyModel to define a procurement project to buy
 * goods, services, or works during a specified period.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:19:15 a. m.
 */
public class CallForTendersModel{

	/**
	 * The date, assigned by the contracting party, on which the CallForTendersModel was
	 * approved.
	 */
	private DateType ApprovalDate;
	/**
	 * An identifier, assigned by the sender, for the process file (i.e., record) to
	 * which this document belongs.
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
	 * Free-form text pertinent to this document, conveying information that is not
	 * contained explicitly in other structures.
	 */
	private TextType Note;
	/**
	 * Identifies the previous version of the Call for Tenders which is superceded by
	 * this version.
	 */
	private IdentifierType PreviousVersionID;
	/**
	 * Identifies an instance of executing a profile, to associate all transactions in
	 * a collaboration.
	 */
	private IdentifierType ProfileExecutionID;
	/**
	 * Identifies a user-defined profile of the customization of UBL being used.
	 */
	private IdentifierType ProfileID;
	/**
	 * Identifies the earliest version of the UBL 2 schema for this document type that
	 * defines all of the elements that might be encountered in the current instance.
	 */
	private IdentifierType UBLVersionID;
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private IdentifierType UUID;
	/**
	 * Indicates the current version of the Call for Tenders.
	 */
	private IdentifierType VersionID;
	private List<ContractingPartyModel> ContractingParties = new ArrayList<>();
	private CustomerPartyModel OriginatorCustomerParty;
	private DocumentReferenceModel TechnicalDocumentReference;
	private DocumentReferenceModel AdditionalDocumentReference;
	private DocumentReferenceModel LegalDocumentReference;
	private PartyModel ReceiverParty;
	private List<ProcurementProjectModel> ProcurementProjects = new ArrayList<>();
	private List<ProcurementProjectLotModel> ProcurementProjectsLot = new ArrayList<>();
	private List<SignatureModel> Signatures = new ArrayList<>();
	private List<TenderingProcessModel> TenderingProcesses = new ArrayList<>();
	private List<TenderingTermsModel> TenderingTermses = new ArrayList<>();

}
