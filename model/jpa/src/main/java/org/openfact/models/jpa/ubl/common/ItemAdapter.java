package org.openfact.models.jpa.ubl.common;

import java.math.BigDecimal;
import java.util.List;

public class ItemAdapter implements ItemModel, JpaModel<ItemEntity> {

    protected static final Logger logger = Logger.getLogger(ItemAdapter.class);
    protected ItemEntity item;
    protected EntityManager em;
    protected OpenfactSession session;

    public ItemAdapter(OpenfactSession session, EntityManager em, ItemEntity item) {
        this.session = session;
        this.em = em;
        this.item = item;
    }

    List<String> getDescription() {
        return this.item.getDescription();
    }

    void setDescription(List<String> description) {
        this.item.setDescription(description);
    }

    QuantityAdapter getPackQuantity() {
        return this.item.getPackQuantity();
    }

    void setPackQuantity(QuantityAdapter value) {
        this.item.setPackQuantity(value);
    }

    BigDecimal getPackSizeNumeric() {
        return this.item.getPackSizeNumeric();
    }

    void setPackSizeNumeric(BigDecimal value) {
        this.item.setPackSizeNumeric(value);
    }

    boolean getCatalogueIndicator() {
        return this.item.getCatalogueIndicator();
    }

    void setCatalogueIndicator(boolean value) {
        this.item.setCatalogueIndicator(value);
    }

    String getName() {
        return this.item.getName();
    }

    void setName(String value) {
        this.item.setName(value);
    }

    boolean getHazardousRiskIndicator() {
        return this.item.getHazardousRiskIndicator();
    }

    void setHazardousRiskIndicator(boolean value) {
        this.item.setHazardousRiskIndicator(value);
    }

    String getAdditionalInformation() {
        return this.item.getAdditionalInformation();
    }

    void setAdditionalInformation(String value) {
        this.item.setAdditionalInformation(value);
    }

    List<String> getKeyword() {
        return this.item.getKeyword();
    }

    void setKeyword(List<String> keyword) {
        this.item.setKeyword(keyword);
    }

    List<String> getBrandName() {
        return this.item.getBrandName();
    }

    void setBrandName(List<String> brandName) {
        this.item.setBrandName(brandName);
    }

    List<String> getAdapterName() {
        return this.item.getAdapterName();
    }

    void setAdapterName(List<String> modelName) {
        this.item.setAdapterName(modelName);
    }

    ItemIdentificationAdapter getBuyersItemIdentification() {
        return this.item.getBuyersItemIdentification();
    }

    void setBuyersItemIdentification(ItemIdentificationAdapter value) {
        this.item.setBuyersItemIdentification(value);
    }

    ItemIdentificationAdapter getSellersItemIdentification() {
        return this.item.getSellersItemIdentification();
    }

    void setSellersItemIdentification(ItemIdentificationAdapter value) {
        this.item.setSellersItemIdentification(value);
    }

    List<ItemIdentificationAdapter> getManufacturersItemIdentification() {
        return this.item.getManufacturersItemIdentification();
    }

    void setManufacturersItemIdentification(List<ItemIdentificationAdapter> items) {
        this.item.setManufacturersItemIdentification(items);
    }

    ItemIdentificationAdapter getStandardItemIdentification() {
        return this.item.getStandardItemIdentification();
    }

    void setStandardItemIdentification(ItemIdentificationAdapter value) {
        this.item.setStandardItemIdentification(value);
    }

    ItemIdentificationAdapter getCatalogueItemIdentification() {
        return this.item.getCatalogueItemIdentification();
    }

    void setCatalogueItemIdentification(ItemIdentificationAdapter value) {
        this.item.setCatalogueItemIdentification(value);
    }

    List<ItemIdentificationAdapter> getAdditionalItemIdentification() {
        return this.item.getAdditionalItemIdentification();
    }

    void setAdditionalItemIdentification(List<ItemIdentificationAdapter> additionalItemIdentification) {
        this.item.setAdditionalItemIdentification(additionalItemIdentification);
    }

    DocumentReferenceAdapter getCatalogueDocumentReference() {
        return this.item.getCatalogueDocumentReference();
    }

    void setCatalogueDocumentReference(DocumentReferenceAdapter value) {
        this.item.setCatalogueDocumentReference(value);
    }

    List<DocumentReferenceAdapter> getItemSpecificationDocumentReference() {
        return this.item.getItemSpecificationDocumentReference();
    }

    void setItemSpecificationDocumentReference(List<DocumentReferenceAdapter> items) {
        this.item.setItemSpecificationDocumentReference(items);
    }

    CountryAdapter getOriginCountry() {
        return this.item.getOriginCountry();
    }

    void setOriginCountry(CountryAdapter value) {
        this.item.setOriginCountry(value);
    }

    List<CommodityClassificationAdapter> getCommodityClassification() {
        return this.item.getCommodityClassification();
    }

    void setCommodityClassification(List<CommodityClassificationAdapter> commodityClassification) {
        this.item.setCommodityClassification(commodityClassification);
    }

    List<TransactionConditionsAdapter> getTransactionConditions() {
        return this.item.getTransactionConditions();
    }

    void setTransactionConditions(List<TransactionConditionsAdapter> transactionConditions) {
        this.item.setTransactionConditions(transactionConditions);
    }

    List<HazardousItemAdapter> getHazardousItem() {
        return this.item.getHazardousItem();
    }

    void setHazardousItem(List<HazardousItemAdapter> hazardousItem) {
        this.item.setHazardousItem(hazardousItem);
    }

    List<TaxCategoryAdapter> getClassifiedTaxCategory() {
        return this.item.getClassifiedTaxCategory();
    }

public class ItemAdapter implements ItemModel, JpaModel<ItemEntity> {

List<ItemPropertyAdapter> getAdditionalItemProperty(){return this.item.getAdditionalItemProperty();}

void setAdditionalItemProperty(List<ItemPropertyAdapter> additionalItemProperty){this.item.setAdditionalItemProperty(additionalItemProperty);}

List<PartyAdapter> getManufacturerParty(){return this.item.getManufacturerParty();}

void setManufacturerParty(List<PartyAdapter> manufacturerParty){this.item.setManufacturerParty(manufacturerParty);}

PartyAdapter getInformationContentProviderParty(){return this.item.getInformationContentProviderParty();}

void setInformationContentProviderParty(PartyAdapter value){this.item.setInformationContentProviderParty(value);}

List<AddressAdapter> getOriginAddress(){return this.item.getOriginAddress();}

void setOriginAddress(List<AddressAdapter> originAddress){this.item.setOriginAddress(originAddress);}

List<ItemInstanceAdapter> getItemInstance(){return this.item.getItemInstance();}

void setItemInstance(List<ItemInstanceAdapter> itemInstance){this.item.setItemInstance(itemInstance);}

String getId(){return this.item.getId();}

void setId(String value){this.item.setId(value);}

}
