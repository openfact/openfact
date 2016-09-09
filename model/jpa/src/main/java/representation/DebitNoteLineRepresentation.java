package representation;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define a line in a DebitNote.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:19 a. m.
 */
public class DebitNoteLineRepresentation{

	/**
	 * The buyer's accounting cost centre for this debit note line, expressed as text.
	 */
	private TextType AccountingCost;
	/**
	 * The buyer's accounting cost centre for this debit note line, expressed as a
	 * code.
	 */
	private CodeType AccountingCostCode;
	/**
	 * The quantity of Items debited in this debit note line.
	 */
	private QuantityType DebitedQuantity;
	/**
	 * An identifier for this debit note line.
	 */
	private IdentifierType ID;
	/**
	 * The total amount for this debit note line, including allowance charges but net
	 * of taxes.
	 */
	private AmountType LineExtensionAmount;
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private TextType Note;
	/**
	 * A code signifying the business purpose for this payment.
	 */
	private CodeType PaymentPurposeCode;
	/**
	 * The date of this debit note line, used to indicate the point at which tax
	 * becomes applicable.
	 */
	private DateType TaxPointDate;
	/**
	 * A universally unique identifier for this debit note line.
	 */
	private IdentifierType UUID;
	private List<AllowanceChargeRepresentation> AllowanceCharges = new ArrayList<>();
	private List<BillingReferenceRepresentation> BillingReferences = new ArrayList<>();
	private DebitNoteRepresentation LineSubDebitNoteLine;
	private List<DeliveryRepresentation> Deliveries = new ArrayList<>();
	private List<DocumentReferenceRepresentation> DocumentReferences = new ArrayList<>();
	private List<ItemRepresentation> Items = new ArrayList<>();
	private LineReferenceRepresentation DespatchLineReference;
	private LineReferenceRepresentation ReceiptLineReference;
	private List<PriceRepresentation> Prices = new ArrayList<>();
	private List<PricingReferenceRepresentation> PricingReferences = new ArrayList<>();
	private ResponseRepresentation DiscrepancyResponse;
	private List<TaxTotalRepresentation> TaxTotals = new ArrayList<>();

}
