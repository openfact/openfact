package org.openfact.models.ubl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A class to describe a piece of equipment used to transport goods.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:36 a. m.
 */
public class TransportEquipmentModel {

    /**
     * The percent of the airflow within this piece of transport equipment.
     */
    private BigDecimal airFlowPercent;
    /**
     * An indicator that this piece of transport equipment is approved for
     * animal food (true) or not (false).
     */
    private boolean animalFoodApprovedIndicator;
    /**
     * characteristics of this piece of transport equipment.
     */
    private TextModel characteristics;
    /**
     * Damage associated with this piece of transport equipment.
     */
    private TextModel damageRemarks;
    /**
     * An indicator that this piece of transport equipment is approved for
     * dangerous goods (true) or not (false).
     */
    private boolean dangerousGoodsApprovedIndicator;
    /**
     * Text describing this piece of transport equipment.
     */
    private TextModel description;
    /**
     * A code signifying the current disposition of this piece of transport
     * equipment.
     */
    private CodeModel dispositionCode;
    /**
     * A code signifying whether this piece of transport equipment is full,
     * partially full, or empty.
     */
    private CodeModel fullnessIndicationCode;
    /**
     * The gross volume of this piece of transport equipment.
     */
    private MeasureModel grossVolumeMeasure;
    /**
     * The gross weight of this piece of transport equipment.
     */
    private MeasureModel grossWeightMeasure;
    /**
     * An indicator that this piece of transport equipment is approved for human
     * food (true) or not (false).
     */
    private boolean humanFoodApprovedIndicator;
    /**
     * The percent humidity within this piece of transport equipment.
     */
    private BigDecimal humidityPercent;
    /**
     * An identifier for this piece of transport equipment.
     */
    private IdentifierModel ID;
    /**
     * Additional information about this piece of transport equipment.
     */
    private TextModel information;
    /**
     * An indication of the legal status of this piece of transport equipment
     * with respect to the Container Convention Code.
     */
    private boolean legalStatusIndicator;
    /**
     * A code signifying the type of owner of this piece of transport equipment.
     */
    private CodeModel ownerTypeCode;
    /**
     * An indicator that this piece of transport equipment can supply power
     * (true) or not (false).
     */
    private boolean powerIndicator;
    /**
     * A code signifying the type of provider of this piece of transport
     * equipment.
     */
    private CodeModel providerTypeCode;
    /**
     * An identifier for the consignment contained by this piece of transport
     * equipment.
     */
    private IdentifierModel referencedConsignmentID;
    /**
     * An indicator that this piece of transport equipment is refrigerated
     * (true) or not (false).
     */
    private boolean refrigeratedIndicator;
    /**
     * An indicator that this piece of transport equipment's refrigeration is on
     * (true) or off (false).
     */
    private boolean refrigerationOnIndicator;
    /**
     * An indicator that this piece of transport equipment is returnable (true)
     * or not (false).
     */
    private boolean returnabilityIndicator;
    /**
     * A code signifying the size and type of this piece of piece of transport
     * equipment. When the piece of transport equipment is a shipping container,
     * it is recommended to use ContainersizeTypeCode for validation.
     */
    private CodeModel sizeTypeCode;
    /**
     * Special transport requirements expressed as text.
     */
    private TextModel specialTransportRequirements;
    /**
     * The weight of this piece of transport equipment when empty.
     */
    private MeasureModel tareWeightMeasure;
    /**
     * An identifier for use in tracing this piece of transport equipment, such
     * as the EPC number used in RFID.
     */
    private IdentifierModel traceID;
    /**
     * A code signifying the tracking device for this piece of transport
     * equipment.
     */
    private CodeModel trackingDeviceCode;
    /**
     * A code signifying the type of this piece of transport equipment.
     */
    private List<TransportEquipmentModel> type_CodeTypeTransportEquipmentTypeCode = new ArrayList<>();
    private AllowanceChargeModel serviceAllowanceCharge;
    private AllowanceChargeModel freightAllowanceCharge;
    private List<DeliveryModel> deliveries = new ArrayList<>();
    private List<DespatchModel> despatches = new ArrayList<>();
    private DimensionModel measurementDimension;
    private DocumentReferenceModel shipmentDocumentReference;
    private List<GoodsItemModel> goodsItems = new ArrayList<>();
    private List<HazardousGoodsTransitModel> hazardousGoodsTransits = new ArrayList<>();
    private LocationModel loadingLocation;
    private LocationModel unloadingLocation;
    private LocationModel storageLocation;
    private List<PackageModel> packages = new ArrayList<>();
    private PartyModel ownerParty;
    private PartyModel operatingParty;
    private PartyModel providerParty;
    private PartyModel loadingProofParty;
    private List<PickupModel> pickups = new ArrayList<>();
    private List<SupplierPartyModel> supplierParties = new ArrayList<>();
    private TemperatureModel maximumTemperature;
    private TemperatureModel minimumTemperature;
    private TradingTermsModel haulageTradingTerms;
    private List<TransportEquipmentModel> containedInTransportEquipment = new ArrayList<>();
    private List<TransportEquipmentModel> attachedTransportEquipment = new ArrayList<>();
    private List<TransportEquipmentModel> sealTransportEquipmentSeals = new ArrayList<>();
    private List<TransportEventModel> quarantineTransportEvent = new ArrayList<>();
    private List<TransportEventModel> positioningTransportEvent = new ArrayList<>();
    private List<TransportEventModel> transportEvents = new ArrayList<>();
    private List<TransportEventModel> loadingTransportEvent = new ArrayList<>();
    private List<TransportEventModel> deliveryTransportEvent = new ArrayList<>();
    private List<TransportEventModel> pickupTransportEvent = new ArrayList<>();
    private List<TransportEventModel> handlingTransportEvent = new ArrayList<>();
    private TransportHandlingUnitModel packagedTransportHandlingUnit;
    private TransportMeansModel applicableTransportMeans;

}
