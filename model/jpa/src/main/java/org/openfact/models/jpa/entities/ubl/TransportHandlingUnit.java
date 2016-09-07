package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;

/**
 * A class to describe a uniquely identifiable unit consisting of one or more
 * packages, goods items, or pieces of transport equipment.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:46 a. m.
 */
public class TransportHandlingUnit {

    /**
     * Text describing damage associated with this transport handling unit.
     */
    private String damageRemarks;
    /**
     * The handling required for this transport handling unit, expressed as a
     * code.
     */
    private String handlingCode;
    /**
     * The handling required for this transport handling unit, expressed as
     * text.
     */
    private String handlingInstructions;
    /**
     * An indicator that the materials contained in this transport handling unit
     * are subject to an international regulation concerning the carriage of
     * dangerous goods (true) or not (false).
     */
    private boolean hazardousRiskIndicator;
    /**
     * An identifier for this transport handling unit.
     */
    private String ID;
    /**
     * Text describing the marks and numbers on this transport handling unit.
     */
    private String shippingMarks;
    /**
     * The total number of goods items in this transport handling unit.
     */
    private BigDecimal totalGoodsItemQuantity;
    /**
     * The total number of packages in this transport handling unit.
     */
    private BigDecimal totalPackageQuantity;
    /**
     * An identifier for use in tracing this transport handling unit, such as
     * the EPC number used in RFID.
     */
    private String traceID;
    /**
     * A code signifying the type of this transport handling unit.
     */
    private String transportHandlingUnitTypeCode;
    private List<CustomsDeclaration> customsDeclarations = new ArrayList<>();
    private Despatch lineHandlingUnitDespatchLine;
    private Dimension floorSpaceMeasurementDimension;
    private Dimension palletSpaceMeasurementDimension;
    private Dimension measurementDimension;
    private DocumentReference shipmentDocumentReference;
    private List<GoodsItem> goodsItems = new ArrayList<>();
    private List<HazardousGoodsTransit> hazardousGoodsTransits = new ArrayList<>();
    private List<Package> packages = new ArrayList<>();
    private Package actualPackage;
    private ReceiptLine receivedHandlingUnitReceiptLine;
    private Shipment referencedShipment;
    private List<Status> status = new ArrayList<>();
    private Temperature minimumTemperature;
    private Temperature maximumTemperature;
    private List<TransportEquipment> transportEquipments = new ArrayList<>();
    private List<TransportMeans> transportMeans = new ArrayList<>();

    /**
     * @return the damageRemarks
     */
    public String getDamageRemarks() {
        return damageRemarks;
    }

    /**
     * @param damageRemarks
     *            the damageRemarks to set
     */
    public void setDamageRemarks(String damageRemarks) {
        this.damageRemarks = damageRemarks;
    }

    /**
     * @return the handlingCode
     */
    public String getHandlingCode() {
        return handlingCode;
    }

    /**
     * @param handlingCode
     *            the handlingCode to set
     */
    public void setHandlingCode(String handlingCode) {
        this.handlingCode = handlingCode;
    }

    /**
     * @return the handlingInstructions
     */
    public String getHandlingInstructions() {
        return handlingInstructions;
    }

    /**
     * @param handlingInstructions
     *            the handlingInstructions to set
     */
    public void setHandlingInstructions(String handlingInstructions) {
        this.handlingInstructions = handlingInstructions;
    }

    /**
     * @return the hazardousRiskIndicator
     */
    public boolean isHazardousRiskIndicator() {
        return hazardousRiskIndicator;
    }

