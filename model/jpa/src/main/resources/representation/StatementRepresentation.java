package org.openfact.models.jpa.entities.ubl;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A document used to report the status of orders, billing, and payment. This
 * document is a statement of account, not a summary invoice.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:21:25 a. m.
 */
public class StatementRepresentation{

	/**
	 * Indicates whether this document is a copy (true) or not (false).
	 */
	private IndicatorType copyIndicator; 
	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private IdentifierType customizationID; 
	/**
	 * The default currency for the Statement.
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
	 * The number of statementLines in the Statement.
	 */
	private NumericType lineCountNumeric; 
	/**
	 * Free-form text pertinent to this document, conveying information that is not
	 * contained explicitly in other structures.
	 */
	private TextType note; 
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
	 * A code signifying the type of the Statement.
	 */
	private CodeType statementTypeCode; 
	/**
	 * The total amount for the Statement.
	 */
	private AmountType totalBalanceAmount; 
	/**
	 * The total of all credit amounts for the Statement.
	 */
	private AmountType totalCreditAmount; 
	/**
	 * The total of all debit amounts for the Statement.
	 */
	private AmountType totalDebitAmount; 
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
	private CustomerPartyRepresentation accountingCustomerParty; 
	private CustomerPartyRepresentation originatorCustomerParty; 
	private CustomerPartyRepresentation buyerCustomerParty; 
	private DocumentReferenceRepresentation additionalDocumentReference; 
	private PartyRepresentation payeeParty; 
	private List<PaymentMeansRepresentation> paymentMeanses = new ArrayList<>(); 
	private List<PaymentTermsRepresentation> paymentTermses = new ArrayList<>(); 
	private PeriodRepresentation statementPeriod; 
	private List<SignatureRepresentation> signatures = new ArrayList<>(); 
	private List<StatementLineRepresentation> statementLines = new ArrayList<>(); 
	private SupplierPartyRepresentation sellerSupplierParty; 
	private SupplierPartyRepresentation accountingSupplierParty; 
	private List<TaxTotalRepresentation> taxTotals = new ArrayList<>(); 

}
