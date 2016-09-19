package org.openfact.models.jpa.ubl.common;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

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

    String getID() {
        return this.debitNoteLine.getID();
    }

    void setID(String value) {
        this.debitNoteLine.setID(value);
    }

    String getUUID() {
        return this.debitNoteLine.getUUID();
    }

    void setUUID(String value) {
        this.debitNoteLine.setUUID(value);
    }

    String getNote() {
        return this.debitNoteLine.getNote();
    }

    void setNote(String value) {
        this.debitNoteLine.setNote(value);
    }

    QuantityAdapter getDebitedQuantity() {
        return this.debitNoteLine.getDebitedQuantity();
    }

    void setDebitedQuantity(QuantityAdapter value) {
        this.debitNoteLine.setDebitedQuantity(value);
    }

    BigDecimal getLineExtensionAmount() {
        return this.debitNoteLine.getLineExtensionAmount();
    }

    void setLineExtensionAmount(BigDecimal value) {
        this.debitNoteLine.setLineExtensionAmount(value);
    }

    LocalDate getTaxPointDate() {
        return this.debitNoteLine.getTaxPointDate();
    }

    void setTaxPointDate(LocalDate value) {
        this.debitNoteLine.setTaxPointDate(value);
    }

    String getAccountingCostCode() {
        return this.debitNoteLine.getAccountingCostCode();
    }

    void setAccountingCostCode(String value) {
        this.debitNoteLine.setAccountingCostCode(value);
    }

    String getAccountingCost() {
        return this.debitNoteLine.getAccountingCost();
    }

    void setAccountingCost(String value) {
        this.debitNoteLine.setAccountingCost(value);
    }

    List<ResponseAdapter> getDiscrepancyResponse() {
        return this.debitNoteLine.getDiscrepancyResponse();
    }

    void setDiscrepancyResponse(List<ResponseAdapter> discrepancyResponse) {
        this.debitNoteLine.setDiscrepancyResponse(discrepancyResponse);
    }

    List<LineReferenceAdapter> getDespatchLineReference() {
        return this.debitNoteLine.getDespatchLineReference();
    }

    void setDespatchLineReference(List<LineReferenceAdapter> despatchLineReference) {
        this.debitNoteLine.setDespatchLineReference(despatchLineReference);
    }

    List<LineReferenceAdapter> getReceiptLineReference() {
        return this.debitNoteLine.getReceiptLineReference();
    }

    void setReceiptLineReference(List<LineReferenceAdapter> receiptLineReference) {
        this.debitNoteLine.setReceiptLineReference(receiptLineReference);
    }

    List<BillingReferenceAdapter> getBillingReference() {
        return this.debitNoteLine.getBillingReference();
    }

    void setBillingReference(List<BillingReferenceAdapter> billingReference) {
        this.debitNoteLine.setBillingReference(billingReference);
    }

    List<DocumentReferenceAdapter> getDocumentReference() {
        return this.debitNoteLine.getDocumentReference();
    }

    void setDocumentReference(List<DocumentReferenceAdapter> documentReference) {
        this.debitNoteLine.setDocumentReference(documentReference);
    }

    PricingReferenceAdapter getPricingReference() {
        return this.debitNoteLine.getPricingReference();
    }

    void setPricingReference(PricingReferenceAdapter value) {
        this.debitNoteLine.setPricingReference(value);
    }

    List<DeliveryAdapter> getDelivery() {
        return this.debitNoteLine.getDelivery();
    }

    void setDelivery(List<DeliveryAdapter> delivery) {
        this.debitNoteLine.setDelivery(delivery);
    }

    List<TaxTotalAdapter> getTaxTotal() {
        return this.debitNoteLine.getTaxTotal();
    }

    void setTaxTotal(List<TaxTotalAdapter> taxTotal) {
        this.debitNoteLine.setTaxTotal(taxTotal);
    }

    ItemAdapter getItem() {
        return this.debitNoteLine.getItem();
    }

    void setItem(ItemAdapter value) {
        this.debitNoteLine.setItem(value);
    }

    PriceAdapter getPrice() {
        return this.debitNoteLine.getPrice();
    }

    void setPrice(PriceAdapter value) {
        this.debitNoteLine.setPrice(value);
    }

    String getId() {
        return this.debitNoteLine.getId();
    }

    void setId(String value) {
        this.debitNoteLine.setId(value);
    }

    /**
     * */
    TaxTotalAdapter addTaxTotal();

}
