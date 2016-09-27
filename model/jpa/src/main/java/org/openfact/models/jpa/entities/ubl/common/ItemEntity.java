package org.openfact.models.jpa.entities.ubl.common;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "ITEM")
@Inheritance(strategy = InheritanceType.JOINED)
public class ItemEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Access(AccessType.PROPERTY)
    protected String id;

    @ElementCollection
    @Column(name = "VALUE")
    @CollectionTable(name = "ITEM_DESCRIPTION", joinColumns = { @JoinColumn(name = "ADDRESS_ID") })
    protected List<String> description = new ArrayList<>();

    @ManyToOne(targetEntity = QuantityEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "PACKQUANTITY_ITEM")
    protected QuantityEntity packQuantity = new QuantityEntity();

    @Column(name = "PACK_SIZE_NUMERIC")
    protected BigDecimal packSizeNumeric;

    @Column(name = "CATALOGUE_INDICATOR")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    protected boolean catalogueIndicator;

    @Column(name = "NAME")
    protected String name;

    @Column(name = "HAZARDOUS_RISK_INDICATOR")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    protected boolean hazardousRiskIndicator;

    @Column(name = "ADDITIONAL_INFORMATION")
    protected String additionalInformation;

    @ElementCollection
    @Column(name = "VALUE")
    @CollectionTable(name = "ITEM_KEYWORD", joinColumns = { @JoinColumn(name = "ITEM_ID") })
    protected List<String> keyword = new ArrayList<>();

    @ElementCollection
    @Column(name = "VALUE")
    @CollectionTable(name = "ITEM_BRANDNAME", joinColumns = { @JoinColumn(name = "ITEM_ID") })
    protected List<String> brandName = new ArrayList<>();

    @ElementCollection
    @Column(name = "VALUE")
    @CollectionTable(name = "ITEM_MODELNAME", joinColumns = { @JoinColumn(name = "ITEM_ID") })
    protected List<String> modelName = new ArrayList<>();

    @ManyToOne(targetEntity = ItemIdentificationEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "BUYERSITEMIDENTIFICATION_ITEM")
    protected ItemIdentificationEntity buyersItemIdentification;

    @ManyToOne(targetEntity = ItemIdentificationEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "SELLERSITEMIDENTIFICATION_ITEM")
    protected ItemIdentificationEntity sellersItemIdentification = new ItemIdentificationEntity();

    @OneToMany(targetEntity = ItemIdentificationEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "MANUFACTURERSITEMIDENTIFICATION_ITEM")
    protected List<ItemIdentificationEntity> manufacturersItemIdentification = new ArrayList<>();

    @ManyToOne(targetEntity = ItemIdentificationEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "STANDARDITEMIDENTIFICATION_ITEM")
    protected ItemIdentificationEntity standardItemIdentification = new ItemIdentificationEntity();

    @ManyToOne(targetEntity = ItemIdentificationEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "CATALOGUEITEMIDENTIFICATION_ITEM")
    protected ItemIdentificationEntity catalogueItemIdentification;

    @OneToMany(targetEntity = ItemIdentificationEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ADDITIONALITEMIDENTIFICATION_ITEM")
    protected List<ItemIdentificationEntity> additionalItemIdentification = new ArrayList<>();

    @ManyToOne(targetEntity = DocumentReferenceEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "CATALOGUEDOCUMENTREFERENCE_ITEM")
    protected DocumentReferenceEntity catalogueDocumentReference = new DocumentReferenceEntity();

    @OneToMany(targetEntity = DocumentReferenceEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ITEMSPECIFICATIONDOCUMENTREF_ITEM")
    protected List<DocumentReferenceEntity> itemSpecificationDocumentReference = new ArrayList<>();

    @ManyToOne(targetEntity = CountryEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ORIGINCOUNTRY_ITEM_ID")
    protected CountryEntity originCountry = new CountryEntity();

    @OneToMany(targetEntity = CommodityClassificationEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "COMMODITYCLASSIFICATION_ITEM")
    protected List<CommodityClassificationEntity> commodityClassification = new ArrayList<>();

    @OneToMany(targetEntity = TransactionConditionsEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "TRANSACTIONCONDITIONS_ITEM")
    protected List<TransactionConditionsEntity> transactionConditions = new ArrayList<>();

    @OneToMany(targetEntity = HazardousItemEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "HAZARDOUSITEM_ITEM")
    protected List<HazardousItemEntity> hazardousItem = new ArrayList<>();

    @OneToMany(targetEntity = TaxCategoryEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ITEM_CLASSIFIEDTAXCATEGORY")
    protected List<TaxCategoryEntity> classifiedTaxCategory = new ArrayList<>();

    @OneToMany(targetEntity = ItemPropertyEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ADDITIONALITEMPROPERTY_ITEM")
    protected List<ItemPropertyEntity> additionalItemProperty = new ArrayList<>();

    @OneToMany(targetEntity = PartyEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "MANUFACTURERPARTY_ITEM")
    protected List<PartyEntity> manufacturerParty = new ArrayList<>();

    @ManyToOne(targetEntity = PartyEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "INFORMATIONCONTENTPROVIDERPARTY_ITEM")
    protected PartyEntity informationContentProviderParty = new PartyEntity();

    @OneToMany(targetEntity = AddressEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ORIGINADDRESS_ITEM_ID")
    protected List<AddressEntity> originAddress = new ArrayList<>();

    @OneToMany(targetEntity = ItemInstanceEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ITEMINSTANCE_ITEM")
    protected List<ItemInstanceEntity> itemInstance = new ArrayList<>();

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the description
     */
    public List<String> getDescription() {
        return description;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(List<String> description) {
        this.description = description;
    }

    /**
     * @return the packQuantity
     */
    public QuantityEntity getPackQuantity() {
        return packQuantity;
    }

    /**
     * @param packQuantity
     *            the packQuantity to set
     */
    public void setPackQuantity(QuantityEntity packQuantity) {
        this.packQuantity = packQuantity;
    }

    /**
     * @return the packSizeNumeric
     */
    public BigDecimal getPackSizeNumeric() {
        return packSizeNumeric;
    }

    /**
     * @param packSizeNumeric
     *            the packSizeNumeric to set
     */
    public void setPackSizeNumeric(BigDecimal packSizeNumeric) {
        this.packSizeNumeric = packSizeNumeric;
    }

    /**
     * @return the catalogueIndicator
     */
    public boolean isCatalogueIndicator() {
        return catalogueIndicator;
    }

    /**
     * @param catalogueIndicator
     *            the catalogueIndicator to set
     */
    public void setCatalogueIndicator(boolean catalogueIndicator) {
        this.catalogueIndicator = catalogueIndicator;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the hazardousRiskIndicator
     */
    public boolean isHazardousRiskIndicator() {
        return hazardousRiskIndicator;
    }

    /**
     * @param hazardousRiskIndicator
     *            the hazardousRiskIndicator to set
     */
    public void setHazardousRiskIndicator(boolean hazardousRiskIndicator) {
        this.hazardousRiskIndicator = hazardousRiskIndicator;
    }

    /**
     * @return the additionalInformation
     */
    public String getAdditionalInformation() {
        return additionalInformation;
    }

    /**
     * @param additionalInformation
     *            the additionalInformation to set
     */
    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    /**
     * @return the keyword
     */
    public List<String> getKeyword() {
        return keyword;
    }

    /**
     * @param keyword
     *            the keyword to set
     */
    public void setKeyword(List<String> keyword) {
        this.keyword = keyword;
    }

    /**
     * @return the brandName
     */
    public List<String> getBrandName() {
        return brandName;
    }

    /**
     * @param brandName
     *            the brandName to set
     */
    public void setBrandName(List<String> brandName) {
        this.brandName = brandName;
    }

    /**
     * @return the modelName
     */
    public List<String> getModelName() {
        return modelName;
    }

    /**
     * @param modelName
     *            the modelName to set
     */
    public void setModelName(List<String> modelName) {
        this.modelName = modelName;
    }

    /**
     * @return the buyersItemIdentification
     */
    public ItemIdentificationEntity getBuyersItemIdentification() {
        return buyersItemIdentification;
    }

    /**
     * @param buyersItemIdentification
     *            the buyersItemIdentification to set
     */
    public void setBuyersItemIdentification(ItemIdentificationEntity buyersItemIdentification) {
        this.buyersItemIdentification = buyersItemIdentification;
    }

    /**
     * @return the sellersItemIdentification
     */
    public ItemIdentificationEntity getSellersItemIdentification() {
        return sellersItemIdentification;
    }

    /**
     * @param sellersItemIdentification
     *            the sellersItemIdentification to set
     */
    public void setSellersItemIdentification(ItemIdentificationEntity sellersItemIdentification) {
        this.sellersItemIdentification = sellersItemIdentification;
    }

    /**
     * @return the manufacturersItemIdentification
     */
    public List<ItemIdentificationEntity> getManufacturersItemIdentification() {
        return manufacturersItemIdentification;
    }

    /**
     * @param manufacturersItemIdentification
     *            the manufacturersItemIdentification to set
     */
    public void setManufacturersItemIdentification(
            List<ItemIdentificationEntity> manufacturersItemIdentification) {
        this.manufacturersItemIdentification = manufacturersItemIdentification;
    }

    /**
     * @return the standardItemIdentification
     */
    public ItemIdentificationEntity getStandardItemIdentification() {
        return standardItemIdentification;
    }

    /**
     * @param standardItemIdentification
     *            the standardItemIdentification to set
     */
    public void setStandardItemIdentification(ItemIdentificationEntity standardItemIdentification) {
        this.standardItemIdentification = standardItemIdentification;
    }

    /**
     * @return the catalogueItemIdentification
     */
    public ItemIdentificationEntity getCatalogueItemIdentification() {
        return catalogueItemIdentification;
    }

    /**
     * @param catalogueItemIdentification
     *            the catalogueItemIdentification to set
     */
    public void setCatalogueItemIdentification(ItemIdentificationEntity catalogueItemIdentification) {
        this.catalogueItemIdentification = catalogueItemIdentification;
    }

    /**
     * @return the additionalItemIdentification
     */
    public List<ItemIdentificationEntity> getAdditionalItemIdentification() {
        return additionalItemIdentification;
    }

    /**
     * @param additionalItemIdentification
     *            the additionalItemIdentification to set
     */
    public void setAdditionalItemIdentification(List<ItemIdentificationEntity> additionalItemIdentification) {
        this.additionalItemIdentification = additionalItemIdentification;
    }

    /**
     * @return the catalogueDocumentReference
     */
    public DocumentReferenceEntity getCatalogueDocumentReference() {
        return catalogueDocumentReference;
    }

    /**
     * @param catalogueDocumentReference
     *            the catalogueDocumentReference to set
     */
    public void setCatalogueDocumentReference(DocumentReferenceEntity catalogueDocumentReference) {
        this.catalogueDocumentReference = catalogueDocumentReference;
    }

    /**
     * @return the itemSpecificationDocumentReference
     */
    public List<DocumentReferenceEntity> getItemSpecificationDocumentReference() {
        return itemSpecificationDocumentReference;
    }

    /**
     * @param itemSpecificationDocumentReference
     *            the itemSpecificationDocumentReference to set
     */
    public void setItemSpecificationDocumentReference(
            List<DocumentReferenceEntity> itemSpecificationDocumentReference) {
        this.itemSpecificationDocumentReference = itemSpecificationDocumentReference;
    }

    /**
     * @return the originCountry
     */
    public CountryEntity getOriginCountry() {
        return originCountry;
    }

    /**
     * @param originCountry
     *            the originCountry to set
     */
    public void setOriginCountry(CountryEntity originCountry) {
        this.originCountry = originCountry;
    }

    /**
     * @return the commodityClassification
     */
    public List<CommodityClassificationEntity> getCommodityClassification() {
        return commodityClassification;
    }

    /**
     * @param commodityClassification
     *            the commodityClassification to set
     */
    public void setCommodityClassification(List<CommodityClassificationEntity> commodityClassification) {
        this.commodityClassification = commodityClassification;
    }

    /**
     * @return the transactionConditions
     */
    public List<TransactionConditionsEntity> getTransactionConditions() {
        return transactionConditions;
    }

    /**
     * @param transactionConditions
     *            the transactionConditions to set
     */
    public void setTransactionConditions(List<TransactionConditionsEntity> transactionConditions) {
        this.transactionConditions = transactionConditions;
    }

    /**
     * @return the hazardousItem
     */
    public List<HazardousItemEntity> getHazardousItem() {
        return hazardousItem;
    }

    /**
     * @param hazardousItem
     *            the hazardousItem to set
     */
    public void setHazardousItem(List<HazardousItemEntity> hazardousItem) {
        this.hazardousItem = hazardousItem;
    }

    /**
     * @return the classifiedTaxCategory
     */
    public List<TaxCategoryEntity> getClassifiedTaxCategory() {
        return classifiedTaxCategory;
    }

    /**
     * @param classifiedTaxCategory
     *            the classifiedTaxCategory to set
     */
    public void setClassifiedTaxCategory(List<TaxCategoryEntity> classifiedTaxCategory) {
        this.classifiedTaxCategory = classifiedTaxCategory;
    }

    /**
     * @return the additionalItemProperty
     */
    public List<ItemPropertyEntity> getAdditionalItemProperty() {
        return additionalItemProperty;
    }

    /**
     * @param additionalItemProperty
     *            the additionalItemProperty to set
     */
    public void setAdditionalItemProperty(List<ItemPropertyEntity> additionalItemProperty) {
        this.additionalItemProperty = additionalItemProperty;
    }

    /**
     * @return the manufacturerParty
     */
    public List<PartyEntity> getManufacturerParty() {
        return manufacturerParty;
    }

    /**
     * @param manufacturerParty
     *            the manufacturerParty to set
     */
    public void setManufacturerParty(List<PartyEntity> manufacturerParty) {
        this.manufacturerParty = manufacturerParty;
    }

    /**
     * @return the informationContentProviderParty
     */
    public PartyEntity getInformationContentProviderParty() {
        return informationContentProviderParty;
    }

    /**
     * @param informationContentProviderParty
     *            the informationContentProviderParty to set
     */
    public void setInformationContentProviderParty(PartyEntity informationContentProviderParty) {
        this.informationContentProviderParty = informationContentProviderParty;
    }

    /**
     * @return the originAddress
     */
    public List<AddressEntity> getOriginAddress() {
        return originAddress;
    }

    /**
     * @param originAddress
     *            the originAddress to set
     */
    public void setOriginAddress(List<AddressEntity> originAddress) {
        this.originAddress = originAddress;
    }

    /**
     * @return the itemInstance
     */
    public List<ItemInstanceEntity> getItemInstance() {
        return itemInstance;
    }

    /**
     * @param itemInstance
     *            the itemInstance to set
     */
    public void setItemInstance(List<ItemInstanceEntity> itemInstance) {
        this.itemInstance = itemInstance;
    }

}
