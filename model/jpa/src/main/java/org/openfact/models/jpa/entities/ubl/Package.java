package org.openfact.models.jpa.entities.ubl;

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
	private Packaging Type_
    String PackagingTypeCode;
    /**
     * Text describing the packaging material.
     */
    private String PackingMaterial;
    /**
     * The quantity of items contained in this package.
     */
    private Quantity.Type Quantity;
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
    private Delivery Unit
    m_Delivery Unit;
    private Despatch m_Despatch;
    private Dimension Measurement Dimension;
    private GoodsItem
    m_GoodsItem;
    private Package Contained Package;
    private Pickup m_Pickup;
    private TransportEquipment
    Containing TransportEquipment;

    public Package() {

    }

    public void finalize() throws Throwable {

    }

    public Package getContained

    Package(){
		return Contained Package;
	}

    public TransportEquipment
    getContaining Transport

    Equipment(){
		return Containing TransportEquipment;
	}

    public Delivery getDelivery() {
        return m_Delivery;
    }

    public Delivery Unit

    getDelivery Unit(){
		return m_Delivery Unit;
	}

    public Despatch getDespatch() {
        return m_Despatch;
    }

    public GoodsItem

    getGoodsItem(){
		return m_GoodsItem;
	}

    public String getID() {
        return ID;
    }

    public Dimension getMeasurement

    Dimension(){
		return Measurement Dimension;
	}

    public String getPackageLevelCode() {
        return PackageLevelCode;
    }

    public Packaging Type_

    String getPackagingTypeCode() {
        return PackagingTypeCode;
    }

    public String getPackingMaterial() {
        return PackingMaterial;
    }

    public Pickup getPickup() {
        return m_Pickup;
    }

    public Quantity.Type getQuantity() {
        return Quantity;
    }

    public boolean getReturnableMaterialIndicator() {
        return ReturnableMaterialIndicator;
    }

    public String getTraceID() {
        return TraceID;
    }

    /**
	 * 
	 * @param newVal
	 */
	public void setContained

    Package(Package newVal) {
        Contained Package = newVal;
    }

    /**
	 * 
	 * @param newVal
	 */
	public void setContaining

    TransportEquipment(TransportEquipment newVal){
		Containing TransportEquipment = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setDelivery(Delivery newVal) {
        m_Delivery = newVal;
    }

    /**
	 * 
	 * @param newVal
	 */
	public void setDelivery

    Unit(Delivery Unit newVal){
		m_Delivery Unit = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setDespatch(Despatch newVal) {
        m_Despatch = newVal;
    }

    /**
	 * 
	 * @param newVal
	 */
	public void setGoods

    Item(GoodsItem newVal){
		m_GoodsItem = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setID(String newVal) {
        ID = newVal;
    }

    /**
	 * 
	 * @param newVal
	 */
	public void setMeasurement

    Dimension(Dimension newVal){
		Measurement Dimension = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setPackageLevelCode(String newVal) {
        PackageLevelCode = newVal;
    }

    /**
	 * 
	 * @param newVal
	 */
	public void setPackagingTypeCode(Packaging Type_ String newVal){
		PackagingTypeCode = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setPackingMaterial(String newVal) {
        PackingMaterial = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setPickup(Pickup newVal) {
        m_Pickup = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setQuantity(Quantity.Type newVal) {
        Quantity = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setReturnableMaterialIndicator(boolean newVal) {
        ReturnableMaterialIndicator = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setTraceID(String newVal) {
        TraceID = newVal;
    }
}// end Package