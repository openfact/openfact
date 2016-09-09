package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
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
public class StatementModel{

	/**
	 * Indicates whether this document is a copy (true) or not (false).
	 */
	private boolean copyIndicator; 
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
	private LocalDate issueDate; 
	/**
	 * The time, assigned by the sender, at which this document was issued.
	 */
	private LocalTime issueTime; 
	/**
	 * The number of statementLines in the Statement.
	 */
	private BigDecimal lineCountNumeric; 
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
	private BigDecimal totalBalanceAmount; 
	/**
	 * The total of all credit amounts for the Statement.
	 */
	private BigDecimal totalCreditAmount; 
	/**
	 * The total of all debit amounts for the Statement.
	 */
	private BigDecimal totalDebitAmount; 
	/**
	 * Identifies the earliest version of the UBL 2 schema for this document type that
	 * defines all of the elements that might be encountered in the current instance.
	 */
	private IdentifierType UBLVersionID; 
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private IdentifierType UUID; 
	private List<AllowanceChargeModel> allowanceCharges = new ArrayList<>(); 
	private CustomerPartyModel accountingCustomerParty; 
	private CustomerPartyModel originatorCustomerParty; 
	private CustomerPartyModel buyerCustomerParty; 
	private DocumentReferenceModel additionalDocumentReference; 
	private PartyModel payeeParty; 
	private List<PaymentMeansModel> paymentMeanses = new ArrayList<>(); 
	private List<PaymentTermsModel> paymentTermses = new ArrayList<>(); 
	private PeriodModel statementPeriod; 
	private List<SignatureModel> signatures = new ArrayList<>(); 
	private List<StatementLineModel> statementLines = new ArrayList<>(); 
	private SupplierPartyModel sellerSupplierParty; 
	private SupplierPartyModel accountingSupplierParty; 
	private List<TaxTotalModel> taxTotals = new ArrayList<>(); 

}
