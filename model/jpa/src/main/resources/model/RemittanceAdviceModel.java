package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A document that specifies details of an actual payment.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:21:17 a. m.
 */
public class RemittanceAdviceModel{

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
	 * An internal reference to the order for payment by the invoicing party. This may
	 * have been requested of the payer by the payee to accompany the payer's
	 * remittance.
	 */
	private TextType invoicingPartyReference; 
	/**
	 * The date, assigned by the sender, on which this document was issued.
	 */
	private LocalDate issueDate; 
	/**
	 * The time, assigned by the sender, at which this document was issued.
	 */
	private LocalTime issueTime; 
	/**
	 * The number of remittanceAdviceLines in the document.
	 */
	private BigDecimal lineCountNumeric; 
	/**
	 * Free-form text pertinent to this document, conveying information that is not
	 * contained explicitly in other structures.
	 */
	private TextType note; 
	/**
	 * An internal reference to the payer's order for payment.
	 */
	private TextType payerReference; 
	/**
	 * An internal reference to the order for payment from the payer to the payer's
	 * bank.
	 */
	private TextType paymentOrderReference; 
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
	 * The totals of all credit amounts for the RemittanceAdvice.
	 */
	private BigDecimal totalCreditAmount; 
	/**
	 * The totals of all debit amounts for the RemittanceAdvice.
	 */
	private BigDecimal totalDebitAmount; 
	/**
	 * The total payable amount for the RemittanceAdviceModel (must be positive).
	 */
	private BigDecimal totalPaymentAmount; 
	/**
	 * Identifies the earliest version of the UBL 2 schema for this document type that
	 * defines all of the elements that might be encountered in the current instance.
	 */
	private IdentifierType UBLVersionID; 
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private IdentifierType UUID; 
	private List<BillingReferenceModel> billingReferences = new ArrayList<>(); 
	private CustomerPartyModel accountingCustomerParty; 
	private DocumentReferenceModel additionalDocumentReference; 
	private PartyModel payeeParty; 
	private List<PaymentMeansModel> paymentMeanses = new ArrayList<>(); 
	private PeriodModel invoicePeriod; 
	private List<RemittanceAdviceLineModel> remittanceAdviceLines = new ArrayList<>(); 
	private List<SignatureModel> signatures = new ArrayList<>(); 
	private SupplierPartyModel accountingSupplierParty; 
	private List<TaxTotalModel> taxTotals = new ArrayList<>(); 

}
