package org.openfact.models.jpa.entities.ubl;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A document used to describe the despatch or delivery of goods and services.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:20:29 a. m.
 */
public class DespatchAdviceRepresentation{

	/**
	 * Indicates whether this document is a copy (true) or not (false).
	 */
	private IndicatorType copyIndicator; 
	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private IdentifierType customizationID; 
	/**
	 * A code signifying the type of the DespatchAdvice.
	 */
	private CodeType despatchAdviceTypeCode; 
	/**
	 * A code signifying the status of the DespatchAdviceRepresentation with respect to its
	 * original state. This code may be used if the document precedes the event and is
	 * subsequently found to be incorrect and in need of cancellation or revision.
	 */
	private DocumentStatusCodeType codeTypeDocumentStatusCode; 
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
	 * The number of despatchLines in this document.
	 */
	private NumericType lineCountNumeric; 
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
	private CustomerPartyRepresentation deliveryCustomerParty; 
	private CustomerPartyRepresentation buyerCustomerParty; 
	private CustomerPartyRepresentation originatorCustomerParty; 
	private List<DespatchLineRepresentation> despatchLines = new ArrayList<>(); 
	private DocumentReferenceRepresentation additionalDocumentReference; 
	private List<OrderReferenceRepresentation> orderReferences = new ArrayList<>(); 
	private List<ShipmentRepresentation> shipments = new ArrayList<>(); 
	private List<SignatureRepresentation> signatures = new ArrayList<>(); 
	private SupplierPartyRepresentation sellerSupplierParty; 
	private SupplierPartyRepresentation despatchSupplierParty; 

}
