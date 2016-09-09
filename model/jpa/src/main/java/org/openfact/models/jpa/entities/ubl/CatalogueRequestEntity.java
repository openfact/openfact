package org.openfact.models.jpa.entities.ubl;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A document used to request a Catalogue.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:19:53 a. m.
 */
public class CatalogueRequestEntity{

	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private IdentifierType customizationID; 
	/**
	 * Textual description of the document instance.
	 */
	private TextType description; 
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
	 * Indicates a request for an update of the item specifications.
	 */
	private IndicatorType itemUpdateRequestIndicator; 
	/**
	 * The number of CatalogueLines in this document.
	 */
	private NumericType lineCountNumeric; 
	/**
	 * Text, assigned by the sender, that identifies this document to business users.
	 */
	private NameType name; 
	/**
	 * Free-form text pertinent to this document, conveying information that is not
	 * contained explicitly in other structures.
	 */
	private TextType note; 
	/**
	 * Indicates a request for a pricing update.
	 */
	private IndicatorType pricingUpdateRequestIndicator; 
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
	 * Identifies the earliest version of the UBL 2 schema for this document type that
	 * defines all of the elements that might be encountered in the current instance.
	 */
	private IdentifierType UBLVersionID; 
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private IdentifierType UUID; 
	private AddressEntity applicableTerritoryAddress; 
	private CatalogueReferenceEntity requestedCatalogueReference; 
	private List<CatalogueRequestEntity> lineCatalogueRequestLines = new ArrayList<>(); 
	private ClassificationSchemeEntity requestedClassificationScheme; 
	private ContractEntity referencedContract; 
	private CustomerPartyEntity contractorCustomerParty; 
	private List<DocumentReferenceEntity> documentReferences = new ArrayList<>(); 
	private LanguageEntity requestedLanguage; 
	private PartyEntity receiverParty; 
	private PartyEntity providerParty; 
	private PeriodEntity validityPeriod; 
	private List<SignatureEntity> signatures = new ArrayList<>(); 
	private SupplierPartyEntity sellerSupplierParty; 
	private List<TradingTermsEntity> tradingTermses = new ArrayList<>(); 

}
