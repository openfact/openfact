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
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.AllowanceChargeModel;
import org.openfact.models.CustomerPartyModel;
import org.openfact.models.DebitNoteModel;
import org.openfact.models.MonetaryTotalModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.SupplierPartyModel;
import org.openfact.models.TaxTotalModel;
import org.openfact.models.enums.RequiredActionDocument;
import org.openfact.models.jpa.entities.AllowanceChargeEntity;
import org.openfact.models.jpa.entities.CustomerPartyEntity;
import org.openfact.models.jpa.entities.DebitNoteEntity;
import org.openfact.models.jpa.entities.DebitNoteRequiredActionEntity;
import org.openfact.models.jpa.entities.MonetaryTotalEntity;
import org.openfact.models.jpa.entities.SupplierPartyEntity;
import org.openfact.models.jpa.entities.TaxTotalEntity;

public class DebitNoteAdapter implements DebitNoteModel, JpaModel<DebitNoteEntity> {

    protected static final Logger logger = Logger.getLogger(DebitNoteAdapter.class);

    protected OrganizationModel organization;
    protected DebitNoteEntity debitNote;
    protected EntityManager em;
    protected OpenfactSession session;

    public DebitNoteAdapter(OpenfactSession session, OrganizationModel organization, EntityManager em,
            DebitNoteEntity debitNote) {
        this.organization = organization;
        this.session = session;
        this.em = em;
        this.debitNote = debitNote;
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
    public SupplierPartyModel getAccountingSupplierParty() {
        if (debitNote.getAccountingCustomerParty() == null) {
            return null;
        }
        return new SupplierPartyAdapter(session, em, debitNote.getAccountingSupplierParty());
    }

    @Override
    public SupplierPartyModel getAccountingSupplierPartyAsNotNull() {
        if (debitNote.getAccountingCustomerParty() == null) {
            SupplierPartyEntity entity = new SupplierPartyEntity();
            debitNote.setAccountingSupplierParty(entity);
        }
        return new SupplierPartyAdapter(session, em, debitNote.getAccountingSupplierParty());
    }

    @Override
    public CustomerPartyModel getAccountingCustomerParty() {
        if (debitNote.getAccountingCustomerParty() == null) {
            return null;
        }
        return new CustomerPartyAdapter(session, em, debitNote.getAccountingCustomerParty());
    }

    @Override
    public CustomerPartyModel getAccountingCustomerPartyAsNotNull() {
        if (debitNote.getAccountingCustomerParty() == null) {
            CustomerPartyEntity entity = new CustomerPartyEntity();
            debitNote.setAccountingCustomerParty(entity);
        }
        return new CustomerPartyAdapter(session, em, debitNote.getAccountingCustomerParty());
    }

    @Override
    public MonetaryTotalModel getRequestedMonetaryTotal() {
        if (debitNote.getRequestedMonetaryTotal() == null) {
            return null;
        }
        return new MonetaryTotalAdapter(session, em, debitNote.getRequestedMonetaryTotal());
    }

    @Override
    public MonetaryTotalModel getRequestedMonetaryTotalAsNotNull() {
        if (debitNote.getRequestedMonetaryTotal() == null) {
            MonetaryTotalEntity entity = new MonetaryTotalEntity();
            debitNote.setRequestedMonetaryTotal(entity);
        }
        return new MonetaryTotalAdapter(session, em, debitNote.getRequestedMonetaryTotal());
    }

    @Override
    public List<TaxTotalModel> getTaxTotal() {
        return debitNote.getTaxTotal().stream().map(f -> new TaxTotalAdapter(session, em, f))
                .collect(Collectors.toList());
    }

    @Override
    public TaxTotalModel addTaxTotal() {
        List<TaxTotalEntity> entities = debitNote.getTaxTotal();

        TaxTotalEntity entity = new TaxTotalEntity();
        entities.add(entity);
        return new TaxTotalAdapter(session, em, entity);
    }

    @Override
    public List<AllowanceChargeModel> getAllowanceCharge() {
        return debitNote.getAllowanceCharge().stream().map(f -> new AllowanceChargeAdapter(session, em, f))
                .collect(Collectors.toList());
    }

    @Override
    public AllowanceChargeModel addAllowanceCharge() {
        List<AllowanceChargeEntity> entities = debitNote.getAllowanceCharge();

        AllowanceChargeEntity entity = new AllowanceChargeEntity();
        entities.add(entity);
        return new AllowanceChargeAdapter(session, em, entity);
    }

    @Override
    public byte[] getXmlDocument() {
        return debitNote.getXmlDocument();
    }

    @Override
    public void setXmlDocument(byte[] value) {
        debitNote.setXmlDocument(value);
    }

    @Override
    public void setAttribute(String name, String value) {
        debitNote.getAttributes().put(name, value);
    }

    @Override
    public void removeAttribute(String name) {
        debitNote.getAttributes().remove(name);
    }

    @Override
    public String getAttribute(String name) {
        return debitNote.getAttributes().get(name);
    }

    @Override
    public Map<String, String> getAttributes() {
        return debitNote.getAttributes();
    }

    @Override
    public Set<String> getRequiredActions() {
        Set<String> result = new HashSet<>();
        for (DebitNoteRequiredActionEntity attr : debitNote.getRequiredActions()) {
            result.add(attr.getAction());
        }
        return result;
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
    public void addRequiredAction(RequiredActionDocument action) {
        String actionName = action.name();
        addRequiredAction(actionName);
    }

    @Override
    public void removeRequiredAction(RequiredActionDocument action) {
        String actionName = action.name();
        removeRequiredAction(actionName);
    }

}
