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
public class GuaranteeCertificate{

	/**
	 * The code stating the constitution means of the guarantee.
	 */
	private CodeType ConstitutionCode;
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
	 * A code signifying the type of the guarantee.
	 */
	private CodeType GuaranteeTypeCode;
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
	 * The liability amount (a monetary value) in the bid bond guarantee.
	 */
	private AmountType LiabilityAmount;
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
	 * A textual description of the purpose of the bid bond guarantee.
	 */
	private TextType Purpose;
	/**
	 * Identifies the earliest version of the UBL 2 schema for this document type that
	 * defines all of the elements that might be encountered in the current instance.
	 */
	private IdentifierType UBLVersionID;
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private IdentifierType UUID;
	private DocumentReference GuaranteeDocumentReference;
	private List<ImmobilizedSecurity> ImmobilizedSecurities = new ArrayList<>();
	private Party InterestedParty;
	private Party GuarantorParty;
	private Party BeneficiaryParty;
	private Period ApplicablePeriod;
	private Regulation ApplicableRegulation;
	private List<Signature> Signatures = new ArrayList<>();

}
