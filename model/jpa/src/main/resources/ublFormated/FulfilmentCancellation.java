package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A document used to cancel an entire fulfilment document (DespatchAdvice or
 * ReceiptAdvice).
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:20:42 a. m.
 */
public class FulfilmentCancellation{

	/**
	 * The reason for cancellation of the referenced document.
	 */
	private TextType CancellationNote;
	/**
	 * Indicates whether this document is a copy (true) or not (false).
	 */
	private boolean CopyIndicator;
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
	private LocalDate IssueDate;
	/**
	 * The time, assigned by the sender, at which this document was issued.
	 */
	private LocalTime IssueTime;
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
	private List<Contract> Contracts = new ArrayList<>();
	private CustomerParty BuyerCustomerParty;
	private CustomerParty OriginatorCustomerParty;
	private CustomerParty DeliveryCustomerParty;
	private DocumentReference AdditionalDocumentReference;
	private DocumentReference ReceiptDocumentReference;
	private DocumentReference DespatchDocumentReference;
	private List<OrderReference> OrderReferences = new ArrayList<>();
	private List<Signature> Signatures = new ArrayList<>();
	private SupplierParty DespatchSupplierParty;
	private SupplierParty SellerSupplierParty;

}
