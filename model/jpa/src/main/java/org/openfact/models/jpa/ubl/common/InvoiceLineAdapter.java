package org.openfact.models.jpa.ubl.common;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class InvoiceLineAdapter implements InvoiceLineModel, JpaModel<InvoiceLineEntity> {

    protected static final Logger logger = Logger.getLogger(InvoiceLineAdapter.class);
    protected InvoiceLineEntity invoiceLine;
    protected EntityManager em;
    protected OpenfactSession session;

    public InvoiceLineAdapter(OpenfactSession session, EntityManager em, InvoiceLineEntity invoiceLine) {
        this.session = session;
        this.em = em;
        this.invoiceLine = invoiceLine;
    }

    String getID() {
        return this.invoiceLine.getID();
    }

    void setID(String value) {
        this.invoiceLine.setID(value);
    }

    String getUUID() {
        return this.invoiceLine.getUUID();
    }

    void setUUID(String value) {
        this.invoiceLine.setUUID(value);
    }

    String getNote() {
        return this.invoiceLine.getNote();
    }

    void setNote(String value) {
        this.invoiceLine.setNote(value);
    }

    QuantityAdapter getInvoicedQuantity() {
        return this.invoiceLine.getInvoicedQuantity();
    }

    void setInvoicedQuantity(QuantityAdapter value) {
        this.invoiceLine.setInvoicedQuantity(value);
    }

    BigDecimal getLineExtensionAmount() {
        return this.invoiceLine.getLineExtensionAmount();
    }

    void setLineExtensionAmount(BigDecimal value) {
        this.invoiceLine.setLineExtensionAmount(value);
    }

    LocalDate getTaxPointDate() {
        return this.invoiceLine.getTaxPointDate();
    }

    void setTaxPointDate(LocalDate value) {
        this.invoiceLine.setTaxPointDate(value);
    }

    String getAccountingCostCode() {
        return this.invoiceLine.getAccountingCostCode();
    }

    void setAccountingCostCode(String value) {
        this.invoiceLine.setAccountingCostCode(value);
    }

    String getAccountingCost() {
        return this.invoiceLine.getAccountingCost();
    }

    void setAccountingCost(String value) {
        this.invoiceLine.setAccountingCost(value);
    }

    boolean getFreeOfChargeIndicator() {
        return this.invoiceLine.getFreeOfChargeIndicator();
    }

    void setFreeOfChargeIndicator(boolean value) {
        this.invoiceLine.setFreeOfChargeIndicator(value);
    }

    List<OrderLineReferenceAdapter> getOrderLineReference() {
        return this.invoiceLine.getOrderLineReference();
    }

    void setOrderLineReference(List<OrderLineReferenceAdapter> orderLineReference) {
        this.invoiceLine.setOrderLineReference(orderLineReference);
    }

    List<LineReferenceAdapter> getDespatchLineReference() {
        return this.invoiceLine.getDespatchLineReference();
    }

    void setDespatchLineReference(List<LineReferenceAdapter> despatchLineReference) {
        this.invoiceLine.setDespatchLineReference(despatchLineReference);
    }

    List<LineReferenceAdapter> getReceiptLineReference() {
        return this.invoiceLine.getReceiptLineReference();
    }

    void setReceiptLineReference(List<LineReferenceAdapter> receiptLineReference) {
        this.invoiceLine.setReceiptLineReference(receiptLineReference);
    }

    List<BillingReferenceAdapter> getBillingReference() {
        return this.invoiceLine.getBillingReference();
    }

    void setBillingReference(List<BillingReferenceAdapter> billingReference) {
        this.invoiceLine.setBillingReference(billingReference);
    }

    List<DocumentReferenceAdapter> getDocumentReference() {
        return this.invoiceLine.getDocumentReference();
    }

    void setDocumentReference(List<DocumentReferenceAdapter> documentReference) {
        this.invoiceLine.setDocumentReference(documentReference);
    }

    PricingReferenceAdapter getPricingReference() {
        return this.invoiceLine.getPricingReference();
    }

    void setPricingReference(PricingReferenceAdapter value) {
        this.invoiceLine.setPricingReference(value);
    }

    PartyAdapter getOriginatorParty() {
        return this.invoiceLine.getOriginatorParty();
    }

    void setOriginatorParty(PartyAdapter value) {
        this.invoiceLine.setOriginatorParty(value);
    }

    List<DeliveryAdapter> getDelivery() {
        return this.invoiceLine.getDelivery();
    }

    void setDelivery(List<DeliveryAdapter> delivery) {
        this.invoiceLine.setDelivery(delivery);
    }

    List<PaymentTermsAdapter> getPaymentTerms() {
        return this.invoiceLine.getPaymentTerms();
    }

    void setPaymentTerms(List<PaymentTermsAdapter> paymentTerms) {
        this.invoiceLine.setPaymentTerms(paymentTerms);
    }

    List<AllowanceChargeAdapter> getAllowanceCharge() {
        return this.invoiceLine.getAllowanceCharge();
    }

    void setAllowanceCharge(List<AllowanceChargeAdapter> allowanceCharge) {
        this.invoiceLine.setAllowanceCharge(allowanceCharge);
    }

    List<TaxTotalAdapter> getTaxTotal() {
        return this.invoiceLine.getTaxTotal();
    }

    void setTaxTotal(List<TaxTotalAdapter> taxTotal) {
        this.invoiceLine.setTaxTotal(taxTotal);
    }

    ItemAdapter getItem() {
        return this.invoiceLine.getItem();
    }

    void setItem(ItemAdapter value) {
        this.invoiceLine.setItem(value);
    }

    PriceAdapter getPrice() {
        return this.invoiceLine.getPrice();
    }

    void setPrice(PriceAdapter value) {
        this.invoiceLine.setPrice(value);
    }

    DeliveryTermsAdapter getDeliveryTerms() {
        return this.invoiceLine.getDeliveryTerms();
    }

    void setDeliveryTerms(DeliveryTermsAdapter value) {
        this.invoiceLine.setDeliveryTerms(value);
    }

    String getId() {
        return this.invoiceLine.getId();
    }

    void setId(String value) {
        this.invoiceLine.setId(value);
    }

    /**
     * */
    TaxTotalAdapter addTaxTotal();

    AllowanceChargeAdapter addAllowanceCharge();

}
