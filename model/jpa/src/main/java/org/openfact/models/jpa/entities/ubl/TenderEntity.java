package org.openfact.models.jpa.entities.ubl;
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
public class TenderEntity{

	/**
	 * An identifier, assigned by the sender, for the process file (i.e., record) to
	 * which this document belongs.
	 */
	private IdentifierType contractFolderID; 
	/**
	 * Short title of a contract associated with this Tender.
	 */
	private TextType contractName; 
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
	 * A code to specify the type of tender (economical or objective criteria versus
	 * technical or subjective criteria)
	 */
	private CodeType tenderTypeCode; 
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
	private List<DocumentReferenceEntity> tendererQualificationDocumentReference = new ArrayList<>(); 
	private PartyEntity subcontractorParty; 
	private PartyEntity tendererParty; 
	private PeriodEntity validityPeriod; 
	private List<SignatureEntity> signatures = new ArrayList<>(); 
	private List<TenderedProjectEntity> tenderedProjects = new ArrayList<>(); 

}
