package representation;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define a reference to an Order.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:18 a. m.
 */
public class OrderReferenceRepresentation{

	/**
	 * Indicates whether the referenced OrderRepresentation is a copy (true) or the original (false).
	 */
	private IndicatorType CopyIndicator;
	/**
	 * Text used for tagging purchasing card transactions.
	 */
	private TextType CustomerReference;
	/**
	 * An identifier for this order reference, assigned by the buyer.
	 */
	private IdentifierType ID;
	/**
	 * The date on which the referenced OrderRepresentation was issued.
	 */
	private DateType IssueDate;
	/**
	 * The time at which the referenced OrderRepresentation was issued.
	 */
	private TimeType IssueTime;
	/**
	 * A code signifying the type of the referenced Order.
	 */
	private CodeType OrderTypeCode;
	/**
	 * An identifier for this order reference, assigned by the seller.
	 */
	private IdentifierType SalesOrderID;
	/**
	 * A universally unique identifier for this order reference.
	 */
	private IdentifierType UUID;
	private List<DocumentReferenceRepresentation> DocumentReferences = new ArrayList<>();

}
