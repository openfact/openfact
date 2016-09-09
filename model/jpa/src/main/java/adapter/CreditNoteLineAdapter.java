package adapter;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define a line in a CreditnoteAdapter or SelfBilledCreditnote.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:14 a. m.
 */
public class CreditnoteLineAdapter{

	/**
	 * The buyer's accounting cost centre for this credit note line, expressed as text.
	 */
	private TextType accountingCost;
	/**
	 * The buyer's accounting cost centre for this credit note line, expressed as a
	 * code.
	 */
	private CodeType accountingCostCode;
	/**
	 * The quantity of items credited in this credit note line.
	 */
	private QuantityType creditedQuantity;
	/**
	 * An indicator that this credit note line is free of charge (true) or not (false).
	 * The default is false.
	 */
	private IndicatorType freeOfChargeIndicator;
	/**
	 * An identifier for this credit note line.
	 */
	private IdentifierType ID;
	/**
	 * The total amount for this credit note line, including allowance charges but
	 * exclusive of taxes.
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
	 * The date of this credit note line, used to indicate the point at which tax
	 * becomes applicable.
	 */
	private DateType taxPointDate;
	/**
	 * A universally unique identifier for this credit note line.
	 */
	private IdentifierType UUID;
	private List<AllowanceChargeAdapter> allowanceCharges = new ArrayList<>();
	private List<BillingReferenceAdapter> billingReferences = new ArrayList<>();
	private CreditnoteLineAdapter SubCreditnoteLine;
	private List<DeliveryAdapter> deliveries = new ArrayList<>();
	private List<DeliveryTermsAdapter> deliveriesTerms = new ArrayList<>();
	private List<DocumentReferenceAdapter> documentReferences = new ArrayList<>();
	private List<ItemAdapter> items = new ArrayList<>();
	private LineReferenceAdapter receiptLineReference;
	private LineReferenceAdapter despatchLineReference;
	private List<OrderLineReferenceAdapter> orderLineReferences = new ArrayList<>();
	private PartyAdapter originatorParty;
	private List<PaymentTermsAdapter> paymentTermses = new ArrayList<>();
	private PeriodAdapter invoicePeriod;
	private List<PriceAdapter> prices = new ArrayList<>();
	private PriceExtensionAdapter itemPriceExtension;
	private List<PricingReferenceAdapter> pricingReferences = new ArrayList<>();
	private ResponseAdapter discrepancyResponse;
	private List<TaxTotalAdapter> taxTotals = new ArrayList<>();

}
