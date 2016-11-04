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
import org.openfact.models.catalog.CurrencyCatalogModel;
import org.openfact.models.catalog.CurrencyCatalogProvider;
import org.openfact.models.jpa.entities.catalog.CurrencyCatalogEntity;

public class JpaCurrencyCatalogProvider implements CurrencyCatalogProvider {

    protected static final Logger logger = Logger.getLogger(JpaCurrencyCatalogProvider.class);
    private final OpenfactSession session;
    protected EntityManager em;

    public JpaCurrencyCatalogProvider(OpenfactSession session, EntityManager em) {
        this.session = session;
        this.em = em;
    }

    @Override
    public void close() {
    }

    @Override
    public CurrencyCatalogModel addCurrencyCatalog(String entity, String currency) {
        CurrencyCatalogEntity catalog = new CurrencyCatalogEntity();
        catalog.setEntityName(entity);
        catalog.setCurrency(currency);
        em.persist(catalog);
        em.flush();

        return new CurrencyCatalogAdapter(session, em, catalog);
    }

    @Override
    public int getCurrenciesCatalogCount() {
        Query query = em.createNamedQuery("getCurrenciesCatalogCount");
        Long result = (Long) query.getSingleResult();
        return result.intValue();
    }

}
