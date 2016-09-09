package representation;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define a line in a CreditnoteRepresentation or SelfBilledCreditnote.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:14 a. m.
 */
public class CreditnoteLineRepresentation{

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
	private List<AllowanceChargeRepresentation> allowanceCharges = new ArrayList<>();
	private List<BillingReferenceRepresentation> billingReferences = new ArrayList<>();
	private CreditnoteLineRepresentation SubCreditnoteLine;
	private List<DeliveryRepresentation> deliveries = new ArrayList<>();
	private List<DeliveryTermsRepresentation> deliveriesTerms = new ArrayList<>();
	private List<DocumentReferenceRepresentation> documentReferences = new ArrayList<>();
	private List<ItemRepresentation> items = new ArrayList<>();
	private LineReferenceRepresentation receiptLineReference;
	private LineReferenceRepresentation despatchLineReference;
	private List<OrderLineReferenceRepresentation> orderLineReferences = new ArrayList<>();
	private PartyRepresentation originatorParty;
	private List<PaymentTermsRepresentation> paymentTermses = new ArrayList<>();
	private PeriodRepresentation invoicePeriod;
	private List<PriceRepresentation> prices = new ArrayList<>();
	private PriceExtensionRepresentation itemPriceExtension;
	private List<PricingReferenceRepresentation> pricingReferences = new ArrayList<>();
	private ResponseRepresentation discrepancyResponse;
	private List<TaxTotalRepresentation> taxTotals = new ArrayList<>();

}
