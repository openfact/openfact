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

import org.jboss.logging.Logger;
import org.openfact.common.util.MultivaluedHashMap;
import org.openfact.file.FileModel;
import org.openfact.file.FileProvider;
import org.openfact.models.*;
import org.openfact.models.enums.DestinyType;
import org.openfact.models.enums.SendResultType;
import org.openfact.models.jpa.entities.*;
import org.openfact.models.utils.OpenfactModelUtils;
import org.openfact.models.SendEventModel;
import org.openfact.models.enums.RequiredAction;

public class DebitNoteAdapter implements DebitNoteModel, JpaModel<DebitNoteEntity> {

    protected static final Logger logger = Logger.getLogger(DebitNoteAdapter.class);

    protected OrganizationModel organization;
    protected DebitNoteEntity debitNote;
    protected EntityManager em;
    protected OpenfactSession session;

    protected FileModel xmlFile;

    public DebitNoteAdapter(OpenfactSession session, OrganizationModel organization, EntityManager em,
            DebitNoteEntity debitNote) {
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
    public byte[] getXmlDocument() {
        FileModel file = getXmlFile();
        if(file != null) {
            return file.getFile();
        } else {
            return null;
        }
    }

    @Override
    public void setXmlDocument(byte[] value) {
        setXmlFileContent(value);
    }

    @Override
    public FileModel getXmlFile() {
        if(xmlFile == null && debitNote.getXmlFileId() != null) {
            FileProvider provider = session.getProvider(FileProvider.class);
            xmlFile = provider.getFileById(organization, debitNote.getXmlFileId());
        }
        return xmlFile;
    }

    @Override
    public void setXmlFileContent(byte[] value) {
        FileModel file = getXmlFile();
        FileProvider provider = session.getProvider(FileProvider.class);
        if(file != null) {
            provider.removeFile(organization, file);
        }
        xmlFile = provider.createFile(organization, OpenfactModelUtils.generateId() + ".xml", value);
        debitNote.setXmlFileId(xmlFile.getId());
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
        entity.setDestityType(destinyType);
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
    public boolean removeSendEvent(OrganizationModel organization, String id) {
        SendEventEntity entity = em.find(SendEventEntity.class, id);
        if (entity == null)
            return false;

        em.remove(entity);
        em.flush();
        return true;
    }

    @Override
    public boolean removeSendEvent(OrganizationModel organization, SendEventModel sendEvent) {
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
