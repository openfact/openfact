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
import oasis.names.specification.ubl.schema.xsd.invoice_21.InvoiceType;
import org.jboss.logging.Logger;
import org.json.JSONObject;
import org.json.XML;
import org.openfact.JSONObjectUtils;
import org.openfact.common.converts.DocumentUtils;
import org.openfact.common.util.MultivaluedHashMap;
import org.openfact.file.*;
import org.openfact.file.FileModel;
import org.openfact.models.*;
import org.openfact.models.enums.DestinyType;
import org.openfact.models.enums.DocumentType;
import org.openfact.models.enums.SendResultType;
import org.openfact.models.jpa.entities.*;
import org.openfact.models.utils.OpenfactModelUtils;
import org.openfact.models.SendEventModel;
import org.openfact.models.enums.RequiredAction;
import org.w3c.dom.Document;

public class InvoiceAdapter implements InvoiceModel, JpaModel<UblDocumentEntity> {

    protected static final Logger logger = Logger.getLogger(InvoiceAdapter.class);

    protected OrganizationModel organization;
    protected UblDocumentEntity invoice;
    protected EntityManager em;
    protected OpenfactSession session;

    protected FileModel xmlFile;
    protected InvoiceType invoiceType;
    protected Document document;
    protected JSONObject jsonObject;

    public InvoiceAdapter(OpenfactSession session, OrganizationModel organization, EntityManager em, UblDocumentEntity invoice) {
        this.organization = organization;
        this.session = session;
        this.em = em;
        this.invoice = invoice;
    }

    public static UblDocumentEntity toEntity(InvoiceModel model, EntityManager em) {
        if (model instanceof InvoiceAdapter) {
            return ((InvoiceAdapter) model).getEntity();
        }
        return em.getReference(UblDocumentEntity.class, model.getId());
    }

    @Override
    public UblDocumentEntity getEntity() {
        return invoice;
    }

    @Override
    public String getId() {
        return invoice.getId();
    }

    @Override
    public String getDocumentId() {
        return invoice.getDocumentId();
    }

    @Override
    public LocalDateTime getCreatedTimestamp() {
        return invoice.getCreatedTimestamp();
    }

    @Override
    public OrganizationModel getOrganization() {
        return organization;
    }

    @Override
    public String getInvoiceTypeCode() {
        return invoice.getInvoiceTypeCode();
    }

    @Override
    public void setInvoiceTypeCode(String value) {
        invoice.setInvoiceTypeCode(value);
    }

    @Override
    public LocalDateTime getIssueDateTime() {
        return invoice.getIssueDateTime();
    }

    @Override
    public void setIssueDateTime(LocalDateTime value) {
        invoice.setIssueDateTime(value);
    }

    @Override
    public String getDocumentCurrencyCode() {
        return invoice.getDocumentCurrencyCode();
    }

    @Override
    public void setDocumentCurrencyCode(String value) {
        invoice.setDocumentCurrencyCode(value);
    }

    @Override
    public String getCustomerRegistrationName() {
        return invoice.getCustomerRegistrationName();
    }

    @Override
    public void setCustomerRegistrationName(String value) {
        invoice.setCustomerRegistrationName(value);
    }

    @Override
    public String getCustomerAdditionalAccountId() {
        return invoice.getCustomerAdditionalAccountId();
    }

    @Override
    public void setCustomerAdditionalAccountId(String value) {
        invoice.setCustomerAdditionalAccountId(value);
    }

    @Override
    public String getCustomerAssignedAccountId() {
        return invoice.getCustomerAssignedAccountId();
    }

    @Override
    public void setCustomerAssignedAccountId(String value) {
        invoice.setCustomerAssignedAccountId(value);
    }

    @Override
    public String getCustomerElectronicMail() {
        return invoice.getCustomerElectronicMail();
    }

    @Override
    public void setCustomerElectronicMail(String value) {
        invoice.setCustomerElectronicMail(value);
    }

