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
	private IndicatorType copyIndicator;
	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private IdentifierType customizationID;
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
	 * The number of quotationLines in this document.
	 */
	private NumericType lineCountNumeric;
	/**
	 * Free-form text pertinent to this document, conveying information that is not
	 * contained explicitly in other structures.
	 */
	private TextType note;
	/**
	 * A code signifying the currency used for all prices in the Quotation.
	 */
	private CurrencyCodeType codeTypePricingCurrencyCode;
	/**
	 * Identifies an instance of executing a profile, to associate all transactions in
	 * a collaboration.
	 */
	private IdentifierType profileExecutionID;
	/**
	 * Identifies a user-defined profile of the subset of UBL being used.
	 */
	private IdentifierType profileID;
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
	private List<ContractModel> contracts = new ArrayList<>();
	private CountryModel destinationCountry;
	private CustomerPartyModel buyerCustomerParty;
	private CustomerPartyModel originatorCustomerParty;
	private List<DeliveryModel> deliveries = new ArrayList<>();
	private List<DeliveryTermsModel> deliveriesTerms = new ArrayList<>();
	private DocumentReferenceModel additionalDocumentReference;
	private DocumentReferenceModel requestForQuotationDocumentReference;
	private MonetaryTotalModel quotedMonetaryTotal;
	private List<PaymentMeansModel> paymentMeanses = new ArrayList<>();
	private PeriodModel validityPeriod;
	private List<QuotationLineModel> quotationLines = new ArrayList<>();
	private List<SignatureModel> signatures = new ArrayList<>();
	private SupplierPartyModel sellerSupplierParty;
	private List<TaxTotalModel> taxTotals = new ArrayList<>();
	private List<TransactionConditionsModel> transactionConditionses = new ArrayList<>();

}
