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
import org.openfact.models.enums.DocumentType;
import org.openfact.models.enums.RequiredAction;
import org.openfact.models.enums.SendEventStatus;
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

public class UBLDocumentAdapter implements DocumentModel, JpaModel<UBLDocumentEntity> {

    protected static final Logger logger = Logger.getLogger(UBLDocumentAdapter.class);

    protected OrganizationModel organization;
    protected UBLDocumentEntity ublDocument;
    protected EntityManager em;
    protected OpenfactSession session;

    protected FileModel xmlFile;
    protected Document xmlDocument;
    protected JSONObject jsonObject;

    public UBLDocumentAdapter(OpenfactSession session, OrganizationModel organization, EntityManager em, UBLDocumentEntity documentEntity) {
        this.organization = organization;
        this.session = session;
        this.em = em;
        this.ublDocument = documentEntity;
    }

    public static UBLDocumentEntity toEntity(DocumentModel model, EntityManager em) {
        if (model instanceof UBLDocumentAdapter) {
            return ((UBLDocumentAdapter) model).getEntity();
        }
        return em.getReference(UBLDocumentEntity.class, model.getId());
    }

    @Override
    public UBLDocumentEntity getEntity() {
        return ublDocument;
    }

    @Override
    public String getId() {
        return ublDocument.getId();
    }

    @Override
    public String getDocumentId() {
        return ublDocument.getDocumentId();
    }

    @Override
    public String getDocumentType() {
        return ublDocument.getDocumentType();
    }

    @Override
    public LocalDateTime getCreatedTimestamp() {
        return ublDocument.getCreatedTimestamp();
    }

    @Override
    public boolean isEnabled() {
        return ublDocument.isEnabled();
    }

    @Override
    public OrganizationModel getOrganization() {
        return organization;
    }

    @Override
    public String getDocumentCurrencyCode() {
        return ublDocument.getDocumentCurrencyCode();
    }

    @Override
    public void setDocumentCurrencyCode(String currencyCode) {
        ublDocument.setDocumentCurrencyCode(currencyCode);
    }

    @Override
    public String getCustomerRegistrationName() {
        return ublDocument.getCustomerRegistrationName();
    }

    @Override
    public void setCustomerRegistrationName(String value) {
        ublDocument.setCustomerRegistrationName(value);
    }

    @Override
    public String getCustomerAssignedAccountId() {
        return ublDocument.getCustomerAssignedAccountId();
    }

    @Override
    public void setCustomerAssignedAccountId(String value) {
        ublDocument.setCustomerAssignedAccountId(value);
    }

    @Override
    public String getCustomerElectronicMail() {
        return ublDocument.getCustomerElectronicMail();
    }

    @Override
    public void setCustomerElectronicMail(String value) {
        ublDocument.setCustomerElectronicMail(value);
    }

    @Override
    public FileModel getXmlAsFile() {
        if (xmlFile == null && ublDocument.getXmlFileId() != null) {
            FileProvider provider = session.getProvider(FileProvider.class);
            xmlFile = provider.getFileById(organization, ublDocument.getXmlFileId());
        }
        return xmlFile;
    }

    @Override
    public void attachXmlFile(FileModel file) {
        xmlFile = file;
        ublDocument.setXmlFileId(xmlFile.getId());
    }

    @Override
    public Document getXmlAsDocument() {
        if (xmlDocument == null) {
            FileModel file = getXmlAsFile();
            if (file != null) {
                try {
                    xmlDocument = DocumentUtils.byteToDocument(file.getFile());
                } catch (Exception e) {
                    throw new ModelException("Error parsing xml file to Document", e);
                }
            }
        }
        return xmlDocument;
    }

