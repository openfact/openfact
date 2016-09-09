package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.DateType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.NameType;
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
    private CodeType FreightRateClassCode;
    /**
     * The name of this transportation service.
     */
    private NameType Name;
    /**
     * In a transport contract, the deadline date by which this transportation
     * service has to be booked. For example, if this service is scheduled for
     * Wednesday 16 February 2011 at 10 a.m. CET, the nomination date might be
     * Tuesday15 February 2011.
     */
    private DateType NominationDate;
    /**
     * In a transport contract, the deadline time by which this transportation
     * service has to be booked. For example, if this service is scheduled for
     * Wednesday 16 February 2011 at 10 a.m. CET, the nomination date might be
     * Tuesday15 February 2011 and the nominat
     */
    private TimeType NominationTime;
    /**
     * The priority of this transportation service.
     */
    private TextType Priority;
    /**
     * A number indicating the order of this transportation service in a
     * sequence of transportation services.
     */
    private NumericType SequenceNumeric;
    /**
     * A code signifying the tariff class applicable to this transportation
     * service.
     */
    private CodeType TariffClassCode;
    /**
     * Text describing this transportation service.
     */
    private TextType TransportationServiceDescription;
    /**
     * The Uniform Resource Identifier (URI) of a document providing additional
     * details regarding this transportation service.
     */
    private IdentifierType TransportationServiceDetailsURIID;
    /**
     * A code signifying the extent of this transportation service (e.g.,
     * door-to-door, port-to-port).
     */
    private CodeType TransportServiceCode;
    private List<CommodityClassificationEntity> UnsupportedCommodityClassification = new ArrayList<>();
    private List<CommodityClassificationEntity> SupportedCommodityClassification = new ArrayList<>();
    private List<CommodityClassificationEntity> CommodityClassifications = new ArrayList<>();
    private DimensionEntity TotalCapacityDimension;
    private List<EnvironmentalEmissionEntity> EnvironmentalEmissions = new ArrayList<>();
    private PartyEntity ResponsibleTransportServiceProviderParty;
    private PeriodEntity EstimatedDurationPeriod;
    private ServiceFrequencyEntity ScheduledServiceFrequency;
    private List<ShipmentStageEntity> ShipmentStages = new ArrayList<>();
    private List<TransportEquipmentEntity> UnsupportedTransportEquipment = new ArrayList<>();
    private List<TransportEquipmentEntity> TransportEquipments = new ArrayList<>();
    private List<TransportEquipmentEntity> SupportedTransportEquipment = new ArrayList<>();
    private List<TransportEventEntity> TransportEvents = new ArrayList<>();

}
