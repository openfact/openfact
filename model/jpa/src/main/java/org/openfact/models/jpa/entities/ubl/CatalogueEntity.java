package org.openfact.models.jpa.entities.ubl;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A document that describes items, prices, and price validity.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:19:17 a. m.
 */
public class CatalogueEntity{

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
	private NameType name; 
	/**
	 * Free-form text pertinent to this document, conveying information that is not
	 * contained explicitly in other structures.
	 */
	private TextType note; 
	/**
	 * An identifier for the previous version of the CatalogueEntity that is superseded by
	 * this version.
	 */
	private IdentifierType previousVersionID; 
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
	 * CatalogueEntity was last revised.
	 */
	private DateType revisionDate; 
	/**
	 * The time, assigned by the Seller party, at which the information in the
	 * CatalogueEntity was last revised.
	 */
	private TimeType revisionTime; 
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
	private IdentifierType versionID; 
	private List<CatalogueLineEntity> catalogueLines = new ArrayList<>(); 
	private CatalogueReferenceEntity sourceCatalogueReference; 
	private ContractEntity referencedContract; 
	private CustomerPartyEntity contractorCustomerParty; 
	private List<DocumentReferenceEntity> documentReferences = new ArrayList<>(); 
	private PartyEntity providerParty; 
	private PartyEntity receiverParty; 
	private PeriodEntity validityPeriod; 
	private List<SignatureEntity> signatures = new ArrayList<>(); 
	private SupplierPartyEntity sellerSupplierParty; 
	private List<TradingTermsEntity> tradingTermses = new ArrayList<>(); 

}
