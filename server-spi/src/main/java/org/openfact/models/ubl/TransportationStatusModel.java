package org.openfact.models.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
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
public class TransportationStatusModel{

	/**
	 * A reference number assigned by a carrier or its agent to identify a specific
	 * shipment, such as a booking reference number when cargo space is reserved prior
	 * to loading.
	 */
	private IdentifierType carrierAssignedID; 
	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private IdentifierType customizationID; 
	/**
	 * A textual description of transportation status.
	 */
	private TextType description; 
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
	 * An instruction regarding this message.
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
	 * A reference number for a shipping order.
	 */
	private IdentifierType shippingOrderID; 
	/**
	 * A code signifying the type of status provided in a TransportationStatus
	 * document.
	 */
	private CodeType transportationStatusTypeCode; 
	/**
	 * A code signifying the overall status of transport service execution.
	 */
	private CodeType transportExecutionStatusCode; 
	/**
	 * Identifies the earliest version of the UBL 2 schema for this document type that
	 * defines all of the elements that might be encountered in the current instance.
	 */
	private IdentifierType UBLVersionID; 
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private IdentifierType UUID; 
	private List<ConsignmentModel> consignments = new ArrayList<>(); 
	private List<DocumentReferenceModel> documentReferences = new ArrayList<>(); 
	private List<DocumentReferenceModel> transportationStatusRequestDocumentReference = new ArrayList<>(); 
	private List<DocumentReferenceModel> transportExecutionPlanDocumentReference = new ArrayList<>(); 
	private LocationModel statusLocation; 
	private PartyModel receiverParty; 
	private PartyModel senderParty; 
	private PeriodModel statusPeriod; 
	private List<SignatureModel> signatures = new ArrayList<>(); 
	private List<TransportEventModel> transportEvents = new ArrayList<>(); 
	private List<TransportEventModel> updatedPickupTransportEvent = new ArrayList<>(); 
	private List<TransportEventModel> updatedDeliveryTransportEvent = new ArrayList<>(); 

}
