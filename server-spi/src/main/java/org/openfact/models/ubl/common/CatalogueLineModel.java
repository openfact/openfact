package org.openfact.models.ubl.common;

import java.util.List;

public interface CatalogueLineModel {

    IDModel getID();

    void setID(IDModel value);

    ActionCodeModel getActionCode();

    void setActionCode(ActionCodeModel value);

    LifeCycleStatusCodeModel getLifeCycleStatusCode();

    void setLifeCycleStatusCode(LifeCycleStatusCodeModel value);

    ContractSubdivisionModel getContractSubdivision();

    void setContractSubdivision(ContractSubdivisionModel value);

    List<NoteModel> getNote();

    void setNote(List<NoteModel> note);

    OrderableIndicatorModel getOrderableIndicator();

    void setOrderableIndicator(OrderableIndicatorModel value);

    OrderableUnitModel getOrderableUnit();

    void setOrderableUnit(OrderableUnitModel value);

    ContentUnitQuantityModel getContentUnitQuantity();

    void setContentUnitQuantity(ContentUnitQuantityModel value);

    OrderQuantityIncrementNumericModel getOrderQuantityIncrementNumeric();

    void setOrderQuantityIncrementNumeric(OrderQuantityIncrementNumericModel value);

    MinimumOrderQuantityModel getMinimumOrderQuantity();

    void setMinimumOrderQuantity(MinimumOrderQuantityModel value);

    MaximumOrderQuantityModel getMaximumOrderQuantity();

    void setMaximumOrderQuantity(MaximumOrderQuantityModel value);

    List<WarrantyInformationModel> getWarrantyInformation();

    void setWarrantyInformation(List<WarrantyInformationModel> warrantyInformation);

    PackLevelCodeModel getPackLevelCode();

    void setPackLevelCode(PackLevelCodeModel value);

    CustomerPartyModel getContractorCustomerParty();

    void setContractorCustomerParty(CustomerPartyModel value);

    SupplierPartyModel getSellerSupplierParty();

    void setSellerSupplierParty(SupplierPartyModel value);

    PartyModel getWarrantyParty();

    void setWarrantyParty(PartyModel value);

    PeriodModel getWarrantyValidityPeriod();

    void setWarrantyValidityPeriod(PeriodModel value);

    PeriodModel getLineValidityPeriod();

    void setLineValidityPeriod(PeriodModel value);

    List<ItemComparisonModel> getItemComparison();

    void setItemComparison(List<ItemComparisonModel> itemComparison);

    List<RelatedItemModel> getComponentRelatedItem();

    void setComponentRelatedItem(List<RelatedItemModel> componentRelatedItem);

    List<RelatedItemModel> getAccessoryRelatedItem();

    void setAccessoryRelatedItem(List<RelatedItemModel> accessoryRelatedItem);

    List<RelatedItemModel> getRequiredRelatedItem();

    void setRequiredRelatedItem(List<RelatedItemModel> requiredRelatedItem);

    List<RelatedItemModel> getReplacementRelatedItem();

    void setReplacementRelatedItem(List<RelatedItemModel> replacementRelatedItem);

    List<RelatedItemModel> getComplementaryRelatedItem();

    void setComplementaryRelatedItem(List<RelatedItemModel> complementaryRelatedItem);

    List<ItemLocationQuantityModel> getRequiredItemLocationQuantity();

    void setRequiredItemLocationQuantity(List<ItemLocationQuantityModel> requiredItemLocationQuantity);

    List<DocumentReferenceModel> getDocumentReference();

    void setDocumentReference(List<DocumentReferenceModel> documentReference);

    ItemModel getItem();

    void setItem(ItemModel value);

    String getId();

    void setId(String value);

}
