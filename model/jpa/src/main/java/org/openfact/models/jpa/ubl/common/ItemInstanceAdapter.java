package org.openfact.models.jpa.ubl.common;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

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

    String getProductTraceID() {
        return this.itemInstance.getProductTraceID();
    }

    void setProductTraceID(String value) {
        this.itemInstance.setProductTraceID(value);
    }

    LocalDate getManufactureDate() {
        return this.itemInstance.getManufactureDate();
    }

    void setManufactureDate(LocalDate value) {
        this.itemInstance.setManufactureDate(value);
    }

    LocalTime getManufactureTime() {
        return this.itemInstance.getManufactureTime();
    }

    void setManufactureTime(LocalTime value) {
        this.itemInstance.setManufactureTime(value);
    }

    String getRegistrationID() {
        return this.itemInstance.getRegistrationID();
    }

    void setRegistrationID(String value) {
        this.itemInstance.setRegistrationID(value);
    }

    String getSerialID() {
        return this.itemInstance.getSerialID();
    }

    void setSerialID(String value) {
        this.itemInstance.setSerialID(value);
    }

    List<ItemPropertyAdapter> getAdditionalItemProperty() {
        return this.itemInstance.getAdditionalItemProperty();
    }

    void setAdditionalItemProperty(List<ItemPropertyAdapter> additionalItemProperty) {
        this.itemInstance.setAdditionalItemProperty(additionalItemProperty);
    }

    LotIdentificationAdapter getLotIdentification() {
        return this.itemInstance.getLotIdentification();
    }

    void setLotIdentification(LotIdentificationAdapter value) {
        this.itemInstance.setLotIdentification(value);
    }

    String getId() {
        return this.itemInstance.getId();
    }

    void setId(String value) {
        this.itemInstance.setId(value);
    }

}
