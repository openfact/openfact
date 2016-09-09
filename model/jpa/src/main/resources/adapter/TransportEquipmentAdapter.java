package org.openfact.models.jpa.entities.ubl;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe a piece of equipment used to transport goods.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:36 a. m.
 */
public class TransportEquipmentAdapter{

	/**
	 * The percent of the airflow within this piece of transport equipment.
	 */
	private PercentType airFlowPercent; 
	/**
	 * An indicator that this piece of transport equipment is approved for animal food
	 * (true) or not (false).
	 */
	private IndicatorType animalFoodApprovedIndicator; 
	/**
	 * characteristics of this piece of transport equipment.
	 */
	private TextType characteristics; 
	/**
	 * Damage associated with this piece of transport equipment.
	 */
	private TextType damageRemarks; 
	/**
	 * An indicator that this piece of transport equipment is approved for dangerous
	 * goods (true) or not (false).
	 */
	private IndicatorType dangerousGoodsApprovedIndicator; 
	/**
	 * Text describing this piece of transport equipment.
	 */
	private TextType description; 
	/**
	 * A code signifying the current disposition of this piece of transport equipment.
	 */
	private CodeType dispositionCode; 
	/**
	 * A code signifying whether this piece of transport equipment is full, partially
	 * full, or empty.
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
	 * An indicator that this piece of transport equipment is approved for human food
	 * (true) or not (false).
	 */
	private IndicatorType humanFoodApprovedIndicator; 
	/**
	 * The percent humidity within this piece of transport equipment.
	 */
	private PercentType humidityPercent; 
	/**
	 * An identifier for this piece of transport equipment.
	 */
	private IdentifierType ID; 
	/**
	 * Additional information about this piece of transport equipment.
	 */
	private TextType information; 
	/**
	 * An indication of the legal status of this piece of transport equipment with
	 * respect to the Container Convention Code.
	 */
	private IndicatorType legalStatusIndicator; 
	/**
	 * A code signifying the type of owner of this piece of transport equipment.
	 */
	private CodeType ownerTypeCode; 
	/**
	 * An indicator that this piece of transport equipment can supply power (true) or
	 * not (false).
	 */
	private IndicatorType powerIndicator; 
	/**
	 * A code signifying the type of provider of this piece of transport equipment.
	 */
	private CodeType providerTypeCode; 
	/**
	 * An identifier for the consignment contained by this piece of transport
	 * equipment.
	 */
	private IdentifierType referencedConsignmentID; 
	/**
	 * An indicator that this piece of transport equipment is refrigerated (true) or
	 * not (false).
	 */
	private IndicatorType refrigeratedIndicator; 
	/**
	 * An indicator that this piece of transport equipment's refrigeration is on
	 * (true) or off (false).
	 */
	private IndicatorType refrigerationOnIndicator; 
	/**
	 * An indicator that this piece of transport equipment is returnable (true) or not
	 * (false).
	 */
	private IndicatorType returnabilityIndicator; 
	/**
	 * A code signifying the size and type of this piece of piece of transport
	 * equipment. When the piece of transport equipment is a shipping container, it is
	 * recommended to use ContainersizeTypeCode for validation.
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
	 * An identifier for use in tracing this piece of transport equipment, such as the
	 * EPC number used in RFID.
	 */
	private IdentifierType traceID; 
	/**
	 * A code signifying the tracking device for this piece of transport equipment.
	 */
	private CodeType trackingDeviceCode; 
	/**
	 * A code signifying the type of this piece of transport equipment.
	 */
	private List<TransportEquipmentAdapter> type_CodeTypeTransportEquipmentTypeCode = new ArrayList<>(); 
	private AllowanceChargeAdapter serviceAllowanceCharge; 
	private AllowanceChargeAdapter freightAllowanceCharge; 
	private List<DeliveryAdapter> deliveries = new ArrayList<>(); 
	private List<DespatchAdapter> despatches = new ArrayList<>(); 
	private DimensionAdapter measurementDimension; 
	private DocumentReferenceAdapter shipmentDocumentReference; 
	private List<GoodsItemAdapter> goodsItems = new ArrayList<>(); 
	private List<HazardousGoodsTransitAdapter> hazardousGoodsTransits = new ArrayList<>(); 
	private LocationAdapter loadingLocation; 
	private LocationAdapter unloadingLocation; 
	private LocationAdapter storageLocation; 
	private List<PackageAdapter> packages = new ArrayList<>(); 
	private PartyAdapter ownerParty; 
	private PartyAdapter operatingParty; 
	private PartyAdapter providerParty; 
	private PartyAdapter loadingProofParty; 
	private List<PickupAdapter> pickups = new ArrayList<>(); 
	private List<SupplierPartyAdapter> supplierParties = new ArrayList<>(); 
	private TemperatureAdapter maximumTemperature; 
	private TemperatureAdapter minimumTemperature; 
	private TradingTermsAdapter haulageTradingTerms; 
	private List<TransportEquipmentAdapter> containedInTransportEquipment = new ArrayList<>(); 
	private List<TransportEquipmentAdapter> attachedTransportEquipment = new ArrayList<>(); 
	private List<TransportEquipmentAdapter> sealTransportEquipmentSeals = new ArrayList<>(); 
	private List<TransportEventAdapter> quarantineTransportEvent = new ArrayList<>(); 
	private List<TransportEventAdapter> positioningTransportEvent = new ArrayList<>(); 
	private List<TransportEventAdapter> transportEvents = new ArrayList<>(); 
	private List<TransportEventAdapter> loadingTransportEvent = new ArrayList<>(); 
	private List<TransportEventAdapter> deliveryTransportEvent = new ArrayList<>(); 
	private List<TransportEventAdapter> pickupTransportEvent = new ArrayList<>(); 
	private List<TransportEventAdapter> handlingTransportEvent = new ArrayList<>(); 
	private TransportHandlingUnitAdapter packagedTransportHandlingUnit; 
	private TransportMeansAdapter applicableTransportMeans; 

}
