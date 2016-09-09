package org.openfact.models.jpa.entities.ubl;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A document that describes the CertificateEntity of Origin.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:19:56 a. m.
 */
public class CertificateOfOriginEntity{

	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private IdentifierType customizationID; 
	/**
	 * Textual description of the document instance.
	 */
	private TextType description; 
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
	 * Identifies the earliest version of the UBL 2 schema for this document type that
	 * defines all of the elements that might be encountered in the current instance.
	 */
	private IdentifierType UBLVersionID; 
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private IdentifierType UUID; 
	/**
	 * Identifies the version of this CertificateEntity of Origin.
	 */
	private IdentifierType versionID; 
	private List<CertificateOfOriginApplicationEntity> certificateOfOriginApplications = new ArrayList<>(); 
	private EndorsementEntity issuerEndorsement; 
	private EndorsementEntity embassyEndorsement; 
	private EndorsementEntity insuranceEndorsement; 
	private List<EndorserPartyEntity> endorserParties = new ArrayList<>(); 
	private PartyEntity importerParty; 
	private PartyEntity exporterParty; 
	private List<SignatureEntity> signatures = new ArrayList<>(); 

}
