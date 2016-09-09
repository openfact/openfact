package model;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A wrapper that allows a document of any kind to be packaged with the UBL
 * document that references it.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:19:08 a. m.
 */
public class AttachedDocumentModel{

	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private IdentifierType CustomizationID;
	/**
	 * Text specifying the type of document.
	 */
	private TextType DocumentType;
	/**
	 * A code signifying the type of document.
	 */
	private CodeType DocumentTypeCode;
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
	 * Free-form text pertinent to this document, conveying information that is not
	 * contained explicitly in other structures.
	 */
	private TextType Note;
	/**
	 * The Identifier of the parent document.
	 */
	private IdentifierType ParentDocumentID;
	/**
	 * A code signifying the type of parent document.
	 */
	private CodeType ParentDocumentTypeCode;
	/**
	 * Indicates the current version of the referred document.
	 */
	private IdentifierType ParentDocumentVersionID;
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
	 * Identifies the earliest version of the UBL 2 schema for this document type that
	 * defines all of the elements that might be encountered in the current instance.
	 */
	private IdentifierType UBLVersionID;
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private IdentifierType UUID;
	private List<AttachmentModel> Attachments = new ArrayList<>();
	private LineReferenceModel ParentDocumentLineReference;
	private PartyModel ReceiverParty;
	private PartyModel SenderParty;
	private List<SignatureModel> Signatures = new ArrayList<>();

}
