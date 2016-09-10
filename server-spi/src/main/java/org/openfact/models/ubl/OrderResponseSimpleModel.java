package org.openfact.models.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A document used to indicate simple acceptance or rejection of an entire Order.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:21:04 a. m.
 */
public class OrderResponseSimpleModel{

	/**
	 * Indicates whether the OrderModel is accepted (true) or rejected (false).
	 */
	private boolean acceptedIndicator; 
	/**
	 * An accounting cost code applied to the order as a whole, expressed as text.
	 */
	private TextType accountingCost; 
	/**
	 * An accounting cost code applied to the order as a whole.
	 */
	private CodeType accountingCostCode; 
	/**
	 * Indicates whether this document is a copy (true) or not (false).
	 */
	private boolean copyIndicator; 
	/**
	 * A supplementary reference for the transaction (e.g., when using a purchasing
	 * card).
	 */
	private TextType customerReference; 
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
	 * The reason for rejection if the order was not accepted.
	 */
	private TextType rejectionNote; 
	/**
	 * Identifies the earliest version of the UBL 2 schema for this document type that
	 * defines all of the elements that might be encountered in the current instance.
	 */
	private IdentifierType UBLVersionID; 
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private IdentifierType UUID; 
	private CustomerPartyModel accountingCustomerParty; 
	private CustomerPartyModel originatorCustomerParty; 
	private CustomerPartyModel buyerCustomerParty; 
	private DocumentReferenceModel additionalDocumentReference; 
	private List<OrderReferenceModel> orderReferences = new ArrayList<>(); 
	private List<SignatureModel> signatures = new ArrayList<>(); 
	private SupplierPartyModel accountingSupplierParty; 
	private SupplierPartyModel sellerSupplierParty; 

}
