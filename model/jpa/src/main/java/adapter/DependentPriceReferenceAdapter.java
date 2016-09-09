package adapter;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define the price of an item as a percentage of the price of a
 * different item.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:26 a. m.
 */
public class DependentPriceReferenceAdapter{

	/**
	 * The percentage by which the price of the different item is multiplied to
	 * calculate the price of the item.
	 */
	private PercentType Percent;
	private AddressAdapter LocationAddress;
	private LineReferenceAdapter DependentLineReference;

}
