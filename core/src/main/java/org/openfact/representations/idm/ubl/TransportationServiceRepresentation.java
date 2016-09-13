package org.openfact.representations.idm.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.NameRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A class to describe a transportation service.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:52 a. m.
 */
public class TransportationServiceRepresentation {

    /**
     * A code signifying the rate class for freight in this transportation
     * service.
     */
    private CodeRepresentation freightRateClassCode;
    /**
     * The name of this transportation service.
     */
    private NameRepresentation name;
    /**
     * In a transport contract, the deadline date by which this transportation
     * service has to be booked. For example, if this service is scheduled for
     * Wednesday 16 February 2011 at 10 a.m. CET, the nomination date might be
     * Tuesday15 February 2011.
     */
    private LocalDate nominationDate;
    /**
     * In a transport contract, the deadline time by which this transportation
     * service has to be booked. For example, if this service is scheduled for
     * Wednesday 16 February 2011 at 10 a.m. CET, the nomination date might be
     * Tuesday15 February 2011 and the nominat
     */
    private LocalTime nominationTime;
    /**
     * The priority of this transportation service.
     */
    private TextRepresentation priority;
    /**
     * A number indicating the order of this transportation service in a
     * sequence of transportation services.
     */
    private BigDecimal sequenceNumeric;
    /**
     * A code signifying the tariff class applicable to this transportation
     * service.
     */
    private CodeRepresentation tariffClassCode;
    /**
     * Text describing this transportation service.
     */
    private TextRepresentation transportationServiceDescription;
    /**
     * The Uniform Resource Identifier (URI) of a document providing additional
     * details regarding this transportation service.
     */
    private IdentifierRepresentation transportationServiceDetailsURIID;
    /**
     * A code signifying the extent of this transportation service (e.g.,
     * door-to-door, port-to-port).
     */
    private CodeRepresentation transportServiceCode;
    private List<CommodityClassificationRepresentation> unsupportedCommodityClassification = new ArrayList<>();
    private List<CommodityClassificationRepresentation> supportedCommodityClassification = new ArrayList<>();
    private List<CommodityClassificationRepresentation> commodityClassifications = new ArrayList<>();
    private DimensionRepresentation totalCapacityDimension;
    private List<EnvironmentalEmissionRepresentation> environmentalEmissions = new ArrayList<>();
    private PartyRepresentation responsibleTransportServiceProviderParty;
    private PeriodRepresentation estimatedDurationPeriod;
    private ServiceFrequencyRepresentation scheduledServiceFrequency;
    private List<ShipmentStageRepresentation> shipmentStages = new ArrayList<>();
    private List<TransportEquipmentRepresentation> unsupportedTransportEquipment = new ArrayList<>();
    private List<TransportEquipmentRepresentation> transportEquipments = new ArrayList<>();
    private List<TransportEquipmentRepresentation> supportedTransportEquipment = new ArrayList<>();
    private List<TransportEventRepresentation> transportEvents = new ArrayList<>();

}
