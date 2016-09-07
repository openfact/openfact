package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;

/**
 * A class to describe a package.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:21 a. m.
 */
public class Package {

    /**
     * An identifier for this package.
     */
    private String ID;
    /**
     * A code signifying a level of packaging.
     */
    private String PackageLevelCode;
    /**
     * A code signifying a type of packaging.
     */
    private String PackagingTypeCode;
    /**
     * Text describing the packaging material.
     */
    private String PackingMaterial;
    /**
     * The quantity of items contained in this package.
     */
    private BigDecimal Quantity;
    /**
     * An indicator that the packaging material is returnable (true) or not
     * (false).
     */
    private boolean ReturnableMaterialIndicator;
    /**
     * An identifier for use in tracing this package, such as the EPC number
     * used in RFID.
     */
    private String TraceID;
    private Delivery m_Delivery;
    private DeliveryUnit m_DeliveryUnit;
    private Despatch m_Despatch;
    private Dimension MeasurementDimension;
    private GoodsItem m_GoodsItem;
    private Package ContainedPackage;
    private Pickup m_Pickup;
    private TransportEquipment ContainingTransportEquipment;

    public Package() {

    }

    public void finalize() throws Throwable {

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
     * @return the packageLevelCode
     */
    public String getPackageLevelCode() {
        return PackageLevelCode;
    }

    /**
     * @param packageLevelCode
     *            the packageLevelCode to set
     */
    public void setPackageLevelCode(String packageLevelCode) {
        PackageLevelCode = packageLevelCode;
    }

    /**
     * @return the packagingTypeCode
     */
    public String getPackagingTypeCode() {
        return PackagingTypeCode;
    }

    /**
     * @param packagingTypeCode
     *            the packagingTypeCode to set
     */
    public void setPackagingTypeCode(String packagingTypeCode) {
        PackagingTypeCode = packagingTypeCode;
    }

    /**
     * @return the packingMaterial
     */
    public String getPackingMaterial() {
        return PackingMaterial;
    }

    /**
     * @param packingMaterial
     *            the packingMaterial to set
     */
    public void setPackingMaterial(String packingMaterial) {
        PackingMaterial = packingMaterial;
    }

    /**
     * @return the quantity
     */
    public BigDecimal getQuantity() {
        return Quantity;
    }

    /**
     * @param quantity
     *            the quantity to set
     */
    public void setQuantity(BigDecimal quantity) {
        Quantity = quantity;
    }

    /**
     * @return the returnableMaterialIndicator
     */
    public boolean isReturnableMaterialIndicator() {
        return ReturnableMaterialIndicator;
    }

    /**
     * @param returnableMaterialIndicator
     *            the returnableMaterialIndicator to set
     */
    public void setReturnableMaterialIndicator(boolean returnableMaterialIndicator) {
        ReturnableMaterialIndicator = returnableMaterialIndicator;
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
     * @return the m_DeliveryUnit
     */
    public DeliveryUnit getM_DeliveryUnit() {
        return m_DeliveryUnit;
    }

    /**
     * @param m_DeliveryUnit
     *            the m_DeliveryUnit to set
     */
    public void setM_DeliveryUnit(DeliveryUnit m_DeliveryUnit) {
        this.m_DeliveryUnit = m_DeliveryUnit;
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
     * @return the containedPackage
     */
    public Package getContainedPackage() {
        return ContainedPackage;
    }

    /**
     * @param containedPackage
     *            the containedPackage to set
     */
    public void setContainedPackage(Package containedPackage) {
        ContainedPackage = containedPackage;
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
     * @return the containingTransportEquipment
     */
    public TransportEquipment getContainingTransportEquipment() {
        return ContainingTransportEquipment;
    }

    /**
     * @param containingTransportEquipment
     *            the containingTransportEquipment to set
     */
    public void setContainingTransportEquipment(TransportEquipment containingTransportEquipment) {
        ContainingTransportEquipment = containingTransportEquipment;
    }

}// end Package