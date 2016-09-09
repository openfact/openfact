package representation;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A document used by a Contracting party to announce a project to buy goods,
 * services, or works.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:20:23 a. m.
 */
public class ContractNoticeRepresentation{

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
	 * Identifies an instance of executing a profile, to associate all transactions in
	 * a collaboration.
	 */
	private IdentifierType ProfileExecutionID;
	/**
	 * Identifies a user-defined profile of the customization of UBL being used.
	 */
	private IdentifierType ProfileID;
	/**
	 * Information about the law that defines the regulatory domain.
	 */
	private TextType RegulatoryDomain;
	/**
	 * The requested publication date for this ContractNotice.
	 */
	private DateType RequestedPublicationDate;
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
	private PartyRepresentation ReceiverParty;
	private PeriodRepresentation FrequencyPeriod;
	private List<ProcurementProjectLotRepresentation> ProcurementProjectLots = new ArrayList<>();
	private List<ProcurementProjectRepresentation> ProcurementProjects = new ArrayList<>();
	private List<SignatureRepresentation> Signatures = new ArrayList<>();
	private List<TenderingProcessRepresentation> TenderingProcesses = new ArrayList<>();
	private List<TenderingTermsRepresentation> TenderingTermses = new ArrayList<>();

}
