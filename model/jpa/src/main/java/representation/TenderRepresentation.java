package representation;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A document whereby an economic operator (the tenderer) makes a formal offer
 * (the tender) to a contracting authority to execute an order for the supply or
 * purchase of goods, or for the execution of work, according to the terms of a
 * proposed contract.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:21:28 a. m.
 */
public class TenderRepresentation{

	/**
	 * An identifier, assigned by the sender, for the process file (i.e., record) to
	 * which this document belongs.
	 */
	private IdentifierType ContractFolderID;
	/**
	 * Short title of a contract associated with this Tender.
	 */
	private TextType ContractName;
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
	 * Identifies an instance of executing a profile, to associate all transactions in
	 * a collaboration.
	 */
	private IdentifierType ProfileExecutionID;
	/**
	 * Identifies a user-defined profile of the customization of UBL being used.
	 */
	private IdentifierType ProfileID;
	/**
	 * A code to specify the type of tender (economical or objective criteria versus
	 * technical or subjective criteria)
	 */
	private CodeType TenderTypeCode;
	/**
	 * Identifies the earliest version of the UBL 2 schema for this document type that
	 * defines all of the elements that might be encountered in the current instance.
	 */
	private IdentifierType UBLVersionID;
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private IdentifierType UUID;
	private List<ContractingPartyRepresentation> ContractingParties = new ArrayList<>();
	private CustomerPartyRepresentation OriginatorCustomerParty;
	private List<DocumentReferenceRepresentation> DocumentReferences = new ArrayList<>();
	private List<DocumentReferenceRepresentation> TendererQualificationDocumentReference = new ArrayList<>();
	private PartyRepresentation SubcontractorParty;
	private PartyRepresentation TendererParty;
	private PeriodRepresentation ValidityPeriod;
	private List<SignatureRepresentation> Signatures = new ArrayList<>();
	private List<TenderedProjectRepresentation> TenderedProjects = new ArrayList<>();

}
