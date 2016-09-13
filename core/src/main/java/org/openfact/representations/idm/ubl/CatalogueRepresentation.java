package org.openfact.representations.idm.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.NameRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A document that describes items, prices, and price validity.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:19:17 a. m.
 */
public class CatalogueRepresentation {

    /**
     * A code signifying whether the transaction is a replacement or an update.
     */
    private CodeRepresentation actionCode;
    /**
     * Identifies a user-defined customization of UBL for a specific use.
     */
    private IdentifierRepresentation customizationID;
    /**
     * Textual description of the document instance.
     */
    private TextRepresentation description;
    /**
     * An identifier for this document, assigned by the sender.
     */
    private IdentifierRepresentation ID;
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
    private NameRepresentation name;
    /**
     * Free-form text pertinent to this document, conveying information that is
     * not contained explicitly in other structures.
     */
    private TextRepresentation note;
    /**
     * An identifier for the previous version of the CatalogueRepresentation
     * that is superseded by this version.
     */
    private IdentifierRepresentation previousVersionID;
    /**
     * Identifies an instance of executing a profile, to associate all
     * transactions in a collaboration.
     */
    private IdentifierRepresentation profileExecutionID;
    /**
     * Identifies a user-defined profile of the customization of UBL being used.
     */
    private IdentifierRepresentation profileID;
    /**
     * The date, assigned by the seller party, on which the information in the
     * CatalogueRepresentation was last revised.
     */
    private LocalDate revisionDate;
    /**
     * The time, assigned by the Seller party, at which the information in the
     * CatalogueRepresentation was last revised.
     */
    private LocalTime revisionTime;
    /**
     * Identifies the earliest version of the UBL 2 schema for this document
     * type that defines all of the elements that might be encountered in the
     * current instance.
     */
    private IdentifierRepresentation UBLVersionID;
    /**
     * A universally unique identifier for an instance of this document.
     */
    private IdentifierRepresentation UUID;
    /**
     * An identifier for the current version of the Catalogue.
     */
    private IdentifierRepresentation versionID;
    private List<CatalogueLineRepresentation> catalogueLines = new ArrayList<>();
    private CatalogueReferenceRepresentation sourceCatalogueReference;
    private ContractRepresentation referencedContract;
    private CustomerPartyRepresentation contractorCustomerParty;
    private List<DocumentReferenceRepresentation> documentReferences = new ArrayList<>();
    private PartyRepresentation providerParty;
    private PartyRepresentation receiverParty;
    private PeriodRepresentation validityPeriod;
    private List<SignatureRepresentation> signatures = new ArrayList<>();
    private SupplierPartyRepresentation sellerSupplierParty;
    private List<TradingTermsRepresentation> tradingTermses = new ArrayList<>();

}