    /**
     * @param hazardousRiskIndicator
     *            the hazardousRiskIndicator to set
     */
    public void setHazardousRiskIndicator(boolean hazardousRiskIndicator) {
        this.hazardousRiskIndicator = hazardousRiskIndicator;
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
     * @return the shippingMarks
     */
    public String getShippingMarks() {
        return shippingMarks;
    }

    /**
     * @param shippingMarks
     *            the shippingMarks to set
     */
    public void setShippingMarks(String shippingMarks) {
        this.shippingMarks = shippingMarks;
    }

    /**
     * @return the totalGoodsItemQuantity
     */
    public BigDecimal getTotalGoodsItemQuantity() {
        return totalGoodsItemQuantity;
    }

    /**
     * @param totalGoodsItemQuantity
     *            the totalGoodsItemQuantity to set
     */
    public void setTotalGoodsItemQuantity(BigDecimal totalGoodsItemQuantity) {
        this.totalGoodsItemQuantity = totalGoodsItemQuantity;
    }

    /**
     * @return the totalPackageQuantity
     */
    public BigDecimal getTotalPackageQuantity() {
        return totalPackageQuantity;
    }

    /**
     * @param totalPackageQuantity
     *            the totalPackageQuantity to set
     */
    public void setTotalPackageQuantity(BigDecimal totalPackageQuantity) {
        this.totalPackageQuantity = totalPackageQuantity;
    }

    /**
     * @return the traceID
     */
    public String getTraceID() {
        return traceID;
    }

    /**
     * @param traceID
     *            the traceID to set
     */
    public void setTraceID(String traceID) {
        this.traceID = traceID;
    }

    /**
     * @return the transportHandlingUnitTypeCode
     */
    public String getTransportHandlingUnitTypeCode() {
        return transportHandlingUnitTypeCode;
    }

    /**
     * @param transportHandlingUnitTypeCode
     *            the transportHandlingUnitTypeCode to set
     */
    public void setTransportHandlingUnitTypeCode(String transportHandlingUnitTypeCode) {
        this.transportHandlingUnitTypeCode = transportHandlingUnitTypeCode;
    }

    /**
     * @return the customsDeclarations
     */
    public List<CustomsDeclaration> getCustomsDeclarations() {
        return customsDeclarations;
    }

    /**
     * @param customsDeclarations
     *            the customsDeclarations to set
     */
    public void setCustomsDeclarations(List<CustomsDeclaration> customsDeclarations) {
        this.customsDeclarations = customsDeclarations;
    }

    /**
     * @return the lineHandlingUnitDespatchLine
     */
    public Despatch getLineHandlingUnitDespatchLine() {
        return lineHandlingUnitDespatchLine;
    }

    /**
     * @param lineHandlingUnitDespatchLine
     *            the lineHandlingUnitDespatchLine to set
     */
    public void setLineHandlingUnitDespatchLine(Despatch lineHandlingUnitDespatchLine) {
        this.lineHandlingUnitDespatchLine = lineHandlingUnitDespatchLine;
    }

    /**
     * @return the floorSpaceMeasurementDimension
     */
    public Dimension getFloorSpaceMeasurementDimension() {
        return floorSpaceMeasurementDimension;
    }

    /**
     * @param floorSpaceMeasurementDimension
     *            the floorSpaceMeasurementDimension to set
     */
    public void setFloorSpaceMeasurementDimension(Dimension floorSpaceMeasurementDimension) {
        this.floorSpaceMeasurementDimension = floorSpaceMeasurementDimension;
    }

    /**
     * @return the palletSpaceMeasurementDimension
     */
    public Dimension getPalletSpaceMeasurementDimension() {
        return palletSpaceMeasurementDimension;
    }

    /**
     * @param palletSpaceMeasurementDimension
     *            the palletSpaceMeasurementDimension to set
     */
    public void setPalletSpaceMeasurementDimension(Dimension palletSpaceMeasurementDimension) {
        this.palletSpaceMeasurementDimension = palletSpaceMeasurementDimension;
    }

    /**
     * @return the measurementDimension
     */
    public Dimension getMeasurementDimension() {
        return measurementDimension;
    }

    /**
     * @param measurementDimension
     *            the measurementDimension to set
     */
    public void setMeasurementDimension(Dimension measurementDimension) {
        this.measurementDimension = measurementDimension;
    }

    /**
     * @return the shipmentDocumentReference
     */
    public DocumentReference getShipmentDocumentReference() {
        return shipmentDocumentReference;
    }

    /**
     * @param shipmentDocumentReference
     *            the shipmentDocumentReference to set
     */
    public void setShipmentDocumentReference(DocumentReference shipmentDocumentReference) {
        this.shipmentDocumentReference = shipmentDocumentReference;
    }

    /**
     * @return the goodsItems
     */
    public List<GoodsItem> getGoodsItems() {
        return goodsItems;
    }

    /**
     * @param goodsItems
     *            the goodsItems to set
     */
    public void setGoodsItems(List<GoodsItem> goodsItems) {
        this.goodsItems = goodsItems;
    }

    /**
     * @return the hazardousGoodsTransits
     */
    public List<HazardousGoodsTransit> getHazardousGoodsTransits() {
        return hazardousGoodsTransits;
    }

    /**
     * @param hazardousGoodsTransits
     *            the hazardousGoodsTransits to set
     */
    public void setHazardousGoodsTransits(List<HazardousGoodsTransit> hazardousGoodsTransits) {
        this.hazardousGoodsTransits = hazardousGoodsTransits;
    }

    /**
     * @return the packages
     */
    public List<Package> getPackages() {
        return packages;
    }

    /**
     * @param packages
     *            the packages to set
     */
    public void setPackages(List<Package> packages) {
        this.packages = packages;
    }

    /**
     * @return the actualPackage
     */
    public Package getActualPackage() {
        return actualPackage;
    }

    /**
     * @param actualPackage
     *            the actualPackage to set
     */
    public void setActualPackage(Package actualPackage) {
        this.actualPackage = actualPackage;
    }

    /**
     * @return the receivedHandlingUnitReceiptLine
     */
    public ReceiptLine getReceivedHandlingUnitReceiptLine() {
        return receivedHandlingUnitReceiptLine;
    }

    /**
     * @param receivedHandlingUnitReceiptLine
     *            the receivedHandlingUnitReceiptLine to set
     */
    public void setReceivedHandlingUnitReceiptLine(ReceiptLine receivedHandlingUnitReceiptLine) {
        this.receivedHandlingUnitReceiptLine = receivedHandlingUnitReceiptLine;
    }

    /**
     * @return the referencedShipment
     */
    public Shipment getReferencedShipment() {
        return referencedShipment;
    }

    /**
     * @param referencedShipment
     *            the referencedShipment to set
     */
    public void setReferencedShipment(Shipment referencedShipment) {
        this.referencedShipment = referencedShipment;
    }

    /**
     * @return the status
     */
    public List<Status> getStatus() {
        return status;
    }

    /**
     * @param status
     *            the status to set
     */
    public void setStatus(List<Status> status) {
        this.status = status;
    }

    /**
     * @return the minimumTemperature
     */
    public Temperature getMinimumTemperature() {
        return minimumTemperature;
    }

    /**
     * @param minimumTemperature
     *            the minimumTemperature to set
     */
    public void setMinimumTemperature(Temperature minimumTemperature) {
        this.minimumTemperature = minimumTemperature;
    }

    /**
     * @return the maximumTemperature
     */
    public Temperature getMaximumTemperature() {
        return maximumTemperature;
    }

    /**
     * @param maximumTemperature
     *            the maximumTemperature to set
     */
    public void setMaximumTemperature(Temperature maximumTemperature) {
        this.maximumTemperature = maximumTemperature;
    }

    /**
     * @return the transportEquipments
     */
    public List<TransportEquipment> getTransportEquipments() {
        return transportEquipments;
    }

    /**
     * @param transportEquipments
     *            the transportEquipments to set
     */
    public void setTransportEquipments(List<TransportEquipment> transportEquipments) {
        this.transportEquipments = transportEquipments;
    }

    /**
     * @return the transportMeans
     */
    public List<TransportMeans> getTransportMeans() {
        return transportMeans;
    }

    /**
     * @param transportMeans
     *            the transportMeans to set
     */
    public void setTransportMeans(List<TransportMeans> transportMeans) {
        this.transportMeans = transportMeans;
    }

}// end TransportHandlingUnit