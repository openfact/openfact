package org.openfact.models.ubl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A class to describe a separately identifiable quantity of goods of a single
 * product type.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:24 a. m.
 */
public class GoodsItemModel {

    /**
     * The number of units in the goods item to which charges apply.
     */
    private QuantityModel chargeableQuantity;
    /**
     * The weight on which a charge is to be based.
     */
    private MeasureModel chargeableWeightMeasure;
    /**
     * An indicator that this goods item has been classified for import by
     * customs (true) or not (false).
     */
    private boolean customsImportClassifiedIndicator;
    /**
     * A code assigned by customs to signify the status of this goods item.
     */
    private CodeModel customsStatusCode;
    /**
     * quantity of the units in this goods item as required by customs for
     * tariff, statistical, or fiscal purposes.
     */
    private QuantityModel customsTariffQuantity;
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
    private TextModel description;
    /**
     * The monetary amount that has to be or has been paid as calculated under
     * the applicable trade delivery.
     */
    private BigDecimal freeOnBoardValueAmount;
    /**
     * The volume of this goods item, normally calculated by multiplying its
     * maximum length, width, and height.
     */
    private MeasureModel grossVolumeMeasure;
    /**
     * The weight of this goods item, including packing and packaging but
     * excluding the carrier's equipment.
     */
    private MeasureModel grossWeightMeasure;
    /**
     * An indication that the transported goods item is subject to an
     * international regulation concerning the carriage of dangerous goods
     * (true) or not (false).
     */
    private boolean hazardousRiskIndicator;
    /**
     * An identifier for this goods item.
     */
    private IdentifierModel ID;
    /**
     * The amount covered by insurance for this goods item.
     */
    private BigDecimal insuranceValueAmount;
    /**
     * The total weight of this goods item, excluding all packing and packaging.
     */
    private MeasureModel netNetWeightMeasure;
    /**
     * The volume contained by a goods item, excluding the volume of any
     * packaging material.
     */
    private MeasureModel netVolumeMeasure;
    /**
     * The weight of this goods item, excluding packing but including packaging
     * that normally accompanies the goods.
     */
    private MeasureModel netWeightMeasure;
    /**
     * A code signifying the treatment preference for this goods item according
     * to international trading agreements.
     */
    private CodeModel preferenceCriterionCode;
    /**
     * The number of units making up this goods item.
     */
    private QuantityModel quantity;
    /**
     * An identifier for a set of tariff codes required to specify a type of
     * goods for customs, transport, statistical, or other regulatory purposes.
     */
    private IdentifierModel requiredCustomsID;
    /**
     * The number of units in the goods item that may be returned.
     */
    private QuantityModel returnableQuantity;
    /**
     * A sequence number differentiating a specific goods item within a
     * consignment.
     */
    private IdentifierModel sequenceNumberID;
    /**
     * An identifier for use in tracing this goods item, such as the EPC number
     * used in RFID.
     */
    private IdentifierModel traceID;
    /**
     * The amount on which a duty, tax, or fee will be assessed.
     */
    private BigDecimal valueAmount;
    private AddressModel originAddress;
    private AllowanceChargeModel freightAllowanceCharge;
    private List<DeliveryModel> deliveries = new ArrayList<>();
    private List<DespatchModel> despatches = new ArrayList<>();
    private DimensionModel measurementDimension;
    private DocumentReferenceModel shipmentDocumentReference;
    private List<InvoiceLineModel> invoiceLines = new ArrayList<>();
    private GoodsItemModel containedGoodsItem;
    private List<GoodsItemContainerModel> goodsItemContainers = new ArrayList<>();
    private List<ItemModel> items = new ArrayList<>();
    private PackageModel containingPackage;
    private List<PickupModel> pickups = new ArrayList<>();
    private List<TemperatureModel> temperatures = new ArrayList<>();
    private List<TemperatureModel> maximumTemperature = new ArrayList<>();
    private List<TemperatureModel> minimumTemperature = new ArrayList<>();

}
