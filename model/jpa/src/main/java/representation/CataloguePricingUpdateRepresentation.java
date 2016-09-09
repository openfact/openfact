package representation;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A document used to update information about prices in an existing Catalogue.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:19:49 a. m.
 */
public class CataloguePricingUpdateRepresentation{

	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private IdentifierType CustomizationID;
	/**
	 * Describes the CatalogueRepresentation Revision.
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
	 * The number of lines in the document.
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
	 * Identifies an instance of executing a profile, to associate all transactions in
	 * a collaboration.
	 */
	private IdentifierType ProfileExecutionID;
	/**
	 * Identifies a user-defined profile of the subset of UBL being used.
	 */
	private IdentifierType ProfileID;
	/**
	 * The date, assigned by the seller, on which the CatalogueRepresentation was revised.
	 */
	private DateType RevisionDate;
	/**
	 * The time, assigned by the seller, at which the CatalogueRepresentation was revised.
	 */
	private TimeType RevisionTime;
	/**
	 * Identifies the earliest version of the UBL 2 schema for this document type that
	 * defines all of the elements that might be encountered in the current instance.
	 */
	private IdentifierType UBLVersionID;
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private IdentifierType UUID;
	/**
	 * Indicates the current version of the catalogue.
	 */
	private IdentifierType VersionID;
	private List<CataloguePricingUpdateLineRepresentation> CataloguePricingUpdateLines = new ArrayList<>();
	private CatalogueReferenceRepresentation RelatedCatalogueReference;
	private ContractRepresentation ReferencedContract;
	private CustomerPartyRepresentation ContractorCustomerParty;
	private LanguageRepresentation DefaultLanguage;
	private PartyRepresentation ProviderParty;
	private PartyRepresentation ReceiverParty;
	private PeriodRepresentation ValidityPeriod;
	private List<SignatureRepresentation> Signatures = new ArrayList<>();
	private SupplierPartyRepresentation SellerSupplierParty;
	private List<TradingTermsRepresentation> TradingTermses = new ArrayList<>();

}
