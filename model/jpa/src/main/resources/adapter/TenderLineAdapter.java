package adapter;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define a line in a Tender.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:15 a. m.
 */
public class TenderLineAdapter{

	/**
	 * The unit of measure and quantity of the orderable unit.
	 */
	private quantityType contentUnitquantity;
	/**
	 * An identifier for this tender line.
	 */
	private IdentifierType ID;
	/**
	 * The total amount for this tender line, including allowance charges but net of
	 * taxes.
	 */
	private AmountType lineExtensionAmount;
	/**
	 * The maximum number of items described in this tender line that can be ordered.
	 */
	private quantityType maximumOrderquantity;
	/**
	 * The minimum number of items described in this tender line that can be ordered.
	 */
	private quantityType minimumOrderquantity;
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private TextType note;
	/**
	 * Text describing a unit in which the item described in this tender line can be
	 * ordered.
	 */
	private TextType orderableUnit;
	/**
	 * The number of items that can set the order quantity increments.
	 */
	private NumericType orderquantityIncrementNumeric;
	/**
	 * A mutually agreed code signifying the level of packaging associated with the
	 * item described in this tender line.
	 */
	private CodeType packLevelCode;
	/**
	 * The quantity of the item quoted in this tender line.
	 */
	private quantityType quantity;
	/**
	 * The total tax amount for this tender line.
	 */
	private AmountType totalTaxAmount;
	/**
	 * Text about a warranty (provided by warrantyParty) for the good or service
	 * described in this tender line.
	 */
	private TextType warrantyInformation;
	private List<DocumentReferenceAdapter> callForTendersDocumentReference = new ArrayList<>();
	private List<DocumentReferenceAdapter> documentReferences = new ArrayList<>();
	private List<ItemAdapter> items = new ArrayList<>();
	private ItemLocationquantityAdapter OfferedItemLocationquantity;
	private LineReferenceAdapter callForTendersLineReference;
	private PartyAdapter warrantyParty;
	private PeriodAdapter warrantyValidityPeriod;
	private RelatedItemAdapter replacementRelatedItem;
	private TenderLineAdapter subTenderLine;

}
