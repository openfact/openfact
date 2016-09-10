package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.CodeType;
import org.openfact.models.ubl.type.IdentifierType;
import org.openfact.models.ubl.type.QuantityType;
import org.openfact.models.ubl.type.TextType;

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
    private TextType damageRemarks;
    /**
     * The handling required for this transport handling unit, expressed as a
     * code.
     */
    private CodeType handlingCode;
    /**
     * The handling required for this transport handling unit, expressed as
     * text.
     */
    private TextType handlingInstructions;
    /**
     * An indicator that the materials contained in this transport handling unit
     * are subject to an international regulation concerning the carriage of
     * dangerous goods (true) or not (false).
     */
    private boolean hazardousRiskIndicator;
    /**
     * An identifier for this transport handling unit.
     */
    private IdentifierType ID;
    /**
     * Text describing the marks and numbers on this transport handling unit.
     */
    private TextType shippingMarks;
    /**
     * The total number of goods items in this transport handling unit.
     */
    private QuantityType totalGoodsItemQuantity;
    /**
     * The total number of packages in this transport handling unit.
     */
    private QuantityType totalPackageQuantity;
    /**
     * An identifier for use in tracing this transport handling unit, such as
     * the EPC number used in RFID.
     */
    private IdentifierType traceID;
    /**
     * A code signifying the type of this transport handling unit.
     */
    private CodeType transportHandlingUnitTypeCode;
    private List<CustomsDeclarationEntity> customsDeclarations = new ArrayList<>();
    private DespatchLineEntity handlingUnitDespatchLine;
    private DimensionEntity floorSpaceMeasurementDimension;
    private DimensionEntity palletSpaceMeasurementDimension;
    private DimensionEntity measurementDimension;
    private DocumentReferenceEntity shipmentDocumentReference;
    private List<GoodsItemEntity> goodsItems = new ArrayList<>();
    private List<HazardousGoodsTransitEntity> hazardousGoodsTransits = new ArrayList<>();
    private List<PackageEntity> packages = new ArrayList<>();
    private List<PackageEntity> actualPackage = new ArrayList<>();
    private ReceiptLineEntity receivedHandlingUnitReceiptLine;
    private ShipmentEntity referencedShipment;
    private List<StatusEntity> statuses = new ArrayList<>();
    private TemperatureEntity minimumTemperature;
    private TemperatureEntity maximumTemperature;
    private List<TransportEquipmentEntity> transportEquipments = new ArrayList<>();
    private List<TransportMeansEntity> transportMeanses = new ArrayList<>();

}
