package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A document used by a ContractingParty to define a procurement project to buy
 * goods, services, or works during a specified period.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:19:15 a. m.
 */
public class CallForTenders{

	/**
	 * The date, assigned by the contracting party, on which the CallForTenders was
	 * approved.
	 */
	private LocalDate ApprovalDate;
	/**
	 * An identifier, assigned by the sender, for the process file (i.e., record) to
	 * which this document belongs.
	 */
	private IdentifierType ContractFolderID;
	/**
	 * Indicates whether this document is a copy (true) or not (false).
	 */
	private boolean CopyIndicator;
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
	private LocalDate IssueDate;
	/**
	 * The time, assigned by the sender, at which this document was issued.
	 */
	private LocalTime IssueTime;
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
	private List<ContractingParty> ContractingParties = new ArrayList<>();
	private CustomerParty OriginatorCustomerParty;
	private DocumentReference TechnicalDocumentReference;
	private DocumentReference AdditionalDocumentReference;
	private DocumentReference LegalDocumentReference;
	private Party ReceiverParty;
	private List<ProcurementProject> ProcurementProjects = new ArrayList<>();
	private List<ProcurementProjectLot> ProcurementProjectsLot = new ArrayList<>();
	private List<Signature> Signatures = new ArrayList<>();
	private List<TenderingProcess> TenderingProcesses = new ArrayList<>();
	private List<TenderingTerms> TenderingTermses = new ArrayList<>();

}
