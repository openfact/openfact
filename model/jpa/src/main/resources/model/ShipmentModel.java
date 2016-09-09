package model;
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
public class ShipmentModel{

	/**
	 * The total number of consignments within this shipment.
	 */
	private QuantityType consignmentQuantity;
	/**
	 * The total declared value for customs purposes of those goods in this shipment
	 * that are subject to the same customs procedure and have the same
	 * tariff/statistical heading, country information, and duty regime.
	 */
	private AmountType declaredCustomsValueAmount;
	/**
	 * The value of this shipment, declared by the shipper or his agent solely for the
	 * purpose of varying the carrier's level of liability from that provided in the
	 * contract of carriage, in case of loss or damage to goods or delayed delivery.
	 */
	private AmountType declaredForCarriageValueAmount;
	/**
	 * The value, declared for statistical purposes, of those goods in this shipment
	 * that have the same statistical heading.
	 */
	private AmountType declaredStatisticsValueAmount;
	/**
	 * DeliveryModel instructions relating to this shipment.
	 */
	private TextType deliveryInstructions;
	/**
	 * The monetary amount that has to be or has been paid as calculated under the
	 * applicable trade delivery.
	 */
	private AmountType freeOnBoardValueAmount;
	/**
	 * The total volume of the goods in this shipment, including packaging.
	 */
	private MeasureType grossVolumeMeasure;
	/**
	 * The total gross weight of a shipment; the weight of the goods plus packaging
	 * plus transport equipment.
	 */
	private MeasureType grossWeightMeasure;
	/**
	 * The handling required for this shipment, expressed as a code.
	 */
	private CodeType handlingCode;
	/**
	 * The handling required for this shipment, expressed as text.
	 */
	private TextType handlingInstructions;
	/**
	 * An identifier for this shipment.
	 */
	private IdentifierType ID;
	/**
	 * Free-form text pertinent to this shipment, conveying information that is not
	 * contained explicitly in other structures.
	 */
	private TextType information;
	/**
	 * The amount covered by insurance for this shipment.
	 */
	private AmountType insuranceValueAmount;
	/**
	 * The total net weight of this shipment, excluding packaging and transport
	 * equipment.
	 */
	private MeasureType netnetWeightMeasure;
	/**
	 * The total volume of the goods in this shipment, excluding packaging and
	 * transport equipment.
	 */
	private MeasureType netVolumeMeasure;
	/**
	 * The net weight of this shipment, excluding packaging.
	 */
	private MeasureType netWeightMeasure;
	/**
	 * A code signifying the priority or level of service required for this shipment.
	 */
	private CodeType shippingPriorityLevelCode;
	/**
	 * Special instructions relating to this shipment.
	 */
	private TextType specialInstructions;
	/**
	 * An indicator that the consignment has been split in transit (true) or not
	 * (false).
	 */
	private IndicatorType splitConsignmentIndicator;
	/**
	 * The total number of goods items in this shipment.
	 */
	private QuantityType totalGoodsItemQuantity;
	/**
	 * The number of pieces of transport handling equipment (pallets, boxes, cases,
	 * etc.) in this shipment.
	 */
	private QuantityType totalTransportHandlingUnitQuantity;
	private AddressModel returnAddress;
	private AddressModel originAddress;
	private AllowanceChargeModel freightAllowanceCharge;
	private List<ConsignmentModel> consignments = new ArrayList<>();
	private CountryModel exportCountry;
	private List<DeliveryModel> deliveries = new ArrayList<>();
	private List<GoodsItemModel> goodsItems = new ArrayList<>();
	private LocationModel lastExitPortLocation;
	private LocationModel firstArrivalPortLocation;
	private List<ShipmentStageModel> shipmentStages = new ArrayList<>();
	private List<TransportHandlingUnitModel> transportHandlingUnits = new ArrayList<>();

}
