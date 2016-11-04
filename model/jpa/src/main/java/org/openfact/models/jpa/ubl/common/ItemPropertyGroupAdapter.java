/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package org.openfact.models.jpa.ubl.common;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.ItemPropertyGroupEntity;
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
    public ItemPropertyGroupEntity getEntity() {
        return itemPropertyGroup;
    }

    public static ItemPropertyGroupEntity toEntity(ItemPropertyGroupModel model, EntityManager em) {
        if (model instanceof ItemPropertyGroupAdapter) {
            return ((ItemPropertyGroupAdapter) model).getEntity();
        }
        return em.getReference(ItemPropertyGroupEntity.class, model.getId());
    }

}
