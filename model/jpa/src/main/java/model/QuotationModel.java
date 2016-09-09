package model;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A document used to quote for the provision of goods and services.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:21:10 a. m.
 */
public class QuotationModel{

	/**
	 * Indicates whether this document is a copy (true) or not (false).
	 */
	private IndicatorType CopyIndicator;
	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private IdentifierType CustomizationID;
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
	 * The number of QuotationLines in this document.
	 */
	private NumericType LineCountNumeric;
	/**
	 * Free-form text pertinent to this document, conveying information that is not
	 * contained explicitly in other structures.
	 */
	private TextType Note;
	/**
	 * A code signifying the currency used for all prices in the Quotation.
	 */
	private CurrencyCodeType CodeTypePricingCurrencyCode;
	/**
	 * Identifies an instance of executing a profile, to associate all transactions in
	 * a collaboration.
	 */
	private IdentifierType ProfileExecutionID;
	/**
	 * Identifies a user-defined profile of the subset of UBL being used.
	 */
	private IdentifierType ProfileID;
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
	private List<ContractModel> Contracts = new ArrayList<>();
	private CountryModel DestinationCountry;
	private CustomerPartyModel BuyerCustomerParty;
	private CustomerPartyModel OriginatorCustomerParty;
	private List<DeliveryModel> Deliveries = new ArrayList<>();
	private List<DeliveryTermsModel> DeliveriesTerms = new ArrayList<>();
	private DocumentReferenceModel AdditionalDocumentReference;
	private DocumentReferenceModel RequestForQuotationDocumentReference;
	private MonetaryTotalModel QuotedMonetaryTotal;
	private List<PaymentMeansModel> PaymentMeanses = new ArrayList<>();
	private PeriodModel ValidityPeriod;
	private List<QuotationLineModel> QuotationLines = new ArrayList<>();
	private List<SignatureModel> Signatures = new ArrayList<>();
	private SupplierPartyModel SellerSupplierParty;
	private List<TaxTotalModel> TaxTotals = new ArrayList<>();
	private List<TransactionConditionsModel> TransactionConditionses = new ArrayList<>();

}
