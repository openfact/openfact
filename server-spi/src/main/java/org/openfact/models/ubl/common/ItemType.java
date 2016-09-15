package org.openfact.models.ubl.common;

import java.util.List;

public interface ItemType {

    List<DescriptionType> getDescription();

    void setDescription(List<DescriptionType> description);

    PackQuantityType getPackQuantity();

    void setPackQuantity(PackQuantityType value);

    PackSizeNumericType getPackSizeNumeric();

    void setPackSizeNumeric(PackSizeNumericType value);

    CatalogueIndicatorType getCatalogueIndicator();

    void setCatalogueIndicator(CatalogueIndicatorType value);

    NameTypeCommBas getName();

    void setName(NameTypeCommBas value);

    HazardousRiskIndicatorType getHazardousRiskIndicator();

    void setHazardousRiskIndicator(HazardousRiskIndicatorType value);

    AdditionalInformationType getAdditionalInformation();

    void setAdditionalInformation(AdditionalInformationType value);

    List<KeywordType> getKeyword();

    void setKeyword(List<KeywordType> keyword);

    List<BrandNameType> getBrandName();

    void setBrandName(List<BrandNameType> brandName);

    List<ModelNameType> getModelName();

    void setModelName(List<ModelNameType> modelName);

    ItemIdentificationType getBuyersItemIdentification();

    void setBuyersItemIdentification(ItemIdentificationType value);

    ItemIdentificationType getSellersItemIdentification();

    void setSellersItemIdentification(ItemIdentificationType value);

    List<ItemIdentificationType> getManufacturersItemIdentification();

    void setManufacturersItemIdentification();

    ItemIdentificationType getStandardItemIdentification();

    void setStandardItemIdentification(ItemIdentificationType value);

    ItemIdentificationType getCatalogueItemIdentification();

    void setCatalogueItemIdentification(ItemIdentificationType value);

    List<ItemIdentificationType> getAdditionalItemIdentification();

    void setAdditionalItemIdentification(List<ItemIdentificationType> additionalItemIdentification);

    DocumentReferenceType getCatalogueDocumentReference();

    void setCatalogueDocumentReference(DocumentReferenceType value);

    List<DocumentReferenceType> getItemSpecificationDocumentReference();

    void setItemSpecificationDocumentReference();

    CountryType getOriginCountry();

    void setOriginCountry(CountryType value);

    List<CommodityClassificationType> getCommodityClassification();

    void setCommodityClassification(List<CommodityClassificationType> commodityClassification);

    List<TransactionConditionsType> getTransactionConditions();

    void setTransactionConditions(List<TransactionConditionsType> transactionConditions);

    List<HazardousItemType> getHazardousItem();

    void setHazardousItem(List<HazardousItemType> hazardousItem);

    List<TaxCategoryType> getClassifiedTaxCategory();

    void setClassifiedTaxCategory(List<TaxCategoryType> classifiedTaxCategory);

    List<ItemPropertyType> getAdditionalItemProperty();

    void setAdditionalItemProperty(List<ItemPropertyType> additionalItemProperty);

    List<PartyType> getManufacturerParty();

    void setManufacturerParty(List<PartyType> manufacturerParty);

    PartyType getInformationContentProviderParty();

    void setInformationContentProviderParty(PartyType value);

    List<AddressType> getOriginAddress();

    void setOriginAddress(List<AddressType> originAddress);

    List<ItemInstanceType> getItemInstance();

    void setItemInstance(List<ItemInstanceType> itemInstance);

    String getId();

    void setId(String value);

}
