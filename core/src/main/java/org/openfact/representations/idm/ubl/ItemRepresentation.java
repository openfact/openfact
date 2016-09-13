package org.openfact.representations.idm.ubl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.QuantityRepresentation;

/**
 * A class to describe an item of trade. It includes a generic description
 * applicable to all examples of the item together with optional subsidiary
 * descriptions of any number of actual instances of the type.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:39 a. m.
 */
public class ItemRepresentation {

    /**
     * Further details regarding this item (e.g., the URL of a relevant web
     * page).
     */
    private String additionalInformation;
    /**
     * A brand name of this item.
     */
    private String brandName;
    /**
     * An indicator that this item was ordered from a catalogue (true) or not
     * (false).
     */
    private boolean catalogueIndicator;
    /**
     * Text describing this item.
     */
    private String description;
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
    private String keyword;
    /**
     * A model name of this item.
     */
    private String modelName;
    /**
     * A short name optionally given to this item, such as a name from a
     * catalogue, as distinct from a description.
     */
    private String name;
    /**
     * The unit packaging quantity; the number of subunits making up this item.
     */
    private QuantityRepresentation packQuantity;
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
    /**
     * @return the additionalInformation
     */
    public String getAdditionalInformation() {
        return additionalInformation;
    }
    /**
     * @param additionalInformation the additionalInformation to set
     */
    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }
    /**
     * @return the brandName
     */
    public String getBrandName() {
        return brandName;
    }
    /**
     * @param brandName the brandName to set
     */
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
    /**
     * @return the catalogueIndicator
     */
    public boolean isCatalogueIndicator() {
        return catalogueIndicator;
    }
    /**
     * @param catalogueIndicator the catalogueIndicator to set
     */
    public void setCatalogueIndicator(boolean catalogueIndicator) {
        this.catalogueIndicator = catalogueIndicator;
    }
    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }
    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * @return the hazardousRiskIndicator
     */
    public boolean isHazardousRiskIndicator() {
        return hazardousRiskIndicator;
    }
    /**
     * @param hazardousRiskIndicator the hazardousRiskIndicator to set
     */
    public void setHazardousRiskIndicator(boolean hazardousRiskIndicator) {
        this.hazardousRiskIndicator = hazardousRiskIndicator;
    }
    /**
     * @return the keyword
     */
    public String getKeyword() {
        return keyword;
    }
    /**
     * @param keyword the keyword to set
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
    /**
     * @return the modelName
     */
    public String getModelName() {
        return modelName;
    }
    /**
     * @param modelName the modelName to set
     */
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return the packQuantity
     */
    public QuantityRepresentation getPackQuantity() {
        return packQuantity;
    }
    /**
     * @param packQuantity the packQuantity to set
     */
    public void setPackQuantity(QuantityRepresentation packQuantity) {
        this.packQuantity = packQuantity;
    }
    /**
     * @return the packSizeNumeric
     */
    public BigDecimal getPackSizeNumeric() {
        return packSizeNumeric;
    }
    /**
     * @param packSizeNumeric the packSizeNumeric to set
     */
    public void setPackSizeNumeric(BigDecimal packSizeNumeric) {
        this.packSizeNumeric = packSizeNumeric;
    }
    /**
     * @return the originAddress
     */
    public AddressRepresentation getOriginAddress() {
        return originAddress;
    }
    /**
     * @param originAddress the originAddress to set
     */
    public void setOriginAddress(AddressRepresentation originAddress) {
        this.originAddress = originAddress;
    }
    /**
     * @return the certificates
     */
    public List<CertificateRepresentation> getCertificates() {
        return certificates;
    }
    /**
     * @param certificates the certificates to set
     */
    public void setCertificates(List<CertificateRepresentation> certificates) {
        this.certificates = certificates;
    }
    /**
     * @return the commodityClassifications
     */
    public List<CommodityClassificationRepresentation> getCommodityClassifications() {
        return commodityClassifications;
    }
    /**
     * @param commodityClassifications the commodityClassifications to set
     */
    public void setCommodityClassifications(
            List<CommodityClassificationRepresentation> commodityClassifications) {
        this.commodityClassifications = commodityClassifications;
    }
    /**
     * @return the originCountry
     */
    public CountryRepresentation getOriginCountry() {
        return originCountry;
    }
    /**
     * @param originCountry the originCountry to set
     */
    public void setOriginCountry(CountryRepresentation originCountry) {
        this.originCountry = originCountry;
    }
    /**
     * @return the dimensions
     */
    public List<DimensionRepresentation> getDimensions() {
        return dimensions;
    }
    /**
     * @param dimensions the dimensions to set
     */
    public void setDimensions(List<DimensionRepresentation> dimensions) {
        this.dimensions = dimensions;
    }
    /**
     * @return the itemSpecificationDocumentReference
     */
    public DocumentReferenceRepresentation getItemSpecificationDocumentReference() {
        return itemSpecificationDocumentReference;
    }
    /**
     * @param itemSpecificationDocumentReference the itemSpecificationDocumentReference to set
     */
    public void setItemSpecificationDocumentReference(
            DocumentReferenceRepresentation itemSpecificationDocumentReference) {
        this.itemSpecificationDocumentReference = itemSpecificationDocumentReference;
    }
    /**
     * @return the catalogueDocumentReference
     */
    public DocumentReferenceRepresentation getCatalogueDocumentReference() {
        return catalogueDocumentReference;
    }
    /**
     * @param catalogueDocumentReference the catalogueDocumentReference to set
     */
    public void setCatalogueDocumentReference(DocumentReferenceRepresentation catalogueDocumentReference) {
        this.catalogueDocumentReference = catalogueDocumentReference;
    }
    /**
     * @return the hazardousItems
     */
    public List<HazardousItemRepresentation> getHazardousItems() {
        return hazardousItems;
    }
    /**
     * @param hazardousItems the hazardousItems to set
     */
    public void setHazardousItems(List<HazardousItemRepresentation> hazardousItems) {
        this.hazardousItems = hazardousItems;
    }
    /**
     * @return the additionalItemIdentification
     */
    public ItemIdentificationRepresentation getAdditionalItemIdentification() {
        return additionalItemIdentification;
    }
    /**
     * @param additionalItemIdentification the additionalItemIdentification to set
     */
    public void setAdditionalItemIdentification(ItemIdentificationRepresentation additionalItemIdentification) {
        this.additionalItemIdentification = additionalItemIdentification;
    }
    /**
     * @return the buyersItemIdentification
     */
    public ItemIdentificationRepresentation getBuyersItemIdentification() {
        return buyersItemIdentification;
    }
    /**
     * @param buyersItemIdentification the buyersItemIdentification to set
     */
    public void setBuyersItemIdentification(ItemIdentificationRepresentation buyersItemIdentification) {
        this.buyersItemIdentification = buyersItemIdentification;
    }
    /**
     * @return the additionalItemProperty
     */
    public ItemPropertyRepresentation getAdditionalItemProperty() {
        return additionalItemProperty;
    }
    /**
     * @param additionalItemProperty the additionalItemProperty to set
     */
    public void setAdditionalItemProperty(ItemPropertyRepresentation additionalItemProperty) {
        this.additionalItemProperty = additionalItemProperty;
    }
    /**
     * @return the manufacturerParty
     */
    public PartyRepresentation getManufacturerParty() {
        return manufacturerParty;
    }
    /**
     * @param manufacturerParty the manufacturerParty to set
     */
    public void setManufacturerParty(PartyRepresentation manufacturerParty) {
        this.manufacturerParty = manufacturerParty;
    }
    /**
     * @return the informationContentProviderParty
     */
    public PartyRepresentation getInformationContentProviderParty() {
        return informationContentProviderParty;
    }
    /**
     * @param informationContentProviderParty the informationContentProviderParty to set
     */
    public void setInformationContentProviderParty(PartyRepresentation informationContentProviderParty) {
        this.informationContentProviderParty = informationContentProviderParty;
    }
    /**
     * @return the transactionConditionses
     */
    public List<TransactionConditionsRepresentation> getTransactionConditionses() {
        return transactionConditionses;
    }
    /**
     * @param transactionConditionses the transactionConditionses to set
     */
    public void setTransactionConditionses(List<TransactionConditionsRepresentation> transactionConditionses) {
        this.transactionConditionses = transactionConditionses;
    }
    /**
     * @return the classifiedTaxCategory
     */
    public TaxCategoryRepresentation getClassifiedTaxCategory() {
        return classifiedTaxCategory;
    }
    /**
     * @param classifiedTaxCategory the classifiedTaxCategory to set
     */
    public void setClassifiedTaxCategory(TaxCategoryRepresentation classifiedTaxCategory) {
        this.classifiedTaxCategory = classifiedTaxCategory;
    }
    /**
     * @return the sellersItemIdentification
     */
    public ItemIdentificationRepresentation getSellersItemIdentification() {
        return sellersItemIdentification;
    }
    /**
     * @param sellersItemIdentification the sellersItemIdentification to set
     */
    public void setSellersItemIdentification(ItemIdentificationRepresentation sellersItemIdentification) {
        this.sellersItemIdentification = sellersItemIdentification;
    }
    /**
     * @return the standardItemIdentification
     */
    public ItemIdentificationRepresentation getStandardItemIdentification() {
        return standardItemIdentification;
    }
    /**
     * @param standardItemIdentification the standardItemIdentification to set
     */
    public void setStandardItemIdentification(ItemIdentificationRepresentation standardItemIdentification) {
        this.standardItemIdentification = standardItemIdentification;
    }
    /**
     * @return the catalogueItemIdentification
     */
    public ItemIdentificationRepresentation getCatalogueItemIdentification() {
        return catalogueItemIdentification;
    }
    /**
     * @param catalogueItemIdentification the catalogueItemIdentification to set
     */
    public void setCatalogueItemIdentification(ItemIdentificationRepresentation catalogueItemIdentification) {
        this.catalogueItemIdentification = catalogueItemIdentification;
    }
    /**
     * @return the manufacturersItemIdentification
     */
    public ItemIdentificationRepresentation getManufacturersItemIdentification() {
        return manufacturersItemIdentification;
    }
    /**
     * @param manufacturersItemIdentification the manufacturersItemIdentification to set
     */
    public void setManufacturersItemIdentification(
            ItemIdentificationRepresentation manufacturersItemIdentification) {
        this.manufacturersItemIdentification = manufacturersItemIdentification;
    }
    /**
     * @return the itemInstances
     */
    public List<ItemInstanceRepresentation> getItemInstances() {
        return itemInstances;
    }
    /**
     * @param itemInstances the itemInstances to set
     */
    public void setItemInstances(List<ItemInstanceRepresentation> itemInstances) {
        this.itemInstances = itemInstances;
    }

}
