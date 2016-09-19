package org.openfact.models.jpa.ubl.common;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import org.openfact.models.OpenfactSession;
import org.jboss.logging.Logger;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.ubl.common.AllowanceChargeModel;
import org.openfact.models.ubl.common.BillingReferenceModel;
import org.openfact.models.ubl.common.DeliveryModel;
import org.openfact.models.ubl.common.DeliveryTermsModel;
import org.openfact.models.ubl.common.DocumentReferenceModel;
import org.openfact.models.ubl.common.InvoiceLineModel;
import org.openfact.models.ubl.common.ItemModel;
import org.openfact.models.ubl.common.LineReferenceModel;
import org.openfact.models.ubl.common.OrderLineReferenceModel;
import org.openfact.models.ubl.common.PartyModel;
import org.openfact.models.ubl.common.PaymentTermsModel;
import org.openfact.models.ubl.common.PriceModel;
import org.openfact.models.ubl.common.PricingReferenceModel;
import org.openfact.models.ubl.common.QuantityModel;
import org.openfact.models.ubl.common.TaxTotalModel;

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

    @Override
    public String getID() {
        return this.invoiceLine.getID();
    }

    @Override
    public void setID(String value) {
        this.invoiceLine.setID(value);
    }

    @Override
    public String getUUID() {
        return this.invoiceLine.getUUID();
    }

    @Override
    public void setUUID(String value) {
        this.invoiceLine.setUUID(value);
    }

    @Override
    public String getNote() {
        return this.invoiceLine.getNote();
    }

    @Override
    public void setNote(String value) {
        this.invoiceLine.setNote(value);
    }

    @Override
    public QuantityModel getInvoicedQuantity() {
        return this.invoiceLine.getInvoicedQuantity();
    }

    @Override
    public void setInvoicedQuantity(QuantityAdapter value) {
        this.invoiceLine.setInvoicedQuantity(value);
    }

    @Override
    public BigDecimal getLineExtensionAmount() {
        return this.invoiceLine.getLineExtensionAmount();
    }

    @Override
    public void setLineExtensionAmount(BigDecimal value) {
        this.invoiceLine.setLineExtensionAmount(value);
    }

    @Override
    public LocalDate getTaxPointDate() {
        return this.invoiceLine.getTaxPointDate();
    }

    @Override
    public void setTaxPointDate(LocalDate value) {
        this.invoiceLine.setTaxPointDate(value);
    }

    @Override
    public String getAccountingCostCode() {
        return this.invoiceLine.getAccountingCostCode();
    }

    @Override
    public void setAccountingCostCode(String value) {
        this.invoiceLine.setAccountingCostCode(value);
    }

    @Override
    public String getAccountingCost() {
        return this.invoiceLine.getAccountingCost();
    }

    @Override
    public void setAccountingCost(String value) {
        this.invoiceLine.setAccountingCost(value);
    }

    @Override
    public boolean getFreeOfChargeIndicator() {
        return this.invoiceLine.getFreeOfChargeIndicator();
    }

    @Override
    public void setFreeOfChargeIndicator(boolean value) {
        this.invoiceLine.setFreeOfChargeIndicator(value);
    }

    @Override
    public List<OrderLineReferenceModel> getOrderLineReference() {
        return this.invoiceLine.getOrderLineReference();
    }

    @Override
    public void setOrderLineReference(List<OrderLineReferenceAdapter> orderLineReference) {
        this.invoiceLine.setOrderLineReference(orderLineReference);
    }

    @Override
    public List<LineReferenceModel> getDespatchLineReference() {
        return this.invoiceLine.getDespatchLineReference();
    }

    @Override
    public void setDespatchLineReference(List<LineReferenceAdapter> despatchLineReference) {
        this.invoiceLine.setDespatchLineReference(despatchLineReference);
    }

    @Override
    public List<LineReferenceModel> getReceiptLineReference() {
        return this.invoiceLine.getReceiptLineReference();
    }

    @Override
    public void setReceiptLineReference(List<LineReferenceAdapter> receiptLineReference) {
        this.invoiceLine.setReceiptLineReference(receiptLineReference);
    }

    @Override
    public List<BillingReferenceModel> getBillingReference() {
        return this.invoiceLine.getBillingReference();
    }

    @Override
    public void setBillingReference(List<BillingReferenceAdapter> billingReference) {
        this.invoiceLine.setBillingReference(billingReference);
    }

    @Override
    public List<DocumentReferenceModel> getDocumentReference() {
        return this.invoiceLine.getDocumentReference();
    }

    @Override
    public void setDocumentReference(List<DocumentReferenceAdapter> documentReference) {
        this.invoiceLine.setDocumentReference(documentReference);
    }

    @Override
    public PricingReferenceModel getPricingReference() {
        return this.invoiceLine.getPricingReference();
    }

    @Override
    public void setPricingReference(PricingReferenceAdapter value) {
        this.invoiceLine.setPricingReference(value);
    }

    @Override
    public PartyModel getOriginatorParty() {
        return this.invoiceLine.getOriginatorParty();
    }

    @Override
    public void setOriginatorParty(PartyAdapter value) {
        this.invoiceLine.setOriginatorParty(value);
    }

    @Override
    public List<DeliveryModel> getDelivery() {
        return this.invoiceLine.getDelivery();
    }

    @Override
    public void setDelivery(List<DeliveryAdapter> delivery) {
        this.invoiceLine.setDelivery(delivery);
    }

    @Override
    public List<PaymentTermsModel> getPaymentTerms() {
        return this.invoiceLine.getPaymentTerms();
    }

    @Override
    public void setPaymentTerms(List<PaymentTermsAdapter> paymentTerms) {
        this.invoiceLine.setPaymentTerms(paymentTerms);
    }

    @Override
    public List<AllowanceChargeModel> getAllowanceCharge() {
        return this.invoiceLine.getAllowanceCharge();
    }

    @Override
    public void setAllowanceCharge(List<AllowanceChargeAdapter> allowanceCharge) {
        this.invoiceLine.setAllowanceCharge(allowanceCharge);
    }

    @Override
    public List<TaxTotalModel> getTaxTotal() {
        return this.invoiceLine.getTaxTotal();
    }

    @Override
    public void setTaxTotal(List<TaxTotalAdapter> taxTotal) {
        this.invoiceLine.setTaxTotal(taxTotal);
    }

    @Override
    public ItemModel getItem() {
        return this.invoiceLine.getItem();
    }

    @Override
    public void setItem(ItemAdapter value) {
        this.invoiceLine.setItem(value);
    }

    @Override
    public PriceModel getPrice() {
        return this.invoiceLine.getPrice();
    }

    @Override
    public void setPrice(PriceAdapter value) {
        this.invoiceLine.setPrice(value);
    }

    @Override
    public DeliveryTermsModel getDeliveryTerms() {
        return this.invoiceLine.getDeliveryTerms();
    }

    @Override
    public void setDeliveryTerms(DeliveryTermsAdapter value) {
        this.invoiceLine.setDeliveryTerms(value);
    }

    @Override
    public String getId() {
        return this.invoiceLine.getId();
    }

    @Override
    public void setId(String value) {
        this.invoiceLine.setId(value);
    }

    /**
     * */
    TaxTotalAdapter addTaxTotal();

    AllowanceChargeAdapter addAllowanceCharge();

}
