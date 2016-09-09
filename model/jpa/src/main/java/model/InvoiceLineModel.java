package model;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define a line in an Invoice.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:37 a. m.
 */
public class InvoiceLineModel{

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
	private List<AllowanceChargeModel> AllowanceCharges = new ArrayList<>();
	private List<BillingReferenceModel> BillingReferences = new ArrayList<>();
	private List<DeliveryModel> Deliveries = new ArrayList<>();
	private List<DeliveryTermsModel> DeliveriesTerms = new ArrayList<>();
	private List<DocumentReferenceModel> DocumentReferences = new ArrayList<>();
	private List<ItemModel> Items = new ArrayList<>();
	private LineReferenceModel DespatchLineReference;
	private LineReferenceModel ReceiptLineReference;
	private List<OrderLineReferenceModel> OrderLineReferences = new ArrayList<>();
	private PartyModel OriginatorParty;
	private List<PaymentTermsModel> PaymentTermses = new ArrayList<>();
	private PeriodModel InvoicePeriod;
	private InvoiceLineModel SubInvoiceLine;
	private List<PriceModel> Prices = new ArrayList<>();
	private PriceExtensionModel ItemPriceExtension;
	private List<PricingReferenceModel> PricingReferences = new ArrayList<>();
	private List<TaxTotalModel> WithholdingTaxTotal = new ArrayList<>();
	private List<TaxTotalModel> TaxTotals = new ArrayList<>();

}
