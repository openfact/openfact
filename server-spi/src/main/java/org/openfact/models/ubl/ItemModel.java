package org.openfact.models.ubl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

public interface ItemModel {

    TextModel getAdditionalInformation();

    void setAdditionalInformation(TextModel additionalInformation);

    NameModel getBrandName();

    void setBrandName(NameModel brandName);

    boolean isCatalogueIndicator();

    void setCatalogueIndicator(boolean catalogueIndicator);

    TextModel getDescription();

    void setDescription(String description);

    void setDescription(TextModel description);

    boolean isHazardousRiskIndicator();

    void setHazardousRiskIndicator(boolean hazardousRiskIndicator);

    TextModel getKeyword();

    void setKeyword(TextModel keyword);

    NameModel getModelName();

    void setModelName(NameModel modelName);

    NameModel getName();

    void setName(NameModel name);

    QuantityModel getPackQuantity();

    void setPackQuantity(QuantityModel packQuantity);

    BigDecimal getPackSizeNumeric();

    void setPackSizeNumeric(BigDecimal packSizeNumeric);

    AddressModel getOriginAddress();

    void setOriginAddress(AddressModel originAddress);

    List<CertificateModel> getCertificates();

    void setCertificates(List<CertificateModel> certificates);

    List<CommodityClassificationModel> getCommodityClassifications();

    void setCommodityClassifications(List<CommodityClassificationModel> commodityClassifications);

    CountryModel getOriginCountry();

    void setOriginCountry(CountryModel originCountry);

    List<DimensionModel> getDimensions();

    void setDimensions(List<DimensionModel> dimensions);

    DocumentReferenceModel getItemSpecificationDocumentReference();

    void setItemSpecificationDocumentReference(DocumentReferenceModel itemSpecificationDocumentReference);

    DocumentReferenceModel getCatalogueDocumentReference();

    void setCatalogueDocumentReference(DocumentReferenceModel catalogueDocumentReference);

    List<HazardousItemModel> getHazardousItems();

    void setHazardousItems(List<HazardousItemModel> hazardousItems);

    ItemIdentificationModel getAdditionalItemIdentification();

    void setAdditionalItemIdentification(ItemIdentificationModel additionalItemIdentification);

    ItemIdentificationModel getBuyersItemIdentification();

    void setBuyersItemIdentification(ItemIdentificationModel buyersItemIdentification);

    ItemPropertyModel getAdditionalItemProperty();

    void setAdditionalItemProperty(ItemPropertyModel additionalItemProperty);

    PartyModel getManufacturerParty();

    void setManufacturerParty(PartyModel manufacturerParty);

    PartyModel getInformationContentProviderParty();

    void setInformationContentProviderParty(PartyModel informationContentProviderParty);

    List<TransactionConditionsModel> getTransactionConditionses();

    void setTransactionConditionses(List<TransactionConditionsModel> transactionConditionses);

    TaxCategoryModel getClassifiedTaxCategory();

    void setClassifiedTaxCategory(TaxCategoryModel classifiedTaxCategory);

    ItemIdentificationModel getSellersItemIdentification();

    void setSellersItemIdentification(ItemIdentificationModel sellersItemIdentification);

    ItemIdentificationModel getStandardItemIdentification();

    void setStandardItemIdentification(ItemIdentificationModel standardItemIdentification);

    ItemIdentificationModel getCatalogueItemIdentification();

    void setCatalogueItemIdentification(ItemIdentificationModel catalogueItemIdentification);

    ItemIdentificationModel getManufacturersItemIdentification();

    void setManufacturersItemIdentification(ItemIdentificationModel manufacturersItemIdentification);

    List<ItemInstanceModel> getItemInstances();

    void setItemInstances(List<ItemInstanceModel> itemInstances);

}
