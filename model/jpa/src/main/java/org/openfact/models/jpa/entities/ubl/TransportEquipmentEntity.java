package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.IndicatorType;
import org.openfact.models.jpa.entities.ublType.MeasureType;
import org.openfact.models.jpa.entities.ublType.PercentType;
import org.openfact.models.jpa.entities.ublType.TextType;

/**
 * A class to describe a piece of equipment used to transport goods.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:36 a. m.
 */
public class TransportEquipmentEntity {

    /**
     * The percent of the airflow within this piece of transport equipment.
     */
    private PercentType AirFlowPercent;
    /**
     * An indicator that this piece of transport equipment is approved for
     * animal food (true) or not (false).
     */
    private IndicatorType AnimalFoodApprovedIndicator;
    /**
     * Characteristics of this piece of transport equipment.
     */
    private TextType Characteristics;
    /**
     * Damage associated with this piece of transport equipment.
     */
    private TextType DamageRemarks;
    /**
     * An indicator that this piece of transport equipment is approved for
     * dangerous goods (true) or not (false).
     */
    private IndicatorType DangerousGoodsApprovedIndicator;
    /**
     * Text describing this piece of transport equipment.
     */
    private TextType Description;
    /**
     * A code signifying the current disposition of this piece of transport
     * equipment.
     */
    private CodeType DispositionCode;
    /**
     * A code signifying whether this piece of transport equipment is full,
     * partially full, or empty.
     */
    private CodeType FullnessIndicationCode;
    /**
     * The gross volume of this piece of transport equipment.
     */
    private MeasureType GrossVolumeMeasure;
    /**
     * The gross weight of this piece of transport equipment.
     */
    private MeasureType GrossWeightMeasure;
    /**
     * An indicator that this piece of transport equipment is approved for human
     * food (true) or not (false).
     */
    private IndicatorType HumanFoodApprovedIndicator;
    /**
     * The percent humidity within this piece of transport equipment.
     */
    private PercentType HumidityPercent;
    /**
     * An identifier for this piece of transport equipment.
     */
    private IdentifierType ID;
    /**
     * Additional information about this piece of transport equipment.
     */
    private TextType Information;
    /**
     * An indication of the legal status of this piece of transport equipment
     * with respect to the Container Convention Code.
     */
    private IndicatorType LegalStatusIndicator;
    /**
     * A code signifying the type of owner of this piece of transport equipment.
     */
    private CodeType OwnerTypeCode;
    /**
     * An indicator that this piece of transport equipment can supply power
     * (true) or not (false).
     */
    private IndicatorType PowerIndicator;
    /**
     * A code signifying the type of provider of this piece of transport
     * equipment.
     */
    private CodeType ProviderTypeCode;
    /**
     * An identifier for the consignment contained by this piece of transport
     * equipment.
     */
    private IdentifierType ReferencedConsignmentID;
    /**
     * An indicator that this piece of transport equipment is refrigerated
     * (true) or not (false).
     */
    private IndicatorType RefrigeratedIndicator;
    /**
     * An indicator that this piece of transport equipment's refrigeration is on
     * (true) or off (false).
     */
    private IndicatorType RefrigerationOnIndicator;
    /**
     * An indicator that this piece of transport equipment is returnable (true)
     * or not (false).
     */
    private IndicatorType ReturnabilityIndicator;
    /**
     * A code signifying the size and type of this piece of piece of transport
     * equipment. When the piece of transport equipment is a shipping container,
     * it is recommended to use ContainerSizeTypeCode for validation.
     */
    private CodeType SizeTypeCode;
    /**
     * Special transport requirements expressed as text.
     */
    private TextType SpecialTransportRequirements;
    /**
     * The weight of this piece of transport equipment when empty.
     */
    private MeasureType TareWeightMeasure;
    /**
     * An identifier for use in tracing this piece of transport equipment, such
     * as the EPC number used in RFID.
     */
    private IdentifierType TraceID;
    /**
     * A code signifying the tracking device for this piece of transport
     * equipment.
     */
    private CodeType TrackingDeviceCode;
    /**
     * A code signifying the type of this piece of transport equipment.
     */
    private List<TransportEquipmentEntity> Type_CodeTypeTransportEquipmentTypeCode = new ArrayList<>();
    private AllowanceChargeEntity ServiceAllowanceCharge;
    private AllowanceChargeEntity FreightAllowanceCharge;
    private List<DeliveryEntity> Deliveries = new ArrayList<>();
    private List<DespatchEntity> Despatches = new ArrayList<>();
    private DimensionEntity MeasurementDimension;
    private DocumentReferenceEntity ShipmentDocumentReference;
    private List<GoodsItemEntity> GoodsItems = new ArrayList<>();
    private List<HazardousGoodsTransitEntity> HazardousGoodsTransits = new ArrayList<>();
    private LocationEntity LoadingLocation;
    private LocationEntity UnloadingLocation;
    private LocationEntity StorageLocation;
    private List<PackageEntity> Packages = new ArrayList<>();
    private PartyEntity OwnerParty;
    private PartyEntity OperatingParty;
    private PartyEntity ProviderParty;
    private PartyEntity LoadingProofParty;
    private List<PickupEntity> Pickups = new ArrayList<>();
    private List<SupplierPartyEntity> SupplierParties = new ArrayList<>();
    private TemperatureEntity MaximumTemperature;
    private TemperatureEntity MinimumTemperature;
    private TradingTermsEntity HaulageTradingTerms;
    private List<TransportEquipmentEntity> ContainedInTransportEquipment = new ArrayList<>();
    private List<TransportEquipmentEntity> AttachedTransportEquipment = new ArrayList<>();
    private List<TransportEquipmentEntity> SealTransportEquipmentSeals = new ArrayList<>();
    private List<TransportEventEntity> QuarantineTransportEvent = new ArrayList<>();
    private List<TransportEventEntity> PositioningTransportEvent = new ArrayList<>();
    private List<TransportEventEntity> TransportEvents = new ArrayList<>();
    private List<TransportEventEntity> LoadingTransportEvent = new ArrayList<>();
    private List<TransportEventEntity> DeliveryTransportEvent = new ArrayList<>();
    private List<TransportEventEntity> PickupTransportEvent = new ArrayList<>();
    private List<TransportEventEntity> HandlingTransportEvent = new ArrayList<>();
    private TransportHandlingUnitEntity PackagedTransportHandlingUnit;
    private TransportMeansEntity ApplicableTransportMeans;

}
