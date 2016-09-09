package model;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe a package.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:21 a. m.
 */
public class PackageModel{

	/**
	 * An identifier for this package.
	 */
	private IdentifierType ID;
	/**
	 * A code signifying a level of packaging.
	 */
	private CodeType packageLevelCode;
	/**
	 * A code signifying a type of packaging.
	 */
	private packagingTypeCodeType packagingTypeCode;
	/**
	 * Text describing the packaging material.
	 */
	private TextType packingMaterial;
	/**
	 * The quantity of items contained in this package.
	 */
	private quantityType quantity;
	/**
	 * An indicator that the packaging material is returnable (true) or not (false).
	 */
	private IndicatorType returnableMaterialIndicator;
	/**
	 * An identifier for use in tracing this package, such as the EPC number used in
	 * RFID.
	 */
	private IdentifierType traceID;
	private List<DeliveryModel> deliveries = new ArrayList<>();
	private List<DeliveryUnitModel> deliveriesUnit = new ArrayList<>();
	private List<DespatchModel> despatches = new ArrayList<>();
	private DimensionModel measurementDimension;
	private List<GoodsItemModel> goodsItems = new ArrayList<>();
	private PackageModel containedPackage;
	private List<PickupModel> pickups = new ArrayList<>();
	private TransportEquipmentModel containingTransportEquipment;

}
