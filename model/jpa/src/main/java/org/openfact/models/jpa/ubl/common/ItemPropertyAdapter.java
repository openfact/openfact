package org.openfact.models.jpa.ubl.common;

import java.util.List;

public class ItemPropertyAdapter implements ItemPropertyModel, JpaModel<ItemPropertyEntity> {

    protected static final Logger logger = Logger.getLogger(ItemPropertyAdapter.class);
    protected ItemPropertyEntity itemProperty;
    protected EntityManager em;
    protected OpenfactSession session;

    public ItemPropertyAdapter(OpenfactSession session, EntityManager em, ItemPropertyEntity itemProperty) {
        this.session = session;
        this.em = em;
        this.itemProperty = itemProperty;
    }

    String getName() {
        return this.itemProperty.getName();
    }

    void setName(String value) {
        this.itemProperty.setName(value);
    }

    String getValue() {
        return this.itemProperty.getValue();
    }

    void setValue(String value) {
        this.itemProperty.setValue(value);
    }

    PeriodAdapter getUsabilityPeriod() {
        return this.itemProperty.getUsabilityPeriod();
    }

    void setUsabilityPeriod(PeriodAdapter value) {
        this.itemProperty.setUsabilityPeriod(value);
    }

    List<ItemPropertyGroupAdapter> getItemPropertyGroup() {
        return this.itemProperty.getItemPropertyGroup();
    }

    void setItemPropertyGroup(List<ItemPropertyGroupAdapter> itemPropertyGroup) {
        this.itemProperty.setItemPropertyGroup(itemPropertyGroup);
    }

    String getId() {
        return this.itemProperty.getId();
    }

    void setId(String value) {
        this.itemProperty.setId(value);
    }

}
