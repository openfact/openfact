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
import java.util.*;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.jboss.logging.Logger;
import org.openfact.common.util.MultivaluedHashMap;
import org.openfact.models.*;
import org.openfact.models.jpa.entities.*;
import org.openfact.models.utils.OpenfactModelUtils;
import org.openfact.ubl.SendEventModel;
import org.openfact.models.enums.RequiredAction;

public class InvoiceAdapter implements InvoiceModel, JpaModel<InvoiceEntity> {

    protected static final Logger logger = Logger.getLogger(InvoiceAdapter.class);

    protected OrganizationModel organization;
    protected InvoiceEntity invoice;
    protected EntityManager em;
    protected OpenfactSession session;

    public InvoiceAdapter(OpenfactSession session, OrganizationModel organization, EntityManager em,
            InvoiceEntity invoice) {
        this.organization = organization;
        this.session = session;
        this.em = em;
        this.invoice = invoice;
    }

    public static InvoiceEntity toEntity(InvoiceModel model, EntityManager em) {
        if (model instanceof InvoiceAdapter) {
            return ((InvoiceAdapter) model).getEntity();
        }
        return em.getReference(InvoiceEntity.class, model.getId());
    }
    
    @Override
    public InvoiceEntity getEntity() {
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
    public SupplierPartyModel getAccountingSupplierParty() {
        if (invoice.getAccountingCustomerParty() == null) {
            return null;
        }
        return new SupplierPartyAdapter(session, em, invoice.getAccountingSupplierParty());
    }

    @Override
    public SupplierPartyModel getAccountingSupplierPartyAsNotNull() {
        if (invoice.getAccountingCustomerParty() == null) {
            SupplierPartyEntity entity = new SupplierPartyEntity();
            invoice.setAccountingSupplierParty(entity);
        }
        return new SupplierPartyAdapter(session, em, invoice.getAccountingSupplierParty());
    }

    @Override
    public CustomerPartyModel getAccountingCustomerParty() {
        if (invoice.getAccountingCustomerParty() == null) {
            return null;
        }
        return new CustomerPartyAdapter(session, em, invoice.getAccountingCustomerParty());
    }

    @Override
    public CustomerPartyModel getAccountingCustomerPartyAsNotNull() {
        if (invoice.getAccountingCustomerParty() == null) {
            CustomerPartyEntity entity = new CustomerPartyEntity();
            invoice.setAccountingCustomerParty(entity);
        }
        return new CustomerPartyAdapter(session, em, invoice.getAccountingCustomerParty());
    }

    @Override
    public MonetaryTotalModel getLegalMonetaryTotal() {
        if (invoice.getLegalMonetaryTotal() == null) {
            return null;
        }
        return new MonetaryTotalAdapter(session, em, invoice.getLegalMonetaryTotal());
    }

    @Override
    public MonetaryTotalModel getLegalMonetaryTotalAsNotNull() {
        if (invoice.getLegalMonetaryTotal() == null) {
            MonetaryTotalEntity entity = new MonetaryTotalEntity();
            invoice.setLegalMonetaryTotal(entity);
        }
        return new MonetaryTotalAdapter(session, em, invoice.getLegalMonetaryTotal());
    }

    @Override
    public List<TaxTotalModel> getTaxTotal() {
        return invoice.getTaxTotal().stream().map(f -> new TaxTotalAdapter(session, em, f))
                .collect(Collectors.toList());
    }

    @Override
    public TaxTotalModel addTaxTotal() {
        List<TaxTotalEntity> entities = invoice.getTaxTotal();

        TaxTotalEntity entity = new TaxTotalEntity();
        entities.add(entity);
        return new TaxTotalAdapter(session, em, entity);
    }

    @Override
    public byte[] getXmlDocument() {
        return invoice.getXmlDocument();
    }

    @Override
    public void setXmlDocument(byte[] value) {
        invoice.setXmlDocument(value);
    }

    /**
     * Attributes*/
    @Override
    public void setSingleAttribute(String name, String value) {
        String firstExistingAttrId = null;
        List<InvoiceAttributeEntity> toRemove = new ArrayList<>();
        for (InvoiceAttributeEntity attr : invoice.getAttributes()) {
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
        InvoiceAttributeEntity attr = new InvoiceAttributeEntity();
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
        List<InvoiceAttributeEntity> toRemove = new ArrayList<>();
        for (InvoiceAttributeEntity attr : invoice.getAttributes()) {
            if (attr.getName().equals(name)) {
                toRemove.add(attr);
            }
        }
        invoice.getAttributes().removeAll(toRemove);
    }

    @Override
    public String getFirstAttribute(String name) {
        for (InvoiceAttributeEntity attr : invoice.getAttributes()) {
            if (attr.getName().equals(name)) {
                return attr.getValue();
            }
        }
        return null;
    }

    @Override
    public List<String> getAttribute(String name) {
        List<String> result = new ArrayList<>();
        for (InvoiceAttributeEntity attr : invoice.getAttributes()) {
            if (attr.getName().equals(name)) {
                result.add(attr.getValue());
            }
        }
        return result;
    }

    @Override
    public Map<String, List<String>> getAttributes() {
        MultivaluedHashMap<String, String> result = new MultivaluedHashMap<>();
        for (InvoiceAttributeEntity attr : invoice.getAttributes()) {
            result.add(attr.getName(), attr.getValue());
        }
        return result;
    }

    /**
     * Required actions*/
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
     * Send events*/
    @Override
    public List<SendEventModel> getSendEvents() {
        return invoice.getSendEvents().stream().map(f -> new SendEventAdapter(session, organization, em, f))
                .collect(Collectors.toList());
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
