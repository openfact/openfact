package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
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
public class AttachedDocumentAdapter{

	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private IdentifierType customizationID; 
	/**
	 * Text specifying the type of document.
	 */
	private TextType documentType; 
	/**
	 * A code signifying the type of document.
	 */
	private CodeType documentTypeCode; 
	/**
	 * An identifier for this document, assigned by the sender.
	 */
	private IdentifierType ID; 
	/**
	 * The date, assigned by the sender, on which this document was issued.
	 */
	private LocalDate issueDate; 
	/**
	 * The time, assigned by the sender, at which this document was issued.
	 */
	private LocalTime issueTime; 
	/**
	 * Free-form text pertinent to this document, conveying information that is not
	 * contained explicitly in other structures.
	 */
	private TextType note; 
	/**
	 * The Identifier of the parent document.
	 */
	private IdentifierType parentDocumentID; 
	/**
	 * A code signifying the type of parent document.
	 */
	private CodeType parentDocumentTypeCode; 
	/**
	 * Indicates the current version of the referred document.
	 */
	private IdentifierType parentDocumentVersionID; 
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
	private List<AttachmentAdapter> attachments = new ArrayList<>(); 
	private LineReferenceAdapter parentDocumentLineReference; 
	private PartyAdapter receiverParty; 
	private PartyAdapter senderParty; 
	private List<SignatureAdapter> signatures = new ArrayList<>(); 

}
