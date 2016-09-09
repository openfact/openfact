package org.openfact.models.jpa.entities.ubl;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define a line in an InventoryReport.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:15:35 a. m.
 */
public class InventoryReportLine{

	/**
	 * The date from which the goods will be available. If not present, the goods are
	 * available now.
	 */
	private DateType AvailabilityDate;
	/**
	 * A code signifying the item's level of availability.
	 */
	private CodeType AvailabilityStatusCode;
	/**
	 * An identifier for this inventory report line.
	 */
	private IdentifierType ID;
	/**
	 * The value of the quantity of the item reported that is currently in stock.
	 */
	private AmountType InventoryValueAmount;
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private TextType Note;
	/**
	 * The quantity of the item reported that is currently in stock.
	 */
	private QuantityType Quantity;
	private List<Item> Items = new ArrayList<>();
	private Location InventoryLocation;

}
