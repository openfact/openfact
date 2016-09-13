package org.openfact.representations.idm.ubl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.QuantityRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;
import org.openfact.representations.idm.ubl.type.TransportModeCodeRepresentation;

/**
 * A class to describe one stage of movement in a transport of goods.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:17:45 a. m.
 */
public class ShipmentStageRepresentation {

    /**
     * The total number of crew aboard a transport means.
     */
    private QuantityRepresentation crewQuantity;
    /**
     * Text of instructions relating to demurrage (the case in which a vessel is
     * prevented from loading or discharging cargo within the stipulated
     * laytime).
     */
    private TextRepresentation demurrageInstructions;
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
    private IdentifierRepresentation ID;
    /**
     * Text of instructions applicable to a shipment stage.
     */
    private TextRepresentation instructions;
    /**
     * An identifier for the loading sequence (of consignments) associated with
     * this shipment stage.
     */
    private IdentifierRepresentation loadingSequenceID;
    /**
     * An indicator that this stage takes place after the main carriage of the
     * shipment (true) or not (false).
     */
    private boolean onCarriageIndicator;
    /**
     * The total number of passengers aboard a transport means.
     */
    private QuantityRepresentation passengerQuantity;
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
     * Identifies the successive loading sequence (of consignments) associated
     * with a shipment stage.
     */
    private IdentifierRepresentation successiveSequenceID;
    /**
     * A code signifying the direction of transit in this shipment stage.
     */
    private CodeRepresentation transitDirectionCode;
    /**
     * A code signifying the kind of transport means (truck, vessel, etc.) used
     * for this shipment stage.
     */
    private CodeRepresentation transportMeansTypeCode;
    /**
     * A code signifying the method of transport used for this shipment stage.
     */
    private TransportModeCodeRepresentation transportModeCode;
    private AllowanceChargeRepresentation freightAllowanceCharge;
    private LocationRepresentation loadingPortLocation;
    private LocationRepresentation transshipPortLocation;
    private LocationRepresentation unloadingPortLocation;
    private LocationRepresentation freightChargeLocation;
    private PartyRepresentation customsAgentParty;
    private PartyRepresentation terminalOperatorParty;
    private PartyRepresentation carrierParty;
    private PeriodRepresentation estimatedTransitPeriod;
    private PeriodRepresentation transitPeriod;
    private PersonRepresentation reportingPerson;
    private PersonRepresentation shipsSurgeonPerson;
    private PersonRepresentation masterPerson;
    private PersonRepresentation crewMemberPerson;
    private PersonRepresentation driverPerson;
    private PersonRepresentation passengerPerson;
    private PersonRepresentation securityOfficerPerson;
    private List<TransportEventRepresentation> exportationTransportEvent = new ArrayList<>();
    private List<TransportEventRepresentation> actualArrivalTransportEvent = new ArrayList<>();
    private List<TransportEventRepresentation> warehousingTransportEvent = new ArrayList<>();
    private List<TransportEventRepresentation> examinationTransportEvent = new ArrayList<>();
    private List<TransportEventRepresentation> actualDepartureTransportEvent = new ArrayList<>();
    private List<TransportEventRepresentation> estimatedDepartureTransportEvent = new ArrayList<>();
    private List<TransportEventRepresentation> requestedDepartureTransportEvent = new ArrayList<>();
    private List<TransportEventRepresentation> plannedWaypointTransportEvent = new ArrayList<>();
    private List<TransportEventRepresentation> optionaltakeoverTransportEvent = new ArrayList<>();
    private List<TransportEventRepresentation> availabilityTransportEvent = new ArrayList<>();
    private List<TransportEventRepresentation> loadingTransportEvent = new ArrayList<>();
    private List<TransportEventRepresentation> takeoverTransportEvent = new ArrayList<>();
    private List<TransportEventRepresentation> requestedArrivalTransportEvent = new ArrayList<>();
    private List<TransportEventRepresentation> requestedWaypointTransportEvent = new ArrayList<>();
    private List<TransportEventRepresentation> plannedDepartureTransportEvent = new ArrayList<>();
    private List<TransportEventRepresentation> plannedArrivalTransportEvent = new ArrayList<>();
    private List<TransportEventRepresentation> detentionTransportEvent = new ArrayList<>();
    private List<TransportEventRepresentation> dischargeTransportEvent = new ArrayList<>();
    private List<TransportEventRepresentation> transportEvents = new ArrayList<>();
    private List<TransportEventRepresentation> actualWaypointTransportEvent = new ArrayList<>();
    private List<TransportEventRepresentation> deliveryTransportEvent = new ArrayList<>();
    private List<TransportEventRepresentation> actualPickupTransportEvent = new ArrayList<>();
    private List<TransportEventRepresentation> dropoffTransportEvent = new ArrayList<>();
    private List<TransportEventRepresentation> receiptTransportEvent = new ArrayList<>();
    private List<TransportEventRepresentation> acceptanceTransportEvent = new ArrayList<>();
    private List<TransportEventRepresentation> storageTransportEvent = new ArrayList<>();
    private List<TransportEventRepresentation> estimatedArrivalTransportEvent = new ArrayList<>();
    private List<TransportMeansRepresentation> transportMeanses = new ArrayList<>();

}
