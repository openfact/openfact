package adapter;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define a certificate applied to the item. Certificated can be a
 * requirement to sell goods or services in a jurisdiction.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:28 a. m.
 */
public class CertificateAdapter{

	/**
	 * The type of this certificate, expressed as a code. The type specifies what
	 * array it belongs to, e.g.. Environmental, security, health improvement etc.
	 */
	private TextType CertificateType;
	/**
	 * The type of this certificate, expressed as a code. The type specifies what
	 * array it belongs to, e.g.. Environmental, security, health improvement etc.
	 */
	private CodeType CertificateTypeCode;
	/**
	 * An identifier for this certificate.
	 */
	private IdentifierType ID;
	/**
	 * Remarks by the applicant for this certificate.
	 */
	private TextType Remarks;
	private List<DocumentReferenceAdapter> DocumentReferences = new ArrayList<>();
	private PartyAdapter IssuerParty;
	private List<SignatureAdapter> Signatures = new ArrayList<>();

}
