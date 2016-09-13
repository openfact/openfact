package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.openfact.models.ubl.type.NameType;
import org.openfact.models.ubl.type.QuantityType;
import org.openfact.models.ubl.type.TextType;

/**
 * A class to describe an item of trade. It includes a generic description
 * applicable to all examples of the item together with optional subsidiary
 * descriptions of any number of actual instances of the type.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:39 a. m.
 */
@Entity
@Table(name = "ITEM")
public class ItemEntity {

	@Id
	@Column(name = "ID_OP", length = 36)
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Access(AccessType.PROPERTY)
	private String id;
	/**
	 * Further details regarding this item (e.g., the URL of a relevant web
	 * page).
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "ADDITIONALINFORMATION_VALUE")),
			@AttributeOverride(name = "languageID", column = @Column(name = "ADDITIONALINFORMATION_LANGUAGEID")) })
	private TextType additionalInformation;
	/**
	 * A brand name of this item.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "BRANDNAME_VALUE")),
			@AttributeOverride(name = "languageID", column = @Column(name = "BRANDNAME_LANGUAGEID")) })
	private NameType brandName;
	/**
	 * An indicator that this item was ordered from a catalogue (true) or not
	 * (false).
	 */
	@Type(type = "org.hibernate.type.NumericBooleanType")
	@Column(name = "CATALOGUE_INDICATOR")
	private boolean catalogueIndicator;
	/**
	 * Text describing this item.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "DESCRIPTION_VALUE")),
			@AttributeOverride(name = "languageID", column = @Column(name = "DESCRIPTION_LANGUAGEID")) })
	private TextType description;
	/**
	 * An indication that the transported item, as delivered, is subject to an
	 * international regulation concerning the carriage of dangerous goods
	 * (true) or not (false).
	 */
	@Type(type = "org.hibernate.type.NumericBooleanType")
	@Column(name = "HAZARDOUS_RISK_INDICATOR")
	private boolean hazardousRiskIndicator;
	/**
	 * A keyword (search string) for this item, assigned by the seller party.
	 * Can also be a synonym for the name of the item.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "KEYWORD_VALUE")),
			@AttributeOverride(name = "languageID", column = @Column(name = "KEYWORD_LANGUAGEID")) })
	private TextType keyword;
	/**
	 * A model name of this item.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "MODELNAME_VALUE")),
			@AttributeOverride(name = "languageID", column = @Column(name = "MODELNAME_LANGUAGEID")) })
	private NameType modelName;
	/**
	 * A short name optionally given to this item, such as a name from a
	 * catalogue, as distinct from a description.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "NAME_VALUE")),
			@AttributeOverride(name = "languageID", column = @Column(name = "NAME_LANGUAGEID")) })
	private NameType name;
	/**
	 * The unit packaging quantity; the number of subunits making up this item.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "PACKQUANTITY_VALUE")),
			@AttributeOverride(name = "unitCode", column = @Column(name = "PACKQUANTITY_UNITCODE")) })
	private QuantityType packQuantity;
	/**
	 * The number of items in a pack of this item.
	 */
	@Column(name = "PACK_SIZE_NUMERIC")
	private BigDecimal packSizeNumeric;
	@Transient
	private AddressEntity originAddress;
	@Transient
	private List<CertificateEntity> certificates = new ArrayList<>();
	@Transient
	private List<CommodityClassificationEntity> commodityClassifications = new ArrayList<>();
	@Transient
	private CountryEntity originCountry;
	@Transient
	private List<DimensionEntity> dimensions = new ArrayList<>();
	@Transient
	private DocumentReferenceEntity itemSpecificationDocumentReference;
	@Transient
	private DocumentReferenceEntity catalogueDocumentReference;
	@Transient
	private List<HazardousItemEntity> hazardousItems = new ArrayList<>();
	@OneToMany(mappedBy = "item", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
	private ItemIdentificationMappingEntity additionalItemIdentification;
	@OneToMany(mappedBy = "item", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
	private ItemIdentificationMappingEntity buyersItemIdentification;
	@Transient
	private ItemPropertyEntity additionalItemProperty;
	@Transient
	private PartyEntity manufacturerParty;
	@Transient
	private PartyEntity informationContentProviderParty;
	@Transient
	private List<TransactionConditionsEntity> transactionConditionses = new ArrayList<>();
	@Transient
	private TaxCategoryEntity classifiedTaxCategory;

	@OneToMany(mappedBy = "item", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
	private ItemIdentificationMappingEntity sellersItemIdentification;

	@OneToMany(mappedBy = "item", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
	private ItemIdentificationMappingEntity standardItemIdentification;
	@OneToMany(mappedBy = "item", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
	private ItemIdentificationMappingEntity catalogueItemIdentification;
	@OneToMany(mappedBy = "item", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
	private ItemIdentificationMappingEntity manufacturersItemIdentification;
	@Transient
	private List<ItemInstanceEntity> itemInstances = new ArrayList<>();
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public TextType getAdditionalInformation() {
		return additionalInformation;
	}
	public void setAdditionalInformation(TextType additionalInformation) {
		this.additionalInformation = additionalInformation;
	}
	public NameType getBrandName() {
		return brandName;
	}
	public void setBrandName(NameType brandName) {
		this.brandName = brandName;
	}
	public boolean isCatalogueIndicator() {
		return catalogueIndicator;
	}
	public void setCatalogueIndicator(boolean catalogueIndicator) {
		this.catalogueIndicator = catalogueIndicator;
	}
	public TextType getDescription() {
		return description;
	}
	public void setDescription(TextType description) {
		this.description = description;
	}
	public boolean isHazardousRiskIndicator() {
		return hazardousRiskIndicator;
	}
	public void setHazardousRiskIndicator(boolean hazardousRiskIndicator) {
		this.hazardousRiskIndicator = hazardousRiskIndicator;
	}
	public TextType getKeyword() {
		return keyword;
	}
	public void setKeyword(TextType keyword) {
		this.keyword = keyword;
	}
	public NameType getModelName() {
		return modelName;
	}
	public void setModelName(NameType modelName) {
		this.modelName = modelName;
	}
	public NameType getName() {
		return name;
	}
	public void setName(NameType name) {
		this.name = name;
	}
	public QuantityType getPackQuantity() {
		return packQuantity;
	}
	public void setPackQuantity(QuantityType packQuantity) {
		this.packQuantity = packQuantity;
	}
	public BigDecimal getPackSizeNumeric() {
		return packSizeNumeric;
	}
	public void setPackSizeNumeric(BigDecimal packSizeNumeric) {
		this.packSizeNumeric = packSizeNumeric;
	}
	public AddressEntity getOriginAddress() {
		return originAddress;
	}
	public void setOriginAddress(AddressEntity originAddress) {
		this.originAddress = originAddress;
	}
	public List<CertificateEntity> getCertificates() {
		return certificates;
	}
	public void setCertificates(List<CertificateEntity> certificates) {
		this.certificates = certificates;
	}
	public List<CommodityClassificationEntity> getCommodityClassifications() {
		return commodityClassifications;
	}
	public void setCommodityClassifications(List<CommodityClassificationEntity> commodityClassifications) {
		this.commodityClassifications = commodityClassifications;
	}
	public CountryEntity getOriginCountry() {
		return originCountry;
	}
	public void setOriginCountry(CountryEntity originCountry) {
		this.originCountry = originCountry;
	}
	public List<DimensionEntity> getDimensions() {
		return dimensions;
	}
	public void setDimensions(List<DimensionEntity> dimensions) {
		this.dimensions = dimensions;
	}
	public DocumentReferenceEntity getItemSpecificationDocumentReference() {
		return itemSpecificationDocumentReference;
	}
	public void setItemSpecificationDocumentReference(DocumentReferenceEntity itemSpecificationDocumentReference) {
		this.itemSpecificationDocumentReference = itemSpecificationDocumentReference;
	}
	public DocumentReferenceEntity getCatalogueDocumentReference() {
		return catalogueDocumentReference;
	}
	public void setCatalogueDocumentReference(DocumentReferenceEntity catalogueDocumentReference) {
		this.catalogueDocumentReference = catalogueDocumentReference;
	}
	public List<HazardousItemEntity> getHazardousItems() {
		return hazardousItems;
	}
	public void setHazardousItems(List<HazardousItemEntity> hazardousItems) {
		this.hazardousItems = hazardousItems;
	}
	public ItemIdentificationMappingEntity getAdditionalItemIdentification() {
		return additionalItemIdentification;
	}
	public void setAdditionalItemIdentification(ItemIdentificationMappingEntity additionalItemIdentification) {
		this.additionalItemIdentification = additionalItemIdentification;
	}
	public ItemIdentificationMappingEntity getBuyersItemIdentification() {
		return buyersItemIdentification;
	}
	public void setBuyersItemIdentification(ItemIdentificationMappingEntity buyersItemIdentification) {
		this.buyersItemIdentification = buyersItemIdentification;
	}
	public ItemPropertyEntity getAdditionalItemProperty() {
		return additionalItemProperty;
	}
	public void setAdditionalItemProperty(ItemPropertyEntity additionalItemProperty) {
		this.additionalItemProperty = additionalItemProperty;
	}
	public PartyEntity getManufacturerParty() {
		return manufacturerParty;
	}
	public void setManufacturerParty(PartyEntity manufacturerParty) {
		this.manufacturerParty = manufacturerParty;
	}
	public PartyEntity getInformationContentProviderParty() {
		return informationContentProviderParty;
	}
	public void setInformationContentProviderParty(PartyEntity informationContentProviderParty) {
		this.informationContentProviderParty = informationContentProviderParty;
	}
	public List<TransactionConditionsEntity> getTransactionConditionses() {
		return transactionConditionses;
	}
	public void setTransactionConditionses(List<TransactionConditionsEntity> transactionConditionses) {
		this.transactionConditionses = transactionConditionses;
	}
	public TaxCategoryEntity getClassifiedTaxCategory() {
		return classifiedTaxCategory;
	}
	public void setClassifiedTaxCategory(TaxCategoryEntity classifiedTaxCategory) {
		this.classifiedTaxCategory = classifiedTaxCategory;
	}
	public ItemIdentificationMappingEntity getSellersItemIdentification() {
		return sellersItemIdentification;
	}
	public void setSellersItemIdentification(ItemIdentificationMappingEntity sellersItemIdentification) {
		this.sellersItemIdentification = sellersItemIdentification;
	}
	public ItemIdentificationMappingEntity getStandardItemIdentification() {
		return standardItemIdentification;
	}
	public void setStandardItemIdentification(ItemIdentificationMappingEntity standardItemIdentification) {
		this.standardItemIdentification = standardItemIdentification;
	}
	public ItemIdentificationMappingEntity getCatalogueItemIdentification() {
		return catalogueItemIdentification;
	}
	public void setCatalogueItemIdentification(ItemIdentificationMappingEntity catalogueItemIdentification) {
		this.catalogueItemIdentification = catalogueItemIdentification;
	}
	public ItemIdentificationMappingEntity getManufacturersItemIdentification() {
		return manufacturersItemIdentification;
	}
	public void setManufacturersItemIdentification(ItemIdentificationMappingEntity manufacturersItemIdentification) {
		this.manufacturersItemIdentification = manufacturersItemIdentification;
	}
	public List<ItemInstanceEntity> getItemInstances() {
		return itemInstances;
	}
	public void setItemInstances(List<ItemInstanceEntity> itemInstances) {
		this.itemInstances = itemInstances;
	}

	

}
