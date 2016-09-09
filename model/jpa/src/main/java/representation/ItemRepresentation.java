package representation;
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
public class ItemRepresentation{

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
	private AddressRepresentation OriginAddress;
	private List<CertificateRepresentation> Certificates = new ArrayList<>();
	private List<CommodityClassificationRepresentation> CommodityClassifications = new ArrayList<>();
	private CountryRepresentation OriginCountry;
	private List<DimensionRepresentation> Dimensions = new ArrayList<>();
	private DocumentReferenceRepresentation ItemSpecificationDocumentReference;
	private DocumentReferenceRepresentation CatalogueDocumentReference;
	private List<HazardousItemRepresentation> HazardousItems = new ArrayList<>();
	private ItemIdentificationRepresentation AdditionalItemIdentification;
	private ItemIdentificationRepresentation BuyersItemIdentification;
	private ItemPropertyRepresentation AdditionalItemProperty;
	private PartyRepresentation ManufacturerParty;
	private PartyRepresentation InformationContentProviderParty;
	private List<TransactionConditionsRepresentation> TransactionConditionses = new ArrayList<>();
	private TaxCategoryRepresentation ClassifiedTaxCategory;
	private ItemIdentificationRepresentation SellersItemIdentification;
	private ItemIdentificationRepresentation StandardItemIdentification;
	private ItemIdentificationRepresentation CatalogueItemIdentification;
	private ItemIdentificationRepresentation ManufacturersItemIdentification;
	private List<ItemInstanceRepresentation> ItemInstances = new ArrayList<>();

}
