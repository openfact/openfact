package org.openfact.models.ubl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A class to describe an item of trade. It includes a generic description
 * applicable to all examples of the item together with optional subsidiary
 * descriptions of any number of actual instances of the type.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:39 a. m.
 */
public class ItemModel {

    /**
     * Further details regarding this item (e.g., the URL of a relevant web
     * page).
     */
    private TextType additionalInformation;
    /**
     * A brand name of this item.
     */
    private NameType brandName;
    /**
     * An indicator that this item was ordered from a catalogue (true) or not
     * (false).
     */
    private boolean catalogueIndicator;
    /**
     * Text describing this item.
     */
    private TextType description;
    /**
     * An indication that the transported item, as delivered, is subject to an
     * international regulation concerning the carriage of dangerous goods
     * (true) or not (false).
     */
    private boolean hazardousRiskIndicator;
    /**
     * A keyword (search string) for this item, assigned by the seller party.
     * Can also be a synonym for the name of the item.
     */
    private TextType keyword;
    /**
     * A model name of this item.
     */
    private NameType modelName;
    /**
     * A short name optionally given to this item, such as a name from a
     * catalogue, as distinct from a description.
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
    private AddressModel originAddress;
    private List<CertificateModel> certificates = new ArrayList<>();
    private List<CommodityClassificationModel> commodityClassifications = new ArrayList<>();
    private CountryModel originCountry;
    private List<DimensionModel> dimensions = new ArrayList<>();
    private DocumentReferenceModel itemSpecificationDocumentReference;
    private DocumentReferenceModel catalogueDocumentReference;
    private List<HazardousItemModel> hazardousItems = new ArrayList<>();
    private ItemIdentificationModel additionalItemIdentification;
    private ItemIdentificationModel buyersItemIdentification;
    private ItemPropertyModel additionalItemProperty;
    private PartyModel manufacturerParty;
    private PartyModel informationContentProviderParty;
    private List<TransactionConditionsModel> transactionConditionses = new ArrayList<>();
    private TaxCategoryModel classifiedTaxCategory;
    private ItemIdentificationModel sellersItemIdentification;
    private ItemIdentificationModel standardItemIdentification;
    private ItemIdentificationModel catalogueItemIdentification;
    private ItemIdentificationModel manufacturersItemIdentification;
    private List<ItemInstanceModel> itemInstances = new ArrayList<>();

}
