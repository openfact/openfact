package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.DateType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.nameType;
import org.openfact.models.jpa.entities.ublType.NumericType;
import org.openfact.models.jpa.entities.ublType.TextType;
import org.openfact.models.jpa.entities.ublType.TimeType;

/**
 * A class to describe a transportation service.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:52 a. m.
 */
public class TransportationServiceEntity {

    /**
     * A code signifying the rate class for freight in this transportation
     * service.
     */
    private CodeType freightRateClassCode;
    /**
     * The name of this transportation service.
     */
    private nameType name;
    /**
     * In a transport contract, the deadline date by which this transportation
     * service has to be booked. For example, if this service is scheduled for
     * Wednesday 16 February 2011 at 10 a.m. CET, the nomination date might be
     * Tuesday15 February 2011.
     */
    private DateType nominationDate;
    /**
     * In a transport contract, the deadline time by which this transportation
     * service has to be booked. For example, if this service is scheduled for
     * Wednesday 16 February 2011 at 10 a.m. CET, the nomination date might be
     * Tuesday15 February 2011 and the nominat
     */
    private TimeType nominationTime;
    /**
     * The priority of this transportation service.
     */
    private TextType priority;
    /**
     * A number indicating the order of this transportation service in a
     * sequence of transportation services.
     */
    private NumericType sequenceNumeric;
    /**
     * A code signifying the tariff class applicable to this transportation
     * service.
     */
    private CodeType tariffClassCode;
    /**
     * Text describing this transportation service.
     */
    private TextType transportationServiceDescription;
    /**
     * The Uniform Resource Identifier (URI) of a document providing additional
     * details regarding this transportation service.
     */
    private IdentifierType transportationServiceDetailsURIID;
    /**
     * A code signifying the extent of this transportation service (e.g.,
     * door-to-door, port-to-port).
     */
    private CodeType transportServiceCode;
    private List<CommodityClassificationEntity> unsupportedCommodityClassification = new ArrayList<>();
    private List<CommodityClassificationEntity> supportedCommodityClassification = new ArrayList<>();
    private List<CommodityClassificationEntity> commodityClassifications = new ArrayList<>();
    private DimensionEntity totalCapacityDimension;
    private List<EnvironmentalEmissionEntity> environmentalEmissions = new ArrayList<>();
    private PartyEntity responsibleTransportServiceProviderParty;
    private PeriodEntity estimatedDurationPeriod;
    private ServiceFrequencyEntity scheduledServiceFrequency;
    private List<ShipmentStageEntity> shipmentStages = new ArrayList<>();
    private List<TransportEquipmentEntity> unsupportedTransportEquipment = new ArrayList<>();
    private List<TransportEquipmentEntity> transportEquipments = new ArrayList<>();
    private List<TransportEquipmentEntity> supportedTransportEquipment = new ArrayList<>();
    private List<TransportEventEntity> transportEvents = new ArrayList<>();

}
