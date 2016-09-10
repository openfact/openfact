package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.IdentifierType;
import org.openfact.models.ubl.type.NameType;
import org.openfact.models.ubl.type.TextType;

/**
 * A document used to update information (e.g., technical descriptions and
 * properties) about Items in an existing Catalogue.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:19:36 a. m.
 */
public class CatalogueItemSpecificationUpdateEntity {

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
    private LocalDate issueDate;
    /**
     * The time, assigned by the sender, at which this document was issued.
     */
    private LocalTime issueTime;
    /**
     * The number of catalogueItemSpecificationUpdateLines in this document.
     */
    private BigDecimal lineCountNumeric;
    /**
     * Text, assigned by the sender, that identifies this document to business
     * users.
     */
    private NameType name;
    /**
     * Free-form text pertinent to this document, conveying information that is
     * not contained explicitly in other structures.
     */
    private TextType note;
    /**
     * Identifies an instance of executing a profile, to associate all
     * transactions in a collaboration.
     */
    private IdentifierType profileExecutionID;
    /**
     * Identifies a user-defined profile of the subset of UBL being used.
     */
    private IdentifierType profileID;
    /**
     * The date, assigned by the seller, on which the CatalogueEntity was
     * revised.
     */
    private LocalDate revisionDate;
    /**
     * The time, assigned by the seller, at which the CatalogueEntity was
     * revised.
     */
    private LocalTime revisionTime;
    /**
     * Identifies the earliest version of the UBL 2 schema for this document
     * type that defines all of the elements that might be encountered in the
     * current instance.
     */
    private IdentifierType UBLVersionID;
    /**
     * A universally unique identifier for an instance of this document.
     */
    private IdentifierType UUID;
    /**
     * Identifies the current version of the Catalogue.
     */
    private IdentifierType versionID;
    private List<CatalogueItemSpecificationUpdateLineEntity> catalogueItemSpecificationUpdateLines = new ArrayList<>();
    private CatalogueReferenceEntity relatedCatalogueReference;
    private ContractEntity referencedContract;
    private CustomerPartyEntity contractorCustomerParty;
    private LanguageEntity defaultLanguage;
    private PartyEntity providerParty;
    private PartyEntity receiverParty;
    private PeriodEntity validityPeriod;
    private List<SignatureEntity> signatures = new ArrayList<>();
    private SupplierPartyEntity sellerSupplierParty;
    private List<TradingTermsEntity> tradingTermses = new ArrayList<>();

}
