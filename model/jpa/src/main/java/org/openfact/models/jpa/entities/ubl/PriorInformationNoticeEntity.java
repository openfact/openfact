package org.openfact.models.jpa.entities.ubl;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A document used by a contracting party to declare the intention to buy goods,
 * services, or works during a specified period.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:21:07 a. m.
 */
public class PriorInformationNoticeEntity{

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
	 * The date planned by the ContractingPartyEntity for publication of the contract
	 * notice.
	 */
	private DateType plannedDate; 
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
	private List<ContractingPartyEntity> contractingParties = new ArrayList<>(); 
	private CustomerPartyEntity originatorCustomerParty; 
	private List<DocumentReferenceEntity> documentReferences = new ArrayList<>(); 
	private PartyEntity receiverParty; 
	private List<ProcurementProjectEntity> procurementProjects = new ArrayList<>(); 
	private List<ProcurementProjectLotEntity> procurementProjectsLot = new ArrayList<>(); 
	private List<SignatureEntity> signatures = new ArrayList<>(); 
	private List<TenderingProcessEntity> tenderingProcesses = new ArrayList<>(); 
	private List<TenderingTermsEntity> tenderingTermses = new ArrayList<>(); 

}
