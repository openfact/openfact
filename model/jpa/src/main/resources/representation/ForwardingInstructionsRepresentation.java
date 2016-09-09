package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A document issued to a forwarder, giving instructions regarding the action to
 * be taken for the forwarding of goods described therein. ForwardingInstructions
 * is used by any party who gives instructions for the transportation services
 * required for a consig
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:20:38 a. m.
 */
public class ForwardingInstructionsRepresentation{

	/**
	 * A term used in commerce in reference to certain duties, called ad valorem
	 * duties, which are levied on commodities at certain rates per centum on their
	 * value.
	 */
	private boolean adValoremIndicator; 
	/**
	 * Reference number assigned by a carrier or its agent to identify a specific
	 * shipment, such as a booking reference number when cargo space is reserved prior
	 * to loading.
	 */
	private IdentifierType carrierAssignedID; 
	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private IdentifierType customizationID; 
	/**
	 * Value declared by the shipper or his agent solely for the purpose of varying
	 * the carrier's level of liability from that provided in the contract of carriage
	 * in case of loss or damage to goods or delayed delivery.
	 */
	private BigDecimal declaredCarriageValueAmount; 
	/**
	 * Textual description of the document instance.
	 */
	private TextType description; 
	/**
	 * A code signifying the status of the ForwardingInstructionsRepresentation with respect to its
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
	private LocalDate issueDate; 
	/**
	 * The time, assigned by the sender, at which this document was issued.
	 */
	private LocalTime issueTime; 
	/**
	 * Text, assigned by the sender, that identifies this document to business users.
	 */
	private NameType name; 
	/**
	 * Free-form text pertinent to this document, conveying information that is not
	 * contained explicitly in other structures.
	 */
	private TextType note; 
	/**
	 * Contains other free-text instructions to the forwarders or carriers related to
	 * the shipment. This should only be used where such information cannot be
	 * represented in other structured information entities within the document.
	 */
	private TextType otherInstruction; 
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
	 * Reference number to identify a Shipping Order.
	 */
	private IdentifierType shippingOrderID; 
	/**
	 * Indicates whether the transport document is consigned to order.
	 */
	private boolean toOrderIndicator; 
	/**
	 * Identifies the earliest version of the UBL 2 schema for this document type that
	 * defines all of the elements that might be encountered in the current instance.
	 */
	private IdentifierType UBLVersionID; 
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private IdentifierType UUID; 
	private List<DocumentReferenceRepresentation> documentReferences = new ArrayList<>(); 
	private List<ExchangeRateRepresentation> exchangeRates = new ArrayList<>(); 
	private PartyRepresentation freightForwarderParty; 
	private PartyRepresentation consignorParty; 
	private PartyRepresentation carrierParty; 
	private List<ShipmentRepresentation> shipments = new ArrayList<>(); 
	private List<SignatureRepresentation> signatures = new ArrayList<>(); 

}
