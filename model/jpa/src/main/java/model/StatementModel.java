package model;
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
	private IndicatorType CopyIndicator;
	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private IdentifierType CustomizationID;
	/**
	 * The default currency for the Statement.
	 */
	private CurrencyCodeType CodeTypeDocumentCurrencyCode;
	/**
	 * An identifier for this document, assigned by the sender.
	 */
	private IdentifierType ID;
	/**
	 * The date, assigned by the sender, on which this document was issued.
	 */
	private DateType IssueDate;
	/**
	 * The time, assigned by the sender, at which this document was issued.
	 */
	private TimeType IssueTime;
	/**
	 * The number of StatementLines in the Statement.
	 */
	private NumericType LineCountNumeric;
	/**
	 * Free-form text pertinent to this document, conveying information that is not
	 * contained explicitly in other structures.
	 */
	private TextType Note;
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
	 * A code signifying the type of the Statement.
	 */
	private CodeType StatementTypeCode;
	/**
	 * The total amount for the Statement.
	 */
	private AmountType TotalBalanceAmount;
	/**
	 * The total of all credit amounts for the Statement.
	 */
	private AmountType TotalCreditAmount;
	/**
	 * The total of all debit amounts for the Statement.
	 */
	private AmountType TotalDebitAmount;
	/**
	 * Identifies the earliest version of the UBL 2 schema for this document type that
	 * defines all of the elements that might be encountered in the current instance.
	 */
	private IdentifierType UBLVersionID;
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private IdentifierType UUID;
	private List<AllowanceChargeModel> AllowanceCharges = new ArrayList<>();
	private CustomerPartyModel AccountingCustomerParty;
	private CustomerPartyModel OriginatorCustomerParty;
	private CustomerPartyModel BuyerCustomerParty;
	private DocumentReferenceModel AdditionalDocumentReference;
	private PartyModel PayeeParty;
	private List<PaymentMeansModel> PaymentMeanses = new ArrayList<>();
	private List<PaymentTermsModel> PaymentTermses = new ArrayList<>();
	private PeriodModel StatementPeriod;
	private List<SignatureModel> Signatures = new ArrayList<>();
	private List<StatementLineModel> StatementLines = new ArrayList<>();
	private SupplierPartyModel SellerSupplierParty;
	private SupplierPartyModel AccountingSupplierParty;
	private List<TaxTotalModel> TaxTotals = new ArrayList<>();

}
