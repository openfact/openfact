package org.openfact.representations.idm.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.QuantityRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A class to describe a uniquely identifiable unit consisting of one or more
 * packages, goods items, or pieces of transport equipment.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:46 a. m.
 */
public class TransportHandlingUnitRepresentation {

    /**
     * Text describing damage associated with this transport handling unit.
     */
    private TextRepresentation damageRemarks;
    /**
     * The handling required for this transport handling unit, expressed as a
     * code.
     */
    private CodeRepresentation handlingCode;
    /**
     * The handling required for this transport handling unit, expressed as
     * text.
     */
    private TextRepresentation handlingInstructions;
    /**
     * An indicator that the materials contained in this transport handling unit
     * are subject to an international regulation concerning the carriage of
     * dangerous goods (true) or not (false).
     */
    private boolean hazardousRiskIndicator;
    /**
     * An identifier for this transport handling unit.
     */
    private IdentifierRepresentation ID;
    /**
     * Text describing the marks and numbers on this transport handling unit.
     */
    private TextRepresentation shippingMarks;
    /**
     * The total number of goods items in this transport handling unit.
     */
    private QuantityRepresentation totalGoodsItemQuantity;
    /**
     * The total number of packages in this transport handling unit.
     */
    private QuantityRepresentation totalPackageQuantity;
    /**
     * An identifier for use in tracing this transport handling unit, such as
     * the EPC number used in RFID.
     */
    private IdentifierRepresentation traceID;
    /**
     * A code signifying the type of this transport handling unit.
     */
    private CodeRepresentation transportHandlingUnitTypeCode;
    private List<CustomsDeclarationRepresentation> customsDeclarations = new ArrayList<>();
    private DespatchLineRepresentation handlingUnitDespatchLine;
    private DimensionRepresentation floorSpaceMeasurementDimension;
    private DimensionRepresentation palletSpaceMeasurementDimension;
    private DimensionRepresentation measurementDimension;
    private DocumentReferenceRepresentation shipmentDocumentReference;
    private List<GoodsItemRepresentation> goodsItems = new ArrayList<>();
    private List<HazardousGoodsTransitRepresentation> hazardousGoodsTransits = new ArrayList<>();
    private List<PackageRepresentation> packages = new ArrayList<>();
    private List<PackageRepresentation> actualPackage = new ArrayList<>();
    private ReceiptLineRepresentation receivedHandlingUnitReceiptLine;
    private ShipmentRepresentation referencedShipment;
    private List<StatusRepresentation> statuses = new ArrayList<>();
    private TemperatureRepresentation minimumTemperature;
    private TemperatureRepresentation maximumTemperature;
    private List<TransportEquipmentRepresentation> transportEquipments = new ArrayList<>();
    private List<TransportMeansRepresentation> transportMeanses = new ArrayList<>();

}
