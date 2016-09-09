package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A document stating the charges incurred for a logistics service.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:20:40 a. m.
 */
public class FreightInvoice{

	/**
	 * The buyer's accounting cost centre, applied to the FreightInvoice as a whole,
	 * expressed as text.
	 */
	private TextType AccountingCost;
	/**
	 * The buyer's accounting code, applied to the FreightInvoice as a whole.
	 */
	private CodeType AccountingCostCode;
	/**
	 * Indicates whether this document is a copy (true) or not (false).
	 */
	private boolean CopyIndicator;
	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private IdentifierType CustomizationID;
	/**
	 * A code signifying the default currency for this document.
	 */
	private CurrencyCodeType CodeTypeDocumentCurrencyCode;
	/**
	 * An identifier for this document, assigned by the sender.
	 */
	private IdentifierType ID;
	/**
	 * A code signifying the type of the FreightInvoice.
	 */
	private CodeType InvoiceTypeCode;
	/**
	 * The date, assigned by the sender, on which this document was issued.
	 */
	private LocalDate IssueDate;
	/**
	 * The time, assigned by the sender, at which this document was issued.
	 */
	private LocalTime IssueTime;
	/**
	 * The number of InvoiceLines in the document.
	 */
	private BigDecimal LineCountNumeric;
	/**
	 * Free-form text pertinent to this document, conveying information that is not
	 * contained explicitly in other structures.
	 */
	private TextType Note;
	/**
	 * A code signifying the alternative currency used for payment in the Freight
	 * Invoice.
	 */
	private CurrencyCodeType CodeTypePaymentAlternativeCurrencyCode;
	/**
	 * A code signifying the currency used for payment in the FreightInvoice.
	 */
	private CurrencyCodeType CodeTypePaymentCurrencyCode;
	/**
	 * A code signifying the currency used for prices in the FreightInvoice.
	 */
	private CurrencyCodeType CodeTypePricingCurrencyCode;
	/**
	 * Identifies an instance of executing a profile, to associate all transactions in
	 * a collaboration.
	 */
	private IdentifierType ProfileExecutionID;
	/**
	 * Identifies a user-defined profile of the customization of UBL being used.
	 */
	private IdentifierType ProfileID;
	/**
	 * A code signifying the currency used for tax amounts in the FreightInvoice.
	 */
	private CurrencyCodeType CodeTypeTaxCurrencyCode;
	/**
	 * The date of the FreightInvoice, used to indicate the point at which tax
	 * becomes applicable.
	 */
	private LocalDate TaxPointDate;
	/**
	 * Identifies the earliest version of the UBL 2 schema for this document type that
	 * defines all of the elements that might be encountered in the current instance.
	 */
	private IdentifierType UBLVersionID;
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private IdentifierType UUID;
	private List<AllowanceCharge> AllowanceCharges = new ArrayList<>();
	private List<BillingReference> BillingReferences = new ArrayList<>();
	private CustomerParty AccountingCustomerParty;
	private DocumentReference DespatchDocumentReference;
	private DocumentReference ReceiptDocumentReference;
	private DocumentReference OriginatorDocumentReference;
	private DocumentReference ContractDocumentReference;
	private DocumentReference AdditionalDocumentReference;
	private ExchangeRate PaymentAlternativeExchangeRate;
	private ExchangeRate PaymentExchangeRate;
	private ExchangeRate TaxExchangeRate;
	private ExchangeRate PricingExchangeRate;
	private List<InvoiceLine> InvoiceLines = new ArrayList<>();
	private MonetaryTotal LegalMonetaryTotal;
	private List<OrderReference> OrderReferences = new ArrayList<>();
	private Party TaxRepresentativeParty;
	private Party PayeeParty;
	private Payment PrepaidPayment;
	private List<PaymentMeans> PaymentMeanses = new ArrayList<>();
	private List<PaymentTerms> PaymentTermses = new ArrayList<>();
	private Period InvoicePeriod;
	private List<Shipment> Shipments = new ArrayList<>();
	private List<Signature> Signatures = new ArrayList<>();
	private SupplierParty AccountingSupplierParty;
	private List<TaxTotal> TaxTotals = new ArrayList<>();

}
