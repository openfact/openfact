package adapter;
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
public class ItemAdapter{

	/**
	 * Further details regarding this item (e.g., the URL of a relevant web page).
	 */
	private TextType AdditionalInformation;
	/**
	 * A brand name of this item.
	 */
	private NameType BrandName;
	/**
	 * An indicator that this item was ordered from a catalogue (true) or not (false).
	 */
	private IndicatorType CatalogueIndicator;
	/**
	 * Text describing this item.
	 */
	private TextType Description;
	/**
	 * An indication that the transported item, as delivered, is subject to an
	 * international regulation concerning the carriage of dangerous goods (true) or
	 * not (false).
	 */
	private IndicatorType HazardousRiskIndicator;
	/**
	 * A keyword (search string) for this item, assigned by the seller party. Can also
	 * be a synonym for the name of the item.
	 */
	private TextType Keyword;
	/**
	 * A model name of this item.
	 */
	private NameType ModelName;
	/**
	 * A short name optionally given to this item, such as a name from a catalogue, as
	 * distinct from a description.
	 */
	private NameType Name;
	/**
	 * The unit packaging quantity; the number of subunits making up this item.
	 */
	private QuantityType PackQuantity;
	/**
	 * The number of items in a pack of this item.
	 */
	private NumericType PackSizeNumeric;
	private AddressAdapter OriginAddress;
	private List<CertificateAdapter> Certificates = new ArrayList<>();
	private List<CommodityClassificationAdapter> CommodityClassifications = new ArrayList<>();
	private CountryAdapter OriginCountry;
	private List<DimensionAdapter> Dimensions = new ArrayList<>();
	private DocumentReferenceAdapter ItemSpecificationDocumentReference;
	private DocumentReferenceAdapter CatalogueDocumentReference;
	private List<HazardousItemAdapter> HazardousItems = new ArrayList<>();
	private ItemIdentificationAdapter AdditionalItemIdentification;
	private ItemIdentificationAdapter BuyersItemIdentification;
	private ItemPropertyAdapter AdditionalItemProperty;
	private PartyAdapter ManufacturerParty;
	private PartyAdapter InformationContentProviderParty;
	private List<TransactionConditionsAdapter> TransactionConditionses = new ArrayList<>();
	private TaxCategoryAdapter ClassifiedTaxCategory;
	private ItemIdentificationAdapter SellersItemIdentification;
	private ItemIdentificationAdapter StandardItemIdentification;
	private ItemIdentificationAdapter CatalogueItemIdentification;
	private ItemIdentificationAdapter ManufacturersItemIdentification;
	private List<ItemInstanceAdapter> ItemInstances = new ArrayList<>();

}
