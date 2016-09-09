package representation;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define a line in an order document (e.g., Order, OrderChange, or
 * OrderResponse) describing an item being ordered.
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:16:15 a. m.
 */
public class OrderLineRepresentation{

	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private TextType Note;
	/**
	 * A code signifying the substitution status of the item on this order line. The
	 * order line may indicate that the substitute is proposed by the buyer (in Order)
	 * or by the seller (in OrderResponse) or that a substitution has been made by
	 * the seller (in Order
	 */
	private SubstitutionStatusCodeType SubstitutionStatusCode;
	private List<DocumentReferenceRepresentation> DocumentReferences = new ArrayList<>();
	private List<LineItemRepresentation> SellerProposedSubstituteLineItem = new ArrayList<>();
	private List<LineItemRepresentation> SellerSubstitutedLineItem = new ArrayList<>();
	private List<LineItemRepresentation> LineItems = new ArrayList<>();
	private List<LineItemRepresentation> BuyerProposedSubstituteLineItem = new ArrayList<>();
	private LineReferenceRepresentation CatalogueLineReference;
	private LineReferenceRepresentation QuotationLineReference;
	private List<OrderLineReferenceRepresentation> OrderLineReferences = new ArrayList<>();

}
