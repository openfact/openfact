package adapter;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define a reference to an Order.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:18 a. m.
 */
public class OrderReferenceAdapter{

	/**
	 * Indicates whether the referenced OrderAdapter is a copy (true) or the original (false).
	 */
	private IndicatorType copyIndicator;
	/**
	 * Text used for tagging purchasing card transactions.
	 */
	private TextType customerReference;
	/**
	 * An identifier for this order reference, assigned by the buyer.
	 */
	private IdentifierType ID;
	/**
	 * The date on which the referenced OrderAdapter was issued.
	 */
	private DateType issueDate;
	/**
	 * The time at which the referenced OrderAdapter was issued.
	 */
	private TimeType issueTime;
	/**
	 * A code signifying the type of the referenced Order.
	 */
	private CodeType orderTypeCode;
	/**
	 * An identifier for this order reference, assigned by the seller.
	 */
	private IdentifierType salesOrderID;
	/**
	 * A universally unique identifier for this order reference.
	 */
	private IdentifierType UUID;
	private List<DocumentReferenceAdapter> documentReferences = new ArrayList<>();

}
