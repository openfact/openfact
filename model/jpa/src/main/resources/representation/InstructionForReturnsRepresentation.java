package representation;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A document used to initiate a return of goods. The producer is requesting the
 * return of products that are not selling well, either to use in other places or
 * to free up rack or shelf space.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:20:46 a. m.
 */
public class InstructionForReturnsRepresentation{

	/**
	 * Indicates whether this document is a copy (true) or not (false).
	 */
	private IndicatorType copyIndicator;
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
	private CustomerPartyRepresentation retailerCustomerParty;
	private List<DocumentReferenceRepresentation> documentReferences = new ArrayList<>();
	private List<InstructionForReturnsLineRepresentation> instructionForReturnsLines = new ArrayList<>();
	private PartyRepresentation manufacturerParty;
	private List<ShipmentRepresentation> shipments = new ArrayList<>();
	private List<SignatureRepresentation> signatures = new ArrayList<>();
	private SupplierPartyRepresentation sellerSupplierParty;

}
