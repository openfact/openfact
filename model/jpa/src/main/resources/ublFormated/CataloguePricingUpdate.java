package org.openfact.models.jpa.entities.ubl;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A document used to update information about prices in an existing Catalogue.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:19:49 a. m.
 */
public class CataloguePricingUpdate{

	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private IdentifierType CustomizationID;
	/**
	 * Describes the Catalogue Revision.
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
	 * The date, assigned by the seller, on which the Catalogue was revised.
	 */
	private DateType RevisionDate;
	/**
	 * The time, assigned by the seller, at which the Catalogue was revised.
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
	private List<CataloguePricingUpdateLine> CataloguePricingUpdateLines = new ArrayList<>();
	private CatalogueReference RelatedCatalogueReference;
	private Contract ReferencedContract;
	private CustomerParty ContractorCustomerParty;
	private Language DefaultLanguage;
	private Party ProviderParty;
	private Party ReceiverParty;
	private Period ValidityPeriod;
	private List<Signature> Signatures = new ArrayList<>();
	private SupplierParty SellerSupplierParty;
	private List<TradingTerms> TradingTermses = new ArrayList<>();

}
