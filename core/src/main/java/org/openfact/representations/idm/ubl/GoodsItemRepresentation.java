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
 * A class to describe a separately identifiable quantity of goods of a single
 * product type.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:24 a. m.
 */
public class GoodsItemRepresentation {

    /**
     * The number of units in the goods item to which charges apply.
     */
    private QuantityRepresentation chargeableQuantity;
    /**
     * The weight on which a charge is to be based.
     */
    private MeasureRepresentation chargeableWeightMeasure;
    /**
     * An indicator that this goods item has been classified for import by
     * customs (true) or not (false).
     */
    private boolean customsImportClassifiedIndicator;
    /**
     * A code assigned by customs to signify the status of this goods item.
     */
    private CodeRepresentation customsStatusCode;
    /**
     * quantity of the units in this goods item as required by customs for
     * tariff, statistical, or fiscal purposes.
     */
    private QuantityRepresentation customsTariffQuantity;
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
    private TextRepresentation description;
    /**
     * The monetary amount that has to be or has been paid as calculated under
     * the applicable trade delivery.
     */
    private BigDecimal freeOnBoardValueAmount;
    /**
     * The volume of this goods item, normally calculated by multiplying its
     * maximum length, width, and height.
     */
    private MeasureRepresentation grossVolumeMeasure;
    /**
     * The weight of this goods item, including packing and packaging but
     * excluding the carrier's equipment.
     */
    private MeasureRepresentation grossWeightMeasure;
    /**
     * An indication that the transported goods item is subject to an
     * international regulation concerning the carriage of dangerous goods
     * (true) or not (false).
     */
    private boolean hazardousRiskIndicator;
    /**
     * An identifier for this goods item.
     */
    private IdentifierRepresentation ID;
    /**
     * The amount covered by insurance for this goods item.
     */
    private BigDecimal insuranceValueAmount;
    /**
     * The total weight of this goods item, excluding all packing and packaging.
     */
    private MeasureRepresentation netNetWeightMeasure;
    /**
     * The volume contained by a goods item, excluding the volume of any
     * packaging material.
     */
    private MeasureRepresentation netVolumeMeasure;
    /**
     * The weight of this goods item, excluding packing but including packaging
     * that normally accompanies the goods.
     */
    private MeasureRepresentation netWeightMeasure;
    /**
     * A code signifying the treatment preference for this goods item according
     * to international trading agreements.
     */
    private CodeRepresentation preferenceCriterionCode;
    /**
     * The number of units making up this goods item.
     */
    private QuantityRepresentation quantity;
    /**
     * An identifier for a set of tariff codes required to specify a type of
     * goods for customs, transport, statistical, or other regulatory purposes.
     */
    private IdentifierRepresentation requiredCustomsID;
    /**
     * The number of units in the goods item that may be returned.
     */
    private QuantityRepresentation returnableQuantity;
    /**
     * A sequence number differentiating a specific goods item within a
     * consignment.
     */
    private IdentifierRepresentation sequenceNumberID;
    /**
     * An identifier for use in tracing this goods item, such as the EPC number
     * used in RFID.
     */
    private IdentifierRepresentation traceID;
    /**
     * The amount on which a duty, tax, or fee will be assessed.
     */
    private BigDecimal valueAmount;
    private AddressRepresentation originAddress;
    private AllowanceChargeRepresentation freightAllowanceCharge;
    private List<DeliveryRepresentation> deliveries = new ArrayList<>();
    private List<DespatchRepresentation> despatches = new ArrayList<>();
    private DimensionRepresentation measurementDimension;
    private DocumentReferenceRepresentation shipmentDocumentReference;
    private List<InvoiceLineRepresentation> invoiceLines = new ArrayList<>();
    private GoodsItemRepresentation containedGoodsItem;
    private List<GoodsItemContainerRepresentation> goodsItemContainers = new ArrayList<>();
    private List<ItemRepresentation> items = new ArrayList<>();
    private PackageRepresentation containingPackage;
    private List<PickupRepresentation> pickups = new ArrayList<>();
    private List<TemperatureRepresentation> temperatures = new ArrayList<>();
    private List<TemperatureRepresentation> maximumTemperature = new ArrayList<>();
    private List<TemperatureRepresentation> minimumTemperature = new ArrayList<>();

}
