package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;

/**
 * A class to describe an item of trade. It includes a generic description
 * applicable to all examples of the item together with optional subsidiary
 * descriptions of any number of actual instances of the type.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:39 a. m.
 */
public class Item {

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
	private BigDecimal fackQuantity;
	/**
	 * The number of items in a pack of this item.
	 */
	private BigDecimal packSizeNumeric;
	private Address originAddress;
	private Certificate m_Certificate;	
	private CommodityClassification m_CommodityClassification;
	private Country qriginCountry;
	private Dimension m_Dimension;
	private DocumentReference itemSpecificationDocumentReference;
	private DocumentReference catalogueDocumentReference;
	private HazardousItem m_HazardousItem;
	private ItemIdentification additionalItemIdentification;
	private ItemIdentification buyersItemIdentification;
	private ItemProperty additionalItemProperty;
	private Party manufacturerParty;
	private Party informationContentProviderParty;

	public String getAdditionalInformation() {
		return additionalInformation;
	}

	public void setAdditionalInformation(String additionalInformation) {
		this.additionalInformation = additionalInformation;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public boolean isCatalogueIndicator() {
		return catalogueIndicator;
	}

	public void setCatalogueIndicator(boolean catalogueIndicator) {
		this.catalogueIndicator = catalogueIndicator;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isHazardousRiskIndicator() {
		return hazardousRiskIndicator;
	}

	public void setHazardousRiskIndicator(boolean hazardousRiskIndicator) {
		this.hazardousRiskIndicator = hazardousRiskIndicator;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getFackQuantity() {
		return fackQuantity;
	}

	public void setFackQuantity(BigDecimal fackQuantity) {
		this.fackQuantity = fackQuantity;
	}

	public BigDecimal getPackSizeNumeric() {
		return packSizeNumeric;
	}

	public void setPackSizeNumeric(BigDecimal packSizeNumeric) {
		this.packSizeNumeric = packSizeNumeric;
	}

	public Address getOriginAddress() {
		return originAddress;
	}

	public void setOriginAddress(Address originAddress) {
		this.originAddress = originAddress;
	}

	public Certificate getM_Certificate() {
		return m_Certificate;
	}

	public void setM_Certificate(Certificate m_Certificate) {
		this.m_Certificate = m_Certificate;
	}

	public CommodityClassification getM_CommodityClassification() {
		return m_CommodityClassification;
	}

	public void setM_CommodityClassification(CommodityClassification m_CommodityClassification) {
		this.m_CommodityClassification = m_CommodityClassification;
	}

	public Country getQriginCountry() {
		return qriginCountry;
	}

	public void setQriginCountry(Country qriginCountry) {
		this.qriginCountry = qriginCountry;
	}

	public Dimension getM_Dimension() {
		return m_Dimension;
	}

	public void setM_Dimension(Dimension m_Dimension) {
		this.m_Dimension = m_Dimension;
	}

	public DocumentReference getItemSpecificationDocumentReference() {
		return itemSpecificationDocumentReference;
	}

	public void setItemSpecificationDocumentReference(DocumentReference itemSpecificationDocumentReference) {
		this.itemSpecificationDocumentReference = itemSpecificationDocumentReference;
	}

	public DocumentReference getCatalogueDocumentReference() {
		return catalogueDocumentReference;
	}

	public void setCatalogueDocumentReference(DocumentReference catalogueDocumentReference) {
		this.catalogueDocumentReference = catalogueDocumentReference;
	}

	public HazardousItem getM_HazardousItem() {
		return m_HazardousItem;
	}

	public void setM_HazardousItem(HazardousItem m_HazardousItem) {
		this.m_HazardousItem = m_HazardousItem;
	}

	public ItemIdentification getAdditionalItemIdentification() {
		return additionalItemIdentification;
	}

	public void setAdditionalItemIdentification(ItemIdentification additionalItemIdentification) {
		this.additionalItemIdentification = additionalItemIdentification;
	}

	public ItemIdentification getBuyersItemIdentification() {
		return buyersItemIdentification;
	}

	public void setBuyersItemIdentification(ItemIdentification buyersItemIdentification) {
		this.buyersItemIdentification = buyersItemIdentification;
	}

	public ItemProperty getAdditionalItemProperty() {
		return additionalItemProperty;
	}

	public void setAdditionalItemProperty(ItemProperty additionalItemProperty) {
		this.additionalItemProperty = additionalItemProperty;
	}

	public Party getManufacturerParty() {
		return manufacturerParty;
	}

	public void setManufacturerParty(Party manufacturerParty) {
		this.manufacturerParty = manufacturerParty;
	}

	public Party getInformationContentProviderParty() {
		return informationContentProviderParty;
	}

	public void setInformationContentProviderParty(Party informationContentProviderParty) {
		this.informationContentProviderParty = informationContentProviderParty;
	}

	public TransactionConditions getM_TransactionConditions() {
		return m_TransactionConditions;
	}

	public void setM_TransactionConditions(TransactionConditions m_TransactionConditions) {
		this.m_TransactionConditions = m_TransactionConditions;
	}

	public TaxCategory getClassifiedTaxCategory() {
		return classifiedTaxCategory;
	}

	public void setClassifiedTaxCategory(TaxCategory classifiedTaxCategory) {
		this.classifiedTaxCategory = classifiedTaxCategory;
	}

	public ItemIdentification getSellersItemIdentification() {
		return sellersItemIdentification;
	}

	public void setSellersItemIdentification(ItemIdentification sellersItemIdentification) {
		this.sellersItemIdentification = sellersItemIdentification;
	}

	public ItemIdentification getStandardItemIdentification() {
		return standardItemIdentification;
	}

	public void setStandardItemIdentification(ItemIdentification standardItemIdentification) {
		this.standardItemIdentification = standardItemIdentification;
	}

	public ItemIdentification getCatalogueItemIdentification() {
		return catalogueItemIdentification;
	}

	public void setCatalogueItemIdentification(ItemIdentification catalogueItemIdentification) {
		this.catalogueItemIdentification = catalogueItemIdentification;
	}

	public ItemIdentification getManufacturersItemIdentification() {
		return manufacturersItemIdentification;
	}

	public void setManufacturersItemIdentification(ItemIdentification manufacturersItemIdentification) {
		this.manufacturersItemIdentification = manufacturersItemIdentification;
	}

	public ItemInstance getM_ItemInstance() {
		return m_ItemInstance;
	}

	public void setM_ItemInstance(ItemInstance m_ItemInstance) {
		this.m_ItemInstance = m_ItemInstance;
	}

	private TransactionConditions m_TransactionConditions;
	private TaxCategory classifiedTaxCategory;
	private ItemIdentification sellersItemIdentification;
	private ItemIdentification standardItemIdentification;
	private ItemIdentification catalogueItemIdentification;
	private ItemIdentification manufacturersItemIdentification;
	private ItemInstance m_ItemInstance;

}// end Item