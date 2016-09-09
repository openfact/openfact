package representation;
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
public class ShipmentStageRepresentation{

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
	private AllowanceChargeRepresentation FreightAllowanceCharge;
	private LocationRepresentation LoadingPortLocation;
	private LocationRepresentation TransshipPortLocation;
	private LocationRepresentation UnloadingPortLocation;
	private LocationRepresentation FreightChargeLocation;
	private PartyRepresentation CustomsAgentParty;
	private PartyRepresentation TerminalOperatorParty;
	private PartyRepresentation CarrierParty;
	private PeriodRepresentation EstimatedTransitPeriod;
	private PeriodRepresentation TransitPeriod;
	private PersonRepresentation ReportingPerson;
	private PersonRepresentation ShipsSurgeonPerson;
	private PersonRepresentation MasterPerson;
	private PersonRepresentation CrewMemberPerson;
	private PersonRepresentation DriverPerson;
	private PersonRepresentation PassengerPerson;
	private PersonRepresentation SecurityOfficerPerson;
	private List<TransportEventRepresentation> ExportationTransportEvent = new ArrayList<>();
	private List<TransportEventRepresentation> ActualArrivalTransportEvent = new ArrayList<>();
	private List<TransportEventRepresentation> WarehousingTransportEvent = new ArrayList<>();
	private List<TransportEventRepresentation> ExaminationTransportEvent = new ArrayList<>();
	private List<TransportEventRepresentation> ActualDepartureTransportEvent = new ArrayList<>();
	private List<TransportEventRepresentation> EstimatedDepartureTransportEvent = new ArrayList<>();
	private List<TransportEventRepresentation> RequestedDepartureTransportEvent = new ArrayList<>();
	private List<TransportEventRepresentation> PlannedWaypointTransportEvent = new ArrayList<>();
	private List<TransportEventRepresentation> OptionalTakeoverTransportEvent = new ArrayList<>();
	private List<TransportEventRepresentation> AvailabilityTransportEvent = new ArrayList<>();
	private List<TransportEventRepresentation> LoadingTransportEvent = new ArrayList<>();
	private List<TransportEventRepresentation> TakeoverTransportEvent = new ArrayList<>();
	private List<TransportEventRepresentation> RequestedArrivalTransportEvent = new ArrayList<>();
	private List<TransportEventRepresentation> RequestedWaypointTransportEvent = new ArrayList<>();
	private List<TransportEventRepresentation> PlannedDepartureTransportEvent = new ArrayList<>();
	private List<TransportEventRepresentation> PlannedArrivalTransportEvent = new ArrayList<>();
	private List<TransportEventRepresentation> DetentionTransportEvent = new ArrayList<>();
	private List<TransportEventRepresentation> DischargeTransportEvent = new ArrayList<>();
	private List<TransportEventRepresentation> TransportEvents = new ArrayList<>();
	private List<TransportEventRepresentation> ActualWaypointTransportEvent = new ArrayList<>();
	private List<TransportEventRepresentation> DeliveryTransportEvent = new ArrayList<>();
	private List<TransportEventRepresentation> ActualPickupTransportEvent = new ArrayList<>();
	private List<TransportEventRepresentation> DropoffTransportEvent = new ArrayList<>();
	private List<TransportEventRepresentation> ReceiptTransportEvent = new ArrayList<>();
	private List<TransportEventRepresentation> AcceptanceTransportEvent = new ArrayList<>();
	private List<TransportEventRepresentation> StorageTransportEvent = new ArrayList<>();
	private List<TransportEventRepresentation> EstimatedArrivalTransportEvent = new ArrayList<>();
	private List<TransportMeansRepresentation> TransportMeanses = new ArrayList<>();

}
