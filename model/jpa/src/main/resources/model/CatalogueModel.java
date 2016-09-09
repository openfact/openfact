package model;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A document that describes items, prices, and price validity.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:19:17 a. m.
 */
public class CatalogueModel{

	/**
	 * A code signifying whether the transaction is a replacement or an update.
	 */
	private CodeType actionCode;
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
	 * The number of catalogueLines in the document.
	 */
	private NumericType lineCountNumeric;
	/**
	 * Text, assigned by the sender, that identifies this document to business users.
	 */
	private nameType name;
	/**
	 * Free-form text pertinent to this document, conveying information that is not
	 * contained explicitly in other structures.
	 */
	private TextType note;
	/**
	 * An identifier for the previous version of the CatalogueModel that is superseded by
	 * this version.
	 */
	private IdentifierType previousversionID;
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
	 * The date, assigned by the seller party, on which the information in the
	 * CatalogueModel was last revised.
	 */
	private DateType revisionDate;
	/**
	 * The time, assigned by the Seller party, at which the information in the
	 * CatalogueModel was last revised.
	 */
	private TimeType revisionTime;
	/**
	 * Identifies the earliest version of the UBL 2 schema for this document type that
	 * defines all of the elements that might be encountered in the current instance.
	 */
	private IdentifierType UBLversionID;
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private IdentifierType UUID;
	/**
	 * An identifier for the current version of the Catalogue.
	 */
	private IdentifierType versionID;
	private List<CatalogueLineModel> catalogueLines = new ArrayList<>();
	private CatalogueReferenceModel sourceCatalogueReference;
	private ContractModel referencedContract;
	private CustomerPartyModel contractorCustomerParty;
	private List<DocumentReferenceModel> documentReferences = new ArrayList<>();
	private PartyModel providerParty;
	private PartyModel receiverParty;
	private PeriodModel validityPeriod;
	private List<SignatureModel> signatures = new ArrayList<>();
	private SupplierPartyModel sellerSupplierParty;
	private List<TradingTermsModel> tradingTermses = new ArrayList<>();

}
