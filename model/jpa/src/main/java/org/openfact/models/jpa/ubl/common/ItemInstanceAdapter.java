package org.openfact.models.jpa.ubl.common;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.ItemInstanceEntity;
import org.openfact.models.jpa.entities.ubl.common.ItemPropertyEntity;
import org.openfact.models.ubl.common.ItemInstanceModel;
import org.openfact.models.ubl.common.ItemPropertyModel;
import org.openfact.models.ubl.common.LotIdentificationModel;

public class ItemInstanceAdapter implements ItemInstanceModel, JpaModel<ItemInstanceEntity> {

    protected static final Logger logger = Logger.getLogger(ItemInstanceAdapter.class);
    protected ItemInstanceEntity itemInstance;
    protected EntityManager em;
    protected OpenfactSession session;

    public ItemInstanceAdapter(OpenfactSession session, EntityManager em, ItemInstanceEntity itemInstance) {
        this.session = session;
        this.em = em;
        this.itemInstance = itemInstance;
    }

    @Override
    public String getProductTraceID() {
        return this.itemInstance.getProductTraceID();
    }

    @Override
    public void setProductTraceID(String value) {
        this.itemInstance.setProductTraceID(value);
    }

    @Override
    public LocalDate getManufactureDate() {
        return this.itemInstance.getManufactureDate();
    }

    @Override
    public void setManufactureDate(LocalDate value) {
        this.itemInstance.setManufactureDate(value);
    }

    @Override
    public LocalTime getManufactureTime() {
        return this.itemInstance.getManufactureTime();
    }

    @Override
    public void setManufactureTime(LocalTime value) {
        this.itemInstance.setManufactureTime(value);
    }

    @Override
    public String getRegistrationID() {
        return this.itemInstance.getRegistrationID();
    }

    @Override
    public void setRegistrationID(String value) {
        this.itemInstance.setRegistrationID(value);
    }

    @Override
    public String getSerialID() {
        return this.itemInstance.getSerialID();
    }

    @Override
    public void setSerialID(String value) {
        this.itemInstance.setSerialID(value);
    }

    @Override
    public List<ItemPropertyModel> getAdditionalItemProperty() {
        return itemInstance.getAdditionalItemProperty().stream()
                .map(f -> new ItemPropertyAdapter(session, em, f)).collect(Collectors.toList());
    }

    @Override
    public void setAdditionalItemProperty(List<ItemPropertyModel> additionalItemProperty) {
        List<ItemPropertyEntity> entities = additionalItemProperty.stream()
                .map(f -> ItemPropertyAdapter.toEntity(f, em)).collect(Collectors.toList());
        itemInstance.setAdditionalItemProperty(entities);
    }

    @Override
    public LotIdentificationModel getLotIdentification() {
        return new LotIdentificationAdapter(session, em, itemInstance.getLotIdentification());
    }

    @Override
    public void setLotIdentification(LotIdentificationModel value) {
        this.itemInstance.setLotIdentification(LotIdentificationAdapter.toEntity(value, em));
    }

    @Override
    public String getId() {
        return this.itemInstance.getId();
    }

    @Override
    public void setId(String value) {
        this.itemInstance.setId(value);
    }

    @Override
    public ItemInstanceEntity getEntity() {
        return itemInstance;
    }

    public static ItemInstanceEntity toEntity(ItemInstanceModel model, EntityManager em) {
        if (model instanceof ItemInstanceAdapter) {
            return ((ItemInstanceAdapter) model).getEntity();
        }
        return em.getReference(ItemInstanceEntity.class, model.getId());
    }

}
