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
import org.openfact.models.catalog.CountryCatalogModel;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.catalog.CountryCatalogEntity;

public class CountryCatalogAdapter implements CountryCatalogModel, JpaModel<CountryCatalogEntity> {

    protected static final Logger logger = Logger.getLogger(CountryCatalogAdapter.class);
    protected CountryCatalogEntity countryCatalog;
    protected EntityManager em;
    protected OpenfactSession session;

    public CountryCatalogAdapter(OpenfactSession session, EntityManager em,
            CountryCatalogEntity countryCatalog) {
        this.countryCatalog = countryCatalog;
        this.em = em;
        this.session = session;
    }

    @Override
    public CountryCatalogEntity getEntity() {
        return countryCatalog;
    }

    @Override
    public String getId() {
        return countryCatalog.getId();
    }

    @Override
    public String getName() {
        return countryCatalog.getName();
    }

    @Override
    public void setName(String name) {
        countryCatalog.setName(name);
    }

    @Override
    public String getShortName() {
        return countryCatalog.getShortName();
    }

    @Override
    public void setShortName(String shortName) {
        countryCatalog.setShortName(shortName);
    }

    @Override
    public String getAlpha2Code() {
        return countryCatalog.getAlpha2Code();
    }

    @Override
    public void setAlpha2Code(String alpha2Code) {
        countryCatalog.setAlpha2Code(alpha2Code);
    }

    @Override
    public String getAlpha3Code() {
        return countryCatalog.getAlpha3Code();
    }

    @Override
    public void setAlpha3Code(String alpha3Code) {
        countryCatalog.setAlpha3Code(alpha3Code);
    }

    @Override
    public String getNumericCode() {
        return countryCatalog.getNumericCode();
    }

    @Override
    public void setNumericCode(String numericCode) {
        countryCatalog.setNumericCode(numericCode);
    }

}
