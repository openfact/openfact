package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;

/**
 * A class to describe a piece of equipment used to transport goods.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:36 a. m.
 */
public class TransportEquipment {

	/**
	 * The percent of the airflow within this piece of transport equipment.
	 */
	private BigDecimal AirFlowPercent;
	/**
	 * An indicator that this piece of transport equipment is approved for
	 * animal food (true) or not (false).
	 */
	private boolean AnimalFoodApprovedIndicator;
	/**
	 * Characteristics of this piece of transport equipment.
	 */
	private String Characteristics;
	/**
	 * Damage associated with this piece of transport equipment.
	 */
	private String DamageRemarks;
	/**
	 * An indicator that this piece of transport equipment is approved for
	 * dangerous goods (true) or not (false).
	 */
	private boolean DangerousGoodsApprovedIndicator;
	/**
	 * Text describing this piece of transport equipment.
	 */
	private String Description;
	/**
	 * A code signifying the current disposition of this piece of transport
	 * equipment.
	 */
	private String DispositionCode;
	/**
	 * A code signifying whether this piece of transport equipment is full,
	 * partially full, or empty.
	 */
	private String FullnessIndicationCode;
	/**
	 * The gross volume of this piece of transport equipment.
	 */
	private BigDecimal GrossVolumeMeasure;
	/**
	 * The gross weight of this piece of transport equipment.
	 */
	private BigDecimal GrossWeightMeasure;
	/**
	 * An indicator that this piece of transport equipment is approved for human
	 * food (true) or not (false).
	 */
	private boolean HumanFoodApprovedIndicator;
	/**
	 * The percent humidity within this piece of transport equipment.
	 */
	private BigDecimal HumidityPercent;
	/**
	 * An identifier for this piece of transport equipment.
	 */
	private String ID;
	/**
	 * Additional information about this piece of transport equipment.
	 */
	private String Information;
	/**
	 * An indication of the legal status of this piece of transport equipment
	 * with respect to the Container Convention Code.
	 */
	private boolean LegalStatusIndicator;
	/**
	 * A code signifying the type of owner of this piece of transport equipment.
	 */
	private String OwnerTypeCode;
	/**
	 * An indicator that this piece of transport equipment can supply power
	 * (true) or not (false).
	 */
	private boolean PowerIndicator;
	/**
	 * A code signifying the type of provider of this piece of transport
	 * equipment.
	 */
	private String ProviderTypeCode;
	/**
	 * An identifier for the consignment contained by this piece of transport
	 * equipment.
	 */
	private String ReferencedConsignmentID;
	/**
	 * An indicator that this piece of transport equipment is refrigerated
	 * (true) or not (false).
	 */
	private boolean RefrigeratedIndicator;
	/**
	 * An indicator that this piece of transport equipment's refrigeration is on
	 * (true) or off (false).
	 */
	private boolean RefrigerationOnIndicator;
	/**
	 * An indicator that this piece of transport equipment is returnable (true)
	 * or not (false).
	 */
	private boolean ReturnabilityIndicator;
	/**
	 * A code signifying the size and type of this piece of piece of transport
	 * equipment. When the piece of transport equipment is a shipping container,
	 * it is recommended to use ContainerSizeTypeCode for validation.
	 */
	private String SizeTypeCode;
	/**
	 * Special transport requirements expressed as text.
	 */
	private String SpecialTransportRequirements;
	/**
	 * The weight of this piece of transport equipment when empty.
	 */
	private BigDecimal TareWeightMeasure;
	/**
	 * An identifier for use in tracing this piece of transport equipment, such
	 * as the EPC number used in RFID.
	 */
	private String TraceID;
	/**
	 * A code signifying the tracking device for this piece of transport
	 * equipment.
	 */
	private String TrackingDeviceCode;
	/**
	 * A code signifying the type of this piece of transport equipment.
	 */
	private String TransportEquipmentTypeCode;
	private AllowanceCharge ServiceAllowanceCharge;
	private AllowanceCharge FreightAllowanceCharge;
	private List<Delivery> deliveries = new ArrayList<>();
	private List<Despatch> despatchs = new ArrayList<>();	
	private Dimension MeasurementDimension;
	private DocumentReference ShipmentDocumentReference;
	private List<GoodsItem> goodsItems = new ArrayList<>();	
	private List<HazardousGoodsTransit> hazardousGoodsTransits = new ArrayList<>();	
	private Location LoadingLocation;
	private Location UnloadingLocation;
	private Location StorageLocation;
	private List<Package> packages = new ArrayList<>();	
	private Party OwnerParty;
	private Party OperatingParty;
	private Party ProviderParty;
	private Party LoadingProofParty;
	private List<Pickup> pickups = new ArrayList<>();	
	private SupplierParty m_SupplierParty;
	private Temperature MaximumTemperature;
	private Temperature MinimumTemperature;
	private TradingTerms HaulageTradingTerms;
	private TransportEquipment ContainedInTransportEquipment;
	private TransportEquipment AttachedTransportEquipment;
	private TransportEquipmentSeal m_TransportEquipmentSeal;
	private TransportEvent QuarantineTransportEvent;
	private TransportEvent PositioningTransportEvent;
	private List<TransportEvent> transportEvents = new ArrayList<>();
	private TransportEvent LoadingTransportEvent;
	private TransportEvent DeliveryTransportEvent;
	private TransportEvent PickupTransportEvent;
	private TransportEvent HandlingTransportEvent;
	private TransportHandlingUnit PackagedTransportHandlingUnit;
	private TransportMeans ApplicableTransportMeans;

	

}// end TransportEquipment