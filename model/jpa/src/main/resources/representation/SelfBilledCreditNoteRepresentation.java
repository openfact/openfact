package org.openfact.models.jpa.entities.ubl;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A credit note created by the debtor in a self billing arrangement with a
 * creditor; SelfBilledCreditNoteRepresentation replaces DebitNoteRepresentation in such arrangements.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:21:22 a. m.
 */
public class SelfBilledCreditNoteRepresentation{

	/**
	 * The buyer's accounting code, applied to the SelfBilledCreditNoteRepresentation as a whole,
	 * expressed as text.
	 */
	private TextType accountingCost; 
	/**
	 * The buyer's accounting code, applied to the SelfBilledCreditNoteRepresentation as a whole.
	 */
	private CodeType accountingCostCode; 
	/**
	 * Indicates whether this document is a copy (true) or not (false).
	 */
	private IndicatorType copyIndicator; 
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
	private DateType issueDate; 
	/**
	 * The time, assigned by the sender, at which this document was issued.
	 */
	private TimeType issueTime; 
	/**
	 * The number of SelfBilledCreditNoteRepresentation Lines in this document.
	 */
	private NumericType lineCountNumeric; 
	/**
	 * Free-form text pertinent to this document, conveying information that is not
	 * contained explicitly in other structures.
	 */
	private TextType note; 
	/**
	 * A code signifying the alternative currency used for payment in the Self Billed
	 * CreditNote.
	 */
	private CurrencyCodeType codeTypePaymentAlternativeCurrencyCode; 
	/**
	 * A code signifying the currency used for payment in the SelfBilledCreditNote.
	 */
	private CurrencyCodeType codeTypePaymentCurrencyCode; 
	/**
	 * A code signifying the currency used for prices in the SelfBilledCreditNote.
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
	 * A code signifying the currency used for tax amounts in the Self Billed Credit
	 * Note.
	 */
	private CurrencyCodeType codeTypeTaxCurrencyCode; 
	/**
	 * The date of the SelfBilledCreditNote, used to indicate the point at which
	 * tax becomes applicable.
	 */
	private DateType taxPointDate; 
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
	private List<CreditNoteLineRepresentation> creditNoteLines = new ArrayList<>(); 
	private CustomerPartyRepresentation accountingCustomerParty; 
	private CustomerPartyRepresentation buyerCustomerParty; 
	private List<DeliveryRepresentation> deliveries = new ArrayList<>(); 
	private List<DeliveryTermsRepresentation> deliveriesTerms = new ArrayList<>(); 
	private DocumentReferenceRepresentation contractDocumentReference; 
	private DocumentReferenceRepresentation originatorDocumentReference; 
	private DocumentReferenceRepresentation statementDocumentReference; 
	private DocumentReferenceRepresentation despatchDocumentReference; 
	private DocumentReferenceRepresentation receiptDocumentReference; 
	private DocumentReferenceRepresentation additionalDocumentReference; 
	private ExchangeRateRepresentation pricingExchangeRate; 
	private ExchangeRateRepresentation paymentAlternativeExchangeRate; 
	private ExchangeRateRepresentation paymentExchangeRate; 
	private ExchangeRateRepresentation taxExchangeRate; 
	private MonetaryTotalRepresentation legalMonetaryTotal; 
	private List<OrderReferenceRepresentation> orderReferences = new ArrayList<>(); 
	private PartyRepresentation taxRepresentativeParty; 
	private PartyRepresentation payeeParty; 
	private List<PaymentMeansRepresentation> paymentMeanses = new ArrayList<>(); 
	private List<PaymentTermsRepresentation> paymentTermses = new ArrayList<>(); 
	private PeriodRepresentation invoicePeriod; 
	private ResponseRepresentation discrepancyResponse; 
	private List<SignatureRepresentation> signatures = new ArrayList<>(); 
	private SupplierPartyRepresentation sellerSupplierParty; 
	private SupplierPartyRepresentation accountingSupplierParty; 
	private List<TaxTotalRepresentation> taxTotals = new ArrayList<>(); 

}
