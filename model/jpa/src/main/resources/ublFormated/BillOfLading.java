package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
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
public class BillOfLading{

	/**
	 * A term used in commerce in reference to certain duties, called ad valorem
	 * duties, which are levied on commodities at certain rates per centum on their
	 * value.
	 */
	private boolean AdValoremIndicator;
	/**
	 * Reference number (such as a booking reference number) assigned by a carrier or
	 * its agent to identify a specific shipment when cargo space is reserved prior to
	 * loading.
	 */
	private IdentifierType CarrierAssignedID;
	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private IdentifierType CustomizationID;
	/**
	 * Value declared by the shipper or his agent solely for the purpose of varying
	 * the carrier's level of liability from that provided in the contract of carriage
	 * in case of loss or damage to goods or delayed delivery.
	 */
	private BigDecimal DeclaredCarriageValueAmount;
	/**
	 * Textual description of the document instance.
	 */
	private TextType Description;
	/**
	 * A code signifying the status of the BillOfLading (revision, replacement, etc.
	 * ).
	 */
	private DocumentStatusCodeType CodeTypeDocumentStatusCode;
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
	 * Text, assigned by the sender, that identifies this document to business users.
	 */
	private NameType Name;
	/**
	 * Free-form text pertinent to this document, conveying information that is not
	 * contained explicitly in other structures.
	 */
	private TextType Note;
	/**
	 * Other free-text instructions to the forwarders or carriers related to the
	 * shipment. This element should only be used where such information cannot be
	 * represented in other structured information entities within the document.
	 */
	private TextType OtherInstruction;
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
	 * Reference number to identify a Shipping Order or Forwarding Instruction.
	 */
	private IdentifierType ShippingOrderID;
	/**
	 * Indicates whether the transport document is consigned to order.
	 */
	private boolean ToOrderIndicator;
	/**
	 * Identifies the earliest version of the UBL 2 schema for this document type that
	 * defines all of the elements that might be encountered in the current instance.
	 */
	private IdentifierType UBLVersionID;
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private IdentifierType UUID;
	private List<DocumentDistribution> DocumentDistributions = new ArrayList<>();
	private List<DocumentReference> DocumentReferences = new ArrayList<>();
	private List<ExchangeRate> ExchangeRates = new ArrayList<>();
	private Party ConsignorParty;
	private Party CarrierParty;
	private Party FreightForwarderParty;
	private List<Shipment> Shipments = new ArrayList<>();
	private List<Signature> Signatures = new ArrayList<>();

}
