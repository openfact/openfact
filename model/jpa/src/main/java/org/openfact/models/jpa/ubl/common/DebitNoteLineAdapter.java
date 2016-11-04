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
package org.openfact.models.jpa.ubl.common;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.BillingReferenceEntity;
import org.openfact.models.jpa.entities.ubl.common.DebitNoteLineEntity;
import org.openfact.models.jpa.entities.ubl.common.DeliveryEntity;
import org.openfact.models.jpa.entities.ubl.common.DocumentReferenceEntity;
import org.openfact.models.jpa.entities.ubl.common.LineReferenceEntity;
import org.openfact.models.jpa.entities.ubl.common.ResponseEntity;
import org.openfact.models.jpa.entities.ubl.common.TaxTotalEntity;
import org.openfact.models.ubl.common.BillingReferenceModel;
import org.openfact.models.ubl.common.DebitNoteLineModel;
import org.openfact.models.ubl.common.DeliveryModel;
import org.openfact.models.ubl.common.DocumentReferenceModel;
import org.openfact.models.ubl.common.ItemModel;
import org.openfact.models.ubl.common.LineReferenceModel;
import org.openfact.models.ubl.common.PriceModel;
import org.openfact.models.ubl.common.PricingReferenceModel;
import org.openfact.models.ubl.common.QuantityModel;
import org.openfact.models.ubl.common.ResponseModel;
import org.openfact.models.ubl.common.TaxTotalModel;

public class DebitNoteLineAdapter implements DebitNoteLineModel, JpaModel<DebitNoteLineEntity> {

    protected static final Logger logger = Logger.getLogger(DebitNoteLineAdapter.class);
    protected DebitNoteLineEntity debitNoteLine;
    protected EntityManager em;
    protected OpenfactSession session;

    public DebitNoteLineAdapter(OpenfactSession session, EntityManager em,
            DebitNoteLineEntity debitNoteLine) {
        this.session = session;
        this.em = em;
        this.debitNoteLine = debitNoteLine;
    }

    @Override
    public String getID() {
        return this.debitNoteLine.getID();
    }

    @Override
    public void setID(String value) {
        this.debitNoteLine.setID(value);
    }

    @Override
    public String getUUID() {
        return this.debitNoteLine.getUuid();
    }

    @Override
    public void setUUID(String value) {
        this.debitNoteLine.setUuid(value);
    }

    @Override
    public String getNote() {
        return this.debitNoteLine.getNote();
    }

    @Override
    public void setNote(String value) {
        this.debitNoteLine.setNote(value);
    }

    @Override
    public QuantityModel getDebitedQuantity() {
        return new QuantityAdapter(session, em, this.debitNoteLine.getDebitedQuantity());
    }

    @Override
    public void setDebitedQuantity(QuantityModel value) {
        this.debitNoteLine.setDebitedQuantity(QuantityAdapter.toEntity(value, em));
    }

    @Override
    public BigDecimal getLineExtensionAmount() {
        return this.debitNoteLine.getLineExtensionAmount();
    }

    @Override
    public void setLineExtensionAmount(BigDecimal value) {
        this.debitNoteLine.setLineExtensionAmount(value);
    }

    @Override
    public LocalDate getTaxPointDate() {
        return this.debitNoteLine.getTaxPointDate();
    }

    @Override
    public void setTaxPointDate(LocalDate value) {
        this.debitNoteLine.setTaxPointDate(value);
    }

    @Override
    public String getAccountingCostCode() {
        return this.debitNoteLine.getAccountingCostCode();
    }

    @Override
    public void setAccountingCostCode(String value) {
        this.debitNoteLine.setAccountingCostCode(value);
    }

    @Override
    public String getAccountingCost() {
        return this.debitNoteLine.getAccountingCost();
    }

    @Override
    public void setAccountingCost(String value) {
        this.debitNoteLine.setAccountingCost(value);
    }

    @Override
    public List<ResponseModel> getDiscrepancyResponse() {
        return this.debitNoteLine.getDiscrepancyResponse().stream()
                .map(f -> new ResponseAdapter(session, em, f)).collect(Collectors.toList());
    }

    @Override
    public void setDiscrepancyResponse(List<ResponseModel> discrepancyResponse) {
        List<ResponseEntity> entities = discrepancyResponse.stream().map(f -> ResponseAdapter.toEntity(f, em))
                .collect(Collectors.toList());
        this.debitNoteLine.setDiscrepancyResponse(entities);
    }

    @Override
    public List<LineReferenceModel> getDespatchLineReference() {
        return this.debitNoteLine.getDespatchLineReference().stream()
                .map(f -> new LineReferenceAdapter(session, em, f)).collect(Collectors.toList());
    }

