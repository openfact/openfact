package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;
import org.openfact.models.jpa.entities.ublType.*;

/**
 * A document used to specify debts incurred by the Debtor.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:20:27 a. m.
 */
public class DebitNoteEntity {

	/**
	 * The Buyer's accounting code, applied to the CreditNoteEntity as a whole,
	 * expressed as text.
	 */
	private TextType accountingCost;
	/**
	 * The Buyer's accounting code, applied to the CreditNoteEntity as a whole.
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
	 * The number of DebitNoteEntity Lines in this document.
	 */
	private BigDecimal lineCountNumeric;
	/**
	 * Free-form text pertinent to this document, conveying information that is
	 * not contained explicitly in other structures.
	 */
	private TextType note;
	/**
	 * A code signifying the alternative currency used for payment in the
	 * DebitNote.
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
	 * Identifies an instance of executing a profile, to associate all
	 * transactions in a collaboration.
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
	 * The date of the DebitNote, used to indicate the point at which tax
	 * becomes applicable.
	 */
	private LocalDate taxPointDate;
	/**
	 * Identifies the earliest version of the UBL 2 schema for this document
	 * type that defines all of the elements that might be encountered in the
	 * current instance.
	 */
	private IdentifierType UBLVersionID;
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private IdentifierType UUID;
	private List<AllowanceChargeEntity> allowanceCharges = new ArrayList<>();
	private List<BillingReferenceEntity> billingReferences = new ArrayList<>();
	private CustomerPartyEntity accountingCustomerParty;
	private CustomerPartyEntity buyerCustomerParty;
	private List<DebitNoteEntity> lineDebitNoteLines = new ArrayList<>();
	private List<DeliveryEntity> deliveries = new ArrayList<>();
	private List<DeliveryTermsEntity> deliveriesTerms = new ArrayList<>();
	private DocumentReferenceEntity additionalDocumentReference;
	private DocumentReferenceEntity contractDocumentReference;
	private DocumentReferenceEntity despatchDocumentReference;
	private DocumentReferenceEntity receiptDocumentReference;
	private DocumentReferenceEntity statementDocumentReference;
	private ExchangeRateEntity paymentAlternativeExchangeRate;
	private ExchangeRateEntity paymentExchangeRate;
	private ExchangeRateEntity pricingExchangeRate;
	private ExchangeRateEntity taxExchangeRate;
	private MonetaryTotalEntity requestedMonetaryTotal;
	private List<OrderReferenceEntity> orderReferences = new ArrayList<>();
	private PartyEntity taxRepresentativeParty;
	private PartyEntity payeeParty;
	private PaymentEntity prepaidPayment;
	private List<PaymentMeansEntity> paymentMeanses = new ArrayList<>();
	private List<PaymentTermsEntity> paymentTermses = new ArrayList<>();
	private PeriodEntity invoicePeriod;
	private ResponseEntity discrepancyResponse;
	private List<SignatureEntity> signatures = new ArrayList<>();
	private SupplierPartyEntity accountingSupplierParty;
	private SupplierPartyEntity sellerSupplierParty;
	private List<TaxTotalEntity> taxTotals = new ArrayList<>();

}
