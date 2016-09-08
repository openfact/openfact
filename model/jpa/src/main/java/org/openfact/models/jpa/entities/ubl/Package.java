package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

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
	private String packageLevelCode;
	/**
	 * A code signifying a type of packaging.
	 */
	private String packagingTypeCode;
	/**
	 * Text describing the packaging material.
	 */
	private String packingMaterial;
	/**
	 * The quantity of items contained in this package.
	 */
	private BigDecimal quantity;
	/**
	 * An indicator that the packaging material is returnable (true) or not
	 * (false).
	 */
	private boolean ReturnableMaterialIndicator;
	/**
	 * An identifier for use in tracing this package, such as the EPC number
	 * used in RFID.
	 */
	private String traceID;
	private List<Delivery> deliveries = new ArrayList<>();
	private List<DeliveryUnit> deliveryUnits=new ArrayList<>();
	private List<Despatch> despatchs = new ArrayList<>();
	private Dimension measurementDimension;
	private List<GoodsItem> goodsItems = new ArrayList<>();
	private Package containedPackage;
	private List<Pickup> pickups = new ArrayList<>();
	private TransportEquipment containingTransportEquipment;

	public Package() {

	}

	public void finalize() throws Throwable {

	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getPackageLevelCode() {
		return packageLevelCode;
	}

	public void setPackageLevelCode(String packageLevelCode) {
		this.packageLevelCode = packageLevelCode;
	}

	public String getPackagingTypeCode() {
		return packagingTypeCode;
	}

	public void setPackagingTypeCode(String packagingTypeCode) {
		this.packagingTypeCode = packagingTypeCode;
	}

	public String getPackingMaterial() {
		return packingMaterial;
	}

	public void setPackingMaterial(String packingMaterial) {
		this.packingMaterial = packingMaterial;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public boolean isReturnableMaterialIndicator() {
		return ReturnableMaterialIndicator;
	}

	public void setReturnableMaterialIndicator(boolean returnableMaterialIndicator) {
		ReturnableMaterialIndicator = returnableMaterialIndicator;
	}

	public String getTraceID() {
		return traceID;
	}

	public void setTraceID(String traceID) {
		this.traceID = traceID;
	}

	public List<Delivery> getDeliveries() {
		return deliveries;
	}

	public void setDeliveries(List<Delivery> deliveries) {
		this.deliveries = deliveries;
	}

	public List<DeliveryUnit> getDeliveryUnits() {
		return deliveryUnits;
	}

	public void setDeliveryUnits(List<DeliveryUnit> deliveryUnits) {
		this.deliveryUnits = deliveryUnits;
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

	public List<GoodsItem> getGoodsItems() {
		return goodsItems;
	}

	public void setGoodsItems(List<GoodsItem> goodsItems) {
		this.goodsItems = goodsItems;
	}

	public Package getContainedPackage() {
		return containedPackage;
	}

	public void setContainedPackage(Package containedPackage) {
		this.containedPackage = containedPackage;
	}

	public List<Pickup> getPickups() {
		return pickups;
	}

	public void setPickups(List<Pickup> pickups) {
		this.pickups = pickups;
	}

	public TransportEquipment getContainingTransportEquipment() {
		return containingTransportEquipment;
	}

	public void setContainingTransportEquipment(TransportEquipment containingTransportEquipment) {
		this.containingTransportEquipment = containingTransportEquipment;
	}
}// end Package