    @Override
    public void setDespatchLineReference(List<LineReferenceModel> despatchLineReference) {
        List<LineReferenceEntity> entities = despatchLineReference.stream()
                .map(f -> LineReferenceAdapter.toEntity(f, em)).collect(Collectors.toList());
        this.debitNoteLine.setDespatchLineReference(entities);
    }

    @Override
    public List<LineReferenceModel> getReceiptLineReference() {
        return this.debitNoteLine.getReceiptLineReference().stream()
                .map(f -> new LineReferenceAdapter(session, em, f)).collect(Collectors.toList());
    }

    @Override
    public void setReceiptLineReference(List<LineReferenceModel> receiptLineReference) {
        List<LineReferenceEntity> entities = receiptLineReference.stream()
                .map(f -> LineReferenceAdapter.toEntity(f, em)).collect(Collectors.toList());
        this.debitNoteLine.setReceiptLineReference(entities);
    }

    @Override
    public List<BillingReferenceModel> getBillingReference() {
        return this.debitNoteLine.getBillingReference().stream()
                .map(f -> new BillingReferenceAdapter(session, em, f)).collect(Collectors.toList());
    }

    @Override
    public void setBillingReference(List<BillingReferenceModel> billingReference) {
        List<BillingReferenceEntity> entities = billingReference.stream()
                .map(f -> BillingReferenceAdapter.toEntity(f, em)).collect(Collectors.toList());
        this.debitNoteLine.setBillingReference(entities);
    }

    @Override
    public List<DocumentReferenceModel> getDocumentReference() {
        return this.debitNoteLine.getDocumentReference().stream()
                .map(f -> new DocumentReferenceAdapter(session, em, f)).collect(Collectors.toList());
    }

    @Override
    public void setDocumentReference(List<DocumentReferenceModel> documentReference) {
        List<DocumentReferenceEntity> entities = documentReference.stream()
                .map(f -> DocumentReferenceAdapter.toEntity(f, em)).collect(Collectors.toList());
        this.debitNoteLine.setDocumentReference(entities);
    }

    @Override
    public PricingReferenceModel getPricingReference() {
        return new PricingReferenceAdapter(session, em, this.debitNoteLine.getPricingReference());
    }

    @Override
    public void setPricingReference(PricingReferenceModel value) {
        this.debitNoteLine.setPricingReference(PricingReferenceAdapter.toEntity(value, em));
    }

    @Override
    public List<DeliveryModel> getDelivery() {
        return this.debitNoteLine.getDelivery().stream().map(f -> new DeliveryAdapter(session, em, f))
                .collect(Collectors.toList());
    }

    @Override
    public void setDelivery(List<DeliveryModel> delivery) {
        List<DeliveryEntity> entities = delivery.stream().map(f -> DeliveryAdapter.toEntity(f, em))
                .collect(Collectors.toList());
        this.debitNoteLine.setDelivery(entities);
    }

    @Override
    public List<TaxTotalModel> getTaxTotal() {
        return this.debitNoteLine.getTaxTotal().stream().map(f -> new TaxTotalAdapter(session, em, f))
                .collect(Collectors.toList());
    }

    @Override
    public void setTaxTotal(List<TaxTotalModel> taxTotal) {
        List<TaxTotalEntity> entities = taxTotal.stream().map(f -> TaxTotalAdapter.toEntity(f, em))
                .collect(Collectors.toList());
        this.debitNoteLine.setTaxTotal(entities);
    }

    @Override
    public ItemModel getItem() {
        return new ItemAdapter(session, em, this.debitNoteLine.getItem());
    }

    @Override
    public void setItem(ItemModel value) {
        this.debitNoteLine.setItem(ItemAdapter.toEntity(value, em));
    }

    @Override
    public PriceModel getPrice() {
        return new PriceAdapter(session, em, this.debitNoteLine.getPrice());
    }

    @Override
    public void setPrice(PriceModel value) {
        this.debitNoteLine.setPrice(PriceAdapter.toEntity(value, em));
    }

    @Override
    public String getId() {
        return this.debitNoteLine.getId();
    }

    @Override
    public DebitNoteLineEntity getEntity() {
        return this.debitNoteLine;
    }

    @Override
    public TaxTotalModel addTaxTotal() {
        List<TaxTotalEntity> entities = this.debitNoteLine.getTaxTotal();

        TaxTotalEntity entity = new TaxTotalEntity();
        entities.add(entity);
        return new TaxTotalAdapter(session, em, entity);
    }

    public static DebitNoteLineEntity toEntity(DebitNoteLineModel model, EntityManager em) {
        if (model instanceof DebitNoteLineAdapter) {
            return ((DebitNoteLineAdapter) model).getEntity();
        }
        return em.getReference(DebitNoteLineEntity.class, model.getId());
    }

}
