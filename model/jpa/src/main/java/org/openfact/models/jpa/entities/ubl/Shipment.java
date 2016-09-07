package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;

/**
 * A class defining an identifiable collection of one or more goods items to be
 * transported between the seller party and the buyer party. This information
 * may be defined within a commercial contract. A shipment can be transported in
 * different consignments (e
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:44 a. m.
 */
public class Shipment {

	/**
	 * The total number of consignments within this shipment.
	 */
	private BigDecimal ConsignmentQuantity;
	/**
	 * The total declared value for customs purposes of those goods in this
	 * shipment that are subject to the same customs procedure and have the same
	 * tariff/statistical heading, country information, and duty regime.
	 */
	private BigDecimal DeclaredCustomsValueAmount;
	/**
	 * The value of this shipment, declared by the shipper or his agent solely
	 * for the purpose of varying the carrier's level of liability from that
	 * provided in the contract of carriage, in case of loss or damage to goods
	 * or delayed delivery.
	 */
	private BigDecimal DeclaredForCarriageValueAmount;
	/**
	 * The value, declared for statistical purposes, of those goods in this
	 * shipment that have the same statistical heading.
	 */
	private BigDecimal DeclaredStatisticsValueAmount;
	/**
	 * Delivery instructions relating to this shipment.
	 */
	private String DeliveryInstructions;
	/**
	 * The monetary amount that has to be or has been paid as calculated under
	 * the applicable trade delivery.
	 */
	private BigDecimal FreeOnBoardValueAmount;
	/**
	 * The total volume of the goods in this shipment, including packaging.
	 */
	private BigDecimal GrossVolumeMeasure;
	/**
	 * The total gross weight of a shipment; the weight of the goods plus
	 * packaging plus transport equipment.
	 */
	private BigDecimal GrossWeightMeasure;
	/**
	 * The handling required for this shipment, expressed as a code.
	 */
	private String HandlingCode;
	/**
	 * The handling required for this shipment, expressed as text.
	 */
	private String HandlingInstructions;
	/**
	 * An identifier for this shipment.
	 */
	private String ID;
	/**
	 * Free-form text pertinent to this shipment, conveying information that is
	 * not contained explicitly in other structures.
	 */
	private String Information;
	/**
	 * The amount covered by insurance for this shipment.
	 */
	private BigDecimal InsuranceValueAmount;
	/**
	 * The total net weight of this shipment, excluding packaging and transport
	 * equipment.
	 */
	private BigDecimal NetNetWeightMeasure;
	/**
	 * The total volume of the goods in this shipment, excluding packaging and
	 * transport equipment.
	 */
	private BigDecimal NetVolumeMeasure;
	/**
	 * The net weight of this shipment, excluding packaging.
	 */
	private BigDecimal NetWeightMeasure;
	/**
	 * A code signifying the priority or level of service required for this
	 * shipment.
	 */
	private String ShippingPriorityLevelCode;
	/**
	 * Special instructions relating to this shipment.
	 */
	private String SpecialInstructions;
	/**
	 * An indicator that the consignment has been split in transit (true) or not
	 * (false).
	 */
	private boolean SplitConsignmentIndicator;
	/**
	 * The total number of goods items in this shipment.
	 */
	private BigDecimal TotalGoodsItemQuantity;
	/**
	 * The number of pieces of transport handling equipment (pallets, boxes,
	 * cases, etc.) in this shipment.
	 */
	private BigDecimal TotalTransportHandlingUnitQuantity;
	private Address ReturnAddress;
	private Address OriginAddress;
	private AllowanceCharge FreightAllowanceCharge;
	private List<Consignment> consignments = new ArrayList<>();
	private Country ExportCountry;
	private List<Delivery> deliveries = new ArrayList<>();
	private List<GoodsItem> goodsItems = new ArrayList<>();
	private Location LastExitPortLocation;
	private Location FirstArrivalPortLocation;
	private List<ShipmentStage> shipmentStages = new ArrayList<>();
	private TransportHandlingUnit m_TransportHandlingUnit;

	public Shipment() {

	}

	public void finalize() throws Throwable {

	}

	/**
	 * @return the consignmentQuantity
	 */
	public BigDecimal getConsignmentQuantity() {
		return ConsignmentQuantity;
	}

	/**
	 * @param consignmentQuantity
	 *            the consignmentQuantity to set
	 */
	public void setConsignmentQuantity(BigDecimal consignmentQuantity) {
		ConsignmentQuantity = consignmentQuantity;
	}

	/**
	 * @return the declaredCustomsValueAmount
	 */
	public BigDecimal getDeclaredCustomsValueAmount() {
		return DeclaredCustomsValueAmount;
	}

