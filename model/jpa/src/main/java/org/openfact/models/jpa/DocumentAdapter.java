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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.jboss.logging.Logger;
import org.openfact.files.FileModel;
import org.openfact.models.DocumentLineModel;
import org.openfact.models.DocumentModel;
import org.openfact.models.OrganizationModel;
import org.openfact.models.SendEventModel;
import org.openfact.models.jpa.entities.AttachedDocumentEntity;
import org.openfact.models.jpa.entities.DocumentAttributeEntity;
import org.openfact.models.jpa.entities.DocumentEntity;
import org.openfact.models.jpa.entities.DocumentLineEntity;
import org.openfact.models.jpa.entities.DocumentRequiredActionEntity;
import org.openfact.models.jpa.entities.SendEventEntity;
import org.openfact.models.types.DestinyType;
import org.openfact.models.types.DocumentRequiredAction;
import org.openfact.models.types.SendEventStatus;
import org.openfact.models.utils.OpenfactModelUtils;

public class DocumentAdapter implements DocumentModel, JpaModel<DocumentEntity>, HibernateWrapper {

    protected static final Logger logger = Logger.getLogger(DocumentAdapter.class);

    protected OrganizationModel organization;
    protected DocumentEntity document;
    protected EntityManager em;

    public DocumentAdapter(OrganizationModel organization, EntityManager em, DocumentEntity document) {
        this.organization = organization;
        this.em = em;
        this.document = document;
    }

    public static DocumentEntity toEntity(DocumentModel model, EntityManager em) {
        if (model instanceof DocumentAdapter) {
            return ((DocumentAdapter) model).getEntity();
        }
        return em.getReference(DocumentEntity.class, model.getId());
    }

