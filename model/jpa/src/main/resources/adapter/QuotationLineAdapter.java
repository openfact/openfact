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
	private AmountType lineExtensionAmount;
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private TextType note;
	/**
	 * The quantity of the item quoted.
	 */
	private quantityType quantity;
	/**
	 * An identifier for the line in the Request for QuotationAdapter to which this line is a
	 * response.
	 */
	private IdentifierType requestForQuotationLineID;
	/**
	 * The total tax amount for this quotation line.
	 */
	private AmountType totalTaxAmount;
	private List<DocumentReferenceAdapter> documentReferences = new ArrayList<>();
	private List<LineItemAdapter> lineItems = new ArrayList<>();
	private List<LineItemAdapter> sellerProposedSubstituteLineItem = new ArrayList<>();
	private List<LineItemAdapter> alternativeLineItem = new ArrayList<>();
	private LineReferenceAdapter requestLineReference;

}
