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
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.jboss.logging.Logger;
import org.openfact.models.CreditNoteModel;
import org.openfact.models.DebitNoteModel;
import org.openfact.models.InvoiceModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.ScrollModel;
import org.openfact.ubl.SendEventModel;
import org.openfact.models.enums.SendResultType;
import org.openfact.models.jpa.entities.CreditNoteSendEventEntity;
import org.openfact.models.jpa.entities.DebitNoteSendEventEntity;
import org.openfact.models.jpa.entities.InvoiceSendEventEntity;
import org.openfact.models.jpa.entities.SendEventEntity;
import org.openfact.models.search.SearchCriteriaFilterOperator;
import org.openfact.models.search.SearchCriteriaModel;
import org.openfact.models.search.SearchResultsModel;
import org.openfact.ubl.SendEventProvider;

public class JpaSendEventProvider extends AbstractHibernateStorage implements SendEventProvider {

    protected static final Logger logger = Logger.getLogger(JpaSendEventProvider.class);

    private static final String ID = "ID";
    private static final String INVOICE_TYPE_CODE = "invoiceTypeCode";
    private static final String ISSUE_DATETIME = "issueDateTime";

    private final OpenfactSession session;
    protected EntityManager em;

    public JpaSendEventProvider(OpenfactSession session, EntityManager em) {
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
    public SendEventModel addSendEvent(OrganizationModel organization, SendResultType type, InvoiceModel invoice) {
        InvoiceSendEventEntity sendEvent = new InvoiceSendEventEntity();
        buildSendEvent(sendEvent, organization, type);
        sendEvent.setInvoice(InvoiceAdapter.toEntity(invoice, em));        
        em.persist(sendEvent);
        em.flush();

        return new SendEventAdapter(session, organization, em, sendEvent);
    }
    
    @Override
    public SendEventModel addSendEvent(OrganizationModel organization, SendResultType type, CreditNoteModel creditNote) {
        CreditNoteSendEventEntity sendEvent = new CreditNoteSendEventEntity();
        buildSendEvent(sendEvent, organization, type);
        sendEvent.setCreditNote(CreditNoteAdapter.toEntity(creditNote, em));        
        em.persist(sendEvent);
        em.flush();

        return new SendEventAdapter(session, organization, em, sendEvent);
    }
    
    @Override
    public SendEventModel addSendEvent(OrganizationModel organization, SendResultType type, DebitNoteModel debitNote) {
        DebitNoteSendEventEntity sendEvent = new DebitNoteSendEventEntity();
        buildSendEvent(sendEvent, organization, type);
        sendEvent.setDebitNote(DebitNoteAdapter.toEntity(debitNote, em));        
        em.persist(sendEvent);
        em.flush();

        return new SendEventAdapter(session, organization, em, sendEvent);
    }
    
    private void buildSendEvent(SendEventEntity sendEvent, OrganizationModel organization, SendResultType type) {
        sendEvent.setCreatedTimestamp(LocalDateTime.now());
        sendEvent.setResult(type.equals(SendResultType.SUCCESS));
        sendEvent.setOrganization(OrganizationAdapter.toEntity(organization, em));
    }

    @Override
    public SendEventModel getSendEventById(OrganizationModel organization, String id) {
        TypedQuery<SendEventEntity> query = em.createNamedQuery("getOrganizationSendEventById", SendEventEntity.class);
        query.setParameter("id", id);
        query.setParameter("organizationId", organization.getId());
        List<SendEventEntity> entities = query.getResultList();
        if (entities.size() == 0)
            return null;
        return new SendEventAdapter(session, organization, em, entities.get(0));
    }

    @Override
    public boolean removeSendEvent(OrganizationModel organization, String id) {
        return removeSendEvent(organization, getSendEventById(organization, id));
    }

    @Override
    public boolean removeSendEvent(OrganizationModel organization, SendEventModel sendEvent) {
        SendEventEntity sendEventEntity = em.find(SendEventEntity.class, sendEvent.getId());
        if (sendEventEntity == null)
            return false;
        
        em.remove(sendEventEntity);
        em.flush();        
        return true;
    }

    @Override
    public List<SendEventModel> getSendEvents(OrganizationModel organization) {
        return getSendEvents(organization, -1, -1);
    }

    @Override
    public List<SendEventModel> getSendEvents(OrganizationModel organization, Integer firstResult, Integer maxResults) {
        String queryName = "getAllSendEventsByOrganization";

        TypedQuery<SendEventEntity> query = em.createNamedQuery(queryName, SendEventEntity.class);
        query.setParameter("organizationId", organization.getId());
        if (firstResult != -1) {
            query.setFirstResult(firstResult);
        }
        if (maxResults != -1) {
            query.setMaxResults(maxResults);
        }
        List<SendEventEntity> results = query.getResultList();
        List<SendEventModel> invoices = results.stream().map(f -> new SendEventAdapter(session, organization, em, f)).collect(Collectors.toList());
        return invoices;
    }

}
