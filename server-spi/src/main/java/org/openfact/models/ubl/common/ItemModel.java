package org.openfact.models.ubl.common;

import java.util.List;

public interface ItemModel {

    List<DescriptionModel> getDescription();

    void setDescription(List<DescriptionModel> description);

    PackQuantityModel getPackQuantity();

    void setPackQuantity(PackQuantityModel value);

    PackSizeNumericModel getPackSizeNumeric();

    void setPackSizeNumeric(PackSizeNumericModel value);

    CatalogueIndicatorModel getCatalogueIndicator();

    void setCatalogueIndicator(CatalogueIndicatorModel value);

    NameModelCommBas getName();

    void setName(NameModelCommBas value);

    HazardousRiskIndicatorModel getHazardousRiskIndicator();

    void setHazardousRiskIndicator(HazardousRiskIndicatorModel value);

    AdditionalInformationModel getAdditionalInformation();

    void setAdditionalInformation(AdditionalInformationModel value);

    List<KeywordModel> getKeyword();

    void setKeyword(List<KeywordModel> keyword);

    List<BrandNameModel> getBrandName();

    void setBrandName(List<BrandNameModel> brandName);

    List<ModelNameModel> getModelName();

    void setModelName(List<ModelNameModel> modelName);

    ItemIdentificationModel getBuyersItemIdentification();

    void setBuyersItemIdentification(ItemIdentificationModel value);

    ItemIdentificationModel getSellersItemIdentification();

    void setSellersItemIdentification(ItemIdentificationModel value);

    List<ItemIdentificationModel> getManufacturersItemIdentification();

    void setManufacturersItemIdentification();

    ItemIdentificationModel getStandardItemIdentification();

    void setStandardItemIdentification(ItemIdentificationModel value);

    ItemIdentificationModel getCatalogueItemIdentification();

    void setCatalogueItemIdentification(ItemIdentificationModel value);

    List<ItemIdentificationModel> getAdditionalItemIdentification();

    void setAdditionalItemIdentification(List<ItemIdentificationModel> additionalItemIdentification);

    DocumentReferenceModel getCatalogueDocumentReference();

    void setCatalogueDocumentReference(DocumentReferenceModel value);

    List<DocumentReferenceModel> getItemSpecificationDocumentReference();

    void setItemSpecificationDocumentReference();

    CountryModel getOriginCountry();

    void setOriginCountry(CountryModel value);

    List<CommodityClassificationModel> getCommodityClassification();

    void setCommodityClassification(List<CommodityClassificationModel> commodityClassification);

    List<TransactionConditionsModel> getTransactionConditions();

    void setTransactionConditions(List<TransactionConditionsModel> transactionConditions);

    List<HazardousItemModel> getHazardousItem();

    void setHazardousItem(List<HazardousItemModel> hazardousItem);

    List<TaxCategoryModel> getClassifiedTaxCategory();

    void setClassifiedTaxCategory(List<TaxCategoryModel> classifiedTaxCategory);

    List<ItemPropertyModel> getAdditionalItemProperty();

    void setAdditionalItemProperty(List<ItemPropertyModel> additionalItemProperty);

    List<PartyModel> getManufacturerParty();

    void setManufacturerParty(List<PartyModel> manufacturerParty);

    PartyModel getInformationContentProviderParty();

    void setInformationContentProviderParty(PartyModel value);

    List<AddressModel> getOriginAddress();

    void setOriginAddress(List<AddressModel> originAddress);

    List<ItemInstanceModel> getItemInstance();

    void setItemInstance(List<ItemInstanceModel> itemInstance);

    String getId();

    void setId(String value);

}
