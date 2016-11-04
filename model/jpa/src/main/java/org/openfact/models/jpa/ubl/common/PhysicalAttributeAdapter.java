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

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.PhysicalAttributeEntity;
import org.openfact.models.ubl.common.PhysicalAttributeModel;

public class PhysicalAttributeAdapter implements PhysicalAttributeModel, JpaModel<PhysicalAttributeEntity> {

    protected static final Logger logger = Logger.getLogger(PhysicalAttributeAdapter.class);
    protected PhysicalAttributeEntity physicalAttribute;
    protected EntityManager em;
    protected OpenfactSession session;

    public PhysicalAttributeAdapter(OpenfactSession session, EntityManager em,
            PhysicalAttributeEntity physicalAttribute) {
        this.session = session;
        this.em = em;
        this.physicalAttribute = physicalAttribute;
    }

    @Override
    public String getAttributeID() {
        return this.physicalAttribute.getAttributeID();
    }

    @Override
    public void setAttributeID(String value) {
        this.physicalAttribute.setAttributeID(value);
    }

    @Override
    public String getPositionCode() {
        return this.physicalAttribute.getPositionCode();
    }

    @Override
    public void setPositionCode(String value) {
        this.physicalAttribute.setPositionCode(value);
    }

    @Override
    public String getDescriptionCode() {
        return this.physicalAttribute.getDescriptionCode();
    }

    @Override
    public void setDescriptionCode(String value) {
        this.physicalAttribute.setDescriptionCode(value);
    }

    @Override
    public List<String> getDescription() {
        return this.physicalAttribute.getDescription();
    }

    @Override
    public void setDescription(List<String> description) {
        this.physicalAttribute.setDescription(description);
    }

    @Override
    public String getId() {
        return this.physicalAttribute.getId();
    }

    @Override
    public PhysicalAttributeEntity getEntity() {

        return physicalAttribute;
    }

    public static PhysicalAttributeEntity toEntity(PhysicalAttributeModel model, EntityManager em) {
        if (model instanceof PhysicalAttributeAdapter) {
            return ((PhysicalAttributeAdapter) model).getEntity();
        }
        return em.getReference(PhysicalAttributeEntity.class, model.getId());
    }

}
