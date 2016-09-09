package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;

import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.TransportModeCodeType;


/**
 * A class to describe one stage of movement in a transport of goods.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:17:45 a. m.
 */
public class ShipmentStage{

	/**
	 * The total number of crew aboard a transport means.
	 */
	private QuantityType CrewQuantity;
	/**
	 * Text of instructions relating to demurrage (the case in which a vessel is
	 * prevented from loading or discharging cargo within the stipulated laytime).
	 */
	private TextType DemurrageInstructions;
	/**
	 * The estimated date of delivery in this shipment stage.
	 */
	private LocalDate EstimatedDeliveryDate;
	/**
	 * The estimated time of delivery in this shipment stage.
	 */
	private LocalTime EstimatedDeliveryTime;
	/**
	 * An identifier for this shipment stage.
	 */
	private IdentifierType ID;
	/**
	 * Text of instructions applicable to a shipment stage.
	 */
	private TextType Instructions;
	/**
	 * An identifier for the loading sequence (of consignments) associated with this
	 * shipment stage.
	 */
	private IdentifierType LoadingSequenceID;
	/**
	 * An indicator that this stage takes place after the main carriage of the
	 * shipment (true) or not (false).
	 */
	private boolean OnCarriageIndicator;
	/**
	 * The total number of passengers aboard a transport means.
	 */
	private QuantityType PassengerQuantity;
	/**
	 * An indicator that this stage takes place before the main carriage of the
	 * shipment (true) or not (false).
	 */
	private boolean PreCarriageIndicator;
	/**
	 * The delivery date required by the buyer in this shipment stage.
	 */
	private LocalDate RequiredDeliveryDate;
	/**
	 * The delivery time required by the buyer in this shipment stage.
	 */
	private LocalTime RequiredDeliveryTime;
	/**
	 * Identifies the successive loading sequence (of consignments) associated with a
	 * shipment stage.
	 */
	private IdentifierType SuccessiveSequenceID;
	/**
	 * A code signifying the direction of transit in this shipment stage.
	 */
	private CodeType TransitDirectionCode;
	/**
	 * A code signifying the kind of transport means (truck, vessel, etc.) used for
	 * this shipment stage.
	 */
	private CodeType TransportMeansTypeCode;
	/**
	 * A code signifying the method of transport used for this shipment stage.
	 */
	private TransportModeCodeType TransportModeCode;
	private AllowanceCharge FreightAllowanceCharge;
	private Location LoadingPortLocation;
	private Location TransshipPortLocation;
	private Location UnloadingPortLocation;
	private Location FreightChargeLocation;
	private Party CustomsAgentParty;
	private Party TerminalOperatorParty;
	private Party CarrierParty;
	private Period EstimatedTransitPeriod;
	private Period TransitPeriod;
	private Person ReportingPerson;
	private Person ShipsSurgeonPerson;
	private Person MasterPerson;
	private Person CrewMemberPerson;
	private Person DriverPerson;
	private Person PassengerPerson;
	private Person SecurityOfficerPerson;
	private List<TransportEvent> ExportationTransportEvent = new ArrayList<>();
	private List<TransportEvent> ActualArrivalTransportEvent = new ArrayList<>();
	private List<TransportEvent> WarehousingTransportEvent = new ArrayList<>();
	private List<TransportEvent> ExaminationTransportEvent = new ArrayList<>();
	private List<TransportEvent> ActualDepartureTransportEvent = new ArrayList<>();
	private List<TransportEvent> EstimatedDepartureTransportEvent = new ArrayList<>();
	private List<TransportEvent> RequestedDepartureTransportEvent = new ArrayList<>();
	private List<TransportEvent> PlannedWaypointTransportEvent = new ArrayList<>();
	private List<TransportEvent> OptionalTakeoverTransportEvent = new ArrayList<>();
	private List<TransportEvent> AvailabilityTransportEvent = new ArrayList<>();
	private List<TransportEvent> LoadingTransportEvent = new ArrayList<>();
	private List<TransportEvent> TakeoverTransportEvent = new ArrayList<>();
	private List<TransportEvent> RequestedArrivalTransportEvent = new ArrayList<>();
	private List<TransportEvent> RequestedWaypointTransportEvent = new ArrayList<>();
	private List<TransportEvent> PlannedDepartureTransportEvent = new ArrayList<>();
	private List<TransportEvent> PlannedArrivalTransportEvent = new ArrayList<>();
	private List<TransportEvent> DetentionTransportEvent = new ArrayList<>();
	private List<TransportEvent> DischargeTransportEvent = new ArrayList<>();
	private List<TransportEvent> TransportEvents = new ArrayList<>();
	private List<TransportEvent> ActualWaypointTransportEvent = new ArrayList<>();
	private List<TransportEvent> DeliveryTransportEvent = new ArrayList<>();
	private List<TransportEvent> ActualPickupTransportEvent = new ArrayList<>();
	private List<TransportEvent> DropoffTransportEvent = new ArrayList<>();
	private List<TransportEvent> ReceiptTransportEvent = new ArrayList<>();
	private List<TransportEvent> AcceptanceTransportEvent = new ArrayList<>();
	private List<TransportEvent> StorageTransportEvent = new ArrayList<>();
	private List<TransportEvent> EstimatedArrivalTransportEvent = new ArrayList<>();
	private List<TransportMeans> TransportMeanses = new ArrayList<>();

}
