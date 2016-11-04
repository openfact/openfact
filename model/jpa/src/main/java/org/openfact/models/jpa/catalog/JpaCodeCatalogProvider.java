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

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.catalog.CodeCatalogModel;
import org.openfact.models.catalog.CodeCatalogProvider;
import org.openfact.models.jpa.entities.catalog.CodeCatalogEntity;

public class JpaCodeCatalogProvider implements CodeCatalogProvider {

    private static final String LOCALE = "locale";
    private static final String TYPE = "type";
    private static final String CODE = "code";
    private static final String DESCRIPTION = "description";

    protected static final Logger logger = Logger.getLogger(JpaCodeCatalogProvider.class);
    private final OpenfactSession session;
    protected EntityManager em;

    public JpaCodeCatalogProvider(OpenfactSession session, EntityManager em) {
        this.session = session;
        this.em = em;
    }

    @Override
    public void close() {
    }

    @Override
    public CodeCatalogModel addCodeCatalog(String locale, String type, String code, String description) {
        CodeCatalogEntity catalog = new CodeCatalogEntity();
        catalog.setLocale(locale);
        catalog.setType(type);
        catalog.setCode(code);
        catalog.setDescription(description);
        em.persist(catalog);
        em.flush();

        return new CodeCatalogAdapter(session, em, catalog);
    }

    @Override
    public CodeCatalogModel getCodeCatalogById(String id) {
        TypedQuery<CodeCatalogEntity> query = em.createNamedQuery("getCodeCatalogById",
                CodeCatalogEntity.class);
        query.setParameter("id", id);
        List<CodeCatalogEntity> entities = query.getResultList();
        if (entities.size() == 0)
            return null;
        return new CodeCatalogAdapter(session, em, entities.get(0));
    }

    @Override
    public boolean removeCodeCatalog(CodeCatalogModel codeCatalog) {
        CodeCatalogEntity codeCatalogEntity = em.find(CodeCatalogEntity.class, codeCatalog.getId());
        if (codeCatalogEntity == null)
            return false;
        em.remove(codeCatalogEntity);
        em.flush();
        return true;
    }

    @Override
    public List<CodeCatalogModel> getCodeCatalogs(Integer firstResult, Integer maxResults) {
        String queryName = "getAllCodeCatalogs";

        TypedQuery<CodeCatalogEntity> query = em.createNamedQuery(queryName, CodeCatalogEntity.class);
        if (firstResult != -1) {
            query.setFirstResult(firstResult);
        }
        if (maxResults != -1) {
            query.setMaxResults(maxResults);
        }
        List<CodeCatalogEntity> results = query.getResultList();
        return results.stream().map(f -> new CodeCatalogAdapter(session, em, f)).collect(Collectors.toList());
    }

    @Override
    public List<CodeCatalogModel> searchForCodeCatalog(String filterText, Integer firstResult,
            Integer maxResults) {
        TypedQuery<CodeCatalogEntity> query = em.createNamedQuery("searchForCodeCatalog",
                CodeCatalogEntity.class);
        query.setParameter("filterText", "%" + filterText.toLowerCase() + "%");
        if (firstResult != -1) {
            query.setFirstResult(firstResult);
        }
        if (maxResults != -1) {
            query.setMaxResults(maxResults);
        }
        List<CodeCatalogEntity> results = query.getResultList();
        return results.stream().map(f -> new CodeCatalogAdapter(session, em, f)).collect(Collectors.toList());
    }

    @Override
    public List<CodeCatalogModel> searchForCodeCatalog(Map<String, String> attributes, Integer firstResult,
            Integer maxResults) {
        StringBuilder builder = new StringBuilder("select u from CodeCatalogEntity u");
        for (Map.Entry<String, String> entry : attributes.entrySet()) {
            String attribute = null;
            String parameterName = null;
            if (entry.getKey().equals(CodeCatalogModel.CODE)) {
                attribute = "lower(u.code)";
                parameterName = JpaCodeCatalogProvider.CODE;
            } else if (entry.getKey().equalsIgnoreCase(CodeCatalogModel.DESCRIPTION)) {
                attribute = "lower(u.description)";
                parameterName = JpaCodeCatalogProvider.DESCRIPTION;
            } else if (entry.getKey().equalsIgnoreCase(CodeCatalogModel.LOCALE)) {
                attribute = "lower(u.locale)";
                parameterName = JpaCodeCatalogProvider.LOCALE;
            } else if (entry.getKey().equalsIgnoreCase(CodeCatalogModel.TYPE)) {
                attribute = "lower(u.type)";
                parameterName = JpaCodeCatalogProvider.TYPE;
            }
            if (attribute == null)
                continue;
            builder.append(" and ");
            builder.append(attribute).append(" like :").append(parameterName);
        }
        builder.append(" order by u.id");
        String q = builder.toString();
        TypedQuery<CodeCatalogEntity> query = em.createQuery(q, CodeCatalogEntity.class);
        for (Map.Entry<String, String> entry : attributes.entrySet()) {
            String parameterName = null;
            if (entry.getKey().equals(CodeCatalogModel.CODE)) {
                parameterName = JpaCodeCatalogProvider.CODE;
            } else if (entry.getKey().equalsIgnoreCase(CodeCatalogModel.DESCRIPTION)) {
                parameterName = JpaCodeCatalogProvider.DESCRIPTION;
            } else if (entry.getKey().equalsIgnoreCase(CodeCatalogModel.LOCALE)) {
                parameterName = JpaCodeCatalogProvider.LOCALE;
            } else if (entry.getKey().equalsIgnoreCase(CodeCatalogModel.TYPE)) {
                parameterName = JpaCodeCatalogProvider.TYPE;
            }
            if (parameterName == null)
                continue;
            query.setParameter(parameterName, "%" + entry.getValue().toLowerCase() + "%");
        }
        if (firstResult != -1) {
            query.setFirstResult(firstResult);
        }
        if (maxResults != -1) {
            query.setMaxResults(maxResults);
        }
        List<CodeCatalogEntity> results = query.getResultList();
        return results.stream().map(f -> new CodeCatalogAdapter(session, em, f)).collect(Collectors.toList());
    }

    @Override
    public int getCodesCatalogCount() {
        Query query = em.createNamedQuery("getCodesCatalogCount");
        Long result = (Long) query.getSingleResult();
        return result.intValue();
    }

}
