package representation;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define a reference to a document.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:35 a. m.
 */
public class DocumentReferenceRepresentation{

	/**
	 * An indicator that the referenced document is a copy (true) or the original
	 * (false).
	 */
	private IndicatorType CopyIndicator;
	/**
	 * Text describing the referenced document.
	 */
	private TextType DocumentDescription;
	/**
	 * A code signifying the status of the reference document with respect to its
	 * original state.
	 */
	private DocumentStatusCodeType CodeTypeDocumentStatusCode;
	/**
	 * The type of document being referenced, expressed as text.
	 */
	private TextType DocumentType;
	/**
	 * The type of document being referenced, expressed as a code.
	 */
	private CodeType DocumentTypeCode;
	/**
	 * An identifier for the referenced document.
	 */
	private IdentifierType ID;
	/**
	 * The date, assigned by the sender of the referenced document, on which the
	 * document was issued.
	 */
	private DateType IssueDate;
	/**
	 * The time, assigned by the sender of the referenced document, at which the
	 * document was issued.
	 */
	private TimeType IssueTime;
	/**
	 * An identifier for the language used in the referenced document.
	 */
	private IdentifierType LanguageID;
	/**
	 * A code signifying the locale in which the language in the referenced document
	 * is used.
	 */
	private CodeType LocaleCode;
	/**
	 * A universally unique identifier for this document reference.
	 */
	private IdentifierType UUID;
	/**
	 * An identifier for the current version of the referenced document.
	 */
	private IdentifierType VersionID;
	/**
	 * A reference to another place in the same XML document instance in which
	 * DocumentReferenceRepresentation appears.
	 */
	private TextType XPath;
	private List<AttachmentRepresentation> Attachments = new ArrayList<>();
	private PartyRepresentation IssuerParty;
	private PeriodRepresentation ValidityPeriod;
	private List<ResultOfVerificationRepresentation> ResultOfVerifications = new ArrayList<>();

}
