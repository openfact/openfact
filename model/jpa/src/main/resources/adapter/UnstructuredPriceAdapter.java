package adapter;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A simplified version of the PriceAdapter class intended for applications such as
 * telephone billing.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:54 a. m.
 */
public class UnstructuredPriceAdapter{

	/**
	 * The price amount.
	 */
	private AmountType priceAmount;
	/**
	 * The usage time upon which the price is based.
	 */
	private TextType timeAmount;

}
