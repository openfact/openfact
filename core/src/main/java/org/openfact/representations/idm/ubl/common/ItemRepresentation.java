package org.openfact.representations.idm.ubl.common;

import java.math.BigDecimal;
import java.util.List;

public class ItemRepresentation {
    private List<String> description;
    private QuantityRepresentation packQuantity;
    private BigDecimal packSizeNumeric;
    private boolean catalogueIndicator;
    private String name;
    private boolean hazardousRiskIndicator;
    private String additionalInformation;
    private List<String> keyword;
    private List<String> brandName;
    private List<String> representationName;
    private ItemIdentificationRepresentation buyersItemIdentification;
    private ItemIdentificationRepresentation sellersItemIdentification;
    private List<ItemIdentificationRepresentation> manufacturersItemIdentification;
    private ItemIdentificationRepresentation standardItemIdentification;
    private ItemIdentificationRepresentation catalogueItemIdentification;
    private List<ItemIdentificationRepresentation> additionalItemIdentification;
    private DocumentReferenceRepresentation catalogueDocumentReference;
    private List<DocumentReferenceRepresentation> itemSpecificationDocumentReference;
    private CountryRepresentation originCountry;
    private List<CommodityClassificationRepresentation> commodityClassification;
    private List<TransactionConditionsRepresentation> transactionConditions;
    private List<HazardousItemRepresentation> hazardousItem;
    private List<TaxCategoryRepresentation> classifiedTaxCategory;
    private List<ItemPropertyRepresentation> additionalItemProperty;
    private List<PartyRepresentation> manufacturerParty;
    private PartyRepresentation informationContentProviderParty;
    private List<AddressRepresentation> originAddress;
    private List<ItemInstanceRepresentation> itemInstance;
    private String id;
}
