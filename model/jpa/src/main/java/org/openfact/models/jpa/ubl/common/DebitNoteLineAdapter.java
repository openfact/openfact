package org.openfact.models.jpa.ubl.common;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import org.openfact.models.OpenfactSession;
import org.jboss.logging.Logger;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.DebitNoteLineEntity;
import org.openfact.models.jpa.entities.ubl.common.DebitNoteLineEntity;
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
        return this.debitNoteLine.getUUID();
    }

    @Override
    public void setUUID(String value) {
        this.debitNoteLine.setUUID(value);
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
        return this.debitNoteLine.getDebitedQuantity();
    }

    @Override
    public void setDebitedQuantity(QuantityAdapter value) {
        this.debitNoteLine.setDebitedQuantity(value);
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
        return this.debitNoteLine.getDiscrepancyResponse();
    }

    @Override
    public void setDiscrepancyResponse(List<ResponseAdapter> discrepancyResponse) {
        this.debitNoteLine.setDiscrepancyResponse(discrepancyResponse);
    }

    @Override
    public List<LineReferenceModel> getDespatchLineReference() {
        return this.debitNoteLine.getDespatchLineReference();
    }

    @Override
    public void setDespatchLineReference(List<LineReferenceAdapter> despatchLineReference) {
        this.debitNoteLine.setDespatchLineReference(despatchLineReference);
    }

    @Override
    public List<LineReferenceModel> getReceiptLineReference() {
        return this.debitNoteLine.getReceiptLineReference();
    }

    @Override
    public void setReceiptLineReference(List<LineReferenceAdapter> receiptLineReference) {
        this.debitNoteLine.setReceiptLineReference(receiptLineReference);
    }

    @Override
    public List<BillingReferenceModel> getBillingReference() {
        return this.debitNoteLine.getBillingReference();
    }

    @Override
    public void setBillingReference(List<BillingReferenceAdapter> billingReference) {
        this.debitNoteLine.setBillingReference(billingReference);
    }

    @Override
    public List<DocumentReferenceModel> getDocumentReference() {
        return this.debitNoteLine.getDocumentReference();
    }

    @Override
    public void setDocumentReference(List<DocumentReferenceAdapter> documentReference) {
        this.debitNoteLine.setDocumentReference(documentReference);
    }

    @Override
    public PricingReferenceModel getPricingReference() {
        return this.debitNoteLine.getPricingReference();
    }

    @Override
    public void setPricingReference(PricingReferenceAdapter value) {
        this.debitNoteLine.setPricingReference(value);
    }

    @Override
    public List<DeliveryModel> getDelivery() {
        return this.debitNoteLine.getDelivery();
    }

    @Override
    public void setDelivery(List<DeliveryAdapter> delivery) {
        this.debitNoteLine.setDelivery(delivery);
    }

    @Override
    public List<TaxTotalModel> getTaxTotal() {
        return this.debitNoteLine.getTaxTotal();
    }

    @Override
    public void setTaxTotal(List<TaxTotalAdapter> taxTotal) {
        this.debitNoteLine.setTaxTotal(taxTotal);
    }

    @Override
    public ItemModel getItem() {
        return this.debitNoteLine.getItem();
    }

    @Override
    public void setItem(ItemAdapter value) {
        this.debitNoteLine.setItem(value);
    }

    @Override
    public PriceModel getPrice() {
        return this.debitNoteLine.getPrice();
    }

    @Override
    public void setPrice(PriceAdapter value) {
        this.debitNoteLine.setPrice(value);
    }

    @Override
    public String getId() {
        return this.debitNoteLine.getId();
    }

    @Override
    public void setId(String value) {
        this.debitNoteLine.setId(value);
    }

    /**
     * */
    TaxTotalAdapter addTaxTotal();

}
