package representation;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define a line in an Invoice.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:37 a. m.
 */
public class InvoiceLineRepresentation{

	/**
	 * The buyer's accounting cost centre for this invoice line, expressed as text.
	 */
	private TextType AccountingCost;
	/**
	 * The buyer's accounting cost centre for this invoice line, expressed as a code.
	 */
	private CodeType AccountingCostCode;
	/**
	 * An indicator that this invoice line is free of charge (true) or not (false).
	 * The default is false.
	 */
	private IndicatorType FreeOfChargeIndicator;
	/**
	 * An identifier for this invoice line.
	 */
	private IdentifierType ID;
	/**
	 * The quantity (of items) on this invoice line.
	 */
	private QuantityType InvoicedQuantity;
	/**
	 * The total amount for this invoice line, including allowance charges but net of
	 * taxes.
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
	 * The date of this invoice line, used to indicate the point at which tax becomes
	 * applicable.
	 */
	private DateType TaxPointDate;
	/**
	 * A universally unique identifier for this invoice line.
	 */
	private IdentifierType UUID;
	private List<AllowanceChargeRepresentation> AllowanceCharges = new ArrayList<>();
	private List<BillingReferenceRepresentation> BillingReferences = new ArrayList<>();
	private List<DeliveryRepresentation> Deliveries = new ArrayList<>();
	private List<DeliveryTermsRepresentation> DeliveriesTerms = new ArrayList<>();
	private List<DocumentReferenceRepresentation> DocumentReferences = new ArrayList<>();
	private List<ItemRepresentation> Items = new ArrayList<>();
	private LineReferenceRepresentation DespatchLineReference;
	private LineReferenceRepresentation ReceiptLineReference;
	private List<OrderLineReferenceRepresentation> OrderLineReferences = new ArrayList<>();
	private PartyRepresentation OriginatorParty;
	private List<PaymentTermsRepresentation> PaymentTermses = new ArrayList<>();
	private PeriodRepresentation InvoicePeriod;
	private InvoiceLineRepresentation SubInvoiceLine;
	private List<PriceRepresentation> Prices = new ArrayList<>();
	private PriceExtensionRepresentation ItemPriceExtension;
	private List<PricingReferenceRepresentation> PricingReferences = new ArrayList<>();
	private List<TaxTotalRepresentation> WithholdingTaxTotal = new ArrayList<>();
	private List<TaxTotalRepresentation> TaxTotals = new ArrayList<>();

}
