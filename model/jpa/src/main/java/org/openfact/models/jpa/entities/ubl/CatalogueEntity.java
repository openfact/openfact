package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.DateType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.NameType;
import org.openfact.models.jpa.entities.ublType.NumericType;
import org.openfact.models.jpa.entities.ublType.TextType;
import org.openfact.models.jpa.entities.ublType.TimeType;

/**
 * A document that describes items, prices, and price validity.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:19:17 a. m.
 */
public class CatalogueEntity {

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
    private DateType IssueDate;
    /**
     * The time, assigned by the sender, at which this document was issued.
     */
    private TimeType IssueTime;
    /**
     * The number of CatalogueLines in the document.
     */
    private NumericType LineCountNumeric;
    /**
     * Text, assigned by the sender, that identifies this document to business
     * users.
     */
    private NameType Name;
    /**
     * Free-form text pertinent to this document, conveying information that is
     * not contained explicitly in other structures.
     */
    private TextType Note;
    /**
     * An identifier for the previous version of the CatalogueEntity that is
     * superseded by this version.
     */
    private IdentifierType PreviousVersionID;
    /**
     * Identifies an instance of executing a profile, to associate all
     * transactions in a collaboration.
     */
    private IdentifierType ProfileExecutionID;
    /**
     * Identifies a user-defined profile of the customization of UBL being used.
     */
    private IdentifierType ProfileID;
    /**
     * The date, assigned by the seller party, on which the information in the
     * CatalogueEntity was last revised.
     */
    private DateType RevisionDate;
    /**
     * The time, assigned by the Seller party, at which the information in the
     * CatalogueEntity was last revised.
     */
    private TimeType RevisionTime;
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
     * An identifier for the current version of the Catalogue.
     */
    private IdentifierType VersionID;
    private List<CatalogueLineEntity> CatalogueLines = new ArrayList<>();
    private CatalogueReferenceEntity SourceCatalogueReference;
    private ContractEntity ReferencedContract;
    private CustomerPartyEntity ContractorCustomerParty;
    private List<DocumentReferenceEntity> DocumentReferences = new ArrayList<>();
    private PartyEntity ProviderParty;
    private PartyEntity ReceiverParty;
    private PeriodEntity ValidityPeriod;
    private List<SignatureEntity> Signatures = new ArrayList<>();
    private SupplierPartyEntity SellerSupplierParty;
    private List<TradingTermsEntity> TradingTermses = new ArrayList<>();

}
