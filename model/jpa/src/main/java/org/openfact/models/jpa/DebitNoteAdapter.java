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

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.xml.transform.TransformerException;

import com.helger.ubl21.UBL21Reader;
import oasis.names.specification.ubl.schema.xsd.debitnote_21.DebitNoteType;
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
import org.openfact.models.enums.SendResultType;
import org.openfact.models.jpa.entities.*;
import org.openfact.models.utils.OpenfactModelUtils;
import org.openfact.models.SendEventModel;
import org.openfact.models.enums.RequiredAction;
import org.w3c.dom.Document;

public class DebitNoteAdapter implements DebitNoteModel, JpaModel<DebitNoteEntity> {

    protected static final Logger logger = Logger.getLogger(DebitNoteAdapter.class);

    protected OrganizationModel organization;
    protected DebitNoteEntity debitNote;
    protected EntityManager em;
    protected OpenfactSession session;

    protected FileModel xmlFile;
    protected DebitNoteType debitNoteType;
    protected Document document;
    protected JSONObject jsonObject;

    public DebitNoteAdapter(OpenfactSession session, OrganizationModel organization, EntityManager em, DebitNoteEntity debitNote) {
        this.organization = organization;
        this.session = session;
        this.em = em;
        this.debitNote = debitNote;
    }
    
    public static DebitNoteEntity toEntity(DebitNoteModel model, EntityManager em) {
        if (model instanceof DebitNoteAdapter) {
            return ((DebitNoteAdapter) model).getEntity();
        }
        return em.getReference(DebitNoteEntity.class, model.getId());
    }

    @Override
    public DebitNoteEntity getEntity() {
        return debitNote;
    }

    @Override
    public String getId() {
        return debitNote.getId();
    }

    @Override
    public String getDocumentId() {
        return debitNote.getDocumentId();
    }

    @Override
    public LocalDateTime getCreatedTimestamp() {
        return debitNote.getCreatedTimestamp();
    }

    @Override
    public OrganizationModel getOrganization() {
        return organization;
    }

    @Override
    public LocalDateTime getIssueDateTime() {
        return debitNote.getIssueDateTime();
    }

    @Override
    public void setIssueDateTime(LocalDateTime value) {
        debitNote.setIssueDateTime(value);
    }

    @Override
    public String getDocumentCurrencyCode() {
        return debitNote.getDocumentCurrencyCode();
    }

    @Override
    public void setDocumentCurrencyCode(String value) {
        debitNote.setDocumentCurrencyCode(value);
    }

    @Override
    public String getCustomerRegistrationName() {
        return debitNote.getCustomerRegistrationName();
    }

    @Override
    public void setCustomerRegistrationName(String value) {
        debitNote.setCustomerRegistrationName(value);
    }

    @Override
    public String getCustomerAssignedAccountId() {
        return debitNote.getCustomerAssignedAccountId();
    }

    @Override
    public void setCustomerAssignedAccountId(String value) {
        debitNote.setCustomerAssignedAccountId(value);
    }

    @Override
    public String getCustomerElectronicMail() {
        return debitNote.getCustomerElectronicMail();
    }

    @Override
    public void setCustomerElectronicMail(String value) {
        debitNote.setCustomerElectronicMail(value);
    }

    @Override
    public BigDecimal getAllowanceTotalAmount() {
        return debitNote.getAllowanceTotalAmount();
    }

    @Override
    public void setAllowanceTotalAmount(BigDecimal value) {
        debitNote.setAllowanceTotalAmount(value);
    }

    @Override
    public BigDecimal getChargeTotalAmount() {
        return debitNote.getChargeTotalAmount();
    }

    @Override
    public void setChargeTotalAmount(BigDecimal value) {
        debitNote.setChargeTotalAmount(value);
    }

    @Override
    public BigDecimal getPayableAmount() {
        return debitNote.getPayableAmount();
    }

    @Override
    public void setPayableAmount(BigDecimal value) {
        debitNote.setPayableAmount(value);
    }

    @Override
    public DebitNoteType getDebitNoteType() {
        if (debitNoteType == null) {
            FileModel file = getXmlAsFile();
            if (file != null) {
                debitNoteType = UBL21Reader.debitNote().read(file.getFile());
            }
        }
        return debitNoteType;
    }

