package representation;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A document used to request a Catalogue.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:19:53 a. m.
 */
public class CatalogueRequestRepresentation{

	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private IdentifierType CustomizationID;
	/**
	 * Textual description of the document instance.
	 */
	private TextType Description;
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
	 * Indicates a request for an update of the item specifications.
	 */
	private IndicatorType ItemUpdateRequestIndicator;
	/**
	 * The number of CatalogueLines in this document.
	 */
	private NumericType LineCountNumeric;
	/**
	 * Text, assigned by the sender, that identifies this document to business users.
	 */
	private NameType Name;
	/**
	 * Free-form text pertinent to this document, conveying information that is not
	 * contained explicitly in other structures.
	 */
	private TextType Note;
	/**
	 * Indicates a request for a pricing update.
	 */
	private IndicatorType PricingUpdateRequestIndicator;
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
	 * Identifies the earliest version of the UBL 2 schema for this document type that
	 * defines all of the elements that might be encountered in the current instance.
	 */
	private IdentifierType UBLVersionID;
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private IdentifierType UUID;
	private AddressRepresentation ApplicableTerritoryAddress;
	private CatalogueReferenceRepresentation RequestedCatalogueReference;
	private List<CatalogueRequestRepresentation> LineCatalogueRequestLines = new ArrayList<>();
	private ClassificationSchemeRepresentation RequestedClassificationScheme;
	private ContractRepresentation ReferencedContract;
	private CustomerPartyRepresentation ContractorCustomerParty;
	private List<DocumentReferenceRepresentation> DocumentReferences = new ArrayList<>();
	private LanguageRepresentation RequestedLanguage;
	private PartyRepresentation ReceiverParty;
	private PartyRepresentation ProviderParty;
	private PeriodRepresentation ValidityPeriod;
	private List<SignatureRepresentation> Signatures = new ArrayList<>();
	private SupplierPartyRepresentation SellerSupplierParty;
	private List<TradingTermsRepresentation> TradingTermses = new ArrayList<>();

}
