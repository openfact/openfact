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
        return creditNote.getAllowanceCharge().stream().map(f -> new AllowanceChargeAdapter(session, em, f)).collect(Collectors.toList());
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
        return creditNote.getTaxTotal().stream().map(f -> new TaxTotalAdapter(session, em, f)).collect(Collectors.toList());
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
        return creditNote.getDiscrepancyResponse().stream().map(f -> new ResponseAdapter(session, em, f)).collect(Collectors.toList());
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

    /**
     * Attributes*/
    @Override
    public void setSingleAttribute(String name, String value) {
        String firstExistingAttrId = null;
        List<CreditNoteAttributeEntity> toRemove = new ArrayList<>();
        for (CreditNoteAttributeEntity attr : creditNote.getAttributes()) {
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
            Query query = em.createNamedQuery("deleteCreditNoteAttributesByNameAndCreditNoteOtherThan");
            query.setParameter("name", name);
            query.setParameter("creditNoteId", creditNote.getId());
            query.setParameter("attrId", firstExistingAttrId);
            int numUpdated = query.executeUpdate();

            // Remove attribute from local entity
            creditNote.getAttributes().removeAll(toRemove);
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
        CreditNoteAttributeEntity attr = new CreditNoteAttributeEntity();
        attr.setId(OpenfactModelUtils.generateId());
        attr.setName(name);
        attr.setValue(value);
        attr.setCreditNote(creditNote);
        em.persist(attr);
        creditNote.getAttributes().add(attr);
    }

    @Override
    public void removeAttribute(String name) {
        // Remove attribute through HQL to avoid StaleUpdateException
        Query query = em.createNamedQuery("deleteCreditNoteAttributesByNameAndCreditNote");
        query.setParameter("name", name);
        query.setParameter("creditNoteId", creditNote.getId());
        int numUpdated = query.executeUpdate();

        // Also remove attributes from local user entity
        List<CreditNoteAttributeEntity> toRemove = new ArrayList<>();
        for (CreditNoteAttributeEntity attr : creditNote.getAttributes()) {
            if (attr.getName().equals(name)) {
                toRemove.add(attr);
            }
        }
        creditNote.getAttributes().removeAll(toRemove);
    }

    @Override
    public String getFirstAttribute(String name) {
        for (CreditNoteAttributeEntity attr : creditNote.getAttributes()) {
            if (attr.getName().equals(name)) {
                return attr.getValue();
            }
        }
        return null;
    }

    @Override
    public List<String> getAttribute(String name) {
        List<String> result = new ArrayList<>();
        for (CreditNoteAttributeEntity attr : creditNote.getAttributes()) {
            if (attr.getName().equals(name)) {
                result.add(attr.getValue());
            }
        }
        return result;
    }

    @Override
    public Map<String, List<String>> getAttributes() {
        MultivaluedHashMap<String, String> result = new MultivaluedHashMap<>();
        for (CreditNoteAttributeEntity attr : creditNote.getAttributes()) {
            result.add(attr.getName(), attr.getValue());
        }
        return result;
    }

    /**
     * Required actions*/
    @Override
    public Set<String> getRequiredActions() {
        Set<String> result = new HashSet<>();
        for (CreditNoteRequiredActionEntity attr : creditNote.getRequiredActions()) {
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
    public void removeRequiredAction(RequiredAction action) {
        String actionName = action.name();
        removeRequiredAction(actionName);
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
    
    /**
     * Send events*/
    
    @Override
    public List<SendEventModel> getSendEvents() {
        return creditNote.getSendEvents().stream().map(f -> new SendEventAdapter(session, organization, em, f)).collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof CreditNoteModel)) return false;

        CreditNoteModel that = (CreditNoteModel) o;
        return that.getId().equals(getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }

}
