package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;

/**
 * A class to describe a separately identifiable quantity of goods of a single
 * product type.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:24 a. m.
 */
public class GoodsItem {

	/**
	 * The number of units in the goods item to which charges apply.
	 */
	private BigDecimal chargeableQuantity;
	/**
	 * The weight on which a charge is to be based.
	 */
	private BigDecimal chargeableWeightMeasure;
	/**
	 * An indicator that this goods item has been classified for import by
	 * customs (true) or not (false).
	 */
	private boolean customsImportClassifiedIndicator;
	/**
	 * A code assigned by customs to signify the status of this goods item.
	 */
	private String customsStatusCode;
	/**
	 * Quantity of the units in this goods item as required by customs for
	 * tariff, statistical, or fiscal purposes.
	 */
	private BigDecimal customsTariffQuantity;
	/**
	 * The total declared value for customs purposes of the goods item.
	 */
	private BigDecimal declaredCustomsValueAmount;
	/**
	 * The value of this goods item, declared by the shipper or his agent solely
	 * for the purpose of varying the carrier's level of liability from that
	 * provided in the contract of carriage, in case of loss or damage to goods
	 * or delayed delivery.
	 */
	private BigDecimal declaredForCarriageValueAmount;
	/**
	 * The total declared value of all the goods items in the same consignment
	 * with this goods item that have the same statistical heading.
	 */
	private BigDecimal declaredStatisticsValueAmount;
	/**
	 * Text describing this goods item to identify it for customs, statistical,
	 * or transport purposes.
	 */
	private String description;
	/**
	 * The monetary amount that has to be or has been paid as calculated under
	 * the applicable trade delivery.
	 */
	private BigDecimal freeOnBoardValueAmount;
	/**
	 * The volume of this goods item, normally calculated by multiplying its
	 * maximum length, width, and height.
	 */
	private BigDecimal grossVolumeMeasure;
	/**
	 * The weight of this goods item, including packing and packaging but
	 * excluding the carrier's equipment.
	 */
	private BigDecimal grossWeightMeasure;
	/**
	 * An indication that the transported goods item is subject to an
	 * international regulation concerning the carriage of dangerous goods
	 * (true) or not (false).
	 */
	private boolean hazardousRiskIndicator;
	/**
	 * An identifier for this goods item.
	 */
	private String id;
	/**
	 * The amount covered by insurance for this goods item.
	 */
	private BigDecimal insuranceValueAmount;
	/**
	 * The total weight of this goods item, excluding all packing and packaging.
	 */
	private BigDecimal netNetWeightMeasure;
	/**
	 * The volume contained by a goods item, excluding the volume of any
	 * packaging material.
	 */
	private BigDecimal netVolumeMeasure;
	/**
	 * The weight of this goods item, excluding packing but including packaging
	 * that normally accompanies the goods.
	 */
	private BigDecimal netWeightMeasure;
	/**
	 * A code signifying the treatment preference for this goods item according
	 * to international trading agreements.
	 */
	private String preferenceCriterionCode;
	/**
	 * The number of units making up this goods item.
	 */
	private BigDecimal quantity;
	/**
	 * An identifier for a set of tariff codes required to specify a type of
	 * goods for customs, transport, statistical, or other regulatory purposes.
	 */
	private String requiredCustomsID;
	/**
	 * The number of units in the goods item that may be returned.
	 */
	private BigDecimal returnableQuantity;
	/**
	 * A sequence number differentiating a specific goods item within a
	 * consignment.
	 */
	private String sequenceNumberID;
	/**
	 * An identifier for use in tracing this goods item, such as the EPC number
	 * used in RFID.
	 */
	private String traceID;
	/**
	 * The amount on which a duty, tax, or fee will be assessed.
	 */
	private BigDecimal valueAmount;
	private Address originAddress;
	private AllowanceCharge freightAllowanceCharge;
	private List<Delivery> deliveries = new ArrayList<>();
	private List<Despatch> despatchs=new ArrayList<>();
	private Dimension measurementDimension;
	private DocumentReference shipmentDocumentReference;
	private List<InvoiceLine> invoiceLines = new ArrayList<>();    
	private GoodsItem containedGoodsItem;
	private List<GoodsItemContainer> goodsItemContainers=new ArrayList<>();
	private List<Item> items = new ArrayList<>();
	private Package containingPackage;
	private List<Pickup> pickups=new ArrayList<>();
	private List<Temperature> temperatures=new ArrayList<>();
	private Temperature maximumTemperature;
	private Temperature minimumTemperature;

	public BigDecimal getChargeableQuantity() {
		return chargeableQuantity;
	}

	public void setChargeableQuantity(BigDecimal chargeableQuantity) {
		this.chargeableQuantity = chargeableQuantity;
	}

	public BigDecimal getChargeableWeightMeasure() {
		return chargeableWeightMeasure;
	}

	public void setChargeableWeightMeasure(BigDecimal chargeableWeightMeasure) {
		this.chargeableWeightMeasure = chargeableWeightMeasure;
	}

	public boolean isCustomsImportClassifiedIndicator() {
		return customsImportClassifiedIndicator;
	}

	public void setCustomsImportClassifiedIndicator(boolean customsImportClassifiedIndicator) {
		this.customsImportClassifiedIndicator = customsImportClassifiedIndicator;
	}

