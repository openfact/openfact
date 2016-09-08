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
    private BigDecimal airFlowPercent;
    /**
     * An indicator that this piece of transport equipment is approved for
     * animal food (true) or not (false).
     */
    private boolean animalFoodApprovedIndicator;
    /**
     * Characteristics of this piece of transport equipment.
     */
    private String aharacteristics;
    /**
     * Damage associated with this piece of transport equipment.
     */
    private String aamageRemarks;
    /**
     * An indicator that this piece of transport equipment is approved for
     * dangerous goods (true) or not (false).
     */
    private boolean dangerousGoodsApprovedIndicator;
    /**
     * Text describing this piece of transport equipment.
     */
    private String description;
    /**
     * A code signifying the current disposition of this piece of transport
     * equipment.
     */
    private String dispositionCode;
    /**
     * A code signifying whether this piece of transport equipment is full,
     * partially full, or empty.
     */
    private String fullnessIndicationCode;
    /**
     * The gross volume of this piece of transport equipment.
     */
    private BigDecimal grossVolumeMeasure;
    /**
     * The gross weight of this piece of transport equipment.
     */
    private BigDecimal grossWeightMeasure;
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
    private String id;
    /**
     * Additional information about this piece of transport equipment.
     */
    private String information;
    /**
     * An indication of the legal status of this piece of transport equipment
     * with respect to the Container Convention Code.
     */
    private boolean legalStatusIndicator;
    /**
     * A code signifying the type of owner of this piece of transport equipment.
     */
    private String ownerTypeCode;
    /**
     * An indicator that this piece of transport equipment can supply power
     * (true) or not (false).
     */
    private boolean powerIndicator;
    /**
     * A code signifying the type of provider of this piece of transport
     * equipment.
     */
    private String providerTypeCode;
    /**
     * An identifier for the consignment contained by this piece of transport
     * equipment.
     */
    private String referencedConsignmentID;
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
     * it is recommended to use ContainerSizeTypeCode for validation.
     */
    private String sizeTypeCode;
    /**
     * Special transport requirements expressed as text.
     */
    private String specialTransportRequirements;
    /**
     * The weight of this piece of transport equipment when empty.
     */
    private BigDecimal tareWeightMeasure;
    /**
     * An identifier for use in tracing this piece of transport equipment, such
     * as the EPC number used in RFID.
     */
    private String traceID;
    /**
     * A code signifying the tracking device for this piece of transport
     * equipment.
     */
    private String trackingDeviceCode;
    /**
     * A code signifying the type of this piece of transport equipment.
     */
    private String transportEquipmentTypeCode;
    private AllowanceCharge serviceAllowanceCharge;
    private AllowanceCharge freightAllowanceCharge;
    private List<Delivery> deliveries = new ArrayList<>();
    private List<Despatch> despatchs = new ArrayList<>();
    private Dimension measurementDimension;
    private DocumentReference shipmentDocumentReference;
    private List<GoodsItem> goodsItems = new ArrayList<>();
    private List<HazardousGoodsTransit> hazardousGoodsTransits = new ArrayList<>();
    private Location loadingLocation;
    private Location unloadingLocation;
    private Location storageLocation;
    private List<Package> packages = new ArrayList<>();
    private Party ownerParty;
    private Party operatingParty;
    private Party providerParty;
    private Party loadingProofParty;
    private List<Pickup> pickups = new ArrayList<>();
    private List<SupplierParty> supplierParties = new ArrayList<>();
    private Temperature maximumTemperature;
    private Temperature minimumTemperature;
    private TradingTerms haulageTradingTerms;
    private TransportEquipment containedInTransportEquipment;
    private TransportEquipment attachedTransportEquipment;
    private List<TransportEquipmentSeal> transportEquipmentSeals = new ArrayList<>();
    private TransportEvent quarantineTransportEvent;
    private TransportEvent positioningTransportEvent;
    private List<TransportEvent> transportEvents = new ArrayList<>();
    private TransportEvent loadingTransportEvent;
    private TransportEvent deliveryTransportEvent;
    private TransportEvent pickupTransportEvent;
    private TransportEvent handlingTransportEvent;
    private TransportHandlingUnit packagedTransportHandlingUnit;
    private TransportMeans applicableTransportMeans;

    public BigDecimal getAirFlowPercent() {
        return airFlowPercent;
    }

    public void setAirFlowPercent(BigDecimal airFlowPercent) {
        this.airFlowPercent = airFlowPercent;
    }

    public boolean isAnimalFoodApprovedIndicator() {
        return animalFoodApprovedIndicator;
    }

    public void setAnimalFoodApprovedIndicator(boolean animalFoodApprovedIndicator) {
        this.animalFoodApprovedIndicator = animalFoodApprovedIndicator;
    }

    public String getAharacteristics() {
        return aharacteristics;
    }

    public void setAharacteristics(String aharacteristics) {
        this.aharacteristics = aharacteristics;
    }

    public String getAamageRemarks() {
        return aamageRemarks;
    }

    public void setAamageRemarks(String aamageRemarks) {
        this.aamageRemarks = aamageRemarks;
    }

    public boolean isDangerousGoodsApprovedIndicator() {
        return dangerousGoodsApprovedIndicator;
    }

    public void setDangerousGoodsApprovedIndicator(boolean dangerousGoodsApprovedIndicator) {
        this.dangerousGoodsApprovedIndicator = dangerousGoodsApprovedIndicator;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDispositionCode() {
        return dispositionCode;
    }

    public void setDispositionCode(String dispositionCode) {
        this.dispositionCode = dispositionCode;
    }

    public String getFullnessIndicationCode() {
        return fullnessIndicationCode;
    }

    public void setFullnessIndicationCode(String fullnessIndicationCode) {
        this.fullnessIndicationCode = fullnessIndicationCode;
    }

    public BigDecimal getGrossVolumeMeasure() {
        return grossVolumeMeasure;
    }

    public void setGrossVolumeMeasure(BigDecimal grossVolumeMeasure) {
        this.grossVolumeMeasure = grossVolumeMeasure;
    }

    public BigDecimal getGrossWeightMeasure() {
        return grossWeightMeasure;
    }

    public void setGrossWeightMeasure(BigDecimal grossWeightMeasure) {
        this.grossWeightMeasure = grossWeightMeasure;
    }

    public boolean isHumanFoodApprovedIndicator() {
        return humanFoodApprovedIndicator;
    }

    public void setHumanFoodApprovedIndicator(boolean humanFoodApprovedIndicator) {
        this.humanFoodApprovedIndicator = humanFoodApprovedIndicator;
    }

    public BigDecimal getHumidityPercent() {
        return humidityPercent;
    }

    public void setHumidityPercent(BigDecimal humidityPercent) {
        this.humidityPercent = humidityPercent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public boolean isLegalStatusIndicator() {
        return legalStatusIndicator;
    }

    public void setLegalStatusIndicator(boolean legalStatusIndicator) {
        this.legalStatusIndicator = legalStatusIndicator;
    }

    public String getOwnerTypeCode() {
        return ownerTypeCode;
    }

    public void setOwnerTypeCode(String ownerTypeCode) {
        this.ownerTypeCode = ownerTypeCode;
    }

    public boolean isPowerIndicator() {
        return powerIndicator;
    }

    public void setPowerIndicator(boolean powerIndicator) {
        this.powerIndicator = powerIndicator;
    }

    public String getProviderTypeCode() {
        return providerTypeCode;
    }

    public void setProviderTypeCode(String providerTypeCode) {
        this.providerTypeCode = providerTypeCode;
    }

    public String getReferencedConsignmentID() {
        return referencedConsignmentID;
    }

    public void setReferencedConsignmentID(String referencedConsignmentID) {
        this.referencedConsignmentID = referencedConsignmentID;
    }

    public boolean isRefrigeratedIndicator() {
        return refrigeratedIndicator;
    }

    public void setRefrigeratedIndicator(boolean refrigeratedIndicator) {
        this.refrigeratedIndicator = refrigeratedIndicator;
    }

    public boolean isRefrigerationOnIndicator() {
        return refrigerationOnIndicator;
    }

    public void setRefrigerationOnIndicator(boolean refrigerationOnIndicator) {
        this.refrigerationOnIndicator = refrigerationOnIndicator;
    }

    public boolean isReturnabilityIndicator() {
        return returnabilityIndicator;
    }

    public void setReturnabilityIndicator(boolean returnabilityIndicator) {
        this.returnabilityIndicator = returnabilityIndicator;
    }

    public String getSizeTypeCode() {
        return sizeTypeCode;
    }

    public void setSizeTypeCode(String sizeTypeCode) {
        this.sizeTypeCode = sizeTypeCode;
    }

    public String getSpecialTransportRequirements() {
        return specialTransportRequirements;
    }

    public void setSpecialTransportRequirements(String specialTransportRequirements) {
        this.specialTransportRequirements = specialTransportRequirements;
    }

    public BigDecimal getTareWeightMeasure() {
        return tareWeightMeasure;
    }

    public void setTareWeightMeasure(BigDecimal tareWeightMeasure) {
        this.tareWeightMeasure = tareWeightMeasure;
    }

    public String getTraceID() {
        return traceID;
    }

    public void setTraceID(String traceID) {
        this.traceID = traceID;
    }

    public String getTrackingDeviceCode() {
        return trackingDeviceCode;
    }

    public void setTrackingDeviceCode(String trackingDeviceCode) {
        this.trackingDeviceCode = trackingDeviceCode;
    }

    public String getTransportEquipmentTypeCode() {
        return transportEquipmentTypeCode;
    }

    public void setTransportEquipmentTypeCode(String transportEquipmentTypeCode) {
        this.transportEquipmentTypeCode = transportEquipmentTypeCode;
    }

    public AllowanceCharge getServiceAllowanceCharge() {
        return serviceAllowanceCharge;
    }

    public void setServiceAllowanceCharge(AllowanceCharge serviceAllowanceCharge) {
        this.serviceAllowanceCharge = serviceAllowanceCharge;
    }

    public AllowanceCharge getFreightAllowanceCharge() {
        return freightAllowanceCharge;
    }

    public void setFreightAllowanceCharge(AllowanceCharge freightAllowanceCharge) {
        this.freightAllowanceCharge = freightAllowanceCharge;
    }

    public List<Delivery> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(List<Delivery> deliveries) {
        this.deliveries = deliveries;
    }

    public List<Despatch> getDespatchs() {
        return despatchs;
    }

    public void setDespatchs(List<Despatch> despatchs) {
        this.despatchs = despatchs;
    }

    public Dimension getMeasurementDimension() {
        return measurementDimension;
    }

    public void setMeasurementDimension(Dimension measurementDimension) {
        this.measurementDimension = measurementDimension;
    }

    public DocumentReference getShipmentDocumentReference() {
        return shipmentDocumentReference;
    }

    public void setShipmentDocumentReference(DocumentReference shipmentDocumentReference) {
        this.shipmentDocumentReference = shipmentDocumentReference;
    }

    public List<GoodsItem> getGoodsItems() {
        return goodsItems;
    }

    public void setGoodsItems(List<GoodsItem> goodsItems) {
        this.goodsItems = goodsItems;
    }

    public List<HazardousGoodsTransit> getHazardousGoodsTransits() {
        return hazardousGoodsTransits;
    }

    public void setHazardousGoodsTransits(List<HazardousGoodsTransit> hazardousGoodsTransits) {
        this.hazardousGoodsTransits = hazardousGoodsTransits;
    }

    public Location getLoadingLocation() {
        return loadingLocation;
    }

    public void setLoadingLocation(Location loadingLocation) {
        this.loadingLocation = loadingLocation;
    }

    public Location getUnloadingLocation() {
        return unloadingLocation;
    }

    public void setUnloadingLocation(Location unloadingLocation) {
        this.unloadingLocation = unloadingLocation;
    }

    public Location getStorageLocation() {
        return storageLocation;
    }

    public void setStorageLocation(Location storageLocation) {
        this.storageLocation = storageLocation;
    }

    public List<Package> getPackages() {
        return packages;
    }

    public void setPackages(List<Package> packages) {
        this.packages = packages;
    }

    public Party getOwnerParty() {
        return ownerParty;
    }

    public void setOwnerParty(Party ownerParty) {
        this.ownerParty = ownerParty;
    }

    public Party getOperatingParty() {
        return operatingParty;
    }

    public void setOperatingParty(Party operatingParty) {
        this.operatingParty = operatingParty;
    }

    public Party getProviderParty() {
        return providerParty;
    }

    public void setProviderParty(Party providerParty) {
        this.providerParty = providerParty;
    }

    public Party getLoadingProofParty() {
        return loadingProofParty;
    }

    public void setLoadingProofParty(Party loadingProofParty) {
        this.loadingProofParty = loadingProofParty;
    }

    public List<Pickup> getPickups() {
        return pickups;
    }

    public void setPickups(List<Pickup> pickups) {
        this.pickups = pickups;
    }

    public List<SupplierParty> getSupplierParties() {
        return supplierParties;
    }

    public void setSupplierParties(List<SupplierParty> supplierParties) {
        this.supplierParties = supplierParties;
    }

    public Temperature getMaximumTemperature() {
        return maximumTemperature;
    }

    public void setMaximumTemperature(Temperature maximumTemperature) {
        this.maximumTemperature = maximumTemperature;
    }

    public Temperature getMinimumTemperature() {
        return minimumTemperature;
    }

    public void setMinimumTemperature(Temperature minimumTemperature) {
        this.minimumTemperature = minimumTemperature;
    }

    public TradingTerms getHaulageTradingTerms() {
        return haulageTradingTerms;
    }

    public void setHaulageTradingTerms(TradingTerms haulageTradingTerms) {
        this.haulageTradingTerms = haulageTradingTerms;
    }

    public TransportEquipment getContainedInTransportEquipment() {
        return containedInTransportEquipment;
    }

    public void setContainedInTransportEquipment(TransportEquipment containedInTransportEquipment) {
        this.containedInTransportEquipment = containedInTransportEquipment;
    }

    public TransportEquipment getAttachedTransportEquipment() {
        return attachedTransportEquipment;
    }

    public void setAttachedTransportEquipment(TransportEquipment attachedTransportEquipment) {
        this.attachedTransportEquipment = attachedTransportEquipment;
    }

    public List<TransportEquipmentSeal> getTransportEquipmentSeals() {
        return transportEquipmentSeals;
    }

    public void setTransportEquipmentSeals(List<TransportEquipmentSeal> transportEquipmentSeals) {
        this.transportEquipmentSeals = transportEquipmentSeals;
    }

    public TransportEvent getQuarantineTransportEvent() {
        return quarantineTransportEvent;
    }

    public void setQuarantineTransportEvent(TransportEvent quarantineTransportEvent) {
        this.quarantineTransportEvent = quarantineTransportEvent;
    }

    public TransportEvent getPositioningTransportEvent() {
        return positioningTransportEvent;
    }

    public void setPositioningTransportEvent(TransportEvent positioningTransportEvent) {
        this.positioningTransportEvent = positioningTransportEvent;
    }

    public List<TransportEvent> getTransportEvents() {
        return transportEvents;
    }

    public void setTransportEvents(List<TransportEvent> transportEvents) {
        this.transportEvents = transportEvents;
    }

    public TransportEvent getLoadingTransportEvent() {
        return loadingTransportEvent;
    }

    public void setLoadingTransportEvent(TransportEvent loadingTransportEvent) {
        this.loadingTransportEvent = loadingTransportEvent;
    }

    public TransportEvent getDeliveryTransportEvent() {
        return deliveryTransportEvent;
    }

    public void setDeliveryTransportEvent(TransportEvent deliveryTransportEvent) {
        this.deliveryTransportEvent = deliveryTransportEvent;
    }

    public TransportEvent getPickupTransportEvent() {
        return pickupTransportEvent;
    }

    public void setPickupTransportEvent(TransportEvent pickupTransportEvent) {
        this.pickupTransportEvent = pickupTransportEvent;
    }

    public TransportEvent getHandlingTransportEvent() {
        return handlingTransportEvent;
    }

    public void setHandlingTransportEvent(TransportEvent handlingTransportEvent) {
        this.handlingTransportEvent = handlingTransportEvent;
    }

    public TransportHandlingUnit getPackagedTransportHandlingUnit() {
        return packagedTransportHandlingUnit;
    }

    public void setPackagedTransportHandlingUnit(TransportHandlingUnit packagedTransportHandlingUnit) {
        this.packagedTransportHandlingUnit = packagedTransportHandlingUnit;
    }

    public TransportMeans getApplicableTransportMeans() {
        return applicableTransportMeans;
    }

    public void setApplicableTransportMeans(TransportMeans applicableTransportMeans) {
        this.applicableTransportMeans = applicableTransportMeans;
    }
}// end TransportEquipment