package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.DateType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.nameType;
import org.openfact.models.jpa.entities.ublType.NumericType;
import org.openfact.models.jpa.entities.ublType.TextType;
import org.openfact.models.jpa.entities.ublType.TimeType;

/**
 * A document used to update information about prices in an existing Catalogue.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:19:49 a. m.
 */
public class CataloguePricingUpdateEntity {

    /**
     * Identifies a user-defined customization of UBL for a specific use.
     */
    private IdentifierType customizationID;
    /**
     * Describes the CatalogueEntity Revision.
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
     * The number of lines in the document.
     */
    private NumericType lineCountNumeric;
    /**
     * Text, assigned by the sender, that identifies this document to business
     * users.
     */
    private nameType name;
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
    private DateType revisionDate;
    /**
     * The time, assigned by the seller, at which the CatalogueEntity was
     * revised.
     */
    private TimeType revisionTime;
    /**
     * Identifies the earliest version of the UBL 2 schema for this document
     * type that defines all of the elements that might be encountered in the
     * current instance.
     */
    private IdentifierType UBLversionID;
    /**
     * A universally unique identifier for an instance of this document.
     */
    private IdentifierType UUID;
    /**
     * Indicates the current version of the catalogue.
     */
    private IdentifierType versionID;
    private List<CataloguePricingUpdateLineEntity> cataloguePricingUpdateLines = new ArrayList<>();
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
