package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class defining an identifiable collection of one or more goods items to be
 * transported between the seller party and the buyer party. This information may
 * be defined within a commercial contract. A shipment can be transported in
 * different consignments (e
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:44 a. m.
 */
public class Shipment{

	/**
	 * The total number of consignments within this shipment.
	 */
	private QuantityType ConsignmentQuantity;
	/**
	 * The total declared value for customs purposes of those goods in this shipment
	 * that are subject to the same customs procedure and have the same
	 * tariff/statistical heading, country information, and duty regime.
	 */
	private BigDecimal DeclaredCustomsValueAmount;
	/**
	 * The value of this shipment, declared by the shipper or his agent solely for the
	 * purpose of varying the carrier's level of liability from that provided in the
	 * contract of carriage, in case of loss or damage to goods or delayed delivery.
	 */
	private BigDecimal DeclaredForCarriageValueAmount;
	/**
	 * The value, declared for statistical purposes, of those goods in this shipment
	 * that have the same statistical heading.
	 */
	private BigDecimal DeclaredStatisticsValueAmount;
	/**
	 * Delivery instructions relating to this shipment.
	 */
	private TextType DeliveryInstructions;
	/**
	 * The monetary amount that has to be or has been paid as calculated under the
	 * applicable trade delivery.
	 */
	private BigDecimal FreeOnBoardValueAmount;
	/**
	 * The total volume of the goods in this shipment, including packaging.
	 */
	private MeasureType GrossVolumeMeasure;
	/**
	 * The total gross weight of a shipment; the weight of the goods plus packaging
	 * plus transport equipment.
	 */
	private MeasureType GrossWeightMeasure;
	/**
	 * The handling required for this shipment, expressed as a code.
	 */
	private CodeType HandlingCode;
	/**
	 * The handling required for this shipment, expressed as text.
	 */
	private TextType HandlingInstructions;
	/**
	 * An identifier for this shipment.
	 */
	private IdentifierType ID;
	/**
	 * Free-form text pertinent to this shipment, conveying information that is not
	 * contained explicitly in other structures.
	 */
	private TextType Information;
	/**
	 * The amount covered by insurance for this shipment.
	 */
	private BigDecimal InsuranceValueAmount;
	/**
	 * The total net weight of this shipment, excluding packaging and transport
	 * equipment.
	 */
	private MeasureType NetNetWeightMeasure;
	/**
	 * The total volume of the goods in this shipment, excluding packaging and
	 * transport equipment.
	 */
	private MeasureType NetVolumeMeasure;
	/**
	 * The net weight of this shipment, excluding packaging.
	 */
	private MeasureType NetWeightMeasure;
	/**
	 * A code signifying the priority or level of service required for this shipment.
	 */
	private CodeType ShippingPriorityLevelCode;
	/**
	 * Special instructions relating to this shipment.
	 */
	private TextType SpecialInstructions;
	/**
	 * An indicator that the consignment has been split in transit (true) or not
	 * (false).
	 */
	private boolean SplitConsignmentIndicator;
	/**
	 * The total number of goods items in this shipment.
	 */
	private QuantityType TotalGoodsItemQuantity;
	/**
	 * The number of pieces of transport handling equipment (pallets, boxes, cases,
	 * etc.) in this shipment.
	 */
	private QuantityType TotalTransportHandlingUnitQuantity;
	private Address ReturnAddress;
	private Address OriginAddress;
	private AllowanceCharge FreightAllowanceCharge;
	private List<Consignment> Consignments = new ArrayList<>();
	private Country ExportCountry;
	private List<Delivery> Deliveries = new ArrayList<>();
	private List<GoodsItem> GoodsItems = new ArrayList<>();
	private Location LastExitPortLocation;
	private Location FirstArrivalPortLocation;
	private List<ShipmentStage> ShipmentStages = new ArrayList<>();
	private List<TransportHandlingUnit> TransportHandlingUnits = new ArrayList<>();

}
