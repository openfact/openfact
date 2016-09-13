package org.openfact.models.ubl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A report on the quantities of each item that are, or will be, in stock. This
 * document is sent by a Buyer (for example a retailer) to a Seller (for example
 * a producer).
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:20:48 a. m.
 */
public class InventoryReportModel {

    /**
     * Indicates whether this document is a copy (true) or not (false).
     */
    private boolean copyIndicator;
    /**
     * Identifies a user-defined customization of UBL for a specific use.
     */
    private IdentifierModel customizationID;
    /**
     * A code signifying the currency in which the Document is presented. This
     * may be the same currency as the pricing or as the tax.
     */
    private CurrencyCodeModel codeTypeDocumentCurrencyCode;
    /**
     * An identifier for the InventoryReport, assigned by the Issuer.
     */
    private IdentifierModel ID;
    /**
     * The date, assigned by the sender, on which this document was issued.
     */
    private LocalDate issueDate;
    /**
     * The time at which the InventoryReportModel was issued.
     */
    private LocalTime issueTime;
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
    private CustomerPartyModel retailerCustomerParty;
    private List<DocumentReferenceModel> documentReferences = new ArrayList<>();
    private List<InventoryReportLineModel> inventoryReportLines = new ArrayList<>();
    private PartyModel inventoryReportingParty;
    private PeriodModel inventoryPeriod;
    private List<SignatureModel> signatures = new ArrayList<>();
    private SupplierPartyModel sellerSupplierParty;

}
