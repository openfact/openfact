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
import org.json.JSONObject;
import org.json.XML;
import org.openfact.JSONObjectUtils;
import org.openfact.common.converts.DocumentUtils;
import org.openfact.common.util.MultivaluedHashMap;
import org.openfact.file.FileModel;
import org.openfact.file.FileProvider;
import org.openfact.models.*;
import org.openfact.models.enums.DestinyType;
import org.openfact.models.enums.RequiredAction;
import org.openfact.models.enums.SendResultType;
import org.openfact.models.jpa.entities.*;
import org.openfact.models.utils.OpenfactModelUtils;
import org.w3c.dom.Document;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.xml.transform.TransformerException;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class DocumentAdapter implements DocumentModel, JpaModel<DocumentEntity> {

    protected static final Logger logger = Logger.getLogger(DocumentAdapter.class);

    protected OrganizationModel organization;
    protected DocumentEntity documentEntity;
    protected EntityManager em;
    protected OpenfactSession session;

    protected FileModel xmlFile;
    protected Document document;
    protected JSONObject jsonObject;

    public DocumentAdapter(OpenfactSession session, OrganizationModel organization, EntityManager em, DocumentEntity documentEntity) {
        this.organization = organization;
        this.session = session;
        this.em = em;
        this.documentEntity = documentEntity;
    }

    public static DocumentEntity toEntity(DocumentModel model, EntityManager em) {
        if (model instanceof DocumentAdapter) {
            return ((DocumentAdapter) model).getEntity();
        }
        return em.getReference(DocumentEntity.class, model.getId());
    }

    @Override
    public DocumentEntity getEntity() {
        return documentEntity;
    }

    @Override
    public String getId() {
        return documentEntity.getId();
    }

    @Override
    public String getDocumentId() {
        return documentEntity.getDocumentId();
    }

    @Override
    public String getDocumentType() {
        return documentEntity.getDocumentType();
    }

    @Override
    public LocalDateTime getCreatedTimestamp() {
        return documentEntity.getCreatedTimestamp();
    }

    @Override
    public boolean isEnabled() {
        return documentEntity.isEnabled();
    }

    @Override
    public OrganizationModel getOrganization() {
        return organization;
    }

    @Override
    public String getCustomerRegistrationName() {
        return documentEntity.getCustomerRegistrationName();
    }

    @Override
    public void setCustomerRegistrationName(String value) {
        documentEntity.setCustomerRegistrationName(value);
    }

    @Override
    public String getCustomerAssignedAccountId() {
        return documentEntity.getCustomerAssignedAccountId();
    }

    @Override
    public void setCustomerAssignedAccountId(String value) {
        documentEntity.setCustomerAssignedAccountId(value);
    }

    @Override
    public String getCustomerElectronicMail() {
        return documentEntity.getCustomerElectronicMail();
    }

    @Override
    public void setCustomerElectronicMail(String value) {
        documentEntity.setCustomerElectronicMail(value);
    }

    @Override
    public FileModel getXmlAsFile() {
        if (xmlFile == null && documentEntity.getXmlFileId() != null) {
            FileProvider provider = session.getProvider(FileProvider.class);
            xmlFile = provider.getFileById(organization, documentEntity.getXmlFileId());
        }
        return xmlFile;
    }

    @Override
    public void attachXmlFile(FileModel file) {
        xmlFile = file;
        documentEntity.setXmlFileId(xmlFile.getId());
    }

    @Override
    public Document getXmlAsDocument() {
        if (document == null) {
            FileModel file = getXmlAsFile();
            if (file != null) {
                try {
                    document = DocumentUtils.byteToDocument(file.getFile());
                } catch (Exception e) {
                    throw new ModelException("Error parsing xml file to Document", e);
                }
            }
        }
        return document;
    }

    @Override
    public JSONObject getXmlAsJSONObject() {
        if (jsonObject == null) {
            try {
                Document document = getXmlAsDocument();
                if (document != null) {
                    String documentString = DocumentUtils.getDocumentToString(document);
                    jsonObject = JSONObjectUtils.renameKey(XML.toJSONObject(documentString), ".*:", "");
                    jsonObject = JSONObjectUtils.getJSONObject(jsonObject, "Invoice");
                }
            } catch (TransformerException e) {
                throw new ModelException("Error parsing xml file to JSON", e);
            }
        }
        return jsonObject;
    }

    /**
     * Attributes
     */
    @Override
    public void setSingleAttribute(String name, String value) {
        String firstExistingAttrId = null;
        List<DocumentAttributeEntity> toRemove = new ArrayList<>();
        for (DocumentAttributeEntity attr : documentEntity.getAttributes()) {
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
            Query query = em.createNamedQuery("deleteDocumentAttributesByNameAndDocumentOtherThan");
            query.setParameter("name", name);
            query.setParameter("documentId", documentEntity.getId());
            query.setParameter("attrId", firstExistingAttrId);
            int numUpdated = query.executeUpdate();

            // Remove attribute from local entity
            documentEntity.getAttributes().removeAll(toRemove);
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
        attr.setDocument(documentEntity);
        em.persist(attr);
        documentEntity.getAttributes().add(attr);
    }

    @Override
    public void removeAttribute(String name) {
        // Remove attribute through HQL to avoid StaleUpdateException
        Query query = em.createNamedQuery("deleteDocumentAttributesByNameAndDocument");
        query.setParameter("name", name);
        query.setParameter("documentId", documentEntity.getId());
        int numUpdated = query.executeUpdate();

        // Also remove attributes from local user entity
        List<DocumentAttributeEntity> toRemove = new ArrayList<>();
        for (DocumentAttributeEntity attr : documentEntity.getAttributes()) {
            if (attr.getName().equals(name)) {
                toRemove.add(attr);
            }
        }
        documentEntity.getAttributes().removeAll(toRemove);
    }

    @Override
    public String getFirstAttribute(String name) {
        for (DocumentAttributeEntity attr : documentEntity.getAttributes()) {
            if (attr.getName().equals(name)) {
                return attr.getValue();
            }
        }
        return null;
    }

    @Override
    public List<String> getAttribute(String name) {
        List<String> result = new ArrayList<>();
        for (DocumentAttributeEntity attr : documentEntity.getAttributes()) {
            if (attr.getName().equals(name)) {
                result.add(attr.getValue());
            }
        }
        return result;
    }

    @Override
    public Map<String, List<String>> getAttributes() {
        MultivaluedHashMap<String, String> result = new MultivaluedHashMap<>();
        for (DocumentAttributeEntity attr : documentEntity.getAttributes()) {
            result.add(attr.getName(), attr.getValue());
        }
        return result;
    }

    /**
     * Required actions
     */
    @Override
    public Set<String> getRequiredActions() {
        Set<String> result = new HashSet<>();
        for (DocumentRequiredActionEntity attr : documentEntity.getRequiredActions()) {
            result.add(attr.getAction());
        }
        return result;
    }

    @Override
    public void addRequiredAction(RequiredAction action) {
        String actionName = action.name();
        addRequiredAction(actionName);
    }

    @Override
    public void addRequiredAction(String actionName) {
        for (DocumentRequiredActionEntity attr : documentEntity.getRequiredActions()) {
            if (attr.getAction().equals(actionName)) {
                return;
            }
        }
        DocumentRequiredActionEntity attr = new DocumentRequiredActionEntity();
        attr.setAction(actionName);
        attr.setDocument(documentEntity);
        em.persist(attr);
        documentEntity.getRequiredActions().add(attr);
    }

    @Override
    public void removeRequiredAction(RequiredAction action) {
        String actionName = action.name();
        removeRequiredAction(actionName);
    }

    @Override
    public void removeRequiredAction(String actionName) {
        Iterator<DocumentRequiredActionEntity> it = documentEntity.getRequiredActions().iterator();
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
        entity.setResult(SendResultType.ON_PROCESS);
        entity.setDestinyType(destinyType);
        entity.setDocument(documentEntity);
        em.persist(entity);
        //em.flush();

        return new SendEventAdapter(session, em, organization, entity);
    }

    @Override
    public SendEventModel getSendEventById(String id) {
        SendEventEntity entity = em.find(SendEventEntity.class, id);
        if (entity != null) {
            return new SendEventAdapter(session, em, organization, entity);
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
        TypedQuery<SendEventEntity> query = em.createNamedQuery("getAllSendEventByDocumentId", SendEventEntity.class);
        query.setParameter("documentId", documentEntity.getId());
        if (firstResult != -1) {
            query.setFirstResult(firstResult);
        }
        if (maxResults != -1) {
            query.setMaxResults(maxResults);
        }
        List<SendEventEntity> results = query.getResultList();
        return results.stream().map(f -> new SendEventAdapter(session, em, organization, f)).collect(Collectors.toList());
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
            if (entry.getKey().equals(DocumentModel.SEND_EVENT_DESTINY_TYPE)) {
                attribute = "u.destinyType";
                parameterName = JpaDocumentProvider.SEND_EVENT_DESTINY_TYPE;
                operator = " = :";
            } else if (entry.getKey().equals(DocumentModel.SEND_EVENT_TYPE)) {
                attribute = "lower(u.type)";
                parameterName = JpaDocumentProvider.SEND_EVENT_TYPE;
                operator = " like :";
            } else if (entry.getKey().equals(DocumentModel.SEND_EVENT_RESULT)) {
                attribute = "u.result";
                parameterName = JpaDocumentProvider.SEND_EVENT_RESULT;
                operator = " = :";
            }
            if (attribute == null) continue;
            builder.append(" and ");
            builder.append(attribute).append(operator).append(parameterName);
        }
        builder.append(" order by u.createdTimestamp");
        String q = builder.toString();
        TypedQuery<SendEventEntity> query = em.createQuery(q, SendEventEntity.class);
        query.setParameter("documentId", documentEntity.getId());
        for (Map.Entry<String, String> entry : attributes.entrySet()) {
            String parameterName = null;
            Object parameterValue = null;
            if (entry.getKey().equals(DocumentModel.SEND_EVENT_DESTINY_TYPE)) {
                parameterName = JpaDocumentProvider.SEND_EVENT_DESTINY_TYPE;
                parameterValue = DestinyType.valueOf(entry.getValue().toUpperCase());
            } else if (entry.getKey().equals(DocumentModel.SEND_EVENT_TYPE)) {
                parameterName = JpaDocumentProvider.SEND_EVENT_TYPE;
                parameterValue = "%" + entry.getValue().toLowerCase() + "%";
            } else if (entry.getKey().equals(DocumentModel.SEND_EVENT_RESULT)) {
                parameterName = JpaDocumentProvider.SEND_EVENT_RESULT;
                parameterValue = SendResultType.valueOf(entry.getValue().toUpperCase());
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
        return results.stream().map(f -> new SendEventAdapter(session, em, organization, f)).collect(Collectors.toList());
    }

    @Override
    public int sendEventCount() {
        Object count = em.createNamedQuery("getDocumentSendEventCountByDocument")
                .setParameter("documentId", documentEntity.getId())
                .getSingleResult();
        return ((Number) count).intValue();
    }

    @Override
    public int sendEventCount(Map<String, String> attributes) {
        StringBuilder builder = new StringBuilder("select count(u) from SendEventEntity u where u.document.id = :documentId");
        for (Map.Entry<String, String> entry : attributes.entrySet()) {
            String attribute = null;
            String parameterName = null;
            String operator = null;
            if (entry.getKey().equals(DocumentModel.SEND_EVENT_DESTINY_TYPE)) {
                attribute = "u.destinyType";
                parameterName = JpaDocumentProvider.SEND_EVENT_DESTINY_TYPE;
                operator = " = :";
            }
            if (entry.getKey().equals(DocumentModel.SEND_EVENT_TYPE)) {
                attribute = "lower(u.type)";
                parameterName = JpaDocumentProvider.SEND_EVENT_TYPE;
                operator = " like :";
            }
            if (entry.getKey().equals(DocumentModel.SEND_EVENT_RESULT)) {
                attribute = "u.result";
                parameterName = JpaDocumentProvider.SEND_EVENT_RESULT;
                operator = " = :";
            }
            if (attribute == null) continue;
            builder.append(" and ");
            builder.append(attribute).append(operator).append(parameterName);
        }

        String q = builder.toString();
        Query query = em.createQuery(q);
        query.setParameter("documentId", documentEntity.getId());
        for (Map.Entry<String, String> entry : attributes.entrySet()) {
            String parameterName = null;
            Object parameterValue = null;
            if (entry.getKey().equals(DocumentModel.SEND_EVENT_DESTINY_TYPE)) {
                parameterName = JpaDocumentProvider.SEND_EVENT_DESTINY_TYPE;
                parameterValue = DestinyType.valueOf(entry.getValue().toUpperCase());
            }
            if (entry.getKey().equals(DocumentModel.SEND_EVENT_TYPE)) {
                parameterName = JpaDocumentProvider.SEND_EVENT_TYPE;
                parameterValue = "%" + entry.getValue().toLowerCase() + "%";
            }
            if (entry.getKey().equals(DocumentModel.SEND_EVENT_RESULT)) {
                parameterName = JpaDocumentProvider.SEND_EVENT_RESULT;
                parameterValue = SendResultType.valueOf(entry.getValue().toUpperCase());
            }
            if (parameterName == null) continue;
            query.setParameter(parameterName, parameterValue);
        }

        Object count = query.getSingleResult();
        return ((Number) count).intValue();
    }

    /**
     * Attatched documents
     */
    @Override
    public List<AttatchedDocumentModel> getAttatchedDocuments() {
        return documentEntity.getAttatchedDocuments().stream().map(f -> new AttatchedDocumentAdapter(session, organization, em, f)).collect(Collectors.toList());
    }

    @Override
    public AttatchedDocumentModel getAttatchedDocumentById(String id) {
        AttatchedDocumentEntity entity = em.find(AttatchedDocumentEntity.class, id);
        if (entity == null) return null;
        return new AttatchedDocumentAdapter(session, organization, em, entity);
    }

    @Override
    public AttatchedDocumentModel addAttatchedDocument(String documentType, String documentId) {
        AttatchedDocumentEntity entity = new AttatchedDocumentEntity();
        entity.setRelatedDocumentType(documentType);
        entity.setRelatedDocumentId(documentId);
        entity.setDocument(documentEntity);
        em.persist(entity);
        em.flush();
        documentEntity.getAttatchedDocuments().add(entity);
        return new AttatchedDocumentAdapter(session, organization, em, entity);
    }

    @Override
    public boolean removeAttatchedDocument(AttatchedDocumentModel attatchedDocument) {
        boolean result = false;
        Iterator<AttatchedDocumentEntity> it = documentEntity.getAttatchedDocuments().iterator();
        while (it.hasNext()) {
            AttatchedDocumentEntity attr = it.next();
            if (attr.getId().equals(attatchedDocument.getId())) {
                it.remove();
                em.remove(attr);
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
