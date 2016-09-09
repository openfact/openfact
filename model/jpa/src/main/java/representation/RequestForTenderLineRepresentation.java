package representation;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define a line in a Request for TenderRepresentation describing an item of goods or
 * a service solicited in the Request for Tender.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:29 a. m.
 */
public class RequestForTenderLineRepresentation{

	/**
	 * The estimated total amount of the deliverable.
	 */
	private AmountType EstimatedAmount;
	/**
	 * An identifier for this request for tender line.
	 */
	private IdentifierType ID;
	/**
	 * The maximum amount allowed for this deliverable.
	 */
	private AmountType MaximumAmount;
	/**
	 * The maximum quantity of the item associated with this request for tender line.
	 */
	private QuantityType MaximumQuantity;
	/**
	 * The minimum amount allowed for this deliverable.
	 */
	private AmountType MinimumAmount;
	/**
	 * The minimum quantity of the item associated with this request for tender line.
	 */
	private QuantityType MinimumQuantity;
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private TextType Note;
	/**
	 * The quantity of the item for which a tender is requested in this line.
	 */
	private QuantityType Quantity;
	/**
	 * Indicates whether the amounts are taxes included (true) or not (false).
	 */
	private IndicatorType TaxIncludedIndicator;
	/**
	 * A universally unique identifier for this request for tender line.
	 */
	private IdentifierType UUID;
	private List<DocumentReferenceRepresentation> DocumentReferences = new ArrayList<>();
	private List<ItemRepresentation> Items = new ArrayList<>();
	private ItemLocationQuantityRepresentation RequiredItemLocationQuantity;
	private PeriodRepresentation DeliveryPeriod;
	private PeriodRepresentation WarrantyValidityPeriod;
	private Request ForTenderLineSubRequestForTenderLine;

}
