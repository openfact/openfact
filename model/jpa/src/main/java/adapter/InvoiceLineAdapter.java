package adapter;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define a line in an Invoice.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:37 a. m.
 */
public class InvoiceLineAdapter{

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
	private List<AllowanceChargeAdapter> AllowanceCharges = new ArrayList<>();
	private List<BillingReferenceAdapter> BillingReferences = new ArrayList<>();
	private List<DeliveryAdapter> Deliveries = new ArrayList<>();
	private List<DeliveryTermsAdapter> DeliveriesTerms = new ArrayList<>();
	private List<DocumentReferenceAdapter> DocumentReferences = new ArrayList<>();
	private List<ItemAdapter> Items = new ArrayList<>();
	private LineReferenceAdapter DespatchLineReference;
	private LineReferenceAdapter ReceiptLineReference;
	private List<OrderLineReferenceAdapter> OrderLineReferences = new ArrayList<>();
	private PartyAdapter OriginatorParty;
	private List<PaymentTermsAdapter> PaymentTermses = new ArrayList<>();
	private PeriodAdapter InvoicePeriod;
	private InvoiceLineAdapter SubInvoiceLine;
	private List<PriceAdapter> Prices = new ArrayList<>();
	private PriceExtensionAdapter ItemPriceExtension;
	private List<PricingReferenceAdapter> PricingReferences = new ArrayList<>();
	private List<TaxTotalAdapter> WithholdingTaxTotal = new ArrayList<>();
	private List<TaxTotalAdapter> TaxTotals = new ArrayList<>();

}
