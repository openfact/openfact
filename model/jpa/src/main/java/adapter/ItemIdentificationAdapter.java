package adapter;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class for assigning identifying information to an item.
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:15:42 a. m.
 */
public class ItemIdentificationAdapter{

	/**
	 * An identifier for a system of barcodes.
	 */
	private IdentifierType BarcodeSymbologyID;
	/**
	 * An extended identifier for the item that identifies the item with specific
	 * properties, e.g., ItemAdapter 123 = Chair / ItemAdapter 123 Ext 45 = brown chair. Two chairs
	 * can have the same item number, but one is brown. The other is white.
	 */
	private IdentifierType ExtendedID;
	/**
	 * An identifier for the item.
	 */
	private IdentifierType ID;
	private DimensionAdapter MeasurementDimension;
	private PartyAdapter IssuerParty;
	private List<PhysicalAttributeAdapter> PhysicalAttributes = new ArrayList<>();

}
