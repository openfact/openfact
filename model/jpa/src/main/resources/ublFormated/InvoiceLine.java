package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define a line in an Invoice.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:37 a. m.
 */
public class InvoiceLine{

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
	private boolean FreeOfChargeIndicator;
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
	private BigDecimal LineExtensionAmount;
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
	private LocalDate TaxPointDate;
	/**
	 * A universally unique identifier for this invoice line.
	 */
	private IdentifierType UUID;
	private List<AllowanceCharge> AllowanceCharges = new ArrayList<>();
	private List<BillingReference> BillingReferences = new ArrayList<>();
	private List<Delivery> Deliveries = new ArrayList<>();
	private List<DeliveryTerms> DeliveriesTerms = new ArrayList<>();
	private List<DocumentReference> DocumentReferences = new ArrayList<>();
	private List<Item> Items = new ArrayList<>();
	private LineReference DespatchLineReference;
	private LineReference ReceiptLineReference;
	private List<OrderLineReference> OrderLineReferences = new ArrayList<>();
	private Party OriginatorParty;
	private List<PaymentTerms> PaymentTermses = new ArrayList<>();
	private Period InvoicePeriod;
	private InvoiceLine SubInvoiceLine;
	private List<Price> Prices = new ArrayList<>();
	private PriceExtension ItemPriceExtension;
	private List<PricingReference> PricingReferences = new ArrayList<>();
	private List<TaxTotal> WithholdingTaxTotal = new ArrayList<>();
	private List<TaxTotal> TaxTotals = new ArrayList<>();

}
