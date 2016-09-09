package org.openfact.models.jpa.entities.ubl;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe a uniquely identifiable unit consisting of one or more
 * packages, goods items, or pieces of transport equipment.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:46 a. m.
 */
public class TransportHandlingUnit{

	/**
	 * Text describing damage associated with this transport handling unit.
	 */
	private TextType DamageRemarks;
	/**
	 * The handling required for this transport handling unit, expressed as a code.
	 */
	private CodeType HandlingCode;
	/**
	 * The handling required for this transport handling unit, expressed as text.
	 */
	private TextType HandlingInstructions;
	/**
	 * An indicator that the materials contained in this transport handling unit are
	 * subject to an international regulation concerning the carriage of dangerous
	 * goods (true) or not (false).
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
	 * An identifier for use in tracing this transport handling unit, such as the EPC
	 * number used in RFID.
	 */
	private IdentifierType TraceID;
	/**
	 * A code signifying the type of this transport handling unit.
	 */
	private CodeType TransportHandlingUnitTypeCode;
	private List<CustomsDeclaration> CustomsDeclarations = new ArrayList<>();
	private DespatchLine HandlingUnitDespatchLine;
	private Dimension FloorSpaceMeasurementDimension;
	private Dimension PalletSpaceMeasurementDimension;
	private Dimension MeasurementDimension;
	private DocumentReference ShipmentDocumentReference;
	private List<GoodsItem> GoodsItems = new ArrayList<>();
	private List<HazardousGoodsTransit> HazardousGoodsTransits = new ArrayList<>();
	private List<Package> Packages = new ArrayList<>();
	private List<Package> ActualPackage = new ArrayList<>();
	private ReceiptLine ReceivedHandlingUnitReceiptLine;
	private Shipment ReferencedShipment;
	private List<Status> Statuses = new ArrayList<>();
	private Temperature MinimumTemperature;
	private Temperature MaximumTemperature;
	private List<TransportEquipment> TransportEquipments = new ArrayList<>();
	private List<TransportMeans> TransportMeanses = new ArrayList<>();

}
