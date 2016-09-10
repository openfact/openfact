package org.openfact.models.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class for assigning identifying information to an item.
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:15:42 a. m.
 */
public class ItemIdentificationModel{

	/**
	 * An identifier for a system of barcodes.
	 */
	private IdentifierType barcodeSymbologyID; 
	/**
	 * An extended identifier for the item that identifies the item with specific
	 * properties, e.g., ItemModel 123 = Chair / ItemModel 123 Ext 45 = brown chair. Two chairs
	 * can have the same item number, but one is brown. The other is white.
	 */
	private IdentifierType extendedID; 
	/**
	 * An identifier for the item.
	 */
	private IdentifierType ID; 
	private DimensionModel measurementDimension; 
	private PartyModel issuerParty; 
	private List<PhysicalAttributeModel> physicalAttributes = new ArrayList<>(); 

}
