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
package org.openfact.models.jpa;

import org.jboss.logging.Logger;
import org.openfact.migration.MigrationModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.OrganizationProvider;
import org.openfact.models.jpa.entities.OrganizationEntity;
import org.openfact.models.search.SearchCriteriaModel;
import org.openfact.models.search.SearchResultsModel;
import org.openfact.models.utils.OpenfactModelUtils;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JpaOrganizationProvider extends AbstractHibernateStorage implements OrganizationProvider {

    protected static final Logger logger = Logger.getLogger(JpaOrganizationProvider.class);
    private static final String NAME = "name";
    private static final String DESCRIPTION = "description";
    private static final String ASSIGNED_IDENTIFICATION_ID = "assignedIdentificationId";
    private static final String SUPPLIER_NAME = "supplierName";
    private static final String REGISTRATION_NAME = "registrationName";
    private final OpenfactSession session;
    protected EntityManager em;

    public JpaOrganizationProvider(OpenfactSession session, EntityManager em) {
        this.session = session;
        this.em = em;
    }

    @Override
    public void close() {
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public MigrationModel getMigrationModel() {
        return new MigrationModelAdapter(em);
    }

    @Override
    public OrganizationModel createOrganization(String name) {
        return createOrganization(OpenfactModelUtils.generateId(), name);
    }

    @Override
    public OrganizationModel createOrganization(String id, String name) {
        if (id == null) {
            id = OpenfactModelUtils.generateId();
        }
        OrganizationEntity organization = new OrganizationEntity();
        organization.setName(name);
        organization.setId(id);
        organization.setCreatedTimestamp(LocalDateTime.now());
        organization.setEnabled(true);
        em.persist(organization);
        em.flush();

        final OrganizationModel adapter = new OrganizationAdapter(session, em, organization);
        session.getOpenfactSessionFactory().publish(new OrganizationModel.OrganizationCreationEvent() {
            @Override
            public OrganizationModel getCreatedOrganization() {
                return adapter;
            }
        });

        return adapter;
    }

    @Override
    public OrganizationModel getOrganization(String id) {
        OrganizationEntity organization = em.find(OrganizationEntity.class, id);
        if (organization == null) {
            return null;
        }
        OrganizationAdapter adapter = new OrganizationAdapter(session, em, organization);
        return adapter;
    }

    @Override
    public OrganizationModel getOrganizationByName(String name) {
        TypedQuery<String> query = em.createNamedQuery("getOrganizationIdByName", String.class);
        query.setParameter("name", name);
        List<String> entities = query.getResultList();
        if (entities.size() == 0)
            return null;
        if (entities.size() > 1)
            throw new IllegalStateException("Should not be more than one organization with same name");
        String id = query.getResultList().get(0);

        return session.organizations().getOrganization(id);
    }

    @Override
    public boolean removeOrganization(String organizationId) {
        OrganizationEntity organization = em.find(OrganizationEntity.class, organizationId);
        if (organization == null) {
            return false;
        }
        em.refresh(organization);
        final OrganizationAdapter adapter = new OrganizationAdapter(session, em, organization);
        session.invoices().preRemove(adapter);
        session.creditNotes().preRemove(adapter);
        session.debitNotes().preRemove(adapter);

        em.flush();

        int num = em.createNamedQuery("deleteComponentConfigByOrganization").setParameter("organization", organization).executeUpdate();
        num = em.createNamedQuery("deleteComponentByOrganization").setParameter("organization", organization).executeUpdate();

        em.remove(organization);

        em.flush();
        em.clear();

        session.getOpenfactSessionFactory().publish(new OrganizationModel.OrganizationRemovedEvent() {
            @Override
            public OrganizationModel getOrganization() {
                return adapter;
            }

            @Override
            public OpenfactSession getOpenfactSession() {
                return session;
            }
        });

        return true;
    }

    @Override
    public boolean removeOrganization(OrganizationModel organization) {
        return removeOrganization(organization.getId());
    }

    @Override
    public List<OrganizationModel> getOrganizations() {
        return getOrganizations(-1, -1);
    }

    @Override
    public List<OrganizationModel> getOrganizations(Integer firstResult, Integer maxResults) {
        TypedQuery<String> query = em.createNamedQuery("getAllOrganizationIds", String.class);
        if (firstResult != -1) {
            query.setFirstResult(firstResult);
        }
        if (maxResults != -1) {
            query.setMaxResults(maxResults);
        }

        List<String> entities = query.getResultList();
        List<OrganizationModel> organizations = new ArrayList<>();
        for (String id : entities) {
            OrganizationModel organization = session.organizations().getOrganization(id);
            if (organization != null) {
                organizations.add(organization);
            }
        }
        return organizations;
    }

    @Override
    public int getOrganizationsCount() {
        Query query = em.createNamedQuery("getOrganizationsCount");
        Long result = (Long) query.getSingleResult();
        return result.intValue();
    }

    @Override
    public List<OrganizationModel> searchForOrganization(String filterText, Integer firstResult, Integer maxResults) {
        TypedQuery<OrganizationEntity> query = em.createNamedQuery("searchForOrganization", OrganizationEntity.class);
        query.setParameter("filterText", "%" + filterText.toLowerCase() + "%");
        if (firstResult != -1) {
            query.setFirstResult(firstResult);
        }
        if (maxResults != -1) {
            query.setMaxResults(maxResults);
        }
        List<OrganizationEntity> results = query.getResultList();
        return results.stream().map(f -> new OrganizationAdapter(session, em, f)).collect(Collectors.toList());
    }

    @Override
    public List<OrganizationModel> searchForOrganization(Map<String, String> attributes, Integer firstResult, Integer maxResults) {
        StringBuilder builder = new StringBuilder("select u from OrganizationEntity u");
        for (Map.Entry<String, String> entry : attributes.entrySet()) {
            String attribute = null;
            String parameterName = null;
            if (entry.getKey().equals(OrganizationModel.NAME)) {
                attribute = "lower(u.name)";
                parameterName = JpaOrganizationProvider.NAME;
            } else if (entry.getKey().equalsIgnoreCase(OrganizationModel.SUPPLIER_NAME)) {
                attribute = "lower(u.supplierName)";
                parameterName = JpaOrganizationProvider.SUPPLIER_NAME;
            } else if (entry.getKey().equalsIgnoreCase(OrganizationModel.REGISTRATION_NAME)) {
                attribute = "lower(u.registrationName)";
                parameterName = JpaOrganizationProvider.REGISTRATION_NAME;
            } else if (entry.getKey().equalsIgnoreCase(OrganizationModel.DESCRIPTION)) {
                attribute = "lower(u.description)";
                parameterName = JpaOrganizationProvider.DESCRIPTION;
            }
            if (attribute == null)
                continue;
            builder.append(" and ");
            builder.append(attribute).append(" like :").append(parameterName);
        }
        builder.append(" order by u.id");
        String q = builder.toString();
        TypedQuery<OrganizationEntity> query = em.createQuery(q, OrganizationEntity.class);
        for (Map.Entry<String, String> entry : attributes.entrySet()) {
            String parameterName = null;
            if (entry.getKey().equals(OrganizationModel.NAME)) {
                parameterName = JpaOrganizationProvider.NAME;
            } else if (entry.getKey().equalsIgnoreCase(OrganizationModel.SUPPLIER_NAME)) {
                parameterName = JpaOrganizationProvider.SUPPLIER_NAME;
            } else if (entry.getKey().equalsIgnoreCase(OrganizationModel.REGISTRATION_NAME)) {
                parameterName = JpaOrganizationProvider.REGISTRATION_NAME;
            } else if (entry.getKey().equalsIgnoreCase(OrganizationModel.DESCRIPTION)) {
                parameterName = JpaOrganizationProvider.DESCRIPTION;
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
        List<OrganizationEntity> results = query.getResultList();
        return results.stream().map(f -> new OrganizationAdapter(session, em, f)).collect(Collectors.toList());
    }

    @Override
    public SearchResultsModel<OrganizationModel> searchForOrganization(SearchCriteriaModel criteria) {
        SearchResultsModel<OrganizationEntity> entityResult = find(criteria, OrganizationEntity.class);
        List<OrganizationEntity> entities = entityResult.getModels();

        SearchResultsModel<OrganizationModel> searchResult = new SearchResultsModel<>();
        List<OrganizationModel> models = searchResult.getModels();

        entities.forEach(f -> models.add(new OrganizationAdapter(session, em, f)));
        searchResult.setTotalSize(entityResult.getTotalSize());
        return searchResult;
    }

    @Override
    public SearchResultsModel<OrganizationModel> searchForOrganization(SearchCriteriaModel criteria, String filterText) {
        SearchResultsModel<OrganizationEntity> entityResult = findFullText(criteria, OrganizationEntity.class, filterText, NAME, SUPPLIER_NAME, REGISTRATION_NAME);
        List<OrganizationEntity> entities = entityResult.getModels();

        SearchResultsModel<OrganizationModel> searchResult = new SearchResultsModel<>();
        List<OrganizationModel> models = searchResult.getModels();

        entities.forEach(f -> models.add(new OrganizationAdapter(session, em, f)));
        searchResult.setTotalSize(entityResult.getTotalSize());
        return searchResult;
    }

}
