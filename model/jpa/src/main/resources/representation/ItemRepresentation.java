package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
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
	private TextType additionalInformation; 
	/**
	 * A brand name of this item.
	 */
	private NameType brandName; 
	/**
	 * An indicator that this item was ordered from a catalogue (true) or not (false).
	 */
	private boolean catalogueIndicator; 
	/**
	 * Text describing this item.
	 */
	private TextType description; 
	/**
	 * An indication that the transported item, as delivered, is subject to an
	 * international regulation concerning the carriage of dangerous goods (true) or
	 * not (false).
	 */
	private boolean hazardousRiskIndicator; 
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
	private BigDecimal packSizeNumeric; 
	private AddressRepresentation originAddress; 
	private List<CertificateRepresentation> certificates = new ArrayList<>(); 
	private List<CommodityClassificationRepresentation> commodityClassifications = new ArrayList<>(); 
	private CountryRepresentation originCountry; 
	private List<DimensionRepresentation> dimensions = new ArrayList<>(); 
	private DocumentReferenceRepresentation itemSpecificationDocumentReference; 
	private DocumentReferenceRepresentation catalogueDocumentReference; 
	private List<HazardousItemRepresentation> hazardousItems = new ArrayList<>(); 
	private ItemIdentificationRepresentation additionalItemIdentification; 
	private ItemIdentificationRepresentation buyersItemIdentification; 
	private ItemPropertyRepresentation additionalItemProperty; 
	private PartyRepresentation manufacturerParty; 
	private PartyRepresentation informationContentProviderParty; 
	private List<TransactionConditionsRepresentation> transactionConditionses = new ArrayList<>(); 
	private TaxCategoryRepresentation classifiedTaxCategory; 
	private ItemIdentificationRepresentation sellersItemIdentification; 
	private ItemIdentificationRepresentation standardItemIdentification; 
	private ItemIdentificationRepresentation catalogueItemIdentification; 
	private ItemIdentificationRepresentation manufacturersItemIdentification; 
	private List<ItemInstanceRepresentation> itemInstances = new ArrayList<>(); 

}
