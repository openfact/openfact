package adapter;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define a line in a DebitNote.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:19 a. m.
 */
public class DebitNoteLineAdapter{

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
	private List<AllowanceChargeAdapter> AllowanceCharges = new ArrayList<>();
	private List<BillingReferenceAdapter> BillingReferences = new ArrayList<>();
	private DebitNoteAdapter LineSubDebitNoteLine;
	private List<DeliveryAdapter> Deliveries = new ArrayList<>();
	private List<DocumentReferenceAdapter> DocumentReferences = new ArrayList<>();
	private List<ItemAdapter> Items = new ArrayList<>();
	private LineReferenceAdapter DespatchLineReference;
	private LineReferenceAdapter ReceiptLineReference;
	private List<PriceAdapter> Prices = new ArrayList<>();
	private List<PricingReferenceAdapter> PricingReferences = new ArrayList<>();
	private ResponseAdapter DiscrepancyResponse;
	private List<TaxTotalAdapter> TaxTotals = new ArrayList<>();

}
