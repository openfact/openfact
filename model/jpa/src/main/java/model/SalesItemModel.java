package model;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe information related to an item in a sales context
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:37 a. m.
 */
public class SalesItemModel{

	/**
	 * The quantity the given information are related to
	 */
	private QuantityType Quantity;
	private List<ActivityPropertyModel> ActivityProperties = new ArrayList<>();
	private List<ItemModel> Items = new ArrayList<>();
	private PriceModel TaxExclusivePrice;
	private PriceModel TaxInclusivePrice;

}
