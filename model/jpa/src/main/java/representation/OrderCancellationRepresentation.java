package representation;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A document used to cancel an entire Order.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:20:54 a. m.
 */
public class OrderCancellationRepresentation{

	/**
	 * The general reason for cancellation of the referenced order.
	 */
	private TextType CancellationNote;
	/**
	 * Indicates whether this document is a copy (true) or not (false).
	 */
	private IndicatorType CopyIndicator;
	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private IdentifierType CustomizationID;
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
	private List<ContractRepresentation> Contracts = new ArrayList<>();
	private CustomerPartyRepresentation OriginatorCustomerParty;
	private CustomerPartyRepresentation BuyerCustomerParty;
	private DocumentReferenceRepresentation OriginatorDocumentReference;
	private DocumentReferenceRepresentation AdditionalDocumentReference;
	private List<OrderReferenceRepresentation> OrderReferences = new ArrayList<>();
	private List<SignatureRepresentation> Signatures = new ArrayList<>();
	private SupplierPartyRepresentation SellerSupplierParty;

}
