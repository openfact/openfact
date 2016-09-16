package org.openfact.models.ubl.common;

import java.math.BigDecimal;
import java.util.List;

public interface ItemModel {

    List<String> getDescription();

    void setDescription(List<String> description);

    QuantityModel getPackQuantity();

    void setPackQuantity(QuantityModel value);

    BigDecimal getPackSizeNumeric();

    void setPackSizeNumeric(BigDecimal value);

    boolean getCatalogueIndicator();

    void setCatalogueIndicator(boolean value);

    String getName();

    void setName(String value);

    boolean getHazardousRiskIndicator();

    void setHazardousRiskIndicator(boolean value);

    String getAdditionalInformation();

    void setAdditionalInformation(String value);

    List<String> getKeyword();

    void setKeyword(List<String> keyword);

    List<String> getBrandName();

    void setBrandName(List<String> brandName);

    List<String> getModelName();

    void setModelName(List<String> modelName);

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
