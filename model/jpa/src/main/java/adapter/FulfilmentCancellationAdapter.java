package adapter;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A document used to cancel an entire fulfilment document (DespatchAdviceAdapter or
 * ReceiptAdvice).
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:20:42 a. m.
 */
public class FulfilmentCancellationAdapter{

	/**
	 * The reason for cancellation of the referenced document.
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
	private List<ContractAdapter> Contracts = new ArrayList<>();
	private CustomerPartyAdapter BuyerCustomerParty;
	private CustomerPartyAdapter OriginatorCustomerParty;
	private CustomerPartyAdapter DeliveryCustomerParty;
	private DocumentReferenceAdapter AdditionalDocumentReference;
	private DocumentReferenceAdapter ReceiptDocumentReference;
	private DocumentReferenceAdapter DespatchDocumentReference;
	private List<OrderReferenceAdapter> OrderReferences = new ArrayList<>();
	private List<SignatureAdapter> Signatures = new ArrayList<>();
	private SupplierPartyAdapter DespatchSupplierParty;
	private SupplierPartyAdapter SellerSupplierParty;

}
