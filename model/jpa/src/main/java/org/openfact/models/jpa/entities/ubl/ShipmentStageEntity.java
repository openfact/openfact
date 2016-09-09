package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.DateType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.IndicatorType;
import org.openfact.models.jpa.entities.ublType.QuantityType;
import org.openfact.models.jpa.entities.ublType.TextType;
import org.openfact.models.jpa.entities.ublType.TimeType;

import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.TransportModeCodeType;

/**
 * A class to describe one stage of movement in a transport of goods.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:17:45 a. m.
 */
public class ShipmentStageEntity {

    /**
     * The total number of crew aboard a transport means.
     */
    private QuantityType CrewQuantity;
    /**
     * Text of instructions relating to demurrage (the case in which a vessel is
     * prevented from loading or discharging cargo within the stipulated
     * laytime).
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
     * An identifier for the loading sequence (of consignments) associated with
     * this shipment stage.
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
     * Identifies the successive loading sequence (of consignments) associated
     * with a shipment stage.
     */
    private IdentifierType SuccessiveSequenceID;
    /**
     * A code signifying the direction of transit in this shipment stage.
     */
    private CodeType TransitDirectionCode;
    /**
     * A code signifying the kind of transport means (truck, vessel, etc.) used
     * for this shipment stage.
     */
    private CodeType TransportMeansTypeCode;
    /**
     * A code signifying the method of transport used for this shipment stage.
     */
    private TransportModeCodeType TransportModeCode;
    private AllowanceChargeEntity FreightAllowanceCharge;
    private LocationEntity LoadingPortLocation;
    private LocationEntity TransshipPortLocation;
    private LocationEntity UnloadingPortLocation;
    private LocationEntity FreightChargeLocation;
    private PartyEntity CustomsAgentParty;
    private PartyEntity TerminalOperatorParty;
    private PartyEntity CarrierParty;
    private PeriodEntity EstimatedTransitPeriod;
    private PeriodEntity TransitPeriod;
    private PersonEntity ReportingPerson;
    private PersonEntity ShipsSurgeonPerson;
    private PersonEntity MasterPerson;
    private PersonEntity CrewMemberPerson;
    private PersonEntity DriverPerson;
    private PersonEntity PassengerPerson;
    private PersonEntity SecurityOfficerPerson;
    private List<TransportEventEntity> ExportationTransportEvent = new ArrayList<>();
    private List<TransportEventEntity> ActualArrivalTransportEvent = new ArrayList<>();
    private List<TransportEventEntity> WarehousingTransportEvent = new ArrayList<>();
    private List<TransportEventEntity> ExaminationTransportEvent = new ArrayList<>();
    private List<TransportEventEntity> ActualDepartureTransportEvent = new ArrayList<>();
    private List<TransportEventEntity> EstimatedDepartureTransportEvent = new ArrayList<>();
    private List<TransportEventEntity> RequestedDepartureTransportEvent = new ArrayList<>();
    private List<TransportEventEntity> PlannedWaypointTransportEvent = new ArrayList<>();
    private List<TransportEventEntity> OptionalTakeoverTransportEvent = new ArrayList<>();
    private List<TransportEventEntity> AvailabilityTransportEvent = new ArrayList<>();
    private List<TransportEventEntity> LoadingTransportEvent = new ArrayList<>();
    private List<TransportEventEntity> TakeoverTransportEvent = new ArrayList<>();
    private List<TransportEventEntity> RequestedArrivalTransportEvent = new ArrayList<>();
    private List<TransportEventEntity> RequestedWaypointTransportEvent = new ArrayList<>();
    private List<TransportEventEntity> PlannedDepartureTransportEvent = new ArrayList<>();
    private List<TransportEventEntity> PlannedArrivalTransportEvent = new ArrayList<>();
    private List<TransportEventEntity> DetentionTransportEvent = new ArrayList<>();
    private List<TransportEventEntity> DischargeTransportEvent = new ArrayList<>();
    private List<TransportEventEntity> TransportEvents = new ArrayList<>();
    private List<TransportEventEntity> ActualWaypointTransportEvent = new ArrayList<>();
    private List<TransportEventEntity> DeliveryTransportEvent = new ArrayList<>();
    private List<TransportEventEntity> ActualPickupTransportEvent = new ArrayList<>();
    private List<TransportEventEntity> DropoffTransportEvent = new ArrayList<>();
    private List<TransportEventEntity> ReceiptTransportEvent = new ArrayList<>();
    private List<TransportEventEntity> AcceptanceTransportEvent = new ArrayList<>();
    private List<TransportEventEntity> StorageTransportEvent = new ArrayList<>();
    private List<TransportEventEntity> EstimatedArrivalTransportEvent = new ArrayList<>();
    private List<TransportMeansEntity> TransportMeanses = new ArrayList<>();

}
