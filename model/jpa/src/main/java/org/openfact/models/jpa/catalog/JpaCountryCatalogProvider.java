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
import javax.persistence.Query;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.catalog.CountryCatalogModel;
import org.openfact.models.catalog.CountryCatalogProvider;
import org.openfact.models.jpa.entities.catalog.CountryCatalogEntity;

public class JpaCountryCatalogProvider implements CountryCatalogProvider {

    protected static final Logger logger = Logger.getLogger(JpaCountryCatalogProvider.class);
    private final OpenfactSession session;
    protected EntityManager em;

    public JpaCountryCatalogProvider(OpenfactSession session, EntityManager em) {
        this.session = session;
        this.em = em;
    }

    @Override
    public void close() {
    }

    @Override
    public CountryCatalogModel addCountryCatalog(String name) {
        CountryCatalogEntity catalog = new CountryCatalogEntity();
        catalog.setName(name);
        em.persist(catalog);
        em.flush();

        return new CountryCatalogAdapter(session, em, catalog);
    }

    @Override
    public int getCountriesCatalogCount() {
        Query query = em.createNamedQuery("getCountriesCatalogCount");
        Long result = (Long) query.getSingleResult();
        return result.intValue();
    }

}
