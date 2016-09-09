package adapter;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A scheduled prepayment (on-account payment) for a estimated utility consumption
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:16:14 a. m.
 */
public class OnAccountPaymentAdapter{

	/**
	 * The estimated consumed quantity covered by the payment.
	 */
	private QuantityType EstimatedConsumedQuantity;
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private TextType Note;
	private List<PaymentTermsAdapter> PaymentTermses = new ArrayList<>();

}
