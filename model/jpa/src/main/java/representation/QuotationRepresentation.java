package representation;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A document used to quote for the provision of goods and services.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:21:10 a. m.
 */
public class QuotationRepresentation{

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
	private List<AllowanceChargeRepresentation> AllowanceCharges = new ArrayList<>();
	private List<ContractRepresentation> Contracts = new ArrayList<>();
	private CountryRepresentation DestinationCountry;
	private CustomerPartyRepresentation BuyerCustomerParty;
	private CustomerPartyRepresentation OriginatorCustomerParty;
	private List<DeliveryRepresentation> Deliveries = new ArrayList<>();
	private List<DeliveryTermsRepresentation> DeliveriesTerms = new ArrayList<>();
	private DocumentReferenceRepresentation AdditionalDocumentReference;
	private DocumentReferenceRepresentation RequestForQuotationDocumentReference;
	private MonetaryTotalRepresentation QuotedMonetaryTotal;
	private List<PaymentMeansRepresentation> PaymentMeanses = new ArrayList<>();
	private PeriodRepresentation ValidityPeriod;
	private List<QuotationLineRepresentation> QuotationLines = new ArrayList<>();
	private List<SignatureRepresentation> Signatures = new ArrayList<>();
	private SupplierPartyRepresentation SellerSupplierParty;
	private List<TaxTotalRepresentation> TaxTotals = new ArrayList<>();
	private List<TransactionConditionsRepresentation> TransactionConditionses = new ArrayList<>();

}
