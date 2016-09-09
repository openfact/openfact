package representation;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define a line in a CreditNoteRepresentation or SelfBilledCreditNote.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:14 a. m.
 */
public class CreditNoteLineRepresentation{

	/**
	 * The buyer's accounting cost centre for this credit note line, expressed as text.
	 */
	private TextType AccountingCost;
	/**
	 * The buyer's accounting cost centre for this credit note line, expressed as a
	 * code.
	 */
	private CodeType AccountingCostCode;
	/**
	 * The quantity of items credited in this credit note line.
	 */
	private QuantityType CreditedQuantity;
	/**
	 * An indicator that this credit note line is free of charge (true) or not (false).
	 * The default is false.
	 */
	private IndicatorType FreeOfChargeIndicator;
	/**
	 * An identifier for this credit note line.
	 */
	private IdentifierType ID;
	/**
	 * The total amount for this credit note line, including allowance charges but
	 * exclusive of taxes.
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
	 * The date of this credit note line, used to indicate the point at which tax
	 * becomes applicable.
	 */
	private DateType TaxPointDate;
	/**
	 * A universally unique identifier for this credit note line.
	 */
	private IdentifierType UUID;
	private List<AllowanceChargeRepresentation> AllowanceCharges = new ArrayList<>();
	private List<BillingReferenceRepresentation> BillingReferences = new ArrayList<>();
	private CreditNoteLineRepresentation SubCreditNoteLine;
	private List<DeliveryRepresentation> Deliveries = new ArrayList<>();
	private List<DeliveryTermsRepresentation> DeliveriesTerms = new ArrayList<>();
	private List<DocumentReferenceRepresentation> DocumentReferences = new ArrayList<>();
	private List<ItemRepresentation> Items = new ArrayList<>();
	private LineReferenceRepresentation ReceiptLineReference;
	private LineReferenceRepresentation DespatchLineReference;
	private List<OrderLineReferenceRepresentation> OrderLineReferences = new ArrayList<>();
	private PartyRepresentation OriginatorParty;
	private List<PaymentTermsRepresentation> PaymentTermses = new ArrayList<>();
	private PeriodRepresentation InvoicePeriod;
	private List<PriceRepresentation> Prices = new ArrayList<>();
	private PriceExtensionRepresentation ItemPriceExtension;
	private List<PricingReferenceRepresentation> PricingReferences = new ArrayList<>();
	private ResponseRepresentation DiscrepancyResponse;
	private List<TaxTotalRepresentation> TaxTotals = new ArrayList<>();

}
