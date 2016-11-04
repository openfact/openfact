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
import org.openfact.models.jpa.entities.ubl.common.DimensionEntity;
import org.openfact.models.jpa.entities.ubl.common.ItemIdentificationEntity;
import org.openfact.models.jpa.entities.ubl.common.PhysicalAttributeEntity;
import org.openfact.models.ubl.common.DimensionModel;
import org.openfact.models.ubl.common.ItemIdentificationModel;
import org.openfact.models.ubl.common.PartyModel;
import org.openfact.models.ubl.common.PhysicalAttributeModel;

public class ItemIdentificationAdapter
        implements ItemIdentificationModel, JpaModel<ItemIdentificationEntity> {

    protected static final Logger logger = Logger.getLogger(ItemIdentificationAdapter.class);
    protected ItemIdentificationEntity itemIdentification;
    protected EntityManager em;
    protected OpenfactSession session;

    public ItemIdentificationAdapter(OpenfactSession session, EntityManager em,
            ItemIdentificationEntity itemIdentification) {
        this.session = session;
        this.em = em;
        this.itemIdentification = itemIdentification;
    }

    @Override
    public String getID() {
        return this.itemIdentification.getID();
    }

    @Override
    public void setID(String value) {
        this.itemIdentification.setID(value);
    }

    @Override
    public String getExtendedID() {
        return this.itemIdentification.getExtendedID();
    }

    @Override
    public void setExtendedID(String value) {
        this.itemIdentification.setExtendedID(value);
    }

    @Override
    public List<PhysicalAttributeModel> getPhysicalAttribute() {
        return itemIdentification.getPhysicalAttribute().stream()
                .map(f -> new PhysicalAttributeAdapter(session, em, f)).collect(Collectors.toList());
    }

    @Override
    public void setPhysicalAttribute(List<PhysicalAttributeModel> physicalAttribute) {
        List<PhysicalAttributeEntity> entities = physicalAttribute.stream()
                .map(f -> PhysicalAttributeAdapter.toEntity(f, em)).collect(Collectors.toList());
        itemIdentification.setPhysicalAttribute(entities);
    }

    @Override
    public List<DimensionModel> getMeasurementDimension() {
        return itemIdentification.getMeasurementDimension().stream()
                .map(f -> new DimensionAdapter(session, em, f)).collect(Collectors.toList());
    }

    @Override
    public void setMeasurementDimension(List<DimensionModel> measurementDimension) {
        List<DimensionEntity> entities = measurementDimension.stream()
                .map(f -> DimensionAdapter.toEntity(f, em)).collect(Collectors.toList());
        this.itemIdentification.setMeasurementDimension(entities);
    }

    @Override
    public PartyModel getIssuerParty() {
        return new PartyAdapter(session, em, itemIdentification.getIssuerParty());
    }

    @Override
    public void setIssuerParty(PartyModel value) {
        this.itemIdentification.setIssuerParty(PartyAdapter.toEntity(value, em));
    }

    @Override
    public String getId() {
        return this.itemIdentification.getId();
    }

    @Override
    public ItemIdentificationEntity getEntity() {
        return itemIdentification;
    }

    public static ItemIdentificationEntity toEntity(ItemIdentificationModel model, EntityManager em) {
        if (model instanceof ItemIdentificationAdapter) {
            return ((ItemIdentificationAdapter) model).getEntity();
        }
        return em.getReference(ItemIdentificationEntity.class, model.getId());
    }

}
