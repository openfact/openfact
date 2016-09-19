package org.openfact.models.jpa.ubl.common;

import javax.persistence.EntityManager;

import org.openfact.models.OpenfactSession;
import org.jboss.logging.Logger;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.ubl.common.ItemPropertyGroupModel;

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

    @Override
    public String getID() {
        return this.itemPropertyGroup.getID();
    }

    @Override
    public void setID(String value) {
        this.itemPropertyGroup.setID(value);
    }

    @Override
    public String getName() {
        return this.itemPropertyGroup.getName();
    }

    @Override
    public void setName(String value) {
        this.itemPropertyGroup.setName(value);
    }

    @Override
    public String getId() {
        return this.itemPropertyGroup.getId();
    }

    @Override
    public void setId(String value) {
        this.itemPropertyGroup.setId(value);
    }

}