	/**
	 * @param declaredCustomsValueAmount
	 *            the declaredCustomsValueAmount to set
	 */
	public void setDeclaredCustomsValueAmount(BigDecimal declaredCustomsValueAmount) {
		DeclaredCustomsValueAmount = declaredCustomsValueAmount;
	}

	/**
	 * @return the declaredForCarriageValueAmount
	 */
	public BigDecimal getDeclaredForCarriageValueAmount() {
		return DeclaredForCarriageValueAmount;
	}

	/**
	 * @param declaredForCarriageValueAmount
	 *            the declaredForCarriageValueAmount to set
	 */
	public void setDeclaredForCarriageValueAmount(BigDecimal declaredForCarriageValueAmount) {
		DeclaredForCarriageValueAmount = declaredForCarriageValueAmount;
	}

	/**
	 * @return the declaredStatisticsValueAmount
	 */
	public BigDecimal getDeclaredStatisticsValueAmount() {
		return DeclaredStatisticsValueAmount;
	}

	/**
	 * @param declaredStatisticsValueAmount
	 *            the declaredStatisticsValueAmount to set
	 */
	public void setDeclaredStatisticsValueAmount(BigDecimal declaredStatisticsValueAmount) {
		DeclaredStatisticsValueAmount = declaredStatisticsValueAmount;
	}

	/**
	 * @return the deliveryInstructions
	 */
	public String getDeliveryInstructions() {
		return DeliveryInstructions;
	}

	/**
	 * @param deliveryInstructions
	 *            the deliveryInstructions to set
	 */
	public void setDeliveryInstructions(String deliveryInstructions) {
		DeliveryInstructions = deliveryInstructions;
	}

	/**
	 * @return the freeOnBoardValueAmount
	 */
	public BigDecimal getFreeOnBoardValueAmount() {
		return FreeOnBoardValueAmount;
	}

