package org.openfact.representations.idm.ubl.common;

import java.math.BigDecimal;
import java.util.List;

public class ItemRepresentation {
    private List<String> Description;
    private QuantityRepresentation PackQuantity;
    private BigDecimal PackSizeNumeric;
    private boolean CatalogueIndicator;
    private String Name;
    private boolean HazardousRiskIndicator;
    private String AdditionalInformation;
    private List<String> Keyword;
    private List<String> BrandName;
    private List<String> RepresentationName;
    private ItemIdentificationRepresentation BuyersItemIdentification;
    private ItemIdentificationRepresentation SellersItemIdentification;
    private List<ItemIdentificationRepresentation> ManufacturersItemIdentification;
    private ItemIdentificationRepresentation StandardItemIdentification;
    private ItemIdentificationRepresentation CatalogueItemIdentification;
    private List<ItemIdentificationRepresentation> AdditionalItemIdentification;
    private DocumentReferenceRepresentation CatalogueDocumentReference;
    private List<DocumentReferenceRepresentation> ItemSpecificationDocumentReference;
    private CountryRepresentation OriginCountry;
    private List<CommodityClassificationRepresentation> CommodityClassification;
    private List<TransactionConditionsRepresentation> TransactionConditions;
    private List<HazardousItemRepresentation> HazardousItem;
    private List<TaxCategoryRepresentation> ClassifiedTaxCategory;
    private List<ItemPropertyRepresentation> AdditionalItemProperty;
    private List<PartyRepresentation> ManufacturerParty;
    private PartyRepresentation InformationContentProviderParty;
    private List<AddressRepresentation> OriginAddress;
    private List<ItemInstanceRepresentation> ItemInstance;
    private String Id;
}