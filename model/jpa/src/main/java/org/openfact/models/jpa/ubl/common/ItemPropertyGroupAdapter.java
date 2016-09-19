package org.openfact.models.jpa.ubl.common;

public class ItemPropertyGroupAdapter implements ItemPropertyGroupModel, JpaModel<ItemPropertyGroupEntity> {

    protected static final Logger logger = Logger.getLogger(ItemPropertyGroupAdapter.class);
    protected ItemPropertyGroupEntity itemPropertyGroup;
    protected EntityManager em;
    protected OpenfactSession session;

    public ItemPropertyGroupAdapter(OpenfactSession session, EntityManager em,
            ItemPropertyGroupEntity itemPropertyGroup) {
        this.session = session;
        this.em = em;
        this.itemPropertyGroup = itemPropertyGroup;
    }

    String getID() {
        return this.itemPropertyGroup.getID();
    }

    void setID(String value) {
        this.itemPropertyGroup.setID(value);
    }

    String getName() {
        return this.itemPropertyGroup.getName();
    }

    void setName(String value) {
        this.itemPropertyGroup.setName(value);
    }

    String getId() {
        return this.itemPropertyGroup.getId();
    }

    void setId(String value) {
        this.itemPropertyGroup.setId(value);
    }

}
