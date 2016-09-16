package org.openfact.representations.idm.ubl.common;

import java.math.BigDecimal;
import java.util.List;

public class ItemModel {
    protected List<String> Description;
    protected QuantityModel PackQuantity;
    protected BigDecimal PackSizeNumeric;
    protected boolean CatalogueIndicator;
    protected String Name;
    protected boolean HazardousRiskIndicator;
    protected String AdditionalInformation;
    protected List<String> Keyword;
    protected List<String> BrandName;
    protected List<String> ModelName;
    protected ItemIdentificationModel BuyersItemIdentification;
    protected ItemIdentificationModel SellersItemIdentification;
    protected List<ItemIdentificationModel> ManufacturersItemIdentification;
    protected ItemIdentificationModel StandardItemIdentification;
    protected ItemIdentificationModel CatalogueItemIdentification;
    protected List<ItemIdentificationModel> AdditionalItemIdentification;
    protected DocumentReferenceModel CatalogueDocumentReference;
    protected List<DocumentReferenceModel> ItemSpecificationDocumentReference;
    protected CountryModel OriginCountry;
    protected List<CommodityClassificationModel> CommodityClassification;
    protected List<TransactionConditionsModel> TransactionConditions;
    protected List<HazardousItemModel> HazardousItem;
    protected List<TaxCategoryModel> ClassifiedTaxCategory;
    protected List<ItemPropertyModel> AdditionalItemProperty;
    protected List<PartyModel> ManufacturerParty;
    protected PartyModel InformationContentProviderParty;
    protected List<AddressModel> OriginAddress;
    protected List<ItemInstanceModel> ItemInstance;
    protected String Id;
}