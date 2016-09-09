package adapter;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe information related to an item in a sales context
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:37 a. m.
 */
public class SalesItemAdapter{

	/**
	 * The quantity the given information are related to
	 */
	private quantityType quantity;
	private List<ActivityPropertyAdapter> activityProperties = new ArrayList<>();
	private List<ItemAdapter> items = new ArrayList<>();
	private PriceAdapter taxExclusivePrice;
	private PriceAdapter taxInclusivePrice;

}
