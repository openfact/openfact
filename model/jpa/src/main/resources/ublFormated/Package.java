package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe a package.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:21 a. m.
 */
public class Package{

	/**
	 * An identifier for this package.
	 */
	private IdentifierType ID;
	/**
	 * A code signifying a level of packaging.
	 */
	private CodeType PackageLevelCode;
	/**
	 * A code signifying a type of packaging.
	 */
	private PackagingTypeCodeType PackagingTypeCode;
	/**
	 * Text describing the packaging material.
	 */
	private TextType PackingMaterial;
	/**
	 * The quantity of items contained in this package.
	 */
	private QuantityType Quantity;
	/**
	 * An indicator that the packaging material is returnable (true) or not (false).
	 */
	private boolean ReturnableMaterialIndicator;
	/**
	 * An identifier for use in tracing this package, such as the EPC number used in
	 * RFID.
	 */
	private IdentifierType TraceID;
	private List<Delivery> Deliveries = new ArrayList<>();
	private List<DeliveryUnit> DeliveriesUnit = new ArrayList<>();
	private List<Despatch> Despatches = new ArrayList<>();
	private Dimension MeasurementDimension;
	private List<GoodsItem> GoodsItems = new ArrayList<>();
	private Package ContainedPackage;
	private List<Pickup> Pickups = new ArrayList<>();
	private TransportEquipment ContainingTransportEquipment;

}
