package model;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define a line in a CreditNoteModel or SelfBilledCreditNote.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:14 a. m.
 */
public class CreditNoteLineModel{

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
	private List<AllowanceChargeModel> AllowanceCharges = new ArrayList<>();
	private List<BillingReferenceModel> BillingReferences = new ArrayList<>();
	private CreditNoteLineModel SubCreditNoteLine;
	private List<DeliveryModel> Deliveries = new ArrayList<>();
	private List<DeliveryTermsModel> DeliveriesTerms = new ArrayList<>();
	private List<DocumentReferenceModel> DocumentReferences = new ArrayList<>();
	private List<ItemModel> Items = new ArrayList<>();
	private LineReferenceModel ReceiptLineReference;
	private LineReferenceModel DespatchLineReference;
	private List<OrderLineReferenceModel> OrderLineReferences = new ArrayList<>();
	private PartyModel OriginatorParty;
	private List<PaymentTermsModel> PaymentTermses = new ArrayList<>();
	private PeriodModel InvoicePeriod;
	private List<PriceModel> Prices = new ArrayList<>();
	private PriceExtensionModel ItemPriceExtension;
	private List<PricingReferenceModel> PricingReferences = new ArrayList<>();
	private ResponseModel DiscrepancyResponse;
	private List<TaxTotalModel> TaxTotals = new ArrayList<>();

}
