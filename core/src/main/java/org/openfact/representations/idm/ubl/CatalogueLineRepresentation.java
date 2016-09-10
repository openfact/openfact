package org.openfact.representations.idm.ubl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeType;
import org.openfact.representations.idm.ubl.type.IdentifierType;
import org.openfact.representations.idm.ubl.type.QuantityType;
import org.openfact.representations.idm.ubl.type.TextType;

/**
 * A class to define a line in a CatalogueRepresentation describing a
 * purchasable item.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:19 a. m.
 */
public class CatalogueLineRepresentation {

    /**
     * A code signifying the action required to synchronize this catalogue line.
     * Recommend codes (delete, update, add)
     */
    private CodeType actionCode;
    /**
     * The numeric quantity of the ordering unit (and units of measure) of the
     * catalogue line.
     */
    private QuantityType contentUnitQuantity;
    /**
     * A subdivision of a contract or tender covering this catalogue line.
     */
    private TextType contractSubdivision;
    /**
     * An identifier for the line in the catalogue.
     */
    private IdentifierType ID;
    /**
     * A code signifying the life cycle status of this catalogue line. Examples
     * are pre-order, end of production
     */
    private CodeType lifeCycleStatusCode;
    /**
     * The maximum amount of the item described in this catalogue line that can
     * be ordered.
     */
    private QuantityType maximumOrderQuantity;
    /**
     * The minimum amount of the item described in this catalogue line that can
     * be ordered.
     */
    private QuantityType minimumOrderQuantity;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private TextType note;
    /**
     * An indicator that this catalogue line describes an orderable item (true)
     * or is included for reference purposes only (false).
     */
    private boolean orderableIndicator;
    /**
     * A textual description of the units in which the item described in this
     * catalogue line can be ordered.
     */
    private TextType orderableUnit;
    /**
     * The number of items that can set the order quantity increments.
     */
    private BigDecimal orderQuantityIncrementNumeric;
    /**
     * A mutually agreed code signifying the level of packaging associated with
     * the item described in this catalogue line.
     */
    private CodeType packLevelCode;
    /**
     * Text about a warranty (provided by WarrantyParty) for the good or service
     * described in this catalogue line.
     */
    private TextType warrantyInformation;
    private CustomerPartyRepresentation contractorCustomerParty;
    private List<DocumentReferenceRepresentation> callForTendersDocumentReference = new ArrayList<>();
    private List<DocumentReferenceRepresentation> documentReferences = new ArrayList<>();
    private List<ItemRepresentation> items = new ArrayList<>();
    private List<ItemComparisonRepresentation> itemsComparison = new ArrayList<>();
    private ItemLocationQuantityRepresentation requiredItemLocationQuantity;
    private ItemPropertyRepresentation keywordItemProperty;
    private LineReferenceRepresentation callForTendersLineReference;
    private PartyRepresentation warrantyParty;
    private PeriodRepresentation warrantyValidityPeriod;
    private PeriodRepresentation lineValidityPeriod;
    private RelatedItemRepresentation componentRelatedItem;
    private RelatedItemRepresentation replacedRelatedItem;
    private RelatedItemRepresentation complementaryRelatedItem;
    private RelatedItemRepresentation replacementRelatedItem;
    private RelatedItemRepresentation accessoryRelatedItem;
    private RelatedItemRepresentation requiredRelatedItem;
    private SupplierPartyRepresentation sellerSupplierParty;

}
