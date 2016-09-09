package org.openfact.models.jpa.entities.ubl;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A document used to request a QuotationRepresentation for goods and services from a Seller.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:21:19 a. m.
 */
public class RequestForQuotationRepresentation{

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
	 * The number of requestForQuotationLines in this document.
	 */
	private NumericType lineCountNumeric; 
	/**
	 * Free-form text pertinent to this document, conveying information that is not
	 * contained explicitly in other structures.
	 */
	private TextType note; 
	/**
	 * The currency that the Seller should use to price the Quotation.
	 */
	private CurrencyCodeType codeTypePricingCurrencyCode; 
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
	 * The due date for submission of the Quotation.
	 */
	private DateType submissionDueDate; 
	/**
	 * Identifies the earliest version of the UBL 2 schema for this document type that
	 * defines all of the elements that might be encountered in the current instance.
	 */
	private IdentifierType UBLVersionID; 
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private IdentifierType UUID; 
	private List<ContractRepresentation> contracts = new ArrayList<>(); 
	private CountryRepresentation destinationCountry; 
	private CustomerPartyRepresentation buyerCustomerParty; 
	private CustomerPartyRepresentation originatorCustomerParty; 
	private List<DeliveryRepresentation> deliveries = new ArrayList<>(); 
	private List<DeliveryTermsRepresentation> deliveriesTerms = new ArrayList<>(); 
	private DocumentReferenceRepresentation additionalDocumentReference; 
	private DocumentReferenceRepresentation catalogueDocumentReference; 
	private PeriodRepresentation requestedValidityPeriod; 
	private List<RequestForQuotationLineRepresentation> requestForQuotationLines = new ArrayList<>(); 
	private List<SignatureRepresentation> signatures = new ArrayList<>(); 
	private SupplierPartyRepresentation sellerSupplierParty; 

}
