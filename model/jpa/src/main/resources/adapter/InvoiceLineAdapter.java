package org.openfact.models.jpa.entities.ubl;
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
	private TextType accountingCost; 
	/**
	 * The buyer's accounting cost centre for this invoice line, expressed as a code.
	 */
	private CodeType accountingCostCode; 
	/**
	 * An indicator that this invoice line is free of charge (true) or not (false).
	 * The default is false.
	 */
	private IndicatorType freeOfChargeIndicator; 
	/**
	 * An identifier for this invoice line.
	 */
	private IdentifierType ID; 
	/**
	 * The quantity (of items) on this invoice line.
	 */
	private QuantityType invoicedQuantity; 
	/**
	 * The total amount for this invoice line, including allowance charges but net of
	 * taxes.
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
	 * The date of this invoice line, used to indicate the point at which tax becomes
	 * applicable.
	 */
	private DateType taxPointDate; 
	/**
	 * A universally unique identifier for this invoice line.
	 */
	private IdentifierType UUID; 
	private List<AllowanceChargeAdapter> allowanceCharges = new ArrayList<>(); 
	private List<BillingReferenceAdapter> billingReferences = new ArrayList<>(); 
	private List<DeliveryAdapter> deliveries = new ArrayList<>(); 
	private List<DeliveryTermsAdapter> deliveriesTerms = new ArrayList<>(); 
	private List<DocumentReferenceAdapter> documentReferences = new ArrayList<>(); 
	private List<ItemAdapter> items = new ArrayList<>(); 
	private LineReferenceAdapter despatchLineReference; 
	private LineReferenceAdapter receiptLineReference; 
	private List<OrderLineReferenceAdapter> orderLineReferences = new ArrayList<>(); 
	private PartyAdapter originatorParty; 
	private List<PaymentTermsAdapter> paymentTermses = new ArrayList<>(); 
	private PeriodAdapter invoicePeriod; 
	private InvoiceLineAdapter subInvoiceLine; 
	private List<PriceAdapter> prices = new ArrayList<>(); 
	private PriceExtensionAdapter itemPriceExtension; 
	private List<PricingReferenceAdapter> pricingReferences = new ArrayList<>(); 
	private List<TaxTotalAdapter> withholdingTaxTotal = new ArrayList<>(); 
	private List<TaxTotalAdapter> taxTotals = new ArrayList<>(); 

}
