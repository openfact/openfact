package org.openfact.models.jpa.entities.ubl;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A document that specifies details of an actual payment.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:21:17 a. m.
 */
public class RemittanceAdvice{

	/**
	 * Indicates whether this document is a copy (true) or not (false).
	 */
	private IndicatorType CopyIndicator;
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
	 * An internal reference to the order for payment by the invoicing party. This may
	 * have been requested of the payer by the payee to accompany the payer's
	 * remittance.
	 */
	private TextType InvoicingPartyReference;
	/**
	 * The date, assigned by the sender, on which this document was issued.
	 */
	private DateType IssueDate;
	/**
	 * The time, assigned by the sender, at which this document was issued.
	 */
	private TimeType IssueTime;
	/**
	 * The number of RemittanceAdviceLines in the document.
	 */
	private NumericType LineCountNumeric;
	/**
	 * Free-form text pertinent to this document, conveying information that is not
	 * contained explicitly in other structures.
	 */
	private TextType Note;
	/**
	 * An internal reference to the payer's order for payment.
	 */
	private TextType PayerReference;
	/**
	 * An internal reference to the order for payment from the payer to the payer's
	 * bank.
	 */
	private TextType PaymentOrderReference;
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
	 * The totals of all credit amounts for the RemittanceAdvice.
	 */
	private AmountType TotalCreditAmount;
	/**
	 * The totals of all debit amounts for the RemittanceAdvice.
	 */
	private AmountType TotalDebitAmount;
	/**
	 * The total payable amount for the RemittanceAdvice (must be positive).
	 */
	private AmountType TotalPaymentAmount;
	/**
	 * Identifies the earliest version of the UBL 2 schema for this document type that
	 * defines all of the elements that might be encountered in the current instance.
	 */
	private IdentifierType UBLVersionID;
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private IdentifierType UUID;
	private List<BillingReference> BillingReferences = new ArrayList<>();
	private CustomerParty AccountingCustomerParty;
	private DocumentReference AdditionalDocumentReference;
	private Party PayeeParty;
	private List<PaymentMeans> PaymentMeanses = new ArrayList<>();
	private Period InvoicePeriod;
	private List<RemittanceAdviceLine> RemittanceAdviceLines = new ArrayList<>();
	private List<Signature> Signatures = new ArrayList<>();
	private SupplierParty AccountingSupplierParty;
	private List<TaxTotal> TaxTotals = new ArrayList<>();

}