    @Override
    public JSONObject getXmlAsJSONObject() {
        if (jsonObject == null) {
            try {
                Document document = getXmlAsDocument();
                if (document != null) {
                    String documentString = DocumentUtils.getDocumentToString(document);
                    jsonObject = JSONObjectUtils.renameKey(XML.toJSONObject(documentString), ".*:", "");
                    DocumentType documentType = DocumentType.getFromString(ublDocument.getDocumentType());
                    if (documentType != null) {
                        switch (documentType) {
                            case INVOICE:
                                jsonObject = JSONObjectUtils.getJSONObject(jsonObject, "Invoice");
                                break;
                            case CREDIT_NOTE:
                                jsonObject = JSONObjectUtils.getJSONObject(jsonObject, "CreditNote");
                                break;
                            case DEBIT_NOTE:
                                jsonObject = JSONObjectUtils.getJSONObject(jsonObject, "DebitNote");
                                break;
                        }
                    } else {
                        String jsonName = Arrays.stream(ublDocument.getDocumentType().toLowerCase().split("_"))
                                .map(c -> c.substring(0, 1).toUpperCase() + c.substring(1))
                                .reduce("", String::concat);

                        JSONObject subJsonObject = JSONObjectUtils.getJSONObject(jsonObject, jsonName);
                        if (subJsonObject != null) {
                            jsonObject = subJsonObject;
                        }
                    }

                    return jsonObject;
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
        List<UBLDocumentAttributeEntity> toRemove = new ArrayList<>();
        for (UBLDocumentAttributeEntity attr : ublDocument.getAttributes()) {
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
            Query query = em.createNamedQuery("deleteUblDocumentAttributesByNameAndUblDocumentOtherThan");
            query.setParameter("name", name);
            query.setParameter("documentId", ublDocument.getId());
            query.setParameter("attrId", firstExistingAttrId);
            int numUpdated = query.executeUpdate();

            // Remove attribute from local entity
            ublDocument.getAttributes().removeAll(toRemove);
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
        UBLDocumentAttributeEntity attr = new UBLDocumentAttributeEntity();
        attr.setId(OpenfactModelUtils.generateId());
        attr.setName(name);
        attr.setValue(value);
        attr.setUblDocument(ublDocument);
        em.persist(attr);
        ublDocument.getAttributes().add(attr);
    }

    @Override
    public void removeAttribute(String name) {
        // Remove attribute through HQL to avoid StaleUpdateException
        Query query = em.createNamedQuery("deleteUblDocumentAttributesByNameAndUblDocument");
        query.setParameter("name", name);
        query.setParameter("documentId", ublDocument.getId());
        int numUpdated = query.executeUpdate();

        // Also remove attributes from local user entity
        List<UBLDocumentAttributeEntity> toRemove = new ArrayList<>();
        for (UBLDocumentAttributeEntity attr : ublDocument.getAttributes()) {
            if (attr.getName().equals(name)) {
                toRemove.add(attr);
            }
        }
        ublDocument.getAttributes().removeAll(toRemove);
    }

    @Override
    public String getFirstAttribute(String name) {
        for (UBLDocumentAttributeEntity attr : ublDocument.getAttributes()) {
            if (attr.getName().equals(name)) {
                return attr.getValue();
            }
        }
        return null;
    }

    @Override
    public List<String> getAttribute(String name) {
        List<String> result = new ArrayList<>();
        for (UBLDocumentAttributeEntity attr : ublDocument.getAttributes()) {
            if (attr.getName().equals(name)) {
                result.add(attr.getValue());
            }
        }
        return result;
    }

    @Override
    public Map<String, List<String>> getAttributes() {
        MultivaluedHashMap<String, String> result = new MultivaluedHashMap<>();
        for (UBLDocumentAttributeEntity attr : ublDocument.getAttributes()) {
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
        for (UBLDocumentRequiredActionEntity attr : ublDocument.getRequiredActions()) {
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
        for (UBLDocumentRequiredActionEntity attr : ublDocument.getRequiredActions()) {
            if (attr.getAction().equals(actionName)) {
                return;
            }
        }
        UBLDocumentRequiredActionEntity attr = new UBLDocumentRequiredActionEntity();
        attr.setAction(actionName);
        attr.setUblDocument(ublDocument);
        em.persist(attr);
        ublDocument.getRequiredActions().add(attr);
    }

    @Override
    public void removeRequiredAction(RequiredAction action) {
        String actionName = action.name();
        removeRequiredAction(actionName);
    }

    @Override
    public void removeRequiredAction(String actionName) {
        Iterator<UBLDocumentRequiredActionEntity> it = ublDocument.getRequiredActions().iterator();
        while (it.hasNext()) {
            UBLDocumentRequiredActionEntity attr = it.next();
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
        entity.setUblDocument(ublDocument);
        em.persist(entity);
        //em.flush();

        return new UBLDocumentSendEventAdapter(session, em, organization, entity);
    }

    @Override
    public SendEventModel getSendEventById(String id) {
        SendEventEntity entity = em.find(SendEventEntity.class, id);
        if (entity != null) {
            return new UBLDocumentSendEventAdapter(session, em, organization, entity);
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
        query.setParameter("documentId", ublDocument.getId());
        if (firstResult != -1) {
            query.setFirstResult(firstResult);
        }
        if (maxResults != -1) {
            query.setMaxResults(maxResults);
        }
        List<SendEventEntity> results = query.getResultList();
        return results.stream().map(f -> new UBLDocumentSendEventAdapter(session, em, organization, f)).collect(Collectors.toList());
    }

    @Override
    public List<SendEventModel> searchForSendEvent(Map<String, String> params) {
        return searchForSendEvent(params, -1, -1);
    }

    @Override
    public List<SendEventModel> searchForSendEvent(Map<String, String> attributes, int firstResult, int maxResults) {
        StringBuilder builder = new StringBuilder("select u from SendEventEntity u where u.ublDocument.id = :documentId");
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
        query.setParameter("documentId", ublDocument.getId());
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
        return results.stream().map(f -> new UBLDocumentSendEventAdapter(session, em, organization, f)).collect(Collectors.toList());
    }

    @Override
    public int sendEventCount() {
        Object count = em.createNamedQuery("getDocumentSendEventCountByDocument")
                .setParameter("documentId", ublDocument.getId())
                .getSingleResult();
        return ((Number) count).intValue();
    }

    @Override
    public int sendEventCount(Map<String, String> attributes) {
        StringBuilder builder = new StringBuilder("select count(u) from SendEventEntity u where u.ublDocument.id = :documentId");
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

        String q = builder.toString();
        Query query = em.createQuery(q);
        query.setParameter("documentId", ublDocument.getId());
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

        Object count = query.getSingleResult();
        return ((Number) count).intValue();
    }

    /**
     * Attatched documents
     */
    @Override
    public List<DocumentModel> getAttachedDocumentsAsOrigin() {
        TypedQuery<UBLDocumentEntity> query = em.createNamedQuery("getAttachedUBLDocumentDestinyByOrigin", UBLDocumentEntity.class);
        query.setParameter("ublDocumentOriginId", ublDocument.getId());
        return query.getResultList().stream().map(f -> new UBLDocumentAdapter(session, organization, em, f)).collect(Collectors.toList());
    }

    @Override
    public List<DocumentModel> getAttachedDocumentsAsDestiny() {
        TypedQuery<UBLDocumentEntity> query = em.createNamedQuery("getAttachedUBLDocumentOriginByDestiny", UBLDocumentEntity.class);
        query.setParameter("ublDocumentDestinyId", ublDocument.getId());
        return query.getResultList().stream().map(f -> new UBLDocumentAdapter(session, organization, em, f)).collect(Collectors.toList());
    }

    @Override
    public void addAttachedDocument(DocumentModel attachedDocument) {
        AttachedUBLDocumentEntity entity = new AttachedUBLDocumentEntity();
        entity.setUblDocumentOrigin(ublDocument);
        entity.setUblDocumentDestiny(UBLDocumentAdapter.toEntity(attachedDocument, em));
        em.persist(entity);
        ublDocument.getAttachedDocumentsAsOrigin().add(entity);
    }

    @Override
    public boolean removeAttachedDocument(DocumentModel attachedDocument) {
        boolean result = false;
        Iterator<AttachedUBLDocumentEntity> it = ublDocument.getAttachedDocumentsAsOrigin().iterator();
        while (it.hasNext()) {
            AttachedUBLDocumentEntity ublAttachedDocumentEntity = it.next();
            if (ublAttachedDocumentEntity.getUblDocumentDestiny().getId().equals(attachedDocument.getId())) {
                it.remove();
                em.remove(ublAttachedDocumentEntity);
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
