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
	private Despatch m_Despatch;
	private Dimension MeasurementDimension;
	private DocumentReference ShipmentDocumentReference;
	private GoodsItem m_GoodsItem;
	private HazardousGoodsTransit m_HazardousGoodsTransit;
	private Location LoadingLocation;
	private Location UnloadingLocation;
	private Location StorageLocation;
	private Package m_Package;
	private Party OwnerParty;
	private Party OperatingParty;
	private Party ProviderParty;
	private Party LoadingProofParty;
	private Pickup m_Pickup;
	private SupplierParty m_SupplierParty;
	private Temperature MaximumTemperature;
	private Temperature MinimumTemperature;
	private TradingTerms HaulageTradingTerms;
	private TransportEquipment ContainedInTransportEquipment;
	private TransportEquipment AttachedTransportEquipment;
	private TransportEquipmentSeal m_TransportEquipmentSeal;
	private TransportEvent QuarantineTransportEvent;
	private TransportEvent PositioningTransportEvent;
	private TransportEvent m_TransportEvent;
	private TransportEvent LoadingTransportEvent;
	private TransportEvent DeliveryTransportEvent;
	private TransportEvent PickupTransportEvent;
	private TransportEvent HandlingTransportEvent;
	private TransportHandlingUnit PackagedTransportHandlingUnit;
	private TransportMeans ApplicableTransportMeans;

	/**
	 * @return the airFlowPercent
	 */
	public BigDecimal getAirFlowPercent() {
		return AirFlowPercent;
	}

	/**
	 * @param airFlowPercent
	 *            the airFlowPercent to set
	 */
	public void setAirFlowPercent(BigDecimal airFlowPercent) {
		AirFlowPercent = airFlowPercent;
	}

	/**
	 * @return the animalFoodApprovedIndicator
	 */
	public boolean isAnimalFoodApprovedIndicator() {
		return AnimalFoodApprovedIndicator;
	}

	/**
	 * @param animalFoodApprovedIndicator
	 *            the animalFoodApprovedIndicator to set
	 */
	public void setAnimalFoodApprovedIndicator(boolean animalFoodApprovedIndicator) {
		AnimalFoodApprovedIndicator = animalFoodApprovedIndicator;
	}

	/**
	 * @return the characteristics
	 */
	public String getCharacteristics() {
		return Characteristics;
	}

	/**
	 * @param characteristics
	 *            the characteristics to set
	 */
	public void setCharacteristics(String characteristics) {
		Characteristics = characteristics;
	}

	/**
	 * @return the damageRemarks
	 */
	public String getDamageRemarks() {
		return DamageRemarks;
	}

	/**
	 * @param damageRemarks
	 *            the damageRemarks to set
	 */
	public void setDamageRemarks(String damageRemarks) {
		DamageRemarks = damageRemarks;
	}

	/**
	 * @return the dangerousGoodsApprovedIndicator
	 */
	public boolean isDangerousGoodsApprovedIndicator() {
		return DangerousGoodsApprovedIndicator;
	}

	/**
	 * @param dangerousGoodsApprovedIndicator
	 *            the dangerousGoodsApprovedIndicator to set
	 */
	public void setDangerousGoodsApprovedIndicator(boolean dangerousGoodsApprovedIndicator) {
		DangerousGoodsApprovedIndicator = dangerousGoodsApprovedIndicator;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return Description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		Description = description;
	}

	/**
	 * @return the dispositionCode
	 */
	public String getDispositionCode() {
		return DispositionCode;
	}

	/**
	 * @param dispositionCode
	 *            the dispositionCode to set
	 */
	public void setDispositionCode(String dispositionCode) {
		DispositionCode = dispositionCode;
	}

	/**
	 * @return the fullnessIndicationCode
	 */
	public String getFullnessIndicationCode() {
		return FullnessIndicationCode;
	}

	/**
	 * @param fullnessIndicationCode
	 *            the fullnessIndicationCode to set
	 */
	public void setFullnessIndicationCode(String fullnessIndicationCode) {
		FullnessIndicationCode = fullnessIndicationCode;
	}

	/**
	 * @return the grossVolumeMeasure
	 */
	public BigDecimal getGrossVolumeMeasure() {
		return GrossVolumeMeasure;
	}

	/**
	 * @param grossVolumeMeasure
	 *            the grossVolumeMeasure to set
	 */
	public void setGrossVolumeMeasure(BigDecimal grossVolumeMeasure) {
		GrossVolumeMeasure = grossVolumeMeasure;
	}

	/**
	 * @return the grossWeightMeasure
	 */
	public BigDecimal getGrossWeightMeasure() {
		return GrossWeightMeasure;
	}

	/**
	 * @param grossWeightMeasure
	 *            the grossWeightMeasure to set
	 */
	public void setGrossWeightMeasure(BigDecimal grossWeightMeasure) {
		GrossWeightMeasure = grossWeightMeasure;
	}

	/**
	 * @return the humanFoodApprovedIndicator
	 */
	public boolean isHumanFoodApprovedIndicator() {
		return HumanFoodApprovedIndicator;
	}

	/**
	 * @param humanFoodApprovedIndicator
	 *            the humanFoodApprovedIndicator to set
	 */
	public void setHumanFoodApprovedIndicator(boolean humanFoodApprovedIndicator) {
		HumanFoodApprovedIndicator = humanFoodApprovedIndicator;
	}

	/**
	 * @return the humidityPercent
	 */
	public BigDecimal getHumidityPercent() {
		return HumidityPercent;
	}

	/**
	 * @param humidityPercent
	 *            the humidityPercent to set
	 */
	public void setHumidityPercent(BigDecimal humidityPercent) {
		HumidityPercent = humidityPercent;
	}

	/**
	 * @return the iD
	 */
	public String getID() {
		return ID;
	}

	/**
	 * @param iD
	 *            the iD to set
	 */
	public void setID(String iD) {
		ID = iD;
	}

	/**
	 * @return the information
	 */
	public String getInformation() {
		return Information;
	}

	/**
	 * @param information
	 *            the information to set
	 */
	public void setInformation(String information) {
		Information = information;
	}

	/**
	 * @return the legalStatusIndicator
	 */
	public boolean isLegalStatusIndicator() {
		return LegalStatusIndicator;
	}

	/**
	 * @param legalStatusIndicator
	 *            the legalStatusIndicator to set
	 */
	public void setLegalStatusIndicator(boolean legalStatusIndicator) {
		LegalStatusIndicator = legalStatusIndicator;
	}

	/**
	 * @return the ownerTypeCode
	 */
	public String getOwnerTypeCode() {
		return OwnerTypeCode;
	}

	/**
	 * @param ownerTypeCode
	 *            the ownerTypeCode to set
	 */
	public void setOwnerTypeCode(String ownerTypeCode) {
		OwnerTypeCode = ownerTypeCode;
	}

	/**
	 * @return the powerIndicator
	 */
	public boolean isPowerIndicator() {
		return PowerIndicator;
	}

	/**
	 * @param powerIndicator
	 *            the powerIndicator to set
	 */
	public void setPowerIndicator(boolean powerIndicator) {
		PowerIndicator = powerIndicator;
	}

	/**
	 * @return the providerTypeCode
	 */
	public String getProviderTypeCode() {
		return ProviderTypeCode;
	}

	/**
	 * @param providerTypeCode
	 *            the providerTypeCode to set
	 */
	public void setProviderTypeCode(String providerTypeCode) {
		ProviderTypeCode = providerTypeCode;
	}

	/**
	 * @return the referencedConsignmentID
	 */
	public String getReferencedConsignmentID() {
		return ReferencedConsignmentID;
	}

	/**
	 * @param referencedConsignmentID
	 *            the referencedConsignmentID to set
	 */
	public void setReferencedConsignmentID(String referencedConsignmentID) {
		ReferencedConsignmentID = referencedConsignmentID;
	}

	/**
	 * @return the refrigeratedIndicator
	 */
	public boolean isRefrigeratedIndicator() {
		return RefrigeratedIndicator;
	}

	/**
	 * @param refrigeratedIndicator
	 *            the refrigeratedIndicator to set
	 */
	public void setRefrigeratedIndicator(boolean refrigeratedIndicator) {
		RefrigeratedIndicator = refrigeratedIndicator;
	}

	/**
	 * @return the refrigerationOnIndicator
	 */
	public boolean isRefrigerationOnIndicator() {
		return RefrigerationOnIndicator;
	}

	/**
	 * @param refrigerationOnIndicator
	 *            the refrigerationOnIndicator to set
	 */
	public void setRefrigerationOnIndicator(boolean refrigerationOnIndicator) {
		RefrigerationOnIndicator = refrigerationOnIndicator;
	}

	/**
	 * @return the returnabilityIndicator
	 */
	public boolean isReturnabilityIndicator() {
		return ReturnabilityIndicator;
	}

	/**
	 * @param returnabilityIndicator
	 *            the returnabilityIndicator to set
	 */
	public void setReturnabilityIndicator(boolean returnabilityIndicator) {
		ReturnabilityIndicator = returnabilityIndicator;
	}

	/**
	 * @return the sizeTypeCode
	 */
	public String getSizeTypeCode() {
		return SizeTypeCode;
	}

	/**
	 * @param sizeTypeCode
	 *            the sizeTypeCode to set
	 */
	public void setSizeTypeCode(String sizeTypeCode) {
		SizeTypeCode = sizeTypeCode;
	}

	/**
	 * @return the specialTransportRequirements
	 */
	public String getSpecialTransportRequirements() {
		return SpecialTransportRequirements;
	}

	/**
	 * @param specialTransportRequirements
	 *            the specialTransportRequirements to set
	 */
	public void setSpecialTransportRequirements(String specialTransportRequirements) {
		SpecialTransportRequirements = specialTransportRequirements;
	}

	/**
	 * @return the tareWeightMeasure
	 */
	public BigDecimal getTareWeightMeasure() {
		return TareWeightMeasure;
	}

	/**
	 * @param tareWeightMeasure
	 *            the tareWeightMeasure to set
	 */
	public void setTareWeightMeasure(BigDecimal tareWeightMeasure) {
		TareWeightMeasure = tareWeightMeasure;
	}

	/**
	 * @return the traceID
	 */
	public String getTraceID() {
		return TraceID;
	}

	/**
	 * @param traceID
	 *            the traceID to set
	 */
	public void setTraceID(String traceID) {
		TraceID = traceID;
	}

	/**
	 * @return the trackingDeviceCode
	 */
	public String getTrackingDeviceCode() {
		return TrackingDeviceCode;
	}

	/**
	 * @param trackingDeviceCode
	 *            the trackingDeviceCode to set
	 */
	public void setTrackingDeviceCode(String trackingDeviceCode) {
		TrackingDeviceCode = trackingDeviceCode;
	}

	/**
	 * @return the transportEquipmentTypeCode
	 */
	public String getTransportEquipmentTypeCode() {
		return TransportEquipmentTypeCode;
	}

	/**
	 * @param transportEquipmentTypeCode
	 *            the transportEquipmentTypeCode to set
	 */
	public void setTransportEquipmentTypeCode(String transportEquipmentTypeCode) {
		TransportEquipmentTypeCode = transportEquipmentTypeCode;
	}

	/**
	 * @return the serviceAllowanceCharge
	 */
	public AllowanceCharge getServiceAllowanceCharge() {
		return ServiceAllowanceCharge;
	}

	/**
	 * @param serviceAllowanceCharge
	 *            the serviceAllowanceCharge to set
	 */
	public void setServiceAllowanceCharge(AllowanceCharge serviceAllowanceCharge) {
		ServiceAllowanceCharge = serviceAllowanceCharge;
	}

	/**
	 * @return the freightAllowanceCharge
	 */
	public AllowanceCharge getFreightAllowanceCharge() {
		return FreightAllowanceCharge;
	}

	/**
	 * @param freightAllowanceCharge
	 *            the freightAllowanceCharge to set
	 */
	public void setFreightAllowanceCharge(AllowanceCharge freightAllowanceCharge) {
		FreightAllowanceCharge = freightAllowanceCharge;
	}

	/**
	 * @return the m_Delivery
	 */
	public Delivery getM_Delivery() {
		return m_Delivery;
	}

	/**
	 * @param m_Delivery
	 *            the m_Delivery to set
	 */
	public void setM_Delivery(Delivery m_Delivery) {
		this.m_Delivery = m_Delivery;
	}

	/**
	 * @return the m_Despatch
	 */
	public Despatch getM_Despatch() {
		return m_Despatch;
	}

	/**
	 * @param m_Despatch
	 *            the m_Despatch to set
	 */
	public void setM_Despatch(Despatch m_Despatch) {
		this.m_Despatch = m_Despatch;
	}

	/**
	 * @return the measurementDimension
	 */
	public Dimension getMeasurementDimension() {
		return MeasurementDimension;
	}

	/**
	 * @param measurementDimension
	 *            the measurementDimension to set
	 */
	public void setMeasurementDimension(Dimension measurementDimension) {
		MeasurementDimension = measurementDimension;
	}

	/**
	 * @return the shipmentDocumentReference
	 */
	public DocumentReference getShipmentDocumentReference() {
		return ShipmentDocumentReference;
	}

	/**
	 * @param shipmentDocumentReference
	 *            the shipmentDocumentReference to set
	 */
	public void setShipmentDocumentReference(DocumentReference shipmentDocumentReference) {
		ShipmentDocumentReference = shipmentDocumentReference;
	}

	/**
	 * @return the m_GoodsItem
	 */
	public GoodsItem getM_GoodsItem() {
		return m_GoodsItem;
	}

	/**
	 * @param m_GoodsItem
	 *            the m_GoodsItem to set
	 */
	public void setM_GoodsItem(GoodsItem m_GoodsItem) {
		this.m_GoodsItem = m_GoodsItem;
	}

	/**
	 * @return the m_HazardousGoodsTransit
	 */
	public HazardousGoodsTransit getM_HazardousGoodsTransit() {
		return m_HazardousGoodsTransit;
	}

	/**
	 * @param m_HazardousGoodsTransit
	 *            the m_HazardousGoodsTransit to set
	 */
	public void setM_HazardousGoodsTransit(HazardousGoodsTransit m_HazardousGoodsTransit) {
		this.m_HazardousGoodsTransit = m_HazardousGoodsTransit;
	}

	/**
	 * @return the loadingLocation
	 */
	public Location getLoadingLocation() {
		return LoadingLocation;
	}

	/**
	 * @param loadingLocation
	 *            the loadingLocation to set
	 */
	public void setLoadingLocation(Location loadingLocation) {
		LoadingLocation = loadingLocation;
	}

	/**
	 * @return the unloadingLocation
	 */
	public Location getUnloadingLocation() {
		return UnloadingLocation;
	}

	/**
	 * @param unloadingLocation
	 *            the unloadingLocation to set
	 */
	public void setUnloadingLocation(Location unloadingLocation) {
		UnloadingLocation = unloadingLocation;
	}

	/**
	 * @return the storageLocation
	 */
	public Location getStorageLocation() {
		return StorageLocation;
	}

	/**
	 * @param storageLocation
	 *            the storageLocation to set
	 */
	public void setStorageLocation(Location storageLocation) {
		StorageLocation = storageLocation;
	}

	/**
	 * @return the m_Package
	 */
	public Package getM_Package() {
		return m_Package;
	}

	/**
	 * @param m_Package
	 *            the m_Package to set
	 */
	public void setM_Package(Package m_Package) {
		this.m_Package = m_Package;
	}

	/**
	 * @return the ownerParty
	 */
	public Party getOwnerParty() {
		return OwnerParty;
	}

	/**
	 * @param ownerParty
	 *            the ownerParty to set
	 */
	public void setOwnerParty(Party ownerParty) {
		OwnerParty = ownerParty;
	}

	/**
	 * @return the operatingParty
	 */
	public Party getOperatingParty() {
		return OperatingParty;
	}

	/**
	 * @param operatingParty
	 *            the operatingParty to set
	 */
	public void setOperatingParty(Party operatingParty) {
		OperatingParty = operatingParty;
	}

	/**
	 * @return the providerParty
	 */
	public Party getProviderParty() {
		return ProviderParty;
	}

	/**
	 * @param providerParty
	 *            the providerParty to set
	 */
	public void setProviderParty(Party providerParty) {
		ProviderParty = providerParty;
	}

	/**
	 * @return the loadingProofParty
	 */
	public Party getLoadingProofParty() {
		return LoadingProofParty;
	}

	/**
	 * @param loadingProofParty
	 *            the loadingProofParty to set
	 */
	public void setLoadingProofParty(Party loadingProofParty) {
		LoadingProofParty = loadingProofParty;
	}

	/**
	 * @return the m_Pickup
	 */
	public Pickup getM_Pickup() {
		return m_Pickup;
	}

	/**
	 * @param m_Pickup
	 *            the m_Pickup to set
	 */
	public void setM_Pickup(Pickup m_Pickup) {
		this.m_Pickup = m_Pickup;
	}

	/**
	 * @return the m_SupplierParty
	 */
	public SupplierParty getM_SupplierParty() {
		return m_SupplierParty;
	}

	/**
	 * @param m_SupplierParty
	 *            the m_SupplierParty to set
	 */
	public void setM_SupplierParty(SupplierParty m_SupplierParty) {
		this.m_SupplierParty = m_SupplierParty;
	}

	/**
	 * @return the maximumTemperature
	 */
	public Temperature getMaximumTemperature() {
		return MaximumTemperature;
	}

	/**
	 * @param maximumTemperature
	 *            the maximumTemperature to set
	 */
	public void setMaximumTemperature(Temperature maximumTemperature) {
		MaximumTemperature = maximumTemperature;
	}

	/**
	 * @return the minimumTemperature
	 */
	public Temperature getMinimumTemperature() {
		return MinimumTemperature;
	}

	/**
	 * @param minimumTemperature
	 *            the minimumTemperature to set
	 */
	public void setMinimumTemperature(Temperature minimumTemperature) {
		MinimumTemperature = minimumTemperature;
	}

	/**
	 * @return the haulageTradingTerms
	 */
	public TradingTerms getHaulageTradingTerms() {
		return HaulageTradingTerms;
	}

	/**
	 * @param haulageTradingTerms
	 *            the haulageTradingTerms to set
	 */
	public void setHaulageTradingTerms(TradingTerms haulageTradingTerms) {
		HaulageTradingTerms = haulageTradingTerms;
	}

	/**
	 * @return the containedInTransportEquipment
	 */
	public TransportEquipment getContainedInTransportEquipment() {
		return ContainedInTransportEquipment;
	}

	/**
	 * @param containedInTransportEquipment
	 *            the containedInTransportEquipment to set
	 */
	public void setContainedInTransportEquipment(TransportEquipment containedInTransportEquipment) {
		ContainedInTransportEquipment = containedInTransportEquipment;
	}

	/**
	 * @return the attachedTransportEquipment
	 */
	public TransportEquipment getAttachedTransportEquipment() {
		return AttachedTransportEquipment;
	}

	/**
	 * @param attachedTransportEquipment
	 *            the attachedTransportEquipment to set
	 */
	public void setAttachedTransportEquipment(TransportEquipment attachedTransportEquipment) {
		AttachedTransportEquipment = attachedTransportEquipment;
	}

	/**
	 * @return the m_TransportEquipmentSeal
	 */
	public TransportEquipmentSeal getM_TransportEquipmentSeal() {
		return m_TransportEquipmentSeal;
	}

	/**
	 * @param m_TransportEquipmentSeal
	 *            the m_TransportEquipmentSeal to set
	 */
	public void setM_TransportEquipmentSeal(TransportEquipmentSeal m_TransportEquipmentSeal) {
		this.m_TransportEquipmentSeal = m_TransportEquipmentSeal;
	}

	/**
	 * @return the quarantineTransportEvent
	 */
	public TransportEvent getQuarantineTransportEvent() {
		return QuarantineTransportEvent;
	}

	/**
	 * @param quarantineTransportEvent
	 *            the quarantineTransportEvent to set
	 */
	public void setQuarantineTransportEvent(TransportEvent quarantineTransportEvent) {
		QuarantineTransportEvent = quarantineTransportEvent;
	}

	/**
	 * @return the positioningTransportEvent
	 */
	public TransportEvent getPositioningTransportEvent() {
		return PositioningTransportEvent;
	}

	/**
	 * @param positioningTransportEvent
	 *            the positioningTransportEvent to set
	 */
	public void setPositioningTransportEvent(TransportEvent positioningTransportEvent) {
		PositioningTransportEvent = positioningTransportEvent;
	}

	/**
	 * @return the m_TransportEvent
	 */
	public TransportEvent getM_TransportEvent() {
		return m_TransportEvent;
	}

	/**
	 * @param m_TransportEvent
	 *            the m_TransportEvent to set
	 */
	public void setM_TransportEvent(TransportEvent m_TransportEvent) {
		this.m_TransportEvent = m_TransportEvent;
	}

	/**
	 * @return the loadingTransportEvent
	 */
	public TransportEvent getLoadingTransportEvent() {
		return LoadingTransportEvent;
	}

	/**
	 * @param loadingTransportEvent
	 *            the loadingTransportEvent to set
	 */
	public void setLoadingTransportEvent(TransportEvent loadingTransportEvent) {
		LoadingTransportEvent = loadingTransportEvent;
	}

	/**
	 * @return the deliveryTransportEvent
	 */
	public TransportEvent getDeliveryTransportEvent() {
		return DeliveryTransportEvent;
	}

	/**
	 * @param deliveryTransportEvent
	 *            the deliveryTransportEvent to set
	 */
	public void setDeliveryTransportEvent(TransportEvent deliveryTransportEvent) {
		DeliveryTransportEvent = deliveryTransportEvent;
	}

	/**
	 * @return the pickupTransportEvent
	 */
	public TransportEvent getPickupTransportEvent() {
		return PickupTransportEvent;
	}

	/**
	 * @param pickupTransportEvent
	 *            the pickupTransportEvent to set
	 */
	public void setPickupTransportEvent(TransportEvent pickupTransportEvent) {
		PickupTransportEvent = pickupTransportEvent;
	}

	/**
	 * @return the handlingTransportEvent
	 */
	public TransportEvent getHandlingTransportEvent() {
		return HandlingTransportEvent;
	}

	/**
	 * @param handlingTransportEvent
	 *            the handlingTransportEvent to set
	 */
	public void setHandlingTransportEvent(TransportEvent handlingTransportEvent) {
		HandlingTransportEvent = handlingTransportEvent;
	}

	/**
	 * @return the packagedTransportHandlingUnit
	 */
	public TransportHandlingUnit getPackagedTransportHandlingUnit() {
		return PackagedTransportHandlingUnit;
	}

	/**
	 * @param packagedTransportHandlingUnit
	 *            the packagedTransportHandlingUnit to set
	 */
	public void setPackagedTransportHandlingUnit(TransportHandlingUnit packagedTransportHandlingUnit) {
		PackagedTransportHandlingUnit = packagedTransportHandlingUnit;
	}

	/**
	 * @return the applicableTransportMeans
	 */
	public TransportMeans getApplicableTransportMeans() {
		return ApplicableTransportMeans;
	}

	/**
	 * @param applicableTransportMeans
	 *            the applicableTransportMeans to set
	 */
	public void setApplicableTransportMeans(TransportMeans applicableTransportMeans) {
		ApplicableTransportMeans = applicableTransportMeans;
	}

}// end TransportEquipment