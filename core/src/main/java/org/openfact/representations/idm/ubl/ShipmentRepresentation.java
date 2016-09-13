package org.openfact.representations.idm.ubl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.MeasureRepresentation;
import org.openfact.representations.idm.ubl.type.QuantityRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

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
public class ShipmentRepresentation {

    /**
     * The total number of consignments within this shipment.
     */
    private QuantityRepresentation consignmentQuantity;
    /**
     * The total declared value for customs purposes of those goods in this
     * shipment that are subject to the same customs procedure and have the same
     * tariff/statistical heading, country information, and duty regime.
     */
    private BigDecimal declaredCustomsValueAmount;
    /**
     * The value of this shipment, declared by the shipper or his agent solely
     * for the purpose of varying the carrier's level of liability from that
     * provided in the contract of carriage, in case of loss or damage to goods
     * or delayed delivery.
     */
    private BigDecimal declaredForCarriageValueAmount;
    /**
     * The value, declared for statistical purposes, of those goods in this
     * shipment that have the same statistical heading.
     */
    private BigDecimal declaredStatisticsValueAmount;
    /**
     * DeliveryRepresentation instructions relating to this shipment.
     */
    private TextRepresentation deliveryInstructions;
    /**
     * The monetary amount that has to be or has been paid as calculated under
     * the applicable trade delivery.
     */
    private BigDecimal freeOnBoardValueAmount;
    /**
     * The total volume of the goods in this shipment, including packaging.
     */
    private MeasureRepresentation grossVolumeMeasure;
    /**
     * The total gross weight of a shipment; the weight of the goods plus
     * packaging plus transport equipment.
     */
    private MeasureRepresentation grossWeightMeasure;
    /**
     * The handling required for this shipment, expressed as a code.
     */
    private CodeRepresentation handlingCode;
    /**
     * The handling required for this shipment, expressed as text.
     */
    private TextRepresentation handlingInstructions;
    /**
     * An identifier for this shipment.
     */
    private IdentifierRepresentation ID;
    /**
     * Free-form text pertinent to this shipment, conveying information that is
     * not contained explicitly in other structures.
     */
    private TextRepresentation information;
    /**
     * The amount covered by insurance for this shipment.
     */
    private BigDecimal insuranceValueAmount;
    /**
     * The total net weight of this shipment, excluding packaging and transport
     * equipment.
     */
    private MeasureRepresentation netNetWeightMeasure;
    /**
     * The total volume of the goods in this shipment, excluding packaging and
     * transport equipment.
     */
    private MeasureRepresentation netVolumeMeasure;
    /**
     * The net weight of this shipment, excluding packaging.
     */
    private MeasureRepresentation netWeightMeasure;
    /**
     * A code signifying the priority or level of service required for this
     * shipment.
     */
    private CodeRepresentation shippingPriorityLevelCode;
    /**
     * Special instructions relating to this shipment.
     */
    private TextRepresentation specialInstructions;
    /**
     * An indicator that the consignment has been split in transit (true) or not
     * (false).
     */
    private boolean splitConsignmentIndicator;
    /**
     * The total number of goods items in this shipment.
     */
    private QuantityRepresentation totalGoodsItemQuantity;
    /**
     * The number of pieces of transport handling equipment (pallets, boxes,
     * cases, etc.) in this shipment.
     */
    private QuantityRepresentation totalTransportHandlingUnitQuantity;
    private AddressRepresentation returnAddress;
    private AddressRepresentation originAddress;
    private AllowanceChargeRepresentation freightAllowanceCharge;
    private List<ConsignmentRepresentation> consignments = new ArrayList<>();
    private CountryRepresentation exportCountry;
    private List<DeliveryRepresentation> deliveries = new ArrayList<>();
    private List<GoodsItemRepresentation> goodsItems = new ArrayList<>();
    private LocationRepresentation lastExitPortLocation;
    private LocationRepresentation firstArrivalPortLocation;
    private List<ShipmentStageRepresentation> shipmentStages = new ArrayList<>();
    private List<TransportHandlingUnitRepresentation> transportHandlingUnits = new ArrayList<>();

}
