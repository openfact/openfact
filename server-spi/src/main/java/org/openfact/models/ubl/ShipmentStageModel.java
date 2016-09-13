package org.openfact.models.ubl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;
import org.openfact.models.ubl.type.TransportModeCodeModel;

/**
 * A class to describe one stage of movement in a transport of goods.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:17:45 a. m.
 */
public class ShipmentStageModel {

    /**
     * The total number of crew aboard a transport means.
     */
    private QuantityModel crewQuantity;
    /**
     * Text of instructions relating to demurrage (the case in which a vessel is
     * prevented from loading or discharging cargo within the stipulated
     * laytime).
     */
    private TextModel demurrageInstructions;
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
    private IdentifierModel ID;
    /**
     * Text of instructions applicable to a shipment stage.
     */
    private TextModel instructions;
    /**
     * An identifier for the loading sequence (of consignments) associated with
     * this shipment stage.
     */
    private IdentifierModel loadingSequenceID;
    /**
     * An indicator that this stage takes place after the main carriage of the
     * shipment (true) or not (false).
     */
    private boolean onCarriageIndicator;
    /**
     * The total number of passengers aboard a transport means.
     */
    private QuantityModel passengerQuantity;
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
    private IdentifierModel successiveSequenceID;
    /**
     * A code signifying the direction of transit in this shipment stage.
     */
    private CodeModel transitDirectionCode;
    /**
     * A code signifying the kind of transport means (truck, vessel, etc.) used
     * for this shipment stage.
     */
    private CodeModel transportMeansTypeCode;
    /**
     * A code signifying the method of transport used for this shipment stage.
     */
    private TransportModeCodeModel transportModeCode;
    private AllowanceChargeModel freightAllowanceCharge;
    private LocationModel loadingPortLocation;
    private LocationModel transshipPortLocation;
    private LocationModel unloadingPortLocation;
    private LocationModel freightChargeLocation;
    private PartyModel customsAgentParty;
    private PartyModel terminalOperatorParty;
    private PartyModel carrierParty;
    private PeriodModel estimatedTransitPeriod;
    private PeriodModel transitPeriod;
    private PersonModel reportingPerson;
    private PersonModel shipsSurgeonPerson;
    private PersonModel masterPerson;
    private PersonModel crewMemberPerson;
    private PersonModel driverPerson;
    private PersonModel passengerPerson;
    private PersonModel securityOfficerPerson;
    private List<TransportEventModel> exportationTransportEvent = new ArrayList<>();
    private List<TransportEventModel> actualArrivalTransportEvent = new ArrayList<>();
    private List<TransportEventModel> warehousingTransportEvent = new ArrayList<>();
    private List<TransportEventModel> examinationTransportEvent = new ArrayList<>();
    private List<TransportEventModel> actualDepartureTransportEvent = new ArrayList<>();
    private List<TransportEventModel> estimatedDepartureTransportEvent = new ArrayList<>();
    private List<TransportEventModel> requestedDepartureTransportEvent = new ArrayList<>();
    private List<TransportEventModel> plannedWaypointTransportEvent = new ArrayList<>();
    private List<TransportEventModel> optionaltakeoverTransportEvent = new ArrayList<>();
    private List<TransportEventModel> availabilityTransportEvent = new ArrayList<>();
    private List<TransportEventModel> loadingTransportEvent = new ArrayList<>();
    private List<TransportEventModel> takeoverTransportEvent = new ArrayList<>();
    private List<TransportEventModel> requestedArrivalTransportEvent = new ArrayList<>();
    private List<TransportEventModel> requestedWaypointTransportEvent = new ArrayList<>();
    private List<TransportEventModel> plannedDepartureTransportEvent = new ArrayList<>();
    private List<TransportEventModel> plannedArrivalTransportEvent = new ArrayList<>();
    private List<TransportEventModel> detentionTransportEvent = new ArrayList<>();
    private List<TransportEventModel> dischargeTransportEvent = new ArrayList<>();
    private List<TransportEventModel> transportEvents = new ArrayList<>();
    private List<TransportEventModel> actualWaypointTransportEvent = new ArrayList<>();
    private List<TransportEventModel> deliveryTransportEvent = new ArrayList<>();
    private List<TransportEventModel> actualPickupTransportEvent = new ArrayList<>();
    private List<TransportEventModel> dropoffTransportEvent = new ArrayList<>();
    private List<TransportEventModel> receiptTransportEvent = new ArrayList<>();
    private List<TransportEventModel> acceptanceTransportEvent = new ArrayList<>();
    private List<TransportEventModel> storageTransportEvent = new ArrayList<>();
    private List<TransportEventModel> estimatedArrivalTransportEvent = new ArrayList<>();
    private List<TransportMeansModel> transportMeanses = new ArrayList<>();

}