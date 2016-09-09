package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.IndicatorType;
import org.openfact.models.jpa.entities.ublType.QuantityType;
import org.openfact.models.jpa.entities.ublType.TextType;

/**
 * A class to describe a uniquely identifiable unit consisting of one or more
 * packages, goods items, or pieces of transport equipment.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:46 a. m.
 */
public class TransportHandlingUnitEntity {

    /**
     * Text describing damage associated with this transport handling unit.
     */
    private TextType DamageRemarks;
    /**
     * The handling required for this transport handling unit, expressed as a
     * code.
     */
    private CodeType HandlingCode;
    /**
     * The handling required for this transport handling unit, expressed as
     * text.
     */
    private TextType HandlingInstructions;
    /**
     * An indicator that the materials contained in this transport handling unit
     * are subject to an international regulation concerning the carriage of
     * dangerous goods (true) or not (false).
     */
    private IndicatorType HazardousRiskIndicator;
    /**
     * An identifier for this transport handling unit.
     */
    private IdentifierType ID;
    /**
     * Text describing the marks and numbers on this transport handling unit.
     */
    private TextType ShippingMarks;
    /**
     * The total number of goods items in this transport handling unit.
     */
    private QuantityType TotalGoodsItemQuantity;
    /**
     * The total number of packages in this transport handling unit.
     */
    private QuantityType TotalPackageQuantity;
    /**
     * An identifier for use in tracing this transport handling unit, such as
     * the EPC number used in RFID.
     */
    private IdentifierType TraceID;
    /**
     * A code signifying the type of this transport handling unit.
     */
    private CodeType TransportHandlingUnitTypeCode;
    private List<CustomsDeclarationEntity> CustomsDeclarations = new ArrayList<>();
    private DespatchLineEntity HandlingUnitDespatchLine;
    private DimensionEntity FloorSpaceMeasurementDimension;
    private DimensionEntity PalletSpaceMeasurementDimension;
    private DimensionEntity MeasurementDimension;
    private DocumentReferenceEntity ShipmentDocumentReference;
    private List<GoodsItemEntity> GoodsItems = new ArrayList<>();
    private List<HazardousGoodsTransitEntity> HazardousGoodsTransits = new ArrayList<>();
    private List<PackageEntity> Packages = new ArrayList<>();
    private List<PackageEntity> ActualPackage = new ArrayList<>();
    private ReceiptLineEntity ReceivedHandlingUnitReceiptLine;
    private ShipmentEntity ReferencedShipment;
    private List<StatusEntity> Statuses = new ArrayList<>();
    private TemperatureEntity MinimumTemperature;
    private TemperatureEntity MaximumTemperature;
    private List<TransportEquipmentEntity> TransportEquipments = new ArrayList<>();
    private List<TransportMeansEntity> TransportMeanses = new ArrayList<>();

}
