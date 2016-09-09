package representation;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define a signature.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:17:47 a. m.
 */
public class SignatureRepresentation{

	/**
	 * The method used to perform XML canonicalization of this signature.
	 */
	private TextType CanonicalizationMethod;
	/**
	 * An identifier for this signature.
	 */
	private IdentifierType ID;
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures; in particular, information regarding the circumstances in which the
	 * signature is being used.
	 */
	private TextType Note;
	/**
	 * Text describing the method of signature.
	 */
	private TextType SignatureMethod;
	/**
	 * The date upon which this signature was verified.
	 */
	private DateType ValidationDate;
	/**
	 * The time at which this signature was verified.
	 */
	private TimeType ValidationTime;
	/**
	 * An identifier for the organization, person, service, or server that verified
	 * this signature.
	 */
	private IdentifierType ValidatorID;
	private AttachmentRepresentation DigitalSignatureAttachment;
	private DocumentReferenceRepresentation OriginalDocumentReference;
	private PartyRepresentation SignatoryParty;

}
