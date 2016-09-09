package org.openfact.models.jpa.entities.ubl;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A document issued by the party who acts as an agent for a transportation
 * carrier or other agents to the party who gives instructions for the
 * transportation services (shipper, consignor, etc.) stating the details of the
 * transportation, charges, and terms a
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:19:12 a. m.
 */
public class BillOfLadingModel{

	/**
	 * A term used in commerce in reference to certain duties, called ad valorem
	 * duties, which are levied on commodities at certain rates per centum on their
	 * value.
	 */
	private IndicatorType adValoremIndicator; 
	/**
	 * Reference number (such as a booking reference number) assigned by a carrier or
	 * its agent to identify a specific shipment when cargo space is reserved prior to
	 * loading.
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
	private AmountType declaredCarriageValueAmount; 
	/**
	 * Textual description of the document instance.
	 */
	private TextType description; 
	/**
	 * A code signifying the status of the BillOfLadingModel (revision, replacement, etc.
	 * ).
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
	 * Text, assigned by the sender, that identifies this document to business users.
	 */
	private NameType name; 
	/**
	 * Free-form text pertinent to this document, conveying information that is not
	 * contained explicitly in other structures.
	 */
	private TextType note; 
	/**
	 * Other free-text instructions to the forwarders or carriers related to the
	 * shipment. This element should only be used where such information cannot be
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
	 * Reference number to identify a Shipping OrderModel or Forwarding Instruction.
	 */
	private IdentifierType shippingOrderID; 
	/**
	 * Indicates whether the transport document is consigned to order.
	 */
	private IndicatorType toOrderIndicator; 
	/**
	 * Identifies the earliest version of the UBL 2 schema for this document type that
	 * defines all of the elements that might be encountered in the current instance.
	 */
	private IdentifierType UBLVersionID; 
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private IdentifierType UUID; 
	private List<DocumentDistributionModel> documentDistributions = new ArrayList<>(); 
	private List<DocumentReferenceModel> documentReferences = new ArrayList<>(); 
	private List<ExchangeRateModel> exchangeRates = new ArrayList<>(); 
	private PartyModel consignorParty; 
	private PartyModel carrierParty; 
	private PartyModel freightForwarderParty; 
	private List<ShipmentModel> shipments = new ArrayList<>(); 
	private List<SignatureModel> signatures = new ArrayList<>(); 

}
