package org.openfact.models.jpa.entities.ubl;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A document used to quote for the provision of goods and services.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:21:10 a. m.
 */
public class QuotationEntity{

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
	private List<AllowanceChargeEntity> allowanceCharges = new ArrayList<>(); 
	private List<ContractEntity> contracts = new ArrayList<>(); 
	private CountryEntity destinationCountry; 
	private CustomerPartyEntity buyerCustomerParty; 
	private CustomerPartyEntity originatorCustomerParty; 
	private List<DeliveryEntity> deliveries = new ArrayList<>(); 
	private List<DeliveryTermsEntity> deliveriesTerms = new ArrayList<>(); 
	private DocumentReferenceEntity additionalDocumentReference; 
	private DocumentReferenceEntity requestForQuotationDocumentReference; 
	private MonetaryTotalEntity quotedMonetaryTotal; 
	private List<PaymentMeansEntity> paymentMeanses = new ArrayList<>(); 
	private PeriodEntity validityPeriod; 
	private List<QuotationLineEntity> quotationLines = new ArrayList<>(); 
	private List<SignatureEntity> signatures = new ArrayList<>(); 
	private SupplierPartyEntity sellerSupplierParty; 
	private List<TaxTotalEntity> taxTotals = new ArrayList<>(); 
	private List<TransactionConditionsEntity> transactionConditionses = new ArrayList<>(); 

}
