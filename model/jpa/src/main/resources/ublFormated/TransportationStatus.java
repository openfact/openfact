package org.openfact.models.jpa.entities.ubl;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A document to circulate reports of transportation status or changes in status
 * (events) among a group of participants.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:21:46 a. m.
 */
public class TransportationStatus{

	/**
	 * A reference number assigned by a carrier or its agent to identify a specific
	 * shipment, such as a booking reference number when cargo space is reserved prior
	 * to loading.
	 */
	private IdentifierType CarrierAssignedID;
	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private IdentifierType CustomizationID;
	/**
	 * A textual description of transportation status.
	 */
	private TextType Description;
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
	 * Text, assigned by the sender, that identifies this document to business users.
	 */
	private NameType Name;
	/**
	 * Free-form text pertinent to this document, conveying information that is not
	 * contained explicitly in other structures.
	 */
	private TextType Note;
	/**
	 * An instruction regarding this message.
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
	 * A reference number for a shipping order.
	 */
	private IdentifierType ShippingOrderID;
	/**
	 * A code signifying the type of status provided in a TransportationStatus
	 * document.
	 */
	private CodeType TransportationStatusTypeCode;
	/**
	 * A code signifying the overall status of transport service execution.
	 */
	private CodeType TransportExecutionStatusCode;
	/**
	 * Identifies the earliest version of the UBL 2 schema for this document type that
	 * defines all of the elements that might be encountered in the current instance.
	 */
	private IdentifierType UBLVersionID;
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private IdentifierType UUID;
	private List<Consignment> Consignments = new ArrayList<>();
	private List<DocumentReference> DocumentReferences = new ArrayList<>();
	private List<DocumentReference> TransportationStatusRequestDocumentReference = new ArrayList<>();
	private List<DocumentReference> TransportExecutionPlanDocumentReference = new ArrayList<>();
	private Location StatusLocation;
	private Party ReceiverParty;
	private Party SenderParty;
	private Period StatusPeriod;
	private List<Signature> Signatures = new ArrayList<>();
	private List<TransportEvent> TransportEvents = new ArrayList<>();
	private List<TransportEvent> UpdatedPickupTransportEvent = new ArrayList<>();
	private List<TransportEvent> UpdatedDeliveryTransportEvent = new ArrayList<>();

}
