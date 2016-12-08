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
import org.openfact.models.AllowanceChargeModel;
import org.openfact.models.CustomerPartyModel;
import org.openfact.models.DebitNoteModel;
import org.openfact.models.MonetaryTotalModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.jpa.entities.*;
import org.openfact.models.utils.OpenfactModelUtils;
import org.openfact.ubl.SendEventModel;
import org.openfact.models.SupplierPartyModel;
import org.openfact.models.TaxTotalModel;
import org.openfact.models.enums.RequiredAction;

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
        return debitNote.getTaxTotal().stream().map(f -> new TaxTotalAdapter(session, em, f)).collect(Collectors.toList());
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
        return debitNote.getAllowanceCharge().stream().map(f -> new AllowanceChargeAdapter(session, em, f)).collect(Collectors.toList());
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

    /**
     * Send events*/
    @Override
    public List<SendEventModel> getSendEvents() {
        return debitNote.getSendEvents().stream().map(f -> new SendEventAdapter(session, organization, em, f)).collect(Collectors.toList());
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
