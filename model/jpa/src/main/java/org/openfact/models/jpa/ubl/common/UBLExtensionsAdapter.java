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
import org.openfact.models.jpa.entities.ubl.common.UBLExtensionEntity;
import org.openfact.models.jpa.entities.ubl.common.UBLExtensionsEntity;
import org.openfact.models.ubl.common.UBLExtensionModel;
import org.openfact.models.ubl.common.UBLExtensionsModel;

public class UBLExtensionsAdapter implements UBLExtensionsModel, JpaModel<UBLExtensionsEntity> {

    protected static final Logger logger = Logger.getLogger(UBLExtensionsAdapter.class);
    protected UBLExtensionsEntity uBLExtensions;
    protected EntityManager em;
    protected OpenfactSession session;

    public UBLExtensionsAdapter(OpenfactSession session, EntityManager em,
            UBLExtensionsEntity uBLExtensions) {
        this.session = session;
        this.em = em;
        this.uBLExtensions = uBLExtensions;
    }

    @Override
    public List<UBLExtensionModel> getUBLExtension() {
        return this.uBLExtensions.getUblExtension().stream().map(f -> new UBLExtensionAdapter(session, em, f))
                .collect(Collectors.toList());
    }

    @Override
    public void setUBLExtension(List<UBLExtensionModel> ublExtension) {
        List<UBLExtensionEntity> entities = ublExtension.stream()
                .map(f -> UBLExtensionAdapter.toEntity(f, em)).collect(Collectors.toList());
        this.uBLExtensions.setUblExtension(entities);
    }

    @Override
    public String getId() {
        return this.uBLExtensions.getId();
    }

    @Override
    public UBLExtensionsEntity getEntity() {
        return this.uBLExtensions;
    }

    public static UBLExtensionsEntity toEntity(UBLExtensionsModel model, EntityManager em) {
        if (model instanceof UBLExtensionsAdapter) {
            return ((UBLExtensionsAdapter) model).getEntity();
        }
        return em.getReference(UBLExtensionsEntity.class, model.getId());
    }

    @Override
    public UBLExtensionModel addUblExtension() {
        List<UBLExtensionEntity> entities = uBLExtensions.getUblExtension();
        UBLExtensionEntity entity = new UBLExtensionEntity();
        entities.add(entity);
        return new UBLExtensionAdapter(session, em, entity);
    }

}
