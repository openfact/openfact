package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.IndicatorType;
import org.openfact.models.jpa.entities.ublType.NumericType;
import org.openfact.models.jpa.entities.ublType.QuantityType;
import org.openfact.models.jpa.entities.ublType.TextType;

/**
 * A class to define a line in a CatalogueEntity describing a purchasable item.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:19 a. m.
 */
public class CatalogueLineEntity {

    /**
     * A code signifying the action required to synchronize this catalogue line.
     * Recommend codes (delete, update, add)
     */
    private CodeType ActionCode;
    /**
     * The numeric quantity of the ordering unit (and units of measure) of the
     * catalogue line.
     */
    private QuantityType ContentUnitQuantity;
    /**
     * A subdivision of a contract or tender covering this catalogue line.
     */
    private TextType ContractSubdivision;
    /**
     * An identifier for the line in the catalogue.
     */
    private IdentifierType ID;
    /**
     * A code signifying the life cycle status of this catalogue line. Examples
     * are pre-order, end of production
     */
    private CodeType LifeCycleStatusCode;
    /**
     * The maximum amount of the item described in this catalogue line that can
     * be ordered.
     */
    private QuantityType MaximumOrderQuantity;
    /**
     * The minimum amount of the item described in this catalogue line that can
     * be ordered.
     */
    private QuantityType MinimumOrderQuantity;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private TextType Note;
    /**
     * An indicator that this catalogue line describes an orderable item (true)
     * or is included for reference purposes only (false).
     */
    private IndicatorType OrderableIndicator;
    /**
     * A textual description of the units in which the item described in this
     * catalogue line can be ordered.
     */
    private TextType OrderableUnit;
    /**
     * The number of items that can set the order quantity increments.
     */
    private NumericType OrderQuantityIncrementNumeric;
    /**
     * A mutually agreed code signifying the level of packaging associated with
     * the item described in this catalogue line.
     */
    private CodeType PackLevelCode;
    /**
     * Text about a warranty (provided by WarrantyParty) for the good or service
     * described in this catalogue line.
     */
    private TextType WarrantyInformation;
    private CustomerPartyEntity ContractorCustomerParty;
    private List<DocumentReferenceEntity> CallForTendersDocumentReference = new ArrayList<>();
    private List<DocumentReferenceEntity> DocumentReferences = new ArrayList<>();
    private List<ItemEntity> Items = new ArrayList<>();
    private List<ItemComparisonEntity> ItemsComparison = new ArrayList<>();
    private ItemLocationQuantityEntity RequiredItemLocationQuantity;
    private ItemPropertyEntity KeywordItemProperty;
    private LineReferenceEntity CallForTendersLineReference;
    private PartyEntity WarrantyParty;
    private PeriodEntity WarrantyValidityPeriod;
    private PeriodEntity LineValidityPeriod;
    private RelatedItemEntity ComponentRelatedItem;
    private RelatedItemEntity ReplacedRelatedItem;
    private RelatedItemEntity ComplementaryRelatedItem;
    private RelatedItemEntity ReplacementRelatedItem;
    private RelatedItemEntity AccessoryRelatedItem;
    private RelatedItemEntity RequiredRelatedItem;
    private SupplierPartyEntity SellerSupplierParty;

}
