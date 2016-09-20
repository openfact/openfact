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
import org.openfact.models.jpa.entities.ubl.common.CreditNoteLineEntity;
import org.openfact.models.jpa.entities.ubl.common.DeliveryEntity;
import org.openfact.models.jpa.entities.ubl.common.DocumentReferenceEntity;
import org.openfact.models.jpa.entities.ubl.common.LineReferenceEntity;
import org.openfact.models.jpa.entities.ubl.common.ResponseEntity;
import org.openfact.models.jpa.entities.ubl.common.TaxTotalEntity;
import org.openfact.models.ubl.common.BillingReferenceModel;
import org.openfact.models.ubl.common.CreditNoteLineModel;
import org.openfact.models.ubl.common.DeliveryModel;
import org.openfact.models.ubl.common.DocumentReferenceModel;
import org.openfact.models.ubl.common.ItemModel;
import org.openfact.models.ubl.common.LineReferenceModel;
import org.openfact.models.ubl.common.PriceModel;
import org.openfact.models.ubl.common.PricingReferenceModel;
import org.openfact.models.ubl.common.QuantityModel;
import org.openfact.models.ubl.common.ResponseModel;
import org.openfact.models.ubl.common.TaxTotalModel;

public class CreditNoteLineAdapter implements CreditNoteLineModel, JpaModel<CreditNoteLineEntity> {

    protected static final Logger logger = Logger.getLogger(CreditNoteLineAdapter.class);
    protected CreditNoteLineEntity creditNoteLine;
    protected EntityManager em;
    protected OpenfactSession session;

    public CreditNoteLineAdapter(OpenfactSession session, EntityManager em,
            CreditNoteLineEntity creditNoteLine) {
        this.session = session;
        this.em = em;
        this.creditNoteLine = creditNoteLine;
    }

    @Override
    public String getID() {
        return this.creditNoteLine.getID();
    }

    @Override
    public void setID(String value) {
        this.creditNoteLine.setID(value);
    }

    @Override
    public String getUUID() {
        return this.creditNoteLine.getUuid();
    }

    @Override
    public void setUUID(String value) {
        this.creditNoteLine.setUuid(value);
    }

    @Override
    public String getNote() {
        return this.creditNoteLine.getNote();
    }

    @Override
    public void setNote(String value) {
        this.creditNoteLine.setNote(value);
    }

    @Override
    public QuantityModel getCreditedQuantity() {
        return new QuantityAdapter(session, em, this.creditNoteLine.getCreditedQuantity());
    }

    @Override
    public void setCreditedQuantity(QuantityModel value) {
        this.creditNoteLine.setCreditedQuantity(QuantityAdapter.toEntity(value, em));
    }

    @Override
    public BigDecimal getLineExtensionAmount() {
        return this.creditNoteLine.getLineExtensionAmount();
    }

    @Override
    public void setLineExtensionAmount(BigDecimal value) {
        this.creditNoteLine.setLineExtensionAmount(value);
    }

    @Override
    public LocalDate getTaxPointDate() {
        return this.creditNoteLine.getTaxPointDate();
    }

    @Override
    public void setTaxPointDate(LocalDate value) {
        this.creditNoteLine.setTaxPointDate(value);
    }

    @Override
    public String getAccountingCostCode() {
        return this.creditNoteLine.getAccountingCostCode();
    }

    @Override
    public void setAccountingCostCode(String value) {
        this.creditNoteLine.setAccountingCostCode(value);
    }

    @Override
    public String getAccountingCost() {
        return this.creditNoteLine.getAccountingCost();
    }

    @Override
    public void setAccountingCost(String value) {
        this.creditNoteLine.setAccountingCost(value);
    }

    @Override
    public List<ResponseModel> getDiscrepancyResponse() {
        return this.creditNoteLine.getDiscrepancyResponse().stream()
                .map(f -> new ResponseAdapter(session, em, f)).collect(Collectors.toList());
    }

    @Override
    public void setDiscrepancyResponse(List<ResponseModel> discrepancyResponse) {
        List<ResponseEntity> entities = discrepancyResponse.stream().map(f -> ResponseAdapter.toEntity(f, em))
                .collect(Collectors.toList());
        this.creditNoteLine.setDiscrepancyResponse(entities);
    }

    @Override
    public List<LineReferenceModel> getDespatchLineReference() {
        return this.creditNoteLine.getDespatchLineReference().stream()
                .map(f -> new LineReferenceAdapter(session, em, f)).collect(Collectors.toList());
    }

