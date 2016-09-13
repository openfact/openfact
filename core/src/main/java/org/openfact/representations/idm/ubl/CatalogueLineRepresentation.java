package org.openfact.representations.idm.ubl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.QuantityRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

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
    private CodeRepresentation actionCode;
    /**
     * The numeric quantity of the ordering unit (and units of measure) of the
     * catalogue line.
     */
    private QuantityRepresentation contentUnitQuantity;
    /**
     * A subdivision of a contract or tender covering this catalogue line.
     */
    private TextRepresentation contractSubdivision;
    /**
     * An identifier for the line in the catalogue.
     */
    private IdentifierRepresentation ID;
    /**
     * A code signifying the life cycle status of this catalogue line. Examples
     * are pre-order, end of production
     */
    private CodeRepresentation lifeCycleStatusCode;
    /**
     * The maximum amount of the item described in this catalogue line that can
     * be ordered.
     */
    private QuantityRepresentation maximumOrderQuantity;
    /**
     * The minimum amount of the item described in this catalogue line that can
     * be ordered.
     */
    private QuantityRepresentation minimumOrderQuantity;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private TextRepresentation note;
    /**
     * An indicator that this catalogue line describes an orderable item (true)
     * or is included for reference purposes only (false).
     */
    private boolean orderableIndicator;
    /**
     * A textual description of the units in which the item described in this
     * catalogue line can be ordered.
     */
    private TextRepresentation orderableUnit;
    /**
     * The number of items that can set the order quantity increments.
     */
    private BigDecimal orderQuantityIncrementNumeric;
    /**
     * A mutually agreed code signifying the level of packaging associated with
     * the item described in this catalogue line.
     */
    private CodeRepresentation packLevelCode;
    /**
     * Text about a warranty (provided by WarrantyParty) for the good or service
     * described in this catalogue line.
     */
    private TextRepresentation warrantyInformation;
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