    public DocumentLineModel toDocumentLineModel(DocumentLineEntity documentLine) {
        return new DocumentLineAdapter(this, em, documentLine);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public DocumentEntity getEntity() {
        return document;
    }

    @Override
    public String getId() {
        return document.getId();
    }

    @Override
    public String getDocumentId() {
        return document.getDocumentId();
    }

    @Override
    public String getDocumentType() {
        return document.getDocumentType();
    }

    @Override
    public LocalDateTime getCreatedTimestamp() {
        return document.getCreatedTimestamp();
    }

    @Override
    public boolean isEnabled() {
        return document.isEnabled();
    }

    @Override
    public void disable() {
        document.setEnabled(false);
    }

    @Override
    public List<DocumentLineModel> getDocumentLines() {
        return document.getLines().stream()
                .map(this::toDocumentLineModel)
                .collect(Collectors.toList());
    }

    @Override
    public DocumentLineModel addDocumentLine() {
        DocumentLineEntity entity = new DocumentLineEntity();
        entity.setDocument(document);
        getSession().persist(entity);
        return toDocumentLineModel(entity);
    }

    @Override
    public boolean removeDocumentLine(DocumentLineModel documentLine) {
        boolean result = false;
        Iterator<DocumentLineEntity> it = document.getLines().iterator();
        while (it.hasNext()) {
            DocumentLineEntity line = it.next();
            if (line.getId().equals(documentLine.getId())) {
                it.remove();
                getSession().remove(line);
                result = true;
            }
        }
        return result;
    }

    @Override
    public OrganizationModel getOrganization() {
        return organization;
    }

    @Override
    public String getDocumentCurrencyCode() {
        return document.getDocumentCurrencyCode();
    }

    @Override
    public void setDocumentCurrencyCode(String currencyCode) {
        document.setDocumentCurrencyCode(currencyCode);
    }

    @Override
    public String getCustomerRegistrationName() {
        return document.getCustomerRegistrationName();
    }

    @Override
    public void setCustomerRegistrationName(String value) {
        document.setCustomerRegistrationName(value);
    }

    @Override
    public String getCustomerAssignedAccountId() {
        return document.getCustomerAssignedAccountId();
    }

    @Override
    public void setCustomerAssignedAccountId(String value) {
        document.setCustomerAssignedAccountId(value);
    }

    @Override
    public String getCustomerElectronicMail() {
        return document.getCustomerElectronicMail();
    }

    @Override
    public void setCustomerElectronicMail(String value) {
        document.setCustomerElectronicMail(value);
    }

    @Override
    public String getXmlFileId() {
        return document.getXmlFileId();
    }

    @Override
    public void attachXmlFile(FileModel file) {
        document.setXmlFileId(file.getId());
    }    

    /**
     * Attributes
     */
    @Override
    public void setSingleAttribute(String name, String value) {
        String firstExistingAttrId = null;
        List<DocumentAttributeEntity> toRemove = new ArrayList<>();
        for (DocumentAttributeEntity attr : document.getAttributes()) {
            if (attr.getName().equals(name)) {
                if (firstExistingAttrId == null) {
                    attr.setValue(value);
                    firstExistingAttrId = attr.getId();
                } else {
                    toRemove.add(attr);
                }
            }
        }

        if (firstExistingAttrId != null) {
            // Remove attributes through HQL to avoid StaleUpdateException
            Query query = em.createNamedQuery("deleteDocumentAttributesByNameAndDocumentPkIdOtherThan");
            query.setParameter("name", name);
            query.setParameter("documentPkId", document.getId());
            query.setParameter("attrId", firstExistingAttrId);
            query.executeUpdate();

            // Remove attribute from local entity
            document.getAttributes().removeAll(toRemove);
        } else {

            persistAttributeValue(name, value);
        }
    }

    @Override
    public void setAttribute(String name, List<String> values) {
        // Remove all existing
        removeAttribute(name);

        // Put all new
        for (String value : values) {
            persistAttributeValue(name, value);
        }
    }

    private void persistAttributeValue(String name, String value) {
        DocumentAttributeEntity attr = new DocumentAttributeEntity();
        attr.setId(OpenfactModelUtils.generateId());
        attr.setName(name);
        attr.setValue(value);
        attr.setDocument(document);
        em.persist(attr);
        document.getAttributes().add(attr);
    }

    @Override
    public void removeAttribute(String name) {
        // Remove attribute through HQL to avoid StaleUpdateException
        Query query = em.createNamedQuery("deleteDocumentAttributesByNameAndDocumentPkId");
        query.setParameter("name", name);
        query.setParameter("documentPkId", document.getId());
        query.executeUpdate();

        // Also remove attributes from local user entity
        List<DocumentAttributeEntity> toRemove = new ArrayList<>();
        for (DocumentAttributeEntity attr : document.getAttributes()) {
            if (attr.getName().equals(name)) {
                toRemove.add(attr);
            }
        }
        document.getAttributes().removeAll(toRemove);
    }

    @Override
    public String getFirstAttribute(String name) {
        for (DocumentAttributeEntity attr : document.getAttributes()) {
            if (attr.getName().equals(name)) {
                return attr.getValue();
            }
        }
        return null;
    }

    @Override
    public List<String> getAttribute(String name) {
        List<String> result = new ArrayList<>();
        for (DocumentAttributeEntity attr : document.getAttributes()) {
            if (attr.getName().equals(name)) {
                result.add(attr.getValue());
            }
        }
        return result;
    }

    @Override
    public Map<String, List<String>> getAttributes() {
        /*MultivaluedHashMap<String, String> result = new MultivaluedHashMap<>();
        for (DocumentAttributeEntity attr : document.getAttributes()) {
            result.add(attr.getName(), attr.getValue());
        }
        return result;*/
        return null;
    }

    /**
     * Required actions
     */
    @Override
    public Set<String> getRequiredActions() {
        Set<String> result = new HashSet<>();
        for (DocumentRequiredActionEntity attr : document.getRequiredActions()) {
            result.add(attr.getAction());
        }
        return result;
    }

    @Override
    public void addRequiredAction(DocumentRequiredAction action) {
        String actionName = action.name();
        addRequiredAction(actionName);
    }

    @Override
    public void addRequiredAction(String actionName) {
        for (DocumentRequiredActionEntity attr : document.getRequiredActions()) {
            if (attr.getAction().equals(actionName)) {
                return;
            }
        }
        DocumentRequiredActionEntity attr = new DocumentRequiredActionEntity();
        attr.setAction(actionName);
        attr.setDocument(document);
        em.persist(attr);
        document.getRequiredActions().add(attr);
    }

    @Override
    public void removeRequiredAction(DocumentRequiredAction action) {
        String actionName = action.name();
        removeRequiredAction(actionName);
    }

    @Override
    public int getCustomerSendEventFailures() {
        return document.getCustomerSendEventFailures();
    }

    @Override
    public void incrementCustomerSendEventFailures() {
        document.setCustomerSendEventFailures(document.getCustomerSendEventFailures() + 1);
    }

    @Override
    public int getThirdPartySendEventFailures() {
        return document.getThirdPartySendEventFailures();
    }

    @Override
    public void incrementThirdPartySendEventFailures() {
        document.setThirdPartySendEventFailures(document.getThirdPartySendEventFailures() + 1);
    }

    @Override
    public void removeRequiredAction(String actionName) {
        Iterator<DocumentRequiredActionEntity> it = document.getRequiredActions().iterator();
        while (it.hasNext()) {
            DocumentRequiredActionEntity attr = it.next();
            if (attr.getAction().equals(actionName)) {
                it.remove();
                em.remove(attr);
            }
        }
    }

    /**
     * Send events
     */
    @Override
    public SendEventModel addSendEvent(DestinyType destinyType) {
        SendEventEntity entity = new SendEventEntity();
        entity.setCreatedTimestamp(LocalDateTime.now());
        entity.setStatus(SendEventStatus.ON_PROCESS);
        entity.setDestiny(destinyType);
        entity.setDocument(document);
        em.persist(entity);

        return new SendEventAdapter(em, organization, entity);
    }

    @Override
    public SendEventModel getSendEventById(String id) {
        SendEventEntity entity = em.find(SendEventEntity.class, id);
        if (entity != null) {
            return new SendEventAdapter(em, organization, entity);
        }
        return null;
    }

    @Override
    public boolean removeSendEvent(SendEventModel sendEvent) {
        SendEventEntity entity = em.find(SendEventEntity.class, sendEvent.getId());
        if (entity == null)
            return false;

        em.remove(entity);
        em.flush();
        return true;
    }

    @Override
    public List<SendEventModel> getSendEvents() {
        return getSendEvents(-1, -1);
    }

    @Override
    public List<SendEventModel> getSendEvents(Integer firstResult, Integer maxResults) {
        TypedQuery<SendEventEntity> query = em.createNamedQuery("getAllSendEventsByDocumentPkId", SendEventEntity.class);
        query.setParameter("documentPkId", document.getId());
        if (firstResult != -1) {
            query.setFirstResult(firstResult);
        }
        if (maxResults != -1) {
            query.setMaxResults(maxResults);
        }
        List<SendEventEntity> results = query.getResultList();
        return results.stream().map(f -> new SendEventAdapter(em, organization, f)).collect(Collectors.toList());
    }

    @Override
    public List<SendEventModel> searchForSendEvent(Map<String, String> params) {
        return searchForSendEvent(params, -1, -1);
    }

    @Override
    public List<SendEventModel> searchForSendEvent(Map<String, String> attributes, int firstResult, int maxResults) {
        StringBuilder builder = new StringBuilder("select u from SendEventEntity u where u.document.id = :documentId");
        for (Map.Entry<String, String> entry : attributes.entrySet()) {
            String attribute = null;
            String parameterName = null;
            String operator = null;
            if (entry.getKey().equals(DocumentModel.SEND_EVENT_DESTINY)) {
                attribute = "u." + JpaDocumentProvider.SEND_EVENT_DESTINY;
                parameterName = JpaDocumentProvider.SEND_EVENT_DESTINY;
                operator = " = :";
            } else if (entry.getKey().equals(DocumentModel.SEND_EVENT_STATUS)) {
                attribute = "u." + JpaDocumentProvider.SEND_EVENT_STATUS;
                parameterName = JpaDocumentProvider.SEND_EVENT_STATUS;
                operator = " = :";
            }
            if (attribute == null) continue;
            builder.append(" and ");
            builder.append(attribute).append(operator).append(parameterName);
        }
        builder.append(" order by u.createdTimestamp");
        String q = builder.toString();
        TypedQuery<SendEventEntity> query = em.createQuery(q, SendEventEntity.class);
        query.setParameter("documentId", document.getId());
        for (Map.Entry<String, String> entry : attributes.entrySet()) {
            String parameterName = null;
            Object parameterValue = null;
            if (entry.getKey().equals(DocumentModel.SEND_EVENT_DESTINY)) {
                parameterName = JpaDocumentProvider.SEND_EVENT_DESTINY;
                parameterValue = DestinyType.valueOf(entry.getValue().toUpperCase());
            } else if (entry.getKey().equals(DocumentModel.SEND_EVENT_STATUS)) {
                parameterName = JpaDocumentProvider.SEND_EVENT_STATUS;
                parameterValue = SendEventStatus.valueOf(entry.getValue().toUpperCase());
            }
            if (parameterName == null) continue;
            query.setParameter(parameterName, parameterValue);
        }
        if (firstResult != -1) {
            query.setFirstResult(firstResult);
        }
        if (maxResults != -1) {
            query.setMaxResults(maxResults);
        }
        List<SendEventEntity> results = query.getResultList();
        return results.stream().map(f -> new SendEventAdapter(em, organization, f)).collect(Collectors.toList());
    }

    /**
     * Attatched documents
     */
    @Override
    public List<DocumentModel> getAttachedDocumentsAsOrigin() {
        TypedQuery<DocumentEntity> query = em.createNamedQuery("getAttachedDocumentsDestinyByOrigin", DocumentEntity.class);
        query.setParameter("documentOriginId", document.getId());
        return query.getResultList().stream().map(f -> new DocumentAdapter(organization, em, f)).collect(Collectors.toList());
    }

    @Override
    public List<DocumentModel> getAttachedDocumentsAsDestiny() {
        TypedQuery<DocumentEntity> query = em.createNamedQuery("getAttachedDocumentsOriginByDestiny", DocumentEntity.class);
        query.setParameter("documentDestinyId", document.getId());
        return query.getResultList().stream().map(f -> new DocumentAdapter(organization, em, f)).collect(Collectors.toList());
    }

    @Override
    public void addAttachedDocument(DocumentModel document) {
        AttachedDocumentEntity entity = new AttachedDocumentEntity();
        entity.setDocumentOrigin(this.document);
        entity.setDocumentDestiny(DocumentAdapter.toEntity(document, em));
        em.persist(entity);
        this.document.getAttachedDocumentsAsOrigin().add(entity);
    }

    @Override
    public boolean removeAttachedDocument(DocumentModel document) {
        boolean result = false;
        Iterator<AttachedDocumentEntity> it = this.document.getAttachedDocumentsAsOrigin().iterator();
        while (it.hasNext()) {
            AttachedDocumentEntity attachedUBLDocument = it.next();
            if (attachedUBLDocument.getDocumentDestiny().getId().equals(document.getId())) {
                it.remove();
                em.remove(attachedUBLDocument);
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof DocumentModel)) return false;

        DocumentModel that = (DocumentModel) o;
        return that.getId().equals(getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }

}
