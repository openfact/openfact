package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;
import org.openfact.models.jpa.entities.ublType.*;

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
	private BigDecimal airFlowPercent;
	/**
	 * An indicator that this piece of transport equipment is approved for
	 * animal food (true) or not (false).
	 */
	private boolean animalFoodApprovedIndicator;
	/**
	 * characteristics of this piece of transport equipment.
	 */
	private TextType characteristics;
	/**
	 * Damage associated with this piece of transport equipment.
	 */
	private TextType damageRemarks;
	/**
	 * An indicator that this piece of transport equipment is approved for
	 * dangerous goods (true) or not (false).
	 */
	private boolean dangerousGoodsApprovedIndicator;
	/**
	 * Text describing this piece of transport equipment.
	 */
	private TextType description;
	/**
	 * A code signifying the current disposition of this piece of transport
	 * equipment.
	 */
	private CodeType dispositionCode;
	/**
	 * A code signifying whether this piece of transport equipment is full,
	 * partially full, or empty.
	 */
	private CodeType fullnessIndicationCode;
	/**
	 * The gross volume of this piece of transport equipment.
	 */
	private MeasureType grossVolumeMeasure;
	/**
	 * The gross weight of this piece of transport equipment.
	 */
	private MeasureType grossWeightMeasure;
	/**
	 * An indicator that this piece of transport equipment is approved for human
	 * food (true) or not (false).
	 */
	private boolean humanFoodApprovedIndicator;
	/**
	 * The percent humidity within this piece of transport equipment.
	 */
	private BigDecimal humidityPercent;
	/**
	 * An identifier for this piece of transport equipment.
	 */
	private IdentifierType ID;
	/**
	 * Additional information about this piece of transport equipment.
	 */
	private TextType information;
	/**
	 * An indication of the legal status of this piece of transport equipment
	 * with respect to the Container Convention Code.
	 */
	private boolean legalStatusIndicator;
	/**
	 * A code signifying the type of owner of this piece of transport equipment.
	 */
	private CodeType ownerTypeCode;
	/**
	 * An indicator that this piece of transport equipment can supply power
	 * (true) or not (false).
	 */
	private boolean powerIndicator;
	/**
	 * A code signifying the type of provider of this piece of transport
	 * equipment.
	 */
	private CodeType providerTypeCode;
	/**
	 * An identifier for the consignment contained by this piece of transport
	 * equipment.
	 */
	private IdentifierType referencedConsignmentID;
	/**
	 * An indicator that this piece of transport equipment is refrigerated
	 * (true) or not (false).
	 */
	private boolean refrigeratedIndicator;
	/**
	 * An indicator that this piece of transport equipment's refrigeration is on
	 * (true) or off (false).
	 */
	private boolean refrigerationOnIndicator;
	/**
	 * An indicator that this piece of transport equipment is returnable (true)
	 * or not (false).
	 */
	private boolean returnabilityIndicator;
	/**
	 * A code signifying the size and type of this piece of piece of transport
	 * equipment. When the piece of transport equipment is a shipping container,
	 * it is recommended to use ContainersizeTypeCode for validation.
	 */
	private CodeType sizeTypeCode;
	/**
	 * Special transport requirements expressed as text.
	 */
	private TextType specialTransportRequirements;
	/**
	 * The weight of this piece of transport equipment when empty.
	 */
	private MeasureType tareWeightMeasure;
	/**
	 * An identifier for use in tracing this piece of transport equipment, such
	 * as the EPC number used in RFID.
	 */
	private IdentifierType traceID;
	/**
	 * A code signifying the tracking device for this piece of transport
	 * equipment.
	 */
	private CodeType trackingDeviceCode;
	/**
	 * A code signifying the type of this piece of transport equipment.
	 */
	private List<TransportEquipmentEntity> type_CodeTypeTransportEquipmentTypeCode = new ArrayList<>();
	private AllowanceChargeEntity serviceAllowanceCharge;
	private AllowanceChargeEntity freightAllowanceCharge;
	private List<DeliveryEntity> deliveries = new ArrayList<>();
	private List<DespatchEntity> despatches = new ArrayList<>();
	private DimensionEntity measurementDimension;
	private DocumentReferenceEntity shipmentDocumentReference;
	private List<GoodsItemEntity> goodsItems = new ArrayList<>();
	private List<HazardousGoodsTransitEntity> hazardousGoodsTransits = new ArrayList<>();
	private LocationEntity loadingLocation;
	private LocationEntity unloadingLocation;
	private LocationEntity storageLocation;
	private List<PackageEntity> packages = new ArrayList<>();
	private PartyEntity ownerParty;
	private PartyEntity operatingParty;
	private PartyEntity providerParty;
	private PartyEntity loadingProofParty;
	private List<PickupEntity> pickups = new ArrayList<>();
	private List<SupplierPartyEntity> supplierParties = new ArrayList<>();
	private TemperatureEntity maximumTemperature;
	private TemperatureEntity minimumTemperature;
	private TradingTermsEntity haulageTradingTerms;
	private List<TransportEquipmentEntity> containedInTransportEquipment = new ArrayList<>();
	private List<TransportEquipmentEntity> attachedTransportEquipment = new ArrayList<>();
	private List<TransportEquipmentEntity> sealTransportEquipmentSeals = new ArrayList<>();
	private List<TransportEventEntity> quarantineTransportEvent = new ArrayList<>();
	private List<TransportEventEntity> positioningTransportEvent = new ArrayList<>();
	private List<TransportEventEntity> transportEvents = new ArrayList<>();
	private List<TransportEventEntity> loadingTransportEvent = new ArrayList<>();
	private List<TransportEventEntity> deliveryTransportEvent = new ArrayList<>();
	private List<TransportEventEntity> pickupTransportEvent = new ArrayList<>();
	private List<TransportEventEntity> handlingTransportEvent = new ArrayList<>();
	private TransportHandlingUnitEntity packagedTransportHandlingUnit;
	private TransportMeansEntity applicableTransportMeans;

}
