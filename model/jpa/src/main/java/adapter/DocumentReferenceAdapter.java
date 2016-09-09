package adapter;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define a reference to a document.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:35 a. m.
 */
public class DocumentReferenceAdapter{

	/**
	 * An indicator that the referenced document is a copy (true) or the original
	 * (false).
	 */
	private IndicatorType copyIndicator;
	/**
	 * Text describing the referenced document.
	 */
	private TextType documentDescription;
	/**
	 * A code signifying the status of the reference document with respect to its
	 * original state.
	 */
	private DocumentStatusCodeType codeTypeDocumentStatusCode;
	/**
	 * The type of document being referenced, expressed as text.
	 */
	private TextType documentType;
	/**
	 * The type of document being referenced, expressed as a code.
	 */
	private CodeType documentTypeCode;
	/**
	 * An identifier for the referenced document.
	 */
	private IdentifierType ID;
	/**
	 * The date, assigned by the sender of the referenced document, on which the
	 * document was issued.
	 */
	private DateType issueDate;
	/**
	 * The time, assigned by the sender of the referenced document, at which the
	 * document was issued.
	 */
	private TimeType issueTime;
	/**
	 * An identifier for the language used in the referenced document.
	 */
	private IdentifierType languageID;
	/**
	 * A code signifying the locale in which the language in the referenced document
	 * is used.
	 */
	private CodeType localeCode;
	/**
	 * A universally unique identifier for this document reference.
	 */
	private IdentifierType UUID;
	/**
	 * An identifier for the current version of the referenced document.
	 */
	private IdentifierType versionID;
	/**
	 * A reference to another place in the same XML document instance in which
	 * DocumentReferenceAdapter appears.
	 */
	private TextType XPath;
	private List<AttachmentAdapter> attachments = new ArrayList<>();
	private PartyAdapter issuerParty;
	private PeriodAdapter validityPeriod;
	private List<ResultOfVerificationAdapter> resultOfVerifications = new ArrayList<>();

}
