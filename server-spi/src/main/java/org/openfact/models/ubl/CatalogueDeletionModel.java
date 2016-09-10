package org.openfact.models.ubl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A document used to cancel an entire Catalogue.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:19:19 a. m.
 */
public class CatalogueDeletionModel {

    /**
     * Identifies a user-defined customization of UBL for a specific use.
     */
    private IdentifierType customizationID;
    /**
     * Textual description of the document instance.
     */
    private TextType description;
    /**
     * The effective date, assigned by the seller, on which the CatalogueModel
     * expires.
     */
    private LocalDate effectiveDate;
    /**
     * The effective time, assigned by the seller, at which the CatalogueModel
     * expires.
     */
    private LocalTime effectiveTime;
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
     * Identifies a user-defined profile of the customization of UBL being used.
     */
    private IdentifierType profileID;
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
    private CatalogueReferenceModel deletedCatalogueReference;
    private ContractModel referencedContract;
    private CustomerPartyModel contractorCustomerParty;
    private PartyModel receiverParty;
    private PartyModel providerParty;
    private PeriodModel validityPeriod;
    private List<SignatureModel> signatures = new ArrayList<>();
    private SupplierPartyModel sellerSupplierParty;

}
