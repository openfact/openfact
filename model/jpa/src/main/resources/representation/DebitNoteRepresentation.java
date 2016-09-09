package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A document used to specify debts incurred by the Debtor.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:20:27 a. m.
 */
public class DebitNoteRepresentation{

	/**
	 * The Buyer's accounting code, applied to the CreditNoteRepresentation as a whole, expressed
	 * as text.
	 */
	private TextType accountingCost; 
	/**
	 * The Buyer's accounting code, applied to the CreditNoteRepresentation as a whole.
	 */
	private CodeType accountingCostCode; 
	/**
	 * Indicates whether this document is a copy (true) or not (false).
	 */
	private boolean copyIndicator; 
	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private IdentifierType customizationID; 
	/**
	 * A code signifying the default currency for this document.
	 */
	private CurrencyCodeType codeTypeDocumentCurrencyCode; 
	/**
	 * An identifier for this document, assigned by the sender.
	 */
	private IdentifierType ID; 
	/**
	 * The date, assigned by the sender, on which this document was issued.
	 */
	private LocalDate issueDate; 
	/**
	 * The time, assigned by the sender, at which this document was issued.
	 */
	private LocalTime issueTime; 
	/**
	 * The number of DebitNoteRepresentation Lines in this document.
	 */
	private BigDecimal lineCountNumeric; 
	/**
	 * Free-form text pertinent to this document, conveying information that is not
	 * contained explicitly in other structures.
	 */
	private TextType note; 
	/**
	 * A code signifying the alternative currency used for payment in the DebitNote.
	 */
	private CurrencyCodeType codeTypePaymentAlternativeCurrencyCode; 
	/**
	 * A code signifying the currency used for payment in the DebitNote.
	 */
	private CurrencyCodeType codeTypePaymentCurrencyCode; 
	/**
	 * A code signifying the currency used for prices in the DebitNote.
	 */
	private CurrencyCodeType codeTypePricingCurrencyCode; 
	/**
	 * Identifies an instance of executing a profile, to associate all transactions in
	 * a collaboration.
	 */
	private IdentifierType profileExecutionID; 
	/**
	 * Identifies a user-defined profile of the customization of UBL being used.
	 */
	private IdentifierType profileID; 
	/**
	 * A code signifying the currency used for tax amounts in the DebitNote.
	 */
	private CurrencyCodeType codeTypeTaxCurrencyCode; 
	/**
	 * The date of the DebitNote, used to indicate the point at which tax becomes
	 * applicable.
	 */
	private LocalDate taxPointDate; 
	/**
	 * Identifies the earliest version of the UBL 2 schema for this document type that
	 * defines all of the elements that might be encountered in the current instance.
	 */
	private IdentifierType UBLVersionID; 
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private IdentifierType UUID; 
	private List<AllowanceChargeRepresentation> allowanceCharges = new ArrayList<>(); 
	private List<BillingReferenceRepresentation> billingReferences = new ArrayList<>(); 
	private CustomerPartyRepresentation accountingCustomerParty; 
	private CustomerPartyRepresentation buyerCustomerParty; 
	private List<DebitNoteRepresentation> lineDebitNoteLines = new ArrayList<>(); 
	private List<DeliveryRepresentation> deliveries = new ArrayList<>(); 
	private List<DeliveryTermsRepresentation> deliveriesTerms = new ArrayList<>(); 
	private DocumentReferenceRepresentation additionalDocumentReference; 
	private DocumentReferenceRepresentation contractDocumentReference; 
	private DocumentReferenceRepresentation despatchDocumentReference; 
	private DocumentReferenceRepresentation receiptDocumentReference; 
	private DocumentReferenceRepresentation statementDocumentReference; 
	private ExchangeRateRepresentation paymentAlternativeExchangeRate; 
	private ExchangeRateRepresentation paymentExchangeRate; 
	private ExchangeRateRepresentation pricingExchangeRate; 
	private ExchangeRateRepresentation taxExchangeRate; 
	private MonetaryTotalRepresentation requestedMonetaryTotal; 
	private List<OrderReferenceRepresentation> orderReferences = new ArrayList<>(); 
	private PartyRepresentation taxRepresentativeParty; 
	private PartyRepresentation payeeParty; 
	private PaymentRepresentation prepaidPayment; 
	private List<PaymentMeansRepresentation> paymentMeanses = new ArrayList<>(); 
	private List<PaymentTermsRepresentation> paymentTermses = new ArrayList<>(); 
	private PeriodRepresentation invoicePeriod; 
	private ResponseRepresentation discrepancyResponse; 
	private List<SignatureRepresentation> signatures = new ArrayList<>(); 
	private SupplierPartyRepresentation accountingSupplierParty; 
	private SupplierPartyRepresentation sellerSupplierParty; 
	private List<TaxTotalRepresentation> taxTotals = new ArrayList<>(); 

}
