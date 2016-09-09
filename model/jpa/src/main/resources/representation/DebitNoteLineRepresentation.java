package representation;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define a line in a Debitnote.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:19 a. m.
 */
public class DebitnoteLineRepresentation{

	/**
	 * The buyer's accounting cost centre for this debit note line, expressed as text.
	 */
	private TextType accountingCost;
	/**
	 * The buyer's accounting cost centre for this debit note line, expressed as a
	 * code.
	 */
	private CodeType accountingCostCode;
	/**
	 * The quantity of items debited in this debit note line.
	 */
	private QuantityType debitedQuantity;
	/**
	 * An identifier for this debit note line.
	 */
	private IdentifierType ID;
	/**
	 * The total amount for this debit note line, including allowance charges but net
	 * of taxes.
	 */
	private AmountType lineExtensionAmount;
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private TextType note;
	/**
	 * A code signifying the business purpose for this payment.
	 */
	private CodeType paymentPurposeCode;
	/**
	 * The date of this debit note line, used to indicate the point at which tax
	 * becomes applicable.
	 */
	private DateType taxPointDate;
	/**
	 * A universally unique identifier for this debit note line.
	 */
	private IdentifierType UUID;
	private List<AllowanceChargeRepresentation> allowanceCharges = new ArrayList<>();
	private List<BillingReferenceRepresentation> billingReferences = new ArrayList<>();
	private DebitnoteRepresentation LineSubDebitnoteLine;
	private List<DeliveryRepresentation> deliveries = new ArrayList<>();
	private List<DocumentReferenceRepresentation> documentReferences = new ArrayList<>();
	private List<ItemRepresentation> items = new ArrayList<>();
	private LineReferenceRepresentation despatchLineReference;
	private LineReferenceRepresentation receiptLineReference;
	private List<PriceRepresentation> prices = new ArrayList<>();
	private List<PricingReferenceRepresentation> pricingReferences = new ArrayList<>();
	private ResponseRepresentation discrepancyResponse;
	private List<TaxTotalRepresentation> taxTotals = new ArrayList<>();

}
