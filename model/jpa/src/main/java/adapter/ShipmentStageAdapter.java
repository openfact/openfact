package adapter;
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
public class ShipmentStageAdapter{

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
	private DateType EstimatedDeliveryDate;
	/**
	 * The estimated time of delivery in this shipment stage.
	 */
	private TimeType EstimatedDeliveryTime;
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
	private IndicatorType OnCarriageIndicator;
	/**
	 * The total number of passengers aboard a transport means.
	 */
	private QuantityType PassengerQuantity;
	/**
	 * An indicator that this stage takes place before the main carriage of the
	 * shipment (true) or not (false).
	 */
	private IndicatorType PreCarriageIndicator;
	/**
	 * The delivery date required by the buyer in this shipment stage.
	 */
	private DateType RequiredDeliveryDate;
	/**
	 * The delivery time required by the buyer in this shipment stage.
	 */
	private TimeType RequiredDeliveryTime;
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
	private AllowanceChargeAdapter FreightAllowanceCharge;
	private LocationAdapter LoadingPortLocation;
	private LocationAdapter TransshipPortLocation;
	private LocationAdapter UnloadingPortLocation;
	private LocationAdapter FreightChargeLocation;
	private PartyAdapter CustomsAgentParty;
	private PartyAdapter TerminalOperatorParty;
	private PartyAdapter CarrierParty;
	private PeriodAdapter EstimatedTransitPeriod;
	private PeriodAdapter TransitPeriod;
	private PersonAdapter ReportingPerson;
	private PersonAdapter ShipsSurgeonPerson;
	private PersonAdapter MasterPerson;
	private PersonAdapter CrewMemberPerson;
	private PersonAdapter DriverPerson;
	private PersonAdapter PassengerPerson;
	private PersonAdapter SecurityOfficerPerson;
	private List<TransportEventAdapter> ExportationTransportEvent = new ArrayList<>();
	private List<TransportEventAdapter> ActualArrivalTransportEvent = new ArrayList<>();
	private List<TransportEventAdapter> WarehousingTransportEvent = new ArrayList<>();
	private List<TransportEventAdapter> ExaminationTransportEvent = new ArrayList<>();
	private List<TransportEventAdapter> ActualDepartureTransportEvent = new ArrayList<>();
	private List<TransportEventAdapter> EstimatedDepartureTransportEvent = new ArrayList<>();
	private List<TransportEventAdapter> RequestedDepartureTransportEvent = new ArrayList<>();
	private List<TransportEventAdapter> PlannedWaypointTransportEvent = new ArrayList<>();
	private List<TransportEventAdapter> OptionalTakeoverTransportEvent = new ArrayList<>();
	private List<TransportEventAdapter> AvailabilityTransportEvent = new ArrayList<>();
	private List<TransportEventAdapter> LoadingTransportEvent = new ArrayList<>();
	private List<TransportEventAdapter> TakeoverTransportEvent = new ArrayList<>();
	private List<TransportEventAdapter> RequestedArrivalTransportEvent = new ArrayList<>();
	private List<TransportEventAdapter> RequestedWaypointTransportEvent = new ArrayList<>();
	private List<TransportEventAdapter> PlannedDepartureTransportEvent = new ArrayList<>();
	private List<TransportEventAdapter> PlannedArrivalTransportEvent = new ArrayList<>();
	private List<TransportEventAdapter> DetentionTransportEvent = new ArrayList<>();
	private List<TransportEventAdapter> DischargeTransportEvent = new ArrayList<>();
	private List<TransportEventAdapter> TransportEvents = new ArrayList<>();
	private List<TransportEventAdapter> ActualWaypointTransportEvent = new ArrayList<>();
	private List<TransportEventAdapter> DeliveryTransportEvent = new ArrayList<>();
	private List<TransportEventAdapter> ActualPickupTransportEvent = new ArrayList<>();
	private List<TransportEventAdapter> DropoffTransportEvent = new ArrayList<>();
	private List<TransportEventAdapter> ReceiptTransportEvent = new ArrayList<>();
	private List<TransportEventAdapter> AcceptanceTransportEvent = new ArrayList<>();
	private List<TransportEventAdapter> StorageTransportEvent = new ArrayList<>();
	private List<TransportEventAdapter> EstimatedArrivalTransportEvent = new ArrayList<>();
	private List<TransportMeansAdapter> TransportMeanses = new ArrayList<>();

}
