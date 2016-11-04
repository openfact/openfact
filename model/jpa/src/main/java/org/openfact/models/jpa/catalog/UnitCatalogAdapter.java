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
package org.openfact.models.jpa.catalog;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.catalog.UnitCatalogModel;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.catalog.UnitCatalogEntity;

public class UnitCatalogAdapter implements UnitCatalogModel, JpaModel<UnitCatalogEntity> {

    protected static final Logger logger = Logger.getLogger(UnitCatalogAdapter.class);
    protected UnitCatalogEntity unitCatalog;
    protected EntityManager em;
    protected OpenfactSession session;

    public UnitCatalogAdapter(OpenfactSession session, EntityManager em, UnitCatalogEntity unitCatalog) {
        this.unitCatalog = unitCatalog;
        this.em = em;
        this.session = session;
    }

    @Override
    public UnitCatalogEntity getEntity() {
        return unitCatalog;
    }

    @Override
    public String getId() {
        return unitCatalog.getId();
    }

    @Override
    public String getName() {
        return unitCatalog.getName();
    }

    @Override
    public void setName(String name) {
        unitCatalog.setName(name);
    }

    @Override
    public String getSymbol() {
        return unitCatalog.getSymbol();
    }

    @Override
    public void setSymbol(String symbol) {
        unitCatalog.setSymbol(symbol);
    }

    @Override
    public String getDescription() {
        return getDescription();
    }

    @Override
    public void setDescription(String description) {
        unitCatalog.setDescription(description);
    }

}
