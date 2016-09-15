package org.openfact.models.ubl.common;

import java.util.List;

public interface CatalogueLineType {

    IDType getID();

    void setID(IDType value);

    ActionCodeType getActionCode();

    void setActionCode(ActionCodeType value);

    LifeCycleStatusCodeType getLifeCycleStatusCode();

    void setLifeCycleStatusCode(LifeCycleStatusCodeType value);

    ContractSubdivisionType getContractSubdivision();

    void setContractSubdivision(ContractSubdivisionType value);

    List<NoteType> getNote();

    void setNote(List<NoteType> note);

    OrderableIndicatorType getOrderableIndicator();

    void setOrderableIndicator(OrderableIndicatorType value);

    OrderableUnitType getOrderableUnit();

    void setOrderableUnit(OrderableUnitType value);

    ContentUnitQuantityType getContentUnitQuantity();

    void setContentUnitQuantity(ContentUnitQuantityType value);

    OrderQuantityIncrementNumericType getOrderQuantityIncrementNumeric();

    void setOrderQuantityIncrementNumeric(OrderQuantityIncrementNumericType value);

    MinimumOrderQuantityType getMinimumOrderQuantity();

    void setMinimumOrderQuantity(MinimumOrderQuantityType value);

    MaximumOrderQuantityType getMaximumOrderQuantity();

    void setMaximumOrderQuantity(MaximumOrderQuantityType value);

    List<WarrantyInformationType> getWarrantyInformation();

    void setWarrantyInformation(List<WarrantyInformationType> warrantyInformation);

    PackLevelCodeType getPackLevelCode();

    void setPackLevelCode(PackLevelCodeType value);

    CustomerPartyType getContractorCustomerParty();

    void setContractorCustomerParty(CustomerPartyType value);

    SupplierPartyType getSellerSupplierParty();

    void setSellerSupplierParty(SupplierPartyType value);

    PartyType getWarrantyParty();

    void setWarrantyParty(PartyType value);

    PeriodType getWarrantyValidityPeriod();

    void setWarrantyValidityPeriod(PeriodType value);

    PeriodType getLineValidityPeriod();

    void setLineValidityPeriod(PeriodType value);

    List<ItemComparisonType> getItemComparison();

    void setItemComparison(List<ItemComparisonType> itemComparison);

    List<RelatedItemType> getComponentRelatedItem();

    void setComponentRelatedItem(List<RelatedItemType> componentRelatedItem);

    List<RelatedItemType> getAccessoryRelatedItem();

    void setAccessoryRelatedItem(List<RelatedItemType> accessoryRelatedItem);

    List<RelatedItemType> getRequiredRelatedItem();

    void setRequiredRelatedItem(List<RelatedItemType> requiredRelatedItem);

    List<RelatedItemType> getReplacementRelatedItem();

    void setReplacementRelatedItem(List<RelatedItemType> replacementRelatedItem);

    List<RelatedItemType> getComplementaryRelatedItem();

    void setComplementaryRelatedItem(List<RelatedItemType> complementaryRelatedItem);

    List<ItemLocationQuantityType> getRequiredItemLocationQuantity();

    void setRequiredItemLocationQuantity(List<ItemLocationQuantityType> requiredItemLocationQuantity);

    List<DocumentReferenceType> getDocumentReference();

    void setDocumentReference(List<DocumentReferenceType> documentReference);

    ItemType getItem();

    void setItem(ItemType value);

    String getId();

    void setId(String value);

}
