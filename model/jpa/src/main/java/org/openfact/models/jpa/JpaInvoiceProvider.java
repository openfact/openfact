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

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.jboss.logging.Logger;
import org.openfact.models.InvoiceModel;
import org.openfact.models.InvoiceProvider;
import org.openfact.models.ModelDuplicateException;
import org.openfact.models.ModelException;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.ScrollModel;
import org.openfact.models.enums.RequiredAction;
import org.openfact.models.jpa.entities.InvoiceEntity;
import org.openfact.models.search.SearchCriteriaFilterOperator;
import org.openfact.models.search.SearchCriteriaModel;
import org.openfact.models.search.SearchResultsModel;

public class JpaInvoiceProvider extends AbstractHibernateStorage implements InvoiceProvider {

    protected static final Logger logger = Logger.getLogger(JpaInvoiceProvider.class);

    private static final String DOCUMENT_ID = "documentId";
    private static final String INVOICE_TYPE_CODE = "invoiceTypeCode";
    private static final String ISSUE_DATETIME = "issueDateTime";

    private final OpenfactSession session;
    protected EntityManager em;

    public JpaInvoiceProvider(OpenfactSession session, EntityManager em) {
        this.session = session;
        this.em = em;
    }

    @Override
    public void close() {
        // TODO Auto-generated method stub
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public InvoiceModel addInvoice(OrganizationModel organization, String documentId) {
        if (documentId == null) {
            throw new ModelException("Invalid documentId, Null value");
        }

        if (session.invoices().getInvoiceByID(organization, documentId) != null) {
            throw new ModelDuplicateException("Invoice documentId existed");
        }

        InvoiceEntity invoice = new InvoiceEntity();
        invoice.setDocumentId(documentId);
        invoice.setCreatedTimestamp(LocalDateTime.now());
        invoice.setOrganization(OrganizationAdapter.toEntity(organization, em));
        em.persist(invoice);
        em.flush();

        final InvoiceModel adapter = new InvoiceAdapter(session, organization, em, invoice);
        session.getOpenfactSessionFactory().publish(new InvoiceModel.InvoiceCreationEvent() {
            @Override
            public InvoiceModel getCreatedInvoice() {
                return adapter;
            }
        });

        return adapter;
    }

    @Override
    public InvoiceModel getInvoiceById(OrganizationModel organization, String id) {
        TypedQuery<InvoiceEntity> query = em.createNamedQuery("getOrganizationInvoiceById",
                InvoiceEntity.class);
        query.setParameter("id", id);
        query.setParameter("organizationId", organization.getId());
        List<InvoiceEntity> entities = query.getResultList();
        if (entities.size() == 0)
            return null;
        return new InvoiceAdapter(session, organization, em, entities.get(0));
    }

    @Override
    public InvoiceModel getInvoiceByID(OrganizationModel organization, String ID) {
        TypedQuery<InvoiceEntity> query = em.createNamedQuery("getOrganizationInvoiceByDocumentId",
                InvoiceEntity.class);
        query.setParameter("documentId", ID);
        query.setParameter("organizationId", organization.getId());
        List<InvoiceEntity> entities = query.getResultList();
        if (entities.size() == 0)
            return null;
        return new InvoiceAdapter(session, organization, em, entities.get(0));
    }

    @Override
    public boolean removeInvoice(OrganizationModel organization, String id) {
        return removeInvoice(organization, getInvoiceById(organization, id));
    }

    @Override
    public boolean removeInvoice(OrganizationModel organization, InvoiceModel invoice) {
        InvoiceEntity invoiceEntity = em.find(InvoiceEntity.class, invoice.getId());
        if (invoiceEntity == null)
            return false;
        removeInvoice(invoiceEntity);
        session.getOpenfactSessionFactory().publish(new InvoiceModel.InvoiceRemovedEvent() {
            @Override
            public InvoiceModel getInvoice() {
                return invoice;
            }

            @Override
            public OpenfactSession getOpenfactSession() {
                return session;
            }
        });
        return true;
    }

    private void removeInvoice(InvoiceEntity invoice) {
        String id = invoice.getId();
        invoice = em.find(InvoiceEntity.class, id);
        if (invoice != null) {
            em.remove(invoice);
        }

        em.flush();
    }

    @Override
    public List<InvoiceModel> getInvoices(OrganizationModel organization) {
        return getInvoices(organization, -1, -1);
    }

    @Override
    public List<InvoiceModel> getInvoices(OrganizationModel organization, Integer firstResult,
                                          Integer maxResults) {
        String queryName = "getAllInvoicesByOrganization";

        TypedQuery<InvoiceEntity> query = em.createNamedQuery(queryName, InvoiceEntity.class);
        query.setParameter("organizationId", organization.getId());
        if (firstResult != -1) {
            query.setFirstResult(firstResult);
        }
        if (maxResults != -1) {
            query.setMaxResults(maxResults);
        }
        List<InvoiceEntity> results = query.getResultList();
        List<InvoiceModel> invoices = results.stream()
                .map(f -> new InvoiceAdapter(session, organization, em, f)).collect(Collectors.toList());
        return invoices;
    }

    @Override
    public List<InvoiceModel> searchForInvoice(OrganizationModel organization, String filterText) {
        return searchForInvoice(organization, filterText, -1, -1);
    }

    @Override
    public List<InvoiceModel> searchForInvoice(OrganizationModel organization, String filterText,
                                               Integer firstResult, Integer maxResults) {
        TypedQuery<InvoiceEntity> query = em.createNamedQuery("searchForInvoice", InvoiceEntity.class);
        query.setParameter("organizationId", organization.getId());
        query.setParameter("search", "%" + filterText.toLowerCase() + "%");
        if (firstResult != -1) {
            query.setFirstResult(firstResult);
        }
        if (maxResults != -1) {
            query.setMaxResults(maxResults);
        }
        List<InvoiceEntity> results = query.getResultList();
        List<InvoiceModel> invoices = results.stream()
                .map(f -> new InvoiceAdapter(session, organization, em, f)).collect(Collectors.toList());
        return invoices;
    }

    @Override
    public SearchResultsModel<InvoiceModel> searchForInvoice(OrganizationModel organization,
                                                             SearchCriteriaModel criteria) {
        criteria.addFilter("organization.id", organization.getId(), SearchCriteriaFilterOperator.eq);

        SearchResultsModel<InvoiceEntity> entityResult = find(criteria, InvoiceEntity.class);
        List<InvoiceEntity> entities = entityResult.getModels();

        SearchResultsModel<InvoiceModel> searchResult = new SearchResultsModel<>();
        List<InvoiceModel> models = searchResult.getModels();

        entities.forEach(f -> models.add(new InvoiceAdapter(session, organization, em, f)));
        searchResult.setTotalSize(entityResult.getTotalSize());
        return searchResult;
    }

    @Override
    public SearchResultsModel<InvoiceModel> searchForInvoice(OrganizationModel organization, SearchCriteriaModel criteria, String filterText) {
        criteria.addFilter("organization.id", organization.getId(), SearchCriteriaFilterOperator.eq);

        SearchResultsModel<InvoiceEntity> entityResult = findFullText(criteria, InvoiceEntity.class, filterText, INVOICE_TYPE_CODE, DOCUMENT_ID);
        List<InvoiceEntity> entities = entityResult.getModels();

        SearchResultsModel<InvoiceModel> searchResult = new SearchResultsModel<>();
        List<InvoiceModel> models = searchResult.getModels();

        entities.forEach(f -> models.add(new InvoiceAdapter(session, organization, em, f)));
        searchResult.setTotalSize(entityResult.getTotalSize());
        return searchResult;
    }

    @Override
    public int getInvoicesCount(OrganizationModel organization) {
        Query query = em.createNamedQuery("getOrganizationInvoiceCount");
        Long result = (Long) query.getSingleResult();
        return result.intValue();
    }

    @Override
    public List<InvoiceModel> getInvoices(OrganizationModel organization, List<RequiredAction> requeridAction, boolean intoRequeridAction) {
        String queryName = "";
        if (intoRequeridAction) {
            queryName = "select i from InvoiceEntity i where i.organization.id = :organizationId and :requeridAction in elements(i.requeridAction) order by i.invoiceTypeCode ";
        } else {
            queryName = "select i from InvoiceEntity i where i.organization.id = :organizationId and :requeridAction not in elements(i.requeridAction) order by i.invoiceTypeCode ";

        }
        TypedQuery<InvoiceEntity> query = em.createQuery(queryName, InvoiceEntity.class);
        query.setParameter("organizationId", organization.getId());
        query.setParameter("requeridAction", requeridAction);
        List<InvoiceEntity> results = query.getResultList();
        List<InvoiceModel> invoices = results.stream()
                .map(f -> new InvoiceAdapter(session, organization, em, f)).collect(Collectors.toList());
        return invoices;
    }

    @Override
    public ScrollModel<InvoiceModel> getInvoicesScroll(OrganizationModel organization) {
        return getInvoicesScroll(organization, true);
    }

    @Override
    public ScrollModel<InvoiceModel> getInvoicesScroll(OrganizationModel organization, boolean asc) {
        return getInvoicesScroll(organization, asc, -1);
    }

    @Override
    public ScrollModel<InvoiceModel> getInvoicesScroll(OrganizationModel organization, boolean asc, int scrollSize) {
        if (scrollSize == -1) {
            scrollSize = 10;
        }

        TypedQuery<String> query = em.createNamedQuery("getAllInvoicesIdByOrganization", String.class);
        query.setParameter("organizationId", organization.getId());

        ScrollAdapter<InvoiceModel, String> result = new ScrollAdapter<>(String.class, query, f -> {
            InvoiceEntity entity = em.find(InvoiceEntity.class, f);
            return new InvoiceAdapter(session, organization, em, entity);
        });

        Iterator<InvoiceModel> iterator = result.iterator();
        while (iterator.hasNext()) {
            InvoiceModel invoiceModel = iterator.next();
            System.out.println("-------------------");
            System.out.println(invoiceModel.getRequiredActions());
        }

        return result;
    }
}