    @Override
    public FileModel getXmlAsFile() {
        if (xmlFile == null && debitNote.getXmlFileId() != null) {
            FileProvider provider = session.getProvider(FileProvider.class);
            xmlFile = provider.getFileById(organization, debitNote.getXmlFileId());
        }
        return xmlFile;
    }

    @Override
    public void attachXmlFile(FileModel file) {
        xmlFile = file;
        debitNote.setXmlFileId(xmlFile.getId());
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
                    jsonObject = JSONObjectUtils.getJSONObject(jsonObject, "DebitNote");
                }
            } catch (TransformerException e) {
                throw new ModelException("Error parsing xml file to JSON", e);
            }
        }
        return jsonObject;
    }


    /**
     * Attributes*/
    @Override
    public void setSingleAttribute(String name, String value) {
        String firstExistingAttrId = null;
        List<DebitNoteAttributeEntity> toRemove = new ArrayList<>();
        for (DebitNoteAttributeEntity attr : debitNote.getAttributes()) {
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
            Query query = em.createNamedQuery("deleteDebitNoteAttributesByNameAndDebitNoteOtherThan");
            query.setParameter("name", name);
            query.setParameter("debitNoteId", debitNote.getId());
            query.setParameter("attrId", firstExistingAttrId);
            int numUpdated = query.executeUpdate();

            // Remove attribute from local entity
            debitNote.getAttributes().removeAll(toRemove);
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
        DebitNoteAttributeEntity attr = new DebitNoteAttributeEntity();
        attr.setId(OpenfactModelUtils.generateId());
        attr.setName(name);
        attr.setValue(value);
        attr.setDebitNote(debitNote);
        em.persist(attr);
        debitNote.getAttributes().add(attr);
    }

    @Override
    public void removeAttribute(String name) {
        // Remove attribute through HQL to avoid StaleUpdateException
        Query query = em.createNamedQuery("deleteDebitNoteAttributesByNameAndDebitNote");
        query.setParameter("name", name);
        query.setParameter("debitNoteId", debitNote.getId());
        int numUpdated = query.executeUpdate();

        // Also remove attributes from local user entity
        List<DebitNoteAttributeEntity> toRemove = new ArrayList<>();
        for (DebitNoteAttributeEntity attr : debitNote.getAttributes()) {
            if (attr.getName().equals(name)) {
                toRemove.add(attr);
            }
        }
        debitNote.getAttributes().removeAll(toRemove);
    }

    @Override
    public String getFirstAttribute(String name) {
        for (DebitNoteAttributeEntity attr : debitNote.getAttributes()) {
            if (attr.getName().equals(name)) {
                return attr.getValue();
            }
        }
        return null;
    }

    @Override
    public List<String> getAttribute(String name) {
        List<String> result = new ArrayList<>();
        for (DebitNoteAttributeEntity attr : debitNote.getAttributes()) {
            if (attr.getName().equals(name)) {
                result.add(attr.getValue());
            }
        }
        return result;
    }

    @Override
    public Map<String, List<String>> getAttributes() {
        MultivaluedHashMap<String, String> result = new MultivaluedHashMap<>();
        for (DebitNoteAttributeEntity attr : debitNote.getAttributes()) {
            result.add(attr.getName(), attr.getValue());
        }
        return result;
    }

    /**
     * Required actions*/
    @Override
    public Set<String> getRequiredActions() {
        Set<String> result = new HashSet<>();
        for (DebitNoteRequiredActionEntity attr : debitNote.getRequiredActions()) {
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
        for (DebitNoteRequiredActionEntity attr : debitNote.getRequiredActions()) {
            if (attr.getAction().equals(actionName)) {
                return;
            }
        }
        DebitNoteRequiredActionEntity attr = new DebitNoteRequiredActionEntity();
        attr.setAction(actionName);
        attr.setDebitNote(debitNote);
        em.persist(attr);
        debitNote.getRequiredActions().add(attr);
    }

    @Override
    public void removeRequiredAction(RequiredAction action) {
        String actionName = action.name();
        removeRequiredAction(actionName);
    }

    /**
     * Send events*/
    @Override
    public SendEventModel addSendEvent(DestinyType destinyType) {
        DebitNoteSendEventEntity entity = new DebitNoteSendEventEntity();
        entity.setCreatedTimestamp(LocalDateTime.now());
        entity.setResult(SendResultType.ON_PROCESS);
        entity.setDestinyType(destinyType);
        entity.setDebitNote(debitNote);
        em.persist(entity);
        em.flush();

        return new SendEventAdapter(session, em, organization, entity);
    }

    @Override
    public SendEventModel getSendEventById(String id) {
        SendEventEntity entity = em.find(SendEventEntity.class, id);
        if(entity != null) {
            return new SendEventAdapter(session, em, organization, entity);
        }
        return null;
    }

    @Override
    public boolean removeSendEvent(String id) {
        SendEventEntity entity = em.find(SendEventEntity.class, id);
        if (entity == null)
            return false;

        em.remove(entity);
        em.flush();
        return true;
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
        String queryName = "getAllSendEventByDebitNoteId";

        TypedQuery<SendEventEntity> query = em.createNamedQuery(queryName, SendEventEntity.class);
        query.setParameter("debitNoteId", debitNote.getId());
        if (firstResult != -1) {
            query.setFirstResult(firstResult);
        }
        if (maxResults != -1) {
            query.setMaxResults(maxResults);
        }
        List<SendEventEntity> results = query.getResultList();
        List<SendEventModel> sendEvents = results.stream().map(f -> new SendEventAdapter(session, em, organization, f)).collect(Collectors.toList());
        return sendEvents;
    }

    @Override
    public List<SendEventModel> searchForSendEvent(Map<String, String> params) {
        return searchForSendEvent(params, -1, -1);
    }

    @Override
    public List<SendEventModel> searchForSendEvent(Map<String, String> attributes, int firstResult, int maxResults) {
        StringBuilder builder = new StringBuilder("select u from DebitNoteSendEventEntity u where u.debitNote.id = :debitNoteId");
        for (Map.Entry<String, String> entry : attributes.entrySet()) {
            String attribute = null;
            String parameterName = null;
            String operator = null;
            if (entry.getKey().equals(DebitNoteModel.SEND_EVENT_DESTINY_TYPE)) {
                attribute = "u.destinyType";
                parameterName = JpaDebitNoteProvider.SEND_EVENT_DESTINY_TYPE;
                operator = " = :";
            } else if (entry.getKey().equals(DebitNoteModel.SEND_EVENT_TYPE)) {
                attribute = "lower(u.type)";
                parameterName = JpaDebitNoteProvider.SEND_EVENT_TYPE;
                operator = " like :";
            } else if (entry.getKey().equals(DebitNoteModel.SEND_EVENT_RESULT)) {
                attribute = "u.result";
                parameterName = JpaDebitNoteProvider.SEND_EVENT_RESULT;
                operator = " = :";
            }
            if (attribute == null) continue;
            builder.append(" and ");
            builder.append(attribute).append(operator).append(parameterName);
        }
        builder.append(" order by u.createdTimestamp");
        String q = builder.toString();
        TypedQuery<DebitNoteSendEventEntity> query = em.createQuery(q, DebitNoteSendEventEntity.class);
        query.setParameter("debitNoteId", debitNote.getId());
        for (Map.Entry<String, String> entry : attributes.entrySet()) {
            String parameterName = null;
            Object parameterValue = null;
            if (entry.getKey().equals(DebitNoteModel.SEND_EVENT_DESTINY_TYPE)) {
                parameterName = JpaDebitNoteProvider.SEND_EVENT_DESTINY_TYPE;
                parameterValue = DestinyType.valueOf(entry.getValue().toUpperCase());
            } else if (entry.getKey().equals(DebitNoteModel.SEND_EVENT_TYPE)) {
                parameterName = JpaDebitNoteProvider.SEND_EVENT_TYPE;
                parameterValue = "%" + entry.getValue().toLowerCase() + "%";
            } else if (entry.getKey().equals(DebitNoteModel.SEND_EVENT_RESULT)) {
                parameterName = JpaDebitNoteProvider.SEND_EVENT_RESULT;
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
        List<DebitNoteSendEventEntity> results = query.getResultList();
        return results.stream().map(f -> new SendEventAdapter(session, em, organization, f)).collect(Collectors.toList());
    }

    @Override
    public int sendEventCount() {
        Object count = em.createNamedQuery("getDebitNoteSendEventCountByDebitNote")
                .setParameter("debitNoteId", debitNote.getId())
                .getSingleResult();
        return ((Number)count).intValue();
    }

    @Override
    public int sendEventCount(Map<String, String> attributes) {
        StringBuilder builder = new StringBuilder("select count(u) from DebitNoteSendEventEntity u where u.debitNote.id = :debitNoteId");
        for (Map.Entry<String, String> entry : attributes.entrySet()) {
            String attribute = null;
            String parameterName = null;
            String operator = null;
            if (entry.getKey().equals(DebitNoteModel.SEND_EVENT_DESTINY_TYPE)) {
                attribute = "u.destinyType";
                parameterName = JpaDebitNoteProvider.SEND_EVENT_DESTINY_TYPE;
                operator = " = :";
            }
            if (entry.getKey().equals(DebitNoteModel.SEND_EVENT_TYPE)) {
                attribute = "lower(u.type)";
                parameterName = JpaDebitNoteProvider.SEND_EVENT_TYPE;
                operator = " like :";
            }
            if (entry.getKey().equals(DebitNoteModel.SEND_EVENT_RESULT)) {
                attribute = "u.result";
                parameterName = JpaDebitNoteProvider.SEND_EVENT_RESULT;
                operator = " = :";
            }
            if (attribute == null) continue;
            builder.append(" and ");
            builder.append(attribute).append(operator).append(parameterName);
        }

        String q = builder.toString();
        Query query = em.createQuery(q);
        query.setParameter("debitNoteId", debitNote.getId());
        for (Map.Entry<String, String> entry : attributes.entrySet()) {
            String parameterName = null;
            Object parameterValue = null;
            if (entry.getKey().equals(DebitNoteModel.SEND_EVENT_DESTINY_TYPE)) {
                parameterName = JpaDebitNoteProvider.SEND_EVENT_DESTINY_TYPE;
                parameterValue = DestinyType.valueOf(entry.getValue().toUpperCase());
            }
            if (entry.getKey().equals(DebitNoteModel.SEND_EVENT_TYPE)) {
                parameterName = JpaDebitNoteProvider.SEND_EVENT_TYPE;
                parameterValue = "%" + entry.getValue().toLowerCase() + "%";
            }
            if (entry.getKey().equals(DebitNoteModel.SEND_EVENT_RESULT)) {
                parameterName = JpaDebitNoteProvider.SEND_EVENT_RESULT;
                parameterValue = SendResultType.valueOf(entry.getValue().toUpperCase());
            }
            if (parameterName == null) continue;
            query.setParameter(parameterName, parameterValue);
        }

        Object count = query.getSingleResult();
        return ((Number)count).intValue();
    }

    /**
     * Attatched documents*/
    @Override
    public List<AttatchedDocumentModel> getAttatchedDocuments() {
        return debitNote.getAttatchedDocuments().stream().map(f -> new AttatchedDocumentAdapter(session, organization, em, f)).collect(Collectors.toList());
    }

    @Override
    public AttatchedDocumentModel getAttatchedDocumentById(String id) {
        DebitNoteAttatchedDocumentEntity entity = em.find(DebitNoteAttatchedDocumentEntity.class, id);
        if(entity == null) return null;
        return new AttatchedDocumentAdapter(session, organization, em, entity);
    }

    @Override
    public AttatchedDocumentModel addAttatchedDocument(DocumentType documentType, String documentId) {
        DebitNoteAttatchedDocumentEntity entity = new DebitNoteAttatchedDocumentEntity();
        entity.setDocumentType(documentType);
        entity.setDocumentId(documentId);
        entity.setDebitNote(debitNote);
        em.persist(entity);
        em.flush();
        debitNote.getAttatchedDocuments().add(entity);
        return new AttatchedDocumentAdapter(session, organization, em, entity);
    }

    @Override
    public boolean removeAttatchedDocument(AttatchedDocumentModel attatchedDocument) {
        boolean result = false;
        Iterator<DebitNoteAttatchedDocumentEntity> it = debitNote.getAttatchedDocuments().iterator();
        while (it.hasNext()) {
            DebitNoteAttatchedDocumentEntity attr = it.next();
            if (attr.getId().equals(attatchedDocument.getId())) {
                it.remove();
                em.remove(attr);
                result = true;
            }
        }
        return result;
    }

    /**
     * Required actions*/
    @Override
    public void removeRequiredAction(String actionName) {
        Iterator<DebitNoteRequiredActionEntity> it = debitNote.getRequiredActions().iterator();
        while (it.hasNext()) {
            DebitNoteRequiredActionEntity attr = it.next();
            if (attr.getAction().equals(actionName)) {
                it.remove();
                em.remove(attr);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof DebitNoteModel)) return false;

        DebitNoteModel that = (DebitNoteModel) o;
        return that.getId().equals(getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
    
}
