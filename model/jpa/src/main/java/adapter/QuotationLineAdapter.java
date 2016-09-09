package adapter;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define a line in a Quotation.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:17:16 a. m.
 */
public class QuotationLineAdapter{

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
	 * An identifier for the line in the Request for QuotationAdapter to which this line is a
	 * response.
	 */
	private IdentifierType RequestForQuotationLineID;
	/**
	 * The total tax amount for this quotation line.
	 */
	private AmountType TotalTaxAmount;
	private List<DocumentReferenceAdapter> DocumentReferences = new ArrayList<>();
	private List<LineItemAdapter> LineItems = new ArrayList<>();
	private List<LineItemAdapter> SellerProposedSubstituteLineItem = new ArrayList<>();
	private List<LineItemAdapter> AlternativeLineItem = new ArrayList<>();
	private LineReferenceAdapter RequestLineReference;

}
