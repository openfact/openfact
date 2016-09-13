package org.openfact.models.ubl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

public interface ItemModel {

    TextType getAdditionalInformation();

    void setAdditionalInformation(TextType additionalInformation);

    NameType getBrandName();

    void setBrandName(NameType brandName);

    boolean isCatalogueIndicator();

    void setCatalogueIndicator(boolean catalogueIndicator);

    TextType getDescription();

    void setDescription(TextType description);

    boolean isHazardousRiskIndicator();

    void setHazardousRiskIndicator(boolean hazardousRiskIndicator);

    TextType getKeyword();

    void setKeyword(TextType keyword);

    NameType getModelName();

    void setModelName(NameType modelName);

    NameType getName();

    void setName(NameType name);

    QuantityType getPackQuantity();

    void setPackQuantity(QuantityType packQuantity);

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
