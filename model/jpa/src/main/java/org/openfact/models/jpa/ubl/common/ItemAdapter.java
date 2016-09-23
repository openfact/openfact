package org.openfact.models.jpa.ubl.common;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.AddressEntity;
import org.openfact.models.jpa.entities.ubl.common.CommodityClassificationEntity;
import org.openfact.models.jpa.entities.ubl.common.DocumentReferenceEntity;
import org.openfact.models.jpa.entities.ubl.common.HazardousItemEntity;
import org.openfact.models.jpa.entities.ubl.common.ItemEntity;
import org.openfact.models.jpa.entities.ubl.common.ItemIdentificationEntity;
import org.openfact.models.jpa.entities.ubl.common.ItemInstanceEntity;
import org.openfact.models.jpa.entities.ubl.common.ItemPropertyEntity;
import org.openfact.models.jpa.entities.ubl.common.PartyEntity;
import org.openfact.models.jpa.entities.ubl.common.TaxCategoryEntity;
import org.openfact.models.jpa.entities.ubl.common.TransactionConditionsEntity;
import org.openfact.models.ubl.common.AddressModel;
import org.openfact.models.ubl.common.CommodityClassificationModel;
import org.openfact.models.ubl.common.CountryModel;
import org.openfact.models.ubl.common.DocumentReferenceModel;
import org.openfact.models.ubl.common.HazardousItemModel;
import org.openfact.models.ubl.common.ItemIdentificationModel;
import org.openfact.models.ubl.common.ItemInstanceModel;
import org.openfact.models.ubl.common.ItemModel;
import org.openfact.models.ubl.common.ItemPropertyModel;
import org.openfact.models.ubl.common.PartyModel;
import org.openfact.models.ubl.common.QuantityModel;
import org.openfact.models.ubl.common.TaxCategoryModel;
import org.openfact.models.ubl.common.TransactionConditionsModel;

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

    @Override
    public ItemEntity getEntity() {
        return this.item;
    }

    @Override
    public List<String> getDescription() {
        return item.getDescription();
    }

    @Override
    public void setDescription(List<String> description) {
        this.item.setDescription(description);
    }

    @Override
    public QuantityModel getPackQuantity() {
        return new QuantityAdapter(session, em, item.getPackQuantity());
    }

    @Override
    public void setPackQuantity(QuantityModel value) {
        item.setPackQuantity(QuantityAdapter.toEntity(value, em));
    }

    @Override
    public BigDecimal getPackSizeNumeric() {
        return item.getPackSizeNumeric();
    }

    @Override
    public void setPackSizeNumeric(BigDecimal value) {
        item.setPackSizeNumeric(value);
    }

    @Override
    public boolean getCatalogueIndicator() {
        return item.isCatalogueIndicator();
    }

    @Override
    public void setCatalogueIndicator(boolean value) {
        item.setCatalogueIndicator(value);
    }

    @Override
    public String getName() {
        return item.getName();
    }

    @Override
    public void setName(String value) {
        item.setName(value);
    }

    @Override
    public boolean getHazardousRiskIndicator() {
        return item.isHazardousRiskIndicator();
    }

    @Override
    public void setHazardousRiskIndicator(boolean value) {
        item.setHazardousRiskIndicator(value);
    }

    @Override
    public String getAdditionalInformation() {
        return item.getAdditionalInformation();
    }

    @Override
    public void setAdditionalInformation(String value) {
        item.setAdditionalInformation(value);
    }

    @Override
    public List<String> getKeyword() {
        return item.getKeyword();
    }

    @Override
    public void setKeyword(List<String> keyword) {
        item.setKeyword(keyword);
    }

    @Override
    public List<String> getBrandName() {
        return item.getBrandName();
    }

    @Override
    public void setBrandName(List<String> brandName) {
        item.setBrandName(brandName);
    }

    @Override
    public List<String> getModelName() {
        return item.getModelName();
    }

    @Override
    public void setModelName(List<String> modelName) {
        item.setModelName(modelName);
    }

    @Override
    public ItemIdentificationModel getBuyersItemIdentification() {
        return new ItemIdentificationAdapter(session, em, item.getBuyersItemIdentification());
    }

    @Override
    public void setBuyersItemIdentification(ItemIdentificationModel value) {
        item.setBuyersItemIdentification(ItemIdentificationAdapter.toEntity(value, em));
    }

    @Override
    public ItemIdentificationModel getSellersItemIdentification() {
        return new ItemIdentificationAdapter(session, em, item.getSellersItemIdentification());
    }

    @Override
    public void setSellersItemIdentification(ItemIdentificationModel value) {
        item.setSellersItemIdentification(ItemIdentificationAdapter.toEntity(value, em));
    }

    @Override
    public List<ItemIdentificationModel> getManufacturersItemIdentification() {
        return item.getManufacturersItemIdentification().stream()
                .map(f -> new ItemIdentificationAdapter(session, em, f)).collect(Collectors.toList());
    }

    @Override
    public void setManufacturersItemIdentification(List<ItemIdentificationModel> items) {
        List<ItemIdentificationEntity> entities = items.stream()
                .map(f -> ItemIdentificationAdapter.toEntity(f, em)).collect(Collectors.toList());
        item.setManufacturersItemIdentification(entities);
    }

    @Override
    public ItemIdentificationModel getStandardItemIdentification() {
        return new ItemIdentificationAdapter(session, em, item.getStandardItemIdentification());
    }

    @Override
    public void setStandardItemIdentification(ItemIdentificationModel value) {
        item.setStandardItemIdentification(ItemIdentificationAdapter.toEntity(value, em));
    }

    @Override
    public ItemIdentificationModel getCatalogueItemIdentification() {
        return new ItemIdentificationAdapter(session, em, item.getCatalogueItemIdentification());
    }

    @Override
    public void setCatalogueItemIdentification(ItemIdentificationModel value) {
        item.setCatalogueItemIdentification(ItemIdentificationAdapter.toEntity(value, em));
    }

    @Override
    public List<ItemIdentificationModel> getAdditionalItemIdentification() {
        return item.getAdditionalItemIdentification().stream()
                .map(f -> new ItemIdentificationAdapter(session, em, f)).collect(Collectors.toList());
    }

    @Override
    public void setAdditionalItemIdentification(List<ItemIdentificationModel> additionalItemIdentification) {
        List<ItemIdentificationEntity> entities = additionalItemIdentification.stream()
                .map(f -> ItemIdentificationAdapter.toEntity(f, em)).collect(Collectors.toList());
        item.setAdditionalItemIdentification(entities);
    }

    @Override
    public DocumentReferenceModel getCatalogueDocumentReference() {
        return new DocumentReferenceAdapter(session, em, item.getCatalogueDocumentReference());
    }

    @Override
    public void setCatalogueDocumentReference(DocumentReferenceModel value) {
        item.setCatalogueDocumentReference(DocumentReferenceAdapter.toEntity(value, em));
    }

    @Override
    public List<DocumentReferenceModel> getItemSpecificationDocumentReference() {
        return item.getItemSpecificationDocumentReference().stream()
                .map(f -> new DocumentReferenceAdapter(session, em, f)).collect(Collectors.toList());
    }

    @Override
    public void setItemSpecificationDocumentReference(List<DocumentReferenceModel> items) {
        List<DocumentReferenceEntity> entities = items.stream()
                .map(f -> DocumentReferenceAdapter.toEntity(f, em)).collect(Collectors.toList());
        item.setItemSpecificationDocumentReference(entities);
    }

    @Override
    public CountryModel getOriginCountry() {
        return new CountryAdapter(session, em, item.getOriginCountry());
    }

    @Override
    public void setOriginCountry(CountryModel value) {
        item.setOriginCountry(CountryAdapter.toEntity(value, em));
    }

    @Override
    public List<CommodityClassificationModel> getCommodityClassification() {
        return item.getCommodityClassification().stream()
                .map(f -> new CommodityClassificationAdapter(session, em, f)).collect(Collectors.toList());
    }

    @Override
    public void setCommodityClassification(List<CommodityClassificationModel> commodityClassification) {
        List<CommodityClassificationEntity> entities = commodityClassification.stream()
                .map(f -> CommodityClassificationAdapter.toEntity(f, em)).collect(Collectors.toList());
        item.setCommodityClassification(entities);
    }

    @Override
    public List<TransactionConditionsModel> getTransactionConditions() {
        return item.getTransactionConditions().stream()
                .map(f -> new TransactionConditionsAdapter(session, em, f)).collect(Collectors.toList());
    }

    @Override
    public void setTransactionConditions(List<TransactionConditionsModel> transactionConditions) {
        List<TransactionConditionsEntity> entities = transactionConditions.stream()
                .map(f -> TransactionConditionsAdapter.toEntity(f, em)).collect(Collectors.toList());
        item.setTransactionConditions(entities);
    }

    @Override
    public List<HazardousItemModel> getHazardousItem() {
        return item.getHazardousItem().stream().map(f -> new HazardousItemAdapter(session, em, f))
                .collect(Collectors.toList());
    }

    @Override
    public void setHazardousItem(List<HazardousItemModel> hazardousItem) {
        List<HazardousItemEntity> entities = hazardousItem.stream()
                .map(f -> HazardousItemAdapter.toEntity(f, em)).collect(Collectors.toList());
        item.setHazardousItem(entities);
    }

    @Override
    public List<TaxCategoryModel> getClassifiedTaxCategory() {
        return item.getClassifiedTaxCategory().stream().map(f -> new TaxCategoryAdapter(session, em, f))
                .collect(Collectors.toList());
    }

    @Override
    public void setClassifiedTaxCategory(List<TaxCategoryModel> classifiedTaxCategory) {
        List<TaxCategoryEntity> entities = classifiedTaxCategory.stream()
                .map(f -> TaxCategoryAdapter.toEntity(f, em)).collect(Collectors.toList());
        item.setClassifiedTaxCategory(entities);
    }

    @Override
    public List<ItemPropertyModel> getAdditionalItemProperty() {
        return item.getAdditionalItemProperty().stream().map(f -> new ItemPropertyAdapter(session, em, f))
                .collect(Collectors.toList());
    }

    @Override
    public void setAdditionalItemProperty(List<ItemPropertyModel> additionalItemProperty) {
        List<ItemPropertyEntity> entities = additionalItemProperty.stream()
                .map(f -> ItemPropertyAdapter.toEntity(f, em)).collect(Collectors.toList());
        item.setAdditionalItemProperty(entities);
    }

    @Override
    public List<PartyModel> getManufacturerParty() {
        return item.getManufacturerParty().stream().map(f -> new PartyAdapter(session, em, f))
                .collect(Collectors.toList());
    }

    @Override
    public void setManufacturerParty(List<PartyModel> manufacturerParty) {
        List<PartyEntity> entities = manufacturerParty.stream().map(f -> PartyAdapter.toEntity(f, em))
                .collect(Collectors.toList());
        item.setManufacturerParty(entities);
    }

    @Override
    public PartyModel getInformationContentProviderParty() {
        return new PartyAdapter(session, em, item.getInformationContentProviderParty());
    }

    @Override
    public void setInformationContentProviderParty(PartyModel value) {
        item.setInformationContentProviderParty(PartyAdapter.toEntity(value, em));
    }

    @Override
    public List<AddressModel> getOriginAddress() {
        return item.getOriginAddress().stream().map(f -> new AddressAdapter(session, em, f))
                .collect(Collectors.toList());
    }

    @Override
    public void setOriginAddress(List<AddressModel> originAddress) {
        List<AddressEntity> entities = originAddress.stream().map(f -> AddressAdapter.toEntity(f, em))
                .collect(Collectors.toList());
        item.setOriginAddress(entities);
    }

    @Override
    public List<ItemInstanceModel> getItemInstance() {
        return item.getItemInstance().stream().map(f -> new ItemInstanceAdapter(session, em, f))
                .collect(Collectors.toList());
    }

    @Override
    public void setItemInstance(List<ItemInstanceModel> itemInstance) {
        List<ItemInstanceEntity> entities = itemInstance.stream()
                .map(f -> ItemInstanceAdapter.toEntity(f, em)).collect(Collectors.toList());
        item.setItemInstance(entities);
    }

    @Override
    public String getId() {
        return item.getId();
    }

    @Override
    public void setId(String value) {
        item.setId(value);
    }

    public static ItemEntity toEntity(ItemModel model, EntityManager em) {
        if (model instanceof ItemAdapter) {
            return ((ItemAdapter) model).getEntity();
        }
        return em.getReference(ItemEntity.class, model.getId());
    }

}
