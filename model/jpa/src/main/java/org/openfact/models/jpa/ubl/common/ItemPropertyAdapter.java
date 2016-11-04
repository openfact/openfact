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

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.ItemPropertyEntity;
import org.openfact.models.jpa.entities.ubl.common.ItemPropertyGroupEntity;
import org.openfact.models.ubl.common.ItemPropertyGroupModel;
import org.openfact.models.ubl.common.ItemPropertyModel;
import org.openfact.models.ubl.common.PeriodModel;

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

    @Override
    public String getName() {
        return this.itemProperty.getName();
    }

    @Override
    public void setName(String value) {
        this.itemProperty.setName(value);
    }

    @Override
    public String getValue() {
        return this.itemProperty.getValue();
    }

    @Override
    public void setValue(String value) {
        this.itemProperty.setValue(value);
    }

    @Override
    public PeriodModel getUsabilityPeriod() {
        return new PeriodAdapter(session, em, itemProperty.getUsabilityPeriod());
    }

    @Override
    public void setUsabilityPeriod(PeriodModel value) {
        this.itemProperty.setUsabilityPeriod(PeriodAdapter.toEntity(value, em));
    }

    @Override
    public List<ItemPropertyGroupModel> getItemPropertyGroup() {
        return itemProperty.getItemPropertyGroup().stream()
                .map(f -> new ItemPropertyGroupAdapter(session, em, f)).collect(Collectors.toList());
    }

    @Override
    public void setItemPropertyGroup(List<ItemPropertyGroupModel> itemPropertyGroup) {
        List<ItemPropertyGroupEntity> entities = itemPropertyGroup.stream()
                .map(f -> ItemPropertyGroupAdapter.toEntity(f, em)).collect(Collectors.toList());
        this.itemProperty.setItemPropertyGroup(entities);
    }

    @Override
    public String getId() {
        return this.itemProperty.getId();
    }

    public static ItemPropertyEntity toEntity(ItemPropertyModel model, EntityManager em) {
        if (model instanceof ItemPropertyAdapter) {
            return ((ItemPropertyAdapter) model).getEntity();
        }
        return em.getReference(ItemPropertyEntity.class, model.getId());
    }

    @Override
    public ItemPropertyEntity getEntity() {
        return itemProperty;
    }

}
