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
import org.openfact.models.jpa.entities.ubl.common.CountryEntity;
import org.openfact.models.ubl.common.CountryModel;

public class CountryAdapter implements CountryModel, JpaModel<CountryEntity> {

    protected static final Logger logger = Logger.getLogger(CountryAdapter.class);
    protected CountryEntity country;
    protected EntityManager em;
    protected OpenfactSession session;

    public CountryAdapter(OpenfactSession session, EntityManager em, CountryEntity country) {
        this.session = session;
        this.em = em;
        this.country = country;
    }

    @Override
    public String getIdentificationCode() {
        return this.country.getIdentificationCode();
    }

    @Override
    public void setIdentificationCode(String value) {
        this.country.setIdentificationCode(value);
    }

    @Override
    public String getName() {
        return this.country.getName();
    }

    @Override
    public void setName(String value) {
        this.country.setName(value);
    }

    @Override
    public String getId() {
        return this.country.getId();
    }

    @Override
    public CountryEntity getEntity() {
        return this.country;
    }

    public static CountryEntity toEntity(CountryModel model, EntityManager em) {
        if (model instanceof CountryAdapter) {
            return ((CountryAdapter) model).getEntity();
        }
        return em.getReference(CountryEntity.class, model.getId());
    }
}
