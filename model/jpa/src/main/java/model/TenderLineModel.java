package model;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define a line in a Tender.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:15 a. m.
 */
public class TenderLineModel{

	/**
	 * The unit of measure and quantity of the orderable unit.
	 */
	private QuantityType ContentUnitQuantity;
	/**
	 * An identifier for this tender line.
	 */
	private IdentifierType ID;
	/**
	 * The total amount for this tender line, including allowance charges but net of
	 * taxes.
	 */
	private AmountType LineExtensionAmount;
	/**
	 * The maximum number of items described in this tender line that can be ordered.
	 */
	private QuantityType MaximumOrderQuantity;
	/**
	 * The minimum number of items described in this tender line that can be ordered.
	 */
	private QuantityType MinimumOrderQuantity;
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private TextType Note;
	/**
	 * Text describing a unit in which the item described in this tender line can be
	 * ordered.
	 */
	private TextType OrderableUnit;
	/**
	 * The number of items that can set the order quantity increments.
	 */
	private NumericType OrderQuantityIncrementNumeric;
	/**
	 * A mutually agreed code signifying the level of packaging associated with the
	 * item described in this tender line.
	 */
	private CodeType PackLevelCode;
	/**
	 * The quantity of the item quoted in this tender line.
	 */
	private QuantityType Quantity;
	/**
	 * The total tax amount for this tender line.
	 */
	private AmountType TotalTaxAmount;
	/**
	 * Text about a warranty (provided by WarrantyParty) for the good or service
	 * described in this tender line.
	 */
	private TextType WarrantyInformation;
	private List<DocumentReferenceModel> CallForTendersDocumentReference = new ArrayList<>();
	private List<DocumentReferenceModel> DocumentReferences = new ArrayList<>();
	private List<ItemModel> Items = new ArrayList<>();
	private ItemLocationQuantityModel OfferedItemLocationQuantity;
	private LineReferenceModel CallForTendersLineReference;
	private PartyModel WarrantyParty;
	private PeriodModel WarrantyValidityPeriod;
	private RelatedItemModel ReplacementRelatedItem;
	private TenderLineModel SubTenderLine;

}
