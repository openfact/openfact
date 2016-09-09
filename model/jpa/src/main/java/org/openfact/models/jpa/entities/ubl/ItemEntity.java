package org.openfact.models.jpa.entities.ubl;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe an item of trade. It includes a generic description
 * applicable to all examples of the item together with optional subsidiary
 * descriptions of any number of actual instances of the type.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:39 a. m.
 */
public class ItemEntity{

	/**
	 * Further details regarding this item (e.g., the URL of a relevant web page).
	 */
	private TextType additionalInformation; 
	/**
	 * A brand name of this item.
	 */
	private NameType brandName; 
	/**
	 * An indicator that this item was ordered from a catalogue (true) or not (false).
	 */
	private IndicatorType catalogueIndicator; 
	/**
	 * Text describing this item.
	 */
	private TextType description; 
	/**
	 * An indication that the transported item, as delivered, is subject to an
	 * international regulation concerning the carriage of dangerous goods (true) or
	 * not (false).
	 */
	private IndicatorType hazardousRiskIndicator; 
	/**
	 * A keyword (search string) for this item, assigned by the seller party. Can also
	 * be a synonym for the name of the item.
	 */
	private TextType keyword; 
	/**
	 * A model name of this item.
	 */
	private NameType modelName; 
	/**
	 * A short name optionally given to this item, such as a name from a catalogue, as
	 * distinct from a description.
	 */
	private NameType name; 
	/**
	 * The unit packaging quantity; the number of subunits making up this item.
	 */
	private QuantityType packQuantity; 
	/**
	 * The number of items in a pack of this item.
	 */
	private NumericType packSizeNumeric; 
	private AddressEntity originAddress; 
	private List<CertificateEntity> certificates = new ArrayList<>(); 
	private List<CommodityClassificationEntity> commodityClassifications = new ArrayList<>(); 
	private CountryEntity originCountry; 
	private List<DimensionEntity> dimensions = new ArrayList<>(); 
	private DocumentReferenceEntity itemSpecificationDocumentReference; 
	private DocumentReferenceEntity catalogueDocumentReference; 
	private List<HazardousItemEntity> hazardousItems = new ArrayList<>(); 
	private ItemIdentificationEntity additionalItemIdentification; 
	private ItemIdentificationEntity buyersItemIdentification; 
	private ItemPropertyEntity additionalItemProperty; 
	private PartyEntity manufacturerParty; 
	private PartyEntity informationContentProviderParty; 
	private List<TransactionConditionsEntity> transactionConditionses = new ArrayList<>(); 
	private TaxCategoryEntity classifiedTaxCategory; 
	private ItemIdentificationEntity sellersItemIdentification; 
	private ItemIdentificationEntity standardItemIdentification; 
	private ItemIdentificationEntity catalogueItemIdentification; 
	private ItemIdentificationEntity manufacturersItemIdentification; 
	private List<ItemInstanceEntity> itemInstances = new ArrayList<>(); 

}
