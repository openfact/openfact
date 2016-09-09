package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A document that describes items, prices, and price validity.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:19:17 a. m.
 */
public class Catalogue{

	/**
	 * A code signifying whether the transaction is a replacement or an update.
	 */
	private CodeType ActionCode;
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
	private LocalDate IssueDate;
	/**
	 * The time, assigned by the sender, at which this document was issued.
	 */
	private LocalTime IssueTime;
	/**
	 * The number of CatalogueLines in the document.
	 */
	private BigDecimal LineCountNumeric;
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
	 * An identifier for the previous version of the Catalogue that is superseded by
	 * this version.
	 */
	private IdentifierType PreviousVersionID;
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
	 * The date, assigned by the seller party, on which the information in the
	 * Catalogue was last revised.
	 */
	private LocalDate RevisionDate;
	/**
	 * The time, assigned by the Seller party, at which the information in the
	 * Catalogue was last revised.
	 */
	private LocalTime RevisionTime;
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
	 * An identifier for the current version of the Catalogue.
	 */
	private IdentifierType VersionID;
	private List<CatalogueLine> CatalogueLines = new ArrayList<>();
	private CatalogueReference SourceCatalogueReference;
	private Contract ReferencedContract;
	private CustomerParty ContractorCustomerParty;
	private List<DocumentReference> DocumentReferences = new ArrayList<>();
	private Party ProviderParty;
	private Party ReceiverParty;
	private Period ValidityPeriod;
	private List<Signature> Signatures = new ArrayList<>();
	private SupplierParty SellerSupplierParty;
	private List<TradingTerms> TradingTermses = new ArrayList<>();

}
