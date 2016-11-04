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
import org.openfact.models.catalog.CurrencyCatalogModel;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.catalog.CurrencyCatalogEntity;

public class CurrencyCatalogAdapter implements CurrencyCatalogModel, JpaModel<CurrencyCatalogEntity> {

    protected static final Logger logger = Logger.getLogger(CurrencyCatalogAdapter.class);
    protected CurrencyCatalogEntity currencyCatalog;
    protected EntityManager em;
    protected OpenfactSession session;

    public CurrencyCatalogAdapter(OpenfactSession session, EntityManager em,
            CurrencyCatalogEntity currencyCatalog) {
        this.currencyCatalog = currencyCatalog;
        this.em = em;
        this.session = session;
    }

    @Override
    public CurrencyCatalogEntity getEntity() {
        return currencyCatalog;
    }

    @Override
    public String getId() {
        return currencyCatalog.getId();
    }

    @Override
    public void setId(String id) {
        currencyCatalog.setId(id);
    }

    @Override
    public String getEntityName() {
        return currencyCatalog.getEntityName();
    }

    @Override
    public void setEntityName(String entity) {
        currencyCatalog.setEntityName(entity);
    }

    @Override
    public String getCurrency() {
        return currencyCatalog.getCurrency();
    }

    @Override
    public void setCurrency(String currency) {
        currencyCatalog.setCurrency(currency);
    }

    @Override
    public String getAlphabeticCode() {
        return currencyCatalog.getAlphabeticCode();
    }

    @Override
    public void setAlphabeticCode(String alphabeticCode) {
        currencyCatalog.setAlphabeticCode(alphabeticCode);
    }

    @Override
    public String getNumericCode() {
        return currencyCatalog.getNumericCode();
    }

    @Override
    public void setNumericCode(String numericCode) {
        currencyCatalog.setNumericCode(numericCode);
    }

    @Override
    public int getMinorUnit() {
        return currencyCatalog.getMinorUnit();
    }

    @Override
    public void setMinorUnit(int minorUnit) {
        currencyCatalog.setMinorUnit(minorUnit);
    }

}
