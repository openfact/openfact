package org.openfact.models.jpa.ubl.common;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

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

    String getID() {
        return this.creditNoteLine.getID();
    }

    void setID(String value) {
        this.creditNoteLine.setID(value);
    }

    String getUUID() {
        return this.creditNoteLine.getUUID();
    }

    void setUUID(String value) {
        this.creditNoteLine.setUUID(value);
    }

    String getNote() {
        return this.creditNoteLine.getNote();
    }

    void setNote(String value) {
        this.creditNoteLine.setNote(value);
    }

    QuantityAdapter getCreditedQuantity() {
        return this.creditNoteLine.getCreditedQuantity();
    }

    void setCreditedQuantity(QuantityAdapter value) {
        this.creditNoteLine.setCreditedQuantity(value);
    }

    BigDecimal getLineExtensionAmount() {
        return this.creditNoteLine.getLineExtensionAmount();
    }

    void setLineExtensionAmount(BigDecimal value) {
        this.creditNoteLine.setLineExtensionAmount(value);
    }

    LocalDate getTaxPointDate() {
        return this.creditNoteLine.getTaxPointDate();
    }

    void setTaxPointDate(LocalDate value) {
        this.creditNoteLine.setTaxPointDate(value);
    }

    String getAccountingCostCode() {
        return this.creditNoteLine.getAccountingCostCode();
    }

    void setAccountingCostCode(String value) {
        this.creditNoteLine.setAccountingCostCode(value);
    }

    String getAccountingCost() {
        return this.creditNoteLine.getAccountingCost();
    }

    void setAccountingCost(String value) {
        this.creditNoteLine.setAccountingCost(value);
    }

    List<ResponseAdapter> getDiscrepancyResponse() {
        return this.creditNoteLine.getDiscrepancyResponse();
    }

    void setDiscrepancyResponse(List<ResponseAdapter> discrepancyResponse) {
        this.creditNoteLine.setDiscrepancyResponse(discrepancyResponse);
    }

    List<LineReferenceAdapter> getDespatchLineReference() {
        return this.creditNoteLine.getDespatchLineReference();
    }

    void setDespatchLineReference(List<LineReferenceAdapter> despatchLineReference) {
        this.creditNoteLine.setDespatchLineReference(despatchLineReference);
    }

    List<LineReferenceAdapter> getReceiptLineReference() {
        return this.creditNoteLine.getReceiptLineReference();
    }

    void setReceiptLineReference(List<LineReferenceAdapter> receiptLineReference) {
        this.creditNoteLine.setReceiptLineReference(receiptLineReference);
    }

    List<BillingReferenceAdapter> getBillingReference() {
        return this.creditNoteLine.getBillingReference();
    }

    void setBillingReference(List<BillingReferenceAdapter> billingReference) {
        this.creditNoteLine.setBillingReference(billingReference);
    }

    List<DocumentReferenceAdapter> getDocumentReference() {
        return this.creditNoteLine.getDocumentReference();
    }

    void setDocumentReference(List<DocumentReferenceAdapter> documentReference) {
        this.creditNoteLine.setDocumentReference(documentReference);
    }

    PricingReferenceAdapter getPricingReference() {
        return this.creditNoteLine.getPricingReference();
    }

    void setPricingReference(PricingReferenceAdapter value) {
        this.creditNoteLine.setPricingReference(value);
    }

    List<DeliveryAdapter> getDelivery() {
        return this.creditNoteLine.getDelivery();
    }

    void setDelivery(List<DeliveryAdapter> delivery) {
        this.creditNoteLine.setDelivery(delivery);
    }

    List<TaxTotalAdapter> getTaxTotal() {
        return this.creditNoteLine.getTaxTotal();
    }

    void setTaxTotal(List<TaxTotalAdapter> taxTotal) {
        this.creditNoteLine.setTaxTotal(taxTotal);
    }

    ItemAdapter getItem() {
        return this.creditNoteLine.getItem();
    }

    void setItem(ItemAdapter value) {
        this.creditNoteLine.setItem(value);
    }

    PriceAdapter getPrice() {
        return this.creditNoteLine.getPrice();
    }

    void setPrice(PriceAdapter value) {
        this.creditNoteLine.setPrice(value);
    }

    String getId() {
        return this.creditNoteLine.getId();
    }

    void setId(String value) {
        this.creditNoteLine.setId(value);
    }

    /*
     * **/
    TaxTotalAdapter addTaxTotal();

}