	/**
	 * @param freeOnBoardValueAmount
	 *            the freeOnBoardValueAmount to set
	 */
	public void setFreeOnBoardValueAmount(BigDecimal freeOnBoardValueAmount) {
		FreeOnBoardValueAmount = freeOnBoardValueAmount;
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
	 * @return the handlingCode
	 */
	public String getHandlingCode() {
		return HandlingCode;
	}

	/**
	 * @param handlingCode
	 *            the handlingCode to set
	 */
	public void setHandlingCode(String handlingCode) {
		HandlingCode = handlingCode;
	}

	/**
	 * @return the handlingInstructions
	 */
	public String getHandlingInstructions() {
		return HandlingInstructions;
	}

	/**
	 * @param handlingInstructions
	 *            the handlingInstructions to set
	 */
	public void setHandlingInstructions(String handlingInstructions) {
		HandlingInstructions = handlingInstructions;
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
	 * @return the insuranceValueAmount
	 */
	public BigDecimal getInsuranceValueAmount() {
		return InsuranceValueAmount;
	}

	/**
	 * @param insuranceValueAmount
	 *            the insuranceValueAmount to set
	 */
	public void setInsuranceValueAmount(BigDecimal insuranceValueAmount) {
		InsuranceValueAmount = insuranceValueAmount;
	}

	/**
	 * @return the netNetWeightMeasure
	 */
	public BigDecimal getNetNetWeightMeasure() {
		return NetNetWeightMeasure;
	}

	/**
	 * @param netNetWeightMeasure
	 *            the netNetWeightMeasure to set
	 */
	public void setNetNetWeightMeasure(BigDecimal netNetWeightMeasure) {
		NetNetWeightMeasure = netNetWeightMeasure;
	}

	/**
	 * @return the netVolumeMeasure
	 */
	public BigDecimal getNetVolumeMeasure() {
		return NetVolumeMeasure;
	}

	/**
	 * @param netVolumeMeasure
	 *            the netVolumeMeasure to set
	 */
	public void setNetVolumeMeasure(BigDecimal netVolumeMeasure) {
		NetVolumeMeasure = netVolumeMeasure;
	}

	/**
	 * @return the netWeightMeasure
	 */
	public BigDecimal getNetWeightMeasure() {
		return NetWeightMeasure;
	}

	/**
	 * @param netWeightMeasure
	 *            the netWeightMeasure to set
	 */
	public void setNetWeightMeasure(BigDecimal netWeightMeasure) {
		NetWeightMeasure = netWeightMeasure;
	}

	/**
	 * @return the shippingPriorityLevelCode
	 */
	public String getShippingPriorityLevelCode() {
		return ShippingPriorityLevelCode;
	}

	/**
	 * @param shippingPriorityLevelCode
	 *            the shippingPriorityLevelCode to set
	 */
	public void setShippingPriorityLevelCode(String shippingPriorityLevelCode) {
		ShippingPriorityLevelCode = shippingPriorityLevelCode;
	}

	/**
	 * @return the specialInstructions
	 */
	public String getSpecialInstructions() {
		return SpecialInstructions;
	}

	/**
	 * @param specialInstructions
	 *            the specialInstructions to set
	 */
	public void setSpecialInstructions(String specialInstructions) {
		SpecialInstructions = specialInstructions;
	}

	/**
	 * @return the splitConsignmentIndicator
	 */
	public boolean isSplitConsignmentIndicator() {
		return SplitConsignmentIndicator;
	}

	/**
	 * @param splitConsignmentIndicator
	 *            the splitConsignmentIndicator to set
	 */
	public void setSplitConsignmentIndicator(boolean splitConsignmentIndicator) {
		SplitConsignmentIndicator = splitConsignmentIndicator;
	}

	/**
	 * @return the totalGoodsItemQuantity
	 */
	public BigDecimal getTotalGoodsItemQuantity() {
		return TotalGoodsItemQuantity;
	}

	/**
	 * @param totalGoodsItemQuantity
	 *            the totalGoodsItemQuantity to set
	 */
	public void setTotalGoodsItemQuantity(BigDecimal totalGoodsItemQuantity) {
		TotalGoodsItemQuantity = totalGoodsItemQuantity;
	}

	/**
	 * @return the totalTransportHandlingUnitQuantity
	 */
	public BigDecimal getTotalTransportHandlingUnitQuantity() {
		return TotalTransportHandlingUnitQuantity;
	}

	/**
	 * @param totalTransportHandlingUnitQuantity
	 *            the totalTransportHandlingUnitQuantity to set
	 */
	public void setTotalTransportHandlingUnitQuantity(BigDecimal totalTransportHandlingUnitQuantity) {
		TotalTransportHandlingUnitQuantity = totalTransportHandlingUnitQuantity;
	}

	/**
	 * @return the returnAddress
	 */
	public Address getReturnAddress() {
		return ReturnAddress;
	}

	/**
	 * @param returnAddress
	 *            the returnAddress to set
	 */
	public void setReturnAddress(Address returnAddress) {
		ReturnAddress = returnAddress;
	}

	/**
	 * @return the originAddress
	 */
	public Address getOriginAddress() {
		return OriginAddress;
	}

	/**
	 * @param originAddress
	 *            the originAddress to set
	 */
	public void setOriginAddress(Address originAddress) {
		OriginAddress = originAddress;
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
	 * @return the m_Consignment
	 */
	public Consignment getM_Consignment() {
		return m_Consignment;
	}

	/**
	 * @param m_Consignment
	 *            the m_Consignment to set
	 */
	public void setM_Consignment(Consignment m_Consignment) {
		this.m_Consignment = m_Consignment;
	}

	/**
	 * @return the exportCountry
	 */
	public Country getExportCountry() {
		return ExportCountry;
	}

	/**
	 * @param exportCountry
	 *            the exportCountry to set
	 */
	public void setExportCountry(Country exportCountry) {
		ExportCountry = exportCountry;
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
	 * @return the lastExitPortLocation
	 */
	public Location getLastExitPortLocation() {
		return LastExitPortLocation;
	}

	/**
	 * @param lastExitPortLocation
	 *            the lastExitPortLocation to set
	 */
	public void setLastExitPortLocation(Location lastExitPortLocation) {
		LastExitPortLocation = lastExitPortLocation;
	}

	/**
	 * @return the firstArrivalPortLocation
	 */
	public Location getFirstArrivalPortLocation() {
		return FirstArrivalPortLocation;
	}

	/**
	 * @param firstArrivalPortLocation
	 *            the firstArrivalPortLocation to set
	 */
	public void setFirstArrivalPortLocation(Location firstArrivalPortLocation) {
		FirstArrivalPortLocation = firstArrivalPortLocation;
	}

	/**
	 * @return the m_ShipmentStage
	 */
	public ShipmentStage getM_ShipmentStage() {
		return m_ShipmentStage;
	}

	/**
	 * @param m_ShipmentStage
	 *            the m_ShipmentStage to set
	 */
	public void setM_ShipmentStage(ShipmentStage m_ShipmentStage) {
		this.m_ShipmentStage = m_ShipmentStage;
	}

	/**
	 * @return the m_TransportHandlingUnit
	 */
	public TransportHandlingUnit getM_TransportHandlingUnit() {
		return m_TransportHandlingUnit;
	}

	/**
	 * @param m_TransportHandlingUnit
	 *            the m_TransportHandlingUnit to set
	 */
	public void setM_TransportHandlingUnit(TransportHandlingUnit m_TransportHandlingUnit) {
		this.m_TransportHandlingUnit = m_TransportHandlingUnit;
	}

}// end Shipment