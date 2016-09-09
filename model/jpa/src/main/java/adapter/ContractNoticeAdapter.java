package adapter;
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
public class ContractNoticeAdapter{

	/**
	 * An identifier, assigned by the sender, for the process file (i.e., record) to
	 * which this document belongs.
	 */
	private IdentifierType contractFolderID;
	/**
	 * Indicates whether this document is a copy (true) or not (false).
	 */
	private IndicatorType copyIndicator;
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
	private DateType issueDate;
	/**
	 * The time, assigned by the sender, at which this document was issued.
	 */
	private TimeType issueTime;
	/**
	 * Free-form text pertinent to this document, conveying information that is not
	 * contained explicitly in other structures.
	 */
	private TextType note;
	/**
	 * Identifies an instance of executing a profile, to associate all transactions in
	 * a collaboration.
	 */
	private IdentifierType profileExecutionID;
	/**
	 * Identifies a user-defined profile of the customization of UBL being used.
	 */
	private IdentifierType profileID;
	/**
	 * Information about the law that defines the regulatory domain.
	 */
	private TextType regulatoryDomain;
	/**
	 * The requested publication date for this ContractNotice.
	 */
	private DateType requestedPublicationDate;
	/**
	 * Identifies the earliest version of the UBL 2 schema for this document type that
	 * defines all of the elements that might be encountered in the current instance.
	 */
	private IdentifierType UBLVersionID;
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private IdentifierType UUID;
	private List<ContractingPartyAdapter> contractingParties = new ArrayList<>();
	private CustomerPartyAdapter originatorCustomerParty;
	private PartyAdapter receiverParty;
	private PeriodAdapter frequencyPeriod;
	private List<ProcurementProjectLotAdapter> procurementProjectLots = new ArrayList<>();
	private List<ProcurementProjectAdapter> procurementProjects = new ArrayList<>();
	private List<SignatureAdapter> signatures = new ArrayList<>();
	private List<TenderingProcessAdapter> tenderingProcesses = new ArrayList<>();
	private List<TenderingTermsAdapter> tenderingTermses = new ArrayList<>();

}
