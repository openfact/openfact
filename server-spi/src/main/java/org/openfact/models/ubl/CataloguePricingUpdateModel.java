package org.openfact.models.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A document used to update information about prices in an existing Catalogue.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:19:49 a. m.
 */
public class CataloguePricingUpdateModel {

    /**
     * Identifies a user-defined customization of UBL for a specific use.
     */
    private IdentifierModel customizationID;
    /**
     * Describes the CatalogueModel Revision.
     */
    private TextModel description;
    /**
     * An identifier for this document, assigned by the sender.
     */
    private IdentifierModel ID;
    /**
     * The date, assigned by the sender, on which this document was issued.
     */
    private LocalDate issueDate;
    /**
     * The time, assigned by the sender, at which this document was issued.
     */
    private LocalTime issueTime;
    /**
     * The number of lines in the document.
     */
    private BigDecimal lineCountNumeric;
    /**
     * Text, assigned by the sender, that identifies this document to business
     * users.
     */
    private NameModel name;
    /**
     * Free-form text pertinent to this document, conveying information that is
     * not contained explicitly in other structures.
     */
    private TextModel note;
    /**
     * Identifies an instance of executing a profile, to associate all
     * transactions in a collaboration.
     */
    private IdentifierModel profileExecutionID;
    /**
     * Identifies a user-defined profile of the subset of UBL being used.
     */
    private IdentifierModel profileID;
    /**
     * The date, assigned by the seller, on which the CatalogueModel was
     * revised.
     */
    private LocalDate revisionDate;
    /**
     * The time, assigned by the seller, at which the CatalogueModel was
     * revised.
     */
    private LocalTime revisionTime;
    /**
     * Identifies the earliest version of the UBL 2 schema for this document
     * type that defines all of the elements that might be encountered in the
     * current instance.
     */
    private IdentifierModel UBLVersionID;
    /**
     * A universally unique identifier for an instance of this document.
     */
    private IdentifierModel UUID;
    /**
     * Indicates the current version of the catalogue.
     */
    private IdentifierModel versionID;
    private List<CataloguePricingUpdateLineModel> cataloguePricingUpdateLines = new ArrayList<>();
    private CatalogueReferenceModel relatedCatalogueReference;
    private ContractModel referencedContract;
    private CustomerPartyModel contractorCustomerParty;
    private LanguageModel defaultLanguage;
    private PartyModel providerParty;
    private PartyModel receiverParty;
    private PeriodModel validityPeriod;
    private List<SignatureModel> signatures = new ArrayList<>();
    private SupplierPartyModel sellerSupplierParty;
    private List<TradingTermsModel> tradingTermses = new ArrayList<>();

}
