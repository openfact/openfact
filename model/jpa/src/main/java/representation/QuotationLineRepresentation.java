package representation;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define a line in a Quotation.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:17:16 a. m.
 */
public class QuotationLineRepresentation{

	/**
	 * An identifier for this quotation line.
	 */
	private IdentifierType ID;
	/**
	 * The total amount for this quotation line, including allowance charges but net
	 * of taxes.
	 */
	private AmountType LineExtensionAmount;
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private TextType Note;
	/**
	 * The quantity of the item quoted.
	 */
	private QuantityType Quantity;
	/**
	 * An identifier for the line in the Request for QuotationRepresentation to which this line is a
	 * response.
	 */
	private IdentifierType RequestForQuotationLineID;
	/**
	 * The total tax amount for this quotation line.
	 */
	private AmountType TotalTaxAmount;
	private List<DocumentReferenceRepresentation> DocumentReferences = new ArrayList<>();
	private List<LineItemRepresentation> LineItems = new ArrayList<>();
	private List<LineItemRepresentation> SellerProposedSubstituteLineItem = new ArrayList<>();
	private List<LineItemRepresentation> AlternativeLineItem = new ArrayList<>();
	private LineReferenceRepresentation RequestLineReference;

}
