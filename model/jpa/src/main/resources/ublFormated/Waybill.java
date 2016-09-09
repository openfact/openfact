package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A transport document describing a shipment It is issued by the party who
 * undertakes to provide transportation services, or undertakes to arrange for
 * their provision, to the party who gives instructions for the transportation
 * services (shipper, consignor,
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:21:52 a. m.
 */
public class Waybill{

	/**
	 * A term used in commerce in reference to certain duties, called ad valorem
	 * duties, which are levied on commodities at certain rates per centum on their
	 * value.
	 */
	private boolean AdValoremIndicator;
	/**
	 * An identifier (in the form of a reference number) assigned by a carrier or its
	 * agent to identify a specific shipment.
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
	 * Text describing the contents of the Waybill.
	 */
	private TextType Description;
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
	 * Other free-text instructions related to the shipment to the forwarders or
	 * carriers. This should only be used where such information cannot be represented
	 * in other structured information entities within the document.
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
	 * An identifier (in the form of a reference number) of the Shipping Order or
	 * Forwarding Instruction associated with this shipment.
	 */
	private IdentifierType ShippingOrderID;
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
	private Party FreightForwarderParty;
	private Party CarrierParty;
	private Party ConsignorParty;
	private List<Shipment> Shipments = new ArrayList<>();
	private List<Signature> Signatures = new ArrayList<>();

}
