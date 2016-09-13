package org.openfact.models.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A document that describes items, prices, and price validity.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:19:17 a. m.
 */
public class CatalogueModel {

    /**
     * A code signifying whether the transaction is a replacement or an update.
     */
    private CodeModel actionCode;
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
     * The number of catalogueLines in the document.
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
     * An identifier for the previous version of the CatalogueModel that is
     * superseded by this version.
     */
    private IdentifierModel previousVersionID;
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
     * The date, assigned by the seller party, on which the information in the
     * CatalogueModel was last revised.
     */
    private LocalDate revisionDate;
    /**
     * The time, assigned by the Seller party, at which the information in the
     * CatalogueModel was last revised.
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
     * An identifier for the current version of the Catalogue.
     */
    private IdentifierModel versionID;
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