    @Override
    public void setDespatchLineReference(List<LineReferenceModel> despatchLineReference) {
        List<LineReferenceEntity> entities = despatchLineReference.stream()
                .map(f -> LineReferenceAdapter.toEntity(f, em)).collect(Collectors.toList());
        this.creditNoteLine.setDespatchLineReference(entities);
    }

    @Override
    public List<LineReferenceModel> getReceiptLineReference() {
        return this.creditNoteLine.getReceiptLineReference().stream()
                .map(f -> new LineReferenceAdapter(session, em, f)).collect(Collectors.toList());
    }

    @Override
    public void setReceiptLineReference(List<LineReferenceModel> receiptLineReference) {
        List<LineReferenceEntity> entities = receiptLineReference.stream()
                .map(f -> LineReferenceAdapter.toEntity(f, em)).collect(Collectors.toList());
        this.creditNoteLine.setReceiptLineReference(entities);
    }

    @Override
    public List<BillingReferenceModel> getBillingReference() {
        return this.creditNoteLine.getBillingReference().stream()
                .map(f -> new BillingReferenceAdapter(session, em, f)).collect(Collectors.toList());
    }

    @Override
    public void setBillingReference(List<BillingReferenceModel> billingReference) {
        List<BillingReferenceEntity> entities = billingReference.stream()
                .map(f -> BillingReferenceAdapter.toEntity(f, em)).collect(Collectors.toList());
        this.creditNoteLine.setBillingReference(entities);
    }

    @Override
    public List<DocumentReferenceModel> getDocumentReference() {
        return this.creditNoteLine.getDocumentReference().stream()
                .map(f -> new DocumentReferenceAdapter(session, em, f)).collect(Collectors.toList());
    }

    @Override
    public void setDocumentReference(List<DocumentReferenceModel> documentReference) {
        List<DocumentReferenceEntity> entities = documentReference.stream()
                .map(f -> DocumentReferenceAdapter.toEntity(f, em)).collect(Collectors.toList());
        this.creditNoteLine.setDocumentReference(entities);
    }

    @Override
    public PricingReferenceModel getPricingReference() {
        return new PricingReferenceAdapter(session, em, this.creditNoteLine.getPricingReference());
    }

    @Override
    public void setPricingReference(PricingReferenceModel value) {
        this.creditNoteLine.setPricingReference(PricingReferenceAdapter.toEntity(value, em));
    }

    @Override
    public List<DeliveryModel> getDelivery() {
        return this.creditNoteLine.getDelivery().stream().map(f -> new DeliveryAdapter(session, em, f))
                .collect(Collectors.toList());
    }

    @Override
    public void setDelivery(List<DeliveryModel> delivery) {
        List<DeliveryEntity> entities = delivery.stream().map(f -> DeliveryAdapter.toEntity(f, em))
                .collect(Collectors.toList());
        this.creditNoteLine.setDelivery(entities);
    }

    @Override
    public List<TaxTotalModel> getTaxTotal() {
        return this.creditNoteLine.getTaxTotal().stream().map(f -> new TaxTotalAdapter(session, em, f))
                .collect(Collectors.toList());
    }

    @Override
    public void setTaxTotal(List<TaxTotalModel> taxTotal) {
        List<TaxTotalEntity> entities = taxTotal.stream().map(f -> TaxTotalAdapter.toEntity(f, em))
                .collect(Collectors.toList());
        this.creditNoteLine.setTaxTotal(entities);
    }

    @Override
    public ItemModel getItem() {
        return new ItemAdapter(session, em, this.creditNoteLine.getItem());
    }

    @Override
    public void setItem(ItemModel value) {
        this.creditNoteLine.setItem(ItemAdapter.toEntity(value, em));
    }

    @Override
    public PriceModel getPrice() {
        return new PriceAdapter(session, em, this.creditNoteLine.getPrice());
    }

    @Override
    public void setPrice(PriceModel value) {
        this.creditNoteLine.setPrice(PriceAdapter.toEntity(value, em));
    }

    @Override
    public String getId() {
        return this.creditNoteLine.getId();
    }

    @Override
    public void setId(String value) {
        this.creditNoteLine.setId(value);
    }

    @Override
    public CreditNoteLineEntity getEntity() {
        return this.creditNoteLine;
    }

    @Override
    public TaxTotalModel addTaxTotal() {
        List<TaxTotalEntity> taxTotals = this.creditNoteLine.getTaxTotal();

        TaxTotalEntity entity = new TaxTotalEntity();
        taxTotals.add(entity);
        return new TaxTotalAdapter(session, em, entity);
    }

}
