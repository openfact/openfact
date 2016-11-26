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
import org.openfact.models.CreditNoteModel;
import org.openfact.models.CustomerPartyModel;
import org.openfact.models.InvoiceModel;
import org.openfact.models.MonetaryTotalModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.ResponseModel;
import org.openfact.models.SendEventModel;
import org.openfact.models.SupplierPartyModel;
import org.openfact.models.TaxTotalModel;
import org.openfact.models.enums.RequiredAction;
import org.openfact.models.jpa.entities.AllowanceChargeEntity;
import org.openfact.models.jpa.entities.CreditNoteEntity;
import org.openfact.models.jpa.entities.CreditNoteRequiredActionEntity;
import org.openfact.models.jpa.entities.CustomerPartyEntity;
import org.openfact.models.jpa.entities.InvoiceEntity;
import org.openfact.models.jpa.entities.MonetaryTotalEntity;
import org.openfact.models.jpa.entities.ResponseEntity;
import org.openfact.models.jpa.entities.SupplierPartyEntity;
import org.openfact.models.jpa.entities.TaxTotalEntity;

public class CreditNoteAdapter implements CreditNoteModel, JpaModel<CreditNoteEntity> {

    protected static final Logger logger = Logger.getLogger(CreditNoteAdapter.class);

    protected OrganizationModel organization;
    protected CreditNoteEntity creditNote;
    protected EntityManager em;
    protected OpenfactSession session;

    public CreditNoteAdapter(OpenfactSession session, OrganizationModel organization, EntityManager em,
            CreditNoteEntity creditNote) {
        this.organization = organization;
        this.session = session;
        this.em = em;
        this.creditNote = creditNote;
    }

    public static CreditNoteEntity toEntity(CreditNoteModel model, EntityManager em) {
        if (model instanceof CreditNoteAdapter) {
            return ((CreditNoteAdapter) model).getEntity();
        }
        return em.getReference(CreditNoteEntity.class, model.getId());
    }
    
    @Override
    public CreditNoteEntity getEntity() {
        return creditNote;
    }

    @Override
    public String getId() {
        return creditNote.getId();
    }

    @Override
    public String getDocumentId() {
        return creditNote.getDocumentId();
    }

    @Override
    public OrganizationModel getOrganization() {
        return organization;
    }

    @Override
    public LocalDateTime getIssueDateTime() {
        return creditNote.getIssueDateTime();
    }

    @Override
    public void setIssueDateTime(LocalDateTime value) {
        creditNote.setIssueDateTime(value);
    }

    @Override
    public String getDocumentCurrencyCode() {
        return creditNote.getDocumentCurrencyCode();
    }

    @Override
    public void setDocumentCurrencyCode(String value) {
        creditNote.setDocumentCurrencyCode(value);
    }

    @Override
    public SupplierPartyModel getAccountingSupplierParty() {
        if (creditNote.getAccountingCustomerParty() == null) {
            return null;
        }
        return new SupplierPartyAdapter(session, em, creditNote.getAccountingSupplierParty());
    }

    @Override
    public SupplierPartyModel getAccountingSupplierPartyAsNotNull() {
        if (creditNote.getAccountingCustomerParty() == null) {
            SupplierPartyEntity entity = new SupplierPartyEntity();
            creditNote.setAccountingSupplierParty(entity);
        }
        return new SupplierPartyAdapter(session, em, creditNote.getAccountingSupplierParty());
    }

    @Override
    public CustomerPartyModel getAccountingCustomerParty() {
        if (creditNote.getAccountingCustomerParty() == null) {
            return null;
        }
        return new CustomerPartyAdapter(session, em, creditNote.getAccountingCustomerParty());
    }

    @Override
    public CustomerPartyModel getAccountingCustomerPartyAsNotNull() {
        if (creditNote.getAccountingCustomerParty() == null) {
            CustomerPartyEntity entity = new CustomerPartyEntity();
            creditNote.setAccountingCustomerParty(entity);
        }
        return new CustomerPartyAdapter(session, em, creditNote.getAccountingCustomerParty());
    }

