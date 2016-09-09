package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A document used to cancel an entire fulfilment document (DespatchAdviceRepresentation or
 * ReceiptAdvice).
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:20:42 a. m.
 */
public class FulfilmentCancellationRepresentation{

	/**
	 * The reason for cancellation of the referenced document.
	 */
	private TextType cancellationNote; 
	/**
	 * Indicates whether this document is a copy (true) or not (false).
	 */
	private boolean copyIndicator; 
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
	 * Identifies the earliest version of the UBL 2 schema for this document type that
	 * defines all of the elements that might be encountered in the current instance.
	 */
	private IdentifierType UBLVersionID; 
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private IdentifierType UUID; 
	private List<ContractRepresentation> contracts = new ArrayList<>(); 
	private CustomerPartyRepresentation buyerCustomerParty; 
	private CustomerPartyRepresentation originatorCustomerParty; 
	private CustomerPartyRepresentation deliveryCustomerParty; 
	private DocumentReferenceRepresentation additionalDocumentReference; 
	private DocumentReferenceRepresentation receiptDocumentReference; 
	private DocumentReferenceRepresentation despatchDocumentReference; 
	private List<OrderReferenceRepresentation> orderReferences = new ArrayList<>(); 
	private List<SignatureRepresentation> signatures = new ArrayList<>(); 
	private SupplierPartyRepresentation despatchSupplierParty; 
	private SupplierPartyRepresentation sellerSupplierParty; 

}
