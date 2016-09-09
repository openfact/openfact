package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A document to indicate the application's response to a transaction. This may be
 * a business response initiated by a user or a technical response sent
 * automatically by an application.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:19:06 a. m.
 */
public class ApplicationResponseAdapter{

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
	 * Identifies an instance of executing a profile, to associate all transactions in
	 * a collaboration.
	 */
	private IdentifierType profileExecutionID; 
	/**
	 * Identifies a user-defined profile of the customization of UBL being used.
	 */
	private IdentifierType profileID; 
	/**
	 * The date on which the information in the response was created.
	 */
	private LocalDate responseDate; 
	/**
	 * The time at which the information in the response was created.
	 */
	private LocalTime responseTime; 
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
	 * Identifies the current version of this document.
	 */
	private IdentifierType versionID; 
	private List<DocumentResponseAdapter> documentResponses = new ArrayList<>(); 
	private PartyAdapter senderParty; 
	private PartyAdapter receiverParty; 
	private List<SignatureAdapter> signatures = new ArrayList<>(); 

}