    @Override
    public BigDecimal getAllowanceTotalAmount() {
        return invoice.getAllowanceTotalAmount();
    }

    @Override
    public void setAllowanceTotalAmount(BigDecimal value) {
        invoice.setAllowanceTotalAmount(value);
    }

    @Override
    public BigDecimal getChargeTotalAmount() {
        return invoice.getChargeTotalAmount();
    }

    @Override
    public void setChargeTotalAmount(BigDecimal value) {
        invoice.setChargeTotalAmount(value);
    }

    @Override
    public BigDecimal getPayableAmount() {
        return invoice.getPayableAmount();
    }

    @Override
    public void setPayableAmount(BigDecimal value) {
        invoice.setPayableAmount(value);
    }

    @Override
    public InvoiceType getInvoiceType() {
        if (invoiceType == null) {
            FileModel file = getXmlAsFile();
            if (file != null) {
                invoiceType = UBL21Reader.invoice().read(file.getFile());
            }
        }
        return invoiceType;
    }

    @Override
    public FileModel getXmlAsFile() {
        if (xmlFile == null && invoice.getXmlFileId() != null) {
            FileProvider provider = session.getProvider(FileProvider.class);
            xmlFile = provider.getFileById(organization, invoice.getXmlFileId());
        }
        return xmlFile;
    }