    @Override
    public List<AllowanceChargeModel> getAllowanceCharge() {
        return creditNote.getAllowanceCharge().stream().map(f -> new AllowanceChargeAdapter(session, em, f))
                .collect(Collectors.toList());
    }

    @Override
    public AllowanceChargeModel addAllowanceCharge() {
        List<AllowanceChargeEntity> entities = creditNote.getAllowanceCharge();

        AllowanceChargeEntity entity = new AllowanceChargeEntity();
        entities.add(entity);
        return new AllowanceChargeAdapter(session, em, entity);
    }

    @Override
    public List<TaxTotalModel> getTaxTotal() {
        return creditNote.getTaxTotal().stream().map(f -> new TaxTotalAdapter(session, em, f))
                .collect(Collectors.toList());
    }

    @Override
    public TaxTotalModel addTaxTotal() {
        List<TaxTotalEntity> entities = creditNote.getTaxTotal();

        TaxTotalEntity entity = new TaxTotalEntity();
        entities.add(entity);
        return new TaxTotalAdapter(session, em, entity);
    }

    @Override
    public MonetaryTotalModel getLegalMonetaryTotal() {
        if (creditNote.getLegalMonetaryTotal() == null) {
            return null;
        }
        return new MonetaryTotalAdapter(session, em, creditNote.getLegalMonetaryTotal());
    }

    @Override
    public MonetaryTotalModel getLegalMonetaryTotalAsNotNull() {
        if (creditNote.getLegalMonetaryTotal() == null) {
            MonetaryTotalEntity entity = new MonetaryTotalEntity();
            creditNote.setLegalMonetaryTotal(entity);
        }
        return new MonetaryTotalAdapter(session, em, creditNote.getLegalMonetaryTotal());
    }

    @Override
    public List<ResponseModel> getDiscrepancyResponse() {
        return creditNote.getDiscrepancyResponse().stream().map(f -> new ResponseAdapter(session, em, f))
                .collect(Collectors.toList());
    }

    @Override
    public ResponseModel addDiscrepancyResponse() {
        List<ResponseEntity> entities = creditNote.getDiscrepancyResponse();

        ResponseEntity entity = new ResponseEntity();
        entities.add(entity);
        return new ResponseAdapter(session, em, entity);
    }

    @Override
    public byte[] getXmlDocument() {
        return creditNote.getXmlDocument();
    }

    @Override
    public void setXmlDocument(byte[] value) {
        creditNote.setXmlDocument(value);
    }

    @Override
    public void setAttribute(String name, String value) {
        creditNote.getAttributes().put(name, value);
    }

    @Override
    public void removeAttribute(String name) {
        creditNote.getAttributes().remove(name);
    }

    @Override
    public String getAttribute(String name) {
        return creditNote.getAttributes().get(name);
    }

    @Override
    public Map<String, String> getAttributes() {
        return creditNote.getAttributes();
    }

    @Override
    public Set<String> getRequiredActions() {
        Set<String> result = new HashSet<>();
        for (CreditNoteRequiredActionEntity attr : creditNote.getRequiredActions()) {
            result.add(attr.getAction());
        }
        return result;
    }

    @Override
    public void addRequiredAction(String actionName) {
        for (CreditNoteRequiredActionEntity attr : creditNote.getRequiredActions()) {
            if (attr.getAction().equals(actionName)) {
                return;
            }
        }
        CreditNoteRequiredActionEntity attr = new CreditNoteRequiredActionEntity();
        attr.setAction(actionName);
        attr.setCreditNote(creditNote);
        em.persist(attr);
        creditNote.getRequiredActions().add(attr);
    }

    @Override
    public void removeRequiredAction(String actionName) {
        Iterator<CreditNoteRequiredActionEntity> it = creditNote.getRequiredActions().iterator();
        while (it.hasNext()) {
            CreditNoteRequiredActionEntity attr = it.next();
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
        return creditNote.getSendEvents().stream().map(f -> new SendEventAdapter(session, organization, em, f))
                .collect(Collectors.toList());
    }

}
