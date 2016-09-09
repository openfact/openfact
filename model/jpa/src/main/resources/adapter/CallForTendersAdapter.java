package org.openfact.models.jpa.entities.ubl;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A document used by a ContractingPartyAdapter to define a procurement project to buy
 * goods, services, or works during a specified period.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:19:15 a. m.
 */
public class CallForTendersAdapter{

	/**
	 * The date, assigned by the contracting party, on which the CallForTendersAdapter was
	 * approved.
	 */
	private DateType approvalDate; 
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
	 * Identifies the previous version of the Call for Tenders which is superceded by
	 * this version.
	 */
	private IdentifierType previousVersionID; 
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
	private IdentifierType versionID; 
	private List<ContractingPartyAdapter> contractingParties = new ArrayList<>(); 
	private CustomerPartyAdapter originatorCustomerParty; 
	private DocumentReferenceAdapter technicalDocumentReference; 
	private DocumentReferenceAdapter additionalDocumentReference; 
	private DocumentReferenceAdapter legalDocumentReference; 
	private PartyAdapter receiverParty; 
	private List<ProcurementProjectAdapter> procurementProjects = new ArrayList<>(); 
	private List<ProcurementProjectLotAdapter> procurementProjectsLot = new ArrayList<>(); 
	private List<SignatureAdapter> signatures = new ArrayList<>(); 
	private List<TenderingProcessAdapter> tenderingProcesses = new ArrayList<>(); 
	private List<TenderingTermsAdapter> tenderingTermses = new ArrayList<>(); 

}