    @Override
    public void attachXmlFile(FileModel file) {
        xmlFile = file;
        invoice.setXmlFileId(xmlFile.getId());
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
        List<UblDocumentAttributeEntity> toRemove = new ArrayList<>();
        for (UblDocumentAttributeEntity attr : invoice.getAttributes()) {
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
            Query query = em.createNamedQuery("deleteInvoiceAttributesByNameAndInvoiceOtherThan");
            query.setParameter("name", name);
            query.setParameter("invoiceId", invoice.getId());
            query.setParameter("attrId", firstExistingAttrId);
            int numUpdated = query.executeUpdate();

            // Remove attribute from local entity
            invoice.getAttributes().removeAll(toRemove);
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
        UblDocumentAttributeEntity attr = new UblDocumentAttributeEntity();
        attr.setId(OpenfactModelUtils.generateId());
        attr.setName(name);
        attr.setValue(value);
        attr.setInvoice(invoice);
        em.persist(attr);
        invoice.getAttributes().add(attr);
    }

    @Override
    public void removeAttribute(String name) {
        // Remove attribute through HQL to avoid StaleUpdateException
        Query query = em.createNamedQuery("deleteInvoiceAttributesByNameAndInvoice");
        query.setParameter("name", name);
        query.setParameter("invoiceId", invoice.getId());
        int numUpdated = query.executeUpdate();

        // Also remove attributes from local user entity
        List<UblDocumentAttributeEntity> toRemove = new ArrayList<>();
        for (UblDocumentAttributeEntity attr : invoice.getAttributes()) {
            if (attr.getName().equals(name)) {
                toRemove.add(attr);
            }
        }
        invoice.getAttributes().removeAll(toRemove);
    }

    @Override
    public String getFirstAttribute(String name) {
        for (UblDocumentAttributeEntity attr : invoice.getAttributes()) {
            if (attr.getName().equals(name)) {
                return attr.getValue();
            }
        }
        return null;
    }

    @Override
    public List<String> getAttribute(String name) {
        List<String> result = new ArrayList<>();
        for (UblDocumentAttributeEntity attr : invoice.getAttributes()) {
            if (attr.getName().equals(name)) {
                result.add(attr.getValue());
            }
        }
        return result;
    }

    @Override
    public Map<String, List<String>> getAttributes() {
        MultivaluedHashMap<String, String> result = new MultivaluedHashMap<>();
        for (UblDocumentAttributeEntity attr : invoice.getAttributes()) {
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
        for (InvoiceRequiredActionEntity attr : invoice.getRequiredActions()) {
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
        for (InvoiceRequiredActionEntity attr : invoice.getRequiredActions()) {
            if (attr.getAction().equals(actionName)) {
                return;
            }
        }
        InvoiceRequiredActionEntity attr = new InvoiceRequiredActionEntity();
        attr.setAction(actionName);
        attr.setInvoice(invoice);
        em.persist(attr);
        invoice.getRequiredActions().add(attr);
    }

    @Override
    public void removeRequiredAction(RequiredAction action) {
        String actionName = action.name();
        removeRequiredAction(actionName);
    }

    @Override
    public void removeRequiredAction(String actionName) {
        Iterator<InvoiceRequiredActionEntity> it = invoice.getRequiredActions().iterator();
        while (it.hasNext()) {
            InvoiceRequiredActionEntity attr = it.next();
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
        InvoiceSendEventEntity entity = new InvoiceSendEventEntity();
        entity.setCreatedTimestamp(LocalDateTime.now());
        entity.setResult(SendResultType.ON_PROCESS);
        entity.setDestinyType(destinyType);
        entity.setInvoice(invoice);
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
        String queryName = "getAllSendEventByInvoiceId";

        TypedQuery<SendEventEntity> query = em.createNamedQuery(queryName, SendEventEntity.class);
        query.setParameter("invoiceId", invoice.getId());
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
        StringBuilder builder = new StringBuilder("select u from InvoiceSendEventEntity u where u.invoice.id = :invoiceId");
        for (Map.Entry<String, String> entry : attributes.entrySet()) {
            String attribute = null;
            String parameterName = null;
            String operator = null;
            if (entry.getKey().equals(InvoiceModel.SEND_EVENT_DESTINY_TYPE)) {
                attribute = "u.destinyType";
                parameterName = JpaInvoiceProvider.SEND_EVENT_DESTINY_TYPE;
                operator = " = :";
            } else if (entry.getKey().equals(InvoiceModel.SEND_EVENT_TYPE)) {
                attribute = "lower(u.type)";
                parameterName = JpaInvoiceProvider.SEND_EVENT_TYPE;
                operator = " like :";
            } else if (entry.getKey().equals(InvoiceModel.SEND_EVENT_RESULT)) {
                attribute = "u.result";
                parameterName = JpaInvoiceProvider.SEND_EVENT_RESULT;
                operator = " = :";
            }
            if (attribute == null) continue;
            builder.append(" and ");
            builder.append(attribute).append(operator).append(parameterName);
        }
        builder.append(" order by u.createdTimestamp");
        String q = builder.toString();
        TypedQuery<InvoiceSendEventEntity> query = em.createQuery(q, InvoiceSendEventEntity.class);
        query.setParameter("invoiceId", invoice.getId());
        for (Map.Entry<String, String> entry : attributes.entrySet()) {
            String parameterName = null;
            Object parameterValue = null;
            if (entry.getKey().equals(InvoiceModel.SEND_EVENT_DESTINY_TYPE)) {
                parameterName = JpaInvoiceProvider.SEND_EVENT_DESTINY_TYPE;
                parameterValue = DestinyType.valueOf(entry.getValue().toUpperCase());
            } else if (entry.getKey().equals(InvoiceModel.SEND_EVENT_TYPE)) {
                parameterName = JpaInvoiceProvider.SEND_EVENT_TYPE;
                parameterValue = "%" + entry.getValue().toLowerCase() + "%";
            } else if (entry.getKey().equals(InvoiceModel.SEND_EVENT_RESULT)) {
                parameterName = JpaInvoiceProvider.SEND_EVENT_RESULT;
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
        List<InvoiceSendEventEntity> results = query.getResultList();
        return results.stream().map(f -> new SendEventAdapter(session, em, organization, f)).collect(Collectors.toList());
    }

    @Override
    public int sendEventCount() {
        Object count = em.createNamedQuery("getInvoiceSendEventCountByInvoice")
                .setParameter("invoiceId", invoice.getId())
                .getSingleResult();
        return ((Number)count).intValue();
    }

    @Override
    public int sendEventCount(Map<String, String> attributes) {
        StringBuilder builder = new StringBuilder("select count(u) from InvoiceSendEventEntity u where u.invoice.id = :invoiceId");
        for (Map.Entry<String, String> entry : attributes.entrySet()) {
            String attribute = null;
            String parameterName = null;
            String operator = null;
            if (entry.getKey().equals(InvoiceModel.SEND_EVENT_DESTINY_TYPE)) {
                attribute = "u.destinyType";
                parameterName = JpaInvoiceProvider.SEND_EVENT_DESTINY_TYPE;
                operator = " = :";
            }
            if (entry.getKey().equals(InvoiceModel.SEND_EVENT_TYPE)) {
                attribute = "lower(u.type)";
                parameterName = JpaInvoiceProvider.SEND_EVENT_TYPE;
                operator = " like :";
            }
            if (entry.getKey().equals(InvoiceModel.SEND_EVENT_RESULT)) {
                attribute = "u.result";
                parameterName = JpaInvoiceProvider.SEND_EVENT_RESULT;
                operator = " = :";
            }
            if (attribute == null) continue;
            builder.append(" and ");
            builder.append(attribute).append(operator).append(parameterName);
        }

        String q = builder.toString();
        Query query = em.createQuery(q);
        query.setParameter("invoiceId", invoice.getId());
        for (Map.Entry<String, String> entry : attributes.entrySet()) {
            String parameterName = null;
            Object parameterValue = null;
            if (entry.getKey().equals(InvoiceModel.SEND_EVENT_DESTINY_TYPE)) {
                parameterName = JpaInvoiceProvider.SEND_EVENT_DESTINY_TYPE;
                parameterValue = DestinyType.valueOf(entry.getValue().toUpperCase());
            }
            if (entry.getKey().equals(InvoiceModel.SEND_EVENT_TYPE)) {
                parameterName = JpaInvoiceProvider.SEND_EVENT_TYPE;
                parameterValue = "%" + entry.getValue().toLowerCase() + "%";
            }
            if (entry.getKey().equals(InvoiceModel.SEND_EVENT_RESULT)) {
                parameterName = JpaInvoiceProvider.SEND_EVENT_RESULT;
                parameterValue = SendResultType.valueOf(entry.getValue().toUpperCase());
            }
            if (parameterName == null) continue;
            query.setParameter(parameterName, parameterValue);
        }

        Object count = query.getSingleResult();
        return ((Number)count).intValue();
    }

    /**
     * Attatched documents
     */
    @Override
    public List<AttatchedDocumentModel> getAttatchedDocuments() {
        return invoice.getAttatchedDocuments().stream().map(f -> new AttatchedDocumentAdapter(session, organization, em, f)).collect(Collectors.toList());
    }

    @Override
    public AttatchedDocumentModel getAttatchedDocumentById(String id) {
        InvoiceAttatchedDocumentEntity entity = em.find(InvoiceAttatchedDocumentEntity.class, id);
        if (entity == null) return null;
        return new AttatchedDocumentAdapter(session, organization, em, entity);
    }

    @Override
    public AttatchedDocumentModel addAttatchedDocument(DocumentType documentType, String documentId) {
        InvoiceAttatchedDocumentEntity entity = new InvoiceAttatchedDocumentEntity();
        entity.setDocumentType(documentType);
        entity.setDocumentId(documentId);
        entity.setInvoice(invoice);
        em.persist(entity);
        em.flush();
        invoice.getAttatchedDocuments().add(entity);
        return new AttatchedDocumentAdapter(session, organization, em, entity);
    }

    @Override
    public boolean removeAttatchedDocument(AttatchedDocumentModel attatchedDocument) {
        boolean result = false;
        Iterator<InvoiceAttatchedDocumentEntity> it = invoice.getAttatchedDocuments().iterator();
        while (it.hasNext()) {
            InvoiceAttatchedDocumentEntity attr = it.next();
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
        if (o == null || !(o instanceof InvoiceModel)) return false;

        InvoiceModel that = (InvoiceModel) o;
        return that.getId().equals(getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }

}
