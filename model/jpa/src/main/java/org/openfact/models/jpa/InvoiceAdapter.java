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
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.CustomerPartyModel;
import org.openfact.models.InvoiceModel;
import org.openfact.models.MonetaryTotalModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.ubl.SendEventModel;
import org.openfact.models.SupplierPartyModel;
import org.openfact.models.TaxTotalModel;
import org.openfact.models.enums.RequiredAction;
import org.openfact.models.jpa.entities.CustomerPartyEntity;
import org.openfact.models.jpa.entities.InvoiceEntity;
import org.openfact.models.jpa.entities.InvoiceRequiredActionEntity;
import org.openfact.models.jpa.entities.MonetaryTotalEntity;
import org.openfact.models.jpa.entities.SupplierPartyEntity;
import org.openfact.models.jpa.entities.TaxTotalEntity;

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

    @Override
    public void setAttribute(String name, String value) {
        invoice.getAttributes().put(name, value);
    }

    @Override
    public void removeAttribute(String name) {
        invoice.getAttributes().remove(name);
    }

    @Override
    public String getAttribute(String name) {
        return invoice.getAttributes().get(name);
    }

    @Override
    public Map<String, String> getAttributes() {
        return invoice.getAttributes();
    }

    @Override
    public Set<String> getRequiredActions() {
        Set<String> result = new HashSet<>();
        for (InvoiceRequiredActionEntity attr : invoice.getRequiredActions()) {
            result.add(attr.getAction());
        }
        return result;
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

    @Override
    public void addRequiredAction(RequiredAction action) {
        String actionName = action.name();
        addRequiredAction(actionName);
    }

    @Override
    public void removeRequiredAction(RequiredAction action) {
        String actionName = action.name();
        removeRequiredAction(actionName);
    }

    @Override
    public List<SendEventModel> getSendEvents() {
        return invoice.getSendEvents().stream().map(f -> new SendEventAdapter(session, organization, em, f))
                .collect(Collectors.toList());
    }
    
}
