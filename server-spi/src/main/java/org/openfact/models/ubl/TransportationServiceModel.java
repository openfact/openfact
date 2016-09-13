package org.openfact.models.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A class to describe a transportation service.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:52 a. m.
 */
public class TransportationServiceModel {

    /**
     * A code signifying the rate class for freight in this transportation
     * service.
     */
    private CodeModel freightRateClassCode;
    /**
     * The name of this transportation service.
     */
    private NameModel name;
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
    private TextModel priority;
    /**
     * A number indicating the order of this transportation service in a
     * sequence of transportation services.
     */
    private BigDecimal sequenceNumeric;
    /**
     * A code signifying the tariff class applicable to this transportation
     * service.
     */
    private CodeModel tariffClassCode;
    /**
     * Text describing this transportation service.
     */
    private TextModel transportationServiceDescription;
    /**
     * The Uniform Resource Identifier (URI) of a document providing additional
     * details regarding this transportation service.
     */
    private IdentifierModel transportationServiceDetailsURIID;
    /**
     * A code signifying the extent of this transportation service (e.g.,
     * door-to-door, port-to-port).
     */
    private CodeModel transportServiceCode;
    private List<CommodityClassificationModel> unsupportedCommodityClassification = new ArrayList<>();
    private List<CommodityClassificationModel> supportedCommodityClassification = new ArrayList<>();
    private List<CommodityClassificationModel> commodityClassifications = new ArrayList<>();
    private DimensionModel totalCapacityDimension;
    private List<EnvironmentalEmissionModel> environmentalEmissions = new ArrayList<>();
    private PartyModel responsibleTransportServiceProviderParty;
    private PeriodModel estimatedDurationPeriod;
    private ServiceFrequencyModel scheduledServiceFrequency;
    private List<ShipmentStageModel> shipmentStages = new ArrayList<>();
    private List<TransportEquipmentModel> unsupportedTransportEquipment = new ArrayList<>();
    private List<TransportEquipmentModel> transportEquipments = new ArrayList<>();
    private List<TransportEquipmentModel> supportedTransportEquipment = new ArrayList<>();
    private List<TransportEventModel> transportEvents = new ArrayList<>();

}