	public String getCustomsStatusCode() {
		return customsStatusCode;
	}

	public void setCustomsStatusCode(String customsStatusCode) {
		this.customsStatusCode = customsStatusCode;
	}

	public BigDecimal getCustomsTariffQuantity() {
		return customsTariffQuantity;
	}

	public void setCustomsTariffQuantity(BigDecimal customsTariffQuantity) {
		this.customsTariffQuantity = customsTariffQuantity;
	}

	public BigDecimal getDeclaredCustomsValueAmount() {
		return declaredCustomsValueAmount;
	}

	public void setDeclaredCustomsValueAmount(BigDecimal declaredCustomsValueAmount) {
		this.declaredCustomsValueAmount = declaredCustomsValueAmount;
	}

	public BigDecimal getDeclaredForCarriageValueAmount() {
		return declaredForCarriageValueAmount;
	}

	public void setDeclaredForCarriageValueAmount(BigDecimal declaredForCarriageValueAmount) {
		this.declaredForCarriageValueAmount = declaredForCarriageValueAmount;
	}

	public BigDecimal getDeclaredStatisticsValueAmount() {
		return declaredStatisticsValueAmount;
	}

	public void setDeclaredStatisticsValueAmount(BigDecimal declaredStatisticsValueAmount) {
		this.declaredStatisticsValueAmount = declaredStatisticsValueAmount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getFreeOnBoardValueAmount() {
		return freeOnBoardValueAmount;
	}

	public void setFreeOnBoardValueAmount(BigDecimal freeOnBoardValueAmount) {
		this.freeOnBoardValueAmount = freeOnBoardValueAmount;
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

	public boolean isHazardousRiskIndicator() {
		return hazardousRiskIndicator;
	}

	public void setHazardousRiskIndicator(boolean hazardousRiskIndicator) {
		this.hazardousRiskIndicator = hazardousRiskIndicator;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BigDecimal getInsuranceValueAmount() {
		return insuranceValueAmount;
	}

	public void setInsuranceValueAmount(BigDecimal insuranceValueAmount) {
		this.insuranceValueAmount = insuranceValueAmount;
	}

	public BigDecimal getNetNetWeightMeasure() {
		return netNetWeightMeasure;
	}

	public void setNetNetWeightMeasure(BigDecimal netNetWeightMeasure) {
		this.netNetWeightMeasure = netNetWeightMeasure;
	}

	public BigDecimal getNetVolumeMeasure() {
		return netVolumeMeasure;
	}

	public void setNetVolumeMeasure(BigDecimal netVolumeMeasure) {
		this.netVolumeMeasure = netVolumeMeasure;
	}

	public BigDecimal getNetWeightMeasure() {
		return netWeightMeasure;
	}

	public void setNetWeightMeasure(BigDecimal netWeightMeasure) {
		this.netWeightMeasure = netWeightMeasure;
	}

	public String getPreferenceCriterionCode() {
		return preferenceCriterionCode;
	}

	public void setPreferenceCriterionCode(String preferenceCriterionCode) {
		this.preferenceCriterionCode = preferenceCriterionCode;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public String getRequiredCustomsID() {
		return requiredCustomsID;
	}

	public void setRequiredCustomsID(String requiredCustomsID) {
		this.requiredCustomsID = requiredCustomsID;
	}

	public BigDecimal getReturnableQuantity() {
		return returnableQuantity;
	}

	public void setReturnableQuantity(BigDecimal returnableQuantity) {
		this.returnableQuantity = returnableQuantity;
	}

	public String getSequenceNumberID() {
		return sequenceNumberID;
	}

	public void setSequenceNumberID(String sequenceNumberID) {
		this.sequenceNumberID = sequenceNumberID;
	}

	public String getTraceID() {
		return traceID;
	}

	public void setTraceID(String traceID) {
		this.traceID = traceID;
	}

	public BigDecimal getValueAmount() {
		return valueAmount;
	}

	public void setValueAmount(BigDecimal valueAmount) {
		this.valueAmount = valueAmount;
	}

	public Address getOriginAddress() {
		return originAddress;
	}

	public void setOriginAddress(Address originAddress) {
		this.originAddress = originAddress;
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

	public List<InvoiceLine> getInvoiceLines() {
		return invoiceLines;
	}

	public void setInvoiceLines(List<InvoiceLine> invoiceLines) {
		this.invoiceLines = invoiceLines;
	}

	public GoodsItem getContainedGoodsItem() {
		return containedGoodsItem;
	}

	public void setContainedGoodsItem(GoodsItem containedGoodsItem) {
		this.containedGoodsItem = containedGoodsItem;
	}

	public List<GoodsItemContainer> getGoodsItemContainers() {
		return goodsItemContainers;
	}

	public void setGoodsItemContainers(List<GoodsItemContainer> goodsItemContainers) {
		this.goodsItemContainers = goodsItemContainers;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Package getContainingPackage() {
		return containingPackage;
	}

	public void setContainingPackage(Package containingPackage) {
		this.containingPackage = containingPackage;
	}

	public List<Pickup> getPickups() {
		return pickups;
	}

	public void setPickups(List<Pickup> pickups) {
		this.pickups = pickups;
	}

	public List<Temperature> getTemperatures() {
		return temperatures;
	}

	public void setTemperatures(List<Temperature> temperatures) {
		this.temperatures = temperatures;
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
}// end Goods Item