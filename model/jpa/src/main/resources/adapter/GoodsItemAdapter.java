package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe a separately identifiable quantity of goods of a single
 * product type.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:24 a. m.
 */
public class GoodsItemAdapter{

	/**
	 * The number of units in the goods item to which charges apply.
	 */
	private QuantityType chargeableQuantity; 
	/**
	 * The weight on which a charge is to be based.
	 */
	private MeasureType chargeableWeightMeasure; 
	/**
	 * An indicator that this goods item has been classified for import by customs
	 * (true) or not (false).
	 */
	private boolean customsImportClassifiedIndicator; 
	/**
	 * A code assigned by customs to signify the status of this goods item.
	 */
	private CodeType customsStatusCode; 
	/**
	 * quantity of the units in this goods item as required by customs for tariff,
	 * statistical, or fiscal purposes.
	 */
	private QuantityType customsTariffQuantity; 
	/**
	 * The total declared value for customs purposes of the goods item.
	 */
	private BigDecimal declaredCustomsValueAmount; 
	/**
	 * The value of this goods item, declared by the shipper or his agent solely for
	 * the purpose of varying the carrier's level of liability from that provided in
	 * the contract of carriage, in case of loss or damage to goods or delayed
	 * delivery.
	 */
	private BigDecimal declaredForCarriageValueAmount; 
	/**
	 * The total declared value of all the goods items in the same consignment with
	 * this goods item that have the same statistical heading.
	 */
	private BigDecimal declaredStatisticsValueAmount; 
	/**
	 * Text describing this goods item to identify it for customs, statistical, or
	 * transport purposes.
	 */
	private TextType description; 
	/**
	 * The monetary amount that has to be or has been paid as calculated under the
	 * applicable trade delivery.
	 */
	private BigDecimal freeOnBoardValueAmount; 
	/**
	 * The volume of this goods item, normally calculated by multiplying its maximum
	 * length, width, and height.
	 */
	private MeasureType grossVolumeMeasure; 
	/**
	 * The weight of this goods item, including packing and packaging but excluding
	 * the carrier's equipment.
	 */
	private MeasureType grossWeightMeasure; 
	/**
	 * An indication that the transported goods item is subject to an international
	 * regulation concerning the carriage of dangerous goods (true) or not (false).
	 */
	private boolean hazardousRiskIndicator; 
	/**
	 * An identifier for this goods item.
	 */
	private IdentifierType ID; 
	/**
	 * The amount covered by insurance for this goods item.
	 */
	private BigDecimal insuranceValueAmount; 
	/**
	 * The total weight of this goods item, excluding all packing and packaging.
	 */
	private MeasureType netNetWeightMeasure; 
	/**
	 * The volume contained by a goods item, excluding the volume of any packaging
	 * material.
	 */
	private MeasureType netVolumeMeasure; 
	/**
	 * The weight of this goods item, excluding packing but including packaging that
	 * normally accompanies the goods.
	 */
	private MeasureType netWeightMeasure; 
	/**
	 * A code signifying the treatment preference for this goods item according to
	 * international trading agreements.
	 */
	private CodeType preferenceCriterionCode; 
	/**
	 * The number of units making up this goods item.
	 */
	private QuantityType quantity; 
	/**
	 * An identifier for a set of tariff codes required to specify a type of goods for
	 * customs, transport, statistical, or other regulatory purposes.
	 */
	private IdentifierType requiredCustomsID; 
	/**
	 * The number of units in the goods item that may be returned.
	 */
	private QuantityType returnableQuantity; 
	/**
	 * A sequence number differentiating a specific goods item within a consignment.
	 */
	private IdentifierType sequenceNumberID; 
	/**
	 * An identifier for use in tracing this goods item, such as the EPC number used
	 * in RFID.
	 */
	private IdentifierType traceID; 
	/**
	 * The amount on which a duty, tax, or fee will be assessed.
	 */
	private BigDecimal valueAmount; 
	private AddressAdapter originAddress; 
	private AllowanceChargeAdapter freightAllowanceCharge; 
	private List<DeliveryAdapter> deliveries = new ArrayList<>(); 
	private List<DespatchAdapter> despatches = new ArrayList<>(); 
	private DimensionAdapter measurementDimension; 
	private DocumentReferenceAdapter shipmentDocumentReference; 
	private List<InvoiceLineAdapter> invoiceLines = new ArrayList<>(); 
	private GoodsItemAdapter containedGoodsItem; 
	private List<GoodsItemContainerAdapter> goodsItemContainers = new ArrayList<>(); 
	private List<ItemAdapter> items = new ArrayList<>(); 
	private PackageAdapter containingPackage; 
	private List<PickupAdapter> pickups = new ArrayList<>(); 
	private List<TemperatureAdapter> temperatures = new ArrayList<>(); 
	private List<TemperatureAdapter> maximumTemperature = new ArrayList<>(); 
	private List<TemperatureAdapter> minimumTemperature = new ArrayList<>(); 

}
