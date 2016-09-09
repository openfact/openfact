package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
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
public class TransportHandlingUnitModel{

	/**
	 * Text describing damage associated with this transport handling unit.
	 */
	private TextType damageRemarks; 
	/**
	 * The handling required for this transport handling unit, expressed as a code.
	 */
	private CodeType handlingCode; 
	/**
	 * The handling required for this transport handling unit, expressed as text.
	 */
	private TextType handlingInstructions; 
	/**
	 * An indicator that the materials contained in this transport handling unit are
	 * subject to an international regulation concerning the carriage of dangerous
	 * goods (true) or not (false).
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
	 * An identifier for use in tracing this transport handling unit, such as the EPC
	 * number used in RFID.
	 */
	private IdentifierType traceID; 
	/**
	 * A code signifying the type of this transport handling unit.
	 */
	private CodeType transportHandlingUnitTypeCode; 
	private List<CustomsDeclarationModel> customsDeclarations = new ArrayList<>(); 
	private DespatchLineModel handlingUnitDespatchLine; 
	private DimensionModel floorSpaceMeasurementDimension; 
	private DimensionModel palletSpaceMeasurementDimension; 
	private DimensionModel measurementDimension; 
	private DocumentReferenceModel shipmentDocumentReference; 
	private List<GoodsItemModel> goodsItems = new ArrayList<>(); 
	private List<HazardousGoodsTransitModel> hazardousGoodsTransits = new ArrayList<>(); 
	private List<PackageModel> packages = new ArrayList<>(); 
	private List<PackageModel> actualPackage = new ArrayList<>(); 
	private ReceiptLineModel receivedHandlingUnitReceiptLine; 
	private ShipmentModel referencedShipment; 
	private List<StatusModel> statuses = new ArrayList<>(); 
	private TemperatureModel minimumTemperature; 
	private TemperatureModel maximumTemperature; 
	private List<TransportEquipmentModel> transportEquipments = new ArrayList<>(); 
	private List<TransportMeansModel> transportMeanses = new ArrayList<>(); 

}
