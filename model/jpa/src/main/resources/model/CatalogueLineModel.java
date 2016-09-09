package org.openfact.models.jpa.entities.ubl;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define a line in a CatalogueModel describing a purchasable item.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:19 a. m.
 */
public class CatalogueLineModel{

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
	 * A code signifying the life cycle status of this catalogue line. Examples are
	 * pre-order, end of production
	 */
	private CodeType lifeCycleStatusCode; 
	/**
	 * The maximum amount of the item described in this catalogue line that can be
	 * ordered.
	 */
	private QuantityType maximumOrderQuantity; 
	/**
	 * The minimum amount of the item described in this catalogue line that can be
	 * ordered.
	 */
	private QuantityType minimumOrderQuantity; 
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private TextType note; 
	/**
	 * An indicator that this catalogue line describes an orderable item (true) or is
	 * included for reference purposes only (false).
	 */
	private IndicatorType orderableIndicator; 
	/**
	 * A textual description of the units in which the item described in this
	 * catalogue line can be ordered.
	 */
	private TextType orderableUnit; 
	/**
	 * The number of items that can set the order quantity increments.
	 */
	private NumericType orderQuantityIncrementNumeric; 
	/**
	 * A mutually agreed code signifying the level of packaging associated with the
	 * item described in this catalogue line.
	 */
	private CodeType packLevelCode; 
	/**
	 * Text about a warranty (provided by WarrantyParty) for the good or service
	 * described in this catalogue line.
	 */
	private TextType warrantyInformation; 
	private CustomerPartyModel contractorCustomerParty; 
	private List<DocumentReferenceModel> callForTendersDocumentReference = new ArrayList<>(); 
	private List<DocumentReferenceModel> documentReferences = new ArrayList<>(); 
	private List<ItemModel> items = new ArrayList<>(); 
	private List<ItemComparisonModel> itemsComparison = new ArrayList<>(); 
	private ItemLocationQuantityModel requiredItemLocationQuantity; 
	private ItemPropertyModel keywordItemProperty; 
	private LineReferenceModel callForTendersLineReference; 
	private PartyModel warrantyParty; 
	private PeriodModel warrantyValidityPeriod; 
	private PeriodModel lineValidityPeriod; 
	private RelatedItemModel componentRelatedItem; 
	private RelatedItemModel replacedRelatedItem; 
	private RelatedItemModel complementaryRelatedItem; 
	private RelatedItemModel replacementRelatedItem; 
	private RelatedItemModel accessoryRelatedItem; 
	private RelatedItemModel requiredRelatedItem; 
	private SupplierPartyModel sellerSupplierParty; 

}
