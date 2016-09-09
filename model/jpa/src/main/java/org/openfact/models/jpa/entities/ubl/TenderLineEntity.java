package org.openfact.models.jpa.entities.ubl;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define a line in a Tender.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:15 a. m.
 */
public class TenderLineEntity{

	/**
	 * The unit of measure and quantity of the orderable unit.
	 */
	private QuantityType contentUnitQuantity; 
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
	private QuantityType maximumOrderQuantity; 
	/**
	 * The minimum number of items described in this tender line that can be ordered.
	 */
	private QuantityType minimumOrderQuantity; 
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
	private NumericType orderQuantityIncrementNumeric; 
	/**
	 * A mutually agreed code signifying the level of packaging associated with the
	 * item described in this tender line.
	 */
	private CodeType packLevelCode; 
	/**
	 * The quantity of the item quoted in this tender line.
	 */
	private QuantityType quantity; 
	/**
	 * The total tax amount for this tender line.
	 */
	private AmountType totalTaxAmount; 
	/**
	 * Text about a warranty (provided by WarrantyParty) for the good or service
	 * described in this tender line.
	 */
	private TextType warrantyInformation; 
	private List<DocumentReferenceEntity> callForTendersDocumentReference = new ArrayList<>(); 
	private List<DocumentReferenceEntity> documentReferences = new ArrayList<>(); 
	private List<ItemEntity> items = new ArrayList<>(); 
	private ItemLocationQuantityEntity offeredItemLocationQuantity; 
	private LineReferenceEntity callForTendersLineReference; 
	private PartyEntity warrantyParty; 
	private PeriodEntity warrantyValidityPeriod; 
	private RelatedItemEntity replacementRelatedItem; 
	private TenderLineEntity subTenderLine; 

}
