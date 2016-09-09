package model;
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
public class ShipmentStageModel{

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
	private AllowanceChargeModel FreightAllowanceCharge;
	private LocationModel LoadingPortLocation;
	private LocationModel TransshipPortLocation;
	private LocationModel UnloadingPortLocation;
	private LocationModel FreightChargeLocation;
	private PartyModel CustomsAgentParty;
	private PartyModel TerminalOperatorParty;
	private PartyModel CarrierParty;
	private PeriodModel EstimatedTransitPeriod;
	private PeriodModel TransitPeriod;
	private PersonModel ReportingPerson;
	private PersonModel ShipsSurgeonPerson;
	private PersonModel MasterPerson;
	private PersonModel CrewMemberPerson;
	private PersonModel DriverPerson;
	private PersonModel PassengerPerson;
	private PersonModel SecurityOfficerPerson;
	private List<TransportEventModel> ExportationTransportEvent = new ArrayList<>();
	private List<TransportEventModel> ActualArrivalTransportEvent = new ArrayList<>();
	private List<TransportEventModel> WarehousingTransportEvent = new ArrayList<>();
	private List<TransportEventModel> ExaminationTransportEvent = new ArrayList<>();
	private List<TransportEventModel> ActualDepartureTransportEvent = new ArrayList<>();
	private List<TransportEventModel> EstimatedDepartureTransportEvent = new ArrayList<>();
	private List<TransportEventModel> RequestedDepartureTransportEvent = new ArrayList<>();
	private List<TransportEventModel> PlannedWaypointTransportEvent = new ArrayList<>();
	private List<TransportEventModel> OptionalTakeoverTransportEvent = new ArrayList<>();
	private List<TransportEventModel> AvailabilityTransportEvent = new ArrayList<>();
	private List<TransportEventModel> LoadingTransportEvent = new ArrayList<>();
	private List<TransportEventModel> TakeoverTransportEvent = new ArrayList<>();
	private List<TransportEventModel> RequestedArrivalTransportEvent = new ArrayList<>();
	private List<TransportEventModel> RequestedWaypointTransportEvent = new ArrayList<>();
	private List<TransportEventModel> PlannedDepartureTransportEvent = new ArrayList<>();
	private List<TransportEventModel> PlannedArrivalTransportEvent = new ArrayList<>();
	private List<TransportEventModel> DetentionTransportEvent = new ArrayList<>();
	private List<TransportEventModel> DischargeTransportEvent = new ArrayList<>();
	private List<TransportEventModel> TransportEvents = new ArrayList<>();
	private List<TransportEventModel> ActualWaypointTransportEvent = new ArrayList<>();
	private List<TransportEventModel> DeliveryTransportEvent = new ArrayList<>();
	private List<TransportEventModel> ActualPickupTransportEvent = new ArrayList<>();
	private List<TransportEventModel> DropoffTransportEvent = new ArrayList<>();
	private List<TransportEventModel> ReceiptTransportEvent = new ArrayList<>();
	private List<TransportEventModel> AcceptanceTransportEvent = new ArrayList<>();
	private List<TransportEventModel> StorageTransportEvent = new ArrayList<>();
	private List<TransportEventModel> EstimatedArrivalTransportEvent = new ArrayList<>();
	private List<TransportMeansModel> TransportMeanses = new ArrayList<>();

}
