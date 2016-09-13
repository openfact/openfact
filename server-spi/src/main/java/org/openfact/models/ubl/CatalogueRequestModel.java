package org.openfact.models.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A document used to request a Catalogue.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:19:53 a. m.
 */
public class CatalogueRequestModel {

    /**
     * Identifies a user-defined customization of UBL for a specific use.
     */
    private IdentifierModel customizationID;
    /**
     * Textual description of the document instance.
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
     * Indicates a request for an update of the item specifications.
     */
    private boolean itemUpdateRequestIndicator;
    /**
     * The number of CatalogueLines in this document.
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
     * Indicates a request for a pricing update.
     */
    private boolean pricingUpdateRequestIndicator;
    /**
     * Identifies an instance of executing a profile, to associate all
     * transactions in a collaboration.
     */
    private IdentifierModel profileExecutionID;
    /**
     * Identifies a user-defined profile of the customization of UBL being used.
     */
    private IdentifierModel profileID;
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
    private AddressModel applicableTerritoryAddress;
    private CatalogueReferenceModel requestedCatalogueReference;
    private List<CatalogueRequestModel> lineCatalogueRequestLines = new ArrayList<>();
    private ClassificationSchemeModel requestedClassificationScheme;
    private ContractModel referencedContract;
    private CustomerPartyModel contractorCustomerParty;
    private List<DocumentReferenceModel> documentReferences = new ArrayList<>();
    private LanguageModel requestedLanguage;
    private PartyModel receiverParty;
    private PartyModel providerParty;
    private PeriodModel validityPeriod;
    private List<SignatureModel> signatures = new ArrayList<>();
    private SupplierPartyModel sellerSupplierParty;
    private List<TradingTermsModel> tradingTermses = new ArrayList<>();

}
