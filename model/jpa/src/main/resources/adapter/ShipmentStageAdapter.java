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
public class ShipmentStageAdapter{

	/**
	 * The total number of crew aboard a transport means.
	 */
	private QuantityType crewQuantity; 
	/**
	 * Text of instructions relating to demurrage (the case in which a vessel is
	 * prevented from loading or discharging cargo within the stipulated laytime).
	 */
	private TextType demurrageInstructions; 
	/**
	 * The estimated date of delivery in this shipment stage.
	 */
	private LocalDate estimatedDeliveryDate; 
	/**
	 * The estimated time of delivery in this shipment stage.
	 */
	private LocalTime estimatedDeliveryTime; 
	/**
	 * An identifier for this shipment stage.
	 */
	private IdentifierType ID; 
	/**
	 * Text of instructions applicable to a shipment stage.
	 */
	private TextType instructions; 
	/**
	 * An identifier for the loading sequence (of consignments) associated with this
	 * shipment stage.
	 */
	private IdentifierType loadingSequenceID; 
	/**
	 * An indicator that this stage takes place after the main carriage of the
	 * shipment (true) or not (false).
	 */
	private boolean onCarriageIndicator; 
	/**
	 * The total number of passengers aboard a transport means.
	 */
	private QuantityType passengerQuantity; 
	/**
	 * An indicator that this stage takes place before the main carriage of the
	 * shipment (true) or not (false).
	 */
	private boolean preCarriageIndicator; 
	/**
	 * The delivery date required by the buyer in this shipment stage.
	 */
	private LocalDate requiredDeliveryDate; 
	/**
	 * The delivery time required by the buyer in this shipment stage.
	 */
	private LocalTime requiredDeliveryTime; 
	/**
	 * Identifies the successive loading sequence (of consignments) associated with a
	 * shipment stage.
	 */
	private IdentifierType successiveSequenceID; 
	/**
	 * A code signifying the direction of transit in this shipment stage.
	 */
	private CodeType transitDirectionCode; 
	/**
	 * A code signifying the kind of transport means (truck, vessel, etc.) used for
	 * this shipment stage.
	 */
	private CodeType transportMeansTypeCode; 
	/**
	 * A code signifying the method of transport used for this shipment stage.
	 */
	private TransportModeCodeType transportModeCode; 
	private AllowanceChargeAdapter freightAllowanceCharge; 
	private LocationAdapter loadingPortLocation; 
	private LocationAdapter transshipPortLocation; 
	private LocationAdapter unloadingPortLocation; 
	private LocationAdapter freightChargeLocation; 
	private PartyAdapter customsAgentParty; 
	private PartyAdapter terminalOperatorParty; 
	private PartyAdapter carrierParty; 
	private PeriodAdapter estimatedTransitPeriod; 
	private PeriodAdapter transitPeriod; 
	private PersonAdapter reportingPerson; 
	private PersonAdapter shipsSurgeonPerson; 
	private PersonAdapter masterPerson; 
	private PersonAdapter crewMemberPerson; 
	private PersonAdapter driverPerson; 
	private PersonAdapter passengerPerson; 
	private PersonAdapter securityOfficerPerson; 
	private List<TransportEventAdapter> exportationTransportEvent = new ArrayList<>(); 
	private List<TransportEventAdapter> actualArrivalTransportEvent = new ArrayList<>(); 
	private List<TransportEventAdapter> warehousingTransportEvent = new ArrayList<>(); 
	private List<TransportEventAdapter> examinationTransportEvent = new ArrayList<>(); 
	private List<TransportEventAdapter> actualDepartureTransportEvent = new ArrayList<>(); 
	private List<TransportEventAdapter> estimatedDepartureTransportEvent = new ArrayList<>(); 
	private List<TransportEventAdapter> requestedDepartureTransportEvent = new ArrayList<>(); 
	private List<TransportEventAdapter> plannedWaypointTransportEvent = new ArrayList<>(); 
	private List<TransportEventAdapter> optionaltakeoverTransportEvent = new ArrayList<>(); 
	private List<TransportEventAdapter> availabilityTransportEvent = new ArrayList<>(); 
	private List<TransportEventAdapter> loadingTransportEvent = new ArrayList<>(); 
	private List<TransportEventAdapter> takeoverTransportEvent = new ArrayList<>(); 
	private List<TransportEventAdapter> requestedArrivalTransportEvent = new ArrayList<>(); 
	private List<TransportEventAdapter> requestedWaypointTransportEvent = new ArrayList<>(); 
	private List<TransportEventAdapter> plannedDepartureTransportEvent = new ArrayList<>(); 
	private List<TransportEventAdapter> plannedArrivalTransportEvent = new ArrayList<>(); 
	private List<TransportEventAdapter> detentionTransportEvent = new ArrayList<>(); 
	private List<TransportEventAdapter> dischargeTransportEvent = new ArrayList<>(); 
	private List<TransportEventAdapter> transportEvents = new ArrayList<>(); 
	private List<TransportEventAdapter> actualWaypointTransportEvent = new ArrayList<>(); 
	private List<TransportEventAdapter> deliveryTransportEvent = new ArrayList<>(); 
	private List<TransportEventAdapter> actualPickupTransportEvent = new ArrayList<>(); 
	private List<TransportEventAdapter> dropoffTransportEvent = new ArrayList<>(); 
	private List<TransportEventAdapter> receiptTransportEvent = new ArrayList<>(); 
	private List<TransportEventAdapter> acceptanceTransportEvent = new ArrayList<>(); 
	private List<TransportEventAdapter> storageTransportEvent = new ArrayList<>(); 
	private List<TransportEventAdapter> estimatedArrivalTransportEvent = new ArrayList<>(); 
	private List<TransportMeansAdapter> transportMeanses = new ArrayList<>(); 

}
