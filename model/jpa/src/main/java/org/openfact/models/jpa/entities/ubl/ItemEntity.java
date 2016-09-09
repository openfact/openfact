package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.IndicatorType;
import org.openfact.models.jpa.entities.ublType.NameType;
import org.openfact.models.jpa.entities.ublType.NumericType;
import org.openfact.models.jpa.entities.ublType.QuantityType;
import org.openfact.models.jpa.entities.ublType.TextType;

/**
 * A class to describe an item of trade. It includes a generic description
 * applicable to all examples of the item together with optional subsidiary
 * descriptions of any number of actual instances of the type.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:39 a. m.
 */
public class ItemEntity {

    /**
     * Further details regarding this item (e.g., the URL of a relevant web
     * page).
     */
    private TextType AdditionalInformation;
    /**
     * A brand name of this item.
     */
    private NameType BrandName;
    /**
     * An indicator that this item was ordered from a catalogue (true) or not
     * (false).
     */
    private IndicatorType CatalogueIndicator;
    /**
     * Text describing this item.
     */
    private TextType Description;
    /**
     * An indication that the transported item, as delivered, is subject to an
     * international regulation concerning the carriage of dangerous goods
     * (true) or not (false).
     */
    private IndicatorType HazardousRiskIndicator;
    /**
     * A keyword (search string) for this item, assigned by the seller party.
     * Can also be a synonym for the name of the item.
     */
    private TextType Keyword;
    /**
     * A model name of this item.
     */
    private NameType ModelName;
    /**
     * A short name optionally given to this item, such as a name from a
     * catalogue, as distinct from a description.
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
    private AddressEntity OriginAddress;
    private List<CertificateEntity> Certificates = new ArrayList<>();
    private List<CommodityClassificationEntity> CommodityClassifications = new ArrayList<>();
    private CountryEntity OriginCountry;
    private List<DimensionEntity> Dimensions = new ArrayList<>();
    private DocumentReferenceEntity ItemSpecificationDocumentReference;
    private DocumentReferenceEntity CatalogueDocumentReference;
    private List<HazardousItemEntity> HazardousItems = new ArrayList<>();
    private ItemIdentificationEntity AdditionalItemIdentification;
    private ItemIdentificationEntity BuyersItemIdentification;
    private ItemPropertyEntity AdditionalItemProperty;
    private PartyEntity ManufacturerParty;
    private PartyEntity InformationContentProviderParty;
    private List<TransactionConditionsEntity> TransactionConditionses = new ArrayList<>();
    private TaxCategoryEntity ClassifiedTaxCategory;
    private ItemIdentificationEntity SellersItemIdentification;
    private ItemIdentificationEntity StandardItemIdentification;
    private ItemIdentificationEntity CatalogueItemIdentification;
    private ItemIdentificationEntity ManufacturersItemIdentification;
    private List<ItemInstanceEntity> ItemInstances = new ArrayList<>();

}
