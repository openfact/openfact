package org.openfact.models.jpa.entities.ubl;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A document to notify the deposit of a bid bond guarantee.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:20:45 a. m.
 */
public class GuaranteeCertificateModel{

	/**
	 * The code stating the constitution means of the guarantee.
	 */
	private CodeType constitutionCode; 
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
	 * A code signifying the type of the guarantee.
	 */
	private CodeType guaranteeTypeCode; 
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
	 * The liability amount (a monetary value) in the bid bond guarantee.
	 */
	private AmountType liabilityAmount; 
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
	 * A textual description of the purpose of the bid bond guarantee.
	 */
	private TextType purpose; 
	/**
	 * Identifies the earliest version of the UBL 2 schema for this document type that
	 * defines all of the elements that might be encountered in the current instance.
	 */
	private IdentifierType UBLVersionID; 
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private IdentifierType UUID; 
	private DocumentReferenceModel guaranteeDocumentReference; 
	private List<ImmobilizedSecurityModel> immobilizedSecurities = new ArrayList<>(); 
	private PartyModel interestedParty; 
	private PartyModel guarantorParty; 
	private PartyModel beneficiaryParty; 
	private PeriodModel applicablePeriod; 
	private RegulationModel applicableRegulation; 
	private List<SignatureModel> signatures = new ArrayList<>(); 

